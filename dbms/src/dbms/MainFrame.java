package dbms;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class MainFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton PatientBT = new JButton("Patients");
		PatientBT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PatientFrame PF = new PatientFrame();
				PF.setVisible(true);
			}
		});
		PatientBT.setBounds(70, 184, 97, 23);
		contentPane.add(PatientBT);
		
		JButton SampleBT = new JButton("Samples");
		SampleBT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SampleFrame SF = new SampleFrame();
				SF.setVisible(true);
			}
		});
		SampleBT.setBounds(249, 184, 89, 23);
		contentPane.add(SampleBT);
		
		JButton DocBT = new JButton("Doctors");
		DocBT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DoctorFrame DF = new DoctorFrame();
				DF.setVisible(true);
			}
		});
		DocBT.setBounds(430, 184, 89, 23);
		contentPane.add(DocBT);
		
		JButton TechBT = new JButton("Technicians");
		TechBT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TechFrame TF = new TechFrame();
				TF.setVisible(true);
			}
		});
		TechBT.setBounds(605, 184, 108, 23);
		contentPane.add(TechBT);
		
		JLabel PatientLB = new JLabel("New label");
		PatientLB.setIcon(new ImageIcon("C:\\Users\\Dell\\Desktop\\mini project\\icons\\patient1.png"));
		PatientLB.setBounds(70, 69, 97, 80);
		contentPane.add(PatientLB);
		
		JLabel SampleLB = new JLabel("New label");
		SampleLB.setIcon(new ImageIcon("C:\\Users\\Dell\\Desktop\\mini project\\icons\\sampimg1.png"));
		SampleLB.setBounds(249, 69, 89, 80);
		contentPane.add(SampleLB);
		
		JLabel DocLB = new JLabel("New label");
		DocLB.setIcon(new ImageIcon("C:\\Users\\Dell\\Desktop\\mini project\\icons\\docimg2.jpg"));
		DocLB.setBounds(430, 69, 89, 80);
		contentPane.add(DocLB);
		
		JLabel TechLB = new JLabel("New label");
		TechLB.setIcon(new ImageIcon("C:\\Users\\Dell\\Desktop\\mini project\\icons\\labtech1.png"));
		TechLB.setBounds(611, 69, 89, 80);
		contentPane.add(TechLB);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Dell\\Desktop\\mini project\\icons\\users1.png"));
		lblNewLabel.setBounds(537, 283, 89, 80);
		contentPane.add(lblNewLabel);
		
		JButton UserBT = new JButton("Users");
		UserBT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Jframe.dispose();
				UserFrame UF = new UserFrame();
				UF.setVisible(true);
				
			}
		});
		UserBT.setBounds(537, 389, 89, 23);
		contentPane.add(UserBT);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Dell\\Desktop\\mini project\\icons\\testimg1.jpg"));
		lblNewLabel_1.setBounds(338, 283, 89, 80);
		contentPane.add(lblNewLabel_1);
		
		JButton TestBT = new JButton("Tests");
		TestBT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TestsFrame TstF = new TestsFrame();
				TstF.setVisible(true);
			}
		});
		TestBT.setBounds(338, 389, 89, 23);
		contentPane.add(TestBT);
		
		JButton ResultBT = new JButton("Results");
		ResultBT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ResultFrame RF = new ResultFrame();
				RF.setVisible(true);
			}
		});
		ResultBT.setBounds(164, 389, 89, 23);
		contentPane.add(ResultBT);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\Dell\\Desktop\\mini project\\icons\\res1.png"));
		lblNewLabel_2.setBounds(164, 283, 89, 80);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setBounds(0, 0, 997, 616);
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\Dell\\Desktop\\mini project\\icons\\backfrm1.png"));
		contentPane.add(lblNewLabel_3);
		
	}
	
	
}
