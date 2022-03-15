package com.api.carinapi.utils;

import java.util.Map;

import com.api.carinapi.interfaces.Unit;
import com.api.carinapi.statements.BlockStatement;
import com.api.carinapi.statements.Command;
import com.api.carinapi.statements.IfState;
import com.api.carinapi.statements.WhileState;
import com.api.carinapi.statements.Expression.BinaryArithExpr;
import com.api.carinapi.statements.Expression.Sensor;
import com.api.carinapi.statements.GlobalFile.NodeTree;
import com.api.carinapi.statements.GlobalFile.Variable;

public  class StatmentFac {

    public static NodeTree creatStatement(String actcom, String directionNode, Unit unit) {
        return new Command(actcom, directionNode, unit);
    }
    public static NodeTree creatStatement(NodeTree left, String op, NodeTree right) {
        return new BinaryArithExpr(left, op, right);
    }
    public static NodeTree creatStatement(Unit unit, String direction) {
        return new Sensor(unit, direction);
    }

    public static  NodeTree creatStatement(NodeTree statement) {
        return new BlockStatement(statement);
    }

    public static NodeTree creatWhileStatement(NodeTree expr, NodeTree statement) {
        return new WhileState(expr, statement);
    }
    public static NodeTree creatAssignStatement(Variable var,int bina){
        return new Command(var,bina);
    }
    public static NodeTree creatIfStatement(NodeTree ifexp, NodeTree thenstate, NodeTree elsestate) {
        return new IfState(ifexp, thenstate, elsestate);
    }
    public static NodeTree creatStatement(String identifier, Map<String,Integer> allvar)
    {
        return new Variable(identifier,allvar);
    }

}
