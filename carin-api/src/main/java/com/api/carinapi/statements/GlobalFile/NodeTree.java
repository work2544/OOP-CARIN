package com.api.carinapi.statements.GlobalFile;

import com.api.carinapi.statements.ErrorPack.EvalError;
import com.api.carinapi.statements.ErrorPack.SyntaxError;

public interface NodeTree {
 int eval() throws EvalError, SyntaxError;
}
