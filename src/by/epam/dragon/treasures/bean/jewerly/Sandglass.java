package by.epam.dragon.treasures.bean.jewerly;

import by.epam.dragon.treasures.bean.Jewerly;

public class Sandglass extends Jewerly {
	private static final long serialVersionUID = 1L;

	private String sandType;

	public Sandglass() {
		super();
	}
	
	public String getSandType() {
		return sandType;
	}

	public void setSandType(String sandType) {
		this.sandType = sandType;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((sandType == null) ? 0 : sandType.hashCode());
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
		Sandglass other = (Sandglass) obj;
		if (sandType == null) {
			if (other.sandType != null)
				return false;
		} else if (!sandType.equals(other.sandType))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return super.toString() + " Sandglass: [sandType=" + sandType + "]";
	}

}
