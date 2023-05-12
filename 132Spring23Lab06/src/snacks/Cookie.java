package snacks;

/* Cookies come in three varieties. Chocolate Chip and Oatmeal cookies are round; 
 * Lemon Square Cookies are Squares.
 */
public class Cookie extends Snack { 
	
	public enum CookieType {CHOCOLATE_CHIP("Chocolate Chip"), 
							OATMEAL("Oatmeal"), 
							LEMON_SQUARE("Lemon Square");

		private String name;

		CookieType(String name) {
			this.name = name;
		}

		@Override
		public String toString() {
			return name;
		}
	}

	private CookieType type;

	public Cookie(CookieType type) {
		super(type + " Cookie");    // invokes toString() on the type
		this.type = type;
		getDimensionsFromUser();
	}

	/* Round cookies have a diameter.
	 * Square cookies have only a "width".
	 */
	@Override
	String[] getDimensionNames() {
		if (type == CookieType.CHOCOLATE_CHIP || type == CookieType.OATMEAL) {
			return new String[] {"diameter"};
		} else {
			return new String[] {"width"};
		}
	}

	/* Round cookies have area:  PI * r^2
	 * Square cookies have area:  width^2
	 */
	@Override
	public double getArea() {
		if (type == CookieType.CHOCOLATE_CHIP || type == CookieType.OATMEAL) {
			double radius = dimensions.get(0) / 2;
			return Math.PI * radius * radius;
		} else {
			double width = dimensions.get(0);
			return width * width;
		}
	}

	@Override
	protected double getCaloriesPerSquareInch() {
		switch (type) {
		case CHOCOLATE_CHIP:
			return 10.5;
		case OATMEAL:
			return 6.4;
		case LEMON_SQUARE:
			return 8.9;
		default:
			throw new IllegalStateException("Unknown cookie!");
		}
	}

}
