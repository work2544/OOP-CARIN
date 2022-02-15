package Direction;
import ErrorPack.EvalError;
import ErrorPack.SyntaxError;
import GlobalFile.*;
class DirectionAst implements DirectionNode{
    DirectionNode direction;
    enum EDirection {
        left,right,up,down,upleft,upright,downleft,downright
    }
    public DirectionAst(DirectionNode direction)
    {
        this.direction=direction;
    }
    @Override
    public void prettyPrint(StringBuilder s) {

    }

    @Override
    public String eval() throws EvalError {
        for(EDirection ed:EDirection.values())
        {
            String sdir= direction.eval();
            if(sdir.equals(ed.name()))
            {
                return direction.eval();
            }
        }
        throw new EvalError("undefined direction"+direction.eval());
    }
}
class Direction implements DirectionNode{
    String direction;
    public Direction(String input){
        this.direction=input;
    }
    @Override
    public String eval() {
        return direction;
    }

    @Override
    public void prettyPrint(StringBuilder s) {
    s.append(direction);
    }
}
public class DirectionParser {
private static DirectionToken tkz;
public DirectionParser(String src) throws SyntaxError {
    this.tkz=new DirectionToken(src);
}
public DirectionNode ParseDirect() throws SyntaxError {
    String word= tkz.consume();
    Direction direction=new Direction(word.toLowerCase());
    return new DirectionAst(direction);

}


}
