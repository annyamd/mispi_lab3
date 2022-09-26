package com.example.web3;

public class Main {
    public static void main(String[] args) {
        //check point (1,1) with r = 1
        AreaShot areaShot = new AreaShot();
        areaShot.setX(1.0f);
        areaShot.setY(1.0f);

        AreaShotsList areaShotsList = new AreaShotsList();
        areaShotsList.setShot(areaShot);
        areaShotsList.setR(1);
        areaShotsList.addShot();

        System.out.println(">>Main done.");
    }
}
