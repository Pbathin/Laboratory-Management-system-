package dbms;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;

public class TechFrame extends JFrame {

	private JPanel contentPane;
	private JTextField IdTF;
	private JTextField NameTF;
	private JTextField PhoneTF;
	private JTextField EmailTF;

	public void refreshTable() {
		try {
			String query = "select * from technicians";
			PreparedStatement pst = conn.prepareStatement(query);
			ResultSet rs = pst.executeQuery(query);
			ResultSetMetaData rsmd=rs.getMetaData();
			DefaultTableModel model=(DefaultTableModel) table.getModel();
			int cols=rsmd.getColumnCount();
			String[] colName={"TechID","TName","Phone","Email"};
			model.setColumnIdentifiers(colName);
			String TechID,TName,Phone,Email;
			while(rs.next()) {
				TechID=rs.getString(1);
				TName=rs.getString(2);
				Phone=rs.getString(3);
				Email=rs.getString(4);
				String[] row= {TechID,TName,Phone,Email};
				model.addRow(row);
			}
			
		} catch (Exception ae) {
			ae.printStackTrace();
		}
	}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TechFrame frame = new TechFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	Connection conn = null;
	private JTable table;

	/**
	 * Create the frame.
	 */
	public TechFrame() {
		conn = ConnectDB.dbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTechnicians = new JLabel("Technicians:");
		lblTechnicians.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblTechnicians.setBounds(38, 29, 207, 40);
		contentPane.add(lblTechnicians);
		
		JLabel IdLB = new JLabel("ID:");
		IdLB.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		IdLB.setBounds(38, 119, 116, 40);
		contentPane.add(IdLB);
		
		IdTF = new JTextField();
		IdTF.setFont(new Font("Tahoma", Font.PLAIN, 18));
		IdTF.setColumns(10);
		IdTF.setBounds(197, 119, 116, 40);
		contentPane.add(IdTF);
		
		JLabel NameLB = new JLabel("Name:");
		NameLB.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		NameLB.setBounds(38, 202, 116, 40);
		contentPane.add(NameLB);
		
		NameTF = new JTextField();
		NameTF.setFont(new Font("Tahoma", Font.PLAIN, 18));
		NameTF.setColumns(10);
		NameTF.setBounds(197, 202, 116, 40);
		contentPane.add(NameTF);
		
		JLabel PhoneLB = new JLabel("Phone No:");
		PhoneLB.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		PhoneLB.setBounds(38, 299, 116, 40);
		contentPane.add(PhoneLB);
		
		PhoneTF = new JTextField();
		PhoneTF.setFont(new Font("Tahoma", Font.PLAIN, 18));
		PhoneTF.setColumns(10);
		PhoneTF.setBounds(197, 299, 116, 40);
		contentPane.add(PhoneTF);
		
		JLabel EmailLB = new JLabel("Email id:");
		EmailLB.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		EmailLB.setBounds(38, 386, 116, 40);
		contentPane.add(EmailLB);
		
		EmailTF = new JTextField();
		EmailTF.setFont(new Font("Tahoma", Font.PLAIN, 18));
		EmailTF.setColumns(10);
		EmailTF.setBounds(197, 385, 116, 40);
		contentPane.add(EmailTF);
		
		JButton InsertBT = new JButton("Insert");
		InsertBT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query = "insert into technicians(TechID,TName,Phone,Email) values (?,?,?,?)";
					PreparedStatement pst = conn.prepareStatement(query);
					
					pst.setString(1,IdTF.getText());
					pst.setString(2,NameTF.getText());
					pst.setString(3,PhoneTF.getText());
					pst.setString(4,EmailTF.getText());
					
					int rs = pst.executeUpdate();
					DefaultTableModel model=(DefaultTableModel) table.getModel();
					model.setRowCount(0);
					refreshTable();
					JOptionPane.showMessageDialog(null, "Data added.");
					IdTF.setText("");
					NameTF.setText("");
					EmailTF.setText("");
					PhoneTF.setText("");

				} catch (Exception ae) {
					JOptionPane.showMessageDialog(null, "Enter required information correctly");
				}
			}
		});
		InsertBT.setBounds(446, 44, 116, 33);
		contentPane.add(InsertBT);
		
		JButton UpdateBT = new JButton("Update");
		UpdateBT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					String query = "update technicians set TName='"+NameTF.getText()+"', Phone='"+PhoneTF.getText()+"', Email='"+EmailTF.getText()+"' where  TechID='"+IdTF.getText()+"'";
					PreparedStatement pst = conn.prepareStatement(query);
					
					pst.executeUpdate();
					DefaultTableModel model=(DefaultTableModel) table.getModel();
					model.setRowCount(0);
					refreshTable();
					JOptionPane.showMessageDialog(null, "Data updated.");
					IdTF.setText("");
					NameTF.setText("");
					EmailTF.setText("");
					PhoneTF.setText("");

				} catch (Exception ae) {
					JOptionPane.showMessageDialog(null, "Enter required information correctly");
				}
			}
		});
		UpdateBT.setBounds(626, 44, 116, 33);
		contentPane.add(UpdateBT);
		
		JButton DeleteBT = new JButton("Delete");
		DeleteBT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int action = JOptionPane.showConfirmDialog(null, "Do you really want to delete:","Delete:",JOptionPane.YES_NO_OPTION);
				if (action==0) {
					try {
						String query = "delete from technicians where TechID='"+IdTF.getText()+"'";
						PreparedStatement pst = conn.prepareStatement(query);
						
						int rs = pst.executeUpdate();
						DefaultTableModel model=(DefaultTableModel) table.getModel();
						model.setRowCount(0);
						refreshTable();
						JOptionPane.showMessageDialog(null, "Data deleted.");
						IdTF.setText("");
						
					} catch (Exception ae) {
						ae.printStackTrace();
					}
				}
			}
		});
		DeleteBT.setBounds(446, 105, 116, 33);
		contentPane.add(DeleteBT);
		
		JButton DisplayBT = new JButton("Display");
		DisplayBT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query = "select * from technicians";
					PreparedStatement pst = conn.prepareStatement(query);
					ResultSet rs = pst.executeQuery(query);
					ResultSetMetaData rsmd=rs.getMetaData();
					DefaultTableModel model=(DefaultTableModel) table.getModel();
					int cols=rsmd.getColumnCount();
					String[] colName={"TechID","TName","Phone","Email"};
					model.setColumnIdentifiers(colName);
					String TechID,TName,Phone,Email;
					while(rs.next()) {
						TechID=rs.getString(1);
						TName=rs.getString(2);
						Phone=rs.getString(3);
						Email=rs.getString(4);
						String[] row= {TechID,TName,Phone,Email};
						model.addRow(row);
					}
					
				} catch (Exception ae) {
					ae.printStackTrace();
				}
			}
		});
		DisplayBT.setBounds(626, 105, 116, 33);
		contentPane.add(DisplayBT);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(415, 163, 328, 248);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton BackBT = new JButton("Back");
		BackBT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame MF = new MainFrame();
				MF.setVisible(true);
			}
		});
		BackBT.setBounds(695, 427, 89, 23);
		contentPane.add(BackBT);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(0, 0, 997, 616);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Dell\\Desktop\\mini project\\icons\\backfrm1.png"));
		contentPane.add(lblNewLabel);
	}
}
