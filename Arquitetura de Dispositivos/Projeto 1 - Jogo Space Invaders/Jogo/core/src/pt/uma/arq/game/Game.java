package pt.uma.arq.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import pt.uma.arq.entities.laser.LaserHandler;
import pt.uma.arq.entities.ship.Fleet;
import pt.uma.arq.entities.ship.PlayerShip;
import pt.uma.arq.entities.ship.Ship;


public class Game extends ApplicationAdapter {
    private SpriteBatch batch;
    private BackgroundManagement backgroundManagement;
    private BitmapFont font;
    private int score;
    private PlayerShip playerShip;
    private Fleet fleet;
    private LaserHandler laserHandler;
    private ShotEnemy shot;
    /************************************************
     * variables of the clocks for the random enemy ship shoot and
     * when player can shoot
     */
    private float enemyShipCurrentTimeToShoot = 0f;
    private float enemyShipTimeInterval = 2f;
    private float playerShipCurrentTimeToShoot = 0f;
    private float playerShipTimeInterval = 0.40f;
    private boolean playerCanShootLaser = false;

    @Override
    public void create() {
        Gdx.graphics.setWindowedMode(600, 800);
        laserHandler = new LaserHandler();
        batch = new SpriteBatch();
        fleet = new Fleet(batch);
        score = 0;
        font = new BitmapFont(Gdx.files.internal("gamefont.fnt"),
                Gdx.files.internal("gamefont.png"), false);

        backgroundManagement = new BackgroundManagement(batch);

        /************************************************************************************/
        // add all ships to the fleet array and create their sprites there for render later
        fleet.addLargeShipsToFleet();
        fleet.addMediumShipsToFleet();
        fleet.addSmallShipsToFleet();
        /************************************************************************************/

        /*********************************/
        //create playerShip
        playerShip = new PlayerShip(batch);
        playerShip.create();
        /*********************************/

        /*********************************/
        // create and prepare the lasers for enemy's
        shot = new ShotEnemy(laserHandler, batch);


    }

    @Override
    public void render() {
        //player movement with left and right keys
        playerShip.handlerInput();

        /************************************************************************
         * timer to controll how frequent the player can shoot this system was implemented right after
         * the tick system engineered by Carlos Vasconcelos was uncessfull in the ammount of animations it could
         * do by each game tick if the player destroyed 3 small ships at near same time so with this delay makes all
         * the animations perfect as they play and the player cant really destroy multiple in a short ammount of time
         * playerShipCurrentTimeToShoot gets added ticks from the getdeltatime graphics function
         * if this number surpass's the float number we assigned to playerShipTimeInterval then player can shoot
         * thru a boolean easy pz the same goes for the enemy ships this timer.
         */
        playerShipCurrentTimeToShoot += Gdx.graphics.getDeltaTime();
        if (playerShipCurrentTimeToShoot > playerShipTimeInterval) {
            playerCanShootLaser = true;
            playerShipCurrentTimeToShoot -= playerShipTimeInterval;
        }
        if (playerCanShootLaser == true) {
            // create player laser with backspace
            // and adds them to laserHandler.lasers array
            playerCanShootLaser = laserHandler.handlerInput(batch, playerShip.getX());

        }
        /************************************************************************

         Gdx.gl.glClearColor(0, 0, 0.2f, 1);
         Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

         /******************************************/
        // Render
        batch.begin();

        backgroundManagement.render();

        // draw score and life
        font.draw(batch, "Score:" + score, 10, 775);
        font.draw(batch, "Life:" + playerShip.getLife(), 490, 775);

        //game over
        if (playerShip.getLife() <= 0) {
            font.draw(batch, "Game Over", 250, 400);
        } else {
            /**********************************************************/
            //if fleet is empty means theres no enemy space ships left
            if (!fleet.getFleet().isEmpty()) {
                /**********************************************/
                // render player ship and enemy ships and move all lasers player/enemy
                playerShip.render();
                fleet.render();
                laserHandler.render();
                laserHandler.moveAll();
                /******************************************/

                /******************************************/
                //returns the ship object that collided if a laser was in his bounding rectangle
                Ship ship = fleet.checkCollided(laserHandler);
                if (ship != null)
                    score += ship.getPowerAttack();
                /******************************************/

                /******************************************/
                // if any ship has collided = true then adds a explosion ship animation to the fleet.explosionShip array for render after
                fleet.explode();
                fleet.renderExplosionSmallShip();
                fleet.renderExplosionMediumShip();
                fleet.renderExplosionLargeShip();
                /******************************************/

                //Execute handleEvent each 1 second
                /**************************************/
                //obter o tempo de render em ms's
                enemyShipCurrentTimeToShoot += Gdx.graphics.getDeltaTime();
                //timer
                if (enemyShipCurrentTimeToShoot > enemyShipTimeInterval) {
                    enemyShipCurrentTimeToShoot -= enemyShipTimeInterval;
                    shot.ShootEnemy(fleet);
                }
                /**************************************/

                playerShip.checkEnemyLasers(laserHandler);
            } else {
                font.draw(batch, "You Win", 250, 400);
            }
            /**********************************************************/
        }

        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
    }

}