package org.game.fantasy.command.handlers;

import static org.mockito.Matchers.anyString;

import org.game.fantasy.command.params.QuitCommandParams;
import org.game.fantasy.controls.ConsoleController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest({ QuitCommandHandler.class, ConsoleController.class, System.class })
public class QuitCommandHandlerTest {

	// @Mock
	private QuitCommandHandler quitCommand = new QuitCommandHandler();

	@Before
	public void setUp() {
		PowerMockito.mockStatic(ConsoleController.class);
		PowerMockito.when(ConsoleController.readBoolean(anyString())).thenReturn(false);

	}

	@Test
	public void testExecute() throws Exception {

		QuitCommandParams params = new QuitCommandParams("Test");

		quitCommand.execute(params);

	}

}
