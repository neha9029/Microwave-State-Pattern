package microwaveOven.util;

public class Logger {

	public static final int ERROR = 0;
	public static final int LOG = 1;

	/* print command based on the type */
	public static void printLog(String s, int type) {
		if (s != null) {

			switch (type) {
			case ERROR:
				System.err.println(s);
				break;
			case LOG:
				System.out.println(s);
				break;

			default:
				break;
			}

		}
	}

	@Override
	public String toString() {
		return "Logger []";
	}

}
