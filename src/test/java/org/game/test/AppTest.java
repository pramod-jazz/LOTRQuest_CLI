package org.game.test;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;

import org.game.fantasy.ui.DisplayUnit;
import org.game.fantasy.ui.Header;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * Unit test for simple App.
 */
@RunWith(MockitoJUnitRunner.class)
public class AppTest {

	@Mock
	DisplayUnit header;

	@Test
	public void testShouldPrintHeader() {

		// Arrange
		String[] args = null;
		header = new Header();
		doNothing().when(header).renderUI();
		;

		// Act
		Game.main(args);

		// Assert
		verify(header).renderUI();

	}

}
