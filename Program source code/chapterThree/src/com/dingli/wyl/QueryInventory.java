package com.dingli.wyl;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.naming.spi.DirStateFactory.Result;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class QueryInventory {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void QueryInventory(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QueryInventory window = new QueryInventory();
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
	public QueryInventory() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 795, 497);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel label = new JLabel("\u8D27\u7269\u540D\u79F0");
		label.setFont(new Font("微软雅黑", Font.BOLD, 30));
		label.setBounds(146, 134, 133, 46);
		panel.add(label);
		
		textField = new JTextField();
		textField.setBounds(309, 134, 299, 46);
		panel.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("\u786E\u8BA4\u67E5\u8BE2");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String gName=textField.getText();
				int num=0;
				
				Connection con=Test.getCon();
				PreparedStatement ps;
				ResultSet rs;
				String sql="DECLARE	@return_value int EXEC	@return_value = [dbo].[GoodsQuery] @goodsName ='"+ gName+"'	SELECT 'Return Value' = @return_value";
								
				try {
					ps=con.prepareCall(sql);
					rs=ps.executeQuery();
					
					while(rs.next())
					{
						num=rs.getInt(7);
					}
					
					System.out.println(num);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if(num!=0)
				{
					JOptionPane.showMessageDialog(null, gName+"还有"+num+"台！");
				}else
				{
					JOptionPane.showMessageDialog(null, gName+"已经没有库存了！");
				}
			}
		});
		btnNewButton.setFont(new Font("幼圆", Font.BOLD, 35));
		btnNewButton.setBounds(264, 285, 243, 93);
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
