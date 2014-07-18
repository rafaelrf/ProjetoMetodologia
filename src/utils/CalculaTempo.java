
package utils;

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

    public long getStartTime() {
        return millis;
    }
}
