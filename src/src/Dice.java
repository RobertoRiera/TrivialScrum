package src;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Dice extends JFrame{

    int randomNumber;
    private JLabel dice;
    private JLabel diceFace;
    private JFrame frame = new JFrame();

    public Dice() {
        createComponents();
        this.pack();
    }

    private void createComponents() {
        frame.setSize(200,200);
        frame.setBackground(Color.BLACK);
        dice = createDice();
        frame.add(dice, BorderLayout.NORTH);
        Timer timerDiceGif = new Timer(2000, e -> {
            dice.setVisible(false);
            diceFace.setVisible(true);
        });
        timerDiceGif.start();
        diceFace = createDiceFace();
        frame.add(diceFace, BorderLayout.CENTER);
        randomNumber=getRandomNumber();
        selectFace();
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
        Timer timerClose = new Timer(3000, e -> frame.dispose());
        timerClose.start();
    }

    private int getRandomNumber() {
        Random rand = new Random(System.currentTimeMillis());
        return rand.nextInt((6 - 1) + 1) + 1;
    }

    private void selectFace() {
        switch (randomNumber){
            case 1:  setImageToLabel("resources/One.png", diceFace);
                break;
            case 2:  setImageToLabel("resources/Two.png", diceFace);
                break;
            case 3:  setImageToLabel("resources/Three.png", diceFace);
                break;
            case 4:  setImageToLabel("resources/Four.png", diceFace);
                break;
            case 5:  setImageToLabel("resources/Five.png", diceFace);
                break;
            case 6:  setImageToLabel("resources/Six.png", diceFace);
                break;
        }
    }

    private JLabel createDice() {
        dice = new JLabel();
        setImageToLabel("resources/Dice.gif", dice);
        dice.setHorizontalAlignment(JLabel.CENTER);
        dice.setVisible(true);
        return dice;
    }

    private void setImageToLabel(String image, JLabel label) {
        ImageIcon dice = new ImageIcon(image);
        label.setIcon(dice);
    }

    private JLabel createDiceFace() {
        diceFace = new JLabel();
        diceFace.setHorizontalAlignment(JLabel.CENTER);
        diceFace.setVisible(false);
        return diceFace;
    }

}
