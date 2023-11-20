package gym;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

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
import java.util.List;
import java.util.ArrayList;


public class Member extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Member frame = new Member();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        
    }

    public Member(){
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
        
        //Back Button
        JButton btnBack = new JButton("Back");
        btnBack.setBackground(new Color(173, 216, 230));
        btnBack.setFont(new Font("Tahoma", Font.BOLD, 18));
        btnBack.setBounds(24, 566, 87, 28);
        panel_1.add(btnBack);
        
        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
              new Home().setVisible(true);
              dispose();
            }
        });
        
        
        JLabel lblNewLabel_2_1 = new JLabel("W e l n e s s  S i m p l i f i e d");
        lblNewLabel_2_1.setFont(new Font("Segoe Print", Font.PLAIN, 9));
        lblNewLabel_2_1.setBounds(5, 95, 182, 20);
        panel_1.add(lblNewLabel_2_1);
               
        
        JPanel panel_2 = new JPanel();
        panel_2.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        panel_2.setBackground(new Color(128, 128, 128));
        panel_2.setBounds(147, 0, 789, 41);
        panel_2.setLayout(null);
        panel.add(panel_2);
        
        JLabel lblNewLabel_1 = new JLabel("New label");
        panel_2.add(lblNewLabel_1);
        
        JLabel lblNewLabel_2 = new JLabel("Member Management");
        lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblNewLabel_2.setBounds(284, 5, 228, 31);
        panel_2.add(lblNewLabel_2);
        
        JLabel lblName = new JLabel("Member Name");
        lblName.setFont(new Font("Segoe UI Historic", Font.BOLD, 16));
        lblName.setBounds(216, 51, 123, 25);
        panel.add(lblName);
        
        JLabel lblAge = new JLabel("Member Age ");
        lblAge.setFont(new Font("Segoe UI Historic", Font.BOLD, 16));
        lblAge.setBounds(469, 51, 123, 25);
        panel.add(lblAge);
        
        JLabel lblMobile = new JLabel("Mobile Number ");
        lblMobile.setFont(new Font("Segoe UI Historic", Font.BOLD, 16));
        lblMobile.setBounds(701, 51, 133, 25);
        panel.add(lblMobile);
        
        JTextField txtName = new JTextField();
        txtName.setFont(new Font("Tahoma", Font.PLAIN, 20));
        txtName.setBounds(186, 86, 176, 32);
        panel.add(txtName);
        txtName.setColumns(10);
        txtName.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                String memberName = txtName.getText().trim();
                if (memberName.matches("^[a-zA-Z]+$")) {
                    
                } else {
                    
                    JOptionPane.showMessageDialog(null, "Invalid member name. Please enter only alphabetic characters.", "Error", JOptionPane.ERROR_MESSAGE);
                    txtName.setText("");
                }
            }
        });

        
        JTextField txtAge = new JTextField();
        txtAge.setFont(new Font("Tahoma", Font.PLAIN, 20));
        txtAge.setColumns(10);
        txtAge.setBounds(434, 86, 176, 32);
        panel.add(txtAge);
        txtAge.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                String ageText = txtAge.getText().trim();
                try {
                    int age = Integer.parseInt(ageText);
                    if (age >= 15 && age <= 99) {
                        // Valid age, do nothing or perform any necessary actions
                    } else {
                        // Invalid age, show an error message
                        JOptionPane.showMessageDialog(null, "Age must be between 15 and 99.", "Error", JOptionPane.ERROR_MESSAGE);
                        // Clear the text field or set it to a default value if desired
                        txtAge.setText("");
                    }
                } catch (NumberFormatException ex) {
                    // Invalid number format, show an error message
                    JOptionPane.showMessageDialog(null, "Invalid age format. Please enter a valid number.", "Error", JOptionPane.ERROR_MESSAGE);
                    // Clear the text field or set it to a default value if desired
                    txtAge.setText("");
                }
            }
        });

        
        JTextField txtMobile = new JTextField();
        txtMobile.setFont(new Font("Tahoma", Font.PLAIN, 20));
        txtMobile.setColumns(10);
        txtMobile.setBounds(683, 86, 176, 32);
        panel.add(txtMobile);
        txtMobile.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                String mobileNumber = txtMobile.getText().trim();
                if (mobileNumber.matches("^07\\d{8}$")) {
                    // Valid mobile number format, do nothing or perform any necessary actions
                } else {
                    // Invalid mobile number format, show an error message
                    JOptionPane.showMessageDialog(null, "Invalid mobile number format. Please enter a 10-digit number starting with '07'.", "Error", JOptionPane.ERROR_MESSAGE);
                    // Clear the text field or set it to a default value if desired
                    txtMobile.setText("");
                }
            }
        });

        
        JLabel lblGender = new JLabel("Gender");
        lblGender.setFont(new Font("Segoe UI Historic", Font.BOLD, 16));
        lblGender.setBounds(237, 148, 65, 25);
        panel.add(lblGender);
        
        JComboBox comboBox = new JComboBox();
        comboBox.setFont(new Font("Tahoma", Font.BOLD, 15));
        comboBox.setModel(new DefaultComboBoxModel(new String[] {"Male", "Female"}));
        comboBox.setBounds(186, 183, 176, 32);
        panel.add(comboBox);
        
        JLabel lblHeight = new JLabel("Height (cm)");
        lblHeight.setFont(new Font("Segoe UI Historic", Font.BOLD, 16));
        lblHeight.setBounds(485, 148, 89, 25);
        panel.add(lblHeight);
        
        JLabel lblWeight = new JLabel("Weight (kg)");
        lblWeight.setFont(new Font("Segoe UI Historic", Font.BOLD, 16));
        lblWeight.setBounds(719, 148, 95, 25);
        panel.add(lblWeight);
        
        //Save to the Database and Display in the Table
        JButton btnSave = new JButton("Save");
        btnSave.setBackground(new Color(76, 175, 80));
        btnSave.setFont(new Font("Tahoma", Font.BOLD, 18));
        btnSave.setBounds(487, 254, 87, 28);
        panel.add(btnSave);
        
        String[] columnNames = {"Member ID", "Member Name", "Age", "Mobile", "Gender", "Height (cm)", "Weight (kg)"};
        //Connection
        btnSave.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Database connection variables
                String jdbcUrl = "jdbc:mysql://localhost:3306/gym_database";
                String dbUsername = "root";
                String dbPassword = "1234";

                // Member data to insert into the database
                String name = txtName.getText();
                int age = Integer.parseInt(txtAge.getText());
                String mobile = txtMobile.getText();
                String gender = comboBox.getSelectedItem().toString();
                double height = Double.parseDouble(txtHeight.getText());
                double weight = Double.parseDouble(txtWeight.getText());

                try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUsername, dbPassword)) {
                    String insertQuery = "INSERT INTO members (member_name, age, mobile, gender, height, weight) VALUES (?, ?, ?, ?, ?, ?)";
                    try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
                        preparedStatement.setString(1, name);
                        preparedStatement.setInt(2, age);
                        preparedStatement.setString(3, mobile);
                        preparedStatement.setString(4, gender);
                        preparedStatement.setDouble(5, height);
                        preparedStatement.setDouble(6, weight);

                        int rowsAffected = preparedStatement.executeUpdate();
                        if (rowsAffected > 0) {
                            System.out.println("Data inserted successfully!");
                         // Call the method to get updated data from the database
                            List<List<Object>> data = refreshTable();

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

                            refreshTable();
                            txtName.setText(""); // Member Name
                            txtAge.setText(""); // Age
                            txtMobile.setText(""); // Mobile
                            txtHeight.setText(""); // Height
                            txtWeight.setText(""); // Weight
                        } else {
                            System.out.println("Failed to insert data.");
                        }
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    // Handle database errors here (show error messages, log errors, etc.)
                }
            }
        });
        
        
        
        txtHeight = new JTextField();
        txtHeight.setFont(new Font("Tahoma", Font.PLAIN, 20));
        txtHeight.setColumns(10);
        txtHeight.setBounds(434, 182, 176, 32);
        panel.add(txtHeight);
        
        txtHeight.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                String heightText = txtHeight.getText().trim();
                if (heightText.matches("^\\d{3}(\\.\\d{1,2})?$")) {
                    // Valid height format, do nothing or perform any necessary actions
                } else {
                    // Invalid height format, show an error message
                    JOptionPane.showMessageDialog(null, "Invalid height format. Please enter a number with exactly three digits before the decimal point and at most two digits after the decimal point.", "Error", JOptionPane.ERROR_MESSAGE);
                    // Clear the text field or set it to a default value if desired
                    txtHeight.setText("");
                }
            }
        });





        
        txtWeight = new JTextField();
        txtWeight.setFont(new Font("Tahoma", Font.PLAIN, 20));
        txtWeight.setColumns(10);
        txtWeight.setBounds(683, 182, 176, 32);
        panel.add(txtWeight);
        txtWeight.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                String weightText = txtWeight.getText().trim();
                if (weightText.matches("^\\d{2,3}(\\.\\d{1,2})?$")) {
                    // Valid weight format, do nothing or perform any necessary actions
                } else {
                    // Invalid weight format, show an error message
                    JOptionPane.showMessageDialog(null, "Invalid weight format. Please enter a number with minimum 2 digits and maximum 3 digits.", "Error", JOptionPane.ERROR_MESSAGE);
                    // Clear the text field or set it to a default value if desired
                    txtWeight.setText("");
                }
            }
        });

        
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
        		{null, "", null, null, null, null, null},
        		{null, "", null, null, "", null, null},
        		{null, "", null, null, null, null, null},
        		{null, null, null, null, null, null, null},
        		{null, "", null, null, null, null, null},
        		{null, null, null, null, "", null, null},
        		{null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null},
        	},
        	new String[] {
        		"Member ID", "Member Name", "Age", "Mobile", "Gender", "Height (cm)", "Weight (kg)"
        	}
        ) {
        	Class[] columnTypes = new Class[] {
        		Integer.class, String.class, Integer.class, Integer.class, String.class, Double.class, Double.class
        	};
        	public Class getColumnClass(int columnIndex) {
        		return columnTypes[columnIndex];
        	}
        });
        table.getColumnModel().getColumn(0).setPreferredWidth(66);
        table.getColumnModel().getColumn(0).setMinWidth(20);
        table.getColumnModel().getColumn(1).setPreferredWidth(100);
        table.getColumnModel().getColumn(2).setMinWidth(20);
        table.getColumnModel().getColumn(4).setMaxWidth(75);
        table.getColumnModel().getColumn(5).setPreferredWidth(84);
        table.getColumnModel().getColumn(6).setPreferredWidth(81);
        
        JTableHeader header = table.getTableHeader();
        header.setFont(new Font("Tahoma", Font.BOLD, 16));

        // Set a custom header renderer to apply the font size
        TableCellRenderer headerRenderer = header.getDefaultRenderer();
        if (headerRenderer instanceof JLabel) {
            ((JLabel) headerRenderer).setHorizontalAlignment(JLabel.CENTER);
            ((JLabel) headerRenderer).setFont(new Font("Tahoma", Font.BOLD, 16));
        }

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(162, 305, 764, 248);
        panel.add(scrollPane);
        
        //Delete the selected Rows
        JButton btnDelete = new JButton("Delete");
        btnDelete.setBackground(new Color(255, 87, 51));
        btnDelete.setFont(new Font("Tahoma", Font.BOLD, 18));
        btnDelete.setBounds(656, 566, 106, 28);
        panel.add(btnDelete);
        
        btnDelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Get the selected row indices from the JTable
                int[] selectedRows = table.getSelectedRows();

                // Check if any row is selected
                if (selectedRows.length > 0) {
                    DefaultTableModel model = (DefaultTableModel) table.getModel();

                    String jdbcUrl = "jdbc:mysql://localhost:3306/gym_database";
                    String dbUsername = "root";
                    String dbPassword = "1234";

                    try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUsername, dbPassword)) {
                        // Prepare the SQL delete statement
                        String deleteQuery = "DELETE FROM members WHERE member_id = ?";
                        
                        // Iterate through the selected rows in reverse order to avoid index issues
                        for (int i = selectedRows.length - 1; i >= 0; i--) {
                            int memberId = (int) table.getValueAt(selectedRows[i], 0); // Assuming member_id is in the first column
                            try (PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery)) {
                                preparedStatement.setInt(1, memberId);

                                // Execute the delete statement
                                int rowsAffected = preparedStatement.executeUpdate();
                                if (rowsAffected > 0) {
                                    // Remove the selected row from the JTable model if deletion from the database was successful
                                    model.removeRow(selectedRows[i]);
                                }
                            }
                        }
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                        // Handle database errors here (show error messages, log errors, etc.)
                    }
                } else {
                    // Show a message indicating that no row is selected for deletion
                    System.out.println("No row selected for deletion.");
                }
            }
        });
        
        //Refresh the Table
        JButton btnRefresh = new JButton("Refresh");
        btnRefresh.setFont(new Font("Tahoma", Font.BOLD, 18));
        btnRefresh.setBackground(new Color(0, 113, 225));
        btnRefresh.setBounds(288, 566, 115, 28);
        panel.add(btnRefresh);
        
        btnRefresh.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Call the method to fetch and display data from the database
                refreshTableFromDatabase();
            	
            }
        });
        
    }
    

    
    //Refresh the table, When Save button clicks
    private List<List<Object>> refreshTable() {
        List<List<Object>> rowData = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/gym_database", "root", "1234")) {
            String selectQuery = "SELECT member_id, member_name, age, mobile, gender, height, weight FROM members";
            try (PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);
                 ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    List<Object> row = new ArrayList<>();
                    row.add(resultSet.getInt("member_id"));
                    row.add(resultSet.getString("member_name"));
                    row.add(resultSet.getInt("age"));
                    row.add(resultSet.getString("mobile"));
                    row.add(resultSet.getString("gender"));
                    row.add(resultSet.getDouble("height"));
                    row.add(resultSet.getDouble("weight"));
                    rowData.add(row);
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            // Handle database errors here (show error messages, log errors, etc.)
        }
        return rowData;
    }
    
    //To Refresh Button
    private void refreshTableFromDatabase() {
        // Database connection variables
        String jdbcUrl = "jdbc:mysql://localhost:3306/gym_database";
        String dbUsername = "root";
        String dbPassword = "1234";

        // Fetch data from the database
        List<List<Object>> data = new ArrayList<>();
        String[] columnNames = {"Member ID", "Member Name", "Age", "Mobile", "Gender", "Height (cm)", "Weight (kg)"};

        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUsername, dbPassword)) {
            String selectQuery = "SELECT member_id, member_name, age, mobile, gender, height, weight FROM members";
            try (PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);
                 ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    List<Object> row = new ArrayList<>();
                    row.add(resultSet.getInt("member_id"));
                    row.add(resultSet.getString("member_name"));
                    row.add(resultSet.getInt("age"));
                    row.add(resultSet.getString("mobile"));
                    row.add(resultSet.getString("gender"));
                    row.add(resultSet.getDouble("height"));
                    row.add(resultSet.getDouble("weight"));
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
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    private JTextField txtHeight;
    private JTextField txtWeight;
    private JTable table;

    private void makeDraggable(final Component component) {
    }
}



 