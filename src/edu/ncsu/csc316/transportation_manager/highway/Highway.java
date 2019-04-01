package edu.ncsu.csc316.transportation_manager.highway;

/**
 * HighWay class includes information of city1, city2, cost of building highway,
 * and asphalt amount needed to build the highway
 * 
 * @author Chee Ng (cwng)
 *
 */
public class Highway implements Comparable<Highway> {
	/** city1 in integer **/
	private int city1;
	/** city1 in integer **/
	private int city2;
	/** cost in double **/
	private double cost;
	/** asphalt in double **/
	private double asphalt;

	/**
	 * Constructs a Highway with the given information
	 * 
	 * @param city1
	 *            city1 of the highway
	 * @param city2
	 *            city2 of the highway
	 * @param cost
	 *            cost of building the highway
	 * @param asphalt
	 *            amount (in miles) of asphalt needed to build the highway
	 */
	public Highway(int city1, int city2, double cost, double asphalt) {
		this.city1 = city1;
		this.city2 = city2;
		this.cost = cost;
		this.asphalt = asphalt;
	}

	/**
	 * Returns a string representation of the Highway in the format:
	 * 
	 * Highway[city1=X, city2=X, cost=X.X, asphalt=X.X]
	 * 
	 * @return the string representation of the highway
	 */
	@Override
	public String toString() {
		return new StringBuilder().append("Highway[city1=").append(getCity1()).append(", city2=").append(getCity2())
				.append(", cost=").append(getCost()).append(", asphalt=").append(getAsphalt()).append("]").toString();
	}

	/**
	 * Get the city one
	 * 
	 * @return the city1
	 */
	public int getCity1() {
		return city1;
	}

	/**
	 * Get the city two
	 * 
	 * @return the city2
	 */
	public int getCity2() {
		return city2;
	}

	/**
	 * Get the cost
	 * 
	 * @return the cost of building highway
	 */
	public double getCost() {
		return cost;
	}

	/**
	 * Get the asphalt
	 * 
	 * @return the amount asphalt of building highway
	 */
	public double getAsphalt() {
		return asphalt;
	}

	/**
	 * Custom compared to gives sorted order by city1, city2, then cost, then
	 * asphalt
	 * 
	 * @param o
	 *            is object to be compared
	 * @return the compared higway
	 */
	@Override
	public int compareTo(Highway o) {
		if (this.city1 == o.city1) {
			if (this.city2 == o.city2) {
				if (this.cost == o.cost) {
					return (int) (this.asphalt - o.asphalt);
				}
				return (int) (this.cost - o.cost);
			}
			return this.city2 - o.city2;
		}
		return this.city1 - o.city1;
	}

}
