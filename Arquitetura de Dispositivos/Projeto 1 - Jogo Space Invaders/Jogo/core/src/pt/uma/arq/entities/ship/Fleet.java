package pt.uma.arq.entities.ship;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import pt.uma.arq.entities.laser.Laser;
import pt.uma.arq.entities.laser.LaserHandler;
import pt.uma.arq.entities.ship.enemies.LargeShip;
import pt.uma.arq.entities.ship.enemies.MediumShip;
import pt.uma.arq.entities.ship.enemies.SmallShip;

import java.util.ArrayList;
import java.util.Random;

public class Fleet {

    private SpriteBatch batch;
    private final ArrayList<Ship> fleet;
    private final ArrayList<Ship> explosionSmallShip;
    private final ArrayList<Ship> explosionMediumShip;
    private final ArrayList<Ship> explosionLargeShip;

    public Fleet(SpriteBatch batch) {
        this.batch = batch;
        fleet = new ArrayList<>();
        explosionSmallShip = new ArrayList<>();
        explosionMediumShip = new ArrayList<>();
        explosionLargeShip = new ArrayList<>();
    }

    /***************************************************************/
    //add the large,medium,small ships to the fleet array
    public void addLargeShipsToFleet() {
        int xIterator = 0;
        for (int j = 0; j < 8; j++) {
            this.addShipToFleetArray(new LargeShip(batch, 100 + xIterator, 700));
            xIterator += 45;
        }
    }

    public void addMediumShipsToFleet() {
        int xIterator = 0;
        for (int j = 0; j < 8; j++) {
            this.addShipToFleetArray(new MediumShip(batch, 70 + xIterator, 550));
            xIterator += 55;
        }
    }

    public void addSmallShipsToFleet() {
        int xIterator = 0;
        for (int j = 0; j < 8; j++) {
            this.addShipToFleetArray(new SmallShip(batch, 150 + xIterator, 400));
            xIterator += 35;
        }
    }
    /***************************************************************/

    /***************************************************************/
    //add ships to the array as general objects Ship
    public void addShipToFleetArray(Ship ship) {
        ship.create();
        fleet.add(ship);
    }
    /***************************************************************/

    /***************************************************************/
    // render the explosions for all the ship types
    public void addExplosionSmallShip(Ship ship) {
        ship.create();
        explosionSmallShip.add(ship);
    }

    public void addExplosionMediumShip(Ship ship) {
        ship.create();
        explosionMediumShip.add(ship);
    }

    public void addExplosionLargeShip(Ship ship) {
        ship.create();
        explosionLargeShip.add(ship);
    }
    /***************************************************************/

    /***************************************************************/
    //render normal ship animations
    public void render() {
        for (Ship ship : fleet) {

            ship.render();
        }
    }
    /***************************************************************/

    /*************************************************************************************************
     * does the rendering for the arrays of the small ships medium ships and large ships
     * this was done this way because with only one array there would be a delay between the animations
     * the tick system engineered by Carlao Vasconcelos was made to make the explosions from the ships
     * smoother with this system the queue for the animations are split into 3 making each Game tick do 3
     * animations instead of one with almost noone delay still has some delay specially if the player destroy
     * 3 of a kind ship its the best we can achieve for now
     */
    public void renderExplosionSmallShip() {
        for (Ship ship : explosionSmallShip) {
            if (ship.tick < 20) {
                ship.explosionAnimator.render(ship.getX(), ship.getY());
                ship.tick++;

            } else {   /*************************************/
                /**break is needed so we  after we remove we dont iterate the for again otherwise its gona
                 * try render an animation from a ship that doesnt exist anymore
                 */
                explosionSmallShip.remove(ship);
                break;

            }
        }
    }

    public void renderExplosionMediumShip() {
        for (Ship ship : explosionMediumShip) {
            if (ship.tick < 20) {
                ship.explosionAnimator.render(ship.getX(), ship.getY());
                ship.tick++;
                break;
            } else {
                /*************************************/
                /**break is needed so we  after we remove we dont iterate the for again otherwise its gona
                 * try render an animation from a ship that doesnt exist anymore
                 */
                explosionMediumShip.remove(ship);
                break;

            }
        }
    }

    public void renderExplosionLargeShip() {
        for (Ship ship : explosionLargeShip) {
            if (ship.tick < 20) {
                ship.explosionAnimator.render(ship.getX(), ship.getY());
                ship.tick++;
                break;
            } else {
                /*************************************/
                /**break is needed so we  after we remove we dont iterate the for again otherwise its gona
                 * try render an animation from a ship that doesnt exist anymore
                 */
                explosionLargeShip.remove(ship);
                break;

            }
        }
    }

    /***********************************************************************************/

    public Ship checkCollided(LaserHandler lasers) {
        for (Ship ship : fleet) {
            for (Laser laser : lasers.getPlayerLasers()) {
                if (ship.boundingBox.contains(laser.getX(), laser.getY())) {
                    ship.collided = true;
                    lasers.removePlayerLaser(laser);
                    return ship;
                }
            }
        }
        return null;
    }

    public void explode() {
        for (Ship ship : fleet) {
            if (ship.collided) {
                ship.explosionAnimator.create();
                switch (ship.powerAttack) {
                    case (5): {
                        addExplosionSmallShip(ship);
                        fleet.remove(ship);
                        break;
                    }
                    case (10): {
                        addExplosionMediumShip(ship);
                        fleet.remove(ship);
                        break;
                    }
                    case (15): {
                        addExplosionLargeShip(ship);
                        fleet.remove(ship);
                        break;
                    }

                }
                break;
            }
        }
    }

    public Ship enemyRandomShip() {
        Random number = new Random();
        int randomShip = number.nextInt(fleet.size());
        return fleet.get(randomShip);
    }

    public ArrayList<Ship> getFleet() {
        return fleet;
    }

}
