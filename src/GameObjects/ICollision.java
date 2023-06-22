package GameObjects;

import Gameplay.CollisionEffect;

public interface ICollision {
    public void checkCollision(PlayerCar player, CollisionEffect fx);
}
