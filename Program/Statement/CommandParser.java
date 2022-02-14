interface Expr{
    void Myprint();
}
class AssignmentStatement implements Expr{
    Variable variable;
    Expr expression;
    public AssignmentStatement(Variable variable, Expr expression){
        this.variable = variable;
        this.expression = expression;
    }
}
class Variable implements Expr{
    String name;
    public Variable(String name){
        this.name =name;
    }
}
class MyInt implements Expr{
    int value;
    public MyInt(int value){
        this.value =value;
    }
}
class Command implements Expr{
    Expr[] Statements;
    public Command(Expr[] statements) {
        this.Statements = statements;
     }
    public void Print(){
        for(Expr statement : Statements){
            System.out.println(statement);
        }
    }
    
}
public class CommandParser{
    public static void main(String[] args) {
        Expr statements = new Command(new Expr[]{
           new AssignmentStatement(new Variable("C"),new MyInt(1)),
           new AssignmentStatement(new Variable("D"),new MyInt(2))
        });
        System.out.println(statements.p);
    }
}
