package Assignment;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;

public class PersonalInfo extends JFrame implements ActionListener {
    JCheckBox jbx1, jbx2, jbx3, jbx4, jbx5, jbx6, jbx7;  // Create checkboxes for 7 people
    JLabel idLabel, nameLabel, genderLabel, dobLabel, departmentLabel, majorLabel, yearLabel, emailLabel, imageLabel, titleLabel;
    JPanel containerPanel, topPanel, leftPanel, rightPanel, imagePanel;
    String defaultImagePath = "D:\\edit\\pic.png";
    Font khmerFont;

    PersonalInfo(String title) {
        super(title);
        setSize(830, 620); // Size of layout
        containerPanel = new JPanel();
        containerPanel.setLayout(null);
        containerPanel.setBounds(0, 0, 830, 620);
        containerPanel.setBackground(new Color(255, 204, 229));

        setResizable(false);
        setLocationRelativeTo(null);  // Center window on the screen
        addWindowListener(new WindowAdapter() {  // Event closing window
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        // Load Khmer font
        try {
            khmerFont = new Font("Khmer OS", Font.BOLD, 20);
        } catch (Exception e) {
            khmerFont = new Font("Arial", Font.PLAIN, 20);
        }

        // Initialize checkboxes with names
        jbx1 = new JCheckBox("លិញ សុខហេង");
        jbx2 = new JCheckBox("សំ រដ្ឋា");
        jbx3 = new JCheckBox("លាង ស៊ាងហួ");
        jbx4 = new JCheckBox("វ៉ាត លីផាត់");
        jbx5 = new JCheckBox("រ៉េត វណ្ណដេត");
        jbx6 = new JCheckBox("វិបុល សុខលីម");
        jbx7 = new JCheckBox("សំណាង សុខវិជ្ជា");

        // Initialize labels for displaying information
        idLabel = new JLabel("", JLabel.CENTER);
        nameLabel = new JLabel("", JLabel.LEFT);
        genderLabel = new JLabel("", JLabel.LEFT);
        dobLabel = new JLabel("", JLabel.LEFT);
        departmentLabel = new JLabel("", JLabel.LEFT);
        majorLabel = new JLabel("", JLabel.LEFT);
        yearLabel = new JLabel("", JLabel.LEFT);
        emailLabel = new JLabel("", JLabel.LEFT);
        imageLabel = new JLabel("", JLabel.LEFT);

        // Set fonts for labels, checkboxes, and title
        Font titleFont = new Font("Khmer OS", Font.BOLD, 24);
        Font labelFont = new Font("Khmer OS", Font.PLAIN, 20);

        idLabel.setFont(new Font("Khmer OS", Font.BOLD, 18));
        nameLabel.setFont(labelFont);
        genderLabel.setFont(labelFont);
        dobLabel.setFont(labelFont);
        departmentLabel.setFont(labelFont);
        majorLabel.setFont(labelFont);
        yearLabel.setFont(labelFont);
        emailLabel.setFont(labelFont);
        imageLabel.setFont(labelFont);

        jbx1.setFont(labelFont);
        jbx2.setFont(labelFont);
        jbx3.setFont(labelFont);
        jbx4.setFont(labelFont);
        jbx5.setFont(labelFont);
        jbx6.setFont(labelFont);
        jbx7.setFont(labelFont);

        // Initialize and set the title label
        titleLabel = new JLabel("ប្រវត្តិរូបសង្ខេប", JLabel.CENTER);
        titleLabel.setFont(titleFont);

        // Add action listeners to checkboxes
        jbx1.addActionListener(this);
        jbx2.addActionListener(this);
        jbx3.addActionListener(this);
        jbx4.addActionListener(this);
        jbx5.addActionListener(this);
        jbx6.addActionListener(this);
        jbx7.addActionListener(this);

        // Set layout for the main frame
        setLayout(null);

        // Create top panel for the title
        topPanel = new JPanel();
        topPanel.setLayout(new BorderLayout());
        topPanel.setBounds(10, 0, 790, 50);
        topPanel.add(titleLabel, BorderLayout.CENTER);

        // Create left panel for checkboxes
        leftPanel = new JPanel();
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
        leftPanel.setBounds(10, 60, 250, 510);
        leftPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));  // Adding padding
        leftPanel.add(jbx1);
        leftPanel.add(jbx2);
        leftPanel.add(jbx3);
        leftPanel.add(jbx4);
        leftPanel.add(jbx5);
        leftPanel.add(jbx6);
        leftPanel.add(jbx7);

        // Create right panel for displaying user information
        rightPanel = new JPanel();
        rightPanel.setLayout(null);
        rightPanel.setBounds(270, 60, 520, 510);

        // Create a panel for the image
        imagePanel = new JPanel();
        imagePanel.setLayout(new BorderLayout());
        imagePanel.setBounds(185, 10, 160, 170);
        imagePanel.setSize(160,190);
        imagePanel.setBackground(Color.GRAY);
        imagePanel.add(imageLabel, BorderLayout.CENTER);
        imagePanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        rightPanel.add(imagePanel);
        // Set bounds for labels of information
        idLabel.setBounds(10, 210, 480, 30);
        nameLabel.setBounds(120, 270, 480, 30);
        genderLabel.setBounds(120, 300, 480, 30);
        dobLabel.setBounds(120, 330, 480, 30);
        departmentLabel.setBounds(120, 360, 480, 30);
        majorLabel.setBounds(120, 390, 480, 30);
        yearLabel.setBounds(120, 420, 480, 30);
        emailLabel.setBounds(120, 450, 480, 30);

        rightPanel.add(idLabel);
        rightPanel.add(nameLabel);
        rightPanel.add(genderLabel);
        rightPanel.add(dobLabel);
        rightPanel.add(departmentLabel);
        rightPanel.add(majorLabel);
        rightPanel.add(yearLabel);
        rightPanel.add(emailLabel);

        // Set background color for the checkbox labels
        jbx1.setBackground(new Color(255, 204, 229));
        jbx1.setOpaque(true);

        jbx2.setBackground(new Color(255, 204, 229));
        jbx2.setOpaque(true);

        jbx3.setBackground(new Color(255, 204, 229));
        jbx3.setOpaque(true);

        jbx4.setBackground(new Color(255, 204, 229));
        jbx4.setOpaque(true);

        jbx5.setBackground(new Color(255, 204, 229));
        jbx5.setOpaque(true);

        jbx6.setBackground(new Color(255, 204, 229));
        jbx6.setOpaque(true);

        jbx7.setBackground(new Color(255, 204, 229));
        jbx7.setOpaque(true);

        topPanel.setBackground(new Color(255, 204, 229));
        leftPanel.setBackground(new Color(255, 204, 229));
        rightPanel.setBackground(new Color(255, 255, 255));

        // Add existing panels to the containerPanel
        containerPanel.add(topPanel);
        containerPanel.add(leftPanel);
        containerPanel.add(rightPanel);
        add(containerPanel);

        // Set the default image
        updateUserInfo("", "", "", "", "", "", "", "", defaultImagePath);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        // Deselect all checkboxes
        jbx1.setSelected(false);
        jbx2.setSelected(false);
        jbx3.setSelected(false);
        jbx4.setSelected(false);
        jbx5.setSelected(false);
        jbx6.setSelected(false);
        jbx7.setSelected(false);

        // Select the checkbox that triggered the event
        JCheckBox selectedCheckbox = (JCheckBox) ae.getSource();
        selectedCheckbox.setSelected(true);

        // Determine which checkbox was selected and update the information accordingly
        if (selectedCheckbox == jbx1) {
            updateUserInfo("51907", "Linh SokHeng", "Male", "10 Dec 2004", "IT", "Computer Science", "2", "heng1900@gmail.com", "D:\\edit\\ហេង.jpg");
        } else if (selectedCheckbox == jbx2) {
            updateUserInfo("45713", "Sam Rotha", "Female", "29 Oct 2003", "IT", "Computer Science", "2", "rotha1900@gmail.com", "D:\\edit\\rotha.JPEG");
        } else if (selectedCheckbox == jbx3) {
            updateUserInfo("51146", "Leang SeangHuor", "Female", "11 Jan 2002", "IT", "Computer Science", "2", "huor1900@gmail.com", "D:\\edit\\hour.jpg");
        } else if (selectedCheckbox == jbx4) {
            updateUserInfo("51569", "Vath LyPhat", "Male", "14 June 2003", "IT", "Computer Science", "2", "phat1900@gmail.com", "D:\\edit\\pic.png");
        } else if (selectedCheckbox == jbx5) {
            updateUserInfo("48357", "Reth VanDeth", "Male", "31 Oct 2005", "IT", "Computer Science", "2", "vandeth1900@gmail.com", "D:\\edit\\deth.png");
        } else if (selectedCheckbox == jbx6) {
            updateUserInfo("46203", "Vibol SokLim", "Male", "24 Dec 2004", "Information Technology", "Computer Science", "2", "vibol1900@gmail.com", "D:\\edit\\lim.jpg");
        } else if (selectedCheckbox == jbx7) {
            updateUserInfo("46489", "Samnang SokVichea", "Male", "06 Dec 2004", "IT", "Computer Science", "2", "vichea1900@gmail.com", "D:\\edit\\vichea.jpg");
        } else {
            // If no checkbox is selected, reset to the default image
            updateUserInfo("", "", "", "", "", "", "", "", defaultImagePath);
        }
    }

    private void updateUserInfo(String id, String name, String gender, String dob, String department, String major, String year, String email, String imagePath) {
        idLabel.setText("  ID  " + ":  " + id);
        nameLabel.setText("Name         " + ":   " + name);
        genderLabel.setText("Gender       " + ":   " + gender);
        dobLabel.setText("DOB           " + ":   " + dob);
        departmentLabel.setText("Department " + ":   " + department);
        majorLabel.setText("Major          " + ":   " + major);
        yearLabel.setText("Year           " + ":   " + year);
        emailLabel.setText("Email          " + ":   " + email);
        imageLabel.setIcon(new ImageIcon(new ImageIcon(imagePath).getImage().getScaledInstance(150, 180, Image.SCALE_SMOOTH)));
    }

    public static void main(String[] args) throws Exception {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        new PersonalInfo("ប្រវត្តិរូបសង្ខេបសមាជិកក្រុម");
    }
}
