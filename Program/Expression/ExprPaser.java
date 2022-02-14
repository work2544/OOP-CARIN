package Expression;

import ErrorPack.EvalError;
import ErrorPack.SyntaxError;

import java.util.Map;

interface Node {
    void prettyPrint(StringBuilder s);
}

public interface ExprPaser extends Node {
    int eval(Map<String, Integer> bindings) throws EvalError, SyntaxError;
}