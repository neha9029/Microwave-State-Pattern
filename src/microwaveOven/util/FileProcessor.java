package microwaveOven.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import microwaveOven.driver.Driver;

public class FileProcessor {

	/** To read the file contents */
	FileReader fileReader;

	/** Reads text from a character-input stream */
	BufferedReader bufferedReader;

	/** Writes text to a character-output stream */
	BufferedWriter bufferedWriter;

	/** To write to output.txt file */
	FileWriter fileWriter;

	public FileProcessor() {
		// TODO Auto-generated constructor stub

		try {
			fileReader = new FileReader(Driver.inputFilePath);
			bufferedReader = new BufferedReader(fileReader);
		} catch (Exception e) {
			Logger.printLog("Invalid file path.\nPlease enter a valid input file path.", Logger.ERROR);
			System.exit(1);
		}

		try {
			bufferedWriter = new BufferedWriter(new FileWriter(Driver.outputFilePath, true));

		} catch (Exception e) {
			// TODO Auto-generated catch block
			Logger.printLog("Invalid file path.\nPlease enter a valid output file path.", Logger.ERROR);
			System.exit(1);
		}

	}

	public String readLine() {

		try {
			return bufferedReader.readLine();
		} catch (IOException e) {

			e.printStackTrace();
		}
		return null;
	}

	public void write(String s) {
		try {

			bufferedWriter.write(s);
			bufferedWriter.newLine();
			bufferedWriter.flush();

		} catch (IOException e) {
			Logger.printLog("Something went wrong while writing to file.\nPlease try again.", Logger.ERROR);
			e.printStackTrace();

			System.exit(1);
		} finally {
		}
	}

	/** close all the read and write */
	public void close() {

		if (fileReader != null)
			try {
				fileReader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		if (bufferedReader != null)
			try {
				bufferedReader.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}

		if (bufferedWriter != null)
			try {
				bufferedWriter.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
	}

	@Override
	public String toString() {
		return "FileProcessor []";
	}

}
