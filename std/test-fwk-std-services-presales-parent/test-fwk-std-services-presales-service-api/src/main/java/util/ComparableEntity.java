package util;

/**
 * The Interface ComparableEntity.
 *
 * @author THouissa
 */
public interface ComparableEntity<T> extends Entity{

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	int hashCode();

	/**
	 * Equals.
	 *
	 * @param obj the obj
	 * @return true, if successful
	 */
	boolean equals(Object obj);
}
