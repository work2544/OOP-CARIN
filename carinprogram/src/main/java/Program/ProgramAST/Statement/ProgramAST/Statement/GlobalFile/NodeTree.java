package ProgramAST.Statement.GlobalFile;

import ProgramAST.Statement.ErrorPack.EvalError;
import ProgramAST.Statement.ErrorPack.SyntaxError;

public interface NodeTree {
 int eval() throws EvalError, SyntaxError;
}
