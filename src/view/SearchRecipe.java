package view;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;
import javax.swing.JRadioButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextArea;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollBar;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.JTextField;

public class SearchRecipe extends JInternalFrame {
	private static JTextArea textArea;
	private static JScrollPane scroll;
	private JRadioButton rdbtnGroceries;
	private static String Table;
	private JRadioButton rdbtnSearchRecipes;
	private JScrollPane scrollPane;
	private JRadioButton rdbtnClearAll;
	private JPanel panel_2;
	private JButton button;
	private JButton button_1;
	private JButton Recipe1;
	private JButton Recipe2;
	private JButton Recipe3;
	private JButton Recipe4;
	private JButton Recipe5;

	/**
	 * Create the frame.
	 */
	
	public static void runReport(Statement state) {
		try {
			ResultSet rs = state.executeQuery("SELECT * FROM " + Table + ";");
			while (rs.next()) {
	            int ID = rs.getInt("ID");
	            String Name = rs.getString("Name");
	            int Quantity = rs.getInt("Quantity");
	            textArea.append(ID + "\t" + Name+ "\t" + Quantity + "\n");
	        }
		}
		catch (Exception e) 
	     {  
	         e.printStackTrace();  
	     }
	}
	public SearchRecipe() {
		setTitle("Report from Database");
		setClosable(true);
		setMaximizable(true);
		setIconifiable(true);
		setBounds(0, 0, 500, 500);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Select Table", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JPanel panel_1 = new JPanel();
		
		panel_2 = new JPanel();
		
		button = new JButton("Accept");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				ResultSet rs1 = MovieMenu.statement.executeQuery("SELECT * FROM Groceries WHERE Name = 'Onion';");
				ResultSet rs2 = MovieMenu.statement.executeQuery("SELECT * FROM Groceries WHERE Name = 'Chicken Thigh';");
				ResultSet rs3 = MovieMenu.statement.executeQuery("SELECT * FROM Groceries WHERE Name = 'Lemon Pepper';");
				ResultSet rs4 = MovieMenu.statement.executeQuery("SELECT * FROM Groceries WHERE Name = 'Oregano Leaves';");
				ResultSet rs5 = MovieMenu.statement.executeQuery("SELECT * FROM Groceries WHERE Name = 'Plain Yogurt';");
				 if (Recipe1.isEnabled()) {
					 int id1 = rs1.getInt("ID");
					 String itemName = rs1.getString("Name");
					 int NewQuantity1 = rs1.getInt("Quantity") - 1;
					 System.out.println(id1+itemName+NewQuantity1);
			         MovieMenu.statement.executeUpdate("UPDATE Groceries SET Quantity = " + NewQuantity1 + "  WHERE Name = '" + itemName + "';");
			         
			         int id2 = rs2.getInt("ID");
					 String itemName2 = rs2.getString("Name");
					 int NewQuantity2 = rs2.getInt("Quantity") - 1;
			         MovieMenu.statement.executeUpdate("UPDATE Groceries SET Quantity= " + NewQuantity2 + "  WHERE Name = '" + itemName2 + "';");
			         
			         int id3 = rs3.getInt("ID");
					 String itemName3 = rs3.getString("Name");
					 int NewQuantity3 = rs3.getInt("Quantity") - 1;
			         MovieMenu.statement.executeUpdate("UPDATE Groceries SET Quantity= " + NewQuantity3 + "  WHERE Name = '" + itemName3 + "';");
			         
			         int id4 = rs4.getInt("ID");
					 String itemName4 = rs4.getString("Name");
					 int NewQuantity4 = rs4.getInt("Quantity") - 1;
			         MovieMenu.statement.executeUpdate("UPDATE Groceries SET Quantity= " + NewQuantity4 + "  WHERE Name = '" + itemName4 + "';");
			         
			         int id5 = rs5.getInt("ID");
					 String itemName5 = rs5.getString("Name");
					 int NewQuantity5 = rs5.getInt("Quantity") - 1;
			         MovieMenu.statement.executeUpdate("UPDATE Groceries SET Quantity= " + NewQuantity5 + "  WHERE Name = '" + itemName5 + "';");
			         
			            }
				}
				catch (Exception ex) 
			     {  
			         ex.printStackTrace();  
			     }
				dispose();
			}
		});
		button.setIcon(new ImageIcon(SearchRecipe.class.getResource("/images/accept.png")));
		
		button_1 = new JButton("Cancel");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		button_1.setIcon(new ImageIcon(SearchRecipe.class.getResource("/images/cancel.png")));
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(99)
					.addComponent(button)
					.addGap(56)
					.addComponent(button_1)
					.addContainerGap(77, Short.MAX_VALUE))
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
						.addComponent(button, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
						.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel_2.setLayout(gl_panel_2);
		
		Recipe1 = new JButton("Recipe#1");
		Recipe1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textArea.setText("");
				String Recipe = "Greek Chicken Crockpot Pita Filling";
				Recipe4.setEnabled(false);
				textArea.append(Recipe + "\n");
				textArea.append("Ingredients: \n 1 Onion, Chopped\n 1 lb. bonless, skinless chicken thigh\n 1 tsp. lemon pepper \n" +
						"1/2 tsp. dried oregano leaves \n 1/2 cup plain yogurt\n\n");
				textArea.append("Combine all ingredients except yogurt in 4-6 quart slow cooker and mix well. Cover crockpot and cook on low setting for 6-8 hours.\n Just before serving, remove chicken from slow cooker and shred with two forks. Stir shredded chicken back into crockpot and stir in yogurt. Make sandwiches with chicken filling, feta cheese if desired, and pita breads. 4 sandwiches");
			}
		});
		Recipe1.setEnabled(false);
		
		Recipe2 = new JButton("Recipe#2");
		Recipe2.setEnabled(false);
		
		Recipe3 = new JButton("Recipe#3");
		Recipe3.setEnabled(false);
		
		Recipe4 = new JButton("Recipe#4");
		Recipe4.setEnabled(false);
		
		Recipe5 = new JButton("Recipe#5");
		Recipe5.setEnabled(false);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 493, Short.MAX_VALUE)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(Recipe1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(Recipe2)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(Recipe3)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(Recipe4)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(Recipe5)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(panel_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(panel_2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 452, Short.MAX_VALUE))
					.addContainerGap(22, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(Recipe1)
						.addComponent(Recipe2)
						.addComponent(Recipe3)
						.addComponent(Recipe4)
						.addComponent(Recipe5))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 310, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(19, Short.MAX_VALUE))
		);
		
		scrollPane = new JScrollPane();
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE)
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 334, Short.MAX_VALUE)
		);
		panel_1.setLayout(gl_panel_1);
		panel_1.add(scrollPane);
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		textArea.setEditable(false);
		
		rdbtnGroceries = new JRadioButton("Check Groceries");
		rdbtnGroceries.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Table = "Groceries";
				textArea.setText("List of Groceries\n");
				runReport(MovieMenu.statement);

			}
		});
		panel.add(rdbtnGroceries);
		
		rdbtnSearchRecipes = new JRadioButton("Search Recipes");
		rdbtnSearchRecipes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				ResultSet rs1 = MovieMenu.statement.executeQuery("SELECT * FROM Groceries WHERE Name = 'Onion';");
				ResultSet rs2 = MovieMenu.statement.executeQuery("SELECT * FROM Groceries WHERE Name = 'Chicken Thigh';");
				ResultSet rs3 = MovieMenu.statement.executeQuery("SELECT * FROM Groceries WHERE Name = 'Lemon Pepper';");
				ResultSet rs4 = MovieMenu.statement.executeQuery("SELECT * FROM Groceries WHERE Name = 'Oregano Leaves';");
				ResultSet rs5 = MovieMenu.statement.executeQuery("SELECT * FROM Groceries WHERE Name = 'Plain Yogurt';");
				if(rs1.next())
				{
					Recipe1.setEnabled(true);
				};
				}
				
				catch (Exception ex) 
			     {  
			         ex.printStackTrace();  
			     }
			}
	});
		panel.add(rdbtnSearchRecipes);
		
		rdbtnClearAll = new JRadioButton("Clear Text Area");
		rdbtnClearAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textArea.setText("");
				Recipe1.setEnabled(false);
				Recipe2.setEnabled(false);
				Recipe3.setEnabled(false);
				Recipe4.setEnabled(false);
				Recipe5.setEnabled(false);
			}
		});
		panel.add(rdbtnClearAll);
		getContentPane().setLayout(groupLayout);
		
	}
}
