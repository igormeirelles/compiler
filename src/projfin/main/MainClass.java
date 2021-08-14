package projfin.main;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import projfin.exceptions.projSemanticException;
import projfin.parser.projlangLexer;
import projfin.parser.projlangParser;

public class MainClass {
	public static void main(String[] args) {
		try {
			projlangLexer lexer;
			projlangParser parser;
			
			lexer = new projlangLexer(CharStreams.fromFileName("input.proj"));
			
			CommonTokenStream tokenStream = new CommonTokenStream(lexer);
			
			parser = new projlangParser(tokenStream);
			
			parser.prog();
			
			System.out.println("Compilation Successful!");
			
			parser.exibeComandos();
			
			parser.generateCode();
		}
		catch(projSemanticException ex) {
			System.err.println("Semantic error -" +ex.getMessage());
		}
		catch(Exception ex) {
			System.err.println("ERROR "+ex.getMessage());
		}
	}
}
