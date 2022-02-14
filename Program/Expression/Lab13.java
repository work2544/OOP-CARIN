package Expression;

import ErrorPack.EvalError;
import ErrorPack.SyntaxError;


import java.util.HashMap;
import java.util.Map;

public class Lab13 {

    public static void main(String[] args) throws Exception {
      
        System.out.println(fortestequation("2+3"));
        System.out.println(fortestoutput("2+3"));
    }

    public static String fortestoutput(String Input) throws SyntaxError, EvalError {
        try {
            ExprParser x = new ExprParser(Input);
            ExprPaser exp = x.parseE();
            StringBuilder expression = new StringBuilder();
            Map<String, Integer> answerarg = new HashMap<String, Integer>();
            exp.prettyPrint(expression);
            int realanswer = exp.eval(null);
            System.out.println(expression + " = " + realanswer);
            return String.valueOf(realanswer);
        } catch (Exception e) {
            e.printStackTrace();
            return "Invalid Input";
        }
    }

    public static String fortestequation(String Input) throws SyntaxError, EvalError {
        try {
            ExprParser x = new ExprParser(Input);
            ExprPaser exp =  x.parseE();
            StringBuilder expression = new StringBuilder();
            exp.prettyPrint(expression);
            System.out.println(expression);
            return String.valueOf(expression);
        } catch (Exception e) {
            e.printStackTrace();
            return "Invalid Input";
        }
        
    }


}
