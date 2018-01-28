package org.game.fantasy.utils;

public class Delay {

	private Integer seconds;

	public Delay(Integer seconds) {
		super();
		this.seconds = seconds;
	}

	public void delayExecution() {

		try {

			Thread.sleep(seconds * 1000);

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
