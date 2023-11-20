package gym;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
import javax.swing.text.MaskFormatter;


import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;

public class Reservation extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
	private JFormattedTextField formattedTextField;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Reservation frame = new Reservation();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Reservation(){
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
        
        JLabel lblNewLabel_2 = new JLabel("Reservations");
        lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblNewLabel_2.setBounds(324, 5, 152, 31);
        panel_2.add(lblNewLabel_2);
        
        JLabel lblNewLabel_3 = new JLabel("Member Name");
        lblNewLabel_3.setFont(new Font("Segoe UI Historic", Font.BOLD, 16));
        lblNewLabel_3.setBounds(186, 75, 123, 25);
        panel.add(lblNewLabel_3);
        
        JLabel lblNewLabel_3_1 = new JLabel("Trainer Name");
        lblNewLabel_3_1.setFont(new Font("Segoe UI Historic", Font.BOLD, 16));
        lblNewLabel_3_1.setBounds(186, 147, 123, 25);
        panel.add(lblNewLabel_3_1);
        
        textField_3 = new JTextField();
        textField_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
        textField_3.setColumns(10);
        textField_3.setBounds(747, 143, 176, 32);
        panel.add(textField_3);
        
        JLabel lblNewLabel_3_2 = new JLabel("Date (MM/dd/yyyy)");
        lblNewLabel_3_2.setFont(new Font("Segoe UI Historic", Font.BOLD, 14));
        lblNewLabel_3_2.setBounds(595, 79, 137, 25);
        panel.add(lblNewLabel_3_2);
        
  
        
        
        
        
        
        
        
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
        	    "Reservation ID", "Member Name", "Trainer Name", "Reservation Date", "Fee"
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
        		{null, null, "", null, null},
        		{null, null, null, null, null},
        		{null, null, "", null, null},
        		{null, null, null, null, null},
        		{null, null, null, null, null},
        		{null, null, null, null, null},
        		{null, null, null, null, null},
        		{null, null, null, null, null},
        		{null, null, null, null, null},
        		{null, null, null, null, null},
        		{null, null, null, null, null},
        		{null, null, null, null, null},
        	},
        	new String[] {
        		"Reserve ID", "Member Name", "Trainer Name", "Date", "Fee"
        	}
        ) {
        	Class[] columnTypes = new Class[] {
        		Object.class, Integer.class, String.class, Integer.class, Integer.class
        	};
        	public Class getColumnClass(int columnIndex) {
        		return columnTypes[columnIndex];
        	}
        });
        table.getColumnModel().getColumn(1).setPreferredWidth(88);
        table.getColumnModel().getColumn(1).setMinWidth(20);
        table.getColumnModel().getColumn(2).setPreferredWidth(100);
        table.getColumnModel().getColumn(3).setMinWidth(20);
        
        JTableHeader header = table.getTableHeader();
        header.setFont(new Font("Tahoma", Font.BOLD, 16));

        // Set a custom header renderer to apply the font size
        TableCellRenderer headerRenderer = header.getDefaultRenderer();
        if (headerRenderer instanceof JLabel) {
            ((JLabel) headerRenderer).setHorizontalAlignment(JLabel.CENTER);
            ((JLabel) headerRenderer).setFont(new Font("Tahoma", Font.BOLD, 16));
        }

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(159, 335, 764, 219);
        panel.add(scrollPane);
      
        
        JLabel lblNewLabel_3_1_1 = new JLabel("Fee");
        lblNewLabel_3_1_1.setFont(new Font("Segoe UI Historic", Font.BOLD, 16));
        lblNewLabel_3_1_1.setBounds(595, 147, 65, 25);
        panel.add(lblNewLabel_3_1_1);
        
        
        try {
            MaskFormatter maskFormatter = new MaskFormatter("##/##/####");
            maskFormatter.setPlaceholderCharacter('_'); // Use underscore as a placeholder for empty characters
            formattedTextField = new JFormattedTextField(maskFormatter);
            formattedTextField.setFont(new Font("Tahoma", Font.PLAIN, 15));
            formattedTextField.setBounds(747, 76, 176, 32);
            panel.add(formattedTextField);

            formattedTextField.addFocusListener(new FocusAdapter() {
                @Override
                public void focusLost(FocusEvent e) {
                    String inputDate = formattedTextField.getText().replaceAll("_", " "); // Replace underscores with spaces for validation
                    if (!isValidDateFormat(inputDate)) {
                        JOptionPane.showMessageDialog(null, "Invalid date format. Please enter the date in MM/dd/yyyy format.");
                        formattedTextField.setText(""); // Clear the field if the format is invalid
                    }
                }
            });

        } catch (ParseException ex) {
            ex.printStackTrace();
        }


        

        
        //Member Names
        JComboBox cmbMName = new JComboBox();
        cmbMName.setFont(new Font("Tahoma", Font.PLAIN, 15));
        cmbMName.setBounds(342, 75, 176, 32);
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

        //Trainer Names
        JComboBox cmbTName = new JComboBox();
        cmbTName.setFont(new Font("Tahoma", Font.PLAIN, 15));
        cmbTName.setBounds(342, 147, 176, 32);
        panel.add(cmbTName);
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/gym_database", "root", "1234")) {
            String selectTrainersQuery = "SELECT trainer_name FROM trainers";
            try (PreparedStatement preparedStatement = connection.prepareStatement(selectTrainersQuery);
                 ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    String trainerName = resultSet.getString("trainer_name");
                    cmbTName.addItem(trainerName);
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            // Handle database errors here (show error messages, log errors, etc.)
        }
        
        JButton btnSave = new JButton("Reserve");
        btnSave.setBackground(new Color(76, 175, 80));
        btnSave.setFont(new Font("Tahoma", Font.BOLD, 18));
        btnSave.setBounds(498, 239, 123, 28);
        panel.add(btnSave);
         
        btnSave.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Get selected values from combo boxes and formatted text field
                String memberName = cmbMName.getSelectedItem().toString();
                String trainerName = cmbTName.getSelectedItem().toString();
                String dateString = formattedTextField.getText().replaceAll("_", " ");
                int fee = 0;

                // Validate and parse the fee
                try {
                    fee = Integer.parseInt(textField_3.getText());
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid fee. Please enter a valid number.");
                    return;
                }

                // Validate date format
                if (!isValidDateFormat(dateString)) {
                    JOptionPane.showMessageDialog(null, "Invalid date format. Please enter the date in MM/dd/yyyy format.");
                    return;
                }

                // Insert data into the reservations table
                try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/gym_database", "root", "1234")) {
                    String insertReservationQuery = "INSERT INTO reservations (member_name, trainer_name, reserve_date, fee) VALUES (?, ?, ?, ?)";
                    try (PreparedStatement preparedStatement = connection.prepareStatement(insertReservationQuery)) {
                        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
                        java.util.Date date = sdf.parse(dateString);
                        java.sql.Date sqlDate = new java.sql.Date(date.getTime());

                        preparedStatement.setString(1, memberName);
                        preparedStatement.setString(2, trainerName);
                        preparedStatement.setDate(3, sqlDate);
                        preparedStatement.setInt(4, fee);

                        int rowsAffected = preparedStatement.executeUpdate();
                        if (rowsAffected > 0) {
                            JOptionPane.showMessageDialog(null, "Reservation saved successfully!");
                            List<List<Object>> data = refreshReservationTable();

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

                            refreshReservationTable();
                        } else {
                            JOptionPane.showMessageDialog(null, "Failed to save reservation. Please try again.");
                        }
                    }
                } catch (SQLException | ParseException ex) {
                    ex.printStackTrace();
                    // Handle database errors here (show error messages, log errors, etc.)
                }
            }
        });
        
        JButton btnRefresh = new JButton("Refresh");
        btnRefresh.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Call the method to fetch and display data from the database
            	refreshReservationTableFromDatabase();
            	
            }
        });
        btnRefresh.setFont(new Font("Tahoma", Font.BOLD, 18));
        btnRefresh.setBackground(new Color(0, 113, 225));
        btnRefresh.setBounds(506, 575, 115, 28);
        panel.add(btnRefresh);

       
    }
    private boolean isValidDateFormat(String inputDate) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
            sdf.setLenient(false);
            sdf.parse(inputDate);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }
    private List<List<Object>> refreshReservationTable() {
        List<List<Object>> rowData = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/gym_database", "root", "1234")) {
            String selectQuery = "SELECT reserve_id, member_name, trainer_name, reserve_date, fee FROM reservations";
            try (PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);
                 ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    List<Object> row = new ArrayList<>();
                    row.add(resultSet.getInt("reserve_id"));
                    row.add(resultSet.getString("member_name"));
                    row.add(resultSet.getString("trainer_name"));
                    row.add(resultSet.getDate("reserve_date"));
                    row.add(resultSet.getInt("fee"));
                    rowData.add(row);
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            // Handle database errors here (show error messages, log errors, etc.)
        }
        return rowData;
    }

    private void refreshReservationTableFromDatabase() {
        // Database connection variables
        String jdbcUrl = "jdbc:mysql://localhost:3306/gym_database";
        String dbUsername = "root";
        String dbPassword = "1234";

        // Fetch data from the database
        List<List<Object>> data = new ArrayList<>();
        String[] columnNames = {"Reservation ID", "Member Name", "Trainer Name", "Reservation Date", "Fee"};

        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUsername, dbPassword)) {
            String selectQuery = "SELECT reserve_id, member_name, trainer_name, reserve_date, fee FROM reservations";
            try (PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);
                 ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    List<Object> row = new ArrayList<>();
                    row.add(resultSet.getInt("reserve_id"));
                    row.add(resultSet.getString("member_name"));
                    row.add(resultSet.getString("trainer_name"));
                    row.add(resultSet.getDate("reserve_date"));
                    row.add(resultSet.getInt("fee"));
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
    private JTextField textField_3;
    private JTable table;
    
    private void makeDraggable(final Component component) {
    }
}



 