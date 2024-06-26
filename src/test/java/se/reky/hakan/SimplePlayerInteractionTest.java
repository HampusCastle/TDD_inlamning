package se.reky.hakan;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import se.reky.hakan.model.Player;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class SimplePlayerInteractionTest {

    private Player player;
    private PlayerInteraction playerInteraction;

    private PlayerInteraction playerTestSetup(String dataForScanner) {
        Scanner scanner = new Scanner(dataForScanner);
        player = new Player();
        IOHandler ioHandler = new IOHandler(scanner);

        return new SimplePlayerInteraction(ioHandler);
    }

    @Test
    @DisplayName("testa instansiering av spelare")
    void testSetupPlayer() {
        playerInteraction = playerTestSetup("Ragnar Lothbrok");
        playerInteraction.setupPlayer(player);
        assertEquals("Ragnar Lothbrok", player.getName());
    }

    @Test
    @DisplayName("Testar så att hp stämmer")
    void testUpdatePlayerHealth() {
        playerInteraction = playerTestSetup("Loki");
        playerInteraction.updatePlayerHealth(player, 10);
        assertEquals(10, player.getHp());
    }
}