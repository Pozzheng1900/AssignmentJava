package Assignment;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.*;
import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import javax.imageio.ImageIO;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableRowSorter;

public class CakeForm extends JFrame implements ActionListener {
    private JLabel Jtitle = new JLabel("LUCKY CAKE STORE", SwingConstants.CENTER);
    private JLabel lbID = new JLabel("ID :");
    private JTextField txtid = new JTextField();
    private JLabel lbName = new JLabel("Name :");
    private JTextField txtName = new JTextField();
    private JLabel lbGender = new JLabel("Gender :");
    private Choice ch_gender = new Choice();
    private JLabel lbSize = new JLabel("Size :");
    private Choice ch_size = new Choice();
    private JLabel lbPrice = new JLabel("Price :");
    private Choice ch_Price = new Choice();
    private JLabel lbPhone = new JLabel("Phone :");
    private JTextField txtPhone = new JTextField();
    private JLabel lbqty = new JLabel("QTY :");
    private JTextField txtqty = new JTextField();
    private JButton btnAdd = new JButton("Add");
    private JButton btnClear = new JButton("Clear");
    private JButton btnExit = new JButton("Exit");
    private JButton btnUpdate = new JButton("Update");
    private JButton btnDelete = new JButton("Delete");
    private JButton btnSave = new JButton("Save");
    private JPanel contentpnl = new JPanel(new GridLayout(1, 2, 30, 20));
    private JPanel btnpnl = new JPanel(new BorderLayout());
    private JPanel txtpnl = new JPanel(new GridLayout(8, 2, 0, 20));
    private JPanel bigContentpnl = new JPanel(new BorderLayout());
    private JPanel contentleftpnl = new JPanel(new BorderLayout());
    private JPanel contentrightpnl = new JPanel(new BorderLayout());
    private TextArea display = new TextArea();
    private JButton btnLoadImage = new JButton("Choose Cake");
    private ImagePanel imagePanel = new ImagePanel(); // Use ImagePanel instead of Canvas
    private JTextField total = new JTextField();
    private JLabel lbTotal = new JLabel("TOTAL : ");
    private JLabel post_date = new JLabel("Post_Date :");
    private JTextField txtDate = new JTextField();

    // Add JTable components
    private JTable table;
    private DefaultTableModel tableModel;
    private int txtIdCount = 0;
    public CakeForm(String title) {
        super(title);
        JLabel background;
        setSize(1100, 850);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Load the background image
        ImageIcon img = new ImageIcon("D:\\All in\\JAVA_M7_G26_2024\\java1\\src\\Assignment\\p3.jpg");
        background = new JLabel("", img, JLabel.CENTER);
        background.setSize(1100,800);
        background.setBounds(0, 0, 1100, 800);
        add(background);

        getContentPane().setBackground(Color.BLACK);

        // Setup content panel
        contentpnl.setOpaque(false);
        contentleftpnl.setBackground(Color.BLACK);

        total.setText("$0.00");

        // Set font all text
        lbID.setFont(new Font("Monospaced", Font.BOLD, 20));
        lbName.setFont(new Font("Monospaced", Font.BOLD, 20));
        lbGender.setFont(new Font("Monospaced", Font.BOLD, 20));
        ch_gender.setFont(new Font("Monospaced", Font.PLAIN, 20));
        lbSize.setFont(new Font("Monospaced", Font.BOLD, 20));
        ch_size.setFont(new Font("Monospaced", Font.PLAIN, 20));
        lbPrice.setFont(new Font("Monospaced", Font.BOLD, 20));
        ch_Price.setFont(new Font("Monospaced", Font.PLAIN, 20));
        lbPhone.setFont(new Font("Monospaced", Font.BOLD, 20));
        lbqty.setFont(new Font("Monospaced", Font.BOLD, 20));
        post_date.setFont(new Font("Monospaced", Font.BOLD, 20));

        // Set color font
        lbID.setForeground(Color.white);
        lbName.setForeground(Color.white);
        lbGender.setForeground(Color.white);
        lbSize.setForeground(Color.white);
        lbPrice.setForeground(Color.white);
        lbPhone.setForeground(Color.white);
        lbqty.setForeground(Color.white);
        post_date.setForeground(Color.white);

        Jtitle.setBorder(new EmptyBorder(30, 0, 30, 0));

        Border border = new EmptyBorder(5,5,5,5);

        // Add all box or add to panel
        txtpnl.setOpaque(false);
        txtpnl.add(lbID);
        txtid.setBorder(null);

        updateTxtIdCount();
        txtid.setFont(new Font("Monospaced",Font.BOLD,20));
        txtid.setText(String.valueOf(Integer.valueOf(txtIdCount)));
//        txtid.setBorder(BorderFactory.createCompoundBorder(
//                txtid.getBorder(),
//                BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        txtid.setBorder(border);
        txtpnl.add(txtid, BorderLayout.NORTH);

        txtpnl.add(lbName);
        txtName.setFont(new Font("Monospaced",Font.BOLD,20));
        txtName.setBorder(border);
        txtpnl.add(txtName);

        txtpnl.add(lbGender);
        ch_gender.add("Male"); // add gender option
        ch_gender.add("Female");
        ch_gender.setFont(new Font("Monospaced",Font.BOLD,20));
        txtpnl.add(ch_gender);

        txtpnl.add(lbSize);
        ch_size.add("Small");
        ch_size.add("Medium");
        ch_size.add("Large");
        ch_size.setFont(new Font("Monospaced",Font.BOLD,20));
        txtpnl.add(ch_size);

        txtpnl.add(lbPrice);
        ch_Price.add("$5.00"); // add price option
        ch_Price.add("$10.00");
        ch_Price.add("$15.00");
        ch_Price.setFont(new Font("Monospaced",Font.BOLD,20));
        txtpnl.add(ch_Price);

        txtpnl.add(lbqty);
        txtqty.setFont(new Font("Monospaced",Font.BOLD,20));
        txtqty.setBorder(border);
        txtpnl.add(txtqty);

        txtpnl.add(lbPhone);
        txtPhone.setFont(new Font("Monospaced",Font.BOLD,20));
        txtPhone.setBorder(border);
        txtpnl.add(txtPhone);

        txtpnl.add(post_date);
        txtDate.setFont(new Font("Monospaced",Font.BOLD,20));
        txtDate.setBorder(border);
        txtDate.setMargin(new Insets(10,10,10,10));
        txtpnl.add(txtDate,BorderLayout.CENTER);

        btnLoadImage.setBounds(30, 570, 145, 40);
        btnLoadImage.setBackground(Color.orange);
        btnLoadImage.setFont(new Font("Monospaced",Font.BOLD,14));
        imagePanel.setBounds(30, 611, 145, 150);
        imagePanel.setBackground(Color.pink);

        btnAdd.setBounds(240, 570, 80, 30);

        btnClear.setBounds(330, 570, 80, 30);

        btnExit.setBounds(420, 570, 80, 30);

        btnUpdate.setBounds(240,620,80,30);

        btnDelete.setBounds(330,620,80,30);

        btnSave.setBounds(420,620,80,30);


        lbTotal.setBounds(450, 715, 120, 50);
        lbTotal.setFont(new Font("Monospaced", Font.BOLD, 20));
        lbTotal.setForeground(Color.white);
        total.setBounds(550, 720, 120, 40);
        total.setBorder(null);
        total.setBackground(new Color(255,105,180));
        total.setFont(new Font("Monospaced", Font.BOLD, 25));
        total.setForeground(Color.WHITE);

        contentleftpnl.setOpaque(false);
        contentleftpnl.add(txtpnl, BorderLayout.NORTH);

        contentpnl.setOpaque(false);
        contentpnl.add(contentleftpnl);

        // Setup the table
        String[] columns = {"ID", "Name", "Gender", "Size", "Price", "Phone", "QTY","P_D"};
        tableModel = new DefaultTableModel(columns, 0);
        table = new JTable(tableModel) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Disable editing for all cells
            }
        };

        table.setFont(new Font("TimesRoman",Font.PLAIN,15));
        // Set font size for the header
        Font headerFont = new Font("TimesRoman", Font.BOLD, 16);
        table.getTableHeader().setFont(headerFont);

        // Set column headers non-editable
        table.getTableHeader().setReorderingAllowed(false);
        for (int i = 0; i < table.getColumnCount(); i++) {
            table.getTableHeader().getColumnModel().getColumn(i).setResizable(false);
            table.getTableHeader().getColumnModel().getColumn(i).setCellEditor(null);
        }

        // Add the table to a scroll pane
        JScrollPane scrollPane = new JScrollPane(table);
        contentrightpnl.add(scrollPane, BorderLayout.CENTER);
        contentpnl.add(contentrightpnl,BorderLayout.CENTER);

        // Set properties for title label
        Jtitle.setFont(new Font("TimesRoman", Font.BOLD, 40));
        Jtitle.setForeground(Color.pink);
        Jtitle.setSize(0, 300);

        bigContentpnl.setOpaque(false);
        bigContentpnl.setBounds(0, 0, 1100, 550);
        bigContentpnl.add(Jtitle, BorderLayout.NORTH);
        bigContentpnl.add(contentpnl);
        bigContentpnl.setBorder(new EmptyBorder(0, 30, 0, 40));

        background.add(bigContentpnl);
        background.add(btnLoadImage);
        background.add(imagePanel);
        background.add(btnAdd);
        background.add(btnClear);
        background.add(btnExit);
        background.add(btnUpdate);
        background.add(btnDelete);
        background.add(btnSave);
        background.add(total);
        background.add(lbTotal);

        btnLoadImage.addActionListener(this); // Register ActionListener for button
        btnAdd.addActionListener(this); // Register ActionListener for add button
        btnClear.addActionListener(this); // Register ActionListener for clear button
        btnExit.addActionListener(this); // Register ActionListener for exit button
        btnUpdate.addActionListener(this);
        btnDelete.addActionListener(this);
        btnSave.addActionListener(this);

        loadDataFromFile("D:\\data.txt");

        // Set the current date and time in txtDate
        setCurrentDateTime();

        setVisible(true);  // make the frame visible
    }

    // database connection
    private void saveDataToFile() {
        try {
            File file = new File("D:\\data.txt");
            FileWriter fw = new FileWriter(file);

            // Write header (column names)
            StringBuilder header = new StringBuilder();
            for (int i = 0; i < table.getColumnCount(); i++) {
                header.append(table.getColumnName(i));
                if (i < table.getColumnCount() - 1) {
                    header.append(",");
                }
            }
            fw.write(header.toString() + "\n");

            // Write rows
            for (int row = 0; row < table.getRowCount(); row++) {
                StringBuilder rowString = new StringBuilder();
                for (int col = 0; col < table.getColumnCount(); col++) {
                    Object value = table.getValueAt(row, col);
                    rowString.append(value.toString());
                    if (col < table.getColumnCount() - 1) {
                        rowString.append(",");
                    }
                }
                fw.write(rowString.toString() + "\n");
            }

            fw.close();
            JOptionPane.showMessageDialog(this, "Data saved successfully to cake_data.csv", "Save Successful", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error saving data: " + e.getMessage(), "Save Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void loadDataFromFile(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            // Read header line
            br.readLine(); // Assuming first line is header and skipping it

            // Read data lines
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == table.getColumnCount()) {
                    tableModel.addRow(data);
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error loading data from file: " + e.getMessage(), "Load Error", JOptionPane.ERROR_MESSAGE);
        }
    }


    // --------------------------------------------------------------------------------

    private void clearImagePanel() {
        imagePanel.setImage(null); // Set the image in the ImagePanel to null
        JOptionPane.showMessageDialog(CakeForm.this, "Your Image Store In DataBase");
    }

    private void recalculateTotal() {
        totalValue = 0.0;
        for (int i = 0; i < tableModel.getRowCount(); i++) {
            String priceStr = (String) tableModel.getValueAt(i, 4);
            String qtyStr = (String) tableModel.getValueAt(i, 6);
            double price = Double.parseDouble(priceStr.replace("$", ""));
            int qty = Integer.parseInt(qtyStr);
            totalValue += price * qty;
        }
        total.setText(String.format("$%.2f", totalValue));
    }

    private void updateTxtIdCount() {
        txtIdCount = 1;
    }

    public void actionPerformed(ActionEvent ar) {
        if (ar.getSource() == btnLoadImage) {
            loadImage();
        } else if (ar.getSource() == btnAdd) {
            addCake();
            saveDataToFile();
        } else if (ar.getSource() == btnClear) {
            clearTotalValue();
            clearForm();
            clearFormNext();
        } else if (ar.getSource() == btnExit) {
            System.exit(0);
        } else if (ar.getSource() == btnUpdate) {
            UpdateCake();
        } else if (ar.getSource() == btnSave) {
            selectRow();
            clearFormNext();
            clearImagePanel();
            saveDataToFile();
        } else if (ar.getSource() == btnDelete) {
            deleteCake();
            saveDataToFile();
        }
    }


    private void deleteItem() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select a row to delete.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        tableModel.removeRow(selectedRow);

        // Update total value
        double totalValue = 0.0;
        for (int i = 0; i < tableModel.getRowCount(); i++) {
            String priceStr = (String) tableModel.getValueAt(i, 4);
            int qty = (int) tableModel.getValueAt(i, 6);
            double priceValue = Double.parseDouble(priceStr.replace("$", ""));
            totalValue += priceValue * qty;
        }
        total.setText(String.format("$%.2f", totalValue));
    }

    private BufferedImage getImageForSelectedRow() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow != -1) {
            // Retrieve the image associated with the selected row
            // For simplicity, let's assume the image is stored in a specific column, adjust this according to your table structure
            // You need to replace "0" with the index of the column where the image is stored
            // You also need to handle the case where the image column contains the image path instead of the image itself
            String imagePath = (String) table.getValueAt(selectedRow, 0); // Replace "0" with the appropriate index
            if (imagePath != null) {
                try {
                    // Load the image from the file path
                    return ImageIO.read(new File(imagePath));
                } catch (IOException ex) {
                    ex.printStackTrace();
                    // Handle error
                }
            }
        }
        return null;
    }

    private void setCurrentDateTime() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = now.format(formatter);
        txtDate.setText(formattedDateTime);
    }

    private double totalValue = 0.0;
    private void updateTotal() {
        // Get the index of the newly added row
        int newRow = tableModel.getRowCount() - 1;

        // Get the quantity and price of the newly added item
        String qtyString = (String) tableModel.getValueAt(newRow, 6);
        String priceString = (String) tableModel.getValueAt(newRow, 4);

        // Calculate the total value for the newly added item
        if (qtyString != null && priceString != null) {
            int cakeQty = Integer.parseInt(qtyString);
            double cakePrice = Double.parseDouble(priceString.substring(1)); // Remove the "$" sign
            totalValue += cakeQty * cakePrice;
        }

        // Update the total text field
        total.setText(String.format("$%.2f", totalValue));
    }

    private void deleteCake() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow != -1) {
            int response = JOptionPane.showConfirmDialog(
                    CakeForm.this,
                    "Are you sure you want to delete this Data?",
                    "Confirm Deletion",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.WARNING_MESSAGE
            );

            if (response == JOptionPane.YES_OPTION) {
                tableModel.removeRow(selectedRow); // Remove the selected row from the table model
            }
        } else {
            JOptionPane.showMessageDialog(CakeForm.this, "Please select a row to delete.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void selectRow() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow != -1) {
            // Get the updated row data
            String newId = txtid.getText();
            String newName = txtName.getText();
            String newGender = ch_gender.getSelectedItem();
            String newSize = ch_size.getSelectedItem();
            String newPrice = ch_Price.getSelectedItem();
            String newPhone = txtPhone.getText();
            String newQty = txtqty.getText();
            String newDate = txtDate.getText();

            // Update the values for the selected row
            tableModel.setValueAt(newId, selectedRow, 0);
            tableModel.setValueAt(newName, selectedRow, 1);
            tableModel.setValueAt(newGender, selectedRow, 2);
            tableModel.setValueAt(newSize, selectedRow, 3);
            tableModel.setValueAt(newPrice, selectedRow, 4);
            tableModel.setValueAt(newPhone, selectedRow, 5);
            tableModel.setValueAt(newQty, selectedRow, 6);
            tableModel.setValueAt(newDate, selectedRow, 7);

            // Update the total based on the updated row data
//            updateTotal();

            recalculateTotal();

            // Clear the text fields and reset button properties
            clearForm();

            // Clear the selection to allow updating subsequent rows
            table.clearSelection();
        } else {
            JOptionPane.showMessageDialog(CakeForm.this, "Please select a row to update.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void UpdateCake() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow != -1) {
            // Get data from the selected row in the table
            String id = (String) table.getValueAt(selectedRow, 0);
            String name = (String) table.getValueAt(selectedRow, 1);
            String gender = (String) table.getValueAt(selectedRow, 2);
            String size = (String) table.getValueAt(selectedRow, 3);
            String price = (String) table.getValueAt(selectedRow, 4);
            String phone = (String) table.getValueAt(selectedRow, 5);
            String qty = (String) table.getValueAt(selectedRow, 6);
            String date = (String) table.getValueAt(selectedRow, 7);

            // Populate the text fields with the selected row data
            txtid.setText(id);
            txtName.setText(name);
            ch_gender.select(gender);
            ch_size.select(size);
            ch_Price.select(price);
            txtPhone.setText(phone);
            txtqty.setText(qty);
            txtDate.setText(date);

            // Update the total based on the updated row data
//            updateTotal();
        }
    }

    private void sortTableByIdDescending() {
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(tableModel);
        sorter.setComparator(0, Comparator.comparingInt(id -> Integer.parseInt((String) id)).reversed());
        table.setRowSorter(sorter);
    }

    private void addCake() {
        String id = txtid.getText();
        String name = txtName.getText();
        String gender = ch_gender.getSelectedItem();
        String size = ch_size.getSelectedItem();
        String price = ch_Price.getSelectedItem();
        String phone = txtPhone.getText();
        String qty = txtqty.getText();
        String date = txtDate.getText();

        totalValue = 0.0;

        // Get the current date and time and format it
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = now.format(formatter);
        txtDate.setText(formattedDateTime);  // Set current date and time in txtDate

        sortTableByIdDescending();

        Object[] row = {id, name, gender, size, price, phone, qty, date};
        tableModel.addRow(row);

        updateTotal();
        clearImagePanel();

        clearForm();
        setCurrentDateTime();
    }

    private void loadImage() {
        FileDialog fileDialog = new FileDialog(this, "Select Image File", FileDialog.LOAD);
        fileDialog.setVisible(true);

        String filename = fileDialog.getFile();
        if (filename != null) {
            String imagePath = fileDialog.getDirectory() + filename;
            try {
                // Load the image from file
                BufferedImage image = ImageIO.read(new File(imagePath));
                // Display the image in the ImagePanel
                imagePanel.setImage(image);
            } catch (Exception ex) {
                ex.printStackTrace();
                // Handle error
            }
        }
    }

    private void clearTotalValue() {
        double total = 0.0;
        for (int row = 0; row < tableModel.getRowCount(); row++) {
            String qtyString = (String) tableModel.getValueAt(row, 6);
            String priceString = (String) tableModel.getValueAt(row, 4);
            if (qtyString != null && priceString != null) {
                int cakeQty = Integer.parseInt(qtyString);
                double cakePrice = Double.parseDouble(priceString.substring(1)); // Remove the "$" sign
                total=0.00;
            }
        }
        totalValue = total;
        this.total.setText(String.format("$%.2f", total));
    }

    private void clearForm() {
//        txtid.setText("");
        txtName.setText("");
        ch_gender.select(0);
        ch_size.select(0);
        ch_Price.select(0);
        txtPhone.setText("");
        txtqty.setText("");
        txtIdCount++; // Increment the counter
        txtid.setText(String.valueOf(Integer.valueOf(txtIdCount)));
    }

    private void clearFormNext() {
//        txtid.setText("");
        txtName.setText("");
        ch_gender.select(0);
        ch_size.select(0);
        ch_Price.select(0);
        txtPhone.setText("");
        txtqty.setText("");
        txtIdCount--; // Decrement the counter
        txtid.setText(String.valueOf(Integer.valueOf(txtIdCount)));
    }

    public static void main(String[] args) {
        new CakeForm("Lucky Cake Store");
    }

    // Inner class to handle image display
    class ImagePanel extends JPanel {
        private BufferedImage image;

        public void setImage(BufferedImage img) {
            image = img;
            repaint();
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (image != null) {
                int panelWidth = getWidth();
                int panelHeight = getHeight();
                int imageWidth = image.getWidth();
                int imageHeight = image.getHeight();

                // Calculate the scaling factors to fit the image in the panel
                double scaleX = (double) panelWidth / imageWidth;
                double scaleY = (double) panelHeight / imageHeight;
                double scale = Math.max(scaleX, scaleY);

                // Calculate the new dimensions for the scaled image
                int scaledWidth = (int) (imageWidth * scale);
                int scaledHeight = (int) (imageHeight * scale);

                // Calculate the position to center the image
                int x = (panelWidth - scaledWidth) / 2;
                int y = (panelHeight - scaledHeight) / 2;

                // Draw the scaled image
                g.drawImage(image, x, y, scaledWidth, scaledHeight, this);
            }
        }
    }
}