package ProgramAST.Statement.GlobalFile;

public class MyNumber implements NodeTree {

        private int val;
        public MyNumber(int val) {
            this.val = val;
        }
        @Override
        public int eval() {
            return val;
        }
}
