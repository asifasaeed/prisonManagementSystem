import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JSeparator;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class OfficerDash extends JFrame {

	private JPanel contentPane;
	private JTextField textOfficer_Id;
	private JTextField textO_fname;
	private JTextField textO_lname;
	private JTextField textO_dob;
	private JTextField txtO_nic;
	private JTextField textTitle;
	private JTextField textSection_id;
	private JTextField textPr_id;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OfficerDash frame = new OfficerDash();
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
	public OfficerDash() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 531);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textOfficer_Id = new JTextField();
		textOfficer_Id.setBounds(129, 93, 96, 20);
		contentPane.add(textOfficer_Id);
		textOfficer_Id.setColumns(10);
		
		JLabel lblOfficerId = new JLabel("Officer ID");
		lblOfficerId.setBounds(10, 96, 109, 14);
		contentPane.add(lblOfficerId);
		
		textO_fname = new JTextField();
		textO_fname.setBounds(129, 129, 96, 20);
		contentPane.add(textO_fname);
		textO_fname.setColumns(10);
		
		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setBounds(10, 132, 109, 14);
		contentPane.add(lblFirstName);
		
		textO_lname = new JTextField();
		textO_lname.setBounds(129, 170, 96, 20);
		contentPane.add(textO_lname);
		textO_lname.setColumns(10);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setBounds(10, 173, 109, 14);
		contentPane.add(lblLastName);
		
		textO_dob = new JTextField();
		textO_dob.setBounds(129, 211, 96, 20);
		contentPane.add(textO_dob);
		textO_dob.setColumns(10);
		
		JLabel lblDob = new JLabel("D.O.B");
		lblDob.setBounds(10, 214, 109, 14);
		contentPane.add(lblDob);
		
		txtO_nic = new JTextField();
		txtO_nic.setBounds(129, 252, 96, 20);
		contentPane.add(txtO_nic);
		txtO_nic.setColumns(10);
		
		JLabel lblNic = new JLabel("N.I.C");
		lblNic.setBounds(10, 255, 109, 14);
		contentPane.add(lblNic);
		
		textTitle = new JTextField();
		textTitle.setBounds(129, 295, 137, 20);
		contentPane.add(textTitle);
		textTitle.setColumns(10);
		
		JLabel lblTitle = new JLabel("Title");
		lblTitle.setBounds(10, 298, 109, 14);
		contentPane.add(lblTitle);
		
		textSection_id = new JTextField();
		textSection_id.setBounds(129, 338, 96, 20);
		contentPane.add(textSection_id);
		textSection_id.setColumns(10);
		
		JLabel lblSectionId = new JLabel("Section ID");
		lblSectionId.setBounds(10, 341, 122, 14);
		contentPane.add(lblSectionId);
		
		textPr_id = new JTextField();
		textPr_id.setBounds(129, 379, 96, 20);
		contentPane.add(textPr_id);
		textPr_id.setColumns(10);
		
		JLabel lblAssignedPrisoner = new JLabel("Assigned Prisoner");
		lblAssignedPrisoner.setBounds(10, 382, 122, 14);
		contentPane.add(lblAssignedPrisoner);
		
		JButton btnCreate = new JButton("Create");
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

				try {
					String myDriver = "com.mysql.cj.jdbc.Driver";
				      String myUrl = "jdbc:mysql://localhost/prisoner_management_system";
				      Class.forName(myDriver);
				      Connection conn = DriverManager.getConnection(myUrl, "root", "messi323");
					
					 String query = " insert into officer (Officer_Id, First_Name, Last_Name, Title, Section_Id, DOB, NIC, Prisoner_Id)"
						        + " values (?, ?, ?, ?, ?,?,?,?)";
					 
					 PreparedStatement preparedStmt = conn.prepareStatement(query);
				      preparedStmt.setString (1, textOfficer_Id.getText());
				      preparedStmt.setString (2, textO_fname.getText());
				      preparedStmt.setString (3, textO_lname.getText());
				      preparedStmt.setString (4, textTitle.getText());
				      preparedStmt.setString (5, textSection_id.getText());
				      preparedStmt.setString (6, textO_dob.getText());
				      preparedStmt.setString (7, txtO_nic.getText());
				      
				      String pr_id = textPr_id.getText();
				      if (pr_id.isEmpty()) {
				      preparedStmt.setString (8, null);}
				      else {
				      preparedStmt.setString (8, pr_id);
				      }
				      
     
				      // execute the preparedstatement
				      preparedStmt.execute();
				      
				      //clear the textbox after adding
				      textOfficer_Id.setText("");
				      textO_fname.setText("");
				      textO_lname.setText("");
				      textTitle.setText("");
				      textSection_id.setText("");
				      textO_dob.setText("");
				      txtO_nic.setText("");
				      textPr_id.setText("");
				      
				      
				      
				      
				      
				      conn.close();
				      JOptionPane.showMessageDialog(null, "Created successfully.");
				      
				     
				  
				     
				}
				catch (Exception ew)
			    {
					JOptionPane.showMessageDialog(null, "Got an exception!\n" + ew.getMessage());
			      
			    }
			}
		});
		btnCreate.setBounds(335, 128, 89, 23);
		contentPane.add(btnCreate);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int rec = 0;
				try {
					String myDriver = "com.mysql.cj.jdbc.Driver";
				      String myUrl = "jdbc:mysql://localhost/prisoner_management_system";
				      Class.forName(myDriver);
				      Connection conn = DriverManager.getConnection(myUrl, "root", "messi323");
				      
				   
				    
				 
				      PreparedStatement ps = conn.prepareStatement("SELECT* FROM officer where Officer_Id = ? ");
				      ps.setString (1, textOfficer_Id.getText());
				      ResultSet rs = ps.executeQuery();
				     
				      while(rs.next()){
				      
				      textO_dob.setText(rs.getString("DOB"));
				      textO_fname.setText(rs.getString("First_Name"));
			          textO_lname.setText(rs.getString("Last_Name"));
				      textTitle.setText(rs.getString("Title"));
				      textSection_id.setText(rs.getString("Section_Id"));
				      txtO_nic.setText(rs.getString("NIC"));
				      textPr_id.setText(rs.getString("Prisoner_Id"));
				      rec=+1;
				      }
				   
				      if (rec==0) {
				    	//clear the textbox after not finding the record

					   
					      textO_fname.setText("");
					      textO_lname.setText("");
					      textTitle.setText("");
					      textSection_id.setText("");
					      textO_dob.setText("");
					      txtO_nic.setText("");
					      textPr_id.setText("");
				    	  JOptionPane.showMessageDialog(null, "Record Not Found." );
				      }
				      else
				      {
				    	  JOptionPane.showMessageDialog(null, "Found the record." );
				      }
				      rs.close();
				      
				     
				      
				}
				
				catch (Exception ew)
			    {
					JOptionPane.showMessageDialog(null, "Got an exception!\n" + ew.getMessage());
			      
			    }
				
				
			}
		});
		btnSearch.setBounds(335, 200, 89, 23);
		contentPane.add(btnSearch);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String myDriver = "com.mysql.cj.jdbc.Driver";
				      String myUrl = "jdbc:mysql://localhost/prisoner_management_system";
				      Class.forName(myDriver);
				      Connection conn = DriverManager.getConnection(myUrl, "root", "messi323");
				      
				   
				    
				 
				      PreparedStatement ps = conn.prepareStatement("DELETE FROM officer where Officer_Id = ? ");
				      ps.setString (1, textOfficer_Id.getText());
				      ps.executeUpdate();
				      
				      //clear the textbox after deleting
				      textOfficer_Id.setText("");
				      textO_fname.setText("");
				      textO_lname.setText("");
				      textTitle.setText("");
				      textSection_id.setText("");
				      textO_dob.setText("");
				      txtO_nic.setText("");
				      textPr_id.setText("");
				      
				      
				      conn.close();
				      JOptionPane.showMessageDialog(null, "Deleted Successfully." );
				      
				}
				
				catch (Exception ew)
			    {
					JOptionPane.showMessageDialog(null, "Got an exception!\n" + ew.getMessage());
			      
			    }
				
				
			}
		});
		btnDelete.setBounds(335, 268, 89, 23);
		contentPane.add(btnDelete);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String myDriver = "com.mysql.cj.jdbc.Driver";
				      String myUrl = "jdbc:mysql://localhost/prisoner_management_system";
				      Class.forName(myDriver);
				      Connection conn = DriverManager.getConnection(myUrl, "root", "messi323");
				      
				      PreparedStatement ps = conn.prepareStatement("UPDATE officer"+" SET First_Name = ?, Last_Name =?, Title =?, Section_Id=?, DOB =?, NIC=?, Prisoner_Id =? "+"where Officer_Id = ? ");
				      
				    
				     
				      ps.setString (1, textO_fname.getText());
				      ps.setString (2, textO_lname.getText());
				      ps.setString (3, textTitle.getText());
				      ps.setString (4, textSection_id.getText());
				      ps.setString (5, textO_dob.getText());
				      ps.setString (6, txtO_nic.getText());
				      
				      String pr_id = textPr_id.getText();
				      if (pr_id.isEmpty()) {
				    	  ps.setString (7, null);}
				      else {
				    	  ps.setString (7, pr_id);
				      }
				      
				      ps.setString (8, textOfficer_Id.getText());
				      
				    
				      
				      
			
				      ps.executeUpdate();
				      
				      //clear the textbox after Updating

				      textOfficer_Id.setText("");
				      textO_fname.setText("");
				      textO_lname.setText("");
				      textTitle.setText("");
				      textSection_id.setText("");
				      textO_dob.setText("");
				      txtO_nic.setText("");
				      textPr_id.setText("");
				      
				      conn.close();
				      JOptionPane.showMessageDialog(null, "Updated Successfully." );
				      
				}
				
				catch (Exception ew)
			    {
					JOptionPane.showMessageDialog(null, "Got an exception!\n" + ew.getMessage());
			      
			    }
				
				
			}
		});
		btnUpdate.setBounds(335, 234, 89, 23);
		contentPane.add(btnUpdate);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(310, 186, 114, 148);
		contentPane.add(separator);
		
		JButton btnClr = new JButton("CLR");
		btnClr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//clear the textbox after clearing
			      textOfficer_Id.setText("");
			      textO_fname.setText("");
			      textO_lname.setText("");
			      textTitle.setText("");
			      textSection_id.setText("");
			      textO_dob.setText("");
			      txtO_nic.setText("");
			      textPr_id.setText("");
			}
		});
		btnClr.setBounds(234, 92, 64, 23);
		contentPane.add(btnClr);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dashboard cDash = new dashboard();
				cDash.setVisible(true);
				OfficerDash.this.dispose();
			}
		});
		btnBack.setBounds(10, 458, 89, 23);
		contentPane.add(btnBack);
		
		JLabel lblOfficer = new JLabel("Officer");
		lblOfficer.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblOfficer.setBounds(175, 0, 203, 53);
		contentPane.add(lblOfficer);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 51, 414, 20);
		contentPane.add(separator_1);
	}
}
