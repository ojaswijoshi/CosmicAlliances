import com.tmsimple.cosmicalliances.PlayerSpaceship;

public interface Collidable {
    boolean intersects(PlayerSpaceship spaceship);
    float getX();
    float getY();
}
