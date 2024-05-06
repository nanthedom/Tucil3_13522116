package interfaces;

import javax.swing.*;
import java.awt.*;

public class WordLadderGUI extends JFrame {
    private JPanel rightPanel, leftPanel;
    private JLabel startLabel, endLabel, algorithmLabel, resultLabel, propsLabel;
    private JTextField startField, endField;
    private JComboBox<String> algorithmDropdown;
    private JButton submitButton;
    private JTextPane resultArea;
    private JScrollPane scrollPane;

    public WordLadderGUI() {
        setPreferredSize(new Dimension(1000, 700));
        createComponents();
        layoutComponents();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void createComponents() {
        startLabel = new JLabel("Start Word:");
        endLabel = new JLabel("End Word:");
        algorithmLabel = new JLabel("Algorithm:");
        resultLabel = new JLabel("Result:");
        propsLabel = new JLabel("<html>Number of step: <br>Number of node visited: <br>Execution Time: </html>");

        startField = new JTextField();
        startField.setPreferredSize(new Dimension(200, 25));

        endField = new JTextField();
        endField.setPreferredSize(new Dimension(200, 25));

        String[] algorithms = { "UCS", "GBFS", "A*" };
        algorithmDropdown = new JComboBox<>(algorithms);

        submitButton = new JButton("Solve!");
        resultArea = new JTextPane();
        // resultArea.setLineWrap(true);
        // resultArea.setWrapStyleWord(true);

        scrollPane = new JScrollPane(resultArea);
        scrollPane.setPreferredSize(new Dimension(300, 200));

        submitButton.addActionListener(e -> {
            String startWord = startField.getText().toUpperCase();
            String endWord = endField.getText().toUpperCase();
            String algorithm = (String) algorithmDropdown.getSelectedItem();
            new WordLadderEventHandler().handleEvent(startWord, endWord, algorithm, resultArea, propsLabel);
        });
    }

    private void layoutComponents() {
        JPanel mainPanel = new JPanel(new GridLayout(1, 2, 0, 0));

        leftPanel = new JPanel(new GridBagLayout()) {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon backgroundImage = new ImageIcon("src/Asset/l.gif");
                Image img = backgroundImage.getImage();
                g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
            }
        };

        rightPanel = new JPanel(new GridBagLayout()) {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon backgroundImage = new ImageIcon("src/Asset/r.gif");
                Image img = backgroundImage.getImage();
                g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
            }
        };

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(5, 5, 5, 5);

        addToPanel(rightPanel, startLabel, constraints, 0, 0);
        addToPanel(rightPanel, startField, constraints, 1, 0);
        addToPanel(rightPanel, endLabel, constraints, 0, 1);
        addToPanel(rightPanel, endField, constraints, 1, 1);
        addToPanel(rightPanel, algorithmLabel, constraints, 0, 2);
        addToPanel(rightPanel, algorithmDropdown, constraints, 1, 2);
        addToPanel(rightPanel, submitButton, constraints, 0, 3, 2, 1);
        addToPanel(rightPanel, resultLabel, constraints, 0, 4);
        addToPanel(rightPanel, scrollPane, constraints, 0, 5, 2, 1);
        addToPanel(rightPanel, propsLabel, constraints, 0, 6);

        mainPanel.add(leftPanel);
        mainPanel.add(rightPanel);

        add(mainPanel);
    }

    private void addToPanel(JPanel panel, Component component, GridBagConstraints constraints, int x, int y) {
        constraints.gridx = x;
        constraints.gridy = y;
        panel.add(component, constraints);
    }

    private void addToPanel(JPanel panel, Component component, GridBagConstraints constraints, int x, int y, int width,
            int height) {
        constraints.gridx = x;
        constraints.gridy = y;
        constraints.gridwidth = width;
        constraints.gridheight = height;
        panel.add(component, constraints);
    }
}
