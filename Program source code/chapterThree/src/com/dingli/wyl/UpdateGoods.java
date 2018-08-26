package com.dingli.wyl;

import java.awt.EventQueue;
import java.util.Date;
import java.text.SimpleDateFormat;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.print.attribute.standard.DateTimeAtCompleted;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UpdateGoods {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void upDateGoods(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateGoods window = new UpdateGoods();
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
	public UpdateGoods() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 735, 501);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel label = new JLabel("\u8D27\u7269\u7F16\u53F7");
		label.setFont(new Font("黑体", Font.BOLD, 20));
		label.setBounds(147, 43, 92, 24);
		panel.add(label);
		
		JLabel label_2 = new JLabel("\u8D27\u7269\u540D\u79F0");
		label_2.setFont(new Font("黑体", Font.BOLD, 20));
		label_2.setBounds(147, 97, 92, 24);
		panel.add(label_2);
		
		JLabel label_4 = new JLabel("\u8D27\u7269\u6570\u91CF");
		label_4.setFont(new Font("黑体", Font.BOLD, 20));
		label_4.setBounds(147, 150, 92, 24);
		panel.add(label_4);
		
		JLabel label_6 = new JLabel("\u5C4F\u5E55\u5C3A\u5BF8");
		label_6.setFont(new Font("黑体", Font.BOLD, 20));
		label_6.setBounds(147, 202, 92, 24);
		panel.add(label_6);
		
		JLabel label_8 = new JLabel("\u4F9B\u5E94\u5546");
		label_8.setFont(new Font("黑体", Font.BOLD, 20));
		label_8.setBounds(170, 253, 69, 24);
		panel.add(label_8);
		
		textField = new JTextField();
		textField.setBounds(268, 43, 289, 24);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(268, 97, 289, 24);
		panel.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(268, 150, 289, 24);
		panel.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(268, 202, 289, 24);
		panel.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(268, 253, 289, 24);
		panel.add(textField_4);
		
		JButton btnNewButton = new JButton("\u786E\u8BA4\u4FEE\u6539");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String goodsID=textField.getText();
				String goodsName=textField_1.getText();
				String quantity=textField_2.getText();
				String volume=textField_3.getText();
				String vendor=textField_4.getText();
				
				String sql="update [Warehouse management].[dbo].[GDMESS] set lowQuantity='"+quantity+"',Volume='"+volume+"',Vendor='"+vendor+"' where goodsID="+goodsID;
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
					JOptionPane.showMessageDialog(null, "修改货物记录成功！");
				}
				else
				{
					JOptionPane.showMessageDialog(null, "修改货物记录失败！");
				}
			}
		});
		btnNewButton.setFont(new Font("幼圆", Font.PLAIN, 25));
		btnNewButton.setBounds(256, 325, 221, 69);
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
