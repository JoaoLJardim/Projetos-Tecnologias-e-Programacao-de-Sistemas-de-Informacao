package pt.uma.arq.entities.laser;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import pt.uma.arq.entities.ship.Ship;

import java.util.ArrayList;


public class LaserHandler {

    private final ArrayList<Laser> playerLasers;
    private final ArrayList<Laser> enemyLasers;

    public LaserHandler() {
        playerLasers = new ArrayList<>();
        enemyLasers = new ArrayList<>();
    }

    /******************************************/
    //remove lasers after impact with player object or ship object
    public void removePlayerLaser(Laser laser) {
        playerLasers.remove(laser);
    }

    public void removeEnemyLaser(Laser enemyLaser) {
        enemyLasers.remove(enemyLaser);
    }
    /******************************************/

    /****************************************************/
    // if player press's space createa new laser with player coordinates and set power Attack to 0
    //since it doesnt need power attack then create the sprite to be ready for render and add it to the array
    public boolean handlerInput(SpriteBatch batch, int x) {
        /***************************/
        // space to shoot a laser as a player
        if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {
            Laser laser = new Laser(batch, x, 50, 0, false);
            laser.create();
            playerLasers.add(laser);
            return false;
        }
        return true;
        /***************************/
    }
    /****************************************************/

    /******************************************/
    //move all lasers player/enemy
    public void moveAll() {
        /***************************/
        //move player ship laser
        for (Laser laser : playerLasers) {
            if (laser.getY() > 800) {
                removePlayerLaser(laser);
                break;
            }

            laser.setY(laser.getY() + 10);
        }
        /***************************/

        /***************************/
        //move enemy ships laser
        for (Laser enemyLaser : enemyLasers) {
            if (enemyLaser.getY() < -5) {
                removeEnemyLaser(enemyLaser);
                break;
            }

            enemyLaser.setY(enemyLaser.getY() - 5);
        }
        /***************************/
    }
    /******************************************/

    /******************************************/
    //render player lasers and enemy lasers
    public void render() {
        /***************************/
        // render laser and enemy lasers
        for (Laser laser : playerLasers) {
            laser.render();
        }
        for (Laser enemyLaser : enemyLasers) {
            enemyLaser.render();
        }
        /***************************/
    }

    /******************************************/

    public ArrayList<Laser> getPlayerLasers() {
        return playerLasers;
    }

    public ArrayList<Laser> getEnemyLasers() {
        return enemyLasers;
    }

    public void addEnemyLaser(Laser laser) {
        laser.create();
        enemyLasers.add(laser);
    }

    public void randomShot(Ship ship, SpriteBatch batch) {
        addEnemyLaser(new Laser(batch, ship.getX(), ship.getY(), ship.getPowerAttack(), true));
    }
}
