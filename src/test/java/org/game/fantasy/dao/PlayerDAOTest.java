package org.game.fantasy.dao;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.IOException;

import org.game.fantasy.model.Player;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class PlayerDAOTest {

	PlayerDAO subject;

	@Mock
	ObjectIOOperations objectIOOperations;

	Player dummy;

	@Before
	public void setUp() throws Exception {
		// Arrange
		MockitoAnnotations.initMocks(this);
		objectIOOperations = Mockito.mock(ObjectIOOperations.class);

		subject = new PlayerDAO();
		subject.setObjectIO(objectIOOperations);

	}

	@Test
	public void testGetDetails() throws IOException, ClassNotFoundException {
		// Arrange
		when(objectIOOperations.deserialize(any(String.class))).thenReturn(any(Player.class));

		// Act
		subject.getDetails("jared");

		// Assert
		verify(objectIOOperations).deserialize(any(String.class));
		verify(objectIOOperations, Mockito.times(1)).deserialize(any(String.class));

	}
	
	

	@Test
	public void testSave() throws IOException {

		// Arrange
		dummy = new Player();
		dummy.setCharacter(0);
		dummy.setCharacterName("lorem");

		doNothing().when(objectIOOperations).serialize(anyObject(), anyString());

		// Act
		subject.save(dummy);

		// Assert
		verify(objectIOOperations).serialize(anyObject(), anyString());

	}

}
