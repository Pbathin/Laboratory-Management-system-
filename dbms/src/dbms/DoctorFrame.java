package dbms;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DoctorFrame extends JFrame {

	private JPanel contentPane;
	
	public void refreshTable() {
		try {
			String query = "select * from doctors";
			PreparedStatement pst = conn.prepareStatement(query);
			ResultSet rs = pst.executeQuery(query);
			ResultSetMetaData rsmd=rs.getMetaData();
			DefaultTableModel model=(DefaultTableModel) table.getModel();
			int cols=rsmd.getColumnCount();
			String[] colName={"Doctor_ID","DName","Phone","Email"};
			model.setColumnIdentifiers(colName);
			String Doctor_ID,DName,Phone,Email;
			while(rs.next()) {
				Doctor_ID=rs.getString(1);
				DName=rs.getString(2);
				Phone=rs.getString(3);
				Email=rs.getString(4);
				String[] row= {Doctor_ID,DName,Phone,Email};
				model.addRow(row);
			}
			
		}
		
		 catch (Exception ae) {
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
					DoctorFrame frame = new DoctorFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	Connection conn = null;
	private JTextField IdTF;
	private JTextField NameTF;
	private JTextField EmailTF;
	private JTextField PhoneTF;
	private JTable table;

	/**
	 * Create the frame.
	 */
	
	
	public DoctorFrame() {
		conn = ConnectDB.dbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel DocLB = new JLabel("Doctors:");
		DocLB.setFont(new Font("Times New Roman", Font.BOLD, 30));
		DocLB.setBounds(49, 11, 155, 40);
		contentPane.add(DocLB);
		
		JLabel IdLB = new JLabel("ID:");
		IdLB.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		IdLB.setBounds(49, 88, 116, 40);
		contentPane.add(IdLB);
		
		IdTF = new JTextField();
		IdTF.setFont(new Font("Tahoma", Font.PLAIN, 18));
		IdTF.setBounds(211, 88, 116, 40);
		contentPane.add(IdTF);
		IdTF.setColumns(10);
		
		JLabel NameLB = new JLabel("Name:");
		NameLB.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		NameLB.setBounds(49, 175, 116, 40);
		contentPane.add(NameLB);
		
		NameTF = new JTextField();
		NameTF.setFont(new Font("Tahoma", Font.PLAIN, 18));
		NameTF.setBounds(211, 175, 116, 40);
		contentPane.add(NameTF);
		NameTF.setColumns(10);
		
		JLabel PhoneLB = new JLabel("Phone No:");
		PhoneLB.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		PhoneLB.setBounds(49, 271, 116, 40);
		contentPane.add(PhoneLB);
		
		EmailTF = new JTextField();
		EmailTF.setFont(new Font("Tahoma", Font.PLAIN, 18));
		EmailTF.setBounds(211, 357, 116, 40);
		contentPane.add(EmailTF);
		EmailTF.setColumns(10);
		
		JLabel EmailLB = new JLabel("Email id:");
		EmailLB.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		EmailLB.setBounds(49, 357, 116, 40);
		contentPane.add(EmailLB);
		
		PhoneTF = new JTextField();
		PhoneTF.setFont(new Font("Tahoma", Font.PLAIN, 18));
		PhoneTF.setBounds(211, 271, 116, 40);
		contentPane.add(PhoneTF);
		PhoneTF.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(393, 146, 360, 260);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton InsertBT = new JButton("Insert");
		InsertBT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query = "insert into doctors(Doctor_ID,DName,Email,Phone) values (?,?,?,?)";
					PreparedStatement pst = conn.prepareStatement(query);
					
					pst.setString(1,IdTF.getText());
					pst.setString(2,NameTF.getText());
					pst.setString(3,EmailTF.getText());
					pst.setString(4,PhoneTF.getText());
					
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
					ae.printStackTrace();
					JOptionPane.showMessageDialog(null, "Enter required information correctly");
				}
				
				
				
				
			}

			
		});
		
		InsertBT.setBounds(429, 21, 116, 33);
		contentPane.add(InsertBT);
		
		
		
		JButton UpdateBT = new JButton("Update");
		UpdateBT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					String query = "update doctors set DName='"+NameTF.getText()+"', Email='"+EmailTF.getText()+"', Phone='"+PhoneTF.getText()+"' where  Doctor_ID='"+IdTF.getText()+"'";
					PreparedStatement pst = conn.prepareStatement(query);
					
					pst.executeUpdate();
					DefaultTableModel model=(DefaultTableModel) table.getModel();
					model.setRowCount(0);
					refreshTable();
					
					JOptionPane.showMessageDialog(null, "Data updated.");
					
				}
				 catch (Exception ae) {
					 JOptionPane.showMessageDialog(null, "Enter required information correctly");
				}
			}

			
			
				
		});
		UpdateBT.setBounds(595, 21, 116, 33);
		contentPane.add(UpdateBT);
		
		JButton DisplayBT = new JButton("Display");
		DisplayBT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query = "select * from doctors";
					PreparedStatement pst = conn.prepareStatement(query);
					ResultSet rs = pst.executeQuery(query);
					ResultSetMetaData rsmd=rs.getMetaData();
					DefaultTableModel model=(DefaultTableModel) table.getModel();
					int cols=rsmd.getColumnCount();
					String[] colName={"Doctor_ID","DName","Phone","Email"};
					model.setColumnIdentifiers(colName);
					String Doctor_ID,DName,Phone,Email;
					while(rs.next()) {
						Doctor_ID=rs.getString(1);
						DName=rs.getString(2);
						Phone=rs.getString(3);
						Email=rs.getString(4);
						String[] row= {Doctor_ID,DName,Phone,Email};
						model.addRow(row);
					}
					
					
				}
				
				 catch (Exception ae) {
					ae.printStackTrace();
				}
			}
			
		});
		DisplayBT.setBounds(595, 88, 116, 33);
		contentPane.add(DisplayBT);
		
		JButton DeleteBT = new JButton("Delete");
		DeleteBT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int action = JOptionPane.showConfirmDialog(null, "Do you really want to delete:","Delete:",JOptionPane.YES_NO_OPTION);
				if (action==0) {
					try {
						String query = "delete from doctors where Doctor_ID='"+IdTF.getText()+"'";
						PreparedStatement pst = conn.prepareStatement(query);
						
						int rs = pst.executeUpdate();
						refreshTable();
						JOptionPane.showMessageDialog(null, "Data deleted.");
						

					} catch (Exception ae) {
						ae.printStackTrace();
					}
				}
				
			}
		});
		DeleteBT.setBounds(429, 88, 116, 33);
		contentPane.add(DeleteBT);
		
		JButton BackBT = new JButton("Back");
		BackBT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame MF = new MainFrame();
				MF.setVisible(true);
			}
		});
		BackBT.setBounds(685, 427, 89, 23);
		contentPane.add(BackBT);
		
		BackBT.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		BackBT.setBounds(615, 410,133, 45);
		contentPane.add(BackBT);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(0, 0, 997, 616);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Dell\\Desktop\\mini project\\icons\\backfrm1.png"));
		contentPane.add(lblNewLabel);
		
	}
	
}
