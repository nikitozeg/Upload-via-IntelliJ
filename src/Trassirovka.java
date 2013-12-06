import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.io.InputStreamReader;

class AsSort {

    void meth(int array[], int key[]) {

        for (int t = 1; t < array.length; t++) {
            for (int k = 0; k < array.length - t; k++) {
                if (array[k] < array[k + 1]) {

                    int a = array[k];
                    array[k] = array[k + 1];
                    array[k + 1] = a;

                    int b = key[k];
                    key[k] = key[k + 1];
                    key[k + 1] = b;
                }
            }
        }
    }
}


public class Trassirovka {
    public static void main(String[] args) throws IOException {
        int i, j, ves, m = 8, n = 9, с, a, b, position;
        int[][] nums = new int[n][n];
        int[][] result = new int[m][m];
        int[] kse = new int[9];
        int[] ksem = new int[9];

        boolean retval;
        ArrayList<Integer> list = new ArrayList<Integer>();
        String s;

        //try{
        FileInputStream fin = new FileInputStream("C:/Intel/1.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(fin));
        //  name= JOptionPane.showInputDialog("enter");
        //  System.out.println(br.readLine());
        // for(int k=0;kk<5;k++){ nums[k][k]=0; }


        for (с = 0; с < 9; с++) {         //Defining the   Total number of relations   (TNR)
            s = br.readLine();
            i = Integer.parseInt(s);
            i = i - 1;

            s = br.readLine();
            j = Integer.parseInt(s);
            j = j - 1;

            s = br.readLine();
            ves = Integer.parseInt(s);

            nums[j][i] = ves;             // "Mirroring" the right-hand part of matrix on the left part
            nums[i][j] = ves;
        }

        for (i = 0; i < n; i++) {          // Calculating the summ of TNR
            kse[i] = 0;
            for (j = 0; j < n; j++) {
                if (nums[j][i] != 0) {
                    kse[i] += 1;
                }
            }
            ksem[i] = kse[i];
        }
        System.out.println("Total number of relations(TNR), for each top\n" + Arrays.toString(ksem));    //Displaying the array of related elements.
        System.out.println();

        AsSort obj = new AsSort();
        int[] key = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        obj.meth(ksem, key);

        System.out.println("Iteration priority\n" + Arrays.toString(key) + "\n");

        System.out.println("Default matrix");
        for (i = 0; i < n; i++) {
            for (j = 0; j < n; j++) {
                System.out.print(nums[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();

        a = 4;
        b = 4;
        position = 1;
        list.add(key[0]);

        for (i = 0; i <= 2; i++) {
            for (j = 0; j < 9; j++)
                if (nums[i][j] == 0)
                    ;
                else {
                    switch (position) {
                        case 1:
                            retval = list.contains(j + 1);
                            if (retval == true)
                                break;
                            result[a - 1][b] = j + 1;
                            list.add(j + 1);
                            position = 2;
                            break;
                        case 2:
                            retval = list.contains(j + 1);
                            if (retval == true)
                                break;
                            result[a][b + 1] = j + 1;
                            list.add(j + 1);
                            position = 3;

                            break;
                        case 3:
                            retval = list.contains(j + 1);
                            if (retval == true)
                                break;
                            result[a + 1][b] = j + 1;
                            list.add(j + 1);
                            position = 4;
                            break;
                        case 4:
                            retval = list.contains(j + 1);
                            if (retval == true)
                                break;
                            result[a][b - 1] = j + 1;
                            list.add(j + 1);
                            position = 5;
                            a = 3;
                            b = 4;
                            break;
                        case 5:      //
                            retval = list.contains(j + 1);
                            if (retval == true)
                                break;
                            result[a - 1][b] = j + 1;
                            list.add(j + 1);
                            position = 1;
                            a = 2;
                            break;
                    }
                }
        }


        System.out.println("Result matrix");

        a = 4;               // Definition of center element
        b = 4;

        result[a][b] = key[0];
        for (i = 0; i < m; i++) {
            for (j = 0; j < m; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }

        fin.close();
    }
}