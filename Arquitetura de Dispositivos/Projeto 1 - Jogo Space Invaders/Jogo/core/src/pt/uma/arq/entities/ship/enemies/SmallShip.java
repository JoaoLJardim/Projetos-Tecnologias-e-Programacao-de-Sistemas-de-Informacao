package pt.uma.arq.entities.ship.enemies;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import pt.uma.arq.entities.ship.Ship;
import pt.uma.arq.game.Animator;

import java.awt.*;

public class SmallShip extends Ship {

    public SmallShip(SpriteBatch batch, int x, int y) {
        this.x = x;
        this.y = y;
        boundingBox = new Rectangle(x - 10, y, 24, 24);
        powerAttack = 5;
        animator = new Animator(batch, "enemy-small.png", 2, 1);
        explosionAnimator = new Animator(batch, "explosion.png", 5, 1);
    }
}
