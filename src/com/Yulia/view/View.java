package com.Yulia.view;

import com.Yulia.model.Point;

import java.util.HashSet;

public class View {


    public void output(HashSet<Point> points){
        System.out.println("HashSet output:\n");
        for (Point point: points) {
            System.out.println(point);
        }
    }

    public void output(Point point){
        System.out.println("Searched point output:\n");
        System.out.println(point);
    }

}
