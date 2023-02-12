package dk.ringhus.gamestates;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import dk.ringhus.entities.Player;
import dk.ringhus.managers.GameStateManager;

public class PlayState extends GameState{

    private ShapeRenderer sr;

    private Player player;

    public PlayState(GameStateManager gsm) {
        super(gsm);
    }

    @Override
    public void init() {
        this.sr = new ShapeRenderer();
        this.player = new Player();
    }

    @Override
    public void update(float dt) {

        this.handleInput();

        this.player.update(dt);
    }

    @Override
    public void draw() {
        this.player.draw(sr);
    }

    @Override
    public void handleInput() {
        player.setLeft(Gdx.input.isKeyPressed(Input.Keys.LEFT));
        player.setRight(Gdx.input.isKeyPressed(Input.Keys.RIGHT));
        player.setUp(Gdx.input.isKeyPressed(Input.Keys.UP));
    }

    @Override
    public void dispose() {

    }
}
