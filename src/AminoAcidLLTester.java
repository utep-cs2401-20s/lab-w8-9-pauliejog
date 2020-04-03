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
     * PASSED
     */
    @Test
    public void testIsSorted1() {
        String sequence = "AGGAAGAUGCCCAGA";
        AminoAcidLL list = AminoAcidLL.createFromRNASequence(sequence);
        assertEquals(false,list.isSorted());
    }
    /*
     * isSorted() method:
     *
     */
    @Test
    public void testIsSorted2() {
        String sequence = "GCCUGUUAC";
        AminoAcidLL list = AminoAcidLL.createFromRNASequence(sequence);
        assertEquals(true,list.isSorted());
    }
    /*
     * sort() method:
     * PASSED
     */
    @Test
    public void testSort1() {
        String sequence = "AGGAAGAUGCCCAGA";
        AminoAcidLL list = AminoAcidLL.createFromRNASequence(sequence);
        AminoAcidLL newList = AminoAcidLL.sort(list);
        AminoAcidLL temp = newList.next;
        while (temp != null) {
            System.out.print(temp.aminoAcid + "   ");
            temp = temp.next;
        }
    }
    /*
     * sort() method:
     * PASSED
     */
    @Test
    public void testSort2() {
        String sequence = "CCGUUGGCACUGUUG";
        AminoAcidLL list = AminoAcidLL.createFromRNASequence(sequence);
        AminoAcidLL newList = AminoAcidLL.sort(list);
        AminoAcidLL temp = newList.next;
        while (temp != null) {
            System.out.print(temp.aminoAcid + "   ");
            temp = temp.next;
        }
    }
    /*
     * sort() method:
     * PASSED
     */
    @Test
    public void testSort3() {
        String sequence = "CAGCCAGCUAGGAGCAAG";
        AminoAcidLL list = AminoAcidLL.createFromRNASequence(sequence);
        AminoAcidLL newList = AminoAcidLL.sort(list);
        AminoAcidLL temp = newList.next;
        while (temp != null) {
            System.out.print(temp.aminoAcid + "   ");
            temp = temp.next;
        }
    }





    /*
     * createFromRNASequence() method: 2 TESTS
     * Tests that the method creates accurate listS of amino acids
     * PASSED (it prints the correct linked listS)
     */
    @Test
    public void testCFRS() {
        String sequence = "AGGAAGAUGCCCAGA";
        AminoAcidLL list = AminoAcidLL.createFromRNASequence(sequence);
        AminoAcidLL temp = list.next;
        while (temp != null) {
            System.out.print(temp.aminoAcid + "   ");
            temp = temp.next;
        }
    }
    @Test
    public void testCFRS2() {
        String sequence = "CAGCCAGCUAGGAGCAAG";
        AminoAcidLL list = AminoAcidLL.createFromRNASequence(sequence);
        AminoAcidLL temp = list.next;
        while (temp != null) {
            System.out.print(temp.aminoAcid + "   ");
            temp = temp.next;
        }
    }


}
