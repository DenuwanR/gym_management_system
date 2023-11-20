package gym;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class Home extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Home frame = new Home();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Home() {
    	setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 950, 650);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(null);
        setContentPane(contentPane);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(112, 128, 144));
        panel.setBounds(0, 0, 936, 613);
        panel.setLayout(null);
        contentPane.add(panel);
        
        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Denuwan\\Downloads\\Mountain_Health___Fitness_Logo__2_-removebg-preview (1).png"));
        lblNewLabel.setBounds(204, 10, 475, 234);
        panel.add(lblNewLabel);
        
        JButton btnMember = new JButton("Member Management");
        btnMember.setIcon(null);
        btnMember.setBackground(new Color(0, 128, 128));
        btnMember.setFont(new Font("Tahoma", Font.BOLD, 18));
        btnMember.setBounds(98, 295, 265, 40);
        panel.add(btnMember);
        btnMember.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
              new Member().setVisible(true);
              dispose();
            }
        });
        
        JButton btnTrainerManagement = new JButton("Trainer Management");
        btnTrainerManagement.setBackground(new Color(0, 128, 128));
        btnTrainerManagement.setFont(new Font("Tahoma", Font.BOLD, 18));
        btnTrainerManagement.setBounds(496, 295, 265, 40);
        panel.add(btnTrainerManagement);
        btnTrainerManagement.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
              new Trainer().setVisible(true);
              dispose();
            }
        });
        
        JButton btnReservations = new JButton("Reservations");
        btnReservations.setBackground(new Color(0, 128, 128));
        btnReservations.setIcon(null);
        btnReservations.setFont(new Font("Tahoma", Font.BOLD, 18));
        btnReservations.setBounds(98, 415, 265, 40);
        panel.add(btnReservations);
        btnReservations.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
              new Reservation().setVisible(true);
              dispose();
            }
        });
        
        JButton btnPayments = new JButton("Payments");
        btnPayments.setBackground(new Color(0, 128, 128));
        btnPayments.setFont(new Font("Tahoma", Font.BOLD, 18));
        btnPayments.setBounds(496, 415, 265, 40);
        panel.add(btnPayments);
        btnPayments.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
              new Payments().setVisible(true);
              dispose();
            }
        });
        
        JButton btnLogOut = new JButton("Log Out");
        btnLogOut.setForeground(new Color(255, 0, 0));
        btnLogOut.setFont(new Font("Tahoma", Font.BOLD, 18));
        btnLogOut.setBounds(361, 519, 131, 40);
        panel.add(btnLogOut);
        
        JLabel lblNewLabel_1 = new JLabel("W  e  l  n  e  s  s    S  i  m  p  l  i  f  i  e  d");
        lblNewLabel_1.setFont(new Font("Segoe Print", Font.PLAIN, 18));
        lblNewLabel_1.setBounds(249, 190, 447, 38);
        panel.add(lblNewLabel_1);
        btnLogOut.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
              new Login().setVisible(true);
              dispose();
            }
        });
    }
    

    private Point mouseOffset;

    private void makeDraggable(final Component component) {
    }
}
