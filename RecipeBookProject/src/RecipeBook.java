import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class RecipeBook {
ArrayList<Recipe> recipeBook;
private String name;
private Recipe recipe;
private Ingredient ingredient;
public static ArrayList<Ingredient> allIngredients= new ArrayList<Ingredient>();
private Scanner input; 

public RecipeBook() {
	this.name="";
	recipeBook= new ArrayList<Recipe>();
}

public RecipeBook(String name) {
		
	this.name=name;
	recipeBook= new ArrayList<Recipe>();
	recipe = new Recipe();
	}

public String getName() {
	return this.name;
}

public void setName(String name) {
	this.name=name;
}

public void newRecipe(String name) {
	recipe=new Recipe(name);
	recipeBook.add(recipe);
}

public boolean addIngredient(String recipeName, String ingredientName, double quantity, String measure) {
boolean contains;
recipe = findRecipe(recipeName);
Ingredient newIngredient=new Ingredient(ingredientName,quantity,measure);


contains=recipe.addIngredient(newIngredient);
return contains;

}

public void setRecipeInstruction(String recipeName,String instructions) {
	recipe = findRecipe(recipeName);
	recipe.setRecipeInstructions(instructions);
}

public Recipe findRecipe(String name) {
	
	
	for ( Recipe i : recipeBook) {
		
		if (i.getName().equals(name)) 
		
			return i;
 	}
	System.out.println("Object RecipeBook, could not find the recipe, go to line 65");
	return null;
 }

public String getRecipeInstructions(String name) {

	Recipe recipeInstructions;
	
	recipeInstructions=findRecipe(name);
	
	
	return recipeInstructions.getRecipeInstructions();
}

public String getRecipe(String name) {
	
	
	Recipe recipeIngredients ;
	recipeIngredients=findRecipe(name);
	
	return(recipeIngredients.toString());

}

public void printRecipe(String name) throws FileNotFoundException {
		
		PrintWriter output = new PrintWriter(name+".txt");
		output.print("Recipe for " + name +"\n \n");
		output.print("\t Instructions \n");
		output.print(getRecipeInstructions(name)+"\n \n");
		output.print("\tIngredients \n");
		output.print(getRecipe(name));
		output.close();
		
		String openfile=System.getProperty("user.dir") + "\\" + name+".txt" ; 
		try {
			Process p = Runtime.getRuntime().exec("notepad " + openfile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Error while tring to print a file go to Object named RecipeBook, method printRecipe " );
		}
		
}

public String[] allRecipes() {
	String[] allRecipes = new String[recipeBook.size()];
	int num=0;
	 for (Recipe  i:recipeBook) {
		 allRecipes[num]=i.getName();
		 num++;
	 }
	
	return allRecipes;
}

public void importRecipe(String filename) throws FileNotFoundException {
	String recipeName=filename.substring(0,filename.indexOf("."));
	newRecipe(recipeName);
	String nme,um, inst;
	double qty;
	input= new Scanner(new FileReader(filename));
	inst=input.nextLine();
	setRecipeInstruction(recipeName,inst);
	
		try { while (input.hasNextLine()) {
		 	nme=input.next();
			qty=input.nextDouble();
			um=input.next();
			addIngredient(recipeName,nme, qty, um); 
	 }
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "The file " + filename + " doesn't have the correct format");
		}

	
  
 
 input.close();
 
 
	
	
}

}
