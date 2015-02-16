package node;

import javax.swing.ImageIcon;

/**
 *
 * @author Felix
 */
public class Wall extends Node {

    public Wall(int x, int y) {
        super(x, y);
        setCode("Z");
        setIcon(new ImageIcon(getClass().getResource("/icons/wall.png")));
    }
    
}
