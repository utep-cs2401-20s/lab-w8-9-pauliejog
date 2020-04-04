/*
* Paulie Jo Gonzalez
* lab w-8-9
 */

import java.time.chrono.MinguoDate;

class AminoAcidLL{
  char aminoAcid;
  String[] codons;
  int[] counts;
  AminoAcidLL next;

  AminoAcidLL(){}

  /********************************************************************************************/
  /* Creates a new node, with a given amino acid/codon 
   * pair and increments the codon counter for that codon.
   * NOTE: Does not check for repeats!! */
  AminoAcidLL(String inCodon){
      aminoAcid = AminoAcidResources.getAminoAcidFromCodon(inCodon);
      codons = AminoAcidResources.getCodonListForAminoAcid(aminoAcid);
      counts = new int[codons.length];
      incrCodons(inCodon);
  }

  /********************************************************************************************/
  /* Recursive method that increments the count for a specific codon:
   * If it should be at this node, increments it and stops, 
   * if not passes the task to the next node. 
   * If there is no next node, add a new node to the list that would contain the codon. 
   */
  private void addCodon(String inCodon){
      if(aminoAcid == AminoAcidResources.getAminoAcidFromCodon(inCodon))
          incrCodons(inCodon);
      else if(next == null) {
          next = new AminoAcidLL(inCodon);
      }
      else
          next.addCodon(inCodon);
  }

  /********************************************************************************************/
  /* Shortcut to find the total number of instances of this amino acid */
  private int totalCount(){
      int sum = 0;
      for(int i = 0; i < counts.length; i++)
          sum += counts[i];
      return sum;
  }

  /********************************************************************************************/
  /* helper method for finding the list difference on two matching nodes
  *  must be matching, but this is not tracked */
  private int totalDiff(AminoAcidLL inList) {
    return Math.abs(totalCount() - inList.totalCount());
  }


  /********************************************************************************************/
  /* helper method for finding the list difference on two matching nodes
  *  must be matching, but this is not tracked */
  private int codonDiff(AminoAcidLL inList){
    int diff = 0;
    for(int i=0; i<codons.length; i++){
      diff += Math.abs(counts[i] - inList.counts[i]);
    }
    return diff;
  }

  /********************************************************************************************/
  /* Recursive method that finds the differences in **Amino Acid** counts. 
   * the list *must* be sorted to use this method */
  public int aminoAcidCompare(AminoAcidLL inList){
      if(!inList.isSorted())
          return -1;
      int diff = 0;
      if(inList == null) {
          diff += totalCount();
          if(next != null)
              diff += next.aminoAcidCompare(inList);
      }
      if(next == null) {
          diff += inList.totalCount();
          if(inList.next != null)
              diff += aminoAcidCompare(inList.next);
      }
      diff += totalCount();
    return diff;
  }
//totalDiff
  /********************************************************************************************/
  /* Same ad above, but counts the codon usage differences
   * Must be sorted. */
  public int codonCompare(AminoAcidLL inList){
    return 0;
  }
//codonDiff

  /********************************************************************************************/
  /* Recursively returns the total list of amino acids in the order that they are in in the linked list. */
  public char[] aminoAcidList() {
      if(next == null) {
          return new char[]{aminoAcid};
      }
      char[] a = next.aminoAcidList();
      char[] ret = new char[a.length+1];
      for(int i = 0; i < a.length; i++) {
        ret[i+1] = a[i];
      }
      ret[0] = aminoAcid;
      return ret;
  }

  /********************************************************************************************/
  /* Recursively returns the total counts of amino acids in the order that they are in in the linked list. */
  public int[] aminoAcidCounts(){
    if(next == null) {
        return new int[]{totalCount()};
    }
    int[] n = next.aminoAcidCounts();
    int[] ret = new int[n.length+1];
    for(int i = 0; i < n.length; i++) {
        ret[i + 1] = n[i];
    }
    ret[0] = totalCount();
    return ret;
  }
  /********************************************************************************************/
  /* recursively determines if a linked list is sorted or not */
  public boolean isSorted() {
      if (next == null)
          return true;
      else if(aminoAcid > next.aminoAcid)
          return false;
      return next.isSorted();
  }//end isSorted
  /********************************************************************************************/
  /* Static method for generating a linked list from an RNA sequence */
  public static AminoAcidLL createFromRNASequence(String inSequence){
    AminoAcidLL list = new AminoAcidLL(inSequence.substring(0,3));
    inSequence = inSequence.substring(3);
    while(inSequence.length() > 2) {
      list.addCodon(inSequence.substring(0,3));
      inSequence = inSequence.substring(3);
    }
    return list;
  }//end createFromRNASequence
  /********************************************************************************************/
  /* sorts a list by amino acid character*/
  public static AminoAcidLL sort(AminoAcidLL inList){
    AminoAcidLL iter = inList;
    char temp;
    while(iter.next != null) {
        if(iter.aminoAcid > iter.next.aminoAcid) {
            temp = iter.aminoAcid;
            iter.aminoAcid = iter.next.aminoAcid;
            iter.next.aminoAcid = temp;
            iter = iter.next;
            if(iter.next == null) {
                if(inList.isSorted())
                    break;
                iter = inList;
            }
        }
        else {
            iter = iter.next;
            if(iter.next == null) {
                if(inList.isSorted())
                    break;
                iter = inList;
            }
        }
    }
    return inList;
  }//end sort
  /********************************************************************************************/
  /* helper method for counts */
  public void incrCodons(String inCodon) {
    int i;
    for(i = 0; i < codons.length; i++) {
      if(codons[i].equals(inCodon))
        break;
    }
    counts[i]++;
  }//end incrCodons
}//end class