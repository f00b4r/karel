package cz.jfx.karel.game;

import cz.jfx.karel.GUI.DeskForm;
import java.util.Scanner;

/**
 *
 * @author Felix
 */
public class Game {

    public final void start() {
        // Parse info from file
        FileParser fp = new FileParser(new Scanner(getClass().getResourceAsStream("/cz/jfx/karel/resources/zadani.log")));
        fp.init();

        final Playground p = new Playground(fp.getWidth(), fp.getHeight());
        // Place Walls
        p.setNode(fp.getWalls());
        // Place Karel
        p.setKarel(fp.getKarel());
        // Place Target
        p.setTarget(fp.getTarget());

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                DeskForm df = new DeskForm(p);
                df.setVisible(true);
            }
        });
    }

}
