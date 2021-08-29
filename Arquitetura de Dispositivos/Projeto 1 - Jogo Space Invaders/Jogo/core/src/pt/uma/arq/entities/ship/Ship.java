package pt.uma.arq.entities.ship;

import pt.uma.arq.game.Animator;

import java.awt.*;

public abstract class Ship {
    protected int x, y;
    protected int powerAttack;
    protected Animator animator;
    protected Animator explosionAnimator;
    protected Rectangle boundingBox;
    protected boolean collided;
    protected int tick;

    public Ship() {
        animator = new Animator(null, null, 0, 0);
        explosionAnimator = new Animator(null, "explosion.png", 5, 1);
        x = 0;
        y = 0;
        powerAttack = 0;
        boundingBox = new Rectangle();
        collided = false;
        tick = 0;
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

    public int getPowerAttack() {
        return powerAttack;
    }
}
