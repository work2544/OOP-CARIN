import Direction.DirectionParser;
import ErrorPack.EvalError;
import ErrorPack.SyntaxError;
import GlobalFile.DirectionNode;

public class ProgramStatementParser {
//    Expr[] exp;
//    public ProgramStatementParser(Expr[] exp) {
//        this.exp = exp;
//    }
public static void main(String[] args) throws SyntaxError, EvalError {

   testDirection();
    System.out.println("fuk");

}
public static void testDirection() throws SyntaxError, EvalError {
try {
    DirectionParser y = new DirectionParser("work");
    DirectionNode dn = y.ParseDirect();
    System.out.println(dn.eval());
}
catch (Exception e)
{
    System.out.println("something wrong");
}
}
}
