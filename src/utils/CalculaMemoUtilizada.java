
package utils;

// TODO: Auto-generated Javadoc
/**
 * The Class CalculaMemoUtilizada.
 */
public class CalculaMemoUtilizada {

    /** The initial free memory. */
    private double memoFreeInicial;
    
    /** The final free memory. */
    private double memoFreeFinal;
    
    /** The runtime. */
    private final Runtime runtime;

    /**
     * Instantiates a new calcula memo utilizada.
     */
    public CalculaMemoUtilizada() {
        runtime = Runtime.getRuntime();
    }

    /**
     * Method to check memory at the moment zero.
     */
    public void checkMemoInicial() {
        memoFreeInicial = runtime.freeMemory();
    }

    /**
     * Check memo f inal.
     */
    public void checkMemoFInal() {
        memoFreeFinal = runtime.freeMemory();
    }

    /**
     * Gets the memo utilizada.
     *
     * @return the memo utilizada
     */
    public double getMemoUtilizada() {
        return memoFreeInicial - memoFreeFinal;
    }

}
