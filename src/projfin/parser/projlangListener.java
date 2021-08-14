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

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link projlangParser}.
 */
public interface projlangListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link projlangParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(projlangParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link projlangParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(projlangParser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by {@link projlangParser#declara}.
	 * @param ctx the parse tree
	 */
	void enterDeclara(projlangParser.DeclaraContext ctx);
	/**
	 * Exit a parse tree produced by {@link projlangParser#declara}.
	 * @param ctx the parse tree
	 */
	void exitDeclara(projlangParser.DeclaraContext ctx);
	/**
	 * Enter a parse tree produced by {@link projlangParser#declaravar}.
	 * @param ctx the parse tree
	 */
	void enterDeclaravar(projlangParser.DeclaravarContext ctx);
	/**
	 * Exit a parse tree produced by {@link projlangParser#declaravar}.
	 * @param ctx the parse tree
	 */
	void exitDeclaravar(projlangParser.DeclaravarContext ctx);
	/**
	 * Enter a parse tree produced by {@link projlangParser#tipo}.
	 * @param ctx the parse tree
	 */
	void enterTipo(projlangParser.TipoContext ctx);
	/**
	 * Exit a parse tree produced by {@link projlangParser#tipo}.
	 * @param ctx the parse tree
	 */
	void exitTipo(projlangParser.TipoContext ctx);
	/**
	 * Enter a parse tree produced by {@link projlangParser#bloco}.
	 * @param ctx the parse tree
	 */
	void enterBloco(projlangParser.BlocoContext ctx);
	/**
	 * Exit a parse tree produced by {@link projlangParser#bloco}.
	 * @param ctx the parse tree
	 */
	void exitBloco(projlangParser.BlocoContext ctx);
	/**
	 * Enter a parse tree produced by {@link projlangParser#cmd}.
	 * @param ctx the parse tree
	 */
	void enterCmd(projlangParser.CmdContext ctx);
	/**
	 * Exit a parse tree produced by {@link projlangParser#cmd}.
	 * @param ctx the parse tree
	 */
	void exitCmd(projlangParser.CmdContext ctx);
	/**
	 * Enter a parse tree produced by {@link projlangParser#cmdleitura}.
	 * @param ctx the parse tree
	 */
	void enterCmdleitura(projlangParser.CmdleituraContext ctx);
	/**
	 * Exit a parse tree produced by {@link projlangParser#cmdleitura}.
	 * @param ctx the parse tree
	 */
	void exitCmdleitura(projlangParser.CmdleituraContext ctx);
	/**
	 * Enter a parse tree produced by {@link projlangParser#cmdescrita}.
	 * @param ctx the parse tree
	 */
	void enterCmdescrita(projlangParser.CmdescritaContext ctx);
	/**
	 * Exit a parse tree produced by {@link projlangParser#cmdescrita}.
	 * @param ctx the parse tree
	 */
	void exitCmdescrita(projlangParser.CmdescritaContext ctx);
	/**
	 * Enter a parse tree produced by {@link projlangParser#cmdattrib}.
	 * @param ctx the parse tree
	 */
	void enterCmdattrib(projlangParser.CmdattribContext ctx);
	/**
	 * Exit a parse tree produced by {@link projlangParser#cmdattrib}.
	 * @param ctx the parse tree
	 */
	void exitCmdattrib(projlangParser.CmdattribContext ctx);
	/**
	 * Enter a parse tree produced by {@link projlangParser#cmdif}.
	 * @param ctx the parse tree
	 */
	void enterCmdif(projlangParser.CmdifContext ctx);
	/**
	 * Exit a parse tree produced by {@link projlangParser#cmdif}.
	 * @param ctx the parse tree
	 */
	void exitCmdif(projlangParser.CmdifContext ctx);
	/**
	 * Enter a parse tree produced by {@link projlangParser#cmdenq}.
	 * @param ctx the parse tree
	 */
	void enterCmdenq(projlangParser.CmdenqContext ctx);
	/**
	 * Exit a parse tree produced by {@link projlangParser#cmdenq}.
	 * @param ctx the parse tree
	 */
	void exitCmdenq(projlangParser.CmdenqContext ctx);
	/**
	 * Enter a parse tree produced by {@link projlangParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(projlangParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link projlangParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(projlangParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link projlangParser#termo}.
	 * @param ctx the parse tree
	 */
	void enterTermo(projlangParser.TermoContext ctx);
	/**
	 * Exit a parse tree produced by {@link projlangParser#termo}.
	 * @param ctx the parse tree
	 */
	void exitTermo(projlangParser.TermoContext ctx);
}