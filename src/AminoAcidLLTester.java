import static org.junit.jupiter.api.Assertions.*;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;

public class AminoAcidLLTester {
    /*
     * AminoAcidLL constructor:
     * Testing that the constructor works
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
     * PASSED
     */
    @Test
    public void testAAList() {
        String sequence = "CCGUUGGCACUGUUG";
        AminoAcidLL list = AminoAcidLL.createFromRNASequence(sequence);
        char[] exp = {'P','L','A'};
        char[] result = list.aminoAcidList();
        assertArrayEquals(exp,result);
    }
    /*
     * aminoAcidList() method:
     * PASSED
     */
    @Test
    public void testAAList2() {
        String sequence = "AGGAAGAUGCCCAGA";
        AminoAcidLL list = AminoAcidLL.createFromRNASequence(sequence);
        char[] exp = {'R','K','M','P'};
        char[] result = list.aminoAcidList();
        assertArrayEquals(exp,result);
    }
    /*
     * aminoAcidCounts() method:
     * PASSED
     */
    @Test
    public void testAACounts() {
        String sequence = "CCGUUGGCACUGUUG";
        AminoAcidLL list = AminoAcidLL.createFromRNASequence(sequence);
        int[] result = list.aminoAcidCounts();
        int[] exp = {1,3,1};
        assertArrayEquals(exp,result);
    }
    /*
     * aminoAcidCounts() method:
     * PASSED
     */
    @Test
    public void testAACounts2() {
        String sequence = "CCGUUGGCACUGUUGGCCUGUUAC";
        AminoAcidLL list = AminoAcidLL.createFromRNASequence(sequence);
        int[] result = list.aminoAcidCounts();
        int[] exp = {1,3,2,1,1};
        assertArrayEquals(exp,result);
    }
    /*
     * aminoAcidCompare() method:
     * FAILED
     */
    @Test
    public void testAACompare() {
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
     * sort() method: Somehow the easiest method for me :|
     * Each of these tests print the sorted list and does not assert anything, but the sorted lists are correct
     * PASSED
     */
    @Test
    public void testSort1() {
        String sequence = "AGGAAGAUGCCCAGA";// R   K   M   P
        AminoAcidLL list = AminoAcidLL.createFromRNASequence(sequence);
        AminoAcidLL newList = AminoAcidLL.sort(list);
        AminoAcidLL temp = newList;
        while (temp != null) {
            System.out.print(temp.aminoAcid + "   ");
            temp = temp.next;
        }// K   M   P   R
    }
    /*
     * sort() method:
     * PASSED
     */
    @Test
    public void testSort2() {
        String sequence = "CCGUUGGCACUGUUG";// P   L   A
        AminoAcidLL list = AminoAcidLL.createFromRNASequence(sequence);
        AminoAcidLL newList = AminoAcidLL.sort(list);
        AminoAcidLL temp = newList;
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
        String sequence = "CAGCCAGCUAGGAGCAAG";// Q   P   A   R   S   K
        AminoAcidLL list = AminoAcidLL.createFromRNASequence(sequence);
        AminoAcidLL newList = AminoAcidLL.sort(list);
        AminoAcidLL temp = newList;
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
    public void testSort4() {
        String sequence = "UACUGUGCC";// A C T
        AminoAcidLL list = AminoAcidLL.createFromRNASequence(sequence);
        AminoAcidLL newList = AminoAcidLL.sort(list);
        AminoAcidLL temp = newList;
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
        AminoAcidLL temp = list;
        while (temp != null) {
            System.out.print(temp.aminoAcid + "   ");
            temp = temp.next;
        }
    }
    @Test
    public void testCFRS2() {
        String sequence = "CAGCCAGCUAGGAGCAAG";
        AminoAcidLL list = AminoAcidLL.createFromRNASequence(sequence);
        AminoAcidLL temp = list;
        while (temp != null) {
            System.out.print(temp.aminoAcid + "   ");
            temp = temp.next;
        }
    }


}//end class
