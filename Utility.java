/**
 * Helper methods
 */
public class Utility {
    /**
     * No instantiating, use static methods
     */
    private Utility() {}

    /**
     * Verifies item is not null or blank and throws appropriate exception message
     * @param context  context for the item, used as a label, usually the variable name
     * @param item  the item to be checked
     */
    public static void verifyNotNullOrBlank(String context, String item) {
        if (item == null) {
            throw new IllegalArgumentException(context + " cannot be null");
        }
        if (item.isBlank()) {
            throw new IllegalArgumentException(context + " cannot be blank");
        }
    }

    /**
     * Verifies integer is in range min through max (inclusive) and throws appropriate exception message
     * @param  min      minimum value permitted (inclusive)
     * @param  max      maximum value permitted (inclusive)
     * @param  context  context for the item, used as a label, usually the variable name
     * @param  item     the item to be checked
     */
    public static void verifyInRange(int min, int max, String context, int item) {
        if (item < min) {
            throw new IllegalArgumentException(context + " cannot be less than " + min);
        }
        if (item > max) {
            throw new IllegalArgumentException(context + " cannot be greater than " + max);
        }
    }

    /**
     * Verifies double is in range min through max (inclusive) and throws appropriate exception message
     * @param  min      minimum value permitted (inclusive)
     * @param  max      maximum value permitted (inclusive)
     * @param  context  context for the item, used as a label, usually the variable name
     * @param  item     the item to be checked
     */
    public static void verifyInRange(double min, double max, String context, double item) {
        if (item - min < 0.000000) {
            throw new IllegalArgumentException(context + " cannot be less than " + min);
        }
        if (item - max > 0.000000) {
            throw new IllegalArgumentException(context + " cannot be greater than " + max);
        }
    }

}
