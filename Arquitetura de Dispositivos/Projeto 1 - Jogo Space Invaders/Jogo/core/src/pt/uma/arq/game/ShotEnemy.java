package pt.uma.arq.game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import pt.uma.arq.entities.laser.LaserHandler;
import pt.uma.arq.entities.ship.Fleet;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class ShotEnemy extends Timer {

    private LaserHandler laserHandler;
    private SpriteBatch batch;

    public ShotEnemy(final LaserHandler laserHandler, final SpriteBatch batch) {
        this.laserHandler = laserHandler;
        this.batch = batch;
    }

    @Override
    public void scheduleAtFixedRate(TimerTask task, Date firstTime, long period) {
        super.scheduleAtFixedRate(task, firstTime, period);
    }

    public void ShootEnemy(final Fleet fleet) {
        laserHandler.randomShot(fleet.enemyRandomShip(), batch);
    }
}