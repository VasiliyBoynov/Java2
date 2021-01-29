package Lesson5;

public class Lesson5 {
    public static void main(String[] args) {
        final int size = 10000000;
        //final int size = 1000;
        final int h = size / 2;
        metod1(size);
        metod2(size,h);
    }

    public static float[] initArray(int size){

        float[] arr = new float[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i]=1;
        }
        return arr;
    }

    public static void metod1(int size){
        float[] arr = initArray(size);
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        long finishTime = System.currentTimeMillis();
        System.out.println("Время работы метода 1 : " + (finishTime-startTime));
    }
    public static void metod2(int size, int h){
        float[] arr = initArray(size);
        long startTime = System.currentTimeMillis();
        float[] arr1 = new float[h];
        float[] arr2 = new float[h];
        System.arraycopy(arr, 0, arr1, 0, h);
        System.arraycopy(arr, h, arr2, 0, h);
        MyThread thread1 = new MyThread(arr1,0);
        MyThread thread2 = new MyThread(arr2,h);
        thread1.start();
        thread2.start();
        while (true){
            if ((!thread1.isAlive()&&!thread2.isAlive())){
                break;
            }
        }
        System.arraycopy(thread1.getArr(), 0, arr, 0, h);
        System.arraycopy(thread2.getArr(), 0, arr, h, h);
        long finishTime = System.currentTimeMillis();
        System.out.println("Время работы метода 2 : " + (finishTime-startTime));
    }

}
