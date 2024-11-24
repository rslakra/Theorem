/**
 *
 */
package com.rslakra.theorem.pluralsight.stack;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.SecureRandom;

import javax.swing.*;

/**
 * @author Rohtash Lakra
 */
public final class UndoDemo extends JFrame implements ActionListener {

    private JButton leftButton;
    private JButton middleButton;
    private JButton rightButton;
    private JList<UndoAction> listButtons;
    private DefaultListModel<UndoAction> listModel;
    private JButton undoButton;
    private SecureRandom random = new SecureRandom();

    class UndoAction {

        private JButton jButton;
        private Color color;

        /**
         * @param jButton
         */
        public UndoAction(JButton jButton) {
            this.jButton = jButton;
            this.color = jButton.getBackground();
        }

        /**
         *
         */
        public void fireUndoEvent() {
            if (leftButton == jButton) {
                leftButton.setBackground(color);
            } else if (middleButton == jButton) {
                middleButton.setBackground(color);
            } else if (rightButton == jButton) {
                rightButton.setBackground(color);
            }
        }

        /**
         *
         */
        @Override
        public String toString() {
            return jButton.getText() + ":" + color.toString();
        }
    }

    public UndoDemo() {
        setSize(new Dimension(640, 480));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        listModel = new DefaultListModel<>();
        listButtons = new JList<>(listModel);
        listButtons.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listButtons.setLayoutOrientation(JList.VERTICAL);
        getContentPane().add(new JScrollPane(listButtons), BorderLayout.EAST);

        // buttons
        JPanel allButtons = new JPanel();
        allButtons.setLayout(new GridLayout(1, 3));

        leftButton = new JButton("1");
        setRandomColor(leftButton);
        leftButton.addActionListener(this);
        allButtons.add(leftButton);

        middleButton = new JButton("2");
        setRandomColor(middleButton);
        middleButton.addActionListener(this);
        allButtons.add(middleButton);

        rightButton = new JButton("3");
        setRandomColor(rightButton);
        rightButton.addActionListener(this);
        allButtons.add(rightButton);
        getContentPane().add(allButtons, BorderLayout.CENTER);

        // undo button
        undoButton = new JButton("Undo");
        undoButton.addActionListener(this);
        getContentPane().add(undoButton, BorderLayout.SOUTH);
    }

    /**
     * @return
     */
    private final Color getRandomColor() {
        int redValue = random.nextInt(255);
        int greenValue = random.nextInt(255);
        int blueValue = random.nextInt(255);
        return new Color(redValue, greenValue, blueValue);
    }

    /**
     * @param jButton
     */
    private void setRandomColor(JButton jButton) {
        jButton.setBackground(getRandomColor());
    }

    /**
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent event) {
        JButton selectedButton = (JButton) event.getSource();
        if (leftButton == selectedButton) {
            listModel.addElement(new UndoAction(selectedButton));
            setRandomColor(leftButton);
        } else if (middleButton == selectedButton) {
            listModel.addElement(new UndoAction(selectedButton));
            setRandomColor(middleButton);
        } else if (rightButton == selectedButton) {
            listModel.addElement(new UndoAction(selectedButton));
            setRandomColor(rightButton);
        } else if (undoButton == selectedButton) {
            if (!listModel.isEmpty()) {
                ((UndoAction) listModel.remove(listModel.getSize() - 1)).fireUndoEvent();
            }
        }
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        new UndoDemo().setVisible(true);
    }

}
