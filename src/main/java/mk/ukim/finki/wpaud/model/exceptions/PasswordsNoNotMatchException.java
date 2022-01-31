package mk.ukim.finki.wpaud.model.exceptions;

public class PasswordsNoNotMatchException extends RuntimeException{
    public PasswordsNoNotMatchException() {
        super("Passwords do not match exception");
    }
}
