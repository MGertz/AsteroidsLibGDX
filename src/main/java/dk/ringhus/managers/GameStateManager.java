package dk.ringhus.managers;

import dk.ringhus.gamestates.GameState;
import dk.ringhus.gamestates.PlayState;

public class GameStateManager {

    // current gamestate
    private GameState gameState;

    public static final int MENU = 0;
    public static final int PLAY = 1;

    public GameStateManager() {
        this.setState(PLAY);
    }

    public void setState(int state) {
        if( this.gameState != null ) {
            this.gameState.dispose();
        }

        if( state == MENU ) {
            // this.gameState = new MenuState(this);
        }
        if( state == PLAY ) {
            this.gameState = new PlayState(this);
        }
    }

    public void update( float dt ) {
        gameState.update(dt);
    }

    public void draw() {
        gameState.draw();
    }
}
