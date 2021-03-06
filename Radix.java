public class Radix{
  public static int nth(int n, int col){
    if (col < 0){
      throw new IndexOutOfBoundsException("Go look for your Imaginary negative column somewhere else");
    }
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
    int num = 0;
    int digit = 0;
    int mostDigits = 1;
    SortableLinkedList temp = new SortableLinkedList();
    SortableLinkedList[] buckets = new SortableLinkedList[10];
    for (int i = 0; i < 10; i++){
      SortableLinkedList boxes = new SortableLinkedList();
      buckets[i] = boxes;
    }

    for (int i = 0; i < mostDigits; i++){
      for (int j = 0; j < data.size();){
        num = data.remove(j);
        if (i == 0 && length(num) > mostDigits){
          mostDigits = length(num);
        }
        digit = nth(num, i);
        buckets[digit].add(num);
      }
      temp.extend(data);
      merge(data, buckets);
    }
  }
  public static void radixSortSimpleNeg(SortableLinkedList data){
    radixSortSimple(data);
    SortableLinkedList clearData = new SortableLinkedList();
    SortableLinkedList newData = new SortableLinkedList();
    for (int i = data.size() -1; i >= 0; i--){
      newData.add(data.remove(i));
    }
    clearData.extend(data);
    data.extend(newData);
  }

  public static void radixSort(SortableLinkedList data){
    SortableLinkedList clearData = new SortableLinkedList();
    SortableLinkedList Negatives = new SortableLinkedList();
    SortableLinkedList Positives = new SortableLinkedList();
    int num = 0;
    for (int i = 0; i < data.size();){
      num = data.remove(i);
      if (num >= 0){
        Positives.add(num);
      }
      else {
        Negatives.add(num);
      }
    }
    radixSortSimple(Positives);
    radixSortSimpleNeg(Negatives);
    clearData.extend(data);
    data.extend(Negatives);
    data.extend(Positives);
  }
}
