package com.api.carinapi.utils;


import java.util.ArrayList;

import com.api.carinapi.statements.ErrorPack.EvalError;
import com.api.carinapi.statements.ErrorPack.SyntaxError;
import com.api.carinapi.statements.GlobalFile.NodeTree;

public class GeneProgram implements NodeTree {
    ArrayList<NodeTree> geneProgram;
    public GeneProgram(){
        geneProgram=new ArrayList<>();
    }
    public void add(NodeTree program){
        geneProgram.add(program);
    }

    @Override
    public int eval() throws EvalError, SyntaxError {
        for (NodeTree nt: geneProgram
             ) {
            nt.eval();
        }
        return 0;
    }
}
