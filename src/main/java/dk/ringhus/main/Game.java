package dk.ringhus.main;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.OrthographicCamera;
import org.lwjgl.opengl.GL20;

public class Game implements ApplicationListener {

    private int width;
    private int height;

    private OrthographicCamera cam;

    /*
     * Method is called once when the game is launched.
     */
    @Override
    public void create() {
        this.cam = new OrthographicCamera(this.width, this.height);
        this.cam.translate(this.width/2, this.height/2);
        this.cam.update();
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
     * A method called constantly, this is where the game logic should be loaded from.
     */
    @Override
    public void render() {

        // clear screen to black
        Gdx.gl.glClearColor(0,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
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
