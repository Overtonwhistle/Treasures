package by.epam.dragon.treasures.bean;

public abstract class Jewerly extends Treasure {
	private static final long serialVersionUID = 1L;
	
	private String material;
	private double weight;

	public Jewerly() {
		super();
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public Double getWeight() {
		return weight;
	}

	public void setWeight(double weigth) {
		this.weight = weigth;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((material == null) ? 0 : material.hashCode());
		long temp;
		temp = Double.doubleToLongBits(weight);
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
		Jewerly other = (Jewerly) obj;
		if (material == null) {
			if (other.material != null)
				return false;
		} else if (!material.equals(other.material))
			return false;
		if (Double.doubleToLongBits(weight) != Double.doubleToLongBits(other.weight))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return super.toString() + " Jewerly: [material=" + material + ", weight=" + weight + "]";
	}

}
