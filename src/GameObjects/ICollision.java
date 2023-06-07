package GameObjects;

import Gameplay.CollisionEffect;

public interface ICollision {
    public abstract void checkCollision(PlayerCar player, CollisionEffect fx);
}
