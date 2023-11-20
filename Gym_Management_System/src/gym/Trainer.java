package gym;

import java.awt.*;
import java.awt.event.*;
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

public class Trainer extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private DefaultTableModel model;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Trainer frame = new Trainer();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Trainer(){
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
        
        JLabel lblNewLabel_2_1 = new JLabel("W e l n e s s  S i m p l i f i e d");
        lblNewLabel_2_1.setFont(new Font("Segoe Print", Font.PLAIN, 9));
        lblNewLabel_2_1.setBounds(5, 95, 182, 20);
        panel_1.add(lblNewLabel_2_1);
        
        JButton btnBack_1 = new JButton("Back");
        btnBack_1.setFont(new Font("Tahoma", Font.BOLD, 18));
        btnBack_1.setBackground(new Color(173, 216, 230));
        btnBack_1.setBounds(25, 566, 87, 28);
        panel_1.add(btnBack_1);
        btnBack_1.addActionListener(new ActionListener() {
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
        
        JLabel lblNewLabel_2 = new JLabel("Trainer Management");
        lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblNewLabel_2.setBounds(284, 5, 228, 31);
        panel_2.add(lblNewLabel_2);
        
        JLabel lblNewLabel_3 = new JLabel("Trainer Name");
        lblNewLabel_3.setFont(new Font("Segoe UI Historic", Font.BOLD, 16));
        lblNewLabel_3.setBounds(216, 51, 123, 25);
        panel.add(lblNewLabel_3);
        
        JLabel lblNewLabel_3_1 = new JLabel("Trainer Age ");
        lblNewLabel_3_1.setFont(new Font("Segoe UI Historic", Font.BOLD, 16));
        lblNewLabel_3_1.setBounds(473, 51, 95, 25);
        panel.add(lblNewLabel_3_1);
        
        JLabel lblNewLabel_3_1_1 = new JLabel("Mobile Number ");
        lblNewLabel_3_1_1.setFont(new Font("Segoe UI Historic", Font.BOLD, 16));
        lblNewLabel_3_1_1.setBounds(701, 51, 133, 25);
        panel.add(lblNewLabel_3_1_1);
        
        txtTName = new JTextField();
        txtTName.setFont(new Font("Tahoma", Font.PLAIN, 20));
        txtTName.setBounds(186, 86, 176, 32);
        panel.add(txtTName);
        txtTName.setColumns(10);
        txtTName.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                String memberName = txtTName.getText().trim();
                if (memberName.matches("^[a-zA-Z]+$")) {
                    
                } else {
                    
                    JOptionPane.showMessageDialog(null, "Invalid member name. Please enter only alphabetic characters.", "Error", JOptionPane.ERROR_MESSAGE);
                    txtTName.setText("");
                }
            }
        });
        
        txtTAge = new JTextField();
        txtTAge.setFont(new Font("Tahoma", Font.PLAIN, 20));
        txtTAge.setColumns(10);
        txtTAge.setBounds(442, 86, 150, 32);
        panel.add(txtTAge);
        txtTAge.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                String ageText = txtTAge.getText().trim();
                try {
                    int age = Integer.parseInt(ageText);
                    if (age >= 22 && age <= 99) {
                        // Valid age, do nothing or perform any necessary actions
                    } else {
                        // Invalid age, show an error message
                        JOptionPane.showMessageDialog(null, "Age must be between 22 and 99.", "Error", JOptionPane.ERROR_MESSAGE);
                        // Clear the text field or set it to a default value if desired
                        txtTAge.setText("");
                    }
                } catch (NumberFormatException ex) {
                    // Invalid number format, show an error message
                    JOptionPane.showMessageDialog(null, "Invalid age format. Please enter a valid number.", "Error", JOptionPane.ERROR_MESSAGE);
                    // Clear the text field or set it to a default value if desired
                    txtTAge.setText("");
                }
            }
        });
        
        txtTMobile = new JTextField();
        txtTMobile.setFont(new Font("Tahoma", Font.PLAIN, 20));
        txtTMobile.setColumns(10);
        txtTMobile.setBounds(673, 86, 196, 32);
        panel.add(txtTMobile);
        txtTMobile.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                String mobileNumber = txtTMobile.getText().trim();
                if (mobileNumber.matches("^07\\d{8}$")) {
                    // Valid mobile number format, do nothing or perform any necessary actions
                } else {
                    // Invalid mobile number format, show an error message
                    JOptionPane.showMessageDialog(null, "Invalid mobile number format. Please enter a 10-digit number starting with '07'.", "Error", JOptionPane.ERROR_MESSAGE);
                    // Clear the text field or set it to a default value if desired
                    txtTMobile.setText("");
                }
            }
        });
        
        JLabel lblNewLabel_3_2 = new JLabel("Gender");
        lblNewLabel_3_2.setFont(new Font("Segoe UI Historic", Font.BOLD, 16));
        lblNewLabel_3_2.setBounds(237, 148, 65, 25);
        panel.add(lblNewLabel_3_2);
        
        JComboBox comboBox = new JComboBox();
        comboBox.setFont(new Font("Tahoma", Font.BOLD, 15));
        comboBox.setModel(new DefaultComboBoxModel(new String[] {"Male", "Female"}));
        comboBox.setBounds(186, 183, 176, 32);
        panel.add(comboBox);
        
        JLabel lblNewLabel_3_2_1 = new JLabel("Experience (Years)");
        lblNewLabel_3_2_1.setFont(new Font("Segoe UI Historic", Font.BOLD, 16));
        lblNewLabel_3_2_1.setBounds(453, 148, 150, 25);
        panel.add(lblNewLabel_3_2_1);
        
        JLabel lblNewLabel_3_2_1_1 = new JLabel("Qualification");
        lblNewLabel_3_2_1_1.setFont(new Font("Segoe UI Historic", Font.BOLD, 16));
        lblNewLabel_3_2_1_1.setBounds(719, 148, 115, 25);
        panel.add(lblNewLabel_3_2_1_1);
        
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

        table.setModel(model);


        table.setModel(new DefaultTableModel(
        	new Object[][] {
        		{null, "", null, null, null, null, null},
        		{null, "", null, null, "", null, null},
        		{null, "", null, null, null, null, null},
        		{null, null, null, null, null, null, null},
        		{null, "", null, null, null, null, null},
        	
        	},
        	new String[] {
        		"Trainer ID", "Trainer Name", "Age", "Mobile", "Gender", "Experience", "Qualification"
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
        
        JSpinner spinner = new JSpinner();
        spinner.setModel(new SpinnerNumberModel(Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1)));
        spinner.setFont(new Font("Tahoma", Font.PLAIN, 15));
        spinner.setBounds(442, 185, 150, 30);
        panel.add(spinner);
        
        JComboBox comboBox_1 = new JComboBox();
        comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Diploma", "Certified Personal Trainer", "Specialized Certifications", "Degree"}));
        comboBox_1.setFont(new Font("Tahoma", Font.BOLD, 14));
        comboBox_1.setBounds(673, 183, 196, 32);
        panel.add(comboBox_1);
         
        //Save to the DB
        JButton btnSave_1 = new JButton("Save");
        btnSave_1.setFont(new Font("Tahoma", Font.BOLD, 18));
        btnSave_1.setBackground(new Color(76, 175, 80));
        btnSave_1.setBounds(484, 254, 87, 28);
        panel.add(btnSave_1);
        
        btnSave_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Get data from input fields
                String trainerName = txtTName.getText();
                int age = Integer.parseInt(txtTAge.getText());
                String mobileNumber = txtTMobile.getText();
                String gender = comboBox.getSelectedItem().toString();
                int experienceYears = (int) spinner.getValue();
                String qualification = comboBox_1.getSelectedItem().toString();

                // Database connection variables
                String jdbcUrl = "jdbc:mysql://localhost:3306/gym_database";
                String dbUsername = "root";
                String dbPassword = "1234";

                try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUsername, dbPassword)) {
                    String insertQuery = "INSERT INTO trainers (trainer_name, age, mobile_number, gender, experience_years, qualification) VALUES (?, ?, ?, ?, ?, ?)";
                    try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
                        preparedStatement.setString(1, trainerName);
                        preparedStatement.setInt(2, age);
                        preparedStatement.setString(3, mobileNumber);
                        preparedStatement.setString(4, gender);
                        preparedStatement.setInt(5, experienceYears);
                        preparedStatement.setString(6, qualification);

                        int rowsAffected = preparedStatement.executeUpdate();
                        if (rowsAffected > 0) {
                            System.out.println("Trainer data inserted successfully!");
                            // Refresh the table to show updated data
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
                        } else {
                            System.out.println("Failed to insert trainer data.");
                        }
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    // Handle database errors here (show error messages, log errors, etc.)
                }
            }
        });
        
        
        JButton btnDelete_1 = new JButton("Delete");
        btnDelete_1.setFont(new Font("Tahoma", Font.BOLD, 18));
        btnDelete_1.setBackground(new Color(255, 87, 51));
        btnDelete_1.setBounds(673, 563, 106, 28);
        panel.add(btnDelete_1);
        
        btnDelete_1.addActionListener(new ActionListener() {
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
                        String deleteQuery = "DELETE FROM trainers WHERE trainer_id = ?";
                        
                        // Iterate through the selected rows in reverse order to avoid index issues
                        for (int i = selectedRows.length - 1; i >= 0; i--) {
                            int trainerId = (int) table.getValueAt(selectedRows[i], 0); // Assuming member_id is in the first column
                            try (PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery)) {
                                preparedStatement.setInt(1, trainerId);

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
        
        //Refresh from DB
        JButton btnRefresh = new JButton("Refresh");
        
        btnRefresh.setFont(new Font("Tahoma", Font.BOLD, 18));
        btnRefresh.setBackground(new Color(0, 113, 225));
        btnRefresh.setBounds(298, 570, 115, 28);
        panel.add(btnRefresh);
        btnRefresh.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		refreshTrainersTableFromDatabase();
        	}
        });
    }
    
    
    
    private String[] columnNames = {
            "Trainer ID", "Trainer Name", "Age", "Mobile", "Gender", "Experience", "Qualification"
    };
    
  //Refresh the table, When Save button clicks
    private List<List<Object>> refreshTable() {
        List<List<Object>> rowData = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/gym_database", "root", "1234")) {
            String selectQuery = "SELECT trainer_id, trainer_name, age, mobile_number, gender, experience_years, qualification FROM trainers";
            try (PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);
                 ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    List<Object> row = new ArrayList<>();
                    row.add(resultSet.getInt("trainer_id"));
                    row.add(resultSet.getString("trainer_name"));
                    row.add(resultSet.getInt("age"));
                    row.add(resultSet.getString("mobile_number"));
                    row.add(resultSet.getString("gender"));
                    row.add(resultSet.getInt("experience_years"));
                    row.add(resultSet.getString("qualification"));
                    rowData.add(row);
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            // Handle database errors here (show error messages, log errors, etc.)
        }
        return rowData;
    }
    
    //Refresh from Refresh button
    private void refreshTrainersTableFromDatabase() {
        // Database connection variables
        String jdbcUrl = "jdbc:mysql://localhost:3306/gym_database";
        String dbUsername = "root";
        String dbPassword = "1234";

        // Fetch data from the database
        List<List<Object>> data = new ArrayList<>();
        String[] columnNames = {"Trainer ID", "Trainer Name", "Age", "Mobile Number", "Gender", "Experience Years", "Qualification"};

        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUsername, dbPassword)) {
            String selectQuery = "SELECT trainer_id, trainer_name, age, mobile_number, gender, experience_years, qualification FROM trainers";
            try (PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);
                 ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    List<Object> row = new ArrayList<>();
                    row.add(resultSet.getInt("trainer_id"));
                    row.add(resultSet.getString("trainer_name"));
                    row.add(resultSet.getInt("age"));
                    row.add(resultSet.getString("mobile_number"));
                    row.add(resultSet.getString("gender"));
                    row.add(resultSet.getInt("experience_years"));
                    row.add(resultSet.getString("qualification"));
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
    private JTextField txtTName;
    private JTextField txtTAge;
    private JTextField txtTMobile;
    private JTable table;

    private void makeDraggable(final Component component) {
    }
}



 