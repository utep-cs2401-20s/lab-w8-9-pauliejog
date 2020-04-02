/*
* Paulie Jo Gonzalez
* lab w-8-9
 */

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
      else {
          if(next != null)
              next.addCodon(inCodon);
          else
              next = new AminoAcidLL(inCodon);
      }
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
  private int totalDiff(AminoAcidLL inList){
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
    return 0;
  }

  /********************************************************************************************/
  /* Same ad above, but counts the codon usage differences
   * Must be sorted. */
  public int codonCompare(AminoAcidLL inList){
    return 0;
  }


  /********************************************************************************************/
  /* Recursively returns the total list of amino acids in the order that they are in in the linked list. */
  public char[] aminoAcidList(){
      return new char[1];
  }

  /********************************************************************************************/
  /* Recursively returns the total counts of amino acids in the order that they are in in the linked list. */
  public int[] aminoAcidCounts(){
    return new int[]{};
  }


  /********************************************************************************************/
  /* recursively determines if a linked list is sorted or not */
  public boolean isSorted(){
    if(next == null)
      return true;
    if(next != null) {

    }
    return false;
  }


  /********************************************************************************************/
  /* Static method for generating a linked list from an RNA sequence */
  public static AminoAcidLL createFromRNASequence(String inSequence){
    AminoAcidLL list = null;
    String tempCodon = "";
    for(int i = 0; i < inSequence.length(); i++) {
      tempCodon += inSequence.charAt(i);
      if(tempCodon.length() == 3) {
        list.addCodon(tempCodon);
        tempCodon = "";
      }
    }
    return list;
  }


  /********************************************************************************************/
  /* sorts a list by amino acid character*/
  public static AminoAcidLL sort(AminoAcidLL inList){
    return null;
  }

  /* helper method for counts */
  public void incrCodons(String inCodon) {
    int i;
    for(i = 0; i < codons.length; i++) {
      if(codons[i].equals(inCodon))
        break;
    }
    counts[i]++;
  }

  /*
    public static void sort(char[] a) {
    String[] temp = new String[2];
    char hold;

    int index = a.length-1;
    while(index >= 0) {
      hold = a[index];
      temp = findLast(a,index);
      a[index] = temp[0].charAt(0);
      a[Integer.valueOf(temp[1])] = hold;
      index--;

    }
  }
  }
  public static String[] findLast(char[] a, int ind) {
    String[] result = new String[2];
    char last = a[0];
    int index = -1;
    for(int i = 0; i <= ind; i++) {
      if(a[i] >= last) {
       last = a[i];
        index = i;
      }
    }
  result[0] = Character.toString(last);
  result[1] = Integer.toString(index);
  return result;
  }
   */


}//end class