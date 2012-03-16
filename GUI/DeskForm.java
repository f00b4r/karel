/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import game.Playground;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import node.Position;
import node.Node;

/**
 *
 * @author Felix
 */
public class DeskForm extends javax.swing.JFrame {

    private final ImageIcon ICON_DEFAULT = new ImageIcon(getClass().getResource("/icons/empty.png"));
    private Playground p;
    private Position currentPosition;

    /**
     * Creates new form DeskForm
     */
    public DeskForm() {
        initComponents();
        initMyComponents();
    }

    public DeskForm(Playground p) {
        this.p = p;
        initComponents();
        initMyComponents();
    }

    private void initMyComponents() {

        if (p == null) {
            throw new RuntimeException("Playground neni definovano");
        }

        setSize(new Dimension((p.getWidth() * 14) + 160, (p.getHeight() * 14) + 160));
        setMinimumSize(new Dimension((p.getWidth() * 14) + 160, (p.getHeight() * 14) + 160));

        GridLayout layout = new GridLayout(p.getHeight(), p.getWidth());
        //layout.setHgap(0);
        //layout.setVgap(1);
        playPanel.setLayout(layout);

        // generate desk
        Node node = null;
        boxes = new JLabel[p.getHeight()][p.getWidth()];
        for (int y = 0; y < p.getHeight(); y++) {
            for (int x = 0; x < p.getWidth(); x++) {
                boxes[y][x] = new JLabel();
                boxes[y][x].setIconTextGap(0);
                boxes[y][x].setMaximumSize(new java.awt.Dimension(16, 16));
                boxes[y][x].setMinimumSize(new java.awt.Dimension(16, 16));
                boxes[y][x].setPreferredSize(new java.awt.Dimension(16, 16));
                //Wall or Clear
                node = p.getNode(x, y);
                if (node != null) {
                    boxes[y][x].setIcon(node.getIcon());
                } else {
                    boxes[y][x].setIcon(ICON_DEFAULT);
                }
                playPanel.add(boxes[y][x]);
            }
        }

        placeKarel();
        placeTarget();
    }

    public void placeKarel() {
        // place Karel
        int x = p.getKarel().getPosition().getX();
        int y = p.getKarel().getPosition().getY();
        currentPosition = new Position(x, y);
        boxes[y][x].setIcon(p.getKarel().getIcon());
    }

    public void replaceKarel() {
        // replace Karel
        boxes[currentPosition.getY()][currentPosition.getX()].setIcon(ICON_DEFAULT);
        int x = p.getKarel().getPosition().getX();
        int y = p.getKarel().getPosition().getY();
        currentPosition = new Position(x, y);
        boxes[y][x].setIcon(p.getKarel().getIcon());
    }

    public void placeTarget() {
        // place Target
        boxes[p.getTarget().getPosition().getY()][p.getTarget().getPosition().getX()].setIcon(p.getTarget().getIcon());
    }

    public void refresh() {
        replaceKarel();
        addLog(p.getPlayHistory());
  
        if (p.getKarel().inTarget()) {
            finish();
        }
    }

    public void finish() {
        addLog("Desk: karel je v cily");
        JOptionPane.showMessageDialog(this, "Karel je v cíly.", "info", JOptionPane.PLAIN_MESSAGE);
        go.setEnabled(false);
        left.setEnabled(false);
        right.setEnabled(false);
        ui.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        playPanel = new javax.swing.JPanel();
        controlPanel = new javax.swing.JPanel();
        right = new javax.swing.JButton();
        go = new javax.swing.JButton();
        left = new javax.swing.JButton();
        ui = new javax.swing.JButton();
        outputPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        output = new javax.swing.JTextPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Karel ");
        setMinimumSize(null);
        setResizable(false);

        playPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout playPanelLayout = new javax.swing.GroupLayout(playPanel);
        playPanel.setLayout(playPanelLayout);
        playPanelLayout.setHorizontalGroup(
            playPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 137, Short.MAX_VALUE)
        );
        playPanelLayout.setVerticalGroup(
            playPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 144, Short.MAX_VALUE)
        );

        controlPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        right.setText("RIGHT");
        right.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rightActionPerformed(evt);
            }
        });

        go.setText("GO");
        go.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                goActionPerformed(evt);
            }
        });

        left.setText("LEFT");
        left.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                leftActionPerformed(evt);
            }
        });

        ui.setText("UI");
        ui.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout controlPanelLayout = new javax.swing.GroupLayout(controlPanel);
        controlPanel.setLayout(controlPanelLayout);
        controlPanelLayout.setHorizontalGroup(
            controlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(controlPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(controlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(controlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(left, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(go, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(right, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(ui, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        controlPanelLayout.setVerticalGroup(
            controlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(controlPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(go)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(right)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(left)
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(ui)
                .addContainerGap())
        );

        jScrollPane1.setViewportView(output);

        javax.swing.GroupLayout outputPanelLayout = new javax.swing.GroupLayout(outputPanel);
        outputPanel.setLayout(outputPanelLayout);
        outputPanelLayout.setHorizontalGroup(
            outputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE)
        );
        outputPanelLayout.setVerticalGroup(
            outputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(outputPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(playPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(controlPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(playPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(controlPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(outputPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-270)/2, (screenSize.height-355)/2, 270, 355);
    }// </editor-fold>//GEN-END:initComponents

    private void goActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_goActionPerformed
        p.getKarel().go();
        refresh();
    }//GEN-LAST:event_goActionPerformed

    private void rightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rightActionPerformed
        p.getKarel().turnRight();
        refresh();
    }//GEN-LAST:event_rightActionPerformed

    private void leftActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_leftActionPerformed
        p.getKarel().turnLeft();
        refresh();
    }//GEN-LAST:event_leftActionPerformed

    private void uiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uiActionPerformed
        addLog("Desk: UI funkce neni implementovana");
    }//GEN-LAST:event_uiActionPerformed

    public void addLog(String msg) {
        output.setText(output.getText() + msg + "\r\n");
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel controlPanel;
    private javax.swing.JButton go;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton left;
    private javax.swing.JTextPane output;
    private javax.swing.JPanel outputPanel;
    private javax.swing.JPanel playPanel;
    private javax.swing.JButton right;
    private javax.swing.JButton ui;
    // End of variables declaration//GEN-END:variables
    private JLabel[][] boxes;
}
