package dk.ringhus.main;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.OrthographicCamera;
import dk.ringhus.managers.GameKeys;
import dk.ringhus.managers.GameStateManager;
import org.lwjgl.opengl.GL20;

public class Game implements ApplicationListener {

    private int width;
    private int height;

    private OrthographicCamera cam;
    private GameStateManager gsm;

    /*
     * Method is called once when the game is launched.
     */
    @Override
    public void create() {
        this.cam = new OrthographicCamera(this.width, this.height);
        this.cam.translate(this.width/2, this.height/2);
        this.cam.update();

        this.gsm = new GameStateManager();
    }

    /*
     * A method called constantly, this is where the game logic should be loaded from.
     */
    @Override
    public void render() {

        // clear screen to black
        Gdx.gl.glClearColor(0,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        this.gsm.update(Gdx.graphics.getDeltaTime());
        this.gsm.draw();
        // Own implementation of keys.
        // This could most likely be replaced by LibGDX own implementation.
        // Just use Gdx.input.isKeyJustPressed()
        GameKeys.update();
    }

    /*
     * Gets called when the window is resized
     */
    @Override
    public void resize(int width, int height) {
        System.out.println("width: " + width + " - height: " + height);
        this.width = width;
        this.height = height;
    }

    /*
     * Used for android phones, used when an incomming call is active, then the game pauses.
     */
    @Override
    public void pause() {

    }

    /*
     * Used for android phones, used when an incomming call is ended, then the game unpauses.
     */
    @Override
    public void resume() {

    }

    /*
     * Called when the game is closed. Only called once.
     */
    @Override
    public void dispose() {

    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }
}
