import javax.swing.*;
import java.util.Arrays;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.io.InputStreamReader;

class putInEmptyCell {
    static public boolean flag = true;
    static public int aa, bb;

    int[][] putInEmptyCell(int array[][], int a, int b, int value) {

        if (array[a - 1][b] == 0) {
            array[a - 1][b] = value;
            aa = a - 1;
            bb = b;
        } else if (array[a - 1][b + 1] == 0) {
            array[a - 1][b + 1] = value;
            aa = a - 1;
            bb = b + 1;
        } else if (array[a][b + 1] == 0) {
            array[a][b + 1] = value;
            aa = a;
            bb = b + 1;
        } else if (array[a + 1][b + 1] == 0) {
            array[a + 1][b + 1] = value;
            aa = a + 1;
            bb = b + 1;
        } else if (array[a + 1][b] == 0) {
            array[a + 1][b] = value;
            aa = a + 1;
            bb = b;
        } else if (array[a + 1][b - 1] == 0) {
            array[a + 1][b - 1] = value;
            aa = a + 1;
            bb = b - 1;
        } else if (array[a][b - 1] == 0) {
            array[a][b - 1] = value;
            aa = a;
            bb = b - 1;
        } else if (array[a - 1][b - 1] == 0) {
            array[a - 1][b - 1] = value;
            aa = a - 1;
            bb = b - 1;
        } else flag = false;

        return array;
    }
}


class getSetofKey  {

    int[] key = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
    int[] sum = new int[9];
    static int i, k, a, b;


    getSetofKey(int array[]) {

        for (i = 1; i < array.length; i++) {
            for (k = 0; k < array.length - i; k++) {
                if (array[k] < array[k + 1]) {

                    a = array[k];
                    array[k] = array[k + 1];
                    array[k + 1] = a;

                    b = key[k];
                    key[k] = key[k + 1];
                    key[k + 1] = b;
                }
            }
        }
    }

    void ResultOut(int array[][], int n) {
        for (i = 0; i < n; i++) {
            for (k = 0; k < n; k++)
                System.out.print(array[i][k] + " ");
            System.out.println();
        }
        System.out.println();
    }

    getSetofKey(int array[][]) {
        for (i = 0; i < array.length; i++) {
            sum[i] = 0;
            for (k = 0; k < array.length; k++)
                if (array[k][i] != 0)
                    sum[i] += 1;
        }
    }
}

public class Trassirovka {
    public static void main(String[] args) throws IOException {
        int i;
        int j;                                                                   //
        int ves;                              //
        int n = 9;
        int с;
        int a;
        int b;                                     //
        int[][] defMatrix = new int[n][n];
        int[][] result = new int[n][n];
        int[] numberOfConnections;
        boolean retval;                                   //sdfsdf
        ArrayList<Integer> list = new ArrayList<Integer>();
        String s;
        int ii, jj;                                         ///
        //int[] priority=new int[]{};



        FileInputStream fin = new FileInputStream("C:/Intel/1.txt");    //читать файл
        BufferedReader br = new BufferedReader(new InputStreamReader(fin));
        //   String name= JOptionPane.showInputDialog("enter");
       //  System.out.println(br.readLine());



        for (с = 0; с < 6; с++) {
            s = br.readLine();            //Определение общего числа    связей
            i = Integer.parseInt(s);     //string----->   integer
            i = i - 1;

            s = br.readLine();
            j = Integer.parseInt(s);
            j = j - 1;

            s = br.readLine();
            ves = Integer.parseInt(s);

            defMatrix[j][i] = ves;             // "Mirroring" the right-hand part of matrix on the left part
            defMatrix[i][j] = ves;             //Зеркальное отображение правой половины на левую.
        }


        getSetofKey obj1 = new  getSetofKey(defMatrix);
        numberOfConnections = obj1.sum;                 //  Transfer result of object to numberOfConnections variable (for illustration).
        //Передача результата
        getSetofKey obj = new  getSetofKey(numberOfConnections);

        //Creating new object for overload Java constructor
        System.out.println("Total number of relations(TNR), for each top\n" + Arrays.toString(numberOfConnections) + "\n");    //Displaying the array of related elements.
        int key[] = obj.key;             //Here is the sorting with associative keys. Method returns key-sorted set.

        System.out.println("Default matrix");
        obj.ResultOut(defMatrix, n);          //Result output

        System.out.println("Iteration priority- key\n" + Arrays.toString(key) + "\n");
        int a1, b1;

        a = 4;
        b = 4;

        putInEmptyCell objPutInEmptyCell = new putInEmptyCell();

       // for (int ty = 0; ty < 9; ty++) {              //Это закоментированный код для установки границ.
        //    result[3][5] = 6;
       //     result[3][6]=4;
       //     list.add(4);
      //  list.add(6);
       // }

 /*     for (int ty = 0; ty < 9; ty++) {
            result[ty][5] = 11;
            list.add(11);
        }                    */


        if (result[a][b]  !=0) {                         //Если установлена граница, то проверяется, не стоит ли первый элемент на ней.
            result = objPutInEmptyCell.putInEmptyCell(result, a, b, key[0]);
            a = objPutInEmptyCell.aa;
            b = objPutInEmptyCell.bb;
            result[a][b] = key[0];
            list.add(key[0]);
        } else {                                        //..если нет, то ставим по координатам [a] и [b]
            result[a][b] = key[0];
            list.add(key[0]);                           //и добавляем в список добавленных элементов.
        }

        a1 = a;
        b1 = a;

        getSetofKey objnik = new getSetofKey(defMatrix[1]);
        int[] priority= objnik.key;

        //   System.out.println("niks priority [1] " + Arrays.toString(priority) + "\n");
        int oldres = 99999;

        for (i = 0; i < 6; i++) {

            a = a1;
            b = b1;
            if (i != 0) {

                getSetofKey objnikw = new getSetofKey(defMatrix[key[i] - 1]);
                priority = objnikw.key;
                //   System.out.println("key[i]= " + (key[i]) + " i=" + i + "\n");
                //    System.out.println("if!=0 niks priority [" + i + "]=" + "\n" + Arrays.toString(priority) + "\n");

                oldres = result[a][b];

                {
                    for (ii = 0; ii < 9; ii++) {
                        for (jj = 0; jj < 9; jj++) {
                            if (result[ii][jj] == key[i]) {
                                {
                                    a1 = ii;
                                    b1 = jj;
                                    // System.out.println("NAIDENO SOVPADENIE ");
                                }
                            }
                        }
                    }
                }
            }


            if (oldres == result[a1][b1]) {

                result = objPutInEmptyCell.putInEmptyCell(result, a, b, key[i]);

                a = objPutInEmptyCell.aa;
                b = objPutInEmptyCell.bb;
                //  obj.ResultOut(result, n);
                list.add(key[i]);


                System.out.println("Center= " + result[a][b]);

            } else {

                a = a1;
                b = b1;
                System.out.println("Center= " + result[a][b]);

            }

            for (j = 0; j < numberOfConnections[i]; j++) {

                //   System.out.println("numberOfConnections[" + i + "]" + numberOfConnections[i]);
                retval = list.contains(priority[j]);
                if (retval == true)
                    ;
                else {
                    result = objPutInEmptyCell.putInEmptyCell(result, a, b, priority[j]);
                    if (putInEmptyCell.flag == true)
                        list.add(priority[j]);
                    else System.out.println("NE DOBAVLEN " + priority[j]);
                    //  obj.ResultOut(result, n);
                }
            }
        }


        System.out.println("Result matrix");          // Printing result matrix. Done!
        obj.ResultOut(result, n);
    }
}
