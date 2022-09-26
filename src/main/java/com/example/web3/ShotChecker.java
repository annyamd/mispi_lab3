package com.example.web3;

public class ShotChecker {

    public static boolean isHit(AreaShot areaShot){
        float x = areaShot.getX();
        float y = areaShot.getY();
        float r = areaShot.getR();

        return (x >= 0 && y >= 0 && x <= r && y <= r)
                || (x >= 0 && y <= 0 && y >= (x - r / 2))
                || (x <= 0 && y <= 0 && (x * x + y * y) <= (r * r));
    }
}
