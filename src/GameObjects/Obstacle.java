package GameObjects;

import Gameplay.CollisionEffect;

public abstract class Obstacle extends MovingObject {
    private int damage;

    public int getDamage() {
        return damage;
    }
    public void setDamage(int damage) {
        if (damage > 0) {
            this.damage = damage;
        }
    }
    @Override
    public void checkCollision(PlayerCar player, CollisionEffect fx) {
        if (!player.isCollided && player.getBounds().intersects(getBounds())) {
            player.decreaseHealth(getDamage());
            fx.displayDamageScreen();
        }
    }
}
