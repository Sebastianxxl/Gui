package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleGui {

    private JButton circleButton;
    private JButton labelButton;
    private JFrame window;
    private DrawPanel panel;
    private JLabel label;


    public static void main(String[] args) {
        new SimpleGui().run();
    }

    protected void run() {

        window = new JFrame();
        circleButton = new JButton("Change color");
        labelButton = new JButton("Change label");
        label = new JLabel("Not Clicked");
        panel = new DrawPanel();
        labelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        circleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        window.getContentPane().add(BorderLayout.SOUTH, circleButton);
        window.getContentPane().add(BorderLayout.CENTER, panel);
        window.getContentPane().add(BorderLayout.EAST, labelButton);
        window.getContentPane().add(BorderLayout.WEST, label);

        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        window.setSize(500, 500);

        window.setVisible(true);

//        moveCicle();
    }

    protected void changeText() {
        circleButton.setText("You clicked me");
    }
    protected void changeLabel() { labelButton.setText("Clicked"); }

    private void moveCicle() {
        for (int x = 0; x <= 300; x++) {
            panel.setXY(x, x);
            window.repaint();
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void changeColor() {
        window.repaint();
    }
}
