package com.dingli.wyl;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AddGoods {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;

	/**
	 * Launch the application.
	 */
	public static void addGoods(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddGoods window = new AddGoods();
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
	public AddGoods() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 734, 499);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u8D27\u7269\u7F16\u53F7");
		lblNewLabel.setFont(new Font("Î¢ÈíÑÅºÚ", Font.BOLD, 18));
		lblNewLabel.setBounds(159, 52, 83, 36);
		panel.add(lblNewLabel);
		
		JLabel label = new JLabel("\u8D27\u7269\u540D\u79F0");
		label.setFont(new Font("Î¢ÈíÑÅºÚ", Font.BOLD, 18));
		label.setBounds(159, 93, 72, 30);
		panel.add(label);
		
		JLabel label_1 = new JLabel("\u8D27\u7269\u79CD\u7C7B");
		label_1.setFont(new Font("Î¢ÈíÑÅºÚ", Font.BOLD, 18));
		label_1.setBounds(159, 138, 72, 24);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("\u8D27\u7269\u578B\u53F7");
		label_2.setFont(new Font("Î¢ÈíÑÅºÚ", Font.BOLD, 18));
		label_2.setBounds(159, 175, 72, 32);
		panel.add(label_2);
		
		JLabel label_3 = new JLabel("\u5C4F\u5E55\u5C3A\u5BF8");
		label_3.setFont(new Font("Î¢ÈíÑÅºÚ", Font.BOLD, 18));
		label_3.setBounds(159, 220, 72, 30);
		panel.add(label_3);
		
		JLabel label_4 = new JLabel("\u4F9B\u5E94\u5546");
		label_4.setFont(new Font("Î¢ÈíÑÅºÚ", Font.BOLD, 18));
		label_4.setBounds(175, 266, 67, 18);
		panel.add(label_4);
		
		JLabel label_5 = new JLabel("\u5E93\u5B58\u91CF");
		label_5.setFont(new Font("Î¢ÈíÑÅºÚ", Font.BOLD, 18));
		label_5.setBounds(175, 301, 72, 36);
		panel.add(label_5);
		
		textField = new JTextField();
		textField.setBounds(276, 60, 258, 24);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(276, 98, 258, 24);
		panel.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(276, 140, 258, 24);
		panel.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(276, 181, 258, 24);
		panel.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(276, 225, 258, 24);
		panel.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(276, 265, 258, 24);
		panel.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(276, 309, 258, 24);
		panel.add(textField_6);
		
		JButton btnNewButton = new JButton("\u786E\u8BA4\u589E\u52A0");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String goodsID=textField.getText();
				String goodsName=textField_1.getText();
				String goodsClass=textField_2.getText();
				String goodsStd=textField_3.getText();
				String volume=textField_4.getText();
				String vendor=textField_5.getText();
				String quantity=textField_6.getText();
				
				String sql="insert into [Warehouse management].[dbo].[GDMESS] (goodsID,goodsName,goodsClass,goodsStd,Volume,Vendor,lowQuantity) values ('"+goodsID+"','"+goodsName+"','"+goodsClass+"','"+goodsStd+"','"+volume+"','"+vendor+"','"+quantity+"')";	
				int result=0;
				
				Connection con=Test.getCon();
				PreparedStatement ps;
				
				try {
					ps=con.prepareStatement(sql);
					result=ps.executeUpdate();
					con.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if(result>0)
				{
					JOptionPane.showMessageDialog(null, "ÐÂÔö»õÎïµÇ¼Ç³É¹¦£¡");
				}
				else
				{
					JOptionPane.showMessageDialog(null, "ÐÂÔö»õÎïµÇ¼ÇÊ§°Ü£¡");
				}
			}
		});
		btnNewButton.setFont(new Font("Ó×Ô²", Font.BOLD, 27));
		btnNewButton.setBounds(255, 359, 187, 54);
		panel.add(btnNewButton);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("\u8FD4\u56DE\u4E3B\u754C\u9762");
		mnNewMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MainWindow mw=new MainWindow();
				mw.main(null);
			}
		});
		menuBar.add(mnNewMenu);
	}

}
