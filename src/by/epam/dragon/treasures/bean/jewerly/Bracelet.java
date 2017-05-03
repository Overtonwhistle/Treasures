package by.epam.dragon.treasures.bean.jewerly;

import by.epam.dragon.treasures.bean.Jewerly;

public class Bracelet extends Jewerly {
	private static final long serialVersionUID = 1L; 
	
	private double girth;
	private String style;
	private String hardness;

	public Bracelet() {
		super();
	}
	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}

	public double getGirth() {
		return girth;
	}

	public void setGirth(double girth) {
		this.girth = girth;
	}

	public String getHardness() {
		return hardness;
	}

	public void setHardness(String hardness) {
		this.hardness = hardness;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		long temp;
		temp = Double.doubleToLongBits(girth);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((hardness == null) ? 0 : hardness.hashCode());
		result = prime * result + ((style == null) ? 0 : style.hashCode());
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
		Bracelet other = (Bracelet) obj;
		if (Double.doubleToLongBits(girth) != Double.doubleToLongBits(other.girth))
			return false;
		if (hardness == null) {
			if (other.hardness != null)
				return false;
		} else if (!hardness.equals(other.hardness))
			return false;
		if (style == null) {
			if (other.style != null)
				return false;
		} else if (!style.equals(other.style))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return super.toString() + " Bracelet: [style=" + style + ", girth=" + girth + ", hardness=" + hardness + "]";
	}
}
