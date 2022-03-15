package com.api.carinapi.statements;

import com.api.carinapi.interfaces.Unit;
import com.api.carinapi.statements.ErrorPack.EvalError;
import com.api.carinapi.statements.ErrorPack.SyntaxError;
import com.api.carinapi.statements.GlobalFile.NodeTree;
import com.api.carinapi.statements.GlobalFile.Variable;

public class Command implements NodeTree {
    NodeTree cmd;
    public Command(String actcom, String directionNode,Unit unit)
    {
        cmd=new ActionCommand(actcom,directionNode,unit);
    }
    public Command(Variable name, int exp)
    {
        cmd=new AssignCommand(name,exp);
    }

    @Override
    public int eval() throws EvalError, SyntaxError {
        return cmd.eval();
    }
}
class ActionCommand implements NodeTree{
    String actcom; //move or acttack
    String directionNode;
    Unit unit;
    public ActionCommand(String actcom, String directionNode,Unit unit)
    {
        this.actcom=actcom;
        this.directionNode=directionNode;
        this.unit=unit;
    }

    @Override
    public int eval() {
        if(actcom.equalsIgnoreCase("move"))
        {
            unit.move(directionNode);
        }
        else if(actcom.equalsIgnoreCase("shoot"))
        {
            unit.attack(directionNode);
        }
        return 0;
    }

}
class AssignCommand implements NodeTree{
    Variable name;
    int exp;

    public AssignCommand(Variable name, int exp) {
        this.name=name;
        this.exp=exp;
    }
    @Override
    public int eval() throws EvalError, SyntaxError {
        Variable.assign(exp);
        return exp;
    }
}

