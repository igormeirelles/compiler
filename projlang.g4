grammar projlang;

@header{
	import projfin.datastructures.projSymbol;
	import projfin.datastructures.projVariable;
	import projfin.datastructures.projSymbolTable;
	import projfin.exceptions.projSemanticException;
	import projfin.ast.projProgram;
	import projfin.ast.AbstractCommand;
	import projfin.ast.CommandLeitura;
	import projfin.ast.CommandEscrita;
	import projfin.ast.CommandAtribuicao;
	import projfin.ast.CommandDecisao;
	import projfin.ast.CommandEnquanto;
	import java.util.ArrayList;
	import java.util.Stack;
	import java.util.*;
}

@members{
	private int _tipo;
	private String _varName;
	private String _varValue;
	private String _readID;
	private String _writeID;
	private String _exprID;
	private String _exprContent;
	private String _exprDecision;
	private String _exprWhile;
	private String imp;
	private projSymbolTable symbolTable = new projSymbolTable();
	private projSymbol symbol;
	private projProgram program = new projProgram();
	private ArrayList<AbstractCommand> currentThread;
	private ArrayList<AbstractCommand> listaTrue;
	private ArrayList<AbstractCommand> listaFalse;
	private ArrayList<AbstractCommand> lista;
	private Stack<ArrayList<AbstractCommand>> stack = new Stack<ArrayList<AbstractCommand>>();
	
	public void checkID(String id){
		if (!symbolTable.exists(id)){
			throw new projSemanticException("Symbol "+id+" not declared");
		}
	}
	
	public void generateCode(){
		program.generateTarget();
	}
	public void exibeComandos(){
		for (AbstractCommand c: program.getComandos()){
			System.out.println(c);
		}
	}
	
}

prog :	   'programa' declara bloco 'fimprog'
		   {program.setVartable(symbolTable);
		    program.setComandos(stack.pop());}
	 ;
	 
declara : (declaravar)+
		;
		
declaravar : tipo ID {
						  _varName = _input.LT(-1).getText();
						  _varValue = null;
						  symbol = new projVariable(_varName, _tipo, _varValue);
						  if(!symbolTable.exists(_varName)){
							  System.out.println("Symbol added "+ symbol);
							  symbolTable.add(symbol);
						  }else{
						  	throw new projSemanticException("Symbol "+_varName+" already declared");
						  }
					  }
			(VIRG ID {
						  _varName = _input.LT(-1).getText();
						  _varValue = null;
						  symbol = new projVariable(_varName, _tipo, _varValue);
						  if(!symbolTable.exists(_varName)){
								 System.out.println("Symbol added "+ symbol);
								 symbolTable.add(symbol);
						  }else{
							  throw new projSemanticException("Symbol "+_varName+" already declared");
						  }
					  }
			)* SC
		;

tipo  : 'numero' { _tipo = projVariable.NUMBER;}
	  | 'texto'	 { _tipo = projVariable.TEXT; }
	  ;

bloco : {currentThread = new ArrayList<AbstractCommand>();
		 stack.push(currentThread);
		}
		(cmd)+
	  ;
	  
cmd  : cmdleitura 
	 | cmdescrita 
	 | cmdattrib  
	 | cmdif	 
	 | cmdenq 
	 ;
	 
cmdleitura  : 'leia' AP 
					 ID { checkID(_input.LT(-1).getText());
					 	  _readID = _input.LT(-1).getText();
					 	}
					 FP 
					 SC
			  {
			  	projVariable var = (projVariable)symbolTable.get(_readID);
			  	CommandLeitura cmd = new CommandLeitura(_readID, var);
			  	stack.peek().add(cmd);
			  }
			  
          	;

cmdescrita  : 'escreva' AP 
						(ID   { checkID(_input.LT(-1).getText()); 
							   _writeID= _input.LT(-1).getText();
							   CommandEscrita cmd = new CommandEscrita(_writeID, 1);
			  				   stack.peek().add(cmd);
							  }
						| ASPA imp=STRING ASPA {
			  					CommandEscrita cmd = new CommandEscrita($imp.getText(), 2);
			  					stack.peek().add(cmd);
			  			})
						FP 
						SC
          	;  
          	
cmdattrib   : ID { checkID(_input.LT(-1).getText());
				   _exprID = _input.LT(-1).getText();
				 } 
				 ATTR { _exprContent= "";}
				 expr
				 SC
			{
			  	CommandAtribuicao cmd = new CommandAtribuicao(_exprID, _exprContent);
			  	stack.peek().add(cmd);
			}
          	; 
          	
cmdif	    : 'se' AP
				   ID { _exprDecision = _input.LT(-1).getText();}
				   OP_RL { _exprDecision += _input.LT(-1).getText();}
				   (ID | NUMBER) { _exprDecision += _input.LT(-1).getText();}
				   FP 
				   AC 
				   {currentThread = new ArrayList<AbstractCommand>();
				    stack.push(currentThread);
				    }
				   (cmd)+ 
				   FC 
				   {
				   	listaTrue = stack.pop();
				   }
				   ('senao' 
				     AC
				     {
				     {	currentThread = new ArrayList<AbstractCommand>();
				      	stack.push(currentThread);}
				     }
				     (cmd+)
				     FC
				     {
					     listaFalse = stack.pop();
					     CommandDecisao cmd = new CommandDecisao(_exprDecision, listaTrue, listaFalse);
					     stack.peek().add(cmd);
				     }
				  )?
          	;     
          	
cmdenq	    : 'enquanto' AP
				   ID { _exprWhile = _input.LT(-1).getText();}
				   OP_RL { _exprWhile += _input.LT(-1).getText();}
				   (ID | NUMBER) { _exprWhile += _input.LT(-1).getText();}
				   FP 
				   AC 
				   {currentThread = new ArrayList<AbstractCommand>();
				    stack.push(currentThread);
				    }
				   (cmd)+ 
				   FC 
				   {
				   	lista = stack.pop();
				   	CommandEnquanto cmd = new CommandEnquanto(_exprWhile, lista);
					stack.peek().add(cmd);
				   }
				   
          	;     
          	
expr		: termo ( OP{_exprContent += _input.LT(-1).getText();} termo)*
			;

termo		: ID { checkID(_input.LT(-1).getText()); 
				   _exprContent += _input.LT(-1).getText();
				 }
			| NUMBER {
			       _exprContent += _input.LT(-1).getText();
			     }
			;
			
AP 			: '('
			;
			
FP 			: ')'
			;
			
AC 			: '{'
			;
			
FC 			: '}'
			;			

SC 			: ';'
			;	
			
OP 			: '+' | '-' | '*' | '/'
			;
			
OP_RL 		: '<' | '>' | '<=' | '>=' | '==' | '!='
			;	
			
ATTR 		: '='
			;
			
VIRG		: ','
			;
			
ASPA 		: '"'
			;
			
ID 			: [a-z] ([a-z] | [A-Z] | [0-9])*
			;
			
NUMBER		: [0-9]+ ('.' [0-9]+)?
			;

STRING      :[A-Z] ([a-z] | [A-Z] | [0-9] | WS)+
			;
WS			: (' ' | '\t' | '\n' | '\r') -> skip;