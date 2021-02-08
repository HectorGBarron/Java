import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.awt.event.ActionEvent;

public class readRecipe extends JFrame {

	private JPanel contentPane;
	private JTextArea textAreaViewRecipe;
	JTextArea textAreaInstructions;
	private RecipeBook recipeBook;
	/**
	 * Create the frame.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public readRecipe(RecipeBook recipeBook) {
		this.recipeBook=recipeBook;
		setTitle("View Recipes");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 518);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSelectARecipe = new JLabel("Select a Recipe");
		lblSelectARecipe.setBounds(48, 30, 103, 16);
		contentPane.add(lblSelectARecipe);
		
		JComboBox cBoxSelectRecipe = new JComboBox();
		
		cBoxSelectRecipe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String selectedRecipe= (String)cBoxSelectRecipe.getSelectedItem();
				if (selectedRecipe!="Select an Option") 
				
				textAreaViewRecipe.setText(recipeBook.getRecipe(selectedRecipe));
				textAreaInstructions.setText(recipeBook.getRecipeInstructions(selectedRecipe));
				
			}
		});
		cBoxSelectRecipe.setModel(new DefaultComboBoxModel(recipeBook.allRecipes()));
		cBoxSelectRecipe.setBounds(163, 27, 175, 22);
		
		contentPane.add(cBoxSelectRecipe);
			
		
		JButton btnPrintToA = new JButton("Print to a Text File");
		btnPrintToA.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent arg0) {
				
				
				String filename=(String)cBoxSelectRecipe.getSelectedItem();
				if (filename!="Select an Option") 
				
			try {
				recipeBook.printRecipe(filename);
			ProcessBuilder pb = new ProcessBuilder("Notepad.exe",filename);	
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null, "Recipe not found");
			}
			}
		});
		btnPrintToA.setBounds(254, 424, 155, 34);
		contentPane.add(btnPrintToA);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 213, 408, 198);
		contentPane.add(scrollPane);
		
		textAreaViewRecipe = new JTextArea();
		textAreaViewRecipe.setEditable(false);
		textAreaViewRecipe.setLineWrap(true);
		scrollPane.setViewportView(textAreaViewRecipe);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(12, 84, 408, 99);
		contentPane.add(scrollPane_1);
		
		textAreaInstructions = new JTextArea();
		textAreaInstructions.setEditable(false);
		scrollPane_1.setViewportView(textAreaInstructions);
		textAreaInstructions.setLineWrap(true);
		
		JLabel lblRecipeInstructions = new JLabel("Recipe Instructions");
		lblRecipeInstructions.setBounds(12, 67, 132, 16);
		contentPane.add(lblRecipeInstructions);
		
		JLabel lblRecipeIngredients = new JLabel("Recipe Ingredients");
		lblRecipeIngredients.setBounds(12, 196, 117, 16);
		contentPane.add(lblRecipeIngredients);
	}
}
