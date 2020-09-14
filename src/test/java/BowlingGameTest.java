import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BowlingGameTest {
    @Test
    void input_to_short() {
        //Given
        BowlingGame bowlingGame = new BowlingGame();
        int[] downSituation = {10, 10, 10, 10, 10, 10, 10, 10, 10, 10};
        //When
        //Then
        assertThrows(Exception.class, () -> bowlingGame.getScore(downSituation));
    }

    @Test
    void input_has_more_than_10() {
        //Given
        BowlingGame bowlingGame = new BowlingGame();
        int[] downSituation = {10, 10, 10, 20, 10, 10, 10, 10, 10, 10};
        //When
        //Then
        assertThrows(Exception.class, () -> bowlingGame.getScore(downSituation));
    }

    @Test
    void input_has_less_than_0() {
        //Given
        BowlingGame bowlingGame = new BowlingGame();
        int[] downSituation = {10, 10, -1, 20, 10, 10, 10, 10, 10, 10};
        //When
        //Then
        assertThrows(Exception.class, () -> bowlingGame.getScore(downSituation));
    }

    @Test
    void all_frame_all_down() throws Exception {
        //Given
        BowlingGame bowlingGame = new BowlingGame();
        int[] downSituation = {10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10};
        //When
        int score = bowlingGame.getScore(downSituation);
        //Then
        assertEquals(300, score);
    }

    @Test
    void all_frame_9_all_down_but_10_spare() throws Exception {
        //Given
        BowlingGame bowlingGame = new BowlingGame();
        int[] downSituation = {10, 10, 10, 10, 10, 10, 10, 10, 10, 4, 6, 2};
        //When
        int score = bowlingGame.getScore(downSituation);
        //Then
        assertEquals(266, score);
    }

    @Test
    void all_frame_9_all_down_and_10_not_spare() throws Exception {
        //Given
        BowlingGame bowlingGame = new BowlingGame();
        int[] downSituation = {10, 10, 10, 10, 10, 10, 10, 10, 10, 4, 3};
        //When
        int score = bowlingGame.getScore(downSituation);
        //Then
        assertEquals(258, score);
    }

    @Test
    void has_some_round_not_all_down_but_spare() throws Exception {
        //Given
        BowlingGame bowlingGame = new BowlingGame();
        int[] downSituation = {3, 7, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10};
        //When
        int score = bowlingGame.getScore(downSituation);
        //Then
        assertEquals(290, score);
    }

    @Test
    void has_some_round_not_all_down_but_not_spare() throws Exception {
        //Given
        BowlingGame bowlingGame = new BowlingGame();
        int[] downSituation = {3, 2, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10};
        //When
        int score = bowlingGame.getScore(downSituation);
        //Then
        assertEquals(275, score);
    }

}
