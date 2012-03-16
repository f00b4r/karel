package node;

import javax.swing.ImageIcon;

/**
 *
 * @author Felix
 */
public class Target extends Node {

    public Target(int x, int y) {
        super(x, y);
        setCode("C");
        setIcon(new ImageIcon(getClass().getResource("/icons/target.png")));
    }
}
