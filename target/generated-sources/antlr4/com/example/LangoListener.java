// Generated from com/example/Lango.g4 by ANTLR 4.9.2
package com.example;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link LangoParser}.
 */
public interface LangoListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link LangoParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(LangoParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link LangoParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(LangoParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link LangoParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(LangoParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link LangoParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(LangoParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link LangoParser#assignmentStatement}.
	 * @param ctx the parse tree
	 */
	void enterAssignmentStatement(LangoParser.AssignmentStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link LangoParser#assignmentStatement}.
	 * @param ctx the parse tree
	 */
	void exitAssignmentStatement(LangoParser.AssignmentStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link LangoParser#printStatement}.
	 * @param ctx the parse tree
	 */
	void enterPrintStatement(LangoParser.PrintStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link LangoParser#printStatement}.
	 * @param ctx the parse tree
	 */
	void exitPrintStatement(LangoParser.PrintStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link LangoParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void enterIfStatement(LangoParser.IfStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link LangoParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void exitIfStatement(LangoParser.IfStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link LangoParser#whileStatement}.
	 * @param ctx the parse tree
	 */
	void enterWhileStatement(LangoParser.WhileStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link LangoParser#whileStatement}.
	 * @param ctx the parse tree
	 */
	void exitWhileStatement(LangoParser.WhileStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MulDivExpr}
	 * labeled alternative in {@link LangoParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterMulDivExpr(LangoParser.MulDivExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MulDivExpr}
	 * labeled alternative in {@link LangoParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitMulDivExpr(LangoParser.MulDivExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CompExpr}
	 * labeled alternative in {@link LangoParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterCompExpr(LangoParser.CompExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CompExpr}
	 * labeled alternative in {@link LangoParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitCompExpr(LangoParser.CompExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ParenExpr}
	 * labeled alternative in {@link LangoParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterParenExpr(LangoParser.ParenExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ParenExpr}
	 * labeled alternative in {@link LangoParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitParenExpr(LangoParser.ParenExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AtomExpr}
	 * labeled alternative in {@link LangoParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterAtomExpr(LangoParser.AtomExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AtomExpr}
	 * labeled alternative in {@link LangoParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitAtomExpr(LangoParser.AtomExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AddSubExpr}
	 * labeled alternative in {@link LangoParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterAddSubExpr(LangoParser.AddSubExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AddSubExpr}
	 * labeled alternative in {@link LangoParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitAddSubExpr(LangoParser.AddSubExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IntAtom}
	 * labeled alternative in {@link LangoParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterIntAtom(LangoParser.IntAtomContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IntAtom}
	 * labeled alternative in {@link LangoParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitIntAtom(LangoParser.IntAtomContext ctx);
	/**
	 * Enter a parse tree produced by the {@code DoubleAtom}
	 * labeled alternative in {@link LangoParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterDoubleAtom(LangoParser.DoubleAtomContext ctx);
	/**
	 * Exit a parse tree produced by the {@code DoubleAtom}
	 * labeled alternative in {@link LangoParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitDoubleAtom(LangoParser.DoubleAtomContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StringAtom}
	 * labeled alternative in {@link LangoParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterStringAtom(LangoParser.StringAtomContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StringAtom}
	 * labeled alternative in {@link LangoParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitStringAtom(LangoParser.StringAtomContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IdAtom}
	 * labeled alternative in {@link LangoParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterIdAtom(LangoParser.IdAtomContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IdAtom}
	 * labeled alternative in {@link LangoParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitIdAtom(LangoParser.IdAtomContext ctx);
}