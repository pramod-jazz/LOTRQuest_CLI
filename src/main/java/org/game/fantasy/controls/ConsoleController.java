package org.game.fantasy.controls;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Optional;
import java.util.Scanner;

import org.apache.log4j.Logger;
import org.game.fantasy.Game;
import org.game.fantasy.exceptions.GameException;
import org.game.fantasy.ui.Header;


/**
 * The Class ConsoleController.
 */
public class ConsoleController {

	/** The Constant logger. */
	final static Logger logger = Logger.getLogger(Game.class);

	/** The scanner. */
	static Scanner scanner = new Scanner(System.in);

	/**
	 * Prints the to console.
	 *
	 * @param filePath the file path
	 * @param isSameLine the is same line
	 */
	public void printToConsole(String filePath, boolean isSameLine) {
		try (BufferedReader reader = new BufferedReader(
				new InputStreamReader(Header.class.getClassLoader().getResourceAsStream(filePath)))) {
			reader.lines().forEach(isSameLine ? System.out::println : System.out::println);
		} catch (IOException e) {
			System.out.println(e);
		}
	}

	/**
	 * Prints the message to console.
	 *
	 * @param customMessage the custom message
	 */
	public static void printMessageToConsole(String customMessage) {
		System.out.println(customMessage);
	}

	/**
	 * Prints the gap.
	 */
	public static void printGap() {
		System.out.println("");
	}

	/**
	 * Ask integer input.
	 *
	 * @param message the message
	 * @return the optional
	 */
	public Optional<Integer> askIntegerInput(String message) {
		Optional<Integer> optionalInput = Optional.empty();

		optionalInput = Optional.ofNullable(ConsoleController.readInteger(message, "Please Enter valid number"));

		return optionalInput;

	}


	/**
	 * Ask string input.
	 *
	 * @return the optional
	 */
	public Optional<String> askStringInput() {
		Optional<String> optionalInput = Optional.empty();

		try {
			optionalInput = Optional.ofNullable((String) scanner.nextLine());
		} catch (Exception e) {
			throw new GameException("Please enter valid input.");
		}
		return optionalInput;

	}

	/**
	 * Gets the string user input.
	 *
	 * @param inputMessage the input message
	 * @return the string user input
	 */
	
	public Optional<String> getStringUserInput(String inputMessage) {
		printMessageToConsole(inputMessage);
		return askStringInput();

	}

	/**
	 * Gets the integer user input.
	 *
	 * @param inputMessage the input message
	 * @return the integer user input
	 */
	public Optional<Integer> getIntegerUserInput(String inputMessage) {
		
		return askIntegerInput(inputMessage);

	}



	

	private static final String DEFAULT_PROMPT = "Enter input: ";
	

	private static final String DEFAULT_RETRY = "Invalid Input. Try again.";

	/**
	 * Read yes no.
	 *
	 * @param prompt the prompt
	 * @return true, if successful
	 */
	public static final boolean readYesNo(String prompt) {
		String input = getYesOrNoTillSuccess(prompt);
		if (input.equalsIgnoreCase("yes")) {
			return true;
		}
		return false;
	}

	/**
	 * Gets the yes or no till success.
	 *
	 * @param prompt the prompt
	 * @return the yes or no till success
	 */
	private static String getYesOrNoTillSuccess(String prompt) {
		String response = readLine(prompt).toLowerCase().trim();

		if (!response.equalsIgnoreCase("yes") && !response.equalsIgnoreCase("no")) {
			// System.err.println("Please enter valid input yes or no ..");
			getYesOrNoTillSuccess(prompt);
		}

		return response;
	}

	/**
	 * Read yes no.
	 *
	 * @return true, if successful
	 */
	public static final boolean readYesNo() {
		return readYesNo(DEFAULT_PROMPT);
	}

	/**
	 * Read boolean.
	 *
	 * @param prompt the prompt
	 * @return true, if successful
	 */
	public static final boolean readBoolean(String prompt) {
		return readYesNo(prompt);
	}

	/**
	 * Read boolean.
	 *
	 * @return true, if successful
	 */
	public static final boolean readBoolean() {
		return readYesNo(DEFAULT_PROMPT);
	}

	/**
	 * Read integer.
	 *
	 * @param prompt the prompt
	 * @param error the error
	 * @param min the min
	 * @param max the max
	 * @return the int
	 */
	public static final int readInteger(String prompt, String error, int min, int max) {
		if (min >= max) {
			return 0; // Should not happen, but can if the client programmer is not paying attention
		}

		try {
			int i = Integer.valueOf((readLine(prompt)));
			if ((i < min) || (i > max)) {
				System.out.println(error);
				return readInteger(prompt, error, min, max);
			}
			return i;
		} catch (NumberFormatException e) {
			System.out.println(error);
			return readInteger(prompt, error, min, max);
		}
	}





	/**
	 * Read integer.
	 *
	 * @param prompt the prompt
	 * @param error the error
	 * @return the int
	 */
	public static final int readInteger(String prompt, String error) {
		try {
			return Integer.valueOf((readLine(prompt)));
		} catch (NumberFormatException e) {
			logger.error("Wrong input by user! ");
			// System.out.println("\n" + error);
			return readInteger(prompt, error);

		}
	}





	/**
	 * Read string.
	 *
	 * @param prompt the prompt
	 * @param error the error
	 * @param minLength the min length
	 * @return the string
	 */
	public static final String readString(String prompt, String error, int minLength) {
		String input = readLine(prompt);
		if (input.length() < minLength) {
			System.out.println("\n" + error);
			return readString(prompt, error, minLength);
		}

		return input;
	}

	/**
	 * Read string.
	 *
	 * @param prompt the prompt
	 * @param error the error
	 * @return the string
	 */
	public static final String readString(String prompt, String error) {
		String input = readLine(prompt);
		if ((input.length() == 0) || (input == null) || (input.equals("\n"))) {
			System.out.println("\n" + error);
		}

		return input;
	}

	/**
	 * Read string.
	 *
	 * @param prompt the prompt
	 * @return the string
	 */
	public static final String readString(String prompt) {
		return readString(prompt, DEFAULT_RETRY);
	}


	/**
	 * Read line.
	 *
	 * @param prompt the prompt
	 * @return the string
	 */
	private static final String readLine(String prompt) {

		System.out.print(prompt + " :");

		// return new Scanner
		return scanner.next();
	
	}

}
