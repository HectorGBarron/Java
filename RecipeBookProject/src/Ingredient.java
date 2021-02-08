/*
 * Method to store the ingredients of a recipe
 * Stores the name, the quantity and the unit of measurement for an ingredient
 * Manages the update the name, quantity and unit of measurement
 * Returns the individual elements: name of the ingredient, quantity and the unit of measurement
 * Returns a string (toString) of the ingredient, quantity and unit of measurement all together 
 */
public class Ingredient {
	private String name;
	private double quantity;
	private String measure;

	/*Constructor to initialize the variables
	 * This constructor will run if no input is received, just an instantiation requested
	 * The variables are initialized with no value
	 */
	public Ingredient() {
		this.name="";
		this.quantity=0.00;
		this.measure="";
	}
		
	/*Constructor overload 
	 * This constructor if the variables values are passed
	 */
	public  Ingredient(String name, double quantity, String measure) 
	{
		this.name=name;
		this.quantity=quantity;
		this.measure=measure;
	}
	
	/* Method to set or update the variable name
	 * Receives the name of the ingredient as a string variable called name
	 * Sets the name (this.name) of the instantiated method to the received name value
	 */
	public void setName(String name) 
	{
		this.name=name;
	}
	
	/* Method to set or update the variable quantity
	 * Receives the quantity of the ingredient as a double variable called quantity
	 * Sets the quantity (this.quantity) of the instantiated method to the received name value
	 */
	public void setQuantity(double quantity) {
		this.quantity=quantity;
	}
	
	/* Method to set or update the variable measurement unit of the ingredient
	 * Receives the name of the new measurement unit as a string variable called measure
	 * Sets the new measurement unit (this.measure) of the instantiated 
	 */	
	public void setMeasureUnit(String measure) {
		this.measure=measure;
	}
	
	//Method to return the name of the ingredient
	public String getName() {
		return name;
	}
	
	//Method to return the quantity of the ingredient
	public double getQuantity() {
		return quantity;
	}
	
	//Method to return the measurement unit of the ingredient
	public String getMeasure() {
		return measure;
	}
	
	/*Method to compare two ingredients (objects) based on the name of the ingredient
	 * It receives the ingredient object, extracts the name and compares it 
	 * The method returns boolean, either true or false
	 */
	public boolean equals (Ingredient object) {
		Ingredient i= object;
		
		if (this.name.toLowerCase().equals(i.getName().toLowerCase()))
			{
				return true;
			} 
		else 
			{
			return false;
			}
	}
	
	/* Method consolidate the three variables into a single string
	 * Doesn't receive anything, it is only called 
	 * It returns a string
	 */
	public String toString() {
		return(name +" "+quantity+" "+ measure);
	}
}
