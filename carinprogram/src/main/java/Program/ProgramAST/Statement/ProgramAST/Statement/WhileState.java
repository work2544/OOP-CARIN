package ProgramAST.Statement;

import ProgramAST.Statement.ErrorPack.EvalError;
import ProgramAST.Statement.ErrorPack.SyntaxError;
import ProgramAST.Statement.GlobalFile.NodeTree;

public class WhileState implements NodeTree {
    NodeTree expr;
    NodeTree statement;
    public WhileState(NodeTree expr,NodeTree statement){
        this.expr=expr;
        this.statement=statement;
    }

    @Override
    public int eval() throws SyntaxError, EvalError {
        for(int i=0;i<1000&&expr.eval()>0;i++)
        {
            statement.eval();
        }
        return 0;
    }
}
