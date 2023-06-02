public interface ICollision {
    // masing-masing obstacle memiliki perilaku cek collision yang berbeda
    public abstract void checkCollision(Player p, CollisionEffect fx);
}
