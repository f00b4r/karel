package node;

/**
 *
 * @author Felix
 */
public interface Movable {

    public static final int DIRECTION_UP = 8;
    public static final int DIRECTION_LEFT = 4;
    public static final int DIRECTION_RIGHT = 6;
    public static final int DIRECTION_DOWN = 2;

    public void go();

    public void turnLeft();

    public void turnRight();
    
    public boolean inTarget();
}
