package by.epam.dragon.treasures.bean.jewerly;

import by.epam.dragon.treasures.bean.Jewerly;

public class Jewel extends Jewerly {
	private static final long serialVersionUID = 1L;
	
	private String type;
	private Double diameter;

	public Jewel() {
		super();
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Double getDiameter() {
		return diameter;
	}

	public void setDiameter(Double diameter) {
		this.diameter = diameter;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((diameter == null) ? 0 : diameter.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		Jewel other = (Jewel) obj;
		if (diameter == null) {
			if (other.diameter != null)
				return false;
		} else if (!diameter.equals(other.diameter))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return super.toString()+ " Jewel: [type=" + type + ", diameter=" + diameter + "]";
	}

}
