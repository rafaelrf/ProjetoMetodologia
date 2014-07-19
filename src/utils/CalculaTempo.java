
package utils;

// TODO: Auto-generated Javadoc
/**
 * The Class CalculaTempo.
 */
public class CalculaTempo {

    /** The millis. */
    private long millis;

    /**
     * Start time.
     */
    public void startTime() {
        millis = System.nanoTime();
    }

    /**
     * Stop time.
     * 
     * @return the long
     */
    public long stopTime() {
        return System.nanoTime() - millis;
    }

    /**
     * Gets the start time.
     *
     * @return the start time
     */
    public long getStartTime() {
        return millis;
    }
}
