package hangman.model;

import hangman.model.exceptions.GameScoreException;

public class PowerScore implements GameScore {

    /**
     * @pre it starts with 0 points
     * @pos minimum score is 0 and maximum score is 500.
     * @param correctCount correct letters given by user
     * @param incorrectCount incorrect letters given by user
     * @throws GameScoreException [correctCount<0,incorrectCount<0]
     * @return total user score
     */
    @Override
    public int calculateScore(int correctCount, int incorrectCount) throws GameScoreException {
        if (correctCount <0 | incorrectCount < 0) throw new GameScoreException(GameScoreException.NEGATIVE_COUNTS);
        int initialPoints = 0;
        int goodPoints = 0;
        for (int i=1; i <= correctCount; i++) {
            goodPoints += Math.pow(5,i);
        }

        int badPoints = incorrectCount * 8;
        int finalScore = initialPoints + goodPoints - badPoints;

        if (finalScore < 0) finalScore = 0;
        else if (finalScore > 500) finalScore = 500;

        return finalScore;
    }
}