package microwaveOven.service;

public class CookingPausedStateImpl implements MicrowaveStateI {
	String log = "";
	MicrowaveContext microwaveContext;

	/** CookingPausedStateImpl constructor */
	public CookingPausedStateImpl(MicrowaveContext microwaveContext) {
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
			log = "Cooking Resumed";
			microwaveContext.results.storeNewResult(log);
			microwaveContext.setState(microwaveContext.getCookingState());
			break;
		case MicrowaveContext.STOP:
			log = "Cooking stopped";
			microwaveContext.results.storeNewResult(log);
			microwaveContext.setState(microwaveContext.getIdleState());
			log = MicrowaveContext.getCurrentTime();
			log = "Current time is " + log;
			microwaveContext.results.storeNewResult(log);
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
