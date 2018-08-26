package com.dingli.wyl;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.awt.Font;


public class TestWB {

	private JFrame frame;
	private JTextField textField;
	private JLabel lblNewLabel;
	private JLabel label;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void dengLu(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TestWB window = new TestWB();
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
	public TestWB() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 726, 486);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(293, 121, 236, 42);
		panel.add(textField);
		textField.setColumns(10);
		
		lblNewLabel = new JLabel("\u7528\u6237\u540D\uFF1A");
		lblNewLabel.setFont(new Font("Î¢ÈíÑÅºÚ", Font.BOLD, 15));
		lblNewLabel.setBounds(177, 120, 72, 44);
		panel.add(lblNewLabel);
		
		label = new JLabel("\u5BC6\u7801\uFF1A");
		label.setFont(new Font("Î¢ÈíÑÅºÚ", Font.BOLD, 15));
		label.setBounds(177, 190, 72, 47);
		panel.add(label);
		
		textField_1 = new JTextField();
		textField_1.setBounds(293, 192, 236, 42);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("\u767B\u9646");
		btnNewButton.setFont(new Font("Ó×Ô²", Font.BOLD, 20));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String userName=textField.getText();
				String passWord=textField_1.getText();
				String sql="select COUNT(*) from [Warehouse management].[dbo].[Managment] where mID='"+userName+"' and PassWord='"+passWord+"'";
				
				Connection con=Test.getCon();
				PreparedStatement ps;
					
				int result=0;
				try {
					ps=con.prepareStatement(sql);
					ResultSet rs=ps.executeQuery();
					
					while(rs.next())
					{
						result=rs.getInt(1);
					}
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(result);
				if(result>=1)
				{
					MainWindow mw=new MainWindow();
					mw.main(null);
				}
				else
				{
					JOptionPane.showMessageDialog(null, "µÇÂ½Ê§°Ü£¡");
				}
				
				
			}
		});
		btnNewButton.setBounds(177, 315, 126, 57);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u6CE8\u518C");
		btnNewButton_1.setFont(new Font("Ó×Ô²", Font.BOLD, 20));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegisteredWindow rw=new RegisteredWindow();
				rw.zhuCe(null);
			}
		});
		btnNewButton_1.setBounds(378, 315, 126, 57);
		panel.add(btnNewButton_1);
	}
}
