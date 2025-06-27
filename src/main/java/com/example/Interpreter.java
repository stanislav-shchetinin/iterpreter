package com.example;

import com.example.LangoBaseVisitor;
import com.example.LangoParser.*;

public class Interpreter extends LangoBaseVisitor<Value> {
    private Scope currentScope;

    public Interpreter() {
        this.currentScope = new Scope();
    }

    @Override
    public Value visitProgram(ProgramContext ctx) {
        Value result = null;
        for (StatementContext statement : ctx.statement()) {
            result = visit(statement);
        }
        return result;
    }

    @Override
    public Value visitAssignmentStatement(AssignmentStatementContext ctx) {
        String variableName = ctx.ID().getText();
        Value value = visit(ctx.expression());
        currentScope.setVariable(variableName, value);
        return value;
    }

    @Override
    public Value visitPrintStatement(PrintStatementContext ctx) {
        Value value = visit(ctx.expression());
        System.out.print(value.asString());
        return value;
    }

    @Override
    public Value visitIfStatement(IfStatementContext ctx) {
        Value condition = visit(ctx.expression());
        
        if (condition.asBoolean()) {
            // Создаем новую область видимости для блока if
            Scope ifScope = new Scope(currentScope);
            Scope previousScope = currentScope;
            currentScope = ifScope;
            
            // Выполняем все операторы в блоке if
            for (StatementContext statement : ctx.statement()) {
                visit(statement);
            }
            
            currentScope = previousScope;
        } else if (ctx.statement().size() > 1) {
            // Блок else (второй набор операторов)
            Scope elseScope = new Scope(currentScope);
            Scope previousScope = currentScope;
            currentScope = elseScope;
            
            // Пропускаем первый блок (if) и берем второй (else)
            for (int i = 1; i < ctx.statement().size(); i++) {
                visit(ctx.statement(i));
            }
            
            currentScope = previousScope;
        }
        
        return new Value(0);
    }

    @Override
    public Value visitWhileStatement(WhileStatementContext ctx) {
        while (visit(ctx.expression()).asBoolean()) {
            // Создаем новую область видимости для каждой итерации
            Scope whileScope = new Scope(currentScope);
            Scope previousScope = currentScope;
            currentScope = whileScope;
            
            // Выполняем все операторы в блоке while
            for (StatementContext statement : ctx.statement()) {
                visit(statement);
            }
            
            currentScope = previousScope;
        }
        return new Value(0);
    }

    @Override
    public Value visitMulDivExpr(MulDivExprContext ctx) {
        Value left = visit(ctx.expression(0));
        Value right = visit(ctx.expression(1));
        String op = ctx.getChild(1).getText();

        switch (op) {
            case "*":
                return multiply(left, right);
            case "/":
                return divide(left, right);
            default:
                throw new RuntimeException("Unknown operator: " + op);
        }
    }

    @Override
    public Value visitAddSubExpr(AddSubExprContext ctx) {
        Value left = visit(ctx.expression(0));
        Value right = visit(ctx.expression(1));
        String op = ctx.getChild(1).getText();

        switch (op) {
            case "+":
                return add(left, right);
            case "-":
                return subtract(left, right);
            default:
                throw new RuntimeException("Unknown operator: " + op);
        }
    }

    @Override
    public Value visitCompExpr(CompExprContext ctx) {
        Value left = visit(ctx.expression(0));
        Value right = visit(ctx.expression(1));
        String op = ctx.getChild(1).getText();

        switch (op) {
            case ">":
                return new Value(compare(left, right) > 0);
            case "<":
                return new Value(compare(left, right) < 0);
            case ">=":
                return new Value(compare(left, right) >= 0);
            case "<=":
                return new Value(compare(left, right) <= 0);
            case "==":
                return new Value(equals(left, right));
            case "!=":
                return new Value(!equals(left, right));
            default:
                throw new RuntimeException("Unknown operator: " + op);
        }
    }

    @Override
    public Value visitParenExpr(ParenExprContext ctx) {
        return visit(ctx.expression());
    }

    @Override
    public Value visitIntAtom(IntAtomContext ctx) {
        return new Value(Integer.parseInt(ctx.INT().getText()));
    }

    @Override
    public Value visitDoubleAtom(DoubleAtomContext ctx) {
        return new Value(Double.parseDouble(ctx.DOUBLE().getText()));
    }

    @Override
    public Value visitStringAtom(StringAtomContext ctx) {
        String text = ctx.STRING().getText();
        // Убираем кавычки
        return new Value(text.substring(1, text.length() - 1));
    }

    @Override
    public Value visitIdAtom(IdAtomContext ctx) {
        String variableName = ctx.ID().getText();
        return currentScope.getVariable(variableName);
    }

    // Вспомогательные методы для операций
    private Value add(Value left, Value right) {
        if (left.getType() == Value.Type.STRING || right.getType() == Value.Type.STRING) {
            return new Value(left.asString() + right.asString());
        }
        if (left.getType() == Value.Type.DOUBLE || right.getType() == Value.Type.DOUBLE) {
            return new Value(left.asDouble() + right.asDouble());
        }
        return new Value(left.asInt() + right.asInt());
    }

    private Value subtract(Value left, Value right) {
        if (left.getType() == Value.Type.DOUBLE || right.getType() == Value.Type.DOUBLE) {
            return new Value(left.asDouble() - right.asDouble());
        }
        return new Value(left.asInt() - right.asInt());
    }

    private Value multiply(Value left, Value right) {
        if (left.getType() == Value.Type.DOUBLE || right.getType() == Value.Type.DOUBLE) {
            return new Value(left.asDouble() * right.asDouble());
        }
        return new Value(left.asInt() * right.asInt());
    }

    private Value divide(Value left, Value right) {
        if (left.getType() == Value.Type.DOUBLE || right.getType() == Value.Type.DOUBLE) {
            double rightVal = right.asDouble();
            if (rightVal == 0.0) {
                throw new RuntimeException("Division by zero");
            }
            return new Value(left.asDouble() / rightVal);
        }
        int rightVal = right.asInt();
        if (rightVal == 0) {
            throw new RuntimeException("Division by zero");
        }
        return new Value(left.asInt() / rightVal);
    }

    private int compare(Value left, Value right) {
        if (left.getType() == Value.Type.DOUBLE || right.getType() == Value.Type.DOUBLE) {
            return Double.compare(left.asDouble(), right.asDouble());
        }
        return Integer.compare(left.asInt(), right.asInt());
    }

    private boolean equals(Value left, Value right) {
        if (left.getType() == Value.Type.STRING || right.getType() == Value.Type.STRING) {
            return left.asString().equals(right.asString());
        }
        if (left.getType() == Value.Type.DOUBLE || right.getType() == Value.Type.DOUBLE) {
            return left.asDouble() == right.asDouble();
        }
        return left.asInt() == right.asInt();
    }
} 
