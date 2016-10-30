package m1.cmd;

/**
 * Created by Ejdems on 28/10/2016.
 */
public class CmdException extends Exception {
    public static final boolean LITERAL = true;

    public CmdException(String message) {
        super("Unknown command: "+message);
    }

    public CmdException(String message,boolean literal) {
        super(message);
    }
}
