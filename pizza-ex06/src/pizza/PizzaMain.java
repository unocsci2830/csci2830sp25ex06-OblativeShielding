package pizza;
import java.util.InputMismatchException;
import java.util.Scanner;

import pizza.crust.CheesyCrust;
import pizza.crust.PizzaCrust;
import pizza.crust.PuffyCrust;
import pizza.crust.ThickCrust;
import pizza.crust.ThinCrust;
import pizza.sauce.Alfredo;
import pizza.sauce.Buffalo;
import pizza.sauce.PizzaSauce;
import pizza.sauce.TomatoSauce;
import pizza.topping.Anchovy;
import pizza.topping.Asiago;
import pizza.topping.Bacon;
import pizza.topping.BellPepper;
import pizza.topping.Jalapeno;
import pizza.topping.MexicanBlend;
import pizza.topping.Mozarella;
import pizza.topping.Parmesan;
import pizza.topping.Pepperoni;
import pizza.topping.PizzaTopping;
import pizza.topping.RedOnion;
import pizza.topping.Sausage;
import pizza.topping.Tomato;

public class PizzaMain {
	
	static Scanner in = new Scanner(System.in);
	
    public static void main(String[] args) {
    	// Welcome
    	System.out.println("Welcome to Joe's Pizzeria!\n");
    	
    	// choose crust
    	System.out.println("""
                           What style of crust do you want?
                           0 - Thin Crust ($1.75)
                           1 - Puffy Crust ($3.00)
                           2 - Cheesy Crust ($3.50)
                           3 - Thick Crust ($3.25)""");
    	PizzaCrust crust = null;
    	switch(readIntInput(0,3)) {
    		case 0:
    			crust = new ThinCrust();
    			break;
    		case 1:
    			crust = new PuffyCrust();
    			break;
    		case 2:
    			crust = new CheesyCrust();
    			break;
    		case 3:
    			System.out.println("Would you like that to be deep dish for an additional $1?"
					+ " 1 for yes, 0 for no:");
    			crust = new ThickCrust(readIntInput(0,1) == 1);
    			break;
    		default: // shouldn't happen
    			System.out.println("ERROR: Defaulting to thin crust.");
    			crust = new ThinCrust();	
    	}

    	System.out.println(crust.toString() + " selected!");
    	
    	// choose crust ingredient
    	System.out.println("Which crust base ingredient would you like?\n0 - Flour\n1 - Cauliflower\n2 - Potato");
    	switch(readIntInput(0,2)) {
	    	case 0:
	    		crust.setIngredient("Flour");
	    		break;
	    	case 1:
	    		crust.setIngredient("Cauliflower");
	    		break;
	    	case 2:
	    		crust.setIngredient("Potato");
	    		break;
    		default:
    			System.out.println("ERROR: Defaulting to flour.");
    			crust.setIngredient("Flour");
    	}
    	
    	// choose sauce
    	System.out.println("""
						What kind of sauce do you want?
						0 - Tomato Sauce ($0.60)
						1 - Alfredo ($0.75)
						2 - Buffalo ($1.25)""");
    	PizzaSauce sauce = null;
    	switch(readIntInput(0,2)) {
    		case 0:
    			sauce = new TomatoSauce();
    			break;
    		case 1:
    			sauce = new Alfredo();
    			break;
    		case 2:
    			sauce = new Buffalo();
    			break;
    		default:
    			System.out.println("ERROR: Defaulting to tomato sauce.");
    			sauce = new TomatoSauce();
    	}
    	System.out.println(sauce.toString() + " selected!");
    	
    	// choose toppings
    	System.out.println("""
                           What toppings do you want? Choose up to 4.
                           00 - Anchovy ($1.00)
                           01 - Asiago ($0.99)
                           02 - Bacon ($1.76)
                           03 - Bell Pepper ($0.46)
                           04 - Jalapeno ($0.60)
                           05 - Mexican Cheese Blend ($0.89)
                           06 - Mozarella ($0.78)
                           07 - Parmesan ($0.93)
                           08 - Pepperoni ($0.99)
                           09 - Red Onion ($0.56)
                           10 - Sausage ($1.24)
                           11 - Tomato ($0.70)
                           
                           12 - Done""");
    	PizzaTopping[] toppings = new PizzaTopping[4];
    	boolean noMore = false;
    	for(int i = 0; i < 4; i++) {
    		
    		switch(readIntInput(0,12)) {
    			case 0:
    				toppings[i] = new Anchovy();
    				break;
    			case 1:
    				toppings[i] = new Asiago();
    				break;
    			case 2:
    				toppings[i] = new Bacon();
    				break;
    			case 3:
    				toppings[i] = new BellPepper();
    				break;
    			case 4:
    				toppings[i] = new Jalapeno();
    				break;
    			case 5:
    				toppings[i] = new MexicanBlend();
    				break;
    			case 6:
    				toppings[i] = new Mozarella();
    				break;
    			case 7:
    				toppings[i] = new Parmesan();
    				break;
    			case 8:
    				toppings[i] = new Pepperoni();
    				break;
    			case 9:
    				toppings[i] = new RedOnion();
    				break;
    			case 10:
    				toppings[i] = new Sausage();
    				break;
    			case 11:
    				toppings[i] = new Tomato();
    				break;
    			case 12:
    				noMore = true;
    				break;
    			default: // shouldn't happen
    				System.out.println("ERROR: Defaulting to no more toppings.");
    				noMore = true;
    		}
    		
    		if(noMore) {
    			break;
    		} else {
    			System.out.println(toppings[i].toString() + " selected! " + (3-i) + " more to choose!");
    		}
    		
    	}

		Pizza p = new Pizza(crust, sauce, toppings);
		System.out.println("\nYour pizza is complete! Here is what you ordered:\n" + p.toString());
		System.out.print(crust.checkIntegrity());
		System.out.println("\nThanks for eating at Joe's Pizzeria!\n");
    	
    }
    
    // read and validate integer input within range
    private static int readIntInput(int min, int max) {
    	
    	boolean inputAccepted = false;
    	int input = min - 1;
    	
    	while(!inputAccepted) {
    		
    		try {
    			input = in.nextInt();
    		} catch(InputMismatchException e) { //unmatched input
    			in.nextLine(); // clear buffer
    		}
    		
    		if(input < min || input > max) { // out of range
    			System.out.println("Invalid input. Please select from the integer options above.");
    		} else { // good
    			inputAccepted = true;
    		}
    		
    	}
    	
    	return input;
    	
    }
}