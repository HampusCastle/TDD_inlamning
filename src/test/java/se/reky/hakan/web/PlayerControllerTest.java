package se.reky.hakan.web;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Disabled
class PlayerControllerTest {

    static ChromeDriver driver;

    @BeforeEach
    void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://localhost:8080/players");
    }

    @AfterEach
    public void tearDown() {
        if(driver != null){
            driver.quit();
        }
    }

    @Test
    @DisplayName("kollar så det är korrekt antal spelare i listan")
    public void checkNumberOfPlayers() {
        List<WebElement> playerList = driver.findElements(By.className("player-name"));
        int actualNumberOfPlayers = playerList.size();
        int expectedNumberOfPlayers = 2;
        System.out.println("Antal spelare i listan: " + actualNumberOfPlayers);
        assertEquals(expectedNumberOfPlayers, actualNumberOfPlayers, "Felaktigt antal spelare i listan");
    }

    @Test
    @DisplayName("kollar så det är korrekt antal spelare i listan")
    public void findFirstPlayer() {
        WebElement player = driver.findElement(By.className("player-name"));
        assertTrue(player.isDisplayed());
    }

    @Test
    @DisplayName("Kollar så titel stämmer")
    public void isTitleCorrect() {
        String title = driver.getTitle();
        assertEquals("Players List", title);
    }

    @Test
    @DisplayName("testar knappens text")
    public void buttontext () {
        WebElement button = driver.findElement(By.tagName("button"));
        String buttonText = button.getText();
        String expectedText = "Logga in";
        assertEquals(expectedText, buttonText, "Knappen säger inte 'Logga in'");

    }

}