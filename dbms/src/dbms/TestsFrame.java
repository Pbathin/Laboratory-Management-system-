package dbms;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TestsFrame extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TestsFrame frame = new TestsFrame();
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
	public TestsFrame() {
		conn = ConnectDB.dbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTests = new JLabel("Tests:");
		lblTests.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblTests.setBounds(28, 29, 155, 40);
		contentPane.add(lblTests);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(28, 108, 606, 342);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton DisplayBT = new JButton("Display");
		DisplayBT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query = "select Sid,Date,concat(B1,B2,B3,B4,U1,U2,U3,S1,S2,S3) AS TestName from samples";
					PreparedStatement pst = conn.prepareStatement(query);
					ResultSet rs = pst.executeQuery(query);
					ResultSetMetaData rsmd=rs.getMetaData();
					DefaultTableModel model=(DefaultTableModel) table.getModel();
					int cols=rsmd.getColumnCount();
					String[] colName={"Sid","Date","TestName"};
					model.setColumnIdentifiers(colName);
					String Sid,Date,TestType;
					while(rs.next()) {
						Sid=rs.getString(1);
						Date=rs.getString(2);
						TestType=rs.getString(3);
						String[] row= {Sid,Date,TestType};
						model.addRow(row);
					}
					pst.close();
					conn.close();
				} catch (Exception ae) {
					ae.printStackTrace();
				}
			}
		});
		DisplayBT.setBounds(658, 150, 116, 33);
		contentPane.add(DisplayBT);
		
		JButton BackBT = new JButton("Back");
		BackBT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame MF = new MainFrame();
				MF.setVisible(true);
			}
		});
		BackBT.setBounds(658, 417, 116, 33);
		contentPane.add(BackBT);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(0, 0, 997, 616);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Dell\\Desktop\\mini project\\icons\\backfrm1.png"));
		contentPane.add(lblNewLabel);
	}
}
