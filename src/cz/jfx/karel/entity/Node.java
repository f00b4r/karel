package cz.jfx.karel.entity;

import cz.jfx.karel.game.Playground;
import javax.swing.ImageIcon;

/**
 *
 * @author Felix
 */
public class Node{
    private Position position;
    private String code;
    private Playground parent;
    private ImageIcon icon = new ImageIcon(getClass().getResource("/cz/jfx/karel/resources/icons/empty.png"));

    public Node(int x, int y) {
        this.position = new Position(x, y);
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public void setPosition(int x, int y) {
        this.position = new Position(x, y);
    }
    
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Playground getParent() {
        return parent;
    }

    public void setParent(Playground p) {
        this.parent = p;
    }

    public ImageIcon getIcon() {
        return icon;
    }

    public void setIcon(ImageIcon icon) {
        this.icon = icon;
    }
    
    @Override
    public String toString() {
        return getCode();
    }
    
    
    
}
