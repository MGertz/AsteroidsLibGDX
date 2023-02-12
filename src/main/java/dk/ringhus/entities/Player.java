package dk.ringhus.entities;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.MathUtils;
import dk.ringhus.main.Game;

public class Player extends SpaceObject {

    private boolean left;
    private boolean right;
    private boolean up;
    private boolean space;

    private float maxSpeed;
    private float acceleration;
    private float deceleration;

    public Player() {

        this.x = Game.WIDTH / 2;
        this.y = Game.HEIGHT / 2;


        this.maxSpeed = 300;
        this.acceleration = 200;
        this.deceleration = 10;

        this.shapeX = new float[4];
        this.shapeY = new float[4];

        // Rotate player to point correctly when game starts.
        this.radians = MathUtils.PI / 2;
        this.rotationSpeed = 3;
        this.speed = 300;

    }

    private void setShare() {
        this.shapeX[0] = this.x + MathUtils.cos(this.radians) * 8;
        this.shapeY[0] = this.y + MathUtils.sin(this.radians) * 8;

        this.shapeX[1] = this.x + MathUtils.cos(this.radians - 4 * MathUtils.PI / 5) * 8;
        this.shapeY[1] = this.y + MathUtils.sin(this.radians - 4 * MathUtils.PI / 5) * 8;

        this.shapeX[2] = this.x + MathUtils.cos(this.radians + MathUtils.PI) * 5;
        this.shapeY[2] = this.y + MathUtils.sin(this.radians + MathUtils.PI) * 5;

        this.shapeX[3] = this.x + MathUtils.cos(this.radians + 4 * MathUtils.PI / 5) * 8;
        this.shapeY[3] = this.y + MathUtils.sin(this.radians + 4 * MathUtils.PI / 5) * 8;
    }

    public void setLeft(boolean b) {
        this.left = b;
    }

    public void setRight(boolean b) {
        this.right = b;
    }

    public void setUp(boolean b) {
        this.up = b;
    }

    public void update(float dt) {
        if( left ) {
            this.radians += this.rotationSpeed * dt;
        }
        if( right ) {
            this.radians -= this.rotationSpeed * dt;
        }

        if( up ) {
            this.dx += MathUtils.cos(this.radians) * this.acceleration * dt;
            this.dy += MathUtils.sin(this.radians) * this.acceleration * dt;

        }

        float vec = (float) Math.sqrt(this.dx  * this.dx + this.dy * this.dy);
        if( vec > 0 ) {
            this.dx -= (this.dx / vec) * this.deceleration * dt;
            this.dy -= (this.dy / vec) * this.deceleration * dt;
        }
        if( vec > this.maxSpeed ) {
            this.dx = (this.dx / vec) * this.maxSpeed;
            this.dy = (this.dy / vec) * this.maxSpeed;
        }

        // set position
        this.x += this.dx * dt;
        this.y += this.dy * dt;

        // setShape
        setShare();

        // screen wrap
        wrap();
    }

    public void draw(ShapeRenderer sr) {
        sr.setColor(1,1,1,1);
        sr.begin(ShapeRenderer.ShapeType.Line);

        // draw player
        for (int i = 0, j = this.shapeX.length - 1; i < this.shapeX.length; j = i++) {
            sr.line(this.shapeX[i], this.shapeY[i], this.shapeX[j], this.shapeY[j]);
        }

        sr.end();
    }

}
