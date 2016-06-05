package com.codewars;

/**
 * Created by sulfur on 17.02.16.
 */
public class FindTheParityOutlier {

        static int find(int[] integers){
            int countEven = 0;
            int countOdd = 0;

            for (int temp : integers){

                if (temp%2 == 0) {
                    countEven++;
                } else countOdd++;
            }
            if(countEven > countOdd) {
                for (int temp : integers) {

                    if (temp % 2 != 0) {
                        return temp;
                    }
                }
            }else {
                    for (int temp : integers){

                        if (temp%2 == 0) {
                            return temp;
                        }
                }
            }

//            System.out.println("Hellow Worldafadga");

            return 0;
        }


}
