package storage;

import entities.Points;

public interface PointStorage {

	void savePoints(Points points);
	
	Points readPoints();
}
