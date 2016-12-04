package util;

// Created by Ponomarenko Oleh on 04.12.2016.


import java.util.Random;


public class MyRandom {

    public static boolean falseOrTrue() {
//        boolean result = false;
//        Random random = new Random();
//        int x = random.nextInt(2);
//        switch (x) {
//            case 0:
//                result = true;
//        }
//        System.out.println(result);
        return new Random().nextBoolean();
    }
}
