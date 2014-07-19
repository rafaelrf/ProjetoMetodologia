
package utils;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class DadosAnalisados {

    /** The file name query. */
    private static String FILE_NAME_QUERY;

    /** The file name insert. */
    private static String FILE_NAME_INSERT;

    private static String FILE_NAME_MEMORY;

    PrintWriter writerQuery;

    PrintWriter writerInsert;

    PrintWriter writerMemory;

    /**
     * Instantiates a new write analysis.
     * 
     * @param algorithm the algorithm
     */
    public DadosAnalisados(String algorithm) {
        FILE_NAME_QUERY = "query_" + algorithm + ".csv";
        FILE_NAME_INSERT = "insert_" + algorithm + ".csv";
        FILE_NAME_MEMORY = "memory_" + algorithm + ".csv";

        try {
            writerQuery = new PrintWriter(FILE_NAME_QUERY, "UTF-8");
            writerInsert = new PrintWriter(FILE_NAME_INSERT, "UTF-8");
            writerMemory = new PrintWriter(FILE_NAME_MEMORY, "UTF-8");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

    }

    /**
     * Write time cost for iserting a word.
     * 
     * @param word the word
     * @param time the time
     */
    public void writeInsert(String word, long time) {
        writerInsert.println(word + ", " + String.valueOf(time));
    }

    /**
     * Write query time cost for a specific word.
     * 
     * @param word the word
     * @param time the time
     */
    public void writeConsulta(String word, long time) {
        writerQuery.println(word + ", " + String.valueOf(time));
    }

    public void writeMemoria(String word, long time) {
        writerMemory.println(word + ", " + String.valueOf(time));
    }

    public void close() {
        writerInsert.close();
        writerQuery.close();
    }

}
