import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;

import javax.swing.*;
import java.awt.*;

public class BoardFrame extends javax.swing.JFrame {

    private JButton jButton1;
    private JButton jButton2;
    private JButton jButton3;
    private JButton jButton4;
    private JButton jButton5;
    private JButton jButton6;
    private JButton centralButton;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JButton jButtonDice;
    private int movements = 55;

    public BoardFrame() {
        initComponents();
        configureButtons();
    }

    private void initComponents() {
        initializeLabels();
        initializeButtons();

        getContentPane().setLayout(new AbsoluteLayout());

        setIconToLabel("resources/queso.png", jLabel1);
        addLabel(jLabel1, new AbsoluteConstraints(270, 300, 30, 40));

        addButtons();
        addActionListenersToButtons();


        setIconToLabel("resources/Tablero.png", jLabel2);
        addLabel(jLabel2, new AbsoluteConstraints(0, 0, 600, 600));

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
    }

    private void initializeLabels() {
        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
    }

    private void initializeButtons() {
        jButton1 = new JButton();
        jButton2 = new JButton();
        jButton3 = new JButton();
        jButton4 = new JButton();
        jButton5 = new JButton();
        jButton6 = new JButton();
        centralButton = new JButton();
        jButtonDice = new JButton("Dado");
    }

    private void setIconToLabel(String string, JLabel label){
        label.setIcon(new ImageIcon(string));
    }

    private void addLabel(JLabel label, AbsoluteConstraints constraints){
        getContentPane().add(label, constraints);
    }

    private void addButtons() {
        addButtonAt(jButton1, 285, 190, 30, 20);
        addButtonAt(jButton2, 285, 390, 30, 20);
        addButtonAt(jButton3, 370, 240, 30, 20);
        addButtonAt(jButton4, 200, 240, 30, 20);
        addButtonAt(jButton5, 200, 340, 30, 20);
        addButtonAt(jButton6, 370, 340, 30, 20);
        addButtonAt(jButtonDice, 530, 540, 65, 30);
        addButtonAt(centralButton, 270, 300, 100, 80);
    }

    private void addActionListenersToButtons() {
        jButton1.addActionListener(evt -> jButtonActionPerformed(jButton1));
        jButton2.addActionListener(evt -> jButtonActionPerformed(jButton2));
        jButton3.addActionListener(evt -> jButtonActionPerformed(jButton3));
        jButton4.addActionListener(evt -> jButtonActionPerformed(jButton4));
        jButton5.addActionListener(evt -> jButtonActionPerformed(jButton5));
        jButton6.addActionListener(evt -> jButtonActionPerformed(jButton6));
        jButtonDice.addActionListener(e -> new Dice(this));
        centralButton.addActionListener(evt -> centralButtonActionPerformed());
    }

    private void configureButtons() {
        configureButton(jButton1);
        configureButton(jButton2);
        configureButton(jButton3);
        configureButton(jButton4);
        configureButton(jButton5);
        configureButton(jButton6);
        configureButton(centralButton);
        jButtonDice.setBackground(Color.ORANGE);
        jButtonDice.setVisible(true);
    }

    private void configureButton(JButton button) {
        button.setOpaque(false);
        button.setContentAreaFilled(false);
        button.setBorderPainted(false);
    }
    private void addButtonAt(JButton jButton, int positionX, int positionY, int width, int height) {
        getContentPane().add(jButton, new AbsoluteConstraints(positionX, positionY, width, height));
    }

    private void jButtonActionPerformed(JButton jButton) {
        if (movements == 0) return;
        moveCheese(getXOf(jButton) + 3, getYOf(jButton) - 8);
    }

    private void centralButtonActionPerformed() {
        if (movements == 0) return;
        moveCheese(getXOf(centralButton), getYOf(centralButton));
    }

    private void moveCheese(int xCords, int yCords) {
        setCheeseAtLocation(xCords, yCords);
        movements--;
    }

    private void setCheeseAtLocation(int x, int y) {
        jLabel1.setLocation(x, y);
    }
    private int getYOf(JButton jButton) {
        return (int) jButton.getLocation().getY();
    }

    private int getXOf(JButton jButton) {
        return (int) jButton.getLocation().getX();
    }
}