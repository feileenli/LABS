package snacks;

/* Doritos are delicious triangular snacks.
 */
public class Dorito extends Snack {
	
	private final static double CALORIES_PER_SQUARE_INCH = 7.4;
	private final static String DESCRIPTION = "Dorito";

	public Dorito() {
		super(DESCRIPTION);
		getDimensionsFromUser();
	}
	
	@Override
	String[] getDimensionNames() {
		return new String[] {"Side 1", "Side 2", "Side 3"};
	}

	/* We use "Huron's forumula" to calculate the area of
	 * a triangle, given the three side lengths (a, b, and c).
	 */
	@Override
	protected double getArea() {
		double a = dimensions.get(0);
		double b = dimensions.get(1);
		double c = dimensions.get(2);
		
		double s = (a + b + c) / 2;
		return Math.sqrt(s * (s - a) * (s - b) * (s - c));
	}

	@Override
	protected double getCaloriesPerSquareInch() {
		return CALORIES_PER_SQUARE_INCH;
	}
}
