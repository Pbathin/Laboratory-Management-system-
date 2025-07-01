import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class SampleFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SampleFrame frame = new SampleFrame();
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
	public SampleFrame() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel SamplesLB = new JLabel("Samples:");
		SamplesLB.setFont(new Font("Times New Roman", Font.BOLD, 30));
		SamplesLB.setBounds(35, 15, 195, 35);//45, 35, 195, 35
		contentPane.add(SamplesLB);
		
		JLabel SamIdLB = new JLabel("Sample ID:");
		SamIdLB.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		SamIdLB.setBounds(73, 62, 67, 22);
		contentPane.add(SamIdLB);
		
		textField_4 = new JTextField();
		textField_4.setBounds(184, 62, 122, 22);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel PatIdLB = new JLabel("Patient ID:");
		PatIdLB.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		PatIdLB.setBounds(75, 98, 65, 22);
		contentPane.add(PatIdLB);
		
		textField = new JTextField();
		textField.setBounds(184, 99, 122, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel DateLB = new JLabel("Date:");
		DateLB.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		DateLB.setBounds(75, 131, 65, 22);
		contentPane.add(DateLB);
		
		textField_1 = new JTextField();
		textField_1.setBounds(184, 133, 122, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Tech ID:");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel.setBounds(75, 163, 65, 22);
		contentPane.add(lblNewLabel);
		
		textField_2 = new JTextField();
		textField_2.setBounds(184, 164, 122, 22);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(45, 195, 337, 255);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Blood", null, panel, null);
		panel.setLayout(null);
		
		final JCheckBox RbcCB = new JCheckBox("RBC");
		RbcCB.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		RbcCB.setBounds(57, 29, 97, 23);
		panel.add(RbcCB);
		
		final JCheckBox WbcCB = new JCheckBox("WBC Count");
		WbcCB.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		WbcCB.setBounds(57, 74, 134, 23);
		panel.add(WbcCB);
		
		final JCheckBox HemglbCB = new JCheckBox("Hemoglobin");
		HemglbCB.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		HemglbCB.setBounds(57, 120, 111, 23);
		panel.add(HemglbCB);
		
		final JCheckBox BloUrCB = new JCheckBox("Blood urea");
		BloUrCB.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		BloUrCB.setBounds(57, 167, 97, 23);
		panel.add(BloUrCB);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Urine", null, panel_1, null);
		panel_1.setLayout(null);
		
		final JCheckBox WetMndCB = new JCheckBox("Wet mount");
		WetMndCB.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		WetMndCB.setBounds(62, 51, 97, 23);
		panel_1.add(WetMndCB);
		
		final JCheckBox CulSenCB = new JCheckBox("Culture sensitivity");
		CulSenCB.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		CulSenCB.setBounds(62, 103, 144, 23);
		panel_1.add(CulSenCB);
		
		final JCheckBox PrtCB = new JCheckBox("For protein");
		PrtCB.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		PrtCB.setBounds(62, 163, 97, 23);
		panel_1.add(PrtCB);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Stool", null, panel_2, null);
		panel_2.setLayout(null);
		
		final JCheckBox OccBldCB = new JCheckBox("For occult blood");
		OccBldCB.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		OccBldCB.setBounds(65, 40, 239, 23);
		panel_2.add(OccBldCB);
		
		final JCheckBox HngDrpCB = new JCheckBox("Stool for hanging drop");
		HngDrpCB.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		HngDrpCB.setBounds(65, 111, 239, 23);
		panel_2.add(HngDrpCB);
		
		final JCheckBox StCulSenCB = new JCheckBox("Stool culture and sensitivity");
		StCulSenCB.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		StCulSenCB.setBounds(65, 173, 239, 23);
		panel_2.add(StCulSenCB);
		
		JButton BackBT = new JButton("Back");
		BackBT.setBounds(634, 401, 102, 35);
		contentPane.add(BackBT);
		
		JButton InsertBT = new JButton("Insert");
		InsertBT.setBounds(466, 401, 102, 35);
		contentPane.add(InsertBT);
		
		JLabel SampImgLB = new JLabel("New label");
		SampImgLB.setIcon(new ImageIcon("G:\\My Drive\\mini project\\icons\\sam1.jpg"));
		SampImgLB.setBounds(440, 35, 315, 330);
		contentPane.add(SampImgLB);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(0, 0, 997, 616);
		lblNewLabel_1.setIcon(new ImageIcon("G:\\My Drive\\mini project\\icons\\backfrm1.png"));
		contentPane.add(lblNewLabel_1);
		
		
	}
	
}
