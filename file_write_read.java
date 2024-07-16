package Assignment;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class file_write_read extends JFrame implements ActionListener {
    /* Title for Frame */
    private JLabel lbtitle = new JLabel("Write Read & Append", JLabel.CENTER);

    /* Labels for frame */
    private JLabel lbFName = new JLabel("First Name : ");
    private JLabel lbLName = new JLabel("Last Name : ");
    private JLabel lbSex = new JLabel("Sex : ");
    private JLabel lbPosition = new JLabel("Position : ");
    private JLabel lbSalary = new JLabel("Salary : ");

    /* JTextFields for frame */
    private JTextField txtFName = new JTextField();
    private JTextField txtLName = new JTextField();
    private JComboBox<String> cbSex = new JComboBox<>(new String[]{"Male", "Female", "Other"});
    private JTextField txtPosition = new JTextField();
    private JTextField txtSalary = new JTextField();

    /* Buttons for frame */
    private JButton btnWrite = new JButton("Write");
    private JButton btnRead = new JButton("Read");
    private JButton btnAppend = new JButton("Append");

    /* Using JPanel for frame */
    private JPanel pnlContent = new JPanel(new BorderLayout());
    private JPanel pnlText = new JPanel(new GridLayout(5, 2, 10, 10)); // 5 rows, 2 columns, 10px padding
    private JPanel pnlBtn = new JPanel(new FlowLayout());

    /* JTable for frame */
    private JTable table;
    private DefaultTableModel tableModel;
    private JScrollPane scrollPane;

    public file_write_read() {
        // Frame settings
        setSize(500, 700);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Title settings
        lbtitle.setFont(new Font("Arial", Font.BOLD, 23));
        lbtitle.setBorder(new EmptyBorder(5, 5, 5, 5));
        add(lbtitle, BorderLayout.NORTH);

        // Set the same width & height for all labels
        Dimension labelSize = new Dimension(100, 30); // width: 100, height: 30 (adjust as needed)
        lbFName.setPreferredSize(labelSize);
        lbLName.setPreferredSize(labelSize);
        lbSex.setPreferredSize(labelSize);
        lbPosition.setPreferredSize(labelSize);
        lbSalary.setPreferredSize(labelSize);

        // Set the same font for all labels
        Font labelFont = new Font("Arial", Font.BOLD, 16); // adjust the font size as needed
        lbFName.setFont(labelFont);
        lbLName.setFont(labelFont);
        lbSex.setFont(labelFont);
        lbPosition.setFont(labelFont);
        lbSalary.setFont(labelFont);

        // Add components to pnlText
        pnlText.add(lbFName);
        pnlText.add(txtFName);
        pnlText.add(lbLName);
        pnlText.add(txtLName);
        pnlText.add(lbSex);
        pnlText.add(cbSex);
        pnlText.add(lbPosition);
        pnlText.add(txtPosition);
        pnlText.add(lbSalary);
        pnlText.add(txtSalary);
        pnlContent.add(pnlText, BorderLayout.NORTH);

        pnlContent.setBorder(new EmptyBorder(10, 10, 10, 10));

        // Add buttons to pnlBtn
        pnlBtn.add(btnWrite);
        pnlBtn.add(btnRead);
        pnlBtn.add(btnAppend);

        // Add pnlBtn to pnlContent
        pnlContent.add(pnlBtn, BorderLayout.SOUTH);

        // Create an empty table model with column names
        String[] columnNames = {"First Name", "Last Name", "Sex", "Position", "Salary"};
        tableModel = new DefaultTableModel(columnNames, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Disable table cell editing
            }
        };

        table = new JTable(tableModel);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // Allow only single row selection
        table.getSelectionModel().addListSelectionListener(new TableSelectionListener());

        scrollPane = new JScrollPane(table);

        // Add scrollPane to pnlContent
        pnlContent.add(scrollPane, BorderLayout.CENTER);

        // Add pnlContent to frame
        add(pnlContent, BorderLayout.CENTER);

        // Center the frame on the screen
        setLocationRelativeTo(null);

        // Add ActionListener to buttons
        btnWrite.addActionListener(this);
        btnRead.addActionListener(this);
        btnAppend.addActionListener(this);

        // Make the frame visible
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnWrite) {
            String firstName = txtFName.getText();
            String lastName = txtLName.getText();
            String sex = cbSex.getSelectedItem().toString();
            String position = txtPosition.getText();
            String salary = txtSalary.getText();

            // Add a new row to the table
            Object[] rowData = {firstName, lastName, sex, position, salary};
            tableModel.addRow(rowData);

            // Write to file
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("D:\\File\\W&R.txt", true))) {
                writer.write(firstName + "," + lastName + "," + sex + "," + position + "," + salary);
                writer.newLine();
            } catch (IOException ex) {
                ex.printStackTrace();
            }

            // Clear the text fields after adding the row
            clearFields();
        } else if (e.getSource() == btnRead) {
            // Clear table before populating from file
            clearTable();

            // Read data from file and populate table
            try (BufferedReader reader = new BufferedReader(new FileReader("D:\\File\\W&R.txt"))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] data = line.split(",");
                    tableModel.addRow(data);
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        } else if (e.getSource() == btnAppend) {
            // Get selected row index
            int selectedRow = table.getSelectedRow();
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(this, "Please select a row to append data.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Get data from selected row
            String firstName = txtFName.getText();
            String lastName = txtLName.getText();
            String sex = cbSex.getSelectedItem().toString();
            String position = txtPosition.getText();
            String salary = txtSalary.getText();

            // Update table model with new data
            tableModel.setValueAt(firstName, selectedRow, 0);
            tableModel.setValueAt(lastName, selectedRow, 1);
            tableModel.setValueAt(sex, selectedRow, 2);
            tableModel.setValueAt(position, selectedRow, 3);
            tableModel.setValueAt(salary, selectedRow, 4);

            // Write updated data to file
            updateFile(selectedRow, firstName, lastName, sex, position, salary);

            // Clear the text fields after appending
            clearFields();
        }
    }

    private void updateFile(int rowIndex, String firstName, String lastName, String sex, String position, String salary) {
        // Read all lines from file into a list
        File file = new File("D:\\File\\W&R.txt");
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            StringBuilder sb = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                sb.append(line).append(System.lineSeparator());
            }
            reader.close();

            // Update the line corresponding to the selected row
            String[] lines = sb.toString().split(System.lineSeparator());
            lines[rowIndex] = firstName + "," + lastName + "," + sex + "," + position + "," + salary;

            // Write back updated lines to the file
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            for (String updatedLine : lines) {
                writer.write(updatedLine);
                writer.newLine();
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void clearFields() {
        txtFName.setText("");
        txtLName.setText("");
        txtPosition.setText("");
        txtSalary.setText("");
        cbSex.setSelectedIndex(0);
    }

    private void clearTable() {
        // Clear all rows from the table
        while (tableModel.getRowCount() > 0) {
            tableModel.removeRow(0);
        }
    }

    private class TableSelectionListener implements ListSelectionListener {
        @Override
        public void valueChanged(ListSelectionEvent e) {
            if (!e.getValueIsAdjusting()) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) {
                    // Populate text fields with selected row data
                    txtFName.setText((String) tableModel.getValueAt(selectedRow, 0));
                    txtLName.setText((String) tableModel.getValueAt(selectedRow, 1));
                    cbSex.setSelectedItem((String) tableModel.getValueAt(selectedRow, 2));
                    txtPosition.setText((String) tableModel.getValueAt(selectedRow, 3));
                    txtSalary.setText((String) tableModel.getValueAt(selectedRow, 4));
                }
            }
        }
    }

    public static void main(String[] args) {
        new file_write_read();
    }
}
