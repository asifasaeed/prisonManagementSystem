import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

public class visits extends JFrame {

	private JPanel contentPane;
	private JTextField textPri_id;
	private JTextField texVis_id;
	private JTextField textV_date;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					visits frame = new visits();
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
	public visits() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 425);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(106, 211, 205, 70);
		contentPane.add(scrollPane);
		
		JList listVisits = new JList();
		scrollPane.setViewportView(listVisits);
		
		textPri_id = new JTextField();
		textPri_id.setBounds(106, 138, 96, 20);
		contentPane.add(textPri_id);
		textPri_id.setColumns(10);
		
		JLabel lblPrisonerId = new JLabel("Prisoner ID");
		lblPrisonerId.setBounds(10, 141, 116, 14);
		contentPane.add(lblPrisonerId);
		
		DefaultListModel V_model = new DefaultListModel(); //create a new list model
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				int rec = 0;
				try {
					String myDriver = "com.mysql.cj.jdbc.Driver";
				      String myUrl = "jdbc:mysql://localhost/prisoner_management_system";
				      Class.forName(myDriver);
				      Connection conn = DriverManager.getConnection(myUrl, "root", "messi323");
				      
				   
				    
				 
				      PreparedStatement ps = conn.prepareStatement("SELECT* FROM visits where Visitor_Id = ? ");
				      ps.setString (1, texVis_id.getText());
				      ResultSet rs = ps.executeQuery();
				      V_model.clear();
				      
				      while(rs.next()){
				      
				    
				      String P_id = rs.getString("Prisoner_Id");
				      String V_date = rs.getString("visit_date");
				      V_model.addElement(P_id + "  -->   "+ V_date);
				     
				      rec=+1;
				      }
				   
				      if (rec==0) {
				    	  JOptionPane.showMessageDialog(null, "Record Not Found." );
				      }
				      else
				      {
				    	  JOptionPane.showMessageDialog(null, "Found the record." );
				      }
				      listVisits.setModel(V_model);
				      rs.close();
				      
				     
				      
				}
				
				catch (Exception ew)
			    {
					JOptionPane.showMessageDialog(null, "Got an exception!\n" + ew.getMessage());
			      
			    }
				
				
			}
		});
		btnSearch.setBounds(335, 106, 89, 23);
		contentPane.add(btnSearch);
		
		texVis_id = new JTextField();
		texVis_id.setBounds(106, 107, 96, 20);
		contentPane.add(texVis_id);
		texVis_id.setColumns(10);
		
		JLabel lblVisitId = new JLabel("Visitor ID");
		lblVisitId.setBounds(10, 110, 86, 14);
		contentPane.add(lblVisitId);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String myDriver = "com.mysql.cj.jdbc.Driver";
				      String myUrl = "jdbc:mysql://localhost/prisoner_management_system";
				      Class.forName(myDriver);
				      Connection conn = DriverManager.getConnection(myUrl, "root", "messi323");
					
					 String query = " insert into visits (Visitor_Id, Prisoner_Id, visit_date)"
						        + " values (?, ?, ?)";
					 
					 PreparedStatement preparedStmt = conn.prepareStatement(query);
				      preparedStmt.setString (1, texVis_id.getText());
				      preparedStmt.setString (2, textPri_id.getText());
				      preparedStmt.setString (3, textV_date.getText());
				      

				      // execute the preparedstatement
				      preparedStmt.execute();
				      
				      PreparedStatement ps = conn.prepareStatement("SELECT* FROM visits where Visitor_Id = ? ");
				      ps.setString (1, texVis_id.getText());
				      ResultSet rs = ps.executeQuery();
				     
				      
				      while(rs.next()){
				      
				    
				      String P_id = rs.getString("Prisoner_Id");
				      String V_date = rs.getString("visit_date");
				      V_model.addElement(P_id + " --> "+ V_date);
				     
				      }
				      listVisits.setModel(V_model);
				      rs.close();
				      
				      
				      
				      
				      //clear the textbox after adding
		
				      textPri_id.setText("");
				      textV_date.setText("");
				    
				      
				      
				      
				      
				      
				      conn.close();
				      JOptionPane.showMessageDialog(null, "Added successfully.");
				      
				     
				  
				     
				}
				catch (Exception ew)
			    {
					JOptionPane.showMessageDialog(null, "Got an exception!\n" + ew.getMessage());
			      
			    }
				
				
				
			}
		});
		btnAdd.setBounds(243, 153, 68, 23);
		contentPane.add(btnAdd);
		
		JLabel lblVisits = new JLabel("Visits");
		lblVisits.setHorizontalAlignment(SwingConstants.CENTER);
		lblVisits.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblVisits.setBounds(124, 11, 187, 46);
		contentPane.add(lblVisits);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 60, 414, 23);
		contentPane.add(separator);
		
		
		
		JLabel lblRecent = new JLabel("Recent");
		lblRecent.setBounds(10, 211, 86, 14);
		contentPane.add(lblRecent);
		
		JLabel lbl_visit = new JLabel("Visits");
		lbl_visit.setBounds(10, 222, 86, 14);
		contentPane.add(lbl_visit);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VisitorDash bDash = new VisitorDash();
				bDash.setVisible(true);
				
				visits.this.dispose();
			}
		});
		btnBack.setBounds(10, 334, 89, 23);
		contentPane.add(btnBack);
		
		textV_date = new JTextField();
		textV_date.setBounds(106, 169, 96, 20);
		contentPane.add(textV_date);
		textV_date.setColumns(10);
		
		JLabel lblVisitDate = new JLabel("Visit Date");
		lblVisitDate.setBounds(10, 172, 96, 14);
		contentPane.add(lblVisitDate);
		
		JButton btnClr = new JButton("CLR");
		btnClr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				 
				texVis_id.setText("");
				   V_model.clear();
				 
			}
			
			
		});
		btnClr.setBounds(212, 106, 59, 23);
		contentPane.add(btnClr);
	}
}
