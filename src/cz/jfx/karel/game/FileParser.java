package cz.jfx.karel.game;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import cz.jfx.karel.entity.Karel;
import cz.jfx.karel.entity.Node;
import cz.jfx.karel.entity.Target;
import cz.jfx.karel.entity.Wall;

/**
 *
 * @author Felix
 */
public class FileParser {

    private static final String TAG_DESK = "PLOCHA";
    private static final String TAG_KAREL = "KAREL";
    private static final String TAG_WALL = "ZED";
    private static final String TAG_TARGET = "CIL";
    private static final String DELIMITER = ";";
    private Scanner scanner;
    /*
     * Playground
     */
    private int width;
    private int height;
    private Karel karel;
    private Target target;
    private ArrayList<Node> walls = new ArrayList();

    public FileParser(Scanner sc) {
        this.scanner = sc;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int _height) {
        this.height = _height;
    }

    public Karel getKarel() {
        return karel;
    }

    public void setKarel(Karel _karel) {
        this.karel = _karel;
    }

    public Target getTarget() {
        return target;
    }

    public void setTarget(Target _target) {
        this.target = _target;
    }

    public ArrayList<Node> getWalls() {
        return walls;
    }

    public void setWalls(ArrayList<Node> _walls) {
        this.walls = _walls;
    }

    public void addWall(Wall w) {
        getWalls().add(w);
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int _width) {
        this.width = _width;
    }

    public void init() {
        String[] line;
        int param1, param2;
        while (scanner.hasNext()) {

            line = scanner.nextLine().split(DELIMITER);
            if (line.length >= 2) {
                param1 = Integer.parseInt(line[1]);
                param2 = Integer.parseInt(line[2]);
            } else if (line.length == 1) {
                param1 = param2 = Integer.parseInt(line[1]);
            } else {
                throw new ArrayIndexOutOfBoundsException("Spatne parametry");
            }

            if (line[0].startsWith(FileParser.TAG_KAREL)) {
                // parse Karel
                karel = new Karel(param1, param2);
            } else if (line[0].startsWith(FileParser.TAG_WALL)) {
                // parse wall
                walls.add(new Wall(param1, param2));
            } else if (line[0].startsWith(FileParser.TAG_TARGET)) {
                // parse target
                target = new Target(param1, param2);
            } else if (line[0].startsWith(FileParser.TAG_DESK)) {
                // parse playground
                width = param1;
                height = param2;
            }
        }
    }
}
