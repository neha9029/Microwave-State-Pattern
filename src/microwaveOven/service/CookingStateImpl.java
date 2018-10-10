package microwaveOven.service;

public class CookingStateImpl implements MicrowaveStateI {

	String log = "";
	MicrowaveContext microwaveContext;

	/** CookingStateImpl constructor */
	public CookingStateImpl(MicrowaveContext microwaveContext) {
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
			log = "Cooking paused";
			microwaveContext.results.storeNewResult(log);
			microwaveContext.setState(microwaveContext.getCookingPausedState());
			break;
		case MicrowaveContext.SET_CLOCK:
			log = "Set Clock button is inactive";
			microwaveContext.results.storeNewResult(log);
			break;
		default:
			if (keycode >= 0 && keycode < 10) {
				log = "Number button is inactive";
				microwaveContext.results.storeNewResult(log);
			}
			break;

		}
	}

}
