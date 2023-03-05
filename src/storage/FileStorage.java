package storage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import entities.Points;

public class FileStorage implements PointStorage {

	@Override
	public Points readPoints() {
		Points points = new Points();
		ObjectInputStream oi = null;
		try {
			FileInputStream fi = new FileInputStream(new File("points.txt"));
			oi = new ObjectInputStream(fi);
			points = (Points) oi.readObject();
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		} catch (IOException e) {
			System.out.println("Error initializing stream");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				oi.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return points;
	}

	@Override
	public void savePoints(Points points) {
		ObjectOutputStream oo = null;
		try {
			FileOutputStream fo = new FileOutputStream(new File("points.txt"));
			oo = new ObjectOutputStream(fo);
			oo.writeObject(points);
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		} catch (IOException e) {
			System.out.println("Error initializing stream");
		} finally {
			try {
				oo.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
