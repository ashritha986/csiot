package project;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class retrieval {

	private JFrame frame;
	private JTextField s;
	private JTextField n;
	private JTextField em;
	private JTextField m1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					retrieval window = new retrieval();
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
	public retrieval() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(153, 153, 153));
		frame.setBounds(100, 100, 628, 468);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Sno");
		lblNewLabel.setForeground(new Color(128, 0, 0));
		lblNewLabel.setFont(new Font("Franklin Gothic Medium", Font.BOLD, 22));
		lblNewLabel.setBounds(144, 101, 48, 44);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblName = new JLabel("Name");
		lblName.setForeground(new Color(128, 0, 0));
		lblName.setFont(new Font("Franklin Gothic Medium", Font.BOLD, 22));
		lblName.setBounds(144, 156, 91, 44);
		frame.getContentPane().add(lblName);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setForeground(new Color(128, 0, 0));
		lblEmail.setFont(new Font("Franklin Gothic Medium", Font.BOLD, 22));
		lblEmail.setBounds(144, 228, 91, 44);
		frame.getContentPane().add(lblEmail);
		
		JLabel lblMarks = new JLabel("Marks");
		lblMarks.setForeground(new Color(128, 0, 0));
		lblMarks.setFont(new Font("Franklin Gothic Medium", Font.BOLD, 22));
		lblMarks.setBounds(144, 283, 91, 44);
		frame.getContentPane().add(lblMarks);
		
		s = new JTextField();
		s.setBounds(275, 117, 129, 20);
		frame.getContentPane().add(s);
		s.setColumns(10);
		
		n = new JTextField();
		n.setColumns(10);
		n.setBounds(275, 172, 129, 20);
		frame.getContentPane().add(n);
		
		em = new JTextField();
		em.setColumns(10);
		em.setBounds(275, 244, 129, 20);
		frame.getContentPane().add(em);
		
		m1 = new JTextField();
		m1.setColumns(10);
		m1.setBounds(275, 299, 129, 20);
		frame.getContentPane().add(m1);
		
		JButton btnNewButton = new JButton("SUBMIT");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/csecs","root","mrec");
					String sno=s.getText();
				String name=n.getText();
				String email=em.getText();
				String m=m1.getText();
				float marks = Float.parseFloat(m);
					String q="Insert into student1 values('"+sno+"','"+name+"','"+email+"','"+marks+"')";
					Statement sta=con.createStatement();
					sta.executeUpdate(q);
					con.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(btnNewButton , "Done!");
			}
		});
		btnNewButton.setFont(new Font("Trebuchet MS", Font.BOLD, 23));
		btnNewButton.setBounds(198, 374, 147, 23);
		frame.getContentPane().add(btnNewButton);
	}
}
