package model;

import controller.GameController;
import model.CountryDom.InitCountriesData;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class GameHandlerTest {

    private GameController gc;
    private GameHandler gh;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        gc = new GameController();
        InitCountriesData.InitCountriesData();
        gh = new GameHandler(gc, false);

    }

    @Test
    void correcTest() throws IOException {
        int correctIndex = gh.getActualQuestion().getIdx();

        int score = gh.getCurrentScore();
        int spree = gh.getSpree();
        int life = gh.getLifes();
        gh.isCorrect(correctIndex);
        assertEquals(spree + 1,gh.getSpree());
        assertEquals(life, gh.getLifes());
        assertNotEquals(score, gh.getCurrentScore());
        assertNotEquals(0, gh.getCurrentScore());
    }

    @Test
    void notCorrecTest() throws IOException {
        int correctIndex = gh.getActualQuestion().getIdx();

        int score = gh.getCurrentScore();
        int spree = gh.getSpree();
        int life = gh.getLifes();
        gh.isCorrect(3-correctIndex);
        assertEquals(0,gh.getSpree());
        assertEquals(life-1, gh.getLifes());
        assertEquals(score, gh.getCurrentScore());
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
        gc =null;
        gh=null;
    }
}