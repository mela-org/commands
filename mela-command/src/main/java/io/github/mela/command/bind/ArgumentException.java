package io.github.mela.command.bind;

/**
 * @author Johnny_JayJay (https://www.github.com/JohnnyJayJay)
 */
public class ArgumentException extends RuntimeException {

  public ArgumentException() {
    super();
  }

  public ArgumentException(String message) {
    super(message);
  }

  public ArgumentException(String message, Throwable cause) {
    super(message, cause);
  }

  public ArgumentException(Throwable cause) {
    super(cause);
  }

  protected ArgumentException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }
}
