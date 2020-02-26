package app;

import javax.swing.JFrame;

public class View {
    JFrame frame;
    public View() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setVisible(true);
    }
}