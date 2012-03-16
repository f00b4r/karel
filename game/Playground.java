package game;

import java.util.ArrayList;
import node.Karel;
import node.Node;
import node.Target;

/**
 *
 * @author Felix
 */
public class Playground {

    private Node[][] playground;
    private Karel karel;
    private Target target;
    private static String playHistory;
    private int width;
    private int height;

    public Playground(int size) {
        width = height = size;
        playground = new Node[size][size];
    }

    public Playground(int width, int height) {
        this.width = width;
        this.height = height;
        playground = new Node[height][width];
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setNode(Node n) {
        if (n.getPosition().getY() >= height || n.getPosition().getY() < 0
                || n.getPosition().getX() >= width || n.getPosition().getX() < 0) {
            throw new ArrayIndexOutOfBoundsException("Presahujici pozice");
        }

        n.setParent(this);
        playground[n.getPosition().getY()][n.getPosition().getX()] = n;
    }

    public void setNode(ArrayList<Node> nodes) {
        for (Node n : nodes) {
            setNode(n);
        }
    }

    public Node getNode(int x, int y) {
        if (y >= height || y < 0 || x >= width || x < 0) {
            throw new ArrayIndexOutOfBoundsException("Presahujici pozice");
        }

        return playground[y][x];
    }

    public Karel getKarel() {
        return karel;
    }

    public void setKarel(Karel karel) {
        karel.setParent(this);
        this.karel = karel;
    }

    public Target getTarget() {
        return target;
    }

    public void setTarget(Target target) {
        target.setParent(this);
        this.target = target;
    }

    public String getPlayHistory() {
        return Playground.playHistory;
    }

    public boolean isSamePosition(Node n1, Node n2) {
        return (n1.getPosition().getX() == n2.getPosition().getX()
                && n1.getPosition().getY() == n2.getPosition().getY());
    }

    public boolean isFreePosition(int x, int y) {
        if (y >= height || y < 0 || x >= width || x < 0) {
            return false;
        }
        return (playground[y][x] == null);
    }

    public boolean isFreePosition(Node n) {
        return isFreePosition(n.getPosition().getX(), n.getPosition().getY());
    }

    public void changePosition(int x, int y, Node n) {
        playground[y][x] = n;
    }

    public void print() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (playground[i][j] != null) {
                    System.out.print(playground[i][j].getCode() + " ");
                } else if (getKarel().getPosition().getX() == j
                        && getKarel().getPosition().getY() == i) {
                    System.out.print(getKarel().getCode() + " ");
                } else if (getTarget().getPosition().getX() == j
                        && getTarget().getPosition().getY() == i) {
                    System.out.print(getTarget().getCode() + " ");
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
        System.out.println("-----------------------------");
    }

    public static void log(String name, String msg) {
        playHistory = name + ": " + msg;
        System.out.println(name + ": " + msg);
    }
}
