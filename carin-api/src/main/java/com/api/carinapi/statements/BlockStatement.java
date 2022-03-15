package com.api.carinapi.statements;

import com.api.carinapi.statements.ErrorPack.EvalError;
import com.api.carinapi.statements.ErrorPack.SyntaxError;
import com.api.carinapi.statements.GlobalFile.NodeTree;

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
