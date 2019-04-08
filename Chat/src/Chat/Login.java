package Chat;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	Connection conn;
	private JPasswordField passwordField;
	static String username,employee_id,date;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setTitle("LogIn Page");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");  
		   LocalDateTime now = LocalDateTime.now();  
		   date=dtf.format(now);
		   
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Arial", Font.BOLD, 16));
		lblUsername.setBounds(57, 91, 80, 14);
		contentPane.add(lblUsername);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Arial", Font.BOLD, 16));
		lblPassword.setBounds(57, 137, 80, 14);
		contentPane.add(lblPassword);

		textField = new JTextField();
		textField.setBounds(157, 88, 137, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(157, 136, 137, 20);
		contentPane.add(passwordField);

		JButton btnNewButton_1 = new JButton("SignIn");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SignIn s = new SignIn();
				s.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(205, 189, 89, 23);
		contentPane.add(btnNewButton_1);

		JLabel lblReportEntry = new JLabel("Report Entry");
		lblReportEntry.setFont(new Font("Arial", Font.BOLD, 20));
		lblReportEntry.setBounds(140, 28, 154, 30);
		contentPane.add(lblReportEntry);

		JLabel lblSigninIfDo = new JLabel("SignIn If do not have account");
		lblSigninIfDo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblSigninIfDo.setBounds(93, 223, 190, 14);
		contentPane.add(lblSigninIfDo);
		
		
		
		JButton btnLogIn = new JButton("Log in");
		btnLogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/chat","root","rat");
				String query="Select * from user_table where username=? and password=? ";
				char ch[]=passwordField.getPassword();
				String post="";
				String pass=String.copyValueOf(ch);
				PreparedStatement ps=con.prepareStatement(query);
				
				ps.setString(1, textField.getText());
				ps.setString(2, pass);
				ResultSet rs=ps.executeQuery();
				while(rs.next()) 
				{
					post=rs.getString("post");
					username=rs.getString("username");
					employee_id=rs.getString("employee_id");
					String manager_id=rs.getString("manager_id");
				}
				if(post.equalsIgnoreCase("manager")) 
				{
					ManagerPortal obj=new ManagerPortal(employee_id);
					obj.setVisible(true);
					obj.setLocationRelativeTo(null);
					ManagerPortal.lblName.setText("Welcome "+username);
					ManagerPortal.lblPost.setText("Employee ID : "+employee_id);
					ManagerPortal.lblDatre.setText("DATE : "+date);
				}
				if(post.equalsIgnoreCase("employee")) 
				{
					Employee obj1=new Employee(username,employee_id,date);
					obj1.setVisible(true);
					Employee.lblName.setText("Welcome "+username);
					Employee.lblPost.setText("Employee ID : "+employee_id);
					Employee.lblNewLabel_1.setText("DATE : "+date);
				}ps.close();con.close();
					}
					
			catch(Exception ae) 
				{
				ae.printStackTrace();
				}
				
				}
		});
		btnLogIn.setBounds(93, 189, 89, 23);
		contentPane.add(btnLogIn);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\my pc\\Downloads\\short.jpg"));
		lblNewLabel.setBounds(0, 0, 434, 262);
		contentPane.add(lblNewLabel);

		
	}
}
