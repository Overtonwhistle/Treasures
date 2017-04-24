package by.epam.dragon.treasures.bean.jewerly;

import by.epam.dragon.treasures.bean.Jewerly;

public class Ring extends Jewerly {

	private String style;
	private boolean hasPreciousStone;

	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}

	public boolean isHasPreciousStone() {
		return hasPreciousStone;
	}

	public void setHasPreciousStone(boolean hasPreciousStone) {
		this.hasPreciousStone = hasPreciousStone;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + (hasPreciousStone ? 1231 : 1237);
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
		Ring other = (Ring) obj;
		if (hasPreciousStone != other.hasPreciousStone)
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
		return super.toString()+" Ring: [style=" + style + ", hasPreciousStone=" + hasPreciousStone + "]";
	}
}
