package com.dingli.wyl;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SelectGoods {

	private JFrame frame;
	private JTable table;
	private Object[][] jet;
	private JMenuBar menuBar;
	private JMenu menu;

	/**
	 * Launch the application.
	 */

			public void run() {
				try {
					SelectGoods window = new SelectGoods();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
			public void getJetLength(){
				Connection con=Test.getCon();
				String sql="select count(*) from [Warehouse management].[dbo].[goodsInformation]";
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
				String sql="select * from [Warehouse management].[dbo].[goodsInformation]";
				
				try {
					PreparedStatement ps=con.prepareStatement(sql);
					ResultSet rs=ps.executeQuery();
					
					int index=0;
					while(rs.next())
					{
						String gID=rs.getString(1);
						String gName=rs.getString(2);
						String code=rs.getString(3);
						int quantity=rs.getInt(4);
						String operator=rs.getString(5);
						String ventor=rs.getString(6);
						SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
						String gTime=sdf.format(rs.getDate(7));
						Object[] p={gID,gName,code,quantity,operator,ventor,gTime};
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
	public SelectGoods() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		getJetLength();
		getData();
		
		frame = new JFrame();
		frame.setBounds(100, 100, 758, 495);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 740, 448);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			jet,
			new String[] {
				"\u8D27\u7269\u7F16\u53F7", "\u8D27\u7269\u540D\u79F0", "\u5355\u636E\u53F7", "\u5E93\u5B58\u6570\u91CF", "\u8D1F\u8D23\u4EBA", "\u4F9B\u5E94\u5546", "\u8FDB\u8D27\u65F6\u95F4"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(120);
		table.getColumnModel().getColumn(1).setPreferredWidth(120);
		table.getColumnModel().getColumn(2).setPreferredWidth(100);
		table.getColumnModel().getColumn(5).setPreferredWidth(100);
		table.getColumnModel().getColumn(6).setPreferredWidth(150);
		scrollPane.setViewportView(table);
		
		menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		menu = new JMenu("\u8FD4\u56DE\u4E3B\u754C\u9762");
		menu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				MainWindow mw=new MainWindow();
				mw.main(null);
			}
		});
		menuBar.add(menu);
	}


}
