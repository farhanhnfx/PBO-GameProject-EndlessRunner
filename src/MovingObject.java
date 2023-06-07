public abstract class MovingObject extends ColliderObject {
    protected int randomIdx;
    protected int initPosY;
    
    public abstract void checkCollision(PlayerCar player, CollisionEffect fx);
}
