import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.io.FileNotFoundException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ImportRecipe extends JFrame {

	private JPanel contentPane;
	private RecipeBook recipeBook; 
	private JTextField textFieldFileName;
	private JTextField textInstruction;
	private JLabel lblCaution;
	private JTextArea textIngredients;
	private String fileName;
	private String recipeName;
	/**
	 * Create the frame.
	 */
	public ImportRecipe(RecipeBook recipeBook) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Import Recipe");
		this.recipeBook=recipeBook;
		setBounds(100, 100, 616, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblFileName = new JLabel("File Name:");
		lblFileName.setBounds(46, 54, 94, 16);
		contentPane.add(lblFileName);
		
		textFieldFileName = new JTextField();
		textFieldFileName.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
			lblCaution.setText("file.txt");
			}
		});
		textFieldFileName.setBounds(133, 51, 142, 22);
		contentPane.add(textFieldFileName);
		textFieldFileName.setColumns(10);
		
		lblCaution = new JLabel("");
		lblCaution.setBounds(156, 32, 56, 16);
		contentPane.add(lblCaution);
		
		JButton btnImport = new JButton("Import");
		btnImport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			try {
				fileName=textFieldFileName.getText();
				recipeName=fileName.substring(0,fileName.indexOf("."));
				
			} catch (Exception e) {
				// TODO: handle exception
				JOptionPane.showMessageDialog(null, "verify the file name or format  -> file.txt");
			}
			
			try {
					recipeBook.importRecipe(fileName);
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "The file "+ fileName + " was not found");
				}
			textInstruction.setText(recipeBook.getRecipeInstructions(recipeName));
			textIngredients.setText(recipeBook.getRecipe(recipeName));
			
				
			}
		});
		btnImport.setBounds(303, 50, 97, 25);
		contentPane.add(btnImport);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(49, 122, 491, 61);
		contentPane.add(scrollPane);
		
		textInstruction = new JTextField();
		textInstruction.setEnabled(false);
		textInstruction.setEditable(false);
		scrollPane.setViewportView(textInstruction);
		textInstruction.setColumns(10);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(47, 222, 493, 118);
		contentPane.add(scrollPane_1);
		
		textIngredients = new JTextArea();
		scrollPane_1.setViewportView(textIngredients);
		textIngredients.setEnabled(false);
		textIngredients.setEditable(false);
		
		JLabel lblIngredients = new JLabel("Ingredients");
		lblIngredients.setBounds(46, 206, 112, 16);
		contentPane.add(lblIngredients);
		
		JLabel lblInstructions = new JLabel("Instructions");
		lblInstructions.setBounds(46, 104, 112, 16);
		contentPane.add(lblInstructions);
	}
}
