package hangman.model.exceptions;

public class GameScoreException extends Exception {

    public static String NEGATIVE_COUNTS = "Counts cannot be negative";

    public GameScoreException(String message) {
        super(message);
    }

}
