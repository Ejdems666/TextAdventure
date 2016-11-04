package m3.cmd;

/**
 * Created by Ejdems on 03/11/2016.
 */
public class InterpreterException extends Exception {
    public InterpreterException(String message) {
        super("Unknown command " + message);
    }
}
