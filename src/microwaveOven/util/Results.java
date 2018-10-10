package microwaveOven.util;

import java.util.ArrayList;

public class Results implements FileDisplayInterface, StdoutDisplayInterface {

	private FileProcessor fileProcessor;
	private ArrayList<String> arrayResult = null;

	public Results() {
		// TODO Auto-generated constructor stub
		fileProcessor = new FileProcessor();
		arrayResult = new ArrayList<>();
	}

	@Override
	public void writeToStdout(String s) {
		
		Logger.printLog(s, Logger.LOG);

	}

	@Override
	public void writeToFile(String s) {
		
		fileProcessor.write(s);

	}

	public void storeNewResult(String testResult) {

		arrayResult.add(testResult);
	}

	public String getResultOutput() {

		StringBuilder strngBuilder = new StringBuilder();
		for (String data : arrayResult) {

			strngBuilder.append(data).append("\n");
		}
		return strngBuilder.toString();
	}

	public FileProcessor getFileProcessor() {

		return fileProcessor;
	}

	public void close() {
		fileProcessor.close();
	}

	@Override
	public String toString() {
		return "Results []";
	}
}
