package src;


import javax.swing.*;
import java.awt.*;

public class BoardFrame extends javax.swing.JFrame {
    private final int X_POS_TO_CENTER_BUTTON = 3;
    private final int Y_POS_TO_CENTER_BUTTON = 8;
    private JButton jButton1, jButton2, jButton3, jButton4, jButton5, jButton6, jButton7, jButtonDice;
    private JLabel jLabelCheese, jLabelBoard, jLabelPlayer;
    private AskForm askForm;
    private Player actualPlayer;

    public BoardFrame() {
        actualPlayer = new Player("Un solo jugador", "green");
        initComponents();
        manageButton(jButton1);
        manageButton(jButton2);
        manageButton(jButton3);
        manageButton(jButton4);
        manageButton(jButton5);
        manageButton(jButton6);
        manageButton(jButton7);
        jButtonDice.setVisible(true);
    }
    public BoardFrame(Player... players) {
        actualPlayer = players[0];
        initComponents();
        manageButton(jButton1);
        manageButton(jButton2);
        manageButton(jButton3);
        manageButton(jButton4);
        manageButton(jButton5);
        manageButton(jButton6);
        manageButton(jButton7);
        jButtonDice.setVisible(true);
    }

    private void manageButton(JButton jbutton) {
        jbutton.setOpaque(false);
        jbutton.setContentAreaFilled(false);
        jbutton.setBorderPainted(false);
    }

    private void initComponents() {
        askForm = new AskForm();
        jLabelCheese = new JLabel();
        jLabelBoard = new JLabel();
        jLabelPlayer = new JLabel();
        jButton1 = new JButton();
        jButton2 = new JButton();
        jButton3 = new JButton();
        jButton4 = new JButton();
        jButton5 = new JButton();
        jButton6 = new JButton();
        jButton7 = new JButton();
        jButtonDice = new JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelCheese.setIcon(new javax.swing.ImageIcon("resources/queso.png"));
        getContentPane().add(jLabelCheese, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 300, 30, 40));

        jButtonDice.setText("Dado");
        jButtonDice.setBackground(Color.ORANGE);
        jButtonDice.addActionListener(e -> new Dice());
        addButtonAt(jButtonDice, 530, 540, 65, 30);

        jButton1.addActionListener(evt -> jButton1ActionPerformed());
        addButtonAt(jButton1, 285, 190, 30, 20);

        jButton2.addActionListener(evt -> jButton2ActionPerformed());
        addButtonAt(jButton2, 285, 390, 30, 20);

        jButton3.addActionListener(evt -> jButton3ActionPerformed());
        addButtonAt(jButton3, 370, 240, 30, 20);

        jButton4.addActionListener(evt -> jButton4ActionPerformed());
        addButtonAt(jButton4, 200, 240, 30, 20);

        jButton5.addActionListener(evt -> jButton5ActionPerformed());
        addButtonAt(jButton5, 200, 340, 30, 20);

        jButton6.addActionListener(evt -> jButton6ActionPerformed());
        addButtonAt(jButton6, 370, 340, 30, 20);

        jButton7.addActionListener(evt -> jButton7ActionPerformed());
        addButtonAt(jButton7, 270, 300, 100, 80);

        jLabelBoard.setIcon(new javax.swing.ImageIcon("resources/Tablero.png"));
        getContentPane().add(jLabelBoard, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 600, 600));

        jLabelPlayer.setText("JUGANDO: " + actualPlayer.getName());
        jLabelPlayer.setFont(new Font("Times New Roman", Font.BOLD, 15));
        jLabelPlayer.setSize(300,50);
        jLabelBoard.add(jLabelPlayer);
        jLabelPlayer.setVisible(true);

        pack();
    }

    private void addButtonAt(JButton jButton, int positionX, int positionY, int width, int height) {
        getContentPane().add(jButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(positionX, positionY, width, height));
    }

    private void moveCheese(int xCords, int yCords) {
        setCheeseAtLocation(xCords, yCords);
    }

    private void jButton1ActionPerformed() {
        cheeseAction(jButton1, "deportes.txt");
    }

    private void jButton2ActionPerformed() {
        cheeseAction(jButton2, "cienciaytecnologia.txt");
    }

    private void jButton3ActionPerformed() {
        cheeseAction(jButton3, "geografia.txt");
    }

    private void jButton4ActionPerformed() {
        cheeseAction(jButton4, "arteyliteratura.txt");
    }

    private void jButton5ActionPerformed() {
        cheeseAction(jButton5, "espectaculo.txt");
    }

    private void jButton6ActionPerformed() {
        cheeseAction(jButton6, "historia.txt");
    }

    private void jButton7ActionPerformed() {
        moveCheese(getXOf(jButton7), getYOf(jButton7));
    }

    private void cheeseAction(JButton jButton, String category) {
        moveCheese(getXOf(jButton) + X_POS_TO_CENTER_BUTTON, getYOf(jButton) - Y_POS_TO_CENTER_BUTTON);
        getWindowPopUpQuestion(category);
    }

    private void setCheeseAtLocation(int x, int y) {
        jLabelCheese.setLocation(x, y);
    }

    private WindowPopUpQuestion getWindowPopUpQuestion(String category) {
        this.setEnabled(false);
        return new WindowPopUpQuestion(askForm, category, this);
    }

    private int getYOf(JButton jButton) {
        return (int) jButton.getLocation().getY();
    }

    private int getXOf(JButton jButton) {
        return (int) jButton.getLocation().getX();
    }

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BoardFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(() -> new BoardFrame().setVisible(true));
    }



}