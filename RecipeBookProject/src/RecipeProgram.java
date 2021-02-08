
public class RecipeProgram {

	
	public static void main(String[] args) {
		//Create a new object RecipeBook that will contain the recipes with the applicable list of ingredients
			RecipeBook recipeBook= new RecipeBook();
			recipeBook.setName("My Recipe Book");
		// This is the default value that will be shown on the drop down list
			recipeBook.newRecipe("Select an Option");
		
		//Loading  sample recipes into memory
			//Create an object type Recipe
				recipeBook.newRecipe("Peach Almond Pie");
				
			//	Adding ingredients to the the Recipe
				recipeBook.addIngredient("Peach Almond Pie"," fresh peaches, sliced ",2, "cups");
				recipeBook.addIngredient("Peach Almond Pie"," lemon juice ",1, "Tbsp");
				recipeBook.addIngredient("Peach Almond Pie"," sugar ",0.25, "cup");
				recipeBook.addIngredient("Peach Almond Pie"," cornstarch ",3, "Tbsp");
				recipeBook.addIngredient("Peach Almond Pie"," butter ",2, "tsp");
				recipeBook.addIngredient("Peach Almond Pie"," salt ",1, "dash");
				recipeBook.addIngredient("Peach Almond Pie"," almond extract ",0.25, "tsp");
				recipeBook.addIngredient("Peach Almond Pie"," pie shell ",1, "9 inch");
		
				// Adding cooking instructions	
				recipeBook.setRecipeInstruction("Peach Almond Pie", "Sprinkle peaches with lemon and sugar.  Let stand 1 hour.  Drain to get 1 cup syrup.  Add cornstarch to syrup and blend.  Cook over low heat until thick.  Remove from heat.  Add butter, salt, and almond extract.  Cool.  Carefully stir in peaches.  Put in shell.  Chill.  Serve with whipped cream, topped with slivered almonds and marachino cherries.");
				recipeBook.newRecipe("Creamy Chicken Broccoli with Rice");
				recipeBook.addIngredient("Creamy Chicken Broccoli with Rice"," miracle whip ",0.5, "cups");
				recipeBook.addIngredient("Creamy Chicken Broccoli with Rice"," skinless chicken breast, cubed ",1, "pound");
				recipeBook.addIngredient("Creamy Chicken Broccoli with Rice"," broccoli, chopped ",2, "cups");
				recipeBook.addIngredient("Creamy Chicken Broccoli with Rice"," Velveeta rice ",0.5, "pound");
				recipeBook.setRecipeInstruction("Creamy Chicken Broccoli with Rice", "Heat salad dressing in a large skillet. Add chicken and completely cook for about 8 minutes. Stir in broccoli and cook until heated. Add Velveeta and stir until thoroughly melted. Serve over rice.");
		
				
				//Display the Main Menu to the user
		MainMenu mainMenu =new MainMenu(recipeBook);
		mainMenu.setVisible(true);
//		
	}
}
	