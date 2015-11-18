package com.test.annotations;

/**
 * Created by sakhtar on 11/08/2015.
 */
public class MyCars {

    @Cars
    String colorRed = "Red car";

    String colorGreen = "Green car";

    @Cars(carName = { Cars.CarName.FERRARI, Cars.CarName.LAMBORGHINI }, color = "red")
    public void myCars() {
        System.out.println("I have following cars.");
    }

    public void notMyCars() {
        System.out.println("I don't have cars.");
    }

    public static void main(String[] args) {
        MyCars myCars = new MyCars();
        myCars.myCars();
        myCars.notMyCars();
    }

}
