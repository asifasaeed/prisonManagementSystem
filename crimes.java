import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollBar;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class crimes extends JFrame {

	private JPanel contentPane;
	private JTextField textP_id;
	private JTextField textO_id;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					crimes frame = new crimes();
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
	public crimes() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 416);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(134, 170, 158, 62);
		contentPane.add(scrollPane);
		
		JList listCrime = new JList();
		scrollPane.setViewportView(listCrime);
		
		JLabel lblCrimes = new JLabel("Crimes");
		lblCrimes.setHorizontalAlignment(SwingConstants.CENTER);
		lblCrimes.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblCrimes.setBounds(154, 11, 138, 31);
		contentPane.add(lblCrimes);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 45, 414, 19);
		contentPane.add(separator);
		
		textP_id = new JTextField();
		textP_id.setBounds(134, 75, 96, 20);
		contentPane.add(textP_id);
		textP_id.setColumns(10);
		
		JLabel lblPrisonerId = new JLabel("Prisoner ID");
		lblPrisonerId.setBounds(20, 78, 96, 14);
		contentPane.add(lblPrisonerId);
		
		textO_id = new JTextField();
		textO_id.setBounds(134, 116, 96, 20);
		contentPane.add(textO_id);
		textO_id.setColumns(10);
		
		JLabel lblOffenseId = new JLabel("Offense ID");
		lblOffenseId.setBounds(20, 119, 85, 14);
		contentPane.add(lblOffenseId);
		
		DefaultListModel O_model = new DefaultListModel(); //create a new list model
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				O_model.clear();
				try {
					String myDriver = "com.mysql.cj.jdbc.Driver";
				      String myUrl = "jdbc:mysql://localhost/prisoner_management_system";
				      Class.forName(myDriver);
				      Connection conn = DriverManager.getConnection(myUrl, "root", "messi323");
					
					 String query = " insert into crime ( Prisoner_Id, Offense_Id)"
						        + " values (?, ?)";
					 
					 PreparedStatement preparedStmt = conn.prepareStatement(query);
				      preparedStmt.setString (1, textP_id.getText());
				      preparedStmt.setString (2, textO_id.getText());
				     
				      

				      // execute the preparedstatement
				      preparedStmt.execute();
				      
				      PreparedStatement ps = conn.prepareStatement("SELECT* FROM crime where Prisoner_Id = ? ");
				      ps.setString (1, textP_id.getText());
				      ResultSet rs = ps.executeQuery();
				     
				      
				      while(rs.next()){
				      
				    
				     
				      String off = rs.getString("Offense_Id");
				      O_model.addElement(off);
				     
				      }
				      listCrime.setModel(O_model);
				      rs.close();
				      
				      
				      
				      
				      //clear the textbox after adding
		
				   
				      textO_id.setText("");
				    
				      
				      
				      
				      
				      
				      conn.close();
				      JOptionPane.showMessageDialog(null, "Added successfully.");
				      
				     
				  
				     
				}
				catch (Exception ew)
			    {
					JOptionPane.showMessageDialog(null, "Got an exception!\n" + ew.getMessage());
			      
			    }
				
				
			}
		});
		btnAdd.setBounds(247, 90, 63, 23);
		contentPane.add(btnAdd);
		
		
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String myDriver = "com.mysql.cj.jdbc.Driver";
				      String myUrl = "jdbc:mysql://localhost/prisoner_management_system";
				      Class.forName(myDriver);
				      Connection conn = DriverManager.getConnection(myUrl, "root", "messi323");
				      
				      PreparedStatement ps = conn.prepareStatement("DELETE FROM crime where Prisoner_Id = ? AND Offense_Id =?");
				      ps.setString (1, textP_id.getText());
				      
				      String s = (String) listCrime.getSelectedValue();
				      ps.setString (2, s);
				      O_model.removeElement(s);
				      ps.executeUpdate();
				     
				     
				      
				    
				      conn.close();
				      JOptionPane.showMessageDialog(null, "Deleted Successfully." );
				      
				}
				catch (Exception ew)
			    {
					JOptionPane.showMessageDialog(null, "Got an exception!\n" + ew.getMessage());
			      
			    }
				
				
				
			}
		});
		btnDelete.setBounds(335, 170, 89, 23);
		contentPane.add(btnDelete);
		
		JLabel lblCommitted = new JLabel("Committed");
		lblCommitted.setBounds(20, 168, 104, 14);
		contentPane.add(lblCommitted);
		
		JLabel lblCrimes_1 = new JLabel("Crimes");
		lblCrimes_1.setBounds(20, 179, 71, 14);
		contentPane.add(lblCrimes_1);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PrisonerDash jDash = new PrisonerDash();
				jDash.setVisible(true);
				crimes.this.dispose();
				
			}
		});
		btnBack.setBounds(10, 343, 89, 23);
		contentPane.add(btnBack);
		
		DefaultListModel X_model = new DefaultListModel(); //create a new list model
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int rec = 0;
				try {
					String myDriver = "com.mysql.cj.jdbc.Driver";
				      String myUrl = "jdbc:mysql://localhost/prisoner_management_system";
				      Class.forName(myDriver);
				      Connection conn = DriverManager.getConnection(myUrl, "root", "messi323");
				      X_model.clear();
				   
				    
				 
				      PreparedStatement ps = conn.prepareStatement("SELECT* FROM crime where Prisoner_Id = ? ");
				      ps.setString (1, textP_id.getText());
				      ResultSet rs = ps.executeQuery();
				      X_model.clear();
				      
				      while(rs.next()){
				      
				    
				      String O_id = rs.getString("Offense_Id");
				    
				      X_model.addElement(O_id );
				      listCrime.setModel(X_model);
				     
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
		btnSearch.setBounds(335, 74, 89, 23);
		contentPane.add(btnSearch);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(247, 252, 177, 2);
		contentPane.add(separator_1);
		
		JLabel lblTheft = new JLabel("101 --> Theft of utilities");
		lblTheft.setBounds(272, 265, 138, 14);
		contentPane.add(lblTheft);
		
		JLabel lblRobbery = new JLabel("102 --> Robbery");
		lblRobbery.setBounds(272, 280, 122, 14);
		contentPane.add(lblRobbery);
		
		JLabel lblExtortion = new JLabel("103 --> Extortion");
		lblExtortion.setBounds(272, 290, 122, 14);
		contentPane.add(lblExtortion);
		
		JLabel lblKidnapping = new JLabel("104 --> Kidnapping");
		lblKidnapping.setBounds(272, 305, 122, 14);
		contentPane.add(lblKidnapping);
		
		JLabel lblRape = new JLabel("105 --> Rape");
		lblRape.setBounds(272, 320, 96, 14);
		contentPane.add(lblRape);
		
		JLabel lblMurder = new JLabel("106 --> Murder");
		lblMurder.setBounds(272, 332, 104, 14);
		contentPane.add(lblMurder);
	}
}
