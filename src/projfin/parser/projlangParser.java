// Generated from projlang.g4 by ANTLR 4.7.1
package projfin.parser;

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

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class projlangParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		AP=10, FP=11, AC=12, FC=13, SC=14, OP=15, OP_RL=16, ATTR=17, VIRG=18, 
		ASPA=19, ID=20, NUMBER=21, STRING=22, WS=23;
	public static final int
		RULE_prog = 0, RULE_declara = 1, RULE_declaravar = 2, RULE_tipo = 3, RULE_bloco = 4, 
		RULE_cmd = 5, RULE_cmdleitura = 6, RULE_cmdescrita = 7, RULE_cmdattrib = 8, 
		RULE_cmdif = 9, RULE_cmdenq = 10, RULE_expr = 11, RULE_termo = 12;
	public static final String[] ruleNames = {
		"prog", "declara", "declaravar", "tipo", "bloco", "cmd", "cmdleitura", 
		"cmdescrita", "cmdattrib", "cmdif", "cmdenq", "expr", "termo"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'programa'", "'fimprog'", "'numero'", "'texto'", "'leia'", "'escreva'", 
		"'se'", "'senao'", "'enquanto'", "'('", "')'", "'{'", "'}'", "';'", null, 
		null, "'='", "','", "'\"'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, "AP", "FP", 
		"AC", "FC", "SC", "OP", "OP_RL", "ATTR", "VIRG", "ASPA", "ID", "NUMBER", 
		"STRING", "WS"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "projlang.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }


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
		

	public projlangParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgContext extends ParserRuleContext {
		public DeclaraContext declara() {
			return getRuleContext(DeclaraContext.class,0);
		}
		public BlocoContext bloco() {
			return getRuleContext(BlocoContext.class,0);
		}
		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof projlangListener ) ((projlangListener)listener).enterProg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof projlangListener ) ((projlangListener)listener).exitProg(this);
		}
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prog);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(26);
			match(T__0);
			setState(27);
			declara();
			setState(28);
			bloco();
			setState(29);
			match(T__1);
			program.setVartable(symbolTable);
					    program.setComandos(stack.pop());
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeclaraContext extends ParserRuleContext {
		public List<DeclaravarContext> declaravar() {
			return getRuleContexts(DeclaravarContext.class);
		}
		public DeclaravarContext declaravar(int i) {
			return getRuleContext(DeclaravarContext.class,i);
		}
		public DeclaraContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declara; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof projlangListener ) ((projlangListener)listener).enterDeclara(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof projlangListener ) ((projlangListener)listener).exitDeclara(this);
		}
	}

	public final DeclaraContext declara() throws RecognitionException {
		DeclaraContext _localctx = new DeclaraContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_declara);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(33); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(32);
				declaravar();
				}
				}
				setState(35); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__2 || _la==T__3 );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeclaravarContext extends ParserRuleContext {
		public TipoContext tipo() {
			return getRuleContext(TipoContext.class,0);
		}
		public List<TerminalNode> ID() { return getTokens(projlangParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(projlangParser.ID, i);
		}
		public TerminalNode SC() { return getToken(projlangParser.SC, 0); }
		public List<TerminalNode> VIRG() { return getTokens(projlangParser.VIRG); }
		public TerminalNode VIRG(int i) {
			return getToken(projlangParser.VIRG, i);
		}
		public DeclaravarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaravar; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof projlangListener ) ((projlangListener)listener).enterDeclaravar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof projlangListener ) ((projlangListener)listener).exitDeclaravar(this);
		}
	}

	public final DeclaravarContext declaravar() throws RecognitionException {
		DeclaravarContext _localctx = new DeclaravarContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_declaravar);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(37);
			tipo();
			setState(38);
			match(ID);

									  _varName = _input.LT(-1).getText();
									  _varValue = null;
									  symbol = new projVariable(_varName, _tipo, _varValue);
									  if(!symbolTable.exists(_varName)){
										  System.out.println("Symbol added "+ symbol);
										  symbolTable.add(symbol);
									  }else{
									  	throw new projSemanticException("Symbol "+_varName+" already declared");
									  }
								  
			setState(45);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==VIRG) {
				{
				{
				setState(40);
				match(VIRG);
				setState(41);
				match(ID);

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
				}
				setState(47);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(48);
			match(SC);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TipoContext extends ParserRuleContext {
		public TipoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tipo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof projlangListener ) ((projlangListener)listener).enterTipo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof projlangListener ) ((projlangListener)listener).exitTipo(this);
		}
	}

	public final TipoContext tipo() throws RecognitionException {
		TipoContext _localctx = new TipoContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_tipo);
		try {
			setState(54);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__2:
				enterOuterAlt(_localctx, 1);
				{
				setState(50);
				match(T__2);
				 _tipo = projVariable.NUMBER;
				}
				break;
			case T__3:
				enterOuterAlt(_localctx, 2);
				{
				setState(52);
				match(T__3);
				 _tipo = projVariable.TEXT; 
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BlocoContext extends ParserRuleContext {
		public List<CmdContext> cmd() {
			return getRuleContexts(CmdContext.class);
		}
		public CmdContext cmd(int i) {
			return getRuleContext(CmdContext.class,i);
		}
		public BlocoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bloco; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof projlangListener ) ((projlangListener)listener).enterBloco(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof projlangListener ) ((projlangListener)listener).exitBloco(this);
		}
	}

	public final BlocoContext bloco() throws RecognitionException {
		BlocoContext _localctx = new BlocoContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_bloco);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			currentThread = new ArrayList<AbstractCommand>();
					 stack.push(currentThread);
					
			setState(58); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(57);
				cmd();
				}
				}
				setState(60); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__8) | (1L << ID))) != 0) );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CmdContext extends ParserRuleContext {
		public CmdleituraContext cmdleitura() {
			return getRuleContext(CmdleituraContext.class,0);
		}
		public CmdescritaContext cmdescrita() {
			return getRuleContext(CmdescritaContext.class,0);
		}
		public CmdattribContext cmdattrib() {
			return getRuleContext(CmdattribContext.class,0);
		}
		public CmdifContext cmdif() {
			return getRuleContext(CmdifContext.class,0);
		}
		public CmdenqContext cmdenq() {
			return getRuleContext(CmdenqContext.class,0);
		}
		public CmdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmd; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof projlangListener ) ((projlangListener)listener).enterCmd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof projlangListener ) ((projlangListener)listener).exitCmd(this);
		}
	}

	public final CmdContext cmd() throws RecognitionException {
		CmdContext _localctx = new CmdContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_cmd);
		try {
			setState(67);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__4:
				enterOuterAlt(_localctx, 1);
				{
				setState(62);
				cmdleitura();
				}
				break;
			case T__5:
				enterOuterAlt(_localctx, 2);
				{
				setState(63);
				cmdescrita();
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 3);
				{
				setState(64);
				cmdattrib();
				}
				break;
			case T__6:
				enterOuterAlt(_localctx, 4);
				{
				setState(65);
				cmdif();
				}
				break;
			case T__8:
				enterOuterAlt(_localctx, 5);
				{
				setState(66);
				cmdenq();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CmdleituraContext extends ParserRuleContext {
		public TerminalNode AP() { return getToken(projlangParser.AP, 0); }
		public TerminalNode ID() { return getToken(projlangParser.ID, 0); }
		public TerminalNode FP() { return getToken(projlangParser.FP, 0); }
		public TerminalNode SC() { return getToken(projlangParser.SC, 0); }
		public CmdleituraContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdleitura; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof projlangListener ) ((projlangListener)listener).enterCmdleitura(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof projlangListener ) ((projlangListener)listener).exitCmdleitura(this);
		}
	}

	public final CmdleituraContext cmdleitura() throws RecognitionException {
		CmdleituraContext _localctx = new CmdleituraContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_cmdleitura);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(69);
			match(T__4);
			setState(70);
			match(AP);
			setState(71);
			match(ID);
			 checkID(_input.LT(-1).getText());
								 	  _readID = _input.LT(-1).getText();
								 	
			setState(73);
			match(FP);
			setState(74);
			match(SC);

						  	projVariable var = (projVariable)symbolTable.get(_readID);
						  	CommandLeitura cmd = new CommandLeitura(_readID, var);
						  	stack.peek().add(cmd);
						  
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CmdescritaContext extends ParserRuleContext {
		public Token imp;
		public TerminalNode AP() { return getToken(projlangParser.AP, 0); }
		public TerminalNode FP() { return getToken(projlangParser.FP, 0); }
		public TerminalNode SC() { return getToken(projlangParser.SC, 0); }
		public TerminalNode ID() { return getToken(projlangParser.ID, 0); }
		public List<TerminalNode> ASPA() { return getTokens(projlangParser.ASPA); }
		public TerminalNode ASPA(int i) {
			return getToken(projlangParser.ASPA, i);
		}
		public TerminalNode STRING() { return getToken(projlangParser.STRING, 0); }
		public CmdescritaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdescrita; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof projlangListener ) ((projlangListener)listener).enterCmdescrita(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof projlangListener ) ((projlangListener)listener).exitCmdescrita(this);
		}
	}

	public final CmdescritaContext cmdescrita() throws RecognitionException {
		CmdescritaContext _localctx = new CmdescritaContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_cmdescrita);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(77);
			match(T__5);
			setState(78);
			match(AP);
			setState(85);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				{
				setState(79);
				match(ID);
				 checkID(_input.LT(-1).getText()); 
											   _writeID= _input.LT(-1).getText();
											   CommandEscrita cmd = new CommandEscrita(_writeID, 1);
							  				   stack.peek().add(cmd);
											  
				}
				break;
			case ASPA:
				{
				setState(81);
				match(ASPA);
				setState(82);
				((CmdescritaContext)_localctx).imp = match(STRING);
				setState(83);
				match(ASPA);

							  					CommandEscrita cmd = new CommandEscrita(((CmdescritaContext)_localctx).imp.getText(), 2);
							  					stack.peek().add(cmd);
							  			
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(87);
			match(FP);
			setState(88);
			match(SC);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CmdattribContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(projlangParser.ID, 0); }
		public TerminalNode ATTR() { return getToken(projlangParser.ATTR, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode SC() { return getToken(projlangParser.SC, 0); }
		public CmdattribContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdattrib; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof projlangListener ) ((projlangListener)listener).enterCmdattrib(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof projlangListener ) ((projlangListener)listener).exitCmdattrib(this);
		}
	}

	public final CmdattribContext cmdattrib() throws RecognitionException {
		CmdattribContext _localctx = new CmdattribContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_cmdattrib);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(90);
			match(ID);
			 checkID(_input.LT(-1).getText());
							   _exprID = _input.LT(-1).getText();
							 
			setState(92);
			match(ATTR);
			 _exprContent= "";
			setState(94);
			expr();
			setState(95);
			match(SC);

						  	CommandAtribuicao cmd = new CommandAtribuicao(_exprID, _exprContent);
						  	stack.peek().add(cmd);
						
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CmdifContext extends ParserRuleContext {
		public TerminalNode AP() { return getToken(projlangParser.AP, 0); }
		public List<TerminalNode> ID() { return getTokens(projlangParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(projlangParser.ID, i);
		}
		public TerminalNode OP_RL() { return getToken(projlangParser.OP_RL, 0); }
		public TerminalNode FP() { return getToken(projlangParser.FP, 0); }
		public List<TerminalNode> AC() { return getTokens(projlangParser.AC); }
		public TerminalNode AC(int i) {
			return getToken(projlangParser.AC, i);
		}
		public List<TerminalNode> FC() { return getTokens(projlangParser.FC); }
		public TerminalNode FC(int i) {
			return getToken(projlangParser.FC, i);
		}
		public TerminalNode NUMBER() { return getToken(projlangParser.NUMBER, 0); }
		public List<CmdContext> cmd() {
			return getRuleContexts(CmdContext.class);
		}
		public CmdContext cmd(int i) {
			return getRuleContext(CmdContext.class,i);
		}
		public CmdifContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdif; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof projlangListener ) ((projlangListener)listener).enterCmdif(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof projlangListener ) ((projlangListener)listener).exitCmdif(this);
		}
	}

	public final CmdifContext cmdif() throws RecognitionException {
		CmdifContext _localctx = new CmdifContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_cmdif);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(98);
			match(T__6);
			setState(99);
			match(AP);
			setState(100);
			match(ID);
			 _exprDecision = _input.LT(-1).getText();
			setState(102);
			match(OP_RL);
			 _exprDecision += _input.LT(-1).getText();
			setState(104);
			_la = _input.LA(1);
			if ( !(_la==ID || _la==NUMBER) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			 _exprDecision += _input.LT(-1).getText();
			setState(106);
			match(FP);
			setState(107);
			match(AC);
			currentThread = new ArrayList<AbstractCommand>();
							    stack.push(currentThread);
							    
			setState(110); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(109);
				cmd();
				}
				}
				setState(112); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__8) | (1L << ID))) != 0) );
			setState(114);
			match(FC);

							   	listaTrue = stack.pop();
							   
			setState(127);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__7) {
				{
				setState(116);
				match(T__7);
				setState(117);
				match(AC);

								     {	currentThread = new ArrayList<AbstractCommand>();
								      	stack.push(currentThread);}
								     
				{
				setState(120); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(119);
					cmd();
					}
					}
					setState(122); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__8) | (1L << ID))) != 0) );
				}
				setState(124);
				match(FC);

									     listaFalse = stack.pop();
									     CommandDecisao cmd = new CommandDecisao(_exprDecision, listaTrue, listaFalse);
									     stack.peek().add(cmd);
								     
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CmdenqContext extends ParserRuleContext {
		public TerminalNode AP() { return getToken(projlangParser.AP, 0); }
		public List<TerminalNode> ID() { return getTokens(projlangParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(projlangParser.ID, i);
		}
		public TerminalNode OP_RL() { return getToken(projlangParser.OP_RL, 0); }
		public TerminalNode FP() { return getToken(projlangParser.FP, 0); }
		public TerminalNode AC() { return getToken(projlangParser.AC, 0); }
		public TerminalNode FC() { return getToken(projlangParser.FC, 0); }
		public TerminalNode NUMBER() { return getToken(projlangParser.NUMBER, 0); }
		public List<CmdContext> cmd() {
			return getRuleContexts(CmdContext.class);
		}
		public CmdContext cmd(int i) {
			return getRuleContext(CmdContext.class,i);
		}
		public CmdenqContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdenq; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof projlangListener ) ((projlangListener)listener).enterCmdenq(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof projlangListener ) ((projlangListener)listener).exitCmdenq(this);
		}
	}

	public final CmdenqContext cmdenq() throws RecognitionException {
		CmdenqContext _localctx = new CmdenqContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_cmdenq);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(129);
			match(T__8);
			setState(130);
			match(AP);
			setState(131);
			match(ID);
			 _exprWhile = _input.LT(-1).getText();
			setState(133);
			match(OP_RL);
			 _exprWhile += _input.LT(-1).getText();
			setState(135);
			_la = _input.LA(1);
			if ( !(_la==ID || _la==NUMBER) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			 _exprWhile += _input.LT(-1).getText();
			setState(137);
			match(FP);
			setState(138);
			match(AC);
			currentThread = new ArrayList<AbstractCommand>();
							    stack.push(currentThread);
							    
			setState(141); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(140);
				cmd();
				}
				}
				setState(143); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__8) | (1L << ID))) != 0) );
			setState(145);
			match(FC);

							   	lista = stack.pop();
							   	CommandEnquanto cmd = new CommandEnquanto(_exprWhile, lista);
								stack.peek().add(cmd);
							   
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExprContext extends ParserRuleContext {
		public List<TermoContext> termo() {
			return getRuleContexts(TermoContext.class);
		}
		public TermoContext termo(int i) {
			return getRuleContext(TermoContext.class,i);
		}
		public List<TerminalNode> OP() { return getTokens(projlangParser.OP); }
		public TerminalNode OP(int i) {
			return getToken(projlangParser.OP, i);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof projlangListener ) ((projlangListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof projlangListener ) ((projlangListener)listener).exitExpr(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(148);
			termo();
			setState(154);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OP) {
				{
				{
				setState(149);
				match(OP);
				_exprContent += _input.LT(-1).getText();
				setState(151);
				termo();
				}
				}
				setState(156);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TermoContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(projlangParser.ID, 0); }
		public TerminalNode NUMBER() { return getToken(projlangParser.NUMBER, 0); }
		public TermoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_termo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof projlangListener ) ((projlangListener)listener).enterTermo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof projlangListener ) ((projlangListener)listener).exitTermo(this);
		}
	}

	public final TermoContext termo() throws RecognitionException {
		TermoContext _localctx = new TermoContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_termo);
		try {
			setState(161);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(157);
				match(ID);
				 checkID(_input.LT(-1).getText()); 
								   _exprContent += _input.LT(-1).getText();
								 
				}
				break;
			case NUMBER:
				enterOuterAlt(_localctx, 2);
				{
				setState(159);
				match(NUMBER);

							       _exprContent += _input.LT(-1).getText();
							     
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\31\u00a6\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\3\2\3\2\3\2\3\2\3\2\3\2\3\3\6\3$\n\3\r"+
		"\3\16\3%\3\4\3\4\3\4\3\4\3\4\3\4\7\4.\n\4\f\4\16\4\61\13\4\3\4\3\4\3\5"+
		"\3\5\3\5\3\5\5\59\n\5\3\6\3\6\6\6=\n\6\r\6\16\6>\3\7\3\7\3\7\3\7\3\7\5"+
		"\7F\n\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3"+
		"\t\5\tX\n\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\6\13q\n\13\r\13\16\13r\3"+
		"\13\3\13\3\13\3\13\3\13\3\13\6\13{\n\13\r\13\16\13|\3\13\3\13\3\13\5\13"+
		"\u0082\n\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\6\f\u0090"+
		"\n\f\r\f\16\f\u0091\3\f\3\f\3\f\3\r\3\r\3\r\3\r\7\r\u009b\n\r\f\r\16\r"+
		"\u009e\13\r\3\16\3\16\3\16\3\16\5\16\u00a4\n\16\3\16\2\2\17\2\4\6\b\n"+
		"\f\16\20\22\24\26\30\32\2\3\3\2\26\27\2\u00a7\2\34\3\2\2\2\4#\3\2\2\2"+
		"\6\'\3\2\2\2\b8\3\2\2\2\n:\3\2\2\2\fE\3\2\2\2\16G\3\2\2\2\20O\3\2\2\2"+
		"\22\\\3\2\2\2\24d\3\2\2\2\26\u0083\3\2\2\2\30\u0096\3\2\2\2\32\u00a3\3"+
		"\2\2\2\34\35\7\3\2\2\35\36\5\4\3\2\36\37\5\n\6\2\37 \7\4\2\2 !\b\2\1\2"+
		"!\3\3\2\2\2\"$\5\6\4\2#\"\3\2\2\2$%\3\2\2\2%#\3\2\2\2%&\3\2\2\2&\5\3\2"+
		"\2\2\'(\5\b\5\2()\7\26\2\2)/\b\4\1\2*+\7\24\2\2+,\7\26\2\2,.\b\4\1\2-"+
		"*\3\2\2\2.\61\3\2\2\2/-\3\2\2\2/\60\3\2\2\2\60\62\3\2\2\2\61/\3\2\2\2"+
		"\62\63\7\20\2\2\63\7\3\2\2\2\64\65\7\5\2\2\659\b\5\1\2\66\67\7\6\2\2\67"+
		"9\b\5\1\28\64\3\2\2\28\66\3\2\2\29\t\3\2\2\2:<\b\6\1\2;=\5\f\7\2<;\3\2"+
		"\2\2=>\3\2\2\2><\3\2\2\2>?\3\2\2\2?\13\3\2\2\2@F\5\16\b\2AF\5\20\t\2B"+
		"F\5\22\n\2CF\5\24\13\2DF\5\26\f\2E@\3\2\2\2EA\3\2\2\2EB\3\2\2\2EC\3\2"+
		"\2\2ED\3\2\2\2F\r\3\2\2\2GH\7\7\2\2HI\7\f\2\2IJ\7\26\2\2JK\b\b\1\2KL\7"+
		"\r\2\2LM\7\20\2\2MN\b\b\1\2N\17\3\2\2\2OP\7\b\2\2PW\7\f\2\2QR\7\26\2\2"+
		"RX\b\t\1\2ST\7\25\2\2TU\7\30\2\2UV\7\25\2\2VX\b\t\1\2WQ\3\2\2\2WS\3\2"+
		"\2\2XY\3\2\2\2YZ\7\r\2\2Z[\7\20\2\2[\21\3\2\2\2\\]\7\26\2\2]^\b\n\1\2"+
		"^_\7\23\2\2_`\b\n\1\2`a\5\30\r\2ab\7\20\2\2bc\b\n\1\2c\23\3\2\2\2de\7"+
		"\t\2\2ef\7\f\2\2fg\7\26\2\2gh\b\13\1\2hi\7\22\2\2ij\b\13\1\2jk\t\2\2\2"+
		"kl\b\13\1\2lm\7\r\2\2mn\7\16\2\2np\b\13\1\2oq\5\f\7\2po\3\2\2\2qr\3\2"+
		"\2\2rp\3\2\2\2rs\3\2\2\2st\3\2\2\2tu\7\17\2\2u\u0081\b\13\1\2vw\7\n\2"+
		"\2wx\7\16\2\2xz\b\13\1\2y{\5\f\7\2zy\3\2\2\2{|\3\2\2\2|z\3\2\2\2|}\3\2"+
		"\2\2}~\3\2\2\2~\177\7\17\2\2\177\u0080\b\13\1\2\u0080\u0082\3\2\2\2\u0081"+
		"v\3\2\2\2\u0081\u0082\3\2\2\2\u0082\25\3\2\2\2\u0083\u0084\7\13\2\2\u0084"+
		"\u0085\7\f\2\2\u0085\u0086\7\26\2\2\u0086\u0087\b\f\1\2\u0087\u0088\7"+
		"\22\2\2\u0088\u0089\b\f\1\2\u0089\u008a\t\2\2\2\u008a\u008b\b\f\1\2\u008b"+
		"\u008c\7\r\2\2\u008c\u008d\7\16\2\2\u008d\u008f\b\f\1\2\u008e\u0090\5"+
		"\f\7\2\u008f\u008e\3\2\2\2\u0090\u0091\3\2\2\2\u0091\u008f\3\2\2\2\u0091"+
		"\u0092\3\2\2\2\u0092\u0093\3\2\2\2\u0093\u0094\7\17\2\2\u0094\u0095\b"+
		"\f\1\2\u0095\27\3\2\2\2\u0096\u009c\5\32\16\2\u0097\u0098\7\21\2\2\u0098"+
		"\u0099\b\r\1\2\u0099\u009b\5\32\16\2\u009a\u0097\3\2\2\2\u009b\u009e\3"+
		"\2\2\2\u009c\u009a\3\2\2\2\u009c\u009d\3\2\2\2\u009d\31\3\2\2\2\u009e"+
		"\u009c\3\2\2\2\u009f\u00a0\7\26\2\2\u00a0\u00a4\b\16\1\2\u00a1\u00a2\7"+
		"\27\2\2\u00a2\u00a4\b\16\1\2\u00a3\u009f\3\2\2\2\u00a3\u00a1\3\2\2\2\u00a4"+
		"\33\3\2\2\2\16%/8>EWr|\u0081\u0091\u009c\u00a3";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}