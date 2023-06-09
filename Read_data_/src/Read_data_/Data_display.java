package Read_data_;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class Data_display {

	private JFrame frame;
	private JTextField t1;
	private JTextField t2;
	private JTable table;
	private JTextField t3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Data_display window = new Data_display();
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
	public Data_display() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(102, 205, 170));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(10, 47, 89, 30);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblMarks = new JLabel("Marks");
		lblMarks.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblMarks.setBounds(10, 88, 89, 30);
		frame.getContentPane().add(lblMarks);
		
		t1 = new JTextField();
		t1.setBounds(107, 52, 127, 20);
		frame.getContentPane().add(t1);
		t1.setColumns(10);
		
		t2 = new JTextField();
		t2.setColumns(10);
		t2.setBounds(109, 93, 127, 20);
		frame.getContentPane().add(t2);
		
		JButton btnNewButton = new JButton("submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String n=t1.getText();
				String m=t2.getText();
				float m1=Float.parseFloat(m);
				Connection con;
				try {
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/aiml","root","mrec");
					
					String q="insert into data values('"+n+"','"+m1+"')";
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
		btnNewButton.setBounds(91, 150, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Load");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/aiml","root","mrec");
					String q="select * from data";
					Statement sta=con.createStatement();
					ResultSet rs= sta.executeQuery(q);
					ResultSetMetaData rsmd=rs.getMetaData();
					DefaultTableModel model =(DefaultTableModel)table.getModel();
					int cols=rsmd.getColumnCount();
					String[] colName = new String[cols];
					for(int i=0;i<cols;i++)
					{
						colName[i]=rsmd.getColumnName(i+1);
						model.setColumnIdentifiers(colName);
						String n1,m1;
						while(rs.next())
						{
							n1=rs.getString(1);
							m1=rs.getString(2);
							String[] row= {n1,m1};
							model.addRow(row);
						}
					}
					
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
			}
		});
		btnNewButton_1.setBounds(261, 189, 68, 30);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("clear");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				table.setModel(new DefaultTableModel());
			}
		});
		btnNewButton_1_1.setBounds(339, 189, 68, 30);
		frame.getContentPane().add(btnNewButton_1_1);
		
		JScrollPane table_1 = new JScrollPane();
		table_1.setBounds(266, 41, 141, 134);
		frame.getContentPane().add(table_1);
		
		table = new JTable();
		table_1.setViewportView(table);
		
		t3 = new JTextField();
		t3.setBounds(13, 199, 86, 20);
		frame.getContentPane().add(t3);
		t3.setColumns(10);
		
		JButton btnNewButton_2 = new JButton("CHECK");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String a=t3.getText();
				float b=Float.parseFloat(a);
				Connection con;
				try {
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/aiml","root","mrec");
					
					String q="select * from data where marks="+b;
					Statement sta=con.createStatement();
					ResultSet rs= sta.executeQuery(q);
					ResultSetMetaData rsmd=rs.getMetaData();
					DefaultTableModel model =(DefaultTableModel)table.getModel();
					int cols=rsmd.getColumnCount();
					String[] colName = new String[cols];
					for(int i=0;i<cols;i++)
					{
						colName[i]=rsmd.getColumnName(i+1);
						model.setColumnIdentifiers(colName);
						String n1,m1;
						while(rs.next())
						{
							n1=rs.getString(1);
							m1=rs.getString(2);
							String[] row= {n1,m1};
							model.addRow(row);
						}
					}
					
					
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		});
		btnNewButton_2.setBounds(124, 196, 74, 23);
		frame.getContentPane().add(btnNewButton_2);
	}
}
