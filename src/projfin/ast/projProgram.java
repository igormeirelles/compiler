package projfin.ast;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

import projfin.datastructures.projSymbol;
import projfin.datastructures.projSymbolTable;

public class projProgram {
	private projSymbolTable vartable;
	private ArrayList<AbstractCommand> comandos;
	private String programName;
	
	
	public void generateTarget() {
		StringBuilder str = new StringBuilder();
		str.append("import java.uitl.Scanner;\n");
		str.append("public class MainClass {\n");
		str.append("  public static void main(String args[]{\n");
		str.append("      Scanner _key = new Scanner(System.in);\n");
		for(projSymbol symbol: vartable.getAll()) {
			str.append(symbol.generateJavaCode()+"\n");
		}
		for(AbstractCommand command: comandos) {
			str.append(command.generateJavaCode()+"\n");
		}
		str.append("  }");
		str.append("}");
		
		try {
			FileWriter fr = new FileWriter(new File("MainClass.java"));
			fr.write(str.toString());
			fr.close();
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
	}


	public projSymbolTable getVartable() {
		return vartable;
	}


	public void setVartable(projSymbolTable vartable) {
		this.vartable = vartable;
	}


	public ArrayList<AbstractCommand> getComandos() {
		return comandos;
	}


	public void setComandos(ArrayList<AbstractCommand> comandos) {
		this.comandos = comandos;
	}


	public String getProgramName() {
		return programName;
	}


	public void setProgramName(String programName) {
		this.programName = programName;
	}
	
}
