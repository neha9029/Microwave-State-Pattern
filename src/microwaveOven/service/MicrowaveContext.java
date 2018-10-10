package microwaveOven.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import microwaveOven.util.Results;

public class MicrowaveContext {

	MicrowaveStateI idleState;
	MicrowaveStateI cookingTimeEnteredState;
	MicrowaveStateI cookingState;
	MicrowaveStateI cookingPausedState;
	MicrowaveStateI clockTimeEnteredState;

	MicrowaveStateI state = idleState;
	int cookTimeCount = 0;
	int clockTimeCount = 0;

	Results results;

	int clockTimeArray[] = new int[1000];
	int cookTimeArray[] = new int[1000];

	public static final int START = 100;
	public static final int STOP = 101;
	public static final int SET_CLOCK = 102;

	public MicrowaveContext(Results results) {

		idleState = new IdleStateImpl(this);
		cookingTimeEnteredState = new CookingTimeEnteredStateImpl(this);
		cookingState = new CookingStateImpl(this);
		cookingPausedState = new CookingPausedStateImpl(this);
		clockTimeEnteredState = new ClockTimeEnteredStateImpl(this);

		this.results = results;

	}

	public void setState(MicrowaveStateI state) {
		this.state = state;
	}

	public MicrowaveStateI getIdleState() {
		return idleState;
	}

	public MicrowaveStateI getCookingTimeEnteredState() {
		return cookingTimeEnteredState;
	}

	public MicrowaveStateI getCookingState() {
		return cookingState;
	}

	public MicrowaveStateI getCookingPausedState() {
		return cookingPausedState;
	}

	public MicrowaveStateI getClockTimeEnteredState() {
		return clockTimeEnteredState;
	}

	public void startPressed() {

		state.startPressed();
	}

	public void stopPressed() {

		state.stopPressed();
	}

	public void numberPressed(int num) {

		state.numberPressed(num);
	}

	public void setClockPressed() {

		state.setClockPressed();
	}

	public static String getCurrentTime() {
		DateFormat dateFormat = new SimpleDateFormat("HH:mm");
		Date date = new Date();
		return dateFormat.format(date);

	}

	public void testMe(Results results) {

		String line = "";

		int count = 0;
		setState(getIdleState());
		while ((line = results.getFileProcessor().readLine()) != null) {

			int number = 0;
			try {
				number = Integer.parseInt(line);
				if (number >= 0 && number < 10) {
					numberPressed(number);
				} else {
					switch (number) {
					case START:
						startPressed();
						break;
					case STOP:
						stopPressed();
						break;
					case SET_CLOCK:
						setClockPressed();
						break;

					default:
						break;
					}
				}

			} catch (NumberFormatException e) {
				System.err.println(line + " is an invalid number.\nTerminating the process");
				results.close();
				System.exit(1);
			}

			count++;
		}

		if (count == 0) {
			System.err.println("File is empty.");
		}

	}

}
