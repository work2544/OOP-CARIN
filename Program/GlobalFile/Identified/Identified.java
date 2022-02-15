package GlobalFile.Identified;

import ErrorPack.EvalError;
import ErrorPack.SyntaxError;
import Expression.ExprParser;
import Expression.ExprTokenizer;
import GlobalFile.ExprPaser;
import GlobalFile.NodeTree;

import java.util.Arrays;
import java.util.Map;

interface Iden extends NodeTree {
    int eval(Map<String, Integer> binder) throws EvalError;
}

class Variable implements Iden {
    protected String name;

    public Variable(String name) {
        this.name = name;
    }

    @Override
    public void prettyPrint(StringBuilder s) {
        s.append(name);
    }

    @Override
    public int eval(Map<String, Integer> binder) throws EvalError {
        if (binder.containsKey(name)) {
            return binder.get(name);
        }
        throw new EvalError("undefined variable: " + name);
    }
}

class Value implements Iden { // parseExpression
    protected int value;

    public Value(ExprParser Input) throws SyntaxError, EvalError {
        this.value = Input.parseE().eval(null);
    }

    @Override
    public void prettyPrint(StringBuilder s) {
        s.append(value);
    }

    @Override
    public int eval(Map<String, Integer> binder) {
        return value;
    }
}

class IdenAST implements Iden {
    Variable var;
    Value val;

    public IdenAST(Variable var, Value val) {
        this.var = var;
        this.val = val;
    }

    @Override
    public void prettyPrint(StringBuilder s) {
        s.append(var.name + " " + val.value);
    }

    @Override
    public int eval(Map<String, Integer> binder) {
        return val.value;
    }
}

public class Identified {
    static String[] bannedWord = new String[] { "antibody", "down", "downleft", "downright", "else", "if", "left", "move",
            "nearby", "right", "shoot", "then", "up", "upleft", "upright", "virus", "while" };
    static IdentifiedTokenizer tkz;

    public Identified(String src) throws SyntaxError {
        tkz = new IdentifiedTokenizer(src);
    }

    public static Iden ParseID() throws SyntaxError, EvalError {
        String val;
        String var;
        if (tkz.peek("<")) {
            tkz.consume("<");
            var = tkz.consume();
            if(Arrays.asList(bannedWord).contains(var)) throw new SyntaxError("cannot be used as identifiers: "+var);
            tkz.consume(">");
            if (tkz.peek("=")) {
                val = ParseE();// new ExprParser()
                ExprParser exp = new ExprParser(val);
                return new IdenAST(new Variable(var), new Value(exp));
            }
        }
        throw new SyntaxError("wrong charactor");
    }

    public static String ParseE() throws SyntaxError {
        ExprTokenizer etkz = new ExprTokenizer(tkz.getSrc(), tkz.getPos());
        return etkz.consume();
    }

    public static boolean IsIdentifier() {
        return false;
    }
}
