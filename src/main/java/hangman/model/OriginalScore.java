package hangman.model;

import hangman.model.exceptions.GameScoreException;

public class OriginalScore implements GameScore {

    /**
     * @pre it starts with 100 points
     * @pos minimum score is 0.
     * @param correctCount correct letters given by user
     * @param incorrectCount incorrect letters given by user
     * @throws GameScoreException [correctCount<0,incorrectCount<0]
     * @return total user score
     */
    @Override
    public int calculateScore(int correctCount, int incorrectCount) {
        return 0;
    }
}
