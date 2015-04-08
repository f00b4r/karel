package cz.jfx.karel.entity;

import javax.swing.ImageIcon;

/**
 *
 * @author Felix
 */
public class Wall extends Node {

    public Wall(int x, int y) {
        super(x, y);
        setCode("Z");
        setIcon(new ImageIcon(getClass().getResource("/cz/jfx/karel/resources/icons/wall.png")));
    }
    
}
