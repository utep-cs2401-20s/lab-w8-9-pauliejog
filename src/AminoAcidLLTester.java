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
        //char[] exp = {'P','L','A','L','L'};
        char[] result = list.aminoAcidList();
        for(int i = 0; i < result.length; i++)
            System.out.print(result[i] + " ");

        //System.out.println("hello");

        //System.out.print(result[1]);
    /*AminoAcidLL temp = list.next;
    while (temp != null) {
      System.out.print(temp.aminoAcid + " ");
      temp = temp.next;

    }*/
    }

}
