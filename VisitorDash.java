

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JScrollBar;
import java.awt.Color;
import javax.swing.JTextArea;

public class VisitorDash extends JFrame {

	private JPanel contentPane;
	private JTextField textV_id;
	private JTextField textV_fname;
	private JTextField textV_lname;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VisitorDash frame = new VisitorDash();
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
	public VisitorDash() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 384);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblVisitor = new JLabel("Visitor");
		lblVisitor.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblVisitor.setBounds(172, 11, 113, 47);
		contentPane.add(lblVisitor);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 57, 414, 15);
		contentPane.add(separator);
		
		textV_id = new JTextField();
		textV_id.setBounds(105, 83, 96, 20);
		contentPane.add(textV_id);
		textV_id.setColumns(10);
		
		JLabel lblVisitorId = new JLabel("Visitor ID");
		lblVisitorId.setBounds(10, 86, 96, 14);
		contentPane.add(lblVisitorId);
		
		textV_fname = new JTextField();
		textV_fname.setBounds(105, 123, 96, 20);
		contentPane.add(textV_fname);
		textV_fname.setColumns(10);
		
		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setBounds(10, 126, 96, 14);
		contentPane.add(lblFirstName);
		
		textV_lname = new JTextField();
		textV_lname.setBounds(105, 163, 96, 20);
		contentPane.add(textV_lname);
		textV_lname.setColumns(10);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setBounds(10, 166, 113, 14);
		contentPane.add(lblLastName);
		
		JButton btnClr = new JButton("CLR");
		btnClr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//clear the textbox after clearing
			      textV_id.setText("");
			    
			      textV_fname.setText("");
			      textV_lname.setText("");
			     
				
				
			}
		});
		btnClr.setBounds(231, 83, 62, 23);
		contentPane.add(btnClr);
		
		JButton btnCreate = new JButton("Create");
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					String myDriver = "com.mysql.cj.jdbc.Driver";
				      String myUrl = "jdbc:mysql://localhost/prisoner_management_system";
				      Class.forName(myDriver);
				      Connection conn = DriverManager.getConnection(myUrl, "root", "messi323");
					
					 String query = " insert into visitor (Visitor_Id, First_Name, Last_Name)"
						        + " values (?, ?, ?)";
					 
					 PreparedStatement preparedStmt = conn.prepareStatement(query);
				      preparedStmt.setString (1, textV_id.getText());
				      preparedStmt.setString (2, textV_fname.getText());
				      preparedStmt.setString (3, textV_lname.getText());
				      
				 
				      
     
				      // execute the preparedstatement
				      preparedStmt.execute();
				      
				      //clear the textbox after adding
				 
				      textV_id.setText("");
				   
				      textV_fname.setText("");
				      textV_lname.setText("");
				    
				      
				      
				      
				      
				      
				      conn.close();
				      JOptionPane.showMessageDialog(null, "Created successfully.");
				      
				     
				  
				     
				}
				catch (Exception ew)
			    {
					JOptionPane.showMessageDialog(null, "Got an exception!\n" + ew.getMessage());
			      
			    }
				
			}
		});
		btnCreate.setBounds(335, 122, 89, 23);
		contentPane.add(btnCreate);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(313, 176, 111, 7);
		contentPane.add(separator_1);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				int rec = 0;
				try {
					String myDriver = "com.mysql.cj.jdbc.Driver";
				      String myUrl = "jdbc:mysql://localhost/prisoner_management_system";
				      Class.forName(myDriver);
				      Connection conn = DriverManager.getConnection(myUrl, "root", "messi323");
				      
				   
				    
				 
				      PreparedStatement ps = conn.prepareStatement("SELECT* FROM visitor where Visitor_Id = ? ");
				      ps.setString (1, textV_id.getText());
				      ResultSet rs = ps.executeQuery();
				     
				      while(rs.next()){
				      
				      textV_id.setText(rs.getString("Visitor_Id"));
				      textV_fname.setText(rs.getString("First_Name"));
			          textV_lname.setText(rs.getString("Last_Name"));
				     
				      rec=+1;
				      }
				   
				      if (rec==0) {
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
		btnSearch.setBounds(335, 190, 89, 23);
		contentPane.add(btnSearch);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					String myDriver = "com.mysql.cj.jdbc.Driver";
				      String myUrl = "jdbc:mysql://localhost/prisoner_management_system";
				      Class.forName(myDriver);
				      Connection conn = DriverManager.getConnection(myUrl, "root", "messi323");
				      
				      PreparedStatement ps = conn.prepareStatement("UPDATE visitor"+" SET First_Name = ?, Last_Name =? "+"where Visitor_Id = ? ");
				      
				    
				     
				      ps.setString (1, textV_fname.getText());
				      ps.setString (2, textV_lname.getText());
				      ps.setString (3, textV_id.getText());
				     
				    
				      
				      
			
				      ps.executeUpdate();
				      
				      //clear the textbox after Updating

				      textV_id.setText("");
				      textV_fname.setText("");
				      textV_lname.setText("");
				     
				      
				      conn.close();
				      JOptionPane.showMessageDialog(null, "Updated Successfully." );
				      
				}
				
				catch (Exception ew)
			    {
					JOptionPane.showMessageDialog(null, "Got an exception!\n" + ew.getMessage());
			      
			    }
				
			}
		});
		btnUpdate.setBounds(335, 223, 89, 23);
		contentPane.add(btnUpdate);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dashboard aDash = new dashboard();
				aDash.setVisible(true);
				VisitorDash.this.dispose();
			}
		});
		btnBack.setBounds(10, 311, 89, 23);
		contentPane.add(btnBack);
		
		JButton btnAddVisits = new JButton("Add Visits");
		btnAddVisits.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				visits newVisit = new visits();
				newVisit.setVisible(true);
				VisitorDash.this.dispose();
			}
		});
		btnAddVisits.setBounds(313, 311, 111, 23);
		contentPane.add(btnAddVisits);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(10, 301, 414, 15);
		contentPane.add(separator_2);
	}
}
