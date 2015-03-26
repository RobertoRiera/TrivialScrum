import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Dice extends JDialog{

    private JLabel dice;
    private JLabel diceFace;

    public Dice(JFrame frame) {
        super(frame, true);
        createComponents();
        configureFrame();
    }

    private void configureFrame() {
        this.setSize(200, 200);
        this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.pack();
        this.setBackground(Color.BLACK);
        this.setVisible(true);
    }

    private void createComponents() {
        this.add(createDice(), BorderLayout.NORTH);
        createShowDiceGifTimer().start();
        this.add(createDiceFace(), BorderLayout.CENTER);
        selectFace();
        createCloseDialogTimer().start();
    }

    private JLabel createDice() {
        dice = new JLabel();
        setImageToLabel("resources/Dice.gif", dice);
        dice.setHorizontalAlignment(JLabel.CENTER);
        dice.setVisible(true);
        return dice;
    }

    private Timer createShowDiceGifTimer() {
        return new Timer(2000, e -> {
            dice.setVisible(false);
            diceFace.setVisible(true);
        });
    }

    private JLabel createDiceFace() {
        diceFace = new JLabel();
        diceFace.setHorizontalAlignment(JLabel.CENTER);
        diceFace.setVisible(false);
        return diceFace;
    }

    private Timer createCloseDialogTimer() {
        return new Timer(3000, e -> Dice.this.dispose());
    }

    private int getRandomNumber() {
        return new Random(System.currentTimeMillis()).nextInt((6 - 1) + 1) + 1;
    }

    private void selectFace() {
        setImageToLabel("resources/" + getRandomNumber() + ".png", diceFace);
    }

    private void setImageToLabel(String image, JLabel label) {
        ImageIcon dice = new ImageIcon(image);
        label.setIcon(dice);
    }
}