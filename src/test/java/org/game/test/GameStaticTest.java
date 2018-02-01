package org.game.test;

import org.game.fantasy.Game;
import org.game.fantasy.GameMetadata;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest(GameMetadata.class)
public class GameStaticTest {

	private Game game;

	private GameMetadata gameMetadata;

	@Before
	public void setUp() {
		// Arrange
		game = new Game();

		PowerMockito.mockStatic(GameMetadata.class);

	}

	@Test
	public void testCustomCharacterSetup() throws Exception {

		String[] args = null;

		// Arrange

		PowerMockito.doNothing().when(GameMetadata.class, "addCustomCharacter", "test");

		// Act
		Game.main(args);

		// Assert

		// verify(GameMetadata.class, "addCustomCharacter", captor.capture());
		// PowerMockito.verifyStatic(GameMetadata.addCustomCharacter(anyString()));
		PowerMockito.verifyStatic(GameMetadata.class);

	}

}
