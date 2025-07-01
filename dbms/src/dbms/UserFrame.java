package dbms;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.sql.*;

import javax.swing.JOptionPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;

public class UserFrame extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserFrame frame = new UserFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	Connection conn = null;

	/**
	 * Create the frame.
	 */
	public UserFrame() {
		conn = ConnectDB.dbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton DisplayBT = new JButton("Display");
		DisplayBT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query = "select * from users";
					PreparedStatement pst = conn.prepareStatement(query);
					ResultSet rs = pst.executeQuery(query);
					ResultSetMetaData rsmd=rs.getMetaData();
					DefaultTableModel model=(DefaultTableModel) table.getModel();
					int cols=rsmd.getColumnCount();
					String[] colName= {"UName","Password"};
					model.setColumnIdentifiers(colName);
					String UName,Password;
					while(rs.next()) {
						UName=rs.getString(1);
						Password=rs.getString(2);
						String[] row= {UName,Password};
						model.addRow(row);
					}
					pst.close();
					conn.close();
				}

				catch (Exception ae) {
					ae.printStackTrace();
				}
			}
		});
		DisplayBT.setBounds(525, 160, 98, 34);
		contentPane.add(DisplayBT);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(409, 241, 332, 160);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Dell\\Desktop\\mini project\\icons\\userbig1.jpg"));
		lblNewLabel.setBounds(35, 50, 320, 350);
		contentPane.add(lblNewLabel);
		
		JLabel UsersBT = new JLabel("Users:");
		UsersBT.setFont(new Font("Times New Roman", Font.BOLD, 25));
		UsersBT.setBounds(409, 50, 170, 50);
		contentPane.add(UsersBT);
		
		JButton BackBT = new JButton("Back");
		BackBT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame MF = new MainFrame();
				MF.setVisible(true);
			}
		});
		BackBT.setBounds(685, 427, 89, 23);
		contentPane.add(BackBT);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(0, 0, 997, 616);
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Dell\\Desktop\\mini project\\icons\\backfrm1.png"));
		contentPane.add(lblNewLabel_1);
		
	}
}
