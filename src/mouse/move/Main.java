package mouse.move;

import java.awt.AWTException;
import java.awt.Robot;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {

	public static final int DEF_PERIOD = 60;

	public static void main(String[] args) throws AWTException {

		int period = DEF_PERIOD;
		Robot robot = new Robot();

		if (args.length > 0) {
			period = Integer.parseInt(args[0]);
		}

		ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();

		Runnable periodicTask = new Runnable() {
			public void run() {
				robot.mouseWheel(1);
			}
		};

		executor.scheduleAtFixedRate(periodicTask, period, period, TimeUnit.SECONDS);

	}

}
