package entities;

import java.io.Serializable;

public class Points implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int points = 0;
	
	public void setPoints(int points) {
		this.points = points;
	}
	
	public int getPoints() {
		return points;
	}
	
	public void add(int add) {
		points += add;
	}
	
	public String toString() {
		return new StringBuffer("Max: ").append(points).toString();
	}

}
