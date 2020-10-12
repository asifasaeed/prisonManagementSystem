import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;
import javax.swing.JSeparator;
import javax.swing.JScrollPane;
import javax.swing.JList;
import java.awt.Font;
import javax.swing.JScrollBar;
import java.awt.event.AdjustmentListener;
import java.awt.event.AdjustmentEvent;

public class PrisonerDash extends JFrame {

	private JPanel contentPane;
	private JTextField textP_Id;
	private JTextField textP_Fname;
	private JTextField textP_Lname;
	private JTextField textP_DOB;
	private JTextField textP_Address;
	private JTextField textP_NIC;
	private JTextField textE_date;
	private JTextField textR_date;
	private JTextField textSection_ID;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PrisonerDash frame = new PrisonerDash();
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
	public PrisonerDash() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 560, 709);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(105, 503, 193, 70);
		contentPane.add(scrollPane);
		
		JList crimeList = new JList();
		scrollPane.setViewportView(crimeList);
		
		JLabel lblNewLabel = new JLabel("Prisoner ID");
		lblNewLabel.setBounds(13, 84, 82, 14);
		contentPane.add(lblNewLabel);
		
		textP_Id = new JTextField();
		textP_Id.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		textP_Id.setBounds(105, 81, 96, 20);
		contentPane.add(textP_Id);
		textP_Id.setColumns(10);
		
		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setBounds(13, 126, 82, 14);
		contentPane.add(lblFirstName);
		
		textP_Fname = new JTextField();
		textP_Fname.setBounds(105, 123, 96, 20);
		contentPane.add(textP_Fname);
		textP_Fname.setColumns(10);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setBounds(13, 166, 82, 14);
		contentPane.add(lblLastName);
		
		textP_Lname = new JTextField();
		textP_Lname.setBounds(105, 163, 96, 20);
		contentPane.add(textP_Lname);
		textP_Lname.setColumns(10);
		
		JLabel lblDob = new JLabel("D.O.B");
		lblDob.setBounds(13, 212, 82, 14);
		contentPane.add(lblDob);
		
		textP_DOB = new JTextField();
		textP_DOB.setBounds(105, 209, 96, 20);
		contentPane.add(textP_DOB);
		textP_DOB.setColumns(10);
		
		textP_Address = new JTextField();
		textP_Address.setBounds(105, 251, 193, 20);
		contentPane.add(textP_Address);
		textP_Address.setColumns(10);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setBounds(13, 254, 72, 14);
		contentPane.add(lblAddress);
		
		textP_NIC = new JTextField();
		textP_NIC.setBounds(105, 295, 96, 20);
		contentPane.add(textP_NIC);
		textP_NIC.setColumns(10);
		
		JLabel lblNic = new JLabel("NIC");
		lblNic.setBounds(13, 298, 48, 14);
		contentPane.add(lblNic);
		
		textE_date = new JTextField();
		textE_date.setBounds(105, 337, 96, 20);
		contentPane.add(textE_date);
		textE_date.setColumns(10);
		
		JLabel lblEntranceDate = new JLabel("Entrance date");
		lblEntranceDate.setBounds(13, 340, 96, 14);
		contentPane.add(lblEntranceDate);
		
		textR_date = new JTextField();
		textR_date.setBounds(105, 379, 96, 20);
		contentPane.add(textR_date);
		textR_date.setColumns(10);
		
		JLabel lblReleaseDate = new JLabel("Release date");
		lblReleaseDate.setBounds(13, 382, 96, 14);
		contentPane.add(lblReleaseDate);
		
		textSection_ID = new JTextField();
		textSection_ID.setBounds(105, 419, 96, 20);
		contentPane.add(textSection_ID);
		textSection_ID.setColumns(10);
		
		JLabel lblSectionId = new JLabel("Section ID");
		lblSectionId.setBounds(13, 422, 96, 14);
		contentPane.add(lblSectionId);
		
		
		//create a new list model
		DefaultListModel O1_model = new DefaultListModel(); 
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//counter for "if the record is found or not"
				int rec = 0;
				
				//exceprion catching for  sql errors
				try {
					  String myDriver = "com.mysql.cj.jdbc.Driver";
				      String myUrl = "jdbc:mysql://localhost/prisoner_management_system";
				      Class.forName(myDriver);
				      Connection conn = DriverManager.getConnection(myUrl, "root", "messi323");
				      O1_model.clear();
				   
				    
				      // for searching the prisoner
				      PreparedStatement ps = conn.prepareStatement("SELECT* FROM prisoner where Prisoner_Id = ? ");
				      ps.setString (1, textP_Id.getText());
				      ResultSet rs = ps.executeQuery();
				     
				      
				      while(rs.next()){
				      
				      textP_DOB.setText(rs.getString("DOB"));
				      textP_Fname.setText(rs.getString("fName"));
			          textP_Lname.setText(rs.getString("lName"));
				      textP_Address.setText(rs.getString("Address"));
				      textE_date.setText(rs.getString("Entrance_Date"));
				      textR_date.setText(rs.getString("Release_Date"));
				      textSection_ID.setText(rs.getString("Section_Id"));
				      textP_NIC.setText(rs.getString("NIC_p"));
				      rec=+1;
				      }
				    
				  	// displaying offenses if any
				      PreparedStatement pst = conn.prepareStatement("SELECT crime.Offense_Id, Offense.Description  from crime inner join offense  on offense.Offense_Id = crime.offense_Id where  crime.Prisoner_Id = ? ");
				     
				      pst.setString (1, textP_Id.getText());
				      ResultSet rst = pst.executeQuery();
				      
				      
				      while(rst.next()){
				      
				    
				      String Off = rst.getString("crime.Offense_Id");
				      String Des = rst.getString("offense.Description");
				      O1_model.addElement(Off + "  -->   "+ Des );
				      rec=+1;
				     
				      }
				      crimeList.setModel(O1_model);
				      rst.close();
					
				      
				      
				      
				    
				      if (rec==0) {
				    	  //clear the textbox after not finding
					     
					      textP_Fname.setText("");
					      textP_Lname.setText("");
					      textP_Address.setText("");
					      textE_date.setText("");
					      textR_date.setText("");
					      textSection_ID.setText("");
					      textP_DOB.setText("");
					      textP_NIC.setText("");
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
		btnSearch.setBounds(423, 140, 89, 23);
		contentPane.add(btnSearch);
		
		JButton btnAdd = new JButton("Create");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		
				try {
					String myDriver = "com.mysql.cj.jdbc.Driver";
				      String myUrl = "jdbc:mysql://localhost/prisoner_management_system";
				      Class.forName(myDriver);
				      Connection conn = DriverManager.getConnection(myUrl, "root", "messi323");
				      O1_model.clear();
					
				      // for inserting data in prisoner table
					 String query = " insert into prisoner (Prisoner_Id, fName, lName, Address, entrance_date, release_date, Section_Id,DOB,NIC_p)"
						        + " values (?, ?, ?, ?, ?,?,?,?,?)";
					 
					 PreparedStatement preparedStmt = conn.prepareStatement(query);
				      preparedStmt.setString (1, textP_Id.getText());
				      preparedStmt.setString (2, textP_Fname.getText());
				      preparedStmt.setString (3, textP_Lname.getText());
				      preparedStmt.setString (4, textP_Address.getText());
				      preparedStmt.setString (5, textE_date.getText());
				      String rdate = textR_date.getText();
				      if (rdate.isEmpty()) {
				      preparedStmt.setString (6, null);}
				      else {
				      preparedStmt.setString (6, rdate);
				      }
				      
				      preparedStmt.setString (7, textSection_ID.getText());
				      preparedStmt.setString (8, textP_DOB.getText());
				      preparedStmt.setString (9, textP_NIC.getText());
				      
				      // execute the preparedstatement
				      preparedStmt.execute();
				      
				      //clear the textbox after adding
				      textP_Id.setText("");
				      textP_Fname.setText("");
				      textP_Lname.setText("");
				      textP_Address.setText("");
				      textE_date.setText("");
				      textR_date.setText("");
				      textSection_ID.setText("");
				      textP_DOB.setText("");
				      textP_NIC.setText("");
				      
				      
				      
				      
				      conn.close();
				      JOptionPane.showMessageDialog(null, "Created successfully.");
				      
				     
				  
				     
				}
				catch (Exception ew)
			    {
					JOptionPane.showMessageDialog(null, "Got an exception!\n" + ew.getMessage());
			      
			    }
			}
		});
		btnAdd.setBounds(423, 80, 89, 23);
		contentPane.add(btnAdd);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String myDriver = "com.mysql.cj.jdbc.Driver";
				      String myUrl = "jdbc:mysql://localhost/prisoner_management_system";
				      Class.forName(myDriver);
				      Connection conn = DriverManager.getConnection(myUrl, "root", "messi323");
				      O1_model.clear();
				      
				      
				      PreparedStatement ps = conn.prepareStatement("UPDATE prisoner"+" SET fName = ?, lName =?, Address =?, entrance_date=?, release_date=?, Section_Id=?,DOB=?,NIC_p=? "+"where Prisoner_Id = ? ");
				      
				    
				     
				      ps.setString (1, textP_Fname.getText());
				      ps.setString (2, textP_Lname.getText());
				      ps.setString (3, textP_Address.getText());
				      ps.setString (4, textE_date.getText());
				      String rdate = textR_date.getText();
				      if (rdate.isEmpty()) {
				    	  ps.setString (5, null);}
				      else {
				    	  ps.setString (5, rdate);
				      }
				      
				      ps.setString (6, textSection_ID.getText());
				      ps.setString (7, textP_DOB.getText());
				      ps.setString (8, textP_NIC.getText());
				      
				      
				      ps.setString (9, textP_Id.getText());
				      ps.executeUpdate();
				      
				      //clear the textbox after Updating
				      textP_Id.setText("");
				      textP_Fname.setText("");
				      textP_Lname.setText("");
				      textP_Address.setText("");
				      textE_date.setText("");
				      textR_date.setText("");
				      textSection_ID.setText("");
				      textP_DOB.setText("");
				      textP_NIC.setText("");
				      
				      
				      conn.close();
				      JOptionPane.showMessageDialog(null, "Updated Successfully." );
				      
				}
				
				catch (Exception ew)
			    {
					JOptionPane.showMessageDialog(null, "Got an exception!\n" + ew.getMessage());
			      
			    }
				      
				
				
				
			}
		});
		btnUpdate.setBounds(423, 174, 89, 23);
		contentPane.add(btnUpdate);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(397, 126, 137, 125);
		contentPane.add(separator);
		
		JButton btnClr = new JButton("CLR");
		btnClr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 //clear the textbox after clearing
			      textP_Id.setText("");
			      textP_Fname.setText("");
			      textP_Lname.setText("");
			      textP_Address.setText("");
			      textE_date.setText("");
			      textR_date.setText("");
			      textSection_ID.setText("");
			      textP_DOB.setText("");
			      textP_NIC.setText("");
			      
			      O1_model.clear();
			      
			      

			}
		});
		btnClr.setBounds(227, 80, 71, 23);
		contentPane.add(btnClr);
		
	
		
		JLabel lblOffense = new JLabel("Offenses");
		lblOffense.setBounds(13, 518, 72, 14);
		contentPane.add(lblOffense);
		
		JButton btnBackHome = new JButton("Back");
		btnBackHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dashboard newDash = new dashboard();
				newDash.setVisible(true);
				PrisonerDash.this.dispose();
				
			}
		});
		btnBackHome.setBounds(13, 621, 89, 23);
		contentPane.add(btnBackHome);
		
		JLabel lblPrisoner = new JLabel("Prisoner");
		lblPrisoner.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblPrisoner.setBounds(216, 10, 129, 38);
		contentPane.add(lblPrisoner);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 59, 524, 14);
		contentPane.add(separator_1);
		
		JLabel lblNewLabel_1 = new JLabel("Committed");
		lblNewLabel_1.setBounds(13, 503, 96, 14);
		contentPane.add(lblNewLabel_1);
		
		JButton btnAddOffense = new JButton("Add Offense");
		btnAddOffense.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				crimes newCrime = new crimes();
				newCrime.setVisible(true);
				PrisonerDash.this.dispose();
				
			}
		});
		btnAddOffense.setBounds(423, 576, 111, 23);
		contentPane.add(btnAddOffense);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(13, 486, 524, 14);
		contentPane.add(separator_2);
	}
}
