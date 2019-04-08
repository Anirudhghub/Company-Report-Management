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
	static JLabel lblName,lblPost,lblDatre;
	private JTable table;
	private JLabel lblNewLabel;
	
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
		setBounds(100, 100, 1274, 730);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		this.setLocationRelativeTo(this);
		
		JLabel lblWelcomeToManager = new JLabel("Welcome to Manager Portal");
		lblWelcomeToManager.setBounds(10, 14, 297, 24);
		lblWelcomeToManager.setFont(new Font("Arial", Font.BOLD, 20));
		
		comboBox = new JComboBox(Functions.getValues("user_table",employee_id));
		comboBox.setBounds(246, 63, 109, 20);
		comboBox.insertItemAt("Select", 0);
		comboBox.setSelectedIndex(0);

		

		JButton btnCheckEmployee = new JButton("Check Report");
		btnCheckEmployee.setBounds(379, 62, 136, 23);
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
				   	row= new Object[19];
				   	row[0]=res.getString(17);
				   	row[1]=res.getString(18);
				   	row[2]=res.getString(1);
					row[3]=res.getString(2);
					row[4]=res.getString(3);
					row[5]=res.getString(4);
					row[6]=res.getString(5);
					row[7]=res.getString(6);
					row[8]=res.getString(7);
					row[9]=res.getString(8);
					row[10]=res.getString(9);
					row[11]=res.getString(10);
					row[12]=res.getString(11);
					row[13]=res.getString(12);
					row[14]=res.getString(13);
					row[15]=res.getString(14);
					row[16]=res.getString(15);
					row[17]=res.getString(16);
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
		lblName.setBounds(20, 52, 216, 14);
		lblName.setForeground(Color.BLACK);
		lblName.setFont(new Font("Tahoma", Font.BOLD, 14));

		lblPost = new JLabel("Employee ID");
		lblPost.setBounds(20, 93, 226, 14);
		lblPost.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JButton button = new JButton("Edit Account Details");
		button.setBounds(564, 62, 140, 23);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EditAccount obj=new EditAccount(employee_id);
				obj.setVisible(true);
			}
		});
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
			},
			new String[] {
				"cp_100", "cp_200", "cp_500", "dc_100", "dc_200", "dc_500", "pasta_250", "pasta_500", "pasta_1", "gt_100", "gt_200", "gt_500", "cstp_100", "cstp_200", "cstp_500", "suggestion", "date", "Area"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(85);
		table.getColumnModel().getColumn(1).setPreferredWidth(85);
		table.getColumnModel().getColumn(2).setPreferredWidth(85);
		table.getColumnModel().getColumn(3).setPreferredWidth(85);
		table.getColumnModel().getColumn(4).setPreferredWidth(85);
		table.getColumnModel().getColumn(5).setPreferredWidth(85);
		table.getColumnModel().getColumn(6).setPreferredWidth(90);
		table.getColumnModel().getColumn(7).setPreferredWidth(90);
		table.getColumnModel().getColumn(8).setPreferredWidth(90);
		table.getColumnModel().getColumn(9).setPreferredWidth(85);
		table.getColumnModel().getColumn(10).setPreferredWidth(85);
		table.getColumnModel().getColumn(11).setPreferredWidth(85);
		table.getColumnModel().getColumn(12).setPreferredWidth(85);
		table.getColumnModel().getColumn(13).setPreferredWidth(85);
		table.getColumnModel().getColumn(14).setPreferredWidth(85);
		table.getColumnModel().getColumn(15).setPreferredWidth(150);
		table.getColumnModel().getColumn(16).setPreferredWidth(100);
		table.getColumnModel().getColumn(17).setPreferredWidth(100);
		table.setBounds(10, 118, 1238, 574);
		contentPane.setLayout(null);
		contentPane.add(lblWelcomeToManager);
		contentPane.add(lblName);
		contentPane.add(lblPost);
		contentPane.add(comboBox);
		contentPane.add(btnCheckEmployee);
		contentPane.add(table);
		contentPane.add(button);
		
		lblDatre = new JLabel("Date");
		lblDatre.setBounds(352, 22, 115, 14);
		contentPane.add(lblDatre);
		
		lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\my pc\\Downloads\\thumb-1920-77522.jpg"));
		lblNewLabel.setBounds(0, 0, 1248, 692);
		contentPane.add(lblNewLabel);
		
		
		
	}
}
