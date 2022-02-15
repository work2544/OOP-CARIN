package Statement.CommandStatement;
import ErrorPack.SyntaxError;
import ErrorPack.EvalError;
import Expression.ExprParser;

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
    Variable var;
    Value val;
    ActCom actCom;
    public CommandAST(Variable var,Value val) throws SyntaxError, EvalError {
        this.var=var;
        this.val=val; //must parseExpr
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
        s.append(var+" = "+val);
    }
    }
    
}

class Variable implements CommandNode{
    protected String name;
    public Variable(String name){
        this.name=name;
    }

    @Override
    public void prettyPrint(StringBuilder s) {
        s.append(name);   }

}
class Value implements CommandNode{
    protected int value;
    public Value(ExprParser Input) throws SyntaxError, EvalError {
        this.value=Input.parseE().eval(null) ;
    }

    @Override
    public void prettyPrint(StringBuilder s) {
        s.append(value);
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

    public static void main(String[] args) throws SyntaxError, EvalError {
//        CommandGroup CG=new CommandGroup(new CommandNode[]{
//                new AssignmentStatement("A","1+2"),
//                new AssignmentStatement("B","2+3*5")
//        });
//
//        StringBuilder s=new StringBuilder();
//        for (CommandNode CN: CG.eval())
//            CN.prettyPrint(s);
//        System.out.println(s);
    }
}
