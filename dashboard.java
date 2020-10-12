import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import java.awt.Font;
import javax.swing.SwingConstants;

public class dashboard extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	

	public static void main(String[] args) {
	
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					dashboard frame = new dashboard();
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
	public dashboard() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		
		JButton btnPrisoner = new JButton("Prisoner");
		btnPrisoner.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//create prisoner dashboard when button is clicked
				PrisonerDash xDash = new PrisonerDash();
			xDash.setVisible(true);
			
			//REMOVE THE WINDOW
			dashboard.this.dispose();
		   
				
			}
		});
		
		
		
		btnPrisoner.setBounds(30, 111, 89, 23);
		contentPane.add(btnPrisoner);
		
		JButton btnOfficer = new JButton("Officer");
		btnOfficer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//create officer dashboard when button is clicked
				
				OfficerDash yDash = new OfficerDash();
				yDash.setVisible(true);
				dashboard.this.dispose();
				
			}
		});
		btnOfficer.setBounds(175, 111, 89, 23);
		contentPane.add(btnOfficer);
		
		JButton btnVisitor = new JButton("Visitor");
		btnVisitor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//create visitor dashboard when button is clicked
				
				VisitorDash zDash = new VisitorDash();
				zDash.setVisible(true);
				dashboard.this.dispose();
				
			}
		});
		btnVisitor.setBounds(313, 111, 89, 23);
		contentPane.add(btnVisitor);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 69, 414, 23);
		contentPane.add(separator);
		
		JLabel lblPrisonManagementSystem = new JLabel("Prison Management System");
		lblPrisonManagementSystem.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrisonManagementSystem.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblPrisonManagementSystem.setBounds(10, 11, 414, 47);
		contentPane.add(lblPrisonManagementSystem);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 174, 414, 15);
		contentPane.add(separator_1);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Search s = new Search ();
				s.setVisible(true);
				dashboard.this.dispose();
			}
		});
		btnSearch.setBounds(175, 197, 89, 23);
		contentPane.add(btnSearch);
	
	}
}
