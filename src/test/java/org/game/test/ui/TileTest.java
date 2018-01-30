package org.game.test.ui;

import org.game.fantasy.ui.ConsolePrinter;
import org.game.fantasy.ui.Header;
import org.game.fantasy.ui.MiddleTile;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class TileTest {

	@Mock
	Header header;
	@Mock
	MiddleTile middleTile;

	@Test
	public void testHeaderPrinting() {

		// Accept
		ConsolePrinter printer = new ConsolePrinter();
		doNothing().when(printer).printToConsole(Mockito.anyString(),Mockito.anyBoolean());

		// Act
		header.renderUI(false);

		// Assert
		Mockito.verify(printer, Mockito.times(1));

	}

	@Test
	public void testMiddleTilePrinting() {

		// Accept
		ConsolePrinter printer = new ConsolePrinter();
		doNothing().when(printer).printToConsole(Mockito.anyString(),Mockito.anyBoolean());

		// Act
		middleTile.renderUI(false);

		// Assert
		Mockito.verify(printer, Mockito.times(1));

	}

}
