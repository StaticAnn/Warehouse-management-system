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
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DeleteGoods {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void deleteGoods(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeleteGoods window = new DeleteGoods();
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
	public DeleteGoods() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 730, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u8D27\u7269\u7F16\u53F7");
		lblNewLabel.setFont(new Font("黑体", Font.BOLD, 30));
		lblNewLabel.setBounds(136, 141, 133, 55);
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(301, 141, 279, 55);
		panel.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("\u786E\u8BA4\u5220\u9664\u8D27\u7269\u4FE1\u606F");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String goodsID=textField.getText();
				String sql="delete from [Warehouse management].[dbo].[GDMESS] where goodsID='"+goodsID+"'";
				
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
					JOptionPane.showMessageDialog(null, "删除货物记录成功！");
				}else
				{
					JOptionPane.showMessageDialog(null, "删除货物记录失败！");
				}
			}
		});
		btnNewButton.setFont(new Font("幼圆", Font.BOLD, 25));
		btnNewButton.setBounds(223, 265, 248, 83);
		panel.add(btnNewButton);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu menu = new JMenu("\u8FD4\u56DE\u4E3B\u754C\u9762");
		menu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MainWindow mw=new MainWindow();
				mw.main(null);
			}
		});
		menuBar.add(menu);
	}

}
