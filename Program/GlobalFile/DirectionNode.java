package GlobalFile;
import ErrorPack.EvalError;

public interface DirectionNode extends NodeTree {
    String eval() throws EvalError;
}
