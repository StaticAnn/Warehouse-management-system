package com.dingli.wyl;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class QueryGoods {

	private JFrame frame;
	private JTable table;
	private Object[][] jet;

	/**
	 * Launch the application.
	 */

			public void run() {
				try {
					QueryGoods window = new QueryGoods();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
			public void getJetLength(){
				Connection con=Test.getCon();
				String sql="select count(*) from [Warehouse management].[dbo].[GDMESS]";
				int count=0;
				try {
					PreparedStatement ps=con.prepareStatement(sql);
					ResultSet rs=ps.executeQuery();
					while(rs.next())
					{
						count=rs.getInt(1);
					}
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				jet=new Object[count][];
				
			}
			
			public void getData(){
				Connection con=Test.getCon();
				String sql="select * from [Warehouse management].[dbo].[GDMESS]";
				
				try {
					PreparedStatement ps=con.prepareStatement(sql);
					ResultSet rs=ps.executeQuery();
					int index=0;
					
					while(rs.next())
					{
						String gID=rs.getString(1);
						String gName=rs.getString(2);
						String gClass=rs.getString(3);
						String gStd=rs.getString(4);
						float volume=rs.getFloat(5);
						String vendor=rs.getString(6);
						int quantity=rs.getInt(7);
						Object[] p={gID,gName,gClass,gStd,volume,vendor,quantity};
						jet[index]=p;
						index++;
					}
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}


	/**
	 * Create the application.
	 */
	public QueryGoods() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		getJetLength();
		getData();
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 502);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 782, 455);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			jet,
			new String[] {
				"\u8D27\u7269\u7F16\u53F7", "\u8D27\u7269\u540D\u79F0", "\u8D27\u7269\u79CD\u7C7B", "\u8D27\u7269\u578B\u53F7", "\u5C4F\u5E55\u5927\u5C0F", "\u4F9B\u5E94\u5546", "\u5E93\u5B58\u6570\u91CF"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(120);
		table.getColumnModel().getColumn(1).setPreferredWidth(120);
		table.getColumnModel().getColumn(2).setPreferredWidth(120);
		scrollPane.setViewportView(table);
		
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
