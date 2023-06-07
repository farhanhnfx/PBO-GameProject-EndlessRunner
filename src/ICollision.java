public interface ICollision {
    // masing-masing obstacle memiliki perilaku cek collision yang berbeda
    public abstract void checkCollision(PlayerCar p, CollisionEffect fx);
}
