package cpp.lab2;

import cpp.lab2.gui.main.MainFrame;

import javax.swing.*;
import java.awt.*;

public class Source {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            MainFrame frame = new MainFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}
