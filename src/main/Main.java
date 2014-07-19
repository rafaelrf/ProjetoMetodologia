
package main;

import core.avltree.AVLTreeImpl;
import core.avltree.Estrutura;
import core.bst.BSTImpl;
import core.linked_list.SingleLinkedList;
import utils.CalculaMemoUtilizada;
import utils.CalculaTempo;
import utils.DadosAnalisados;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

// TODO: Auto-generated Javadoc
/**
 * The Class Main2 is used to simply run without passing args on terminal.
 */
public class Main {

    /** The Constant LIST. */
    private static final String LIST = "list";

    /** The Constant AVLTREE. */
    private static final String AVLTREE = "avltree";

    /** The Constant BSTTREE. */
    private static final String BSTTREE = "bstree";

    /** The estrutra. */
    private static Estrutura estrutura;

    /** Memory Usage Checker . */
    private static CalculaMemoUtilizada memoriaUtilizada;

    /** The load total time. */
    private static long loadTotalTime;

    /** The query total time. */
    private static long queryTotalTime;

    /** The write dados. */
    private static DadosAnalisados writeDados;

    /**
     * Exec query.
     * 
     * @param path the path
     */
    public static void execQuery(String path) {
        BufferedReader br = null;
        CalculaTempo cTime = new CalculaTempo();

        try {

            String word;

            br = new BufferedReader(new FileReader(path));

            boolean result = false;
            // reservar memoria agora para isto não atrapalhar o tempo de
            // consulta

            while ((word = br.readLine()) != null) {
                cTime.startTime();
                result = estrutura.search(word.toLowerCase());
                if (result) {
                    System.out.println(word + " : S");
                } else {
                    System.out.println(word + " : N");
                }
                // ManipulateTextFile.addCSVQueryTime(algorithm, stopTime);
                writeDados.writeConsulta(word, cTime.stopTime());

            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

    }

    /**
     * Load data.
     * 
     * @param path the path
     */
    public static void loadData(String path) {
        BufferedReader br = null;
        CalculaTempo cTime = new CalculaTempo();

        try {

            String word;

            br = new BufferedReader(new FileReader(path));

            cTime.startTime();

            memoriaUtilizada.checkMemoInicial();

            while ((word = br.readLine()) != null) {
                cTime.startTime();
                estrutura.insert(word.toLowerCase());
            }

            memoriaUtilizada.checkMemoFInal();

            // ManipulateTextFile.addCSVLoadTime(algorithm, cTime.stopTime());
            writeDados.writeMemoria(word, cTime.stopTime());

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

    }

    /**
     * The main method.
     * 
     * @param args the arguments
     */
    public static void main(String[] args) {
        // instanciar o medidor de tempo e de memoria antes do metodo load, caso
        // contrario o tempo de medição será interferido pelo tempo de
        // instanciação das classes
        memoriaUtilizada = new CalculaMemoUtilizada();

        // Path para o arquivo contendo as palavras que serao adicionadas.
        String dataPath;

        // Path para o arquivo contendo as palavras que serao consultadas.
        String queryPath;

        // FLAG para definir qual estrutura será usada: LIST, BSTTREE ou
        // AVLTREE
        String StructureType;

        if (args.length < 3) {
            System.err.print("Missing args\n");
            return;
        } else {
            StructureType = args[0];
            dataPath = args[1];
            queryPath = args[2];
        }

        if (StructureType.equals(LIST)) {
            estrutura = new SingleLinkedList<String>();
        } else if (StructureType.equals(AVLTREE)) {
            estrutura = new AVLTreeImpl<String, String>();
        } else if (StructureType.equals(BSTTREE)) {
            estrutura = new BSTImpl<String, String>();
        } else {
            System.err
                    .println("Estrutura invalida, escolha entre: "
                            + LIST + ", " + BSTTREE + " ou " + AVLTREE);
            return;
        }

        writeDados = new DadosAnalisados(StructureType);

        CalculaTempo cTime = new CalculaTempo();

        cTime.startTime();
        loadData(dataPath);
        loadTotalTime = cTime.getStartTime();

        cTime.startTime();
        execQuery(queryPath);
        queryTotalTime = cTime.getStartTime();

        System.out.println("tempo_de_carga : " + String.valueOf(loadTotalTime));
        System.out.println("tempo_da_consulta : "
                + String.valueOf(queryTotalTime));

        double memoryUsage = memoriaUtilizada.getMemoUtilizada();
        // ManipulateTextFile.addCSVMemoryUsage(algorithm, memoryUsage);
        writeDados.writeMemoria(StructureType, (long) memoryUsage);

        System.out.println("consumo_de_memoria : "
                + String.valueOf(memoryUsage));
    }
}
