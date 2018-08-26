package com.dingli.wyl;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainWindow {

	private JFrame frame;
	private static int num=0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				if(num==0)
				{
					TestWB test=new TestWB();
					test.dengLu(null);
					num++;
				}

				try {
					MainWindow window = new MainWindow();
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
	public MainWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 729, 488);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setBounds(89, 13, 72, 18);
		panel.add(label);
		
		JButton btnNewButton = new JButton("\u65B0\u589E\u8D27\u7269\u767B\u8BB0");
		btnNewButton.setFont(new Font("Î¢ÈíÑÅºÚ", Font.BOLD, 20));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddGoods ag=new AddGoods();
				ag.addGoods(null);
				
			}
		});
		btnNewButton.setBounds(167, 191, 159, 56);
		panel.add(btnNewButton);
		
		JButton button = new JButton("\u8D27\u7269\u5220\u9664\u767B\u8BB0");
		button.setFont(new Font("Î¢ÈíÑÅºÚ", Font.BOLD, 20));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeleteGoods dg=new DeleteGoods();
				dg.deleteGoods(null);
				
			}
		});
		button.setBounds(390, 191, 159, 56);
		panel.add(button);
		
		JButton button_1 = new JButton("\u67E5\u8BE2\u8D27\u7269\u660E\u7EC6");
		button_1.setFont(new Font("Î¢ÈíÑÅºÚ", Font.BOLD, 20));
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SelectGoods sg=new SelectGoods();
				sg.run();
			}
		});
		button_1.setBounds(167, 329, 159, 56);
		panel.add(button_1);
		
		JButton button_2 = new JButton("\u4FEE\u6539\u8D27\u7269\u4FE1\u606F");
		button_2.setFont(new Font("Î¢ÈíÑÅºÚ", Font.BOLD, 20));
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UpdateGoods ug=new UpdateGoods();
				ug.upDateGoods(null);
			}
		});
		button_2.setBounds(390, 260, 159, 56);
		panel.add(button_2);
		
		JLabel label_1 = new JLabel("\u4ED3\u5E93\u7BA1\u7406\u7CFB\u7EDF");
		label_1.setFont(new Font("Ó×Ô²", Font.PLAIN, 60));
		label_1.setBounds(167, 42, 382, 136);
		panel.add(label_1);
		
		JButton btnNewButton_1 = new JButton("\u8D27\u7269\u6570\u91CF\u67E5\u8BE2");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				QueryGoods qg=new QueryGoods();
				qg.run();
			}
		});
		btnNewButton_1.setFont(new Font("Î¢ÈíÑÅºÚ", Font.BOLD, 20));
		btnNewButton_1.setBounds(167, 260, 159, 56);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("\u5269\u4F59\u5E93\u5B58\u67E5\u8BE2");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				QueryInventory qi=new QueryInventory();
				qi.QueryInventory(null);
			}
		});
		btnNewButton_2.setFont(new Font("Î¢ÈíÑÅºÚ", Font.BOLD, 20));
		btnNewButton_2.setBounds(390, 329, 159, 56);
		panel.add(btnNewButton_2);
	}
}
