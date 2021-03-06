package Chat;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class SignIn extends JFrame {

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
	/*
	 * public static void main(String[] args) { EventQueue.invokeLater(new
	 * Runnable() { public void run() { try { SignIn frame = new SignIn();
	 * frame.setVisible(true); } catch (Exception e) { e.printStackTrace(); } } });
	 * }
	 */

	/**
	 * Create the frame.
	 */
	public SignIn() {
		setTitle("SignIn Page");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 443, 360);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		String id = "";
		for (int i = 1; i <= 6; i++) {
			id += (int) (Math.random() * 9) + 1;
			//System.out.println(i);
		}

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

		textField_1 = new JTextField(id);
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

		JButton btnNewButton = new JButton("SignIn");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e1) {
				String s = e1.getActionCommand();
				if (s == "SignIn") {
					try {
						Class.forName("com.mysql.jdbc.Driver");
						con = DriverManager.getConnection("jdbc:mysql://localhost:3306/chat", "root", "rat");
						String username=textField.getText();
						String employee_id=textField.getText();
						String query = "insert into user_table values(?,?,?,?,?,?,?)";
						String query2 = "insert into login values(?,?,?) ";
						
						PreparedStatement ps = con.prepareStatement(query);
						PreparedStatement ps2 = con.prepareStatement(query2);
						
						ps.setString(1, username);
						ps.setString(2, textField_1.getText());
						ps.setString(3, textField_2.getText());
						ps.setString(4, textField_3.getText());
						ps.setString(5, textField_4.getText());
						ps.setString(6, (String) comboBox.getSelectedItem());
						ps.setString(7, textField_5.getText());
						ps2.setString(1, username);
						ps2.setString(2, textField_2.getText());
						ps2.setString(3, (String) comboBox.getSelectedItem());
						if((String) comboBox.getSelectedItem()=="employee" && textField_5.getText().equals("")) 
						{
							JOptionPane.showMessageDialog(getParent(), "enter the managerID");
						}
						
						ps2.executeUpdate();
						i = ps.executeUpdate();
						
						if (i == 1) {
							String query3 ="create table "+username+" select * from employee ";
							PreparedStatement ps3=con.prepareStatement(query3);
							int j=ps3.executeUpdate();
							if(j==1) 
							{
								JOptionPane.showMessageDialog(getParent(), "Database created!!");
							}
							ps3.close();
							JOptionPane.showMessageDialog(getParent(), i + " Record inserted", "Update",
									JOptionPane.INFORMATION_MESSAGE);
							textField.setText(null);
							textField_1.setText(null);
							textField_2.setText(null);
							textField_3.setText(null);
							textField_4.setText(null);
							textField_5.setText(null);
							comboBox.setSelectedIndex(0);
						} else {
							JOptionPane.showMessageDialog(getParent(), "Updation unsuccessfull", "Error",
									JOptionPane.ERROR_MESSAGE);
							
						}
						ps2.close();
						ps.close();
						
						con.close();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}
			}
		});
		btnNewButton.setBounds(74, 288, 89, 23);
		panel.add(btnNewButton);

		JButton btnReset = new JButton("RESET");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(null);
				textField_1.setText(null);
				textField_2.setText(null);
				textField_3.setText(null);
				textField_4.setText(null);
				textField_5.setText(null);
				comboBox.setSelectedIndex(0);
				
			}
		});
		btnReset.setBounds(191, 288, 89, 23);
		panel.add(btnReset);

		JLabel lblSigninPage = new JLabel("SignIn Page");
		lblSigninPage.setFont(new Font("Arial", Font.BOLD, 20));
		lblSigninPage.setBounds(126, 14, 154, 30);
		panel.add(lblSigninPage);

		JLabel lblIfYouAre = new JLabel("ManagerID(Manager's employeeID) :");
		lblIfYouAre.setBounds(29, 230, 177, 23);
		panel.add(lblIfYouAre);

		
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\my pc\\Downloads\\short.jpg"));
		lblNewLabel.setBounds(0, 0, 424, 322);
		panel.add(lblNewLabel);
	}
}
