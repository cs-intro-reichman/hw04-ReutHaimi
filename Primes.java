public class Primes {
    public static void main(String[] args) {
    int n = Integer.parseInt(args [0]);
    int counter = 0;
    boolean [] arr = new boolean[n+1];
    for (int i = 2 ; i < arr.length ; i++){
        arr [i] = true;
    }

    for (int i = 2 ; i < arr.length ; i++){
    for (int j = i + 1 ; j < arr.length ; j ++){
        if ((j % i == 0) && (arr [j] == true)){
            arr [j]= false;
        }
    }
    }
    for (int i = 0 ; i < arr.length ; i++){
        if (arr [i] == true){
            counter ++;
            System.out.println(i);
        }
    }
    System.out.println(counter);
    System.out.println(n);
    int precentage = (int)(((double)counter / (double)n) * 100) ;
    System.out.println(precentage);
    System.out.println("There are " + counter + " primes between 2 and " + n + " (" + precentage + "% are primes)");

    }
}

