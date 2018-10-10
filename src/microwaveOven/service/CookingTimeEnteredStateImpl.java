package microwaveOven.service;

public class CookingTimeEnteredStateImpl implements MicrowaveStateI {

	String log = "";
	MicrowaveContext microwaveContext;

	/** CookingTimeEnteredStateImpl constructor */
	public CookingTimeEnteredStateImpl(MicrowaveContext microwaveContext) {
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
			if (microwaveContext.cookTimeCount > 2) {

				if (microwaveContext.cookTimeCount == 3) {
					log = "0" + microwaveContext.cookTimeArray[0] + ":" + microwaveContext.cookTimeArray[1] + ""
							+ microwaveContext.cookTimeArray[2];
				} else if (microwaveContext.cookTimeCount > 3) {
					log = microwaveContext.cookTimeArray[0] + "" + microwaveContext.cookTimeArray[1] + ":"
							+ microwaveContext.cookTimeArray[2] + "" + microwaveContext.cookTimeArray[3];
				}
				log = "Cooking state entered for " + log;
				microwaveContext.results.storeNewResult(log);

				microwaveContext.setState(microwaveContext.getCookingState());
				microwaveContext.cookTimeCount = 0;
				microwaveContext.cookTimeArray = new int[1000];
			} else {
				log = "Start button is inactive " + log;
				microwaveContext.results.storeNewResult(log);
			}
			break;
		case MicrowaveContext.STOP:
			microwaveContext.cookTimeCount = 0;
			log = MicrowaveContext.getCurrentTime();
			microwaveContext.results.storeNewResult(log);
			microwaveContext.setState(microwaveContext.getIdleState());
			break;
		case MicrowaveContext.SET_CLOCK:
			log = "Set clock button is inactive";
			microwaveContext.results.storeNewResult(log);
			break;
		default:
			if (keycode >= 0 && keycode < 10) {
				/**
				 * Increment cookTimeCount and add to cook time array every time
				 * user hits the number pad
				 */
				microwaveContext.cookTimeArray[microwaveContext.cookTimeCount] = keycode;
				microwaveContext.cookTimeCount = microwaveContext.cookTimeCount + 1;

				/**
				 * Take input from user if the count is less than or equal to 4
				 */
				if (microwaveContext.cookTimeCount <= 4) {
					log = keycode + "";
					microwaveContext.results.storeNewResult(log);
				}
				/** Produce beep if user hits more than 4 digits */
				else if (microwaveContext.cookTimeCount > 4) {
					log = "Beep";
					microwaveContext.results.storeNewResult(log);
				}
			}
			break;

		}
	}

}
