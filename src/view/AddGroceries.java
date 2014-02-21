package view;

import java.awt.EventQueue;
import java.sql.Connection;  
import java.sql.DriverManager;  
import java.sql.ResultSet;  
import java.sql.Statement;  
import java.sql.SQLException;
import javax.swing.JInternalFrame;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddGroceries extends JInternalFrame {
	private static JTextField Quantity5;
	private static JTextField itemName1;
	private static JTextField Quantity2;
	private static JTextField Quantity3;
	private static JTextField Quantity4;
	private static JTextField Quantity1;
	private static JTextField itemName2;
	private static JTextField itemName3;
	private static JTextField itemName4;
	private static JTextField itemName5;
	
	/**
	 * Create the frame.
	 */
	public static void Insert (Statement state) {
		 try {
			 ResultSet rs = state.executeQuery("SELECT * FROM Groceries WHERE Name = '" + itemName1.getText() + "';");
			 if (rs.next()) {
				    System.out.println("hello");
		            int Id = rs.getInt("ID");
		            String Name = rs.getString("Name");
		            int NewQuantity = rs.getInt("Quantity") + Integer.parseInt(Quantity1.getText());
		            state.executeUpdate("UPDATE Groceries SET Quantity= " +NewQuantity + "  WHERE Name = '" + itemName1.getText() + "';");	        
		            }
			 else if(!("".equals(itemName1.getText())))
				 state.executeUpdate("insert into Groceries values ( NULL, " +  " '" + itemName1.getText() + "', '" +  Integer.parseInt(Quantity1.getText()) + "');");
			 
			 ResultSet rs2 = state.executeQuery("SELECT * FROM Groceries WHERE Name = '" + itemName2.getText() + "';");
			 if (rs2.next()) {
		            int Id = rs2.getInt("ID");
		            String Name = rs2.getString("Name");
		            int NewQuantity2 = rs2.getInt("Quantity") + Integer.parseInt(Quantity2.getText());
		            state.executeUpdate("UPDATE Groceries SET Quantity= " + NewQuantity2 + "  WHERE Name ='" + itemName2.getText() + "';");	        
		            }
			 else if(!("".equals(itemName2.getText())))
				 state.executeUpdate("insert into Groceries values ( NULL, " +  " '" + itemName2.getText() + "', '" +  Integer.parseInt(Quantity2.getText()) + "');");
			 
			 ResultSet rs3 = state.executeQuery("SELECT * FROM Groceries WHERE Name = '" + itemName3.getText() + "';");
			 if (rs3.next()) {
		            int Id = rs3.getInt("ID");
		            String Name = rs3.getString("Name");
		            int NewQuantity3 = rs3.getInt("Quantity") + Integer.parseInt(Quantity3.getText());
		            state.executeUpdate("UPDATE Groceries SET Quantity= " +NewQuantity3 + "  WHERE Name ='" + itemName3.getText() + "';");	        
		            }
			 else if(!("".equals(itemName3.getText())))
				 state.executeUpdate("insert into Groceries values ( NULL, " +  " '" + itemName3.getText() + "', '" +  Integer.parseInt(Quantity3.getText()) + "');");
				
			 ResultSet rs4 = state.executeQuery("SELECT * FROM Groceries WHERE Name = '" + itemName4.getText() + "';");
			 if (rs4.next()) {
		            int Id = rs4.getInt("ID");
		            String Name = rs4.getString("Name");
		            int NewQuantity4 = rs4.getInt("Quantity") + Integer.parseInt(Quantity4.getText());
		            state.executeUpdate("UPDATE Groceries SET Quantity= " +NewQuantity4 + "  WHERE Name ='" + itemName4.getText() + "';");	        
		            }
			 else if(!("".equals(itemName4.getText())))
				 state.executeUpdate("insert into Groceries values ( NULL, " +  " '" + itemName4.getText() + "', '" +  Integer.parseInt(Quantity4.getText()) + "');");
				
			 ResultSet rs5 = state.executeQuery("SELECT * FROM Groceries WHERE Name = '" + itemName5.getText() + "';");
			 if (rs5.next()) {
		            int Id = rs5.getInt("ID");
		            String Name = rs5.getString("Name");
		            int NewQuantity5 = rs5.getInt("Quantity") + Integer.parseInt(Quantity5.getText());
		            state.executeUpdate("UPDATE Groceries SET Quantity= " + NewQuantity5 + "  WHERE Name ='" + itemName5.getText() + "';");	        
		            }
			 else if(!("".equals(itemName5.getText())))
				 state.executeUpdate("insert into Groceries values ( NULL, " +  " '" + itemName5.getText() + "', '" +  Integer.parseInt(Quantity5.getText()) + "');");
				
		 }
		 catch (Exception e) 
	     {  
	         e.printStackTrace();  
	     }
	 }
		 
	public AddGroceries() {
		
		setFrameIcon(new ImageIcon(AddGroceries.class.getResource("/images/Groceries.jpg")));
		setTitle("Inserting New Grocery Items");
		setClosable(true);
		setMaximizable(true);
		setIconifiable(true);
		setBounds(0, 0, 500, 400);
		
		JPanel Grocery = new JPanel();
		Grocery.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Grocery Entry", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JPanel panelMenu = new JPanel();
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(Grocery, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 452, Short.MAX_VALUE)
						.addComponent(panelMenu, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 452, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(22, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(Grocery, GroupLayout.PREFERRED_SIZE, 282, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panelMenu, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(13, Short.MAX_VALUE))
		);
		Grocery.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		
		JLabel lblNewLabel = new JLabel("Item Name");
		Grocery.add(lblNewLabel, "2, 4, default, top");
		
		itemName1 = new JTextField();
		Grocery.add(itemName1, "6, 4, fill, default");
		itemName1.setColumns(10);
		
		JLabel lblQuantity_3 = new JLabel("Quantity");
		Grocery.add(lblQuantity_3, "10, 4, right, default");
		
		Quantity1 = new JTextField();
		Quantity1.setColumns(10);
		Grocery.add(Quantity1, "12, 4, fill, default");
		
		JLabel lblNewLabel_1 = new JLabel("Item Name");
		Grocery.add(lblNewLabel_1, "2, 8");
		
		itemName2 = new JTextField();
		itemName2.setColumns(10);
		Grocery.add(itemName2, "6, 8, fill, default");
		
		JLabel lblQuantity_2 = new JLabel("Quantity");
		Grocery.add(lblQuantity_2, "10, 8, right, default");
		
		Quantity2 = new JTextField();
		Grocery.add(Quantity2, "12, 8, fill, default");
		Quantity2.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Item Name");
		Grocery.add(lblNewLabel_2, "2, 12");
		
		itemName3 = new JTextField();
		itemName3.setColumns(10);
		Grocery.add(itemName3, "6, 12, fill, default");
		
		JLabel lblQuantity_1 = new JLabel("Quantity");
		Grocery.add(lblQuantity_1, "10, 12, right, default");
		
		Quantity3 = new JTextField();
		Grocery.add(Quantity3, "12, 12, fill, default");
		Quantity3.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Item Name");
		Grocery.add(lblNewLabel_3, "2, 16");
		
		itemName4 = new JTextField();
		itemName4.setColumns(10);
		Grocery.add(itemName4, "6, 16, fill, default");
		
		JLabel lblQuantity = new JLabel("Quantity");
		Grocery.add(lblQuantity, "10, 16, right, default");
		
		Quantity4 = new JTextField();
		Grocery.add(Quantity4, "12, 16, fill, default");
		Quantity4.setColumns(10);
		
		JLabel lblGenre = new JLabel("Item Name");
		Grocery.add(lblGenre, "2, 20");
		
		itemName5 = new JTextField();
		itemName5.setColumns(10);
		Grocery.add(itemName5, "6, 20, fill, default");
		
		JLabel lblQuantitymeasurements = new JLabel("Quantity");
		Grocery.add(lblQuantitymeasurements, "10, 20, right, default");
		
		Quantity5 = new JTextField();
		Grocery.add(Quantity5, "12, 20, fill, default");
		Quantity5.setColumns(10);
		
		JButton btnAccept = new JButton("Accept");
		btnAccept.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Insert(MovieMenu.statement);
				dispose();
			}
		});
		btnAccept.setIcon(new ImageIcon(AddGroceries.class.getResource("/images/accept.png")));
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnCancel.setIcon(new ImageIcon(AddGroceries.class.getResource("/images/cancel.png")));
		GroupLayout gl_panelMenu = new GroupLayout(panelMenu);
		gl_panelMenu.setHorizontalGroup(
				gl_panelMenu.createParallelGroup(Alignment.LEADING)
					.addGroup(Alignment.TRAILING, gl_panelMenu.createSequentialGroup()
						.addContainerGap(99, Short.MAX_VALUE)
						.addComponent(btnAccept)
						.addGap(56)
						.addComponent(btnCancel)
						.addGap(77))
			);
		gl_panelMenu.setVerticalGroup(
			gl_panelMenu.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelMenu.createSequentialGroup()
					.addGroup(gl_panelMenu.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnAccept)
						.addComponent(btnCancel))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panelMenu.setLayout(gl_panelMenu);
		getContentPane().setLayout(groupLayout);

	}
}
