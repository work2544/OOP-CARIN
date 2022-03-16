package com.api.carinapi.statements;

import com.api.carinapi.statements.ErrorPack.EvalError;
import com.api.carinapi.statements.ErrorPack.SyntaxError;
import com.api.carinapi.statements.GlobalFile.NodeTree;

public class IfState implements NodeTree {
   NodeTree ifexp;
   NodeTree thenstate;
   NodeTree elsestate;
   public IfState(NodeTree ifexp,NodeTree thenstate,NodeTree elsestate)
   {
        this.ifexp=ifexp;
        this.thenstate=thenstate;
        this.elsestate=elsestate;
   }

    @Override
    public int eval() throws SyntaxError, EvalError {
       if(ifexp.eval()>0)
           thenstate.eval();
       else
           elsestate.eval();
        return 0;
    }
}