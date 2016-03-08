package main;
import java.util.HashMap;
import java.util.Map;
import java.util.Date;
/**
 * Created by Данил on 06.03.2016.
 */
public class HashMapBenchamrker {//Класс, нужный для замеров производительности HashMap
    private int[] insertionsCounts;//Массив, содеражащий числа вставок(1000,10000,...100000))
    private int iterationsCount;//Число итераций, нужное для определения среднего
    private Map<Key,UserProfile> map;
    boolean keyIsBad ;
    public HashMapBenchamrker(int[] insertionsCounts, int iterationsCount){
        this.insertionsCounts=insertionsCounts;
        this.iterationsCount=iterationsCount;
        this.map=new HashMap<>();
    }
    private   long  computeInsertionsTime(int insertionsCount){//Вычисление длительности insertionsCount вставок
        long beginTime =(new Date()).getTime();
        for(int i=0; i<insertionsCount; i++){
            map.put(new Key(i,keyIsBad),new UserProfile(i,"","",""));
        }
        return ( (new Date()).getTime()-beginTime);
    }
    //Вычисление средней длительности insertionsCount вставок
    //По  iterationsCount циклам
    private double computeAvgInsertionTime(int insertionsCount)
    {
        int averageTime =0;
        for(int i=0; i<iterationsCount; i++) {
            averageTime+=computeInsertionsTime(insertionsCount);
            map.clear();
        }
        return  (double)averageTime/iterationsCount;

    }

    public double[] run(boolean keyIsBad)
    {
        this.keyIsBad=keyIsBad;
        double[] resultArray = new double[insertionsCounts.length];
        for (int i=0; i<insertionsCounts.length;i++){
            resultArray[i] = computeAvgInsertionTime(insertionsCounts[i]);
        }
        return  resultArray;
    }

}
