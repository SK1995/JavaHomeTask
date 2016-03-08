package main;

public class Main {

    public static  final int STEP=10000;
    public static  final int ITERATIONS_COUNT=10;
    public static  final int INSERTION_COUNTS_LENGTH =11;//Длина массива с числами вставок


    public static void main(String[] args) throws InterruptedException {
        int[] insertionCounts = new int[INSERTION_COUNTS_LENGTH];//Массив с числами вставок(1.000, 10.000, 20.000,...100.000)
        insertionCounts[0] =1000;
        for (int i=1; i<INSERTION_COUNTS_LENGTH; i++)
            insertionCounts[i]=STEP*i;
        HashMapBenchamrker benchamarker =new HashMapBenchamrker(insertionCounts,ITERATIONS_COUNT);
        double[] goodKeyBenchmarkResult = benchamarker.run(false);
        double[] badKeyBenchmarkResult = benchamarker.run(true);
        for (int i=0; i<INSERTION_COUNTS_LENGTH; i++) {
            System.out.print("Time of " + insertionCounts[i] + " insertions with good key: ");
            System.out.println(goodKeyBenchmarkResult[i] + "ms");
        }
        for (int i=0; i<INSERTION_COUNTS_LENGTH; i++) {
            System.out.print("Time of " + insertionCounts[i] + " insertions with bad key: ");
            System.out.println(badKeyBenchmarkResult[i] + "ms");
        }
    }
}