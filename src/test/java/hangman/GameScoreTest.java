package hangman;

import hangman.model.BonusScore;
import hangman.model.OriginalScore;
import hangman.model.PowerBonusScore;
import hangman.model.exceptions.GameScoreException;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.fail;


/**
 * Equivalence class
 * Original Score
 * VALID: [0,100]
 * INVALID: (-inf,0) V (100,inf)
 *
 * correctCount and incorrectCount
 * VALID: [0,inf)
 * INVALID: (-inf,0]
 * * Limit: 0
 *
 * Bonus Score
 * VALID: [0,inf)
 * INVALID: (-inf,0)
 *
 * correctCount and incorrectCount
 * VALID: [0,inf)
 * INVALID: (-inf,0]
 * * Limit: 0
 *
 * PowerBonusScore
 * VALID: [0,500]
 * INVALID: (-inf,0) V (500,inf)
 *
 * correctCount and incorrectCount
 * VALID: [0,inf)
 * INVALID: (-inf,0]
 * * Limit: 0
 *
 */
public class GameScoreTest {

    OriginalScore originalScore = new OriginalScore();
    BonusScore bonusScore = new BonusScore();
    PowerBonusScore powerBonusScore = new PowerBonusScore();


    // originalScore
    @Test
    public void givenANumberOriginalScoreWhenNegativeThenThrowError() {
        try {
            originalScore.calculateScore(-50,0);
            fail("calculateScore cannot accept negative values for correctCount or incorrectCount");
        } catch (GameScoreException e) {
            Assert.assertTrue(true);
        }
    }

    @Test
    public void givenCorrectIncorrectOriginalScoreWhenIs0ThenResult100() {
        try {
            int correct = 0;
            int incorrect = 0;
            int actualResult = originalScore.calculateScore(correct,incorrect);
            int expected = 100;
            Assert.assertEquals(expected, actualResult);

        } catch (GameScoreException e) {
            fail();
        }
    }

    @Test
    public void givenCorrectOriginalScoreWhenIs0ThenResult100() {
        try {
            int correct = 10;
            int incorrect = 0;
            int actualResult = originalScore.calculateScore(correct,incorrect);
            int expected = 100;
            Assert.assertEquals(expected, actualResult);

        } catch (GameScoreException e) {
            fail();
        }
    }

    @Test
    public void givenIncorrectOriginalScoreWhenIs0ThenResultChange() {
        try {
            int correct = 0;
            int incorrect = 3;
            int actualResult = originalScore.calculateScore(correct,incorrect);
            int expected = 100 - incorrect * 10;
            Assert.assertEquals(expected, actualResult);

        } catch (GameScoreException e) {
            fail();
        }
    }

    @Test
    public void givenCorrectIncorrectOriginalScoreWhenPositiveThenGiveResult() {
        try {
            int correct = 2;
            int incorrect = 4;
            int actualResult = originalScore.calculateScore(correct,incorrect);
            int expected = 100 - incorrect * 10;
            Assert.assertEquals(expected, actualResult);

        } catch (GameScoreException e) {
            fail();
        }
    }

    // bonusScore
    @Test
    public void givenANumberBonusScoreWhenNegativeThenThrowError() {
        try {
            bonusScore.calculateScore(50,-80);
            fail("calculateScore cannot accept negative values for correctCount or incorrectCount");
        } catch (GameScoreException e) {
            Assert.assertTrue(true);
        }
    }

    @Test
    public void givenIncorrectBonusScoreWhenIs8ThenResult0() {
        try {
            int correct = 0;
            int incorrect = 8;
            int actualResult = bonusScore.calculateScore(correct,incorrect);
            int expected = correct * 10 - incorrect * 5;
            Assert.assertEquals(expected, actualResult);

        } catch (GameScoreException e) {
            fail();
        }
    }

    @Test
    public void givenCorrectBonusScoreWhenIs0ThenResult0() {
        try {
            int correct = 0;
            int incorrect = 0;
            int actualResult = bonusScore.calculateScore(correct,incorrect);
            int expected = correct * 10 - incorrect * 5;
            Assert.assertEquals(expected, actualResult);

        } catch (GameScoreException e) {
            fail();
        }
    }

    @Test
    public void givenCorrectIncorrectBonusScoreWhenPositiveThenGiveResult() {
        try {
            int correct = 4;
            int incorrect = 8;
            int actualResult = bonusScore.calculateScore(correct,incorrect);
            int expected = correct * 10 - incorrect * 5;
            Assert.assertEquals(expected, actualResult);

        } catch (GameScoreException e) {
            fail();
        }
    }

    // powerBonusScore
    @Test
    public void givenANumberPowerBonusScoreWhenNegativeThenThrowError() {
        try {
            bonusScore.calculateScore(-50,-80);
            fail("calculateScore cannot accept negative values for correctCount or incorrectCount");
        } catch (GameScoreException e) {
            Assert.assertTrue(true);
        }
    }

    public void givenCorrectPowerBonusScoreWhenIs0ThenResult0() {
        try {
            int correct = 0;
            int incorrect = 0;
            int actualResult = bonusScore.calculateScore(correct,incorrect);
            int expected = (5^correct) - incorrect * 8;
            Assert.assertEquals(expected, actualResult);

        } catch (GameScoreException e) {
            fail();
        }
    }

    public void givenCorrectPowerBonusScoreWhenIs4ThenResult500() {
        try {
            int correct = 4;
            int incorrect = 0;
            int actualResult = bonusScore.calculateScore(correct,incorrect);
            int expected = (5^correct) - incorrect * 8;
            Assert.assertEquals(expected, actualResult);

        } catch (GameScoreException e) {
            fail();
        }
    }

    public void givenIncorrectPowerBonusScoreWhenIs4ThenResult0() {
        try {
            int correct = 0;
            int incorrect = 4;
            int actualResult = bonusScore.calculateScore(correct,incorrect);
            int expected = (5^correct) - incorrect * 8;
            Assert.assertEquals(expected, actualResult);

        } catch (GameScoreException e) {
            fail();
        }
    }


}
