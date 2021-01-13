public class Radix{
  public static int nth(int n, int col){
    int rem = n%((int)(Math.pow(10, col +1)));
    if (col !=0){
      rem = rem - rem%((int)(Math.pow(10, col)));
    }
    rem = rem / ((int)(Math.pow(10, col)));
    return Math.abs(rem);
  }

  public static int length(int n){
    int len = (int)(Math.log10(Math.abs(n)));
    return len + 1;
  }
  public static void merge(MyLinkedList original,MyLinkedList[]buckets){
    for (int i = 0; i < buckets.length; i++){
      original.extend(buckets[i]);
    }
  }
}
