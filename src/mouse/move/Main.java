package mouse.move;

import java.awt.AWTException;
import java.awt.Robot;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {

	public static final int DEF_PERIOD = 60;

	static void moveWheel(int amt) throws AWTException {
		Robot robot = new Robot();
		robot.mouseWheel(amt);
	}

	public static void main(String[] args) {

		int period = DEF_PERIOD;

		if (args.length > 0) {
			period = Integer.parseInt(args[0]);
		}

		ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();

		Runnable periodicTask = new Runnable() {
			public void run() {
				try {
					moveWheel(1);
				} catch (AWTException e) {
					e.printStackTrace();
				}
			}
		};

		executor.scheduleAtFixedRate(periodicTask, period, period, TimeUnit.SECONDS);

	}

}
