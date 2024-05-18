package se.reky.hakan;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class IOHandlerTest {

    private IOHandler ioHandler;

    private IOHandler testHandler (String scannerData) {
        Scanner scanner = new Scanner(scannerData);
        return new IOHandler(scanner);
    }

    @Test
    @DisplayName("Maquina scanner test")
    void testScannerData() {
        ioHandler = testHandler("Test");
        assertEquals("Test", ioHandler.nextLine());
    }
    @Test
    @DisplayName("Testa att konvertera en sträng")
    void testIOHandler() {
        ioHandler = testHandler("1");
        assertTrue(ioHandler.hasNextInt());
    }

}