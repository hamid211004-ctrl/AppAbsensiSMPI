/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package appabsensismpihidayatuttholibin.view.componen;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author ASUS
 */
public class tableCustom extends JFrame {

    private JTable table;
    private JScrollPane scrollPane;

    public tableCustom() {
        setTitle("JTable Custom");
        setSize(700, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Model tabel
        DefaultTableModel model = new DefaultTableModel(
            new Object[][]{
                {"KLS001", "X RPL 1", "36"},
                {"KLS002", "X RPL 2", "34"},
                {"KLS003", "XI RPL 1", "35"},
                {"KLS004", "XI RPL 2", "33"},
                {"KLS005", "XII RPL 1", "32"}
            },
            new String[]{
                "ID Kelas",
                "Nama Kelas",
                "Jumlah Siswa"
            }
        ) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        // Membuat JTable
        table = new JTable(model);

        // Custom tabel
        table.setRowHeight(35);
        table.setGridColor(new Color(220, 220, 220));
        table.setSelectionBackground(new Color(0, 153, 153));
        table.setSelectionForeground(Color.WHITE);
        table.getTableHeader().setBackground(new Color(0, 102, 102));
        table.getTableHeader().setForeground(Color.WHITE);
        table.getTableHeader().setReorderingAllowed(false);

        // Rata tengah semua kolom
        DefaultTableCellRenderer center = new DefaultTableCellRenderer();
        center.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);

        for (int i = 0; i < table.getColumnCount(); i++) {
            table.getColumnModel().getColumn(i).setCellRenderer(center);
        }

        // Warna baris selang-seling
        table.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(
                    JTable table,
                    Object value,
                    boolean isSelected,
                    boolean hasFocus,
                    int row,
                    int column) {

                Component c = super.getTableCellRendererComponent(
                        table, value, isSelected,
                        hasFocus, row, column);

                setHorizontalAlignment(CENTER);

                if (!isSelected) {
                    if (row % 2 == 0) {
                        c.setBackground(Color.WHITE);
                    } else {
                        c.setBackground(new Color(240, 248, 255));
                    }
                }

                return c;
            }
        });

        // Event saat baris dipilih
        table.getSelectionModel().addListSelectionListener(e -> {
            int row = table.getSelectedRow();

            if (row != -1) {
                String id = table.getValueAt(row, 0).toString();
                String nama = table.getValueAt(row, 1).toString();

                System.out.println("ID Kelas : " + id);
                System.out.println("Nama Kelas : " + nama);
            }
        });

        scrollPane = new JScrollPane(table);
        add(scrollPane);
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> {
            new tableCustom().setVisible(true);
        });
    }
}