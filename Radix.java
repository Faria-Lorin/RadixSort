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
  public static void merge( SortableLinkedList original, SortableLinkedList[]buckets){
    for (int i = 0; i < buckets.length; i++){
      original.extend(buckets[i]);
    }
  }
  public static void radixSortSimple(SortableLinkedList data){
    int digit = 0;
    int mostDigits = 0;
    SortableLinkedList clearData = new SortableLinkedList();
    SortableLinkedList[] buckets = new SortableLinkedList[10];
    for (int i = 0; i < 10; i++){
      SortableLinkedList boxes = new SortableLinkedList();
      buckets[i] = boxes;
    }
    for (int i = 0; i < data.size(); i++){
      if (length(data.get(i)) > mostDigits){
        mostDigits = length(data.get(i));
      }
    }
    for (int i = 0; i < mostDigits; i++){
      for (int j = 0; j < data.size(); j++){
        digit = nth(data.get(j), i);
        buckets[digit].add(data.get(j));
      }
    }

      clearData.extend(data);
      merge(data, buckets);
  }
}
