package com.api.carinapi.utils;

import com.api.carinapi.statements.ErrorPack.SyntaxError;
import com.api.carinapi.statements.GlobalFile.Tokenizer;

public class ProgramTokenizer implements Tokenizer {

    private String src;
    private String next;
    private int pos;

    public ProgramTokenizer(String src) throws SyntaxError {
        this.src = src;
        pos = 0;
        computeNext();
    }
    private void computeNext() throws SyntaxError {
        StringBuilder s = new StringBuilder();
        while (pos < src.length()) {
            char c = src.charAt(pos);
            s.append(c);

            if (Character.isDigit(c)) {  // start of number
                for (pos++; pos < src.length() && Character.isDigit(src.charAt(pos)); pos++)
                    s.append(src.charAt(pos));
                break;
            } else if (Character.isLetter(c)) {  // start of string
                for (pos++; pos < src.length() && (Character.isLetter(src.charAt(pos))||Character.isDigit(src.charAt(pos))); pos++)
                    s.append(src.charAt(pos));
                break;
            } else if (c == '(' || c == ')'||c=='<'||c=='>' ||c == '+' ||  c == '-' || c == '*' || c == '/' || c == '%'||c=='^'||c=='='||c=='{'||c=='}'||c=='\n') {
                pos++;
                break;
            } else if (c == ' ')  // ignore whitespace
            {
                pos++;
                s.setLength(s.length() - 1);
            } else
                throw new SyntaxError("unknown character: " + c);
        }
        next = s.toString();

    }

    @Override
    public String peek() {
        return next;
    }

    @Override
    public String consume() throws SyntaxError {
        String result = next;
        computeNext();
        return result;
    }

    public boolean peek(String s) {
        return next.equals(s);
    }


    public void consume(String s) throws SyntaxError {
        if (peek(s)) {
            consume();
        } else
            throw new SyntaxError("error with " + peek());
    }
}

