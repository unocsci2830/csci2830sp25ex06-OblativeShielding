package pizza.crust;

import pizza.MenuItem;

public abstract class PizzaCrust implements MenuItem {
	
	protected String ingredient = "";
	
	@Override
	public abstract String toString();
	
	public String toNiceString() {
		int p = this.getPrice();
		return "Crust: " + toString() 
			+ (!ingredient.equals("") ? (" made with " + ingredient) : "")
			+ " ($" + p / 100 + "." + p % 100 + ")";
	}
	
	public void setIngredient(String i) {
		ingredient = i;
	}
	
	public String getIngredient() {
		return ingredient;
	}
	
	public String checkIntegrity() {
		return "";
	}

}