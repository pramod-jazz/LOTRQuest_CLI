package org.game.fantasy.dao;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ObjectIOOperations {
	
	public void serialize(Object object, String name) throws IOException {

		ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(name));

		objectOutputStream.writeObject(object);
		objectOutputStream.flush();
		objectOutputStream.close();

	}
	
	
	public Object deserialize(String filename) throws IOException, ClassNotFoundException {


		Object object = null;
		try {
			object = readFromFile(filename);
		} catch (IOException | ClassNotFoundException e) {
			object = readFromClasspathResource(filename);
		}

		return object;
	}

	private Object readFromFile(String filename) throws IOException, ClassNotFoundException {
		try (ObjectInputStream stream = new ObjectInputStream(new FileInputStream(filename))) {
			return stream.readObject();
		}
	}

	private Object readFromClasspathResource(String filename) throws IOException, ClassNotFoundException {
		try (ObjectInputStream stream = new ObjectInputStream(ObjectIOOperations.class.getClassLoader().getResourceAsStream(filename))) {
			return stream.readObject();
		}
	}

}
