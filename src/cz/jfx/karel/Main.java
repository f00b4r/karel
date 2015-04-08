package cz.jfx.karel;

import cz.jfx.karel.game.Game;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

/**
 *
 * @author Felix
 */
public class Main {

    public static void main(String[] args) {
        try {
            javax.swing.UIManager.setLookAndFeel(new NimbusLookAndFeel());
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            System.out.println("Nelze nastavit LaF");
        }

        Game g = new Game();
        g.start();
    }
}
