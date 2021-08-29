package pt.uma.arq.entities.ship;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import pt.uma.arq.entities.laser.Laser;
import pt.uma.arq.entities.laser.LaserHandler;
import pt.uma.arq.game.Animator;

import java.awt.*;
import java.util.ArrayList;

public class PlayerShip extends Ship {
    private int life;

    public PlayerShip(SpriteBatch batch) {
        x = 300;
        y = 30;
        life = 100;
        powerAttack = 0;
        animator = new Animator(batch, "ship.png", 5, 2);
    }

    public int getLife() {
        if (life <= 0)
            return 0;

        return life;
    }

    public void handlerInput() {
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT) || Gdx.input.isKeyPressed(Input.Keys.A)) {
            if (x < 20)
                return;
            x -= 5;
        } else if (Gdx.input.isKeyPressed(Input.Keys.RIGHT) || Gdx.input.isKeyPressed(Input.Keys.D)) {
            if (x > 560)
                return;
            x += 5;
        }
    }

    public void checkEnemyLasers(LaserHandler laserEnemiesHandler) {
        boundingBox = new Rectangle(this.getX() - 10, this.getY(), 24, 20);
        ArrayList<Laser> EnemyLaser = laserEnemiesHandler.getEnemyLasers();
        for (Laser laser : EnemyLaser) {
            if (boundingBox.contains(laser.getX(), laser.getY())) {
                if (life > 0) {
                    life -= laser.getPowerAttack();
                    laserEnemiesHandler.removeEnemyLaser(laser);
                    break;
                }
                break;
            }

        }
    }

}
