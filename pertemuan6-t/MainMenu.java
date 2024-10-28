import javax.swing.*;
import java.awt.*;

public class MainMenu extends JFrame {
    public MainMenu() {
        setTitle("Pemesanan Tiket Kereta Whoosh");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        // Tambahkan teks sambutan di halaman utama
        JLabel sambutanLabel = new JLabel("<html><body><h1 style='text-align:center;'>"
            + "Hello, <span style='color:orange;'>Admin!</span> Selamat datang di Whoosh</h1>"
            + "<h3 style='text-align:center;'>Silakan pilih opsi pemesanan dari menu</h3></body></html>", SwingConstants.CENTER);
        sambutanLabel.setVerticalAlignment(SwingConstants.CENTER);
        
        // Buat Menu
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Menu");
        JMenuItem pemesananItem = new JMenuItem("Form Pemesanan");

        pemesananItem.addActionListener(e -> new FormPemesanan().setVisible(true));

        menu.add(pemesananItem);
        menuBar.add(menu);
        setJMenuBar(menuBar);
        
        // Tambahkan label ke konten utama
        add(sambutanLabel, BorderLayout.CENTER);
    }
}
