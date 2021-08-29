package pt.uma.arq.entities.ship.enemies;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import pt.uma.arq.entities.ship.Ship;
import pt.uma.arq.game.Animator;

import java.awt.*;

public class LargeShip extends Ship {

    public LargeShip(SpriteBatch batch, int x, int y) {
        this.x = x;
        this.y = y;

        boundingBox = new Rectangle(x - 5, y, 41, 48);
        powerAttack = 15;
        animator = new Animator(batch, "enemy-big.png", 2, 1);
        explosionAnimator = new Animator(batch, "explosion.png", 5, 1);
    }
}
