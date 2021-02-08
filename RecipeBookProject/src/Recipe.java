
import java.util.ArrayList;

import javax.swing.JOptionPane;

// This Class creates the Object Recipe that contains ingredients
// and instructions

public class Recipe {
public ArrayList<Ingredient> ingredientList;
private String name;
private String recipeInstructions;
	
	/*Constructor to initialize the variables when the object its instantiated without passing values
	 * It doesn't receive any value
	 * It initialized the variables 
	 */
	public Recipe() {
		this.name="";
		ingredientList=new ArrayList<Ingredient>();
		recipeInstructions="";
	}

	
	/*Constructor to initialize the variables when the object its instantiated passing values
	 * It receives the name of the recipe
	 * It initialized the variables and assign the name of the recipe to the variable name 
	 */
		public Recipe(String name) {
		this.name=name;
		ingredientList=new ArrayList<Ingredient>();
		recipeInstructions="";
	}

	public void setName(String name) {
		this.name=name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public boolean addIngredient(Ingredient ingredient)
	{		
		boolean contains=false;
		for (Ingredient i:ingredientList) 
		{
			if (i.equals(ingredient))
				{contains= true;
				JOptionPane.showMessageDialog(null, "The ingredient "+i.getName()+ " already exist \n It won't be added");
				break;
				}			
		}
		
	 if (!contains) {
		 ingredientList.add(ingredient);
	 }
	
	return contains;	
		
		
	}

	public void setRecipeInstructions(String instructions) {
		this.recipeInstructions=instructions;
	}
	
	public String getRecipeInstructions() {
		return this.recipeInstructions;
	}
	
	public String toString() {
		
		String stringIngredients="\n";
		for (Ingredient i:ingredientList) 
		{
	
			stringIngredients+=i.toString()+"\n";
		
		}
		
		return stringIngredients;
	}
	

}
