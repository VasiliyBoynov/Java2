package Lesson5;

public class MyThread extends Thread {

    private float[] arr;
    private int start;

    public MyThread(float[] arr, int start) {
        this.arr = arr;
        this.start = start;
    }

    public float[] getArr() {
        return arr;
    }

    private void mathArray(){
        for (int i = 0; i < this.arr.length; i++) {
            this.arr[i] = (float)(this.arr[i] * Math.sin(0.2f + (i+this.start) / 5) * Math.cos(0.2f + (i+this.start) / 5) * Math.cos(0.4f + (i+this.start)/ 2));
        }
    }

    @Override
    public void run() {
        mathArray();

    }
}
