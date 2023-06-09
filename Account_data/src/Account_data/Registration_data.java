package Account_data;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class Registration_data {

	private JFrame frame;
	private JTextField t1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registration_data window = new Registration_data();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Registration_data() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(175, 238, 238));
		frame.setBounds(100, 100, 381, 403);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Registration");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(113, 11, 143, 31);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(20, 65, 69, 31);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Gender");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_1.setBounds(20, 107, 69, 31);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Branch");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_2.setBounds(20, 149, 69, 31);
		frame.getContentPane().add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Programming ");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_3.setBounds(20, 191, 119, 31);
		frame.getContentPane().add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("language");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_4.setBounds(20, 210, 69, 25);
		frame.getContentPane().add(lblNewLabel_1_4);
		
		t1 = new JTextField();
		t1.setBounds(133, 72, 190, 20);
		frame.getContentPane().add(t1);
		t1.setColumns(10);
		
		JRadioButton r1 = new JRadioButton("Female");
		r1.setBackground(new Color(175, 238, 238));
		r1.setFont(new Font("Tahoma", Font.BOLD, 11));
		r1.setBounds(133, 113, 69, 23);
		frame.getContentPane().add(r1);
		
		JRadioButton r2 = new JRadioButton("Male");
		r2.setBackground(new Color(175, 238, 238));
		r2.setFont(new Font("Tahoma", Font.BOLD, 11));
		r2.setBounds(232, 113, 69, 23);
		frame.getContentPane().add(r2);
		
		ButtonGroup bg=new ButtonGroup();
		bg.add(r1);
		bg.add(r2);
		
		JComboBox co1 = new JComboBox();
		co1.setBackground(new Color(245, 245, 245));
		co1.setFont(new Font("Tahoma", Font.BOLD, 11));
		co1.setModel(new DefaultComboBoxModel(new String[] {"Select", "CSE", "ECE", "IT", "MECH", "AIML", "IOT", "CS", "DS", "EEE"}));
		co1.setBounds(133, 155, 190, 22);
		frame.getContentPane().add(co1);
		
		JCheckBox c1 = new JCheckBox("c\r\n");
		c1.setBackground(new Color(175, 238, 238));
		c1.setFont(new Font("Tahoma", Font.BOLD, 11));
		c1.setBounds(133, 199, 41, 23);
		frame.getContentPane().add(c1);
		
		JCheckBox c2 = new JCheckBox("Python");
		c2.setFont(new Font("Tahoma", Font.BOLD, 11));
		c2.setBackground(new Color(175, 238, 238));
		c2.setBounds(176, 197, 69, 23);
		frame.getContentPane().add(c2);
		
		JCheckBox c3 = new JCheckBox("Java");
		c3.setFont(new Font("Tahoma", Font.BOLD, 11));
		c3.setBackground(new Color(175, 238, 238));
		c3.setBounds(247, 197, 76, 23);
		frame.getContentPane().add(c3);
		
		JButton btnNewButton = new JButton("SUBMIT");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String n=t1.getText();
				String g;
				if(r1.isSelected() )
				{
					g="female";
					
				}
				else if(r2.isSelected())
				{
					g="Male";
					
				}
				else
				{
					g="invalid";
					
				}
				String b=(String)co1.getSelectedItem();
				String pl;
				if(c1.isSelected() && c2.isSelected() && c3.isSelected()) {
					pl="c,Python ,java";
					
				}
				else if(c2.isSelected() && c1.isSelected())
				{
					pl="c,python";
					
				}
				else if(c3.isSelected() && c1.isSelected())
				{
					pl="c,java";
				}
				else if(c2.isSelected() && c3.isSelected())
				{
					pl="python,java";
				}
				else if(c2.isSelected())
				{
					pl="python"; 
				}
				else if(c1.isSelected())
				{
					pl="c";
				}
				
				else
				{
					pl="java";
				}
				
				try {
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/aiml","root","mrec");
					String q="insert into account values('"+n+"','"+g+"','"+b+"','"+pl+"')";
					Statement sta=con.createStatement();
					sta.execute(q);
					con.close();
					JOptionPane.showMessageDialog(btnNewButton, "Done!");
					
					
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton.setBounds(113, 275, 132, 44);
		frame.getContentPane().add(btnNewButton);
	}
}
