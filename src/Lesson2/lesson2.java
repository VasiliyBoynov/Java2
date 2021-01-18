package Lesson2;

import Lesson2.MyException.MyArrayDataException;
import Lesson2.MyException.MyArraySizeException;

public class lesson2 {
    public static void main(String[] args) {

        try {
            System.out.println(sumArray(creatMatrixString()));
        } catch (MyArraySizeException e) {
            e.printStackTrace();
        } catch (MyArrayDataException e) {
            e.printStackTrace();
        }

        try {
            System.out.println(sumArray(creatMatrixString1()));
        } catch (MyArraySizeException e) {
            e.printStackTrace();
        } catch (MyArrayDataException e) {
            e.printStackTrace();
        }

        try {
            System.out.println(sumArray(creatMatrixString2()));
        } catch (MyArraySizeException e) {
            e.printStackTrace();
        } catch (MyArrayDataException e) {
            e.printStackTrace();
        }

        try {
            System.out.println(sumArray(creatMatrixString3()));
        } catch (MyArraySizeException e) {
            e.printStackTrace();
        } catch (MyArrayDataException e) {
            e.printStackTrace();
        }

    }
    public static String[][] creatMatrixString(){
        String[][] strings = new String[3][];
        strings[0]= new String[] {"1"};
        strings[1]= new String[] {"1"};
        strings[2]= new String[] {"1"};
        return strings;
    }

    public static String[][] creatMatrixString1(){
        String[][] strings = new String[4][];
        strings[0]= new String[] {"1","2","3","4"};
        strings[1]= new String[] {"1"};
        strings[2]= new String[] {"1"};
        strings[3]= new String[] {"1","2","3","4"};
        return strings;
    }

    public static String[][] creatMatrixString2(){
        String[][] strings = new String[4][];
        strings[0]= new String[] {"1","2","3","4"};
        strings[1]= new String[] {"1","2","3","4"};
        strings[2]= new String[] {"1","2","3","!4"};
        strings[3]= new String[] {"1","2","3","4"};
        return strings;
    }

    public static String[][] creatMatrixString3(){
        String[][] strings = new String[4][];
        strings[0]= new String[] {"1","2","3","4"};
        strings[1]= new String[] {"1","2","3","4"};
        strings[2]= new String[] {"1","2","3","4"};
        strings[3]= new String[] {"1","2","3","4"};
        return strings;
    }


    public static int sumArray(String[][] strings) throws MyArraySizeException, MyArrayDataException {
        int count=0;

        if (strings.length!=4){
            throw new MyArraySizeException("The number of lines is not equal to 4.");
        }
        for (int i = 0; i < strings.length; i++) {
            if (strings[i].length!=4) {
                throw new MyArraySizeException(String.format("The number of column on line number %d is not equal to 4%n",i+1));
            }
            for (int j = 0; j < strings[i].length; j++) {
                try {
                    count+=Integer.parseInt(strings[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(String.format("incorrect input data format in line = %d; column = %d%n",i+1,j+1));
                }
            }

        }
        return count;
    }
}
