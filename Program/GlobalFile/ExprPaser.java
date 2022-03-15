package GlobalFile;

import ErrorPack.EvalError;
import ErrorPack.SyntaxError;

import java.util.Map;

public interface ExprPaser extends NodeTree {
    int eval(Map<String, Integer> bindings) throws EvalError, SyntaxError;
}