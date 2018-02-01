package org.game.fantasy.dao;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


/**
 * The Class ObjectIOOperations.
 */
public class ObjectIOOperations {

	/**
	 * Serialize.
	 *
	 * @param object the object
	 * @param name the name
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public void serialize(Object object, String name) throws IOException {

		ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(name));

		objectOutputStream.writeObject(object);
		objectOutputStream.flush();
		objectOutputStream.close();

	}

	/**
	 * Deserialize.
	 *
	 * @param filename the filename
	 * @return the object
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws ClassNotFoundException the class not found exception
	 */
	public Object deserialize(String filename) throws IOException, ClassNotFoundException {

		Object object = null;
		try {
			object = readFromFile(filename);
		} catch (IOException | ClassNotFoundException e) {
			object = readFromClasspathResource(filename);
		}

		return object;
	}

	/**
	 * Read from file.
	 *
	 * @param filename the filename
	 * @return the object
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws ClassNotFoundException the class not found exception
	 */
	private Object readFromFile(String filename) throws IOException, ClassNotFoundException {
		try (ObjectInputStream stream = new ObjectInputStream(new FileInputStream(filename))) {
			return stream.readObject();
		}
	}

	/**
	 * Read from classpath resource.
	 *
	 * @param filename the filename
	 * @return the object
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws ClassNotFoundException the class not found exception
	 */
	private Object readFromClasspathResource(String filename) throws IOException, ClassNotFoundException {
		try (ObjectInputStream stream = new ObjectInputStream(
				ObjectIOOperations.class.getClassLoader().getResourceAsStream(filename))) {
			return stream.readObject();
		}
	}

}
