package Chat;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.TextAction;

import com.mysql.jdbc.Connection;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JSpinner;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;

public class Employee extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTable table_1;
	private JTable table_2;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_14;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	private JLabel label_4;
	private JLabel label_5;
	private JLabel label_6;
	private JLabel label_7;
	private JLabel label_8;
	private JLabel label_9;
	private JLabel lblGm_3;
	private JLabel label_10;
	private JLabel lblKg;
	static JLabel lblNewLabel,lblPost,lblName,lblNewLabel_1;
	java.sql.Connection connn;
	PreparedStatement ps;
	private JButton btnEditAccountDetails;
	

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Employee frame = new Employee();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public Employee(String username,String employee_id,String date) {
		setTitle("Employee Account");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 748, 406);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel lblEmployeeReport = new JLabel("Employee Report");
		lblEmployeeReport.setBounds(45, 25, 205, 24);
		lblEmployeeReport.setFont(new Font("Arial", Font.BOLD, 20));

		JLabel lblNewLabel_3 = new JLabel("Cornflour Powder");
		lblNewLabel_3.setBounds(15, 150, 109, 14);

		JLabel lblNewLabel_4 = new JLabel("Drinking Choclate");
		lblNewLabel_4.setBounds(144, 150, 106, 14);

		JLabel lblNewLabel_5 = new JLabel("Pasta");
		lblNewLabel_5.setBounds(304, 150, 43, 14);

		JLabel lblNewLabel_6 = new JLabel("Green Tea");
		lblNewLabel_6.setBounds(428, 150, 83, 14);

		JLabel lblNewLabel_7 = new JLabel("Custard Powder");
		lblNewLabel_7.setBounds(543, 150, 117, 14);
		
		JComboBox comboBox = new JComboBox();
		comboBox.addItem("Area 1");
		comboBox.addItem("Area 2");
		comboBox.addItem("Area 3");
		comboBox.addItem("Area 4");
		comboBox.addItem("Area 5");
		comboBox.insertItemAt("(Select)", 0);
		comboBox.setSelectedIndex(0);
		comboBox.setBounds(345, 54, 148, 20);
		contentPane.add(comboBox);

		JLabel label = new JLabel("");
		label.setBounds(15, 131, 0, 0);
		JTextArea textArea = new JTextArea();
		textArea.setBounds(528, 16, 132, 78);
		textArea.setColumns(50);
		textArea.setRows(10);
		JButton btnSave = new JButton("SAVE");
		btnSave.setBounds(569, 316, 70, 23);
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ex) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					connn = DriverManager.getConnection("jdbc:mysql://localhost:3306/chat", "root", "rat");
					String query = "insert into "+username+" values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ";
					ps = connn.prepareStatement(query);
					ps.setString(1, textField.getText());
					ps.setString(2, textField_1.getText());
					ps.setString(3, textField_2.getText());
					ps.setString(4, textField_3.getText());
					ps.setString(5, textField_4.getText());
					ps.setString(6, textField_5.getText());
					ps.setString(7, textField_6.getText());
					ps.setString(8, textField_7.getText());
					ps.setString(9, textField_8.getText());
					ps.setString(10, textField_9.getText());
					ps.setString(11, textField_10.getText());
					ps.setString(12, textField_11.getText());
					ps.setString(13, textField_12.getText());
					ps.setString(14, textField_13.getText());
					ps.setString(15, textField_14.getText());
					ps.setString(16, textArea.getText());
					ps.setString(17, date);
					ps.setString(18, (String) comboBox.getSelectedItem());
					ps.execute();
					ps.close();
					connn.close();
				} catch (Exception aet) {
					aet.printStackTrace();
				}
			}
		});

		JButton btnReset = new JButton("RESET");
		btnReset.setBounds(486, 316, 73, 23);

		JSeparator separator = new JSeparator();
		separator.setBounds(5, 170, 734, 25);

		JLabel lblSuggestionqueries = new JLabel("Suggestion/Queries :");
		lblSuggestionqueries.setBounds(345, 18, 147, 17);
		lblSuggestionqueries.setFont(new Font("Tahoma", Font.BOLD, 14));

		table = new JTable();
		table.setBounds(27, 74, 34, 0);

		table_1 = new JTable();
		table_1.setBounds(98, 88, 1, 1);

		table_2 = new JTable();
		table_2.setBounds(144, 93, 1, 1);

		JLabel lblGm = new JLabel("100 gm");
		lblGm.setBounds(5, 204, 45, 14);

		JLabel lblGm_1 = new JLabel("200 gm");
		lblGm_1.setBounds(5, 242, 45, 14);

		JLabel lblGm_2 = new JLabel("500 gm");
		lblGm_2.setBounds(5, 280, 45, 14);

		textField = new JTextField();
		textField.setBounds(54, 201, 70, 20);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setBounds(54, 239, 70, 20);
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setBounds(54, 277, 70, 20);
		textField_2.setColumns(10);

		textField_3 = new JTextField();
		textField_3.setBounds(181, 201, 70, 20);
		textField_3.setColumns(10);

		textField_4 = new JTextField();
		textField_4.setBounds(181, 239, 70, 20);
		textField_4.setColumns(10);

		textField_5 = new JTextField();
		textField_5.setBounds(181, 277, 70, 20);
		textField_5.setColumns(10);

		textField_6 = new JTextField();
		textField_6.setBounds(304, 201, 70, 20);
		textField_6.setColumns(10);

		textField_7 = new JTextField();
		textField_7.setBounds(304, 239, 70, 20);
		textField_7.setColumns(10);

		textField_8 = new JTextField();
		textField_8.setBounds(304, 277, 70, 20);
		textField_8.setColumns(10);

		textField_9 = new JTextField();
		textField_9.setBounds(441, 201, 70, 20);
		textField_9.setColumns(10);

		textField_10 = new JTextField();
		textField_10.setBounds(441, 239, 70, 20);
		textField_10.setColumns(10);

		textField_11 = new JTextField();
		textField_11.setBounds(441, 277, 70, 20);
		textField_11.setColumns(10);

		textField_12 = new JTextField();
		textField_12.setBounds(571, 201, 70, 20);
		textField_12.setColumns(10);

		textField_13 = new JTextField();
		textField_13.setBounds(571, 239, 70, 20);
		textField_13.setColumns(10);

		textField_14 = new JTextField();
		textField_14.setBounds(571, 277, 70, 20);
		textField_14.setColumns(10);

		label_1 = new JLabel("100 gm");
		label_1.setBounds(139, 204, 43, 14);

		label_2 = new JLabel("200 gm");
		label_2.setBounds(139, 242, 43, 14);

		label_3 = new JLabel("500 gm");
		label_3.setBounds(139, 280, 43, 14);

		label_4 = new JLabel("100 gm");
		label_4.setBounds(398, 204, 46, 14);

		label_5 = new JLabel("200 gm");
		label_5.setBounds(398, 242, 46, 14);

		label_6 = new JLabel("500 gm");
		label_6.setBounds(398, 280, 46, 14);

		label_7 = new JLabel("100 gm");
		label_7.setBounds(529, 204, 43, 14);

		label_8 = new JLabel("200 gm");
		label_8.setBounds(529, 242, 43, 14);

		label_9 = new JLabel("500 gm");
		label_9.setBounds(529, 280, 43, 14);

		lblGm_3 = new JLabel("250 gm");
		lblGm_3.setBounds(261, 204, 42, 14);

		label_10 = new JLabel("500 gm");
		label_10.setBounds(261, 242, 54, 14);

		lblKg = new JLabel("1 kg");
		lblKg.setBounds(266, 280, 38, 14);

		lblName = new JLabel("Name");
		lblName.setBounds(5, 106, 140, 14);

		lblPost = new JLabel("Employee ID");
		lblPost.setBounds(180, 106, 148, 14);
		
		contentPane.setLayout(null);
		contentPane.add(table);
		contentPane.add(table_1);
		contentPane.add(table_2);
		contentPane.add(lblEmployeeReport);
		contentPane.add(label);
		contentPane.add(lblNewLabel_3);
		contentPane.add(lblNewLabel_4);
		contentPane.add(lblName);
		contentPane.add(lblPost);
		contentPane.add(lblSuggestionqueries);
		contentPane.add(lblNewLabel_6);
		contentPane.add(lblNewLabel_5);
		contentPane.add(textArea);
		contentPane.add(lblNewLabel_7);
		contentPane.add(lblGm);
		contentPane.add(textField);
		contentPane.add(lblGm_1);
		contentPane.add(textField_1);
		contentPane.add(lblGm_2);
		contentPane.add(textField_2);
		contentPane.add(label_1);
		contentPane.add(label_2);
		contentPane.add(label_3);
		contentPane.add(textField_4);
		contentPane.add(textField_3);
		contentPane.add(textField_5);
		contentPane.add(lblGm_3);
		contentPane.add(textField_6);
		contentPane.add(label_10);
		contentPane.add(textField_7);
		contentPane.add(lblKg);
		contentPane.add(textField_8);
		contentPane.add(label_5);
		contentPane.add(label_4);
		contentPane.add(label_6);
		contentPane.add(textField_10);
		contentPane.add(textField_11);
		contentPane.add(textField_9);
		contentPane.add(label_7);
		contentPane.add(label_8);
		contentPane.add(label_9);
		contentPane.add(btnReset);
		contentPane.add(btnSave);
		contentPane.add(textField_14);
		contentPane.add(textField_13);
		contentPane.add(textField_12);
		contentPane.add(separator);
		
		btnEditAccountDetails = new JButton("Edit Account Details");
		btnEditAccountDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EditAccount obj=new EditAccount(employee_id);
				obj.setVisible(true);
			}
		});
		btnEditAccountDetails.setBounds(5, 316, 140, 23);
		contentPane.add(btnEditAccountDetails);
		
		lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(351, 106, 160, 14);
		contentPane.add(lblNewLabel_1);
		
		
		
		JLabel lblArea = new JLabel("AREA : ");
		lblArea.setFont(new Font("Arial", Font.BOLD, 14));
		lblArea.setBounds(261, 60, 59, 14);
		contentPane.add(lblArea);
		
		
	}
}
