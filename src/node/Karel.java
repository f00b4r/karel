package node;

import game.Playground;
import javax.swing.ImageIcon;

/**
 *
 * @author Felix
 */
public class Karel extends Node implements Movable {

    private int direction;
    private final ImageIcon ICON_UP = new ImageIcon(getClass().getResource("/icons/karelUP.png"));
    private final ImageIcon ICON_DOWN = new ImageIcon(getClass().getResource("/icons/karelDOWN.png"));
    private final ImageIcon ICON_LEFT = new ImageIcon(getClass().getResource("/icons/karelLEFT.png"));
    private final ImageIcon ICON_RIGHT = new ImageIcon(getClass().getResource("/icons/karelRIGHT.png"));

    public Karel(int x, int y) {
        super(x, y);
        setCode("K");
        setDirection(Movable.DIRECTION_UP);
        setIcon(ICON_UP);
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    @Override
    public void go() {
        Position newPos = null;
        switch (direction) {
            case Movable.DIRECTION_UP:
                newPos = new Position(getPosition().getX(), getPosition().getY() - 1);
                break;
            case Movable.DIRECTION_LEFT:
                newPos = new Position(getPosition().getX() - 1, getPosition().getY());
                break;
            case Movable.DIRECTION_RIGHT:
                newPos = new Position(getPosition().getX() + 1, getPosition().getY());
                break;
            case Movable.DIRECTION_DOWN:
                newPos = new Position(getPosition().getX(), getPosition().getY() + 1);
                break;
        }


        if (getParent().isFreePosition(newPos.getX(), newPos.getY())) {
            Playground.log("Karel", "jdu na " + newPos);
            setPosition(newPos);
        } else {
            Playground.log("System", "pozice " + newPos + " je obsazena");
        }
    }

    @Override
    public void turnLeft() {
        Playground.log("Karel", "otacim se doleva");
        switch (direction) {
            case Movable.DIRECTION_UP:
                setDirection(DIRECTION_LEFT);
                break;
            case Movable.DIRECTION_LEFT:
                setDirection(DIRECTION_DOWN);
                break;
            case Movable.DIRECTION_RIGHT:
                setDirection(DIRECTION_UP);
                break;
            case Movable.DIRECTION_DOWN:
                setDirection(DIRECTION_RIGHT);
                break;
        }
    }

    @Override
    public void turnRight() {
        Playground.log("Karel", "otacim se doprava");
        switch (direction) {
            case Movable.DIRECTION_UP:
                setDirection(DIRECTION_RIGHT);
                break;
            case Movable.DIRECTION_LEFT:
                setDirection(DIRECTION_UP);
                break;
            case Movable.DIRECTION_RIGHT:
                setDirection(DIRECTION_DOWN);
                break;
            case Movable.DIRECTION_DOWN:
                setDirection(DIRECTION_LEFT);
                break;
        }
    }

    @Override
    public boolean inTarget() {
        return getParent().isSamePosition(this, getParent().getTarget());
    }

    @Override
    public ImageIcon getIcon() {
        switch (direction) {
            case Movable.DIRECTION_LEFT:
                return ICON_LEFT;
            case Movable.DIRECTION_RIGHT:
                return ICON_RIGHT;
            case Movable.DIRECTION_DOWN:
                return ICON_DOWN;
            default:
                return ICON_UP;
        }
    }
}
