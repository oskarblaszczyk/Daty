package urodziny;

public class InvalidBirthDateException extends RuntimeException {
    InvalidBirthDateException() {
    }

    InvalidBirthDateException(String message) {
        super(message);
    }
}
