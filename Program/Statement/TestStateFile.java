public class TestStateFile {
    public static void main(String[] args) {
        CommandParser CP=new CommandParser(new Expr[]{
            new Assign(new Variable("C"),new MyInt(1)),
            new Assign(new Variable("D"),new MyInt(2))
        });
    }
}
