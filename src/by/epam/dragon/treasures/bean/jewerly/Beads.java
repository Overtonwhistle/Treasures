package by.epam.dragon.treasures.bean.jewerly;

import by.epam.dragon.treasures.bean.Jewerly;

public class Beads extends Jewerly {

	private double length;
	private double thickness;

	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = length;
	}

	public double getThickness() {
		return thickness;
	}

	public void setThickness(double thickness) {
		this.thickness = thickness;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		long temp;
		temp = Double.doubleToLongBits(length);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(thickness);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Beads other = (Beads) obj;
		if (Double.doubleToLongBits(length) != Double.doubleToLongBits(other.length))
			return false;
		if (Double.doubleToLongBits(thickness) != Double.doubleToLongBits(other.thickness))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return super.toString()+" Beads: [length=" + length + ", thickness=" + thickness + "]";
	}
}
