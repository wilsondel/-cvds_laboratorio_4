package hangman;

import hangman.model.BonusScore;
import hangman.model.OriginalScore;
import hangman.model.PowerScore;
import hangman.model.exceptions.GameScoreException;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.fail;


/**
 * Equivalence class
 *
 *  Para calculateScore sus clases de equivalencia serian:
 * correctCount > 0 and incorrectCount > 0  (Valid)
 * correctCount < 0 and incorrectCount > 0  (Invalid)
 * correctCount > 0 and incorrectCount < 0  (Invalid)
 * correctCount < 0 and incorrectCount < 0  (Invalid)
 * correctCount <  incorrectCount  (Valid)
 * correctCount >  incorrectCount  (Valid)
 * correctCount = 0 and incorrectCount = 0  (Limit)
 *
 */
public class GameScoreTest {

    OriginalScore originalScore = new OriginalScore();
    BonusScore bonusScore = new BonusScore();
    PowerScore powerScore = new PowerScore();




    // originalScore (Second case)
    @Test
    public void givenANumberOriginalScoreWhenNegativeThenThrowError() {
        try {
            originalScore.calculateScore(-50,0);
            fail("calculateScore cannot accept negative values for correctCount");
        } catch (GameScoreException e) {
            Assert.assertTrue(true);
        }
    }

    // originalScore (Limit case)
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

    // originalScore (First case)
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

    // originalScore (Third case)
    @Test
    public void givenCorrectOriginalScoreWhenPositiveThenGiveResult() {
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

    // bonusScore (First case)
    @Test
    public void givenANumberBonusScoreWhenNegativeThenThrowError() {
        try {
            bonusScore.calculateScore(50,-80);
            fail("calculateScore cannot accept negative values for correctCount or incorrectCount");
        } catch (GameScoreException e) {
            Assert.assertTrue(true);
        }
    }

    // bonusScore (Fifth case)
    @Test
    public void givenIncorrectBonusScoreWhenIs8ThenResult0() {
        try {
            int correct = 0;
            int incorrect = 8;
            int actualResult = bonusScore.calculateScore(correct,incorrect);
            int expected = 0;
            Assert.assertEquals(expected, actualResult);

        } catch (GameScoreException e) {
            fail();
        }
    }

    // bonusScore (Limit case)
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


    // powerScore (First case)
    @Test
    public void givenANumberPowerScoreWhenNegativeThenThrowError() {
        try {
            powerScore.calculateScore(-50,-80);
            fail("calculateScore cannot accept negative values for correctCount or incorrectCount");
        } catch (GameScoreException e) {
            Assert.assertTrue(true);
        }
    }

    // powerScore (Limit case)
    @Test
    public void givenCorrectPowerScoreWhenIs0ThenResult0() {
        try {
            int correct = 0;
            int incorrect = 0;
            int actualResult = powerScore.calculateScore(correct,incorrect);
            int expected = 0;
            Assert.assertEquals(expected, actualResult);

        } catch (GameScoreException e) {
            fail();
        }
    }

    // powerScore (Sixth case)
    @Test
    public void givenCorrectPowerScoreWhenIs4ThenResult500() {
        try {
            int correct = 4;
            int incorrect = 0;
            int actualResult = powerScore.calculateScore(correct,incorrect);
            int expected = 500;
            Assert.assertEquals(expected, actualResult);

        } catch (GameScoreException e) {
            fail();
        }
    }

    // powerScore (Fifth case)
    @Test
    public void givenIncorrectPowerScoreWhenIs4ThenResult0() {
        try {
            int correct = 0;
            int incorrect = 4;
            int actualResult = powerScore.calculateScore(correct,incorrect);
            int expected = 0;
            Assert.assertEquals(expected, actualResult);

        } catch (GameScoreException e) {
            fail();
        }
    }


}
