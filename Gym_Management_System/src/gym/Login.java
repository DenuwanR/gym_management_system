package gym;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class Login extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JPasswordField passwordField;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Login frame = new Login();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Login() {
    	setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 850, 600);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout()); // Use BorderLayout to divide the frame

        JPanel leftPanel = new JPanel();
        leftPanel.setBackground(new Color(0, 102, 102));
        leftPanel.setLayout(null);
        leftPanel.setPreferredSize(new Dimension(245, 560)); // Set preferred size for left panel
        contentPane.add(leftPanel, BorderLayout.WEST);
        
        JLabel lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Denuwan\\Downloads\\Mountain_Health___Fitness_Logo__2_-removebg-preview c2.png"));
        lblNewLabel_1.setBounds(10, 111, 222, 174);
        leftPanel.add(lblNewLabel_1);
        
        JLabel lblNewLabel_2 = new JLabel("W e l n e s s  S i m p l i f i e d");
        lblNewLabel_2.setFont(new Font("Segoe Print", Font.PLAIN, 14));
        lblNewLabel_2.setBounds(10, 295, 230, 20);
        leftPanel.add(lblNewLabel_2);
        
        JLabel lblNewLabel_4 = new JLabel("© All Rights Reserved 2023");
        lblNewLabel_4.setForeground(new Color(139, 133, 137));
        lblNewLabel_4.setFont(new Font("Lucida Bright", Font.BOLD, 12));
        lblNewLabel_4.setBounds(10, 522, 222, 28);
        leftPanel.add(lblNewLabel_4);
        
        JLabel lblNewLabel_4_1 = new JLabel("Denuwan Rathnayake");
        lblNewLabel_4_1.setForeground(new Color(139, 133, 137));
        lblNewLabel_4_1.setFont(new Font("Lucida Bright", Font.BOLD, 12));
        lblNewLabel_4_1.setBounds(10, 504, 194, 28);
        leftPanel.add(lblNewLabel_4_1);
        
      

        JPanel rightPanel = new JPanel();
        rightPanel.setBackground(new Color(245, 245, 220));
        rightPanel.setLayout(null); // Use null layout for manual positioning of components
        contentPane.add(rightPanel, BorderLayout.CENTER); // Add right panel to the center

        // Add movable JLabels and JTextFields to the right panel
        JLabel label1 = new JLabel("Username :");
        label1.setFont(new Font("Bahnschrift", Font.BOLD, 22));
        label1.setBounds(89, 206, 130, 30);
        makeDraggable(label1);
        rightPanel.add(label1);

        JTextField textField1 = new JTextField();
        textField1.setFont(new Font("Tahoma", Font.PLAIN, 20));
        textField1.setBounds(250, 201, 198, 35);
        makeDraggable(textField1);
        rightPanel.add(textField1);
        
        JLabel lblNewLabel = new JLabel("Administrator Login");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 28));
        lblNewLabel.setBounds(145, 86, 340, 58);
        rightPanel.add(lblNewLabel);
        
        JLabel lblPassword = new JLabel("Password :");
        lblPassword.setFont(new Font("Bahnschrift", Font.BOLD, 22));
        lblPassword.setBounds(90, 294, 129, 30);
        rightPanel.add(lblPassword);
        
        
        //username = admin & password = 1234
        JButton btnLogin = new JButton("Login");
        btnLogin.setForeground(new Color(240, 240, 240));
        btnLogin.setBackground(new Color(0, 102, 102));
        btnLogin.setFont(new Font("Tahoma", Font.BOLD, 20));
        btnLogin.setBounds(283, 394, 109, 30);
        rightPanel.add(btnLogin);
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = textField1.getText();
                String password = new String(passwordField.getPassword());

                // Check if username and password are correct
                if (username.equals("admin") && password.equals("1234")) {
                    // Open the home interface
                    Home home = new Home();
                    home.setVisible(true);
                    dispose(); 
                } else {
                    // Display an error message for invalid username or password
                    JOptionPane.showMessageDialog(Login.this, "Invalid username or password", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        passwordField = new JPasswordField();
        passwordField.setFont(new Font("Tahoma", Font.PLAIN, 20));
        passwordField.setBounds(250, 290, 198, 35);
        rightPanel.add(passwordField);
        
        JLabel lblNewLabel_3 = new JLabel("Need Any Help ? Please Contact - ");
        lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 13));
        lblNewLabel_3.setBounds(145, 521, 186, 23);
        rightPanel.add(lblNewLabel_3);
        
        JLabel lblNewLabel_3_1 = new JLabel("076 88 65 169");
        lblNewLabel_3_1.setForeground(new Color(0, 0, 255));
        lblNewLabel_3_1.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblNewLabel_3_1.setBounds(330, 520, 186, 23);
        rightPanel.add(lblNewLabel_3_1);

        setContentPane(contentPane);
    }

    private void makeDraggable(final Component component) {
    }
}

