import java.awt.event.*;
import javax.swing.*;

public class MouseListenerExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("MouseListener Example");

        JLabel label = new JLabel("Arahin trus klik mos kesini bre");
        label.setBounds(50,50,300,30);

        label.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                label.setText("Mouse Clicked at: ("+ e.getX() + ", " + e.getY() + ")" );
            } 

            public void mousePressed(MouseEvent e){
                label.setText("Mouse Pressed at: ("+ e.getX() + ", " + e.getY() + ")" );
            }

            public void mouseReleased(MouseEvent e){
                label.setText("Mouse Pressed at: ("+ e.getX() + ", " + e.getY() + ")" );
            }

            public void mouseEntered(MouseEvent e){
               label.setText("Mouse entered the area.");
            }
            public void mouseExited(MouseEvent e){
                label.setText("Mouse exited the area.");
            }
        });

        frame.add(label);
        frame.setSize(400,200);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}
