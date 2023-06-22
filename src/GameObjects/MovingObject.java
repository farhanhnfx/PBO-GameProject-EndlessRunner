package GameObjects;

public abstract class MovingObject extends ColliderObject implements IMovementY, ICollision {
    protected int randomIdx;
    protected int initPosY;
    
    public abstract int getRandomX();
}
