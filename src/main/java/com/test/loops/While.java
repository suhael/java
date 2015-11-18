package com.test.loops;

import java.util.Arrays;
import java.util.List;

/**
 * Created by sakhtar on 22/07/2015.
 */
public class While {

    public static void main(String[] args) {
        int retries = 0;
        boolean trackingFound = false;

        List<Integer> integerList = Arrays.asList(new Integer(1), new Integer(2), new Integer(3));

        while((retries < 3) && (!trackingFound)) {

            for(Integer integer : integerList){
                System.out.println("Loop count retries("+retries+") and int value ("+integer.intValue()+")");
                if((integer.intValue() == 2) && (retries == 2)){
                    trackingFound = true;
                    break;
                }
            }
            retries++;

        }
    }
}
