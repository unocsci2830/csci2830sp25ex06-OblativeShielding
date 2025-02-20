package pizza.topping;
public class Pepperoni extends MeatTopping {
	@Override
	public String toString() {
		return "Pepperoni";
	}
	@Override
	public int getPrice() {
		return 125;
	}
}