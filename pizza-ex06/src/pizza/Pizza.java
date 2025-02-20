package pizza;
import java.util.ArrayList;

import pizza.crust.PizzaCrust;
import pizza.sauce.PizzaSauce;
import pizza.topping.PizzaTopping;

public class Pizza implements MenuItem {
	
	//initialize member variables
	private PizzaCrust crust;
	private PizzaSauce sauce;
	private PizzaTopping[] toppings;

	private ArrayList<MenuItem> receipt = new ArrayList<MenuItem>();
	
	//constructor method that takes one crust, one sauce, and an array of toppings
	public Pizza(PizzaCrust c, PizzaSauce s, PizzaTopping[] t) {
		crust = c;						//Initializing the member variables from the parameters
		receipt.add(c);					//Adding new items to receipt
		sauce = s;						//---
		receipt.add(c);					//---
		toppings = new PizzaTopping[4]; //---
		for(int i = 0; i < (4 < t.length ? 4 : t.length); i++) { //Limit toppings to 4 even if input is bigger
			toppings[i] = t[i];									 //Probably unnecessary, but meh
			if(t[i] != null) {
				receipt.add(t[i]);
			}
		}
	}
	
	public PizzaCrust getCrust() { //getter method - unneeded for the way I set it up, but force of habit
		return crust;
	}
	
	public PizzaSauce getSauce() { //ditto
		return sauce;
	}
	
	public PizzaTopping[] getToppings() { //ditto
		return toppings.clone();
	}
	
	@Override
	public String toString() { //toString override
		String r = "Pizza\n-=-=-=-=-\n" + crust.toNiceString() + "\n" + sauce.toNiceString();
		for(PizzaTopping t : toppings) {
			if(t != null) {
				r += "\n" + t.toNiceString();
			}
		}
		int p = this.getPrice();
		r += "\nTotal cost: $" + (p / 100) + "." + (p % 100) + "."; 
		return r;
	}
	
	@Override
	public int getPrice() {
		int p = 0;
		for(MenuItem m : receipt) {
			p += m.getPrice();
		}
		return p;
	}

}