package game;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import node.Karel;
import node.Node;
import node.Target;
import node.Wall;

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
    private File _f;
    /*
     * Playground
     */
    private int _width;
    private int _height;
    private Karel _karel;
    private Target _target;
    private ArrayList<Node> _walls = new ArrayList();

    public FileParser(File f) {
        this._f = f;
    }

    public FileParser(String f) {
        this._f = new File(f);
    }

    public File getFile() {
        return _f;
    }

    public void setFile(File f) {
        this._f = f;
    }

    public int getHeight() {
        return _height;
    }

    public void setHeight(int _height) {
        this._height = _height;
    }

    public Karel getKarel() {
        return _karel;
    }

    public void setKarel(Karel _karel) {
        this._karel = _karel;
    }

    public Target getTarget() {
        return _target;
    }

    public void setTarget(Target _target) {
        this._target = _target;
    }

    public ArrayList<Node> getWalls() {
        return _walls;
    }

    public void setWalls(ArrayList<Node> _walls) {
        this._walls = _walls;
    }

    public void addWall(Wall w) {
        getWalls().add(w);
    }

    public int getWidth() {
        return _width;
    }

    public void setWidth(int _width) {
        this._width = _width;
    }

    public void init() {
        try {
            Scanner sc = new Scanner(_f);
            String[] line;
            int param1, param2;
            while (sc.hasNext()) {

                line = sc.nextLine().split(DELIMITER);
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
                    _karel = new Karel(param1, param2);
                } else if (line[0].startsWith(FileParser.TAG_WALL)) {
                    // parse wall
                    _walls.add(new Wall(param1, param2));
                } else if (line[0].startsWith(FileParser.TAG_TARGET)) {
                    // parse target
                    _target = new Target(param1, param2);
                } else if (line[0].startsWith(FileParser.TAG_DESK)) {
                    // parse playground
                    _width = param1;
                    _height = param2;
                }
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Chyba pri cteni souboru..");
            System.out.println(ex.getMessage());
        }

    }
}
