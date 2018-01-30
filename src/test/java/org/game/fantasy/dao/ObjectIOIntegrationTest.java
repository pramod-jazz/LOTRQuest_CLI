package org.game.fantasy.dao;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.powermock.core.classloader.annotations.PrepareForTest;

import junit.framework.Assert;

@RunWith(MockitoJUnitRunner.class)
@PrepareForTest({ ObjectIOOperations.class })
public class ObjectIOIntegrationTest {

	org.game.fantasy.model.Character dummy;
	org.game.fantasy.model.Character dummy2;
	List<org.game.fantasy.model.Character> dummyCharacters;

	ObjectIOOperations objectIO = new ObjectIOOperations();

	@Test
	public void testSaveObject() {

		// Arrange
		dummy = Mockito.mock(org.game.fantasy.model.Character.class, Mockito.withSettings().serializable());

		try {

			// Act
			objectIO.serialize(dummy, "dummy.ser");

			org.game.fantasy.model.Character result = (org.game.fantasy.model.Character) objectIO
					.deserialize("dummy.ser");

			// Assert
			Assert.assertEquals(result.getCharacterName(), dummy.getCharacterName());

			// Cleanup
			new File("dummy.ser").delete();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	@Test
	public void saveListObject() {

		// Arrange
		dummyCharacters = new ArrayList<>();
		dummy = Mockito.mock(org.game.fantasy.model.Character.class, Mockito.withSettings().serializable());
		dummy.setCharacterName("lorem");
		dummy2 = Mockito.mock(org.game.fantasy.model.Character.class, Mockito.withSettings().serializable());
		dummy2.setCharacterName("ipsum");

		try {
			// Act
			objectIO.serialize(dummyCharacters, "dummyCharacters.ser");

			List<org.game.fantasy.model.Character> results = (List<org.game.fantasy.model.Character>) objectIO
					.deserialize("dummyCharacters.ser");

			// Assert
			Assert.assertEquals(results.size(), dummyCharacters.size());

			// Cleanup
			new File("dummyCharacters.ser").delete();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

}
