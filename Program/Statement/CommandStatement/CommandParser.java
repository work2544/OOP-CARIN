package Statement.CommandStatement;
import ErrorPack.SyntaxError;
import ErrorPack.EvalError;
import Expression.ExprParser;

import GlobalFile.Identified.Identified;
import GlobalFile.NodeTree;

interface CommandNode extends NodeTree {
    void prettyPrint(StringBuilder s);
}

//interface Ident extends CommandNode{
//    int eval(Map<Variable,Value> bindings) throws EvalError, SyntaxError;
//}
//interface Act extends CommandNode{
//    String eval(String command) throws EvalError, SyntaxError;
//}

class CommandAST implements CommandNode{

    ActCom actCom;
    public CommandAST(Identified iden) throws SyntaxError, EvalError {

    }
    public CommandAST(ActCom actCom){
        this.actCom=actCom;
    }

    @Override
    public void prettyPrint(StringBuilder s) {
    if(actCom!=null)
    {
        s.append(actCom);
    }
    else
    {
       // s.append(var+" = "+val);
    }
    }
}


class ActCom implements CommandNode{
    String actcom; //move or acttack
    public ActCom(String actcom)
    {
        this.actcom=actcom;
    }

    @Override
    public void prettyPrint(StringBuilder s) {
    s.append(actcom);
    }

}

public class CommandParser{ //เจอ= assign ไม่เจอ command
    static ComTokenizer ct;
    public CommandParser(String Input) throws SyntaxError {
        ct=new ComTokenizer(Input);
    }
    public static CommandNode ComParser() throws SyntaxError {
        CommandNode e ;//parseAct()
        if (ct.peek("=")) {
            String op = ct.consume();
            if (op.equals("=")){}
             //   e = new CommandAST(e,new ExprParser(ct));
        }
        return null;
    
    }
    public static CommandNode ParseAssignCommand()
    {
return null;
    }
    public static CommandNode ParseActionCommand()
    {
        return null;
    }
    public static CommandNode ParseMove(){
        return null;
    }
    public static CommandNode ParseShoot(){
        return null;
    }
}
