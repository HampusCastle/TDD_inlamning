package se.reky.hakan.util;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import se.reky.hakan.Game;
import se.reky.hakan.GameException;

import static org.junit.jupiter.api.Assertions.*;

class GameUtilTest {

    GameUtil gameUtil;

    @BeforeEach
    void setUp() {
        gameUtil = new GameUtil();
    }

    @Test
    @DisplayName("Testing when the game throws an exception")
    void toLowerCaseButFirstLetterCapitalized() {
        assertThrows(GameException.class, () -> gameUtil.toLowerCaseButFirstLetterCapitalized(null));
    }
}