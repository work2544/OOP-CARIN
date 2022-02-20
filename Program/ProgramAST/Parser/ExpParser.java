package ProgramAST.Parser;

import ProgramAST.ProgramTokenizer;
import ProgramAST.Statement.Command;
import ProgramAST.Statement.ErrorPack.EvalError;
import ProgramAST.Statement.ErrorPack.SyntaxError;
import ProgramAST.Statement.Expression.BinaryArithExpr;
import ProgramAST.Statement.GlobalFile.MyNumber;
import ProgramAST.Statement.GlobalFile.NodeTree;
import ProgramAST.Statement.GlobalFile.Variable;
import Unit.Unit;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;


public class ExpParser {


    public static void main(String[] args) throws SyntaxError, EvalError {
        Parser exp;
        Unit x=null;
        Map<String,Integer> unitvar=new HashMap<>();
        exp=new Parser("<10>+<10>",unitvar,x);
        System.out.println(exp.parseState().eval());
        exp=new Parser("<a>=<10>",unitvar,x);
        System.out.println(exp.parseState().eval());
        exp=new Parser("<a2>=<10>+<10>",unitvar,x);
        System.out.println(exp.parseState().eval());
        exp=new Parser("<b2>=<a2>*<2>",unitvar,x);
        System.out.println(exp.parseState().eval());
    }


}
