package org.game.fantasy.dao;

import static org.mockito.Matchers.anyObject;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;

import java.io.IOException;
import java.util.Optional;

import org.game.fantasy.model.GameDetails;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import junit.framework.Assert;

@RunWith(MockitoJUnitRunner.class)
public class GameDetailsDAOTest {

	private GameDetailsDAO subject;

	@Mock
	private ObjectIOOperations objectIOOperations;

	private GameDetails details;

	@Before
	public void setUp() throws Exception {
		// Arrange
		details = new GameDetails(0, "lorem", 0);
		subject = new GameDetailsDAO();
		subject.setObjectIO(objectIOOperations);
	}

	@Test
	public void testGetDetails() throws ClassNotFoundException, IOException {

		Mockito.when(objectIOOperations.deserialize(anyString())).thenReturn(details);
		// Act
		Optional<GameDetails> returnedDetails = subject.getDetails();
		// Assert
		Mockito.verify(objectIOOperations).deserialize(anyString());
		Assert.assertEquals(details.getPlayerId(), returnedDetails.get().getPlayerId());

	}

	@Test
	public void testSave() throws IOException {
		doNothing().when(objectIOOperations).serialize(anyObject(), anyString());

		// Act
		subject.save(details);

		// Assert
		verify(objectIOOperations).serialize(anyObject(), anyString());
		verify(objectIOOperations, Mockito.atLeast(1)).serialize(anyObject(), anyString());

	}

}
