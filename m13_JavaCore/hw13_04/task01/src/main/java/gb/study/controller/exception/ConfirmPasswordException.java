package gb.study.controller.exception;

public class ConfirmPasswordException extends Exception {
    public ConfirmPasswordException() {
    }
    public ConfirmPasswordException(String message) {
        super(message);
    }
}
