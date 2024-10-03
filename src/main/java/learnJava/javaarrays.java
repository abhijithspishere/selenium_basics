package learnJava;
import java.util.*;
public class javaarrays {
    public static void main(String[] args) {
       int a[] = {1,2,3};
        System.out.println(a.length);
        System.out.println(Arrays.toString(a));

        /* for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]); */

            for (int i : a) {
                System.out.println(i);
            }
        }
    }

