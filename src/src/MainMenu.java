package src;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu extends JFrame{

    public MainMenu() {
        this.setTitle("Trivial");
        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setResizable(false);
        createComponents();
        this.pack();
        this.setLocationRelativeTo(null);
    }

    private void createComponents() {
        this.add(createMainPanel());
    }

    private JPanel createMainPanel() {
        ImagePanel panel = new ImagePanel("resources/MainMenu.jpg");
        panel.setLayout(new GridBagLayout());
        panel.add(createButtonsPanel(), new GridBagConstraints());
        return panel;
    }

    private JPanel createButtonsPanel() {
        JPanel panel = new JPanel();
        panel.add(createButton("Estadísticas"));
        JButton start = createButton("Comenzar partida");
        start.addActionListener((ActionEvent e) -> {
            JFrame board = new BoardFrame(new Player("Pepe", "red"));
            board.setVisible(true);
            MainMenu.this.dispose(); //Si quitamos esta linea no se cierra el menu inicial
            
            //no se como visualizarlo, se k va aqui
        });
        setVisible(true);
        panel.add(start);
        panel.add(createButton("Ver reglas"));
        panel.setOpaque(false);
        return panel;
    }

    private JButton createButton(String buttonName) {
        JButton button = new JButton(buttonName);
        button.setBackground(Color.ORANGE);
        return button;
    }
}
