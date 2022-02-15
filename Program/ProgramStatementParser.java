import Direction.DirectionParser;
import ErrorPack.EvalError;
import ErrorPack.SyntaxError;
import GlobalFile.DirectionNode;
import GlobalFile.Identified.Identified;

public class ProgramStatementParser {
//    Expr[] exp;
//    public ProgramStatementParser(Expr[] exp) {
//        this.exp = exp;
//    }
public static void main(String[] args) throws SyntaxError, EvalError {

   testIden();
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
public static void testIden() throws SyntaxError, EvalError {
    Identified id=new Identified("<x>=1+1+1");

    System.out.println(id.ParseID());
}
}
