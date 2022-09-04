package hangman.model;

import hangman.model.exceptions.GameScoreException;

public interface GameScore {

    public int calculateScore(int correctCount, int incorrectCount) throws GameScoreException;

}
