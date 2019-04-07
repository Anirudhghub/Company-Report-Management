package Chat;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;

public class ManagerPortal extends JFrame {

	private JPanel contentPane;
	Connection con;
	PreparedStatement ps;
	private JTextField textField;
	private JTextField textField_1;
	JComboBox comboBox;
	static JLabel lblName,lblPost;
	private JTable table;
	
	/**
	 * Launch the application.
	 */
	/*
	 * public static void main(String[] args) { EventQueue.invokeLater(new
	 * Runnable() { public void run() { try { ManagerPortal frame = new
	 * ManagerPortal(); frame.setVisible(true); } catch (Exception e) {
	 * e.printStackTrace(); } } }); }
	 */

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public ManagerPortal(String employee_id) throws SQLException {
		setTitle("Manager Account");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 752, 498);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		this.setLocationRelativeTo(this);
		
		JLabel lblWelcomeToManager = new JLabel("Welcome to Manager Portal");
		lblWelcomeToManager.setBounds(10, 0, 297, 24);
		lblWelcomeToManager.setFont(new Font("Arial", Font.BOLD, 20));
		
		comboBox = new JComboBox(Functions.getValues("user_table",employee_id));
		comboBox.setBounds(32, 115, 109, 20);
		comboBox.insertItemAt("Select", 0);
		comboBox.setSelectedIndex(0);

		

		JButton btnCheckEmployee = new JButton("Check Report");
		btnCheckEmployee.setBounds(27, 189, 136, 23);
		btnCheckEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try{Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/chat","root","rat");
				String values=(String) comboBox.getSelectedItem();
				String query="Select * from "+values+" ";
				PreparedStatement ps=con.prepareStatement(query);
				ResultSet res=ps.executeQuery();
				DefaultTableModel model=(DefaultTableModel)table.getModel();
				Object[] row;
			   while(res.next()) 
			   {
				   	row= new Object[16];
				   	row[0]=res.getString(1);
					row[1]=res.getString(2);
					row[2]=res.getString(3);
					row[3]=res.getString(4);
					row[4]=res.getString(5);
					row[5]=res.getString(6);
					row[6]=res.getString(7);
					row[7]=res.getString(8);
					row[8]=res.getString(9);
					row[9]=res.getString(10);
					row[10]=res.getString(11);
					row[11]=res.getString(12);
					row[12]=res.getString(13);
					row[13]=res.getString(14);
					row[14]=res.getString(15);
					row[15]=res.getString(16);
					model.addRow(row);}
			   ps.close();con.close();
			}
				catch(Exception e2) 
				{
					e2.printStackTrace();
					}
				}

		});

		

		lblName = new JLabel("Name");
		lblName.setBounds(10, 35, 177, 14);
		lblName.setForeground(Color.BLACK);
		lblName.setFont(new Font("Tahoma", Font.BOLD, 14));

		lblPost = new JLabel("Employee ID");
		lblPost.setBounds(10, 60, 153, 14);
		lblPost.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JButton button = new JButton("Edit Account Details");
		button.setBounds(10, 426, 140, 23);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EditAccount obj=new EditAccount(employee_id);
				obj.setVisible(true);
			}
		});
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
			},
			new String[] {
				"cp_100", "cp_200", "cp_500", "dc_100", "dc_200", "dc_500", "pasta_250", "pasta_500", "pasta_1", "gt_100", "gt_200", "gt_500", "cstp_100", "cstp_200", "cstp_500", "suggestion"
			}
		));
		table.setBounds(173, 49, 626, 454);
		contentPane.setLayout(null);
		contentPane.add(lblWelcomeToManager);
		contentPane.add(lblName);
		contentPane.add(lblPost);
		contentPane.add(comboBox);
		contentPane.add(btnCheckEmployee);
		contentPane.add(table);
		contentPane.add(button);
		
	}
}