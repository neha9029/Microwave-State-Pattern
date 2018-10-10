package microwaveOven.service;

public class ClockTimeEnteredStateImpl implements MicrowaveStateI {
	String log = "";
	MicrowaveContext microwaveContext;

	/** ClockTimeEnteredStateImpl constructor */
	public ClockTimeEnteredStateImpl(MicrowaveContext microwaveContext) {
		this.microwaveContext = microwaveContext;
	}

	@Override
	public void startPressed() {
		action(MicrowaveContext.START);

	}

	@Override
	public void stopPressed() {

		action(MicrowaveContext.STOP);
	}

	@Override
	public void numberPressed(int num) {

		action(num);
	}

	@Override
	public void setClockPressed() {

		action(MicrowaveContext.SET_CLOCK);

	}

	void action(int keycode) {

		switch (keycode) {

		case MicrowaveContext.START:
			/**
			 * Check if the count is at least greater than 2 and form the HH:mm
			 * format clock
			 */
			if (microwaveContext.clockTimeCount > 2) {
				if (microwaveContext.clockTimeCount == 3) {
					log = "0" + microwaveContext.clockTimeArray[0] + ":" + microwaveContext.clockTimeArray[1] + ""
							+ microwaveContext.clockTimeArray[2];
				} else if (microwaveContext.clockTimeCount > 3) {
					log = microwaveContext.clockTimeArray[0] + "" + microwaveContext.clockTimeArray[1] + ":"
							+ microwaveContext.clockTimeArray[2] + "" + microwaveContext.clockTimeArray[3];
				}
				log = "Current time set to " + log;
				microwaveContext.results.storeNewResult(log);
				microwaveContext.setState(microwaveContext.getIdleState());
				microwaveContext.clockTimeCount = 0;
			} else {
				log = "Start button is inactive";
				microwaveContext.results.storeNewResult(log);
			}
			break;
		case MicrowaveContext.STOP:
			log = "Stop button is inactive";
			microwaveContext.results.storeNewResult(log);
			break;
		case MicrowaveContext.SET_CLOCK:
			log = "Set Clock button is inactive";
			microwaveContext.results.storeNewResult(log);
			break;
		default:
			if (keycode >= 0 && keycode < 10) {
				/**
				 * Increment clockTimeCount and add to clock array every time
				 * user hits the number pad
				 */
				microwaveContext.clockTimeArray[microwaveContext.clockTimeCount] = keycode;
				microwaveContext.clockTimeCount = microwaveContext.clockTimeCount + 1;

				/**
				 * Take input from user if the count is less than or equal to 4
				 */
				if (microwaveContext.clockTimeCount <= 4) {

					log = keycode + "";
					microwaveContext.results.storeNewResult(log);
				}
				/** Produce beep if user hits more than 4 digits */
				else if (microwaveContext.clockTimeCount > 4) {
					log = "Beep";
					microwaveContext.results.storeNewResult(log);
				}
			}
			break;

		}
	}

}
