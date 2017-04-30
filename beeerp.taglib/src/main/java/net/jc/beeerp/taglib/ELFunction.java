package net.jc.beeerp.taglib;

import java.util.Arrays;
import java.util.List;

/**
 * The ELFunction class is a container of custom EL function used in jsp.
 */
public class ELFunction
{
	private ELFunction() {
		throw new IllegalAccessError("Utility class");
	};

	/**
	 * @see List#contains
	 * @param array The array to check values
	 * @param item The item to check
	 * @return True if the item is in the array
	 */
	public static boolean contains(Object[] array, Object item)
	{
		List<Object> list = Arrays.asList(array);
		return list.contains(item);
	}
}
