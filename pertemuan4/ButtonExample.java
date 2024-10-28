import java.awt.event.*;
import javax.swing.*;

public class ButtonExample {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Button Example");
        JButton button = new JButton("pencet sy");

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "duaarrr memei");
            }
        });

        button.setBounds(50,50,150,30);
        frame.add(button);
        frame.setSize(300,200);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}