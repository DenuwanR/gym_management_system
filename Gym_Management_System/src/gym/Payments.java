package gym;

import java.awt.*;
import java.awt.event.*;
import java.awt.print.PrinterException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;

public class Payments extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Payments frame = new Payments();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Payments(){
    	setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 950, 650);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(null);
        setContentPane(contentPane);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(192, 192, 192));
        panel.setBounds(0, 0, 936, 613);
        panel.setLayout(null);
        contentPane.add(panel);
        
        JPanel panel_1 = new JPanel();
        panel_1.setBackground(new Color(0, 128, 128));
        panel_1.setBounds(0, 0, 149, 613);
        panel_1.setLayout(null);
        panel.add(panel_1);
        
        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Denuwan\\Downloads\\Mountain_Health___Fitness_Logo__2_-removebg-preview (1) rs cr.png"));
        lblNewLabel.setBounds(24, 0, 104, 118);
        panel_1.add(lblNewLabel);
        
        JButton btnBack = new JButton("Back");
        btnBack.setBackground(new Color(173, 216, 230));
        btnBack.setFont(new Font("Tahoma", Font.BOLD, 18));
        btnBack.setBounds(24, 566, 87, 28);
        panel_1.add(btnBack);
        
        JLabel lblNewLabel_2_1 = new JLabel("W e l n e s s  S i m p l i f i e d");
        lblNewLabel_2_1.setFont(new Font("Segoe Print", Font.PLAIN, 9));
        lblNewLabel_2_1.setBounds(5, 95, 182, 20);
        panel_1.add(lblNewLabel_2_1);
        
        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
              new Home().setVisible(true);
              dispose();
            }
        });
        
        JPanel panel_2 = new JPanel();
        panel_2.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        panel_2.setBackground(new Color(128, 128, 128));
        panel_2.setBounds(147, 0, 789, 41);
        panel_2.setLayout(null);
        panel.add(panel_2);
        
        JLabel lblNewLabel_1 = new JLabel("New label");
        panel_2.add(lblNewLabel_1);
        
        JLabel lblNewLabel_2 = new JLabel("Payments");
        lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 22));
        lblNewLabel_2.setBounds(336, 5, 139, 31);
        panel_2.add(lblNewLabel_2);
        
        JLabel lblNewLabel_3 = new JLabel("Member Name");
        lblNewLabel_3.setFont(new Font("Segoe UI Historic", Font.BOLD, 16));
        lblNewLabel_3.setBounds(188, 67, 123, 25);
        panel.add(lblNewLabel_3);
        
        JLabel lblNewLabel_3_2 = new JLabel("Month");
        lblNewLabel_3_2.setFont(new Font("Segoe UI Historic", Font.BOLD, 16));
        lblNewLabel_3_2.setBounds(188, 211, 65, 25);
        panel.add(lblNewLabel_3_2);
        
        JComboBox cmbMName = new JComboBox();
        cmbMName.setFont(new Font("Tahoma", Font.BOLD, 15));
        cmbMName.setBounds(356, 64, 176, 32);
        panel.add(cmbMName);
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/gym_database", "root", "1234")) {
            String selectMembersQuery = "SELECT member_name FROM members";
            try (PreparedStatement preparedStatement = connection.prepareStatement(selectMembersQuery);
                 ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    String memberName = resultSet.getString("member_name");
                    cmbMName.addItem(memberName);
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            // Handle database errors here (show error messages, log errors, etc.)
        }
        
        table = new JTable();
        table.setForeground(new Color(0, 0, 0));
        table.setBorder(UIManager.getBorder("Table.scrollPaneBorder"));
        table.setFont(new Font("Tahoma", Font.PLAIN, 14));
        table.setToolTipText("Name\r\n");
        table.setBackground(new Color(255, 255, 255));
        table.setSurrendersFocusOnKeystroke(true);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.setFillsViewportHeight(true);
        table.setColumnSelectionAllowed(true);
        table.setCellSelectionEnabled(true);

        // Define column names
        String[] columnNames = {
            "Member ID", "Member Name", "Age", "Mobile", "Gender", "Height (cm)", "Weight (kg)"
        };

        // Define data (replace this with your actual data)
        Object[][] data = {
            {null, "d", null, null, null, null, null},
            {null, "d", null, null, "d", null, null},
            {null, "dv", null, null, null, null, null},
            {null, null, null, null, null, null, null},
            {null, "d", null, null, null, null, null},
            {null, null, null, null, "d", null, null},
        };

        DefaultTableModel model = new DefaultTableModel(data, columnNames) {
            Class[] columnTypes = {
                Integer.class, String.class, Integer.class, Integer.class, String.class, Double.class, Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return columnTypes[columnIndex];
            }
        };

        table.setModel(new DefaultTableModel(
        	new Object[][] {
        		{null, "", null, null, null, null},
        		{null, "", null, null, "", null},
        		{null, "", null, null, null, null},
        		{null, null, null, null, null, null},
        		{null, "", null, null, null, null},
        		{null, null, null, null, "", null},
        		{null, null, null, null, null, null},
        		{null, null, null, null, null, null},
        		{null, null, null, null, null, null},
        		{null, null, null, null, null, null},
        		{null, null, null, null, null, null},
        		{null, null, null, null, null, null},
        		{null, null, null, null, null, null},
        		{null, null, null, null, null, null},
        	},
        	new String[] {
        		"Payment ID", "Member Name", "Year", "Month", "Package", "Fee"
        	}
        ) {
        	Class[] columnTypes = new Class[] {
        		Object.class, String.class, Integer.class, Integer.class, String.class, Double.class
        	};
        	public Class getColumnClass(int columnIndex) {
        		return columnTypes[columnIndex];
        	}
        });
        table.getColumnModel().getColumn(1).setPreferredWidth(100);
        table.getColumnModel().getColumn(2).setMinWidth(20);
        table.getColumnModel().getColumn(4).setMaxWidth(75);
        table.getColumnModel().getColumn(5).setPreferredWidth(84);
        
        JTableHeader header = table.getTableHeader();
        header.setFont(new Font("Tahoma", Font.BOLD, 16));

        // Set a custom header renderer to apply the font size
        TableCellRenderer headerRenderer = header.getDefaultRenderer();
        if (headerRenderer instanceof JLabel) {
            ((JLabel) headerRenderer).setHorizontalAlignment(JLabel.CENTER);
            ((JLabel) headerRenderer).setFont(new Font("Tahoma", Font.BOLD, 16));
        }

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(200, 303, 651, 248);
        panel.add(scrollPane);
        
        JButton btnRefresh = new JButton("Refresh");
        btnRefresh.setBackground(new Color(0, 113, 225));
        btnRefresh.setFont(new Font("Tahoma", Font.BOLD, 18));
        btnRefresh.setBounds(332, 566, 123, 28);
        panel.add(btnRefresh);
        btnRefresh.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	refreshPaymentTableFromDatabase();
            }
        });
        
        JLabel lblNewLabel_3_2_1 = new JLabel("Year");
        lblNewLabel_3_2_1.setFont(new Font("Segoe UI Historic", Font.BOLD, 16));
        lblNewLabel_3_2_1.setBounds(188, 135, 65, 25);
        panel.add(lblNewLabel_3_2_1);
        
        JComboBox comboBox_1 = new JComboBox();
        comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030"}));
        comboBox_1.setFont(new Font("Tahoma", Font.BOLD, 15));
        comboBox_1.setBounds(356, 135, 176, 32);
        panel.add(comboBox_1);
        
        JComboBox comboBox_2 = new JComboBox();
        comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"}));
        comboBox_2.setFont(new Font("Tahoma", Font.BOLD, 15));
        comboBox_2.setBounds(356, 208, 176, 32);
        panel.add(comboBox_2);
        
        JLabel lblNewLabel_3_2_2 = new JLabel("Package");
        lblNewLabel_3_2_2.setFont(new Font("Segoe UI Historic", Font.BOLD, 16));
        lblNewLabel_3_2_2.setBounds(617, 67, 65, 25);
        panel.add(lblNewLabel_3_2_2);
        
        JComboBox cmbPackage = new JComboBox();
        cmbPackage.setModel(new DefaultComboBoxModel(new String[] {"A", "B"}));
        cmbPackage.setFont(new Font("Tahoma", Font.BOLD, 15));
        cmbPackage.setBounds(724, 64, 176, 32);
        panel.add(cmbPackage);
        cmbPackage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedPackage = cmbPackage.getSelectedItem().toString();
                if (selectedPackage.equals("A")) {
                    txtFee.setText("2000"); // Set fee to Rs.2000 for package A
                } else if (selectedPackage.equals("B")) {
                    txtFee.setText("3000"); // Set fee to Rs.3000 for package B
                } else {
                    txtFee.setText(""); // Handle other package selections as needed
                }
            }
        });

        
        JLabel lblNewLabel_3_2_2_1 = new JLabel("Fee");
        lblNewLabel_3_2_2_1.setFont(new Font("Segoe UI Historic", Font.BOLD, 16));
        lblNewLabel_3_2_2_1.setBounds(617, 135, 65, 25);
        panel.add(lblNewLabel_3_2_2_1);
        
        txtFee = new JTextField();
        txtFee.setEditable(false);
        txtFee.setFont(new Font("Tahoma", Font.BOLD, 15));
        txtFee.setBounds(724, 135, 176, 32);
        panel.add(txtFee);
        txtFee.setColumns(10);
        
        JButton btnPay = new JButton("Pay");
        btnPay.setForeground(new Color(255, 255, 255));
        btnPay.setFont(new Font("Tahoma", Font.BOLD, 18));
        btnPay.setBackground(new Color(71, 106, 226));
        btnPay.setBounds(754, 208, 123, 28);
        panel.add(btnPay);
        
        JButton btnPrint = new JButton("Print");
        btnPrint.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		try {
					table.print();
				} catch (PrinterException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
        	}
        });
        btnPrint.setFont(new Font("Tahoma", Font.BOLD, 18));
        btnPrint.setBackground(new Color(255, 128, 0));
        btnPrint.setBounds(628, 566, 106, 28);
        panel.add(btnPrint);
        btnPay.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String memberName = cmbMName.getSelectedItem().toString();
                int year = Integer.parseInt(comboBox_1.getSelectedItem().toString());
                String month = comboBox_2.getSelectedItem().toString();
                String packageType = cmbPackage.getSelectedItem().toString();
                double fee = Double.parseDouble(txtFee.getText());
                
                // Check if a payment for the selected month and year already exists
                if (isPaymentExists(memberName, year, month)) {
                    JOptionPane.showMessageDialog(null, "Payment for " + month + " " + year + " already exists for this member.");
                } else {
                    try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/gym_database", "root", "1234")) {
                        String insertPaymentQuery = "INSERT INTO payments (member_name, year, month, package, fee) VALUES (?, ?, ?, ?, ?)";
                        try (PreparedStatement preparedStatement = connection.prepareStatement(insertPaymentQuery)) {
                            preparedStatement.setString(1, memberName);
                            preparedStatement.setInt(2, year);
                            preparedStatement.setString(3, month);
                            preparedStatement.setString(4, packageType);
                            preparedStatement.setDouble(5, fee);

                            int rowsAffected = preparedStatement.executeUpdate();
                            if (rowsAffected > 0) {
                                JOptionPane.showMessageDialog(null, "Payment saved successfully!");
                            } else {
                                JOptionPane.showMessageDialog(null, "Failed to save payment. Please try again.");
                            }
                        }
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                        // Handle database errors here (show error messages, log errors, etc.)
                    }
                    refreshPaymentTableFromDatabase();
                }
            }
        });
       

        

               

        
    }
    
	 // Method to check if a payment for the given member, year, and month already exists
	    private boolean isPaymentExists(String memberName, int year, String month) {
	        boolean paymentExists = false;
	        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/gym_database", "root", "1234")) {
	            String selectQuery = "SELECT * FROM payments WHERE member_name = ? AND year = ? AND month = ?";
	            try (PreparedStatement preparedStatement = connection.prepareStatement(selectQuery)) {
	                preparedStatement.setString(1, memberName);
	                preparedStatement.setInt(2, year);
	                preparedStatement.setString(3, month);
	                try (ResultSet resultSet = preparedStatement.executeQuery()) {
	                    // If any result is returned, a payment already exists for the given month and year
	                    paymentExists = resultSet.next();
	                }
	            }
	        } catch (SQLException ex) {
	            ex.printStackTrace();
	            // Handle database errors here (show error messages, log errors, etc.)
	        }
	        return paymentExists;
	    }
	    
    
    private void refreshPaymentTableFromDatabase() {
        String[] columnNames = {"Payment ID", "Member Name", "Year", "Month", "Package", "Fee"};

        // Fetch data from the database
        List<List<Object>> data = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/gym_database", "root", "1234")) {
            String selectQuery = "SELECT payment_id, member_name, year, month, package, fee FROM payments";
            try (PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);
                 ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    List<Object> row = new ArrayList<>();
                    row.add(resultSet.getInt("payment_id"));
                    row.add(resultSet.getString("member_name"));
                    row.add(resultSet.getInt("year"));
                    row.add(resultSet.getString("month"));
                    row.add(resultSet.getString("package"));
                    row.add(resultSet.getDouble("fee"));
                    data.add(row);
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            // Handle database errors here (show error messages, log errors, etc.)
        }

        // Convert List of Lists to 2D array
        Object[][] tableData = new Object[data.size()][];
        for (int i = 0; i < data.size(); i++) {
            List<Object> row = data.get(i);
            tableData[i] = row.toArray(new Object[0]);
        }

        // Create a new DefaultTableModel with the retrieved data and column names
        DefaultTableModel tableModel = new DefaultTableModel(tableData, columnNames);

        // Set the new model to your JTable
        table.setModel(tableModel);
    }

    

    private Point mouseOffset;
    private JTextField textField;
    private JTable table;
    private JTextField txtFee;

    private void makeDraggable(final Component component) {
    }
}



 