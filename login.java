package Assignment;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class login extends JFrame implements ActionListener {
    private JLabel title = new JLabel("FORM LOGIN");
    private JLabel lbEmail = new JLabel("Email :");
    private JTextField txtEmail = new JTextField();
    private JLabel lbPass = new JLabel("Password :");
    private JPasswordField txtPass = new JPasswordField(10);
    private JButton btnLogin = new JButton("Login");
    private JButton btnExit = new JButton("Exit");
    private JLabel lbReg = new JLabel("Click here for registering!");

    private String registeredEmail;
    private String registeredPassword;

    public login(String email, String password) {
        this.registeredEmail = email;
        this.registeredPassword = password;

        this.setTitle("Form Login");

        this.setSize(470, 460);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setResizable(false);

        JPanel contentPane = new JPanel();
        contentPane.setLayout(null);
        contentPane.setBackground(new Color(123, 104, 238));
        this.setContentPane(contentPane);

        btnLogin.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                btnLogin.setBackground(Color.GREEN);
            }

            public void mouseExited(MouseEvent e) {
                btnLogin.setBackground(UIManager.getColor("Button.background"));
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

        btnLogin.addActionListener(this);
        btnExit.addActionListener(this);

        contentPane.add(title);
        title.setFont(new Font("TimesRoman", Font.BOLD, 30));
        title.setBounds(130, 10, 200, 50);
        title.setForeground(Color.WHITE);

        contentPane.add(lbEmail);
        lbEmail.setBounds(50, 50, 80, 100);
        lbEmail.setFont(new Font("TimesRoman", Font.BOLD, 18));
        lbEmail.setForeground(Color.WHITE);

        contentPane.add(txtEmail);
        txtEmail.setBounds(200, 85, 200, 30);
        txtEmail.setFont(new Font("TimesRoman",Font.PLAIN,16));

        contentPane.add(lbPass);
        lbPass.setBounds(50, 100, 100, 100);
        lbPass.setFont(new Font("TimesRoman", Font.BOLD, 18));
        lbPass.setForeground(Color.WHITE);

        contentPane.add(txtPass);
        txtPass.setBounds(200, 135, 200, 30);
        txtPass.setFont(new Font("TimesRoman",Font.PLAIN,16));

        contentPane.add(btnLogin);
        contentPane.add(btnExit);
        btnLogin.setBounds(120, 200, 100, 30);
        btnExit.setBounds(250, 200, 100, 30);

        contentPane.add(lbReg);
        lbReg.setBounds(150, 230, 180, 50);
        lbReg.setFont(new Font("TimesRoman", Font.BOLD, 14));
        lbReg.setForeground(Color.WHITE);

        lbReg.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                lbReg.setForeground(Color.YELLOW);
            }

            public void mouseExited(MouseEvent e) {
                lbReg.setForeground(Color.WHITE);
            }

            public void mouseClicked(MouseEvent e) {
                new register();
                dispose();
            }
        });

        this.setBackground(Color.MAGENTA);
        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == btnLogin) {
            String email = txtEmail.getText();
            String password = new String(txtPass.getPassword());

            Border originalBorder = txtEmail.getBorder();

            boolean valid = true;

            if (!email.equals(registeredEmail)) {
                txtEmail.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
                valid = false;
            } else {
                txtEmail.setBorder(originalBorder);
            }

            if (!password.equals(registeredPassword)) {
                txtPass.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
                valid = false;
            } else {
                txtPass.setBorder(originalBorder);
            }

            if (valid) {
                CakeForm cake = new CakeForm("");
                cake.setVisible(true);
                this.dispose();
            } else {
                if (!email.equals(registeredEmail)) {
                    JOptionPane.showMessageDialog(this, "Wrong email!");
                } else if(!password.equals(registeredPassword)) {
                    JOptionPane.showMessageDialog(this, "Wrong password!");
                } else if (!email.equals(registeredEmail) && !password.equals(registeredPassword)) {
                    JOptionPane.showMessageDialog(this, "Wrong email and password!");
                }
            }
        }
        if(ae.getSource()==btnExit) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new login("ruppjava@gmail.com", "Rupp168");
    }
}
