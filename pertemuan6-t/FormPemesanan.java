import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormPemesanan extends JFrame {
    private JTextField namaField, teleponField;
    private JTextArea catatanArea;
    private JRadioButton ekonomiButton, bisnisButton, eksekutifButton;
    private JCheckBox makananBox, wifiBox, minumanBox;
    private JComboBox<String> tujuanBox;
    private JList<String> waktuList;
    private JSlider jumlahSlider;
    private DefaultTableModel tableModel;

    public FormPemesanan() {
        setTitle("Form Pemesanan Tiket Kereta Whoosh");
        setSize(700, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new BorderLayout());

        // Panel Utama untuk Form Input
        JPanel mainPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);

        // Nama dan Telepon
        namaField = new JTextField(20);
        teleponField = new JTextField(20);
        addField(mainPanel, gbc, "Nama:", namaField, 0);
        addField(mainPanel, gbc, "Telepon:", teleponField, 1);

        // Kelas Kereta
        ekonomiButton = new JRadioButton("Ekonomi");
        bisnisButton = new JRadioButton("Bisnis");
        eksekutifButton = new JRadioButton("Eksekutif");
        ButtonGroup kelasGroup = new ButtonGroup();
        kelasGroup.add(ekonomiButton);
        kelasGroup.add(bisnisButton);
        kelasGroup.add(eksekutifButton);

        JPanel kelasPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        kelasPanel.add(ekonomiButton);
        kelasPanel.add(bisnisButton);
        kelasPanel.add(eksekutifButton);
        addField(mainPanel, gbc, "Kelas:", kelasPanel, 2);

        // Layanan Tambahan
        makananBox = new JCheckBox("Makanan");
        wifiBox = new JCheckBox("Wi-Fi");
        minumanBox = new JCheckBox("Minuman");

        JPanel layananPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        layananPanel.add(makananBox);
        layananPanel.add(wifiBox);
        layananPanel.add(minumanBox);
        addField(mainPanel, gbc, "Layanan Tambahan:", layananPanel, 3);

        // Tujuan dan Waktu
        tujuanBox = new JComboBox<>(new String[]{"Jakarta", "Bandung", "Surabaya"});
        waktuList = new JList<>(new String[]{"07:00", "13:00", "18:00"});
        waktuList.setVisibleRowCount(3);

        addField(mainPanel, gbc, "Tujuan:", tujuanBox, 4);
        addField(mainPanel, gbc, "Waktu Keberangkatan:", new JScrollPane(waktuList), 5);

        // Jumlah Tiket dengan Slider
        jumlahSlider = new JSlider(1, 10, 1);
        jumlahSlider.setMajorTickSpacing(1);
        jumlahSlider.setPaintTicks(true);
        jumlahSlider.setPaintLabels(true);
        addField(mainPanel, gbc, "Jumlah Tiket:", jumlahSlider, 6);

        // Catatan Tambahan
        catatanArea = new JTextArea(3, 20);
        addField(mainPanel, gbc, "Catatan:", new JScrollPane(catatanArea), 7);

        // Tambahkan Panel Utama ke BorderLayout.CENTER
        add(mainPanel, BorderLayout.CENTER);

        // Panel untuk Tombol Pesan dan Tabel Output
        JPanel bottomPanel = new JPanel(new BorderLayout());

        // Tombol Pesan
        JButton pesanButton = new JButton("Pesan");
        pesanButton.addActionListener(new PesanButtonListener());
        bottomPanel.add(pesanButton, BorderLayout.NORTH);

        // Tabel Output di bawah tombol
        
        tableModel = new DefaultTableModel(new Object[]{"Nama", "Telepon", "Kelas", "Tujuan", "Waktu", "Jumlah"}, 0);
        JTable table = new JTable(tableModel);
        JScrollPane tableScrollPane = new JScrollPane(table);
        tableScrollPane.setPreferredSize(new Dimension(600, 150)); // Mengatur ukuran tabel agar lebih kecil
        bottomPanel.add(tableScrollPane, BorderLayout.CENTER);

        add(bottomPanel, BorderLayout.SOUTH);
    }

    private void addField(JPanel panel, GridBagConstraints gbc, String labelText, JComponent component, int yPos) {
        gbc.gridx = 0;
        gbc.gridy = yPos;
        panel.add(new JLabel(labelText), gbc);

        gbc.gridx = 1;
        panel.add(component, gbc);
    }

    // Listener untuk tombol pesan
    private class PesanButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String nama = namaField.getText();
            String telepon = teleponField.getText();
            String kelas = ekonomiButton.isSelected() ? "Ekonomi" : bisnisButton.isSelected() ? "Bisnis" : "Eksekutif";
            String tujuan = (String) tujuanBox.getSelectedItem();
            String waktu = waktuList.getSelectedValue();
            int jumlah = jumlahSlider.getValue();

            tableModel.addRow(new Object[]{nama, telepon, kelas, tujuan, waktu, jumlah});
        }
    }
}
