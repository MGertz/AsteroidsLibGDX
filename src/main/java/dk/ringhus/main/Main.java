package dk.ringhus.main;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;

public class Main {
    public static void main(String[] args) {
        Lwjgl3ApplicationConfiguration cfg = new Lwjgl3ApplicationConfiguration();

        cfg.setTitle("Asteroids");
        cfg.setIdleFPS(60);
        cfg.setWindowedMode(800, 450);
        cfg.setResizable(true);

        new Lwjgl3Application(new Game(), cfg);
    }
}