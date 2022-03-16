package ProgramAST;

import ProgramAST.Statement.ErrorPack.EvalError;
import ProgramAST.Statement.ErrorPack.SyntaxError;
import ProgramAST.Statement.GlobalFile.NodeTree;

import java.util.ArrayList;

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
