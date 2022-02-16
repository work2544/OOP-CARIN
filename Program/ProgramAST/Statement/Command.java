package ProgramAST.Statement.CommandStatement;

import ProgramAST.ErrorPack.EvalError;
import ProgramAST.ErrorPack.SyntaxError;
import ProgramAST.Expression.BinaryArithExpr;
import ProgramAST.GlobalFile.DirectionNode;
import ProgramAST.GlobalFile.ExprPaser;
import ProgramAST.GlobalFile.NodeTree;
import ProgramAST.GlobalFile.Variable;
import Unit.Unit;



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
    BinaryArithExpr exp;

    public AssignCommand(Variable name, BinaryArithExpr exp) {
        this.exp=exp;
        this.name=name;
    }
    @Override
    public int eval() throws EvalError, SyntaxError {
        Variable.assign(exp.eval());
        return 0;
    }
}

