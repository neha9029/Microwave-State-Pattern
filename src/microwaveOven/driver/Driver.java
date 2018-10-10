package microwaveOven.driver;

import microwaveOven.service.MicrowaveContext;
import microwaveOven.util.Logger;
import microwaveOven.util.Results;

public class Driver {

	/** variable to save the input file path */
	public static String inputFilePath = "";

	/** variable to save the output file path */
	public static String outputFilePath = "";

	public static void main(String args[]) {

		if (args.length != 2) {
			Logger.printLog("Incorrect number of arguments.\nPlease provide input and output file path only.",
					Logger.ERROR);
			System.exit(1);
		} else {

			inputFilePath = args[0];
			outputFilePath = args[1];
			// inputFilePath = "/Users/nehanaik/Desktop/inputfile.txt";
			// outputFilePath = "/Users/nehanaik/Desktop/outputfile.txt";

		}

		/** initialize Results */
		Results results = new Results();

		/** initialize MicrowaveContext */
		MicrowaveContext microwaveContext = new MicrowaveContext(results);

		microwaveContext.testMe(results);
		String output = results.getResultOutput();
		Logger.printLog(output, Logger.LOG);
		results.writeToFile(output);
		results.close();

	}

}
