package friendship;

import java.awt.EventQueue;
import java.util.Random;
import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFormattedTextField;

public class friendship_calculator {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JLabel lblNewLabel_2;
	private JFormattedTextField frmtdtxtfldFriendship;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					friendship_calculator window = new friendship_calculator();
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
	public friendship_calculator() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(165, 42, 42));
		frame.setBounds(100, 100, 519, 418);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Friendship Calculator");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel.setBounds(147, 21, 226, 42);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Your name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(29, 95, 128, 42);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Your Friend name");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_1.setBounds(29, 148, 143, 42);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		textField = new JTextField();
		textField.setBounds(199, 143, 86, -28);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(199, 108, 186, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(199, 161, 186, 20);
		frame.getContentPane().add(textField_2);
		
		JButton btnNewButton = new JButton("Check Friendship %");
		btnNewButton.setBackground(new Color(240, 230, 140));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Random r=new Random();
				int p= r.nextInt(1,100);
				
				frmtdtxtfldFriendship = new JFormattedTextField();
				frmtdtxtfldFriendship.setBackground(new Color(255, 222, 173));
				frmtdtxtfldFriendship.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
				frmtdtxtfldFriendship.setText("   Friendship% = "+p);
				frmtdtxtfldFriendship.setBounds(158, 221, 186, 57);
				frame.getContentPane().add(frmtdtxtfldFriendship);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBounds(158, 304, 186, 30);
		frame.getContentPane().add(btnNewButton);
		
		
		
		
		
		
		
		
	}
}
