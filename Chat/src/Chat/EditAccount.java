package Chat;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;

public class EditAccount extends JFrame {

	
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	JComboBox comboBox;
	Connection con;
	int i = 0;
	private JTextField textField_5;
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditAccount frame = new EditAccount();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
*/
	/**
	 * Create the frame.
	 */
	public EditAccount(String employee_id) {
		setTitle("Edit Account");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 443, 360);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		

		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(0, 0, 434, 322);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblName = new JLabel("Username :");
		lblName.setBounds(29, 58, 59, 14);
		panel.add(lblName);

		JLabel lblId = new JLabel("Id :");
		lblId.setBounds(31, 83, 46, 14);
		panel.add(lblId);

		JLabel lblPassword = new JLabel("Password :");
		lblPassword.setBounds(31, 108, 78, 14);
		panel.add(lblPassword);

		JLabel lblPhoneNumber = new JLabel("Phone Number :");
		lblPhoneNumber.setBounds(31, 133, 78, 14);
		panel.add(lblPhoneNumber);

		JLabel lblDepartment = new JLabel("e-mail :");
		lblDepartment.setBounds(31, 158, 78, 14);
		panel.add(lblDepartment);

		JLabel lblPost = new JLabel("Post :");
		lblPost.setBounds(31, 192, 46, 14);
		panel.add(lblPost);

		textField = new JTextField();
		textField.setBounds(212, 55, 149, 20);
		panel.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField(employee_id);
		textField_1.setColumns(10);
		textField_1.setBounds(212, 80, 149, 20);
		panel.add(textField_1);
		textField_1.setEditable(false);
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(212, 105, 149, 20);
		panel.add(textField_2);

		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(212, 130, 149, 20);
		panel.add(textField_3);

		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(212, 155, 149, 20);
		panel.add(textField_4);

		textField_5 = new JTextField();
		textField_5.setBounds(212, 231, 149, 20);
		panel.add(textField_5);
		textField_5.setColumns(10);
		comboBox = new JComboBox();
		comboBox.insertItemAt("Select", 0);
		comboBox.setSelectedIndex(0);
		comboBox.addItem("Manager");
		comboBox.addItem("employee");
		comboBox.setBounds(212, 189, 149, 20);
		panel.add(comboBox);

		JLabel label = new JLabel("Edit Account Details");
		label.setFont(new Font("Arial", Font.BOLD, 20));
		label.setBounds(123, 14, 271, 30);
		panel.add(label);

		JLabel lblIfYouAre = new JLabel("ManagerID(Manager's employeeID) :");
		lblIfYouAre.setBounds(29, 230, 177, 23);
		panel.add(lblIfYouAre);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ex) {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				con=DriverManager.getConnection("jdbc:mysql://localhost:3306/chat","root","rat");
				String query="update user_table set username=?,password=?,phone=?,e_mail=?,post=?,manager_id=? where employee_id=?";
				PreparedStatement ps=con.prepareStatement(query);
				ps.setString(1, textField.getText());
				ps.setString(2, textField_2.getText());
				ps.setString(3, textField_3.getText());
				ps.setString(4, textField_4.getText());
				ps.setString(5, (String) comboBox.getSelectedItem());
				ps.setString(6, textField_5.getText());
				ps.setString(7, textField_1.getText());
				i=ps.executeUpdate();
				if(i==0)
				{
					JOptionPane.showMessageDialog(getParent(), "Updation failed!!", "Error", JOptionPane.ERROR_MESSAGE);
				}
				if(i==1)
				{
					JOptionPane.showMessageDialog(getParent(), "Updation done!!", "Success", JOptionPane.INFORMATION_MESSAGE);
				  
				}
				}
				catch(Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
		btnUpdate.setBounds(268, 288, 89, 23);
		panel.add(btnUpdate);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				try 
				{
					Class.forName("com.mysql.jdbc.Driver");
					Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/chat","root","rat");
					String quer="Select * from user_table where employee_id=? ";
					PreparedStatement ps=conn.prepareStatement(quer);
					ps.setString(1, textField_1.getText());
					ResultSet rs=ps.executeQuery();
					while(rs.next()) 
					{
						textField.setText(rs.getString(1));
						textField_2.setText(rs.getString(3));
						textField_3.setText(rs.getString(4));
						textField_4.setText(rs.getString(5));
						comboBox.setSelectedItem(rs.getString(6));
						textField_5.setText(rs.getString(7));
					}
					ps.close();conn.close();
				}
				catch(Exception e) 
				{
					
				}
			}
		});
		btnSearch.setBounds(117, 288, 89, 23);
		panel.add(btnSearch);
	
	}
}
