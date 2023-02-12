package dk.ringhus.gamestates;

import dk.ringhus.managers.GameStateManager;

public abstract class GameState {

    protected GameStateManager gsm;

    protected GameState(GameStateManager gsm) {
        this.gsm = gsm;
        init();
    }

    // Called when the game starts
    public abstract void init();

    // Update is loaded everytime the game loops, it will be responsible for updating every items position and state.
    public abstract void update(float dt);

    // draw, is loaded everytime the game loops, its responsible for drawing the game into the screen
    public abstract void draw();

    // Handled userInput
    public abstract void handleInput();

    // used when switching to another gameState, and current gameState should be trashed.
    public abstract void dispose();

}
