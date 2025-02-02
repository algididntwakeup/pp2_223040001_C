import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class TabelJawaBerubah {
    public static void main(String[] args) {
        JFrame frame = new JFrame("tabel jawi custom");

        String[] columnNames = { "ID", "Name", "Age" };
        Object[][] data = {
            { 1, "joko", 25 },
            { 2, "dodo", 30 },
            { 3, "mulyono", 35 },
        };

        // Membuat DefaultTableModel dengan data dan header
        DefaultTableModel model = new DefaultTableModel(data, columnNames) {
            @Override
            public boolean isCellEditable(int row, int column) {
                // Hanya kolom 'Name' yang dapat diedit
                return column == 1;
            }
        };

        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        frame.add(scrollPane);

        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}