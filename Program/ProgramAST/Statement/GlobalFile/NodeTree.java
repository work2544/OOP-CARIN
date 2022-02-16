package ProgramAST.GlobalFile;

import ProgramAST.ErrorPack.EvalError;
import ProgramAST.ErrorPack.SyntaxError;

public interface NodeTree {
 int eval() throws EvalError, SyntaxError;
}
