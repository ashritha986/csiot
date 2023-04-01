package project;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class checkmarks {

	private JFrame frame;
	private JTextField t1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					checkmarks window = new checkmarks();
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
	public checkmarks() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(95, 158, 160));
		frame.setBounds(100, 100, 617, 443);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("MARKSHEET");
		lblNewLabel.setFont(new Font("Ink Free", Font.BOLD, 22));
		lblNewLabel.setBounds(223, 28, 184, 36);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lb1 = new JLabel("Name");
		lb1.setForeground(new Color(102, 102, 0));
		lb1.setFont(new Font("Ink Free", Font.BOLD, 22));
		lb1.setBounds(111, 208, 296, 36);
		frame.getContentPane().add(lb1);
		
		JLabel lb2 = new JLabel("Marks\r\n");
		lb2.setForeground(new Color(102, 102, 0));
		lb2.setFont(new Font("Ink Free", Font.BOLD, 22));
		lb2.setBounds(111, 255, 403, 36);
		frame.getContentPane().add(lb2);
		
		JLabel lblSno = new JLabel("Your Sno");
		lblSno.setForeground(new Color(102, 102, 0));
		lblSno.setFont(new Font("Ink Free", Font.BOLD, 22));
		lblSno.setBounds(78, 81, 115, 36);
		frame.getContentPane().add(lblSno);
		
		t1 = new JTextField();
		t1.setColumns(10);
		t1.setBounds(243, 91, 141, 20);
		frame.getContentPane().add(t1);
		
		JButton btnNewButton = new JButton("Get Marks");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s=t1.getText();
				int sno=Integer.parseInt(s);
				try {
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/csecs","root","mrec");
					String q="select name,marks from student1 where sno=?";
					PreparedStatement ps = con.prepareStatement(q);
					ps.setInt(1, sno);
					ResultSet rs=ps.executeQuery();
					rs.next();
					lb1.setText("Name: "+rs.getString(1));
					lb2.setText("Marks: "+rs.getInt(2));
					
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		});
		btnNewButton.setBackground(new Color(240, 248, 255));
		btnNewButton.setFont(new Font("Microsoft Himalaya", Font.PLAIN, 22));
		btnNewButton.setBounds(221, 140, 115, 31);
		frame.getContentPane().add(btnNewButton);
	}

}
