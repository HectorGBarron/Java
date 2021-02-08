import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


// This is the application main menu
// the main menu its a frame with a button to display the existing recipes and another
// to add a recipe

public class MainMenu extends JFrame {

	private JPanel contentPane;

	
	private RecipeBook recipeBook;
	/**
	 * Create the frame.
	 */
	public MainMenu(RecipeBook recipeBook) {
		this.recipeBook=recipeBook;
		setTitle("Recipe Book");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 591, 386);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnViewExistingRecipes = new JButton("View Recipes");
		btnViewExistingRecipes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			readRecipe windowReadRecipe= new readRecipe(recipeBook);
			windowReadRecipe.setVisible(true);
			
			}
		});
		btnViewExistingRecipes.setHorizontalAlignment(SwingConstants.TRAILING);
		btnViewExistingRecipes.setBounds(127, 146, 119, 47);
		contentPane.add(btnViewExistingRecipes);
		
		JButton btnNewRecipe = new JButton("New Recipe");
		btnNewRecipe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			NewRecipe WindowNewRecipe=new NewRecipe (recipeBook);
			

			WindowNewRecipe.setVisible(true);
			}
		});
		btnNewRecipe.setBounds(307, 146, 119, 47);
		contentPane.add(btnNewRecipe);
	}
}
