package com.api.carinapi.utils;

import java.util.Map;

import com.api.carinapi.interfaces.Unit;
import com.api.carinapi.statements.BlockStatement;
import com.api.carinapi.statements.Command;
import com.api.carinapi.statements.IfState;
import com.api.carinapi.statements.WhileState;
import com.api.carinapi.statements.ErrorPack.EvalError;
import com.api.carinapi.statements.Expression.BinaryArithExpr;
import com.api.carinapi.statements.Expression.Sensor;
import com.api.carinapi.statements.GlobalFile.NodeTree;
import com.api.carinapi.statements.GlobalFile.Variable;

public  class StatmentFac {

    public NodeTree creatStatement(String actcom, String directionNode, Unit unit) {
        return new Command(actcom, directionNode, unit);
    }
    public NodeTree creatStatement(NodeTree left, String op, NodeTree right) {
        return new BinaryArithExpr(left, op, right);
    }
    public NodeTree creatStatement(Unit unit, String direction) {
        return new Sensor(unit, direction);
    }

    public  NodeTree creatStatement(NodeTree statement) {
        return new BlockStatement(statement);
    }

    public NodeTree creatWhileStatement(NodeTree expr, NodeTree statement) {
        return new WhileState(expr, statement);
    }
    public NodeTree creatAssignStatement(Variable var) throws EvalError {
        return new Command(var);
    }
    public NodeTree creatAssignStatement(Variable var,NodeTree expr){
        return new Command(var,expr);
    }
    public NodeTree creatIfStatement(NodeTree ifexp, NodeTree thenstate, NodeTree elsestate) {
        return new IfState(ifexp, thenstate, elsestate);
    }
    public NodeTree creatIfStatement(NodeTree ifexp, NodeTree thenstate) {
        return new IfState(ifexp, thenstate);
    }
    public NodeTree creatStatement(String identifier, Map<String,Integer> allvar)
    {
        return new Variable(identifier,allvar);
    }

}
