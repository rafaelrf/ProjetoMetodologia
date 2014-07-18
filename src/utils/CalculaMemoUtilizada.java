
package utils;

public class CalculaMemoUtilizada {

    private double initialFreeMemory;
    private double finalFreeMemory;
    private final Runtime runtime;

    public CalculaMemoUtilizada() {
        runtime = Runtime.getRuntime();
    }

    /**
     * Method to check memory at the moment zero.
     */
    public void checkMemoInicial() {
        initialFreeMemory = runtime.freeMemory();
    }

    public void checkMemoFInal() {
        finalFreeMemory = runtime.freeMemory();
    }

    public double getMemoUtilizada() {
        return initialFreeMemory - finalFreeMemory;
    }

}
