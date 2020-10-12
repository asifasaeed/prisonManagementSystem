import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import java.awt.Color;
import javax.swing.JCheckBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Search extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTable table_1;
	private JTable table_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Search frame = new Search();
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
	public Search() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 659, 461);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dashboard kDash = new dashboard ();
				kDash.setVisible(true);
				Search.this.dispose();
				
			}
		});
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 210, 623, 167);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		btnBack.setBounds(10, 388, 89, 23);
		contentPane.add(btnBack);
		
		JRadioButton rdbtnPrisoners = new JRadioButton("Prisoners");
		rdbtnPrisoners.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String myDriver = "com.mysql.cj.jdbc.Driver";
				      String myUrl = "jdbc:mysql://localhost/prisoner_management_system";
				      Class.forName(myDriver);
				      Connection conn = DriverManager.getConnection(myUrl, "root", "messi323");
				      
				      table_2.setVisible(true);
				 
				      PreparedStatement ps = conn.prepareStatement("SELECT Prisoner_Id, fName, lName, Section_Id, entrance_date, release_date  FROM prisoner  ");

				      ResultSet rs = ps.executeQuery();
				      table.setModel(DbUtils.resultSetToTableModel(rs));
				      
				      
				      
				      PreparedStatement pst = conn.prepareStatement("SELECT COUNT(*) FROM prisoner ");
				      ResultSet rst = pst.executeQuery();
				      table_2.setModel(DbUtils.resultSetToTableModel(rst));
				     
				    
				      
				     
				      
				}
				
				catch (Exception ew)
			    {
					JOptionPane.showMessageDialog(null, "Got an exception!\n" + ew.getMessage());
			      
			    }
				
				
			}
			
			
		});
		rdbtnPrisoners.setBounds(179, 67, 89, 23);
		contentPane.add(rdbtnPrisoners);
		
		JRadioButton rdbtnOfficers = new JRadioButton("Officers");
		rdbtnOfficers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String myDriver = "com.mysql.cj.jdbc.Driver";
				      String myUrl = "jdbc:mysql://localhost/prisoner_management_system";
				      Class.forName(myDriver);
				      Connection conn = DriverManager.getConnection(myUrl, "root", "messi323");
				      
				      table_2.setVisible(true);

				 
				      PreparedStatement ps = conn.prepareStatement("SELECT Officer_Id, First_Name, Last_Name, Title, Section_Id, Prisoner_Id FROM officer ");
				      ResultSet rs = ps.executeQuery();
				      table.setModel(DbUtils.resultSetToTableModel(rs));
				      
				      PreparedStatement pst = conn.prepareStatement("SELECT COUNT(*) FROM officer ");
				      ResultSet rst = pst.executeQuery();
				      table_2.setModel(DbUtils.resultSetToTableModel(rst));
				      
				  
				      
				      
				      

				      
				}
				
				catch (Exception ew)
			    {
					JOptionPane.showMessageDialog(null, "Got an exception!\n" + ew.getMessage());
			      
			    }
				
			}
		});
		rdbtnOfficers.setBounds(10, 67, 109, 23);
		contentPane.add(rdbtnOfficers);
		
		JRadioButton rdbtnVisitors = new JRadioButton("Visitors");
		rdbtnVisitors.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String myDriver = "com.mysql.cj.jdbc.Driver";
				      String myUrl = "jdbc:mysql://localhost/prisoner_management_system";
				      Class.forName(myDriver);
				      Connection conn = DriverManager.getConnection(myUrl, "root", "messi323");
				      
				      table_2.setVisible(true);
				 
				      PreparedStatement ps = conn.prepareStatement("SELECT * FROM visitor ");

				      ResultSet rs = ps.executeQuery();
				      table.setModel(DbUtils.resultSetToTableModel(rs));
				      
				      
				      PreparedStatement pst = conn.prepareStatement("SELECT COUNT(*) FROM visitor ");
				      ResultSet rst = pst.executeQuery();
				      table_2.setModel(DbUtils.resultSetToTableModel(rst));
				     
				    
				      
				     
				      
				}
				
				catch (Exception ew)
			    {
					JOptionPane.showMessageDialog(null, "Got an exception!\n" + ew.getMessage());
			      
			    }
				
				
			}
		});
		rdbtnVisitors.setBounds(364, 67, 109, 23);
		contentPane.add(rdbtnVisitors);
		
		JRadioButton rdbtnOffenses = new JRadioButton("Offenses");
		rdbtnOffenses.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					String myDriver = "com.mysql.cj.jdbc.Driver";
				      String myUrl = "jdbc:mysql://localhost/prisoner_management_system";
				      Class.forName(myDriver);
				      Connection conn = DriverManager.getConnection(myUrl, "root", "messi323");
				      
				      table_2.setVisible(true);
				 
				      PreparedStatement ps = conn.prepareStatement("SELECT* FROM offense ");

				      ResultSet rs = ps.executeQuery();
				      table.setModel(DbUtils.resultSetToTableModel(rs));
				     
				      
				      PreparedStatement pst = conn.prepareStatement("SELECT COUNT(*) FROM offense ");
				      ResultSet rst = pst.executeQuery();
				      table_2.setModel(DbUtils.resultSetToTableModel(rst));
				    
				      
				     
				      
				}
				
				catch (Exception ew)
			    {
					JOptionPane.showMessageDialog(null, "Got an exception!\n" + ew.getMessage());
			      
			    }
			}
		});
		rdbtnOffenses.setBounds(524, 93, 109, 23);
		contentPane.add(rdbtnOffenses);
		
		JRadioButton rdbtnSections = new JRadioButton("Sections");
		rdbtnSections.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String myDriver = "com.mysql.cj.jdbc.Driver";
				      String myUrl = "jdbc:mysql://localhost/prisoner_management_system";
				      Class.forName(myDriver);
				      Connection conn = DriverManager.getConnection(myUrl, "root", "messi323");
				      
				      table_2.setVisible(true);
				 
				      PreparedStatement ps = conn.prepareStatement("SELECT* FROM Section ");

				      ResultSet rs = ps.executeQuery();
				      table.setModel(DbUtils.resultSetToTableModel(rs));
				      
				      PreparedStatement pst = conn.prepareStatement("SELECT COUNT(*) FROM section  ");
				      ResultSet rst = pst.executeQuery();
				      table_2.setModel(DbUtils.resultSetToTableModel(rst));
				     
				    
				      
				     
				      
				}
				
				catch (Exception ew)
			    {
					JOptionPane.showMessageDialog(null, "Got an exception!\n" + ew.getMessage());
			      
			    }
			}
		});
		rdbtnSections.setBounds(524, 67, 109, 23);
		contentPane.add(rdbtnSections);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 58, 623, 7);
		contentPane.add(separator);
		
		JLabel lblSearch = new JLabel("Search");
		lblSearch.setHorizontalAlignment(SwingConstants.CENTER);
		lblSearch.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblSearch.setBounds(261, 11, 184, 36);
		contentPane.add(lblSearch);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 135, 623, 7);
		contentPane.add(separator_1);
		
		table_2 = new JTable();
		table_2.setBounds(560, 185, 73, 14);
		contentPane.add(table_2);
		
		JLabel lblTotalCount = new JLabel("Total count");
		lblTotalCount.setBounds(465, 185, 89, 14);
		contentPane.add(lblTotalCount);
		
		JLabel lblRecords = new JLabel("All Records:");
		lblRecords.setBounds(10, 185, 128, 14);
		contentPane.add(lblRecords);
		
		JCheckBox chckbxAssignedOfficer = new JCheckBox("Assigned officer");
		chckbxAssignedOfficer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					String myDriver = "com.mysql.cj.jdbc.Driver";
				      String myUrl = "jdbc:mysql://localhost/prisoner_management_system";
				      Class.forName(myDriver);
				      Connection conn = DriverManager.getConnection(myUrl, "root", "messi323");
				      
				      table_2.setVisible(false);

				 
				      PreparedStatement ps = conn.prepareStatement("SELECT prisoner.Prisoner_Id, prisoner.fName, prisoner.lName, prisoner.Section_Id, prisoner.entrance_date, prisoner.release_date, officer.Officer_Id, officer.First_Name,officer.Last_Name  FROM prisoner JOIN officer on prisoner.Prisoner_Id = officer.Prisoner_Id  ");

				      ResultSet rs = ps.executeQuery();
				      table.setModel(DbUtils.resultSetToTableModel(rs));
				      
				      
    
				      
				     
				      
				}
				
				catch (Exception ew)
			    {
					JOptionPane.showMessageDialog(null, "Got an exception!\n" + ew.getMessage());
			      
			    }
				
				
				
				
			}
		});
		chckbxAssignedOfficer.setBounds(202, 93, 128, 23);
		contentPane.add(chckbxAssignedOfficer);
		
		
		
		JCheckBox chckbxAssignedPrisoner = new JCheckBox("Assigned prisoner");
		chckbxAssignedPrisoner.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				try {
					String myDriver = "com.mysql.cj.jdbc.Driver";
				      String myUrl = "jdbc:mysql://localhost/prisoner_management_system";
				      Class.forName(myDriver);
				      Connection conn = DriverManager.getConnection(myUrl, "root", "messi323");
				      
				      table_2.setVisible(false);

				 
				      PreparedStatement ps = conn.prepareStatement("SELECT officer.Officer_Id, officer.First_Name, officer.Last_Name, officer.Title, officer.Section_Id, officer.Prisoner_Id FROM officer join  prisoner on officer.Prisoner_Id = prisoner.Prisoner_Id ");
				      ResultSet rs = ps.executeQuery();
				      table.setModel(DbUtils.resultSetToTableModel(rs));
				      
				    
				      
				  
				      
				      
				      

				      
				}
				
				catch (Exception ew)
			    {
					JOptionPane.showMessageDialog(null, "Got an exception!\n" + ew.getMessage());
			      
			    }
				
				
				
			}
		});
		chckbxAssignedPrisoner.setBounds(30, 93, 118, 23);
		contentPane.add(chckbxAssignedPrisoner);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setOrientation(SwingConstants.VERTICAL);
		separator_2.setBounds(154, 58, 19, 66);
		contentPane.add(separator_2);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setOrientation(SwingConstants.VERTICAL);
		separator_3.setBounds(339, 58, 19, 66);
		contentPane.add(separator_3);
		
		JSeparator separator_4 = new JSeparator();
		separator_4.setOrientation(SwingConstants.VERTICAL);
		separator_4.setBounds(490, 58, 19, 66);
		contentPane.add(separator_4);
		
		
	}
}
