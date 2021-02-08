import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.Color;
import java.awt.SystemColor;

public class NewRecipe extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldRecipeName;
	private JLabel lblIngredient;
	private JTextField textFieldIngredient;
	private JButton btnCreateNewRecipe;
	private JComboBox comboBoxUnitsOfMesure;
	private RecipeBook recipeBook;
	private JTextField textFieldQuantity;
	private JScrollPane scrollPane;
	private JTextArea textAreaInstructions;
	private JTextArea textAreaListOfIngredients;
	private JScrollPane scrollPane_1;
	private JButton btnAdd;
	private JLabel lblToProceed;
	private JLabel lblStatus;

//	public static void main(String[] args) {
//		NewRecipe WindowNewRecipe=new NewRecipe ();
//		
//
//		WindowNewRecipe.setVisible(true);
//
//	}
	
	public NewRecipe(RecipeBook recipebook) {
	this.recipeBook=recipebook;
//	public NewRecipe() {	
//		recipeBook=new RecipeBook();
	
	setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);	
		
		
		setTitle("New Recipe");
		setBounds(100, 100, 631, 427);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRecipeName = new JLabel("Recipe Name:");
		lblRecipeName.setBounds(30, 13, 97, 16);
		contentPane.add(lblRecipeName);
		
		textFieldRecipeName = new JTextField();
		textFieldRecipeName.setBounds(122, 10, 116, 22);
		contentPane.add(textFieldRecipeName);
		textFieldRecipeName.setColumns(10);
		
		lblIngredient = new JLabel("Ingredient");
		lblIngredient.setBounds(116, 152, 67, 16);
		contentPane.add(lblIngredient);
		
		textFieldIngredient = new JTextField();
		textFieldIngredient.setEnabled(false);
		textFieldIngredient.setEditable(false);
		textFieldIngredient.setBounds(22, 169, 242, 22);
		contentPane.add(textFieldIngredient);
		textFieldIngredient.setColumns(10);
		
		btnCreateNewRecipe = new JButton("Create New Recipe");
		btnCreateNewRecipe.setBounds(343, 9, -418, 25);
		contentPane.add(btnCreateNewRecipe);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				textFieldRecipeName.setEnabled(false);
				recipeBook.newRecipe(textFieldRecipeName.getText());
				textFieldIngredient.setEnabled(true);
				textFieldIngredient.setEditable(true);
				textFieldQuantity.setEnabled(true);
				textFieldQuantity.setEditable(true);
				comboBoxUnitsOfMesure.setEnabled(true);
//				comboBoxUnitsOfMesure.setEditable(true);
				textAreaInstructions.setEnabled(true);
				textAreaInstructions.setEditable(true);
				btnAdd.setEnabled(true);
				btnSave.setEnabled(false);
				lblToProceed.setVisible(false);
				textAreaInstructions.setBackground(Color.white);
				textAreaListOfIngredients.setBackground(Color.white);
			}
		});
		btnSave.setBounds(250, 9, 97, 25);
		contentPane.add(btnSave);
		
		JLabel lblQuantity = new JLabel("Quantity");
		lblQuantity.setBounds(280, 152, 56, 16);
		contentPane.add(lblQuantity);
		
		textFieldQuantity = new JTextField();
		textFieldQuantity.setEnabled(false);
		textFieldQuantity.setEditable(false);
		textFieldQuantity.setBounds(276, 169, 72, 22);
		contentPane.add(textFieldQuantity);
		textFieldQuantity.setColumns(10);
		
		JLabel lblUnitOfMeasure = new JLabel("Unit of Measure");
		lblUnitOfMeasure.setBounds(380, 152, 97, 16);
		contentPane.add(lblUnitOfMeasure);
		
		comboBoxUnitsOfMesure = new JComboBox();
		comboBoxUnitsOfMesure.setEnabled(false);
		comboBoxUnitsOfMesure.setModel(new DefaultComboBoxModel(new String[] {"", "Oz", "Lbs", "Grams", "Kilos", "Pieces", "Gallons", "Litters"}));
		comboBoxUnitsOfMesure.setBounds(380, 169, 97, 22);
		contentPane.add(comboBoxUnitsOfMesure);
		
		btnAdd = new JButton("Add");
		btnAdd.setEnabled(false);
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String recipeName;
				double quantity=0;
				String measure;
				String ingredientName;
				String ingredients = textAreaListOfIngredients.getText();
				//Validate if the quantity is a valid input
				
				try { quantity = Double.parseDouble((textFieldQuantity.getText()));
						recipeName=textFieldRecipeName.getText(); // Get the recipe name
						measure =(String)comboBoxUnitsOfMesure.getSelectedItem(); // get the unit of measurement
						ingredientName=textFieldIngredient.getText();
						
						
						recipeBook.addIngredient(recipeName, ingredientName, quantity, measure);
				
						
						ingredients=ingredients+ ingredientName+"\t"+ quantity + "\t" + measure+"\n";
				
						textAreaListOfIngredients.setText(ingredients);
				
				
						comboBoxUnitsOfMesure.setSelectedIndex(0);
						textFieldIngredient.setText("");
						textFieldQuantity.setText("");					
				} catch (Exception e) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(null, "The quantity must be numeric");
				
				}
				
				
			}
		});
		btnAdd.setBounds(489, 168, 97, 25);
		contentPane.add(btnAdd);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(23, 57, 563, 67);
		contentPane.add(scrollPane);
		
		textAreaInstructions = new JTextArea();
		textAreaInstructions.setBackground(Color.LIGHT_GRAY);
		textAreaInstructions.setEnabled(false);
		textAreaInstructions.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				recipeBook.setRecipeInstruction(textFieldRecipeName.getText(), textAreaInstructions.getText());
				lblStatus.setText("Saved");
			}
			@Override
			public void focusGained(FocusEvent e) {
			lblStatus.setText("Editing");
			}
		});
		scrollPane.setViewportView(textAreaInstructions);
		textAreaInstructions.setEditable(false);
		
		JLabel lblCookingInstructions = new JLabel("Cooking Instructions:");
		lblCookingInstructions.setBounds(26, 42, 138, 16);
		contentPane.add(lblCookingInstructions);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(22, 217, 559, 113);
		contentPane.add(scrollPane_1);
		
		textAreaListOfIngredients = new JTextArea();
		textAreaListOfIngredients.setBackground(Color.LIGHT_GRAY);
		textAreaListOfIngredients.setEnabled(false);
		textAreaListOfIngredients.setEditable(false);
		scrollPane_1.setViewportView(textAreaListOfIngredients);
		
		JLabel lblListOfIngredients = new JLabel("List of Ingredients");
		lblListOfIngredients.setBounds(22, 195, 115, 16);
		contentPane.add(lblListOfIngredients);
		
		lblToProceed = new JLabel("To proceed save a recipe name");
		lblToProceed.setBounds(359, 13, 223, 16);
		contentPane.add(lblToProceed);
		
		lblStatus = new JLabel("");
		lblStatus.setBounds(522, 125, 56, 16);
		contentPane.add(lblStatus);
		
		JButton btnFromFile = new JButton("From File");
		btnFromFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			ImportRecipe windowImportRecipe= new ImportRecipe(recipeBook);
			windowImportRecipe.setVisible(true);
			dispose();
			}
			
		});
		btnFromFile.setBounds(484, 343, 97, 25);
		contentPane.add(btnFromFile);
		
	
	}
}
