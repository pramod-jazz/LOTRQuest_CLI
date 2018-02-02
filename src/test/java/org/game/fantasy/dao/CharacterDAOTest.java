package org.game.fantasy.dao;

import static org.mockito.Matchers.anyCollectionOf;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.game.fantasy.model.GameCharacter;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import junit.framework.Assert;

@RunWith(MockitoJUnitRunner.class)
public class CharacterDAOTest {

	CharacterDAO subject;

	@Mock
	ObjectIOOperations objectIOOperations;

	List<GameCharacter> characters = new ArrayList<>();

	@Before
	public void setUp() throws Exception {
		subject = new CharacterDAO();
		subject.setObjectIO(objectIOOperations);

		characters.add(new GameCharacter(1, "lorem", "ipsum"));
		characters.add(new GameCharacter(1, "hassle", "castle"));
	}

	@Test
	public void testFindAll() throws ClassNotFoundException, IOException {

		// Arrange
		Mockito.when(objectIOOperations.deserialize(anyString())).thenReturn(characters);
		

		// Act
		List<GameCharacter> returnedCharacters = subject.findAll();
		
		// Assert
		verify(objectIOOperations, times(1)).deserialize(anyString());
		Assert.assertEquals(characters.size(), returnedCharacters.size());
		
	}

	@Test
	public void testSaveAll() throws IOException {
		// Arrange
		doNothing().when(objectIOOperations).serialize(anyCollectionOf(GameCharacter.class), anyString());

		// Act
		subject.saveAll(characters);

		// Assert
		verify(objectIOOperations, times(1)).serialize(anyCollectionOf(GameCharacter.class), anyString());

	}

}
