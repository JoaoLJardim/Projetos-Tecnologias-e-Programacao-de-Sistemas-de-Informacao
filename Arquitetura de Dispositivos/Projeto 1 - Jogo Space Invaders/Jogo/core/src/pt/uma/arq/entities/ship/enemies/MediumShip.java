package pt.uma.arq.entities.ship.enemies;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import pt.uma.arq.entities.ship.Ship;
import pt.uma.arq.game.Animator;

import java.awt.*;

public class MediumShip extends Ship {

    public MediumShip(SpriteBatch batch, int x, int y) {
        this.x = x;
        this.y = y;

        boundingBox = new Rectangle(x - 10, y, 49, 24);
        powerAttack = 10;
        animator = new Animator(batch, "enemy-medium.png", 2, 1);
        explosionAnimator = new Animator(batch, "explosion.png", 5, 1);
    }
}
