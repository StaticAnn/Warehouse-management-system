package com.dingli.wyl;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class RegisteredWindow {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void zhuCe(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisteredWindow window = new RegisteredWindow();
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
	public RegisteredWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 729, 497);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel label = new JLabel("\u8D1F\u8D23\u4EBA\u59D3\u540D");
		label.setFont(new Font("ºÚÌå", Font.BOLD, 25));
		label.setBounds(116, 104, 138, 39);
		panel.add(label);
		
		JLabel label_1 = new JLabel("\u8D1F\u8D23\u4EBA\u8D26\u53F7");
		label_1.setFont(new Font("ºÚÌå", Font.BOLD, 25));
		label_1.setBounds(116, 170, 138, 39);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("\u8D1F\u8D23\u4EBA\u5BC6\u7801");
		label_2.setFont(new Font("ºÚÌå", Font.BOLD, 25));
		label_2.setBounds(116, 238, 138, 39);
		panel.add(label_2);
		
		textField = new JTextField();
		textField.setBounds(292, 104, 265, 39);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(292, 174, 265, 39);
		panel.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(292, 238, 265, 39);
		panel.add(textField_2);
		
		JButton button = new JButton("\u6CE8\u518C");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String name=textField.getText();
				String userNmae=textField_1.getText();
				String passWord=textField_2.getText();
				
				String sql="insert into [Warehouse management].[dbo].[Managment] (PassWord,Person,mID) values ('"+passWord+"','"+name+"','"+userNmae+"')";	
				
				int result=0;
				
				Connection con=Test.getCon();
				PreparedStatement ps;
				
				try {
					ps=con.prepareStatement(sql);
					result=ps.executeUpdate();
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(result>0)
				{
					JOptionPane.showMessageDialog(null, "×¢²á³É¹¦£¡");
				}
				else
				{
					JOptionPane.showMessageDialog(null, "×¢²áÊ§°Ü£¡");
				}
				
			}
		});
		button.setFont(new Font("Ó×Ô²", Font.BOLD, 25));
		button.setBounds(135, 337, 206, 66);
		panel.add(button);
		
		JButton btnNewButton = new JButton("\u8FD4\u56DE\u767B\u9646\u754C\u9762");
		btnNewButton.setFont(new Font("Ó×Ô²", Font.BOLD, 25));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TestWB test=new TestWB();
				test.dengLu(null);
			}
		});
		btnNewButton.setBounds(351, 337, 206, 66);
		panel.add(btnNewButton);
	}

}
