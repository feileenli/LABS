package snacks;

/* Triscuits are rectangular snacks that taste like cardboard.
 */
public class Triscuit extends Snack {
	
	private final static double CALORIES_PER_SQUARE_INCH = 6.1;
	private final static String DESCRIPTION = "Triscuit";

	public Triscuit() {
		super(DESCRIPTION);
		getDimensionsFromUser();
	}
	
	@Override
	String[] getDimensionNames() {
		return new String[] {"Length", "Width"};
	}

	/* Triscuits are rectangles, so the area is
	 * length * width
	 */
	@Override
	protected double getArea() {
		double length = dimensions.get(0);
		double width = dimensions.get(1);
		return length * width;
	}

	@Override
	protected double getCaloriesPerSquareInch() {
		return CALORIES_PER_SQUARE_INCH;
	}
}
