package Statement;
import ErrorPack.SyntaxError;
import ErrorPack.EvalError;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

interface CommandNode {
    void prettyPrint(StringBuilder s);
}
interface CommandExpr extends CommandNode {
    LinkedList<CommandNode> eval() throws EvalError, SyntaxError;
}
interface IdentifiedExpr extends CommandNode{
    int eval(Map<Variable,Value> bindings) throws EvalError, SyntaxError;
}

class CommandGroup implements CommandExpr{
    CommandNode[] commands;
    public CommandGroup(CommandNode[] commands){
        this.commands=commands;
    }

    @Override
    public void prettyPrint(StringBuilder s) {
        s.append(commands);
    }

    @Override
    public LinkedList<CommandNode> eval() throws EvalError, SyntaxError {
        return new LinkedList<CommandNode>(List.of(commands));
    }
}
class AssignmentStatement implements IdentifiedExpr{
    Variable var;
    Value val;
    public AssignmentStatement(String var,int val){
        this.var=new Variable(var);
        this.val=new Value(val);
    }

    @Override
    public void prettyPrint(StringBuilder s) {
        s.append(var.name+" = "+val.value+", ");
    }

    @Override
    public int eval(Map<Variable,Value> bindings) throws EvalError, SyntaxError {
        if(bindings.containsKey(var))
            return bindings.get(var).value;
        else
            throw new EvalError("Undefined Variable: "+var);
    }

}

class Variable {
    protected String name;
    public Variable(String name){
        this.name=name;
    }

}
class Value{
    protected int value;
    public Value(int value){
        this.value = value;
    }
}

public class CommandParser{
    public static void main(String[] args) throws SyntaxError, EvalError {
        AssignmentStatement[] statements = new AssignmentStatement[]{
                new AssignmentStatement("A",1),
                new AssignmentStatement("B",2)
        };
        System.out.println(statements);
        CommandGroup CG=new CommandGroup(new CommandNode[]{
                new AssignmentStatement("A",1),
                new AssignmentStatement("B",2)
        });

        StringBuilder s=new StringBuilder();
        for (CommandNode CN: CG.eval())
            CN.prettyPrint(s);
        System.out.println(s);
    }
}
