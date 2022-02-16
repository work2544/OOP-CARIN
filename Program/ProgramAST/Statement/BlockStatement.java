package ProgramAST.Statement.BlockStatement;

import ProgramAST.ErrorPack.EvalError;
import ProgramAST.ErrorPack.SyntaxError;
import ProgramAST.GlobalFile.NodeTree;


public class BlockStatement implements NodeTree {
    NodeTree expr;
    NodeTree statement;
    public BlockStatement(NodeTree expr,NodeTree statement){
        this.expr=expr;
        this.statement=statement;
    }

    @Override
    public int eval() throws SyntaxError, EvalError {
            statement.eval();
        return 0;
    }
}
