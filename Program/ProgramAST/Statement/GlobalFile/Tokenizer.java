package ProgramAST.GlobalFile;

import ProgramAST.ErrorPack.SyntaxError;

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
