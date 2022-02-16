package ProgramAST.Statement;

import ProgramAST.Statement.ErrorPack.EvalError;
import ProgramAST.Statement.ErrorPack.SyntaxError;
import ProgramAST.Statement.GlobalFile.NodeTree;


public class BlockStatement implements NodeTree {
    NodeTree statement;
    public BlockStatement(NodeTree statement){
        this.statement=statement;
    }

    @Override
    public int eval() throws SyntaxError, EvalError {
            statement.eval();
        return 0;
    }
}
