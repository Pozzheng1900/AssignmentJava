package Assignment;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class register extends JFrame implements ActionListener {
    private JLabel title = new JLabel("FORM REGISTER");
    private JLabel lbEmail = new JLabel("Email :");
    private JTextField txtEmail = new JTextField();
    private JLabel lbPass = new JLabel("Password :");
    private JPasswordField txtPass = new JPasswordField();
    private JLabel lbCfPass = new JLabel("Confirm PW :");
    private JPasswordField txtCfPass = new JPasswordField();
    private JButton btnReg = new JButton("Register");
    private JButton btnExit = new JButton("Exit");
    private JLabel lbReg = new JLabel("Click here for login!");

    public register() {
        this.setSize(470, 460);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setTitle("Form Register");
        JPanel contentPane = new JPanel();
        contentPane.setLayout(null);
        contentPane.setBackground(new Color(255, 185, 15));
        this.setContentPane(contentPane);

        btnReg.addActionListener(this);
        btnExit.addActionListener(this);

        contentPane.add(title);
        title.setFont(new Font("TimesRoman", Font.BOLD, 30));
        title.setBounds(100, 10, 280, 50);

        contentPane.add(lbEmail);
        lbEmail.setBounds(50, 50, 80, 100);
        lbEmail.setFont(new Font("TimesRoman", Font.BOLD, 18));

        contentPane.add(txtEmail);
        txtEmail.setBounds(200, 85, 200, 30);
        txtEmail.setFont(new Font("TimesRoman",Font.PLAIN,16));

        contentPane.add(lbPass);
        lbPass.setBounds(50, 100, 100, 100);
        lbPass.setFont(new Font("TimesRoman", Font.BOLD, 18));

        contentPane.add(txtPass);
        txtPass.setBounds(200, 135, 200, 30);
        txtPass.setFont(new Font("TimesRoman",Font.PLAIN,16));

        contentPane.add(lbCfPass);
        lbCfPass.setBounds(50, 150, 130, 100);
        lbCfPass.setFont(new Font("TimesRoman", Font.BOLD, 18));

        contentPane.add(txtCfPass);
        txtCfPass.setBounds(200, 185, 200, 30);

        contentPane.add(btnReg);
        contentPane.add(btnExit);
        btnReg.setBounds(120, 250, 100, 30);
        btnExit.setBounds(250, 250, 100, 30);

        contentPane.add(lbReg);
        lbReg.setBounds(170, 280, 150, 50);
        lbReg.setFont(new Font("TimesRoman", Font.BOLD, 14));
        lbReg.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                lbReg.setForeground(Color.WHITE);
            }

            public void mouseExited(MouseEvent e) {
                lbReg.setForeground(Color.BLACK);
            }

            public void mouseClicked(MouseEvent e) {
                new login("", "");
                dispose();
            }
        });

        btnReg.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                btnReg.setBackground(Color.GREEN);
            }

            public void mouseExited(MouseEvent e) {
                btnReg.setBackground(UIManager.getColor("Button.background"));
//                btnReg.setForeground(UIManager.getColor("Button.Foreground"));
            }
        });

        btnExit.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                btnExit.setBackground(Color.RED);
                btnExit.setForeground(Color.white);
            }

            public void mouseExited(MouseEvent e) {
                btnExit.setBackground(UIManager.getColor("Button.background"));
                btnExit.setForeground(UIManager.getColor("Button.Foreground"));
            }
        });

        this.setVisible(true);
    }
    public String getEmail() {
        return txtEmail.getText();
    }
    public String getPassword() {
        return new String(txtPass.getPassword());
    }
    public String getConfirmPassword() {
        return new String(txtCfPass.getPassword());
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == btnReg) {
            String email = getEmail();
            String password = getPassword();
            String confirmPassword = getConfirmPassword();

            if(email.isEmpty() && password.isEmpty() && confirmPassword.isEmpty()) {
                JOptionPane.showMessageDialog(this,"Email, Password and ConfirmPassword has Emptied");
                return;
            }

            else if (email.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please Input Email!");
                return;
            }

            else if(password.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please Input Password!");
                return;
            }

            else if(confirmPassword.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please Input Confirm Password!");
                return;
            }

            else if (!password.equals(confirmPassword)) {
                JOptionPane.showMessageDialog(this, "Passwords do not match!");
                return;
            }



            login log = new login(email, password);
            log.setVisible(true);
            this.dispose();
        }
        if(ae.getSource()==btnExit) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new register();
    }
}
