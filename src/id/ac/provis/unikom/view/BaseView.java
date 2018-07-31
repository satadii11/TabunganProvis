package id.ac.provis.unikom.view;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * @author satadii11
 */
public class BaseView extends JFrame {
    public void showDialog(String message) {
        JOptionPane.showMessageDialog(null, message);
    }
}
