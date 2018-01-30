package org.game.fantasy.ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsolePrinter {

	public void printToConsole(String filePath,boolean isSameLine) {
		try (BufferedReader reader = new BufferedReader(
				new InputStreamReader(Header.class.getClassLoader().getResourceAsStream(filePath)))) {
			reader.lines().forEach(isSameLine ? System.out::println : System.out::println );
		} catch (IOException e) {
			System.out.println(e);
		}
	}

	public void printMessageToConsole(String customMessage) {
		System.out.println(customMessage);
	}

}
