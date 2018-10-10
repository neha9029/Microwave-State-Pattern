package microwaveOven.service;

public class IdleStateImpl implements MicrowaveStateI {

	String log = "";
	MicrowaveContext microwaveContext;

	public IdleStateImpl(MicrowaveContext microwaveContext) {
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
			log = "Start button is inactive";
			microwaveContext.results.storeNewResult(log);
			break;
		case MicrowaveContext.STOP:
			log = "Stop button is inactive";
			microwaveContext.results.storeNewResult(log);
			break;
		case MicrowaveContext.SET_CLOCK:
			log = "Enter Current Time";
			microwaveContext.results.storeNewResult(log);
			microwaveContext.clockTimeArray = new int[1000];
			microwaveContext.setState(microwaveContext.getClockTimeEnteredState());
			break;
		default:
			if (keycode >= 0 && keycode < 10) {
				/** Reset the cook time count and its array */
				microwaveContext.cookTimeCount = 0;
				microwaveContext.cookTimeArray = new int[1000];

				log = keycode + "";
				microwaveContext.results.storeNewResult(log);

				microwaveContext.cookTimeArray[microwaveContext.cookTimeCount] = keycode;
				microwaveContext.cookTimeCount = microwaveContext.cookTimeCount + 1;
				microwaveContext.setState(microwaveContext.getCookingTimeEnteredState());
			}
			break;

		}
	}

}
