package org.game.fantasy.dao;




import static org.mockito.Matchers.anyObject;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.game.fantasy.model.Level;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class LevelDAOTest {

	@Mock
	private LevelDAO subject;

	private Level level;
	
	
	private List<Level> levels;
	@Mock
    private	ObjectIOOperations objectIO = new ObjectIOOperations();
	
	@Before
	public void setUp() throws Exception {

		levels = new ArrayList<>();
		// Arrange
		level = new Level();
		level.setId(0);
		level.setLavelName("Mordor");
		levels.add(level);
		
		
		
		
	}

	@Test
	public void testShouldSaveLavel() throws IOException {

		// Arrange
		doNothing().when(objectIO).serialize(anyObject(), anyString());
		
		//Act
		subject.saveAll(levels);
		
		//Assert
		verify(objectIO,times(1)).serialize(levels, "test");
		
		
		
	}	
}
