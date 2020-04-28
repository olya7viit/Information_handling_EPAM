package by.matusevich.task2.exception;

public class ImpossibleOperationException extends Throwable {

    public ImpossibleOperationException() {
        super();
    }

    public ImpossibleOperationException(String message) {
        super(message);
    }

    public ImpossibleOperationException(String message, Throwable cause) {
        super(message, cause);
    }

    public ImpossibleOperationException(Throwable cause) {
        super(cause);
    }

    protected ImpossibleOperationException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
