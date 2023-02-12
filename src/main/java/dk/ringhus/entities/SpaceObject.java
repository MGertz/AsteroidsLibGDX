package dk.ringhus.entities;

import dk.ringhus.main.Game;

public class SpaceObject {

    // Position
    protected float x;
    protected float y;

    // Vectror Direction traveling
    protected float dx;
    protected float dy;

    // Direction in Radians
    protected float radians;

    // Speed
    protected float speed;

    protected float rotationSpeed;

    protected int width;
    protected int height;

    protected float[] shapeX;
    protected float[] shapeY;

    protected void wrap() {
        if(this.x < 0) x = Game.WIDTH;
        if(this.x > Game.WIDTH) x = 0;
        if(this.y < 0) y = Game.HEIGHT;
        if(this.y > Game.HEIGHT) y = 0;
    }


}
