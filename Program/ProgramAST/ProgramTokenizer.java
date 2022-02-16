package ProgramAST;

import ProgramAST.Statement.ErrorPack.SyntaxError;
import ProgramAST.Statement.GlobalFile.Tokenizer;

public class ProgramTokenizer implements Tokenizer {

        private String src;
        private String next;
        private int pos;
        public class MyText{
            static String[] banned_word={"antibody", "down", "downleft", "downright", "else", "if",
                    "left", "move", "nearby", "right", "shoot", "then", "up", "upleft", "upright", "virus", "while"};
            static String[] direction={"left" ," right" ," up ", "down "," upleft "," upright "," downleft "," downright"};
    }
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
                    break;
                } else if (c == '(' || c == ')'||c=='<'||c=='>' ||c == '+' ||  c == '-' || c == '*' || c == '/' || c == '%'||c=='^'||c=='=') {
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
            for (String bw:MyText.banned_word){
                if(bw.equals(next))throw new SyntaxError("banned word: " + next);
            }
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
        public static boolean isNumber(String peek) {
        try {
            Double.parseDouble(peek);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
        }
    public static boolean isDirection(String peek) {
        for(String d:MyText.direction){
            if(peek.equals(d))return true;
        }
        return false;
    }
        public void consume(String s) throws SyntaxError {
            if (peek(s)) {
                consume();
            } else
                throw new SyntaxError("error with " + peek());
        }
    }

