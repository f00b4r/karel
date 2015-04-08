package cz.jfx.karel.entity;

import javax.swing.ImageIcon;

/**
 *
 * @author Felix
 */
public class Target extends Node {

    public Target(int x, int y) {
        super(x, y);
        setCode("C");
        setIcon(new ImageIcon(getClass().getResource("/cz/jfx/karel/resources/icons/target.png")));
    }
}
