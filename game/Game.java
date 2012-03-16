package game;

import GUI.DeskForm;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

/**
 *
 * @author Felix
 */
public class Game {

    private void start() {
        // Parse info from file
        FileParser fp = new FileParser("ROOT_PATH/src/game/zadani.log");
        fp.init();

        final Playground p = new Playground(fp.getWidth(), fp.getHeight());
        // Place Walls
        p.setNode(fp.getWalls());
        // Place Karel
        p.setKarel(fp.getKarel());
        // Place Target
        p.setTarget(fp.getTarget());

        try {
            javax.swing.UIManager.setLookAndFeel(new NimbusLookAndFeel());
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            System.out.println("Nelze nastavit LaF");
        }

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

    public static void main(String[] args) {
        Game g = new Game();
        g.start();
    }
}
