import java.awt.event.*;
import javax.swing.*;

public class KeyListenerExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("KeyListener Example");
        JLabel label = new JLabel("coba pencet tombol di kibot dah");
        label.setBounds(50,50,300,30);

        JTextField textField = new JTextField();
        textField.setBounds(50,100,200,30);

      textField.addKeyListener(new KeyListener() {
        public void keyPressed(KeyEvent e) {
         label.setText("Key pressed: "+ KeyEvent.getKeyText(e.getKeyCode()));
        }

        public void keyReleased(KeyEvent e) {
            label.setText("Key released: "+ KeyEvent.getKeyText(e.getKeyCode()));
        }

        public void keyTyped(KeyEvent e) {
            label.setText("Key typed: " + e.getKeyChar());
        }
      });

      frame.add(label);
      frame.add(textField);
      frame.setSize(400,200);
      frame.setLayout(null);
      frame.setVisible(true);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
