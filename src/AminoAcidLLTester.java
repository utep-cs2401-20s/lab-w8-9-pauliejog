import static org.junit.jupiter.api.Assertions.*;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;

public class AminoAcidLLTester {
    /*
     * AminoAcidLL constructor:
     */
    @Test
    public void testConstructor() {
        AminoAcidLL aA = new AminoAcidLL("GCU");
        String[] codonsList = {"GCG","GCA","GCC","GCU"};
        int[] counts = {0,0,0,1};
        assertEquals('A',aA.aminoAcid);
        assertArrayEquals(codonsList,aA.codons);
        assertArrayEquals(counts,aA.counts);
    }

    /*
     * aminoAcidList() method:
     */
    @Test
    public void testAAL() {
        String sequence = "CCGUUGGCACUGUUG";
        AminoAcidLL list = AminoAcidLL.createFromRNASequence(sequence);
        //char[] exp = {'P','L','A'};
        char[] result = list.aminoAcidList();
        //assertArrayEquals(exp,result);
    }
    /*
     * aminoAcidCompare() method:
     */
    @Test
    public void testAAC() {
        String sequence = "CCGUUGGCACUGUUG";
        String sequence2 = "CCU";
        AminoAcidLL list = AminoAcidLL.createFromRNASequence(sequence);
        AminoAcidLL list2 = AminoAcidLL.createFromRNASequence(sequence2);
        System.out.println(list.aminoAcidCompare(list2));
    }
    /*
     * isSorted() method:
     */
    @Test
    public void testIsSorted() {
        String sequence = "AGGAAGAUGCCC";
        AminoAcidLL list = AminoAcidLL.createFromRNASequence(sequence);
        AminoAcidLL temp = list.next;
        while (temp != null) {
            System.out.print(temp.aminoAcid + " ");
            temp = temp.next;

        /*if(list.isSorted())
            System.out.println("true");
        else
            System.out.println("false");*/
        }
    }
    /*
     * createFromRNASequence() method:
     * Tests that the method creates an accurate list of amino acids
     * PASSED (it prints the correct linked list)
     */
    @Test
    public void testCFRS() {
        String sequence = "AGGAAGAUGCCC";
        AminoAcidLL list = AminoAcidLL.createFromRNASequence(sequence);
        AminoAcidLL temp = list.next;
        while (temp != null) {
            System.out.print(temp.aminoAcid + " ");
            temp = temp.next;
        }
    }


}
