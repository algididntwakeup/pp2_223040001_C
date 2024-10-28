import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class ContohTabelJawi {
  public static void main(String[] args) {
    JFrame frame = new JFrame("meja jawa");

    // Membuat tabel dengan data awal dan header kolom
    String[] columnNames = { "ID", "nama", "umur" };
    Object[][] data = {
        { 1, "joko", 25 },
        { 2, "bambang", 30 },
        { 3, "budi", 35 },
    };

    // Membuat model tabel
    DefaultTableModel model = new DefaultTableModel(data, columnNames);

    // Membuat JTable dengan model
    JTable table = new JTable(model);

    // Membuat JScrollPane untuk menampung JTable
    JScrollPane scrollPane = new JScrollPane(table);

    // Menambahkan JScrollPane ke frame
    frame.add(scrollPane);

    // Konfigurasi frame
    frame.setSize(400, 200);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
  }
}