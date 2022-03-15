package com.api.carinapi.statements.GlobalFile;

import com.api.carinapi.statements.ErrorPack.SyntaxError;

public interface Tokenizer {
    /**
     * Returns the next token
     * in the input stream.
     */
    String peek();

    /**
     * Consumes the next token
     * from the input stream
     * and returns it.
     *
     * @throws SyntaxError
     */
    String consume() throws SyntaxError;
}
