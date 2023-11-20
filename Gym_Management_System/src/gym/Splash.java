package gym;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class Splash extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Splash frame = new Splash();
                    frame.setVisible(true);
                    // Set a timer to close the splash screen after 3 seconds
                    Timer timer = new Timer(3000, new ActionListener() {
                        public void actionPerformed(ActionEvent arg0) {
                            frame.dispose(); // Close the splash screen
                            openLoginInterface(); // Open the login interface
                        }
                    });
                    timer.setRepeats(false); // Set to run only once
                    timer.start(); // Start the timer
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Splash() {
    	setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 850, 615);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(null);
        setContentPane(contentPane);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(64, 128, 128));
        panel.setBounds(0, 0, 836, 578);
        panel.setLayout(null);
        contentPane.add(panel);
        
        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Denuwan\\Downloads\\Mountain_Health___Fitness_Logo__2_-removebg-preview (1).png"));
        lblNewLabel.setBounds(151, 45, 475, 234);
        panel.add(lblNewLabel);
        
        JLabel lblNewLabel_1 = new JLabel("W  e  l  n  e  s  s    S  i  m  p  l  i  f  i  e  d");
        lblNewLabel_1.setForeground(new Color(255, 255, 255));
        lblNewLabel_1.setFont(new Font("Segoe Print", Font.PLAIN, 20));
        lblNewLabel_1.setBounds(192, 243, 490, 38);
        panel.add(lblNewLabel_1);
        
        JProgressBar progressBar = new JProgressBar();
        progressBar.setForeground(new Color(223, 223, 0));
        progressBar.setIndeterminate(true);
        progressBar.setValue(1);
        progressBar.setBounds(0, 555, 836, 23);
        panel.add(progressBar);
        
        JLabel lblNewLabel_1_1 = new JLabel("Gym Management System");
        lblNewLabel_1_1.setForeground(new Color(192, 192, 192));
        lblNewLabel_1_1.setFont(new Font("Perpetua", Font.PLAIN, 25));
        lblNewLabel_1_1.setBounds(296, 426, 238, 38);
        panel.add(lblNewLabel_1_1);
        
        JLabel lblNewLabel_1_1_1 = new JLabel("MADSE224F-026");
        lblNewLabel_1_1_1.setForeground(new Color(97, 97, 97));
        lblNewLabel_1_1_1.setFont(new Font("Perpetua", Font.PLAIN, 14));
        lblNewLabel_1_1_1.setBounds(368, 516, 93, 29);
        panel.add(lblNewLabel_1_1_1);
        
        JLabel lblNewLabel_1_1_1_1 = new JLabel("Denuwan Rathnayake");
        lblNewLabel_1_1_1_1.setForeground(new Color(97, 97, 97));
        lblNewLabel_1_1_1_1.setFont(new Font("Perpetua", Font.PLAIN, 17));
        lblNewLabel_1_1_1_1.setBounds(347, 501, 146, 23);
        panel.add(lblNewLabel_1_1_1_1);
    }
    
    private static void openLoginInterface() {
        // Code to open the login interface goes here
        // For example:
        Login login = new Login();
        login.setVisible(true);
    }

    private Point mouseOffset;

    private void makeDraggable(final Component component) {
    }
}
