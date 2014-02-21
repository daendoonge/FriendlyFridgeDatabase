package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;  
import java.sql.DriverManager;  
import java.sql.ResultSet;  
import java.sql.Statement;  
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.ImageIcon;
import javax.swing.JToolBar;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class MovieMenu extends JFrame {
	public static Statement statement;
	public static Connection conn;
	public static String Preference;
	private JPanel contentPane;
	private JPanel desktopPane;
	private JButton addMovie;
	private JButton editDatabase;
	private JButton searchDatabase;
	private JButton removeFromDatabase;
	private AddGroceries IMo;
	private SearchRecipe SR;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MovieMenu frame = new MovieMenu();
					frame.setVisible(true);
					conn = CreateConnection();
				   	statement = conn.createStatement();
				   	Create(conn);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public static Connection CreateConnection() {
		  Connection conn = null;
		  try 
		     { 
	      Class.forName("org.sqlite.JDBC");  
	      conn = DriverManager.getConnection("jdbc:sqlite:Groceries.db");
	      
		     }
		  catch (Exception e) 
		     {  
		         e.printStackTrace();  
		     }
		  return conn;
	  }
	public static void Create (Connection conn) {
		try {
			  Statement statement = conn.createStatement();
			  statement.executeUpdate("CREATE TABLE Groceries (ID INTEGER  PRIMARY KEY ASC, Name     CHAR( 50 ), Quantity     INT);");

		}
			  catch (Exception e) 
			     {  
			         e.printStackTrace();  
			     }
	}
	 public static void close (Connection conn, Statement statement) {
		  try {
			  conn.close();
		      statement.close();
		  }
		  catch(SQLException e){
		      // if the error message is "out of memory", 
		      // it probably means no database file is found
		      System.err.println(e.getMessage());
		  }
	 }	 
	/**
	 * Create the frame.
	 */
	public MovieMenu() {
		initCompoments();
		CreateEvents();
	}
	private void CreateEvents() {
		addMovie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (IMo == null || IMo.isClosed()) {
					IMo = new AddGroceries();
					desktopPane.add(IMo);
					IMo.show();
				}
			}
		});
		searchDatabase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (SR == null || SR.isClosed()) {
					SR = new SearchRecipe();
					desktopPane.add(SR);
					SR.show();
				}
			}
		});
		
	}
	
	private void initCompoments() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(MovieMenu.class.getResource("/images/fridge-freezer2.jpg")));
		setTitle("Friendly Fridge");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 600);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("File");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Exit");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mntmNewMenuItem.setIcon(new ImageIcon(MovieMenu.class.getResource("/images/smallcancel.png")));
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenu mnNewMenu_1 = new JMenu("Edit");
		menuBar.add(mnNewMenu_1);
		
		JMenu mnAbout = new JMenu("About");
		menuBar.add(mnAbout);
		
		JMenuItem mntmAboutUs = new JMenuItem("About Us");
		mntmAboutUs.setIcon(new ImageIcon(MovieMenu.class.getResource("/images/info.png")));
		mnAbout.add(mntmAboutUs);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JToolBar toolBar = new JToolBar();
		toolBar.setFloatable(false);
		
		JToolBar toolBar_1 = new JToolBar();
		toolBar_1.setFloatable(false);
		
		desktopPane = new JPanel();
		
		JToolBar toolBar_4 = new JToolBar();
		toolBar_4.setFloatable(false);
		
		JToolBar toolBar_5 = new JToolBar();
		toolBar_5.setFloatable(false);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(toolBar_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
								.addComponent(toolBar, GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
								.addComponent(toolBar_4, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE))
							.addGap(18))
						.addComponent(toolBar_5, GroupLayout.PREFERRED_SIZE, 185, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(desktopPane, GroupLayout.PREFERRED_SIZE, 524, GroupLayout.PREFERRED_SIZE)
					.addGap(5))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(19)
					.addComponent(toolBar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(toolBar_1, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(toolBar_4, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(toolBar_5, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
					.addGap(271))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(desktopPane, GroupLayout.DEFAULT_SIZE, 561, Short.MAX_VALUE))
		);
		
		removeFromDatabase = new JButton("Preference Settings     ");
		toolBar_5.add(removeFromDatabase);
		removeFromDatabase.setIcon(new ImageIcon(MovieMenu.class.getResource("/images/setting.png")));
		
		editDatabase = new JButton("Mood Check            ");
		toolBar_4.add(editDatabase);
		editDatabase.setIcon(new ImageIcon(MovieMenu.class.getResource("/images/music.jpg")));
		
		searchDatabase = new JButton("Search Recipe         ");
		toolBar_1.add(searchDatabase);
		searchDatabase.setIcon(new ImageIcon(MovieMenu.class.getResource("/images/search.jpg")));
		GroupLayout gl_desktopPane = new GroupLayout(desktopPane);
		gl_desktopPane.setHorizontalGroup(
			gl_desktopPane.createParallelGroup(Alignment.LEADING)
				.addGap(0, 482, Short.MAX_VALUE)
		);
		gl_desktopPane.setVerticalGroup(
			gl_desktopPane.createParallelGroup(Alignment.LEADING)
				.addGap(0, 412, Short.MAX_VALUE)
		);
		desktopPane.setLayout(gl_desktopPane);
		addMovie = new JButton("Add Grocery Items ");
		toolBar.add(addMovie);
		addMovie.setHorizontalAlignment(SwingConstants.LEFT);
		
		addMovie.setIcon(new ImageIcon(MovieMenu.class.getResource("/images/Groceries.jpg")));
		contentPane.setLayout(gl_contentPane);
		
		
	}
}
