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
    int len = (int)Math.log(Math.abs(n));
    return len;
  }
  public static void main(String[] args) {
    System.out.println(nth(Integer.parseInt(args[0]),Integer.parseInt(args[1])));
    System.out.println(length(Integer.parseInt(args[0])));
  }
}
