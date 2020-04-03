import static org.junit.jupiter.api.Assertions.*;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;

class AminoAcidResourcesTester{

  @Test
  public void allCodons(){
    char[] rna = {'A','C','U','G'};
    char[] aa = {'A','C','D','E','F','G','H','I','K','L','M','N','P','Q','R','S','T','V','W'};
    for(int i=0; i<4; i++){
      for(int j=0; j<4; j++){
        for(int k=0; k<4;k++){
          String s = new String(new char[]{rna[i],rna[j],rna[k]});
          char aaOut = AminoAcidResources.getAminoAcidFromCodon(s);
          if(aaOut != '*'){
            String[] codonList = AminoAcidResources.getCodonListForAminoAcid(aaOut);
            boolean found = false;
            for(int l=0; l<codonList.length; l++){
              found |= (codonList[l].equals(s));
            }
            if(!found) System.err.println("Codon " + s + " not found, said AA was " + aaOut);
          }

          aaOut = AminoAcidResources.getAminoAcidFromCodon(s.toLowerCase());
          if(aaOut != '*'){
            String[] codonList = AminoAcidResources.getCodonListForAminoAcid(aaOut);
            boolean found = false;
            for(int l=0; l<codonList.length; l++){
              found |= (codonList[l].equals(s));
            }
            if(!found) System.err.println("Codon " + s + " not found, said AA was " + aaOut);
          }
        }
      }
    }

  }

  @Test
  public void allAAs(){

    char[] aa = {'A','C','D','E','F','G','H','I','K','L','M','N','P','Q','R','S','T','V','W'};
    for(int i=0; i<aa.length; i++){
      String[] codonList = AminoAcidResources.getCodonListForAminoAcid(aa[i]);
      for(int l=0; l<codonList.length; l++){
        if(aa[i] != AminoAcidResources.getAminoAcidFromCodon(codonList[l])){
          System.err.println("AA " + aa[i] + " not found, said codon was " + codonList[l]);
        }
      }

      codonList = AminoAcidResources.getCodonListForAminoAcid(Character.toLowerCase(aa[i]));
      for(int l=0; l<codonList.length; l++){
        if(aa[i] != AminoAcidResources.getAminoAcidFromCodon(codonList[l])){
          System.err.println("AA " + aa[i] + " not found, said codon was " + codonList[l]);
        }
      }
    }
  }

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
    while(temp != null) {
      System.out.print(temp.aminoAcid + " ");
      temp = temp.next;
    }*/
  }



}//end class