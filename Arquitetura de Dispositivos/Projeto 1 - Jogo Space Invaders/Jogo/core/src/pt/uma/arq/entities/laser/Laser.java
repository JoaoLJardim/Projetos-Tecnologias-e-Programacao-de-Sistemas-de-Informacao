package pt.uma.arq.entities.laser;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import pt.uma.arq.game.Animator;

public class Laser {
    private int x, y;
    private Animator animator;
    private int powerAttack;

    public Laser(SpriteBatch batch, int x, int y, int powerAttack, boolean inverted) {
        this.powerAttack = powerAttack;
        this.x = x;
        this.y = y;
        if (inverted == false)
            animator = new Animator(batch, "laser-bolts.png", 2, 2);
        else
            animator = new Animator(batch, "laser-bolts-inverted.png", 2, 2);
    }

    public void create() {
        animator.create();
    }

    public void render() {
        animator.render(x, y);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getPowerAttack() {
        return this.powerAttack;
    }
}
