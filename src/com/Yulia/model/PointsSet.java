package com.Yulia.model;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

public class PointsSet extends HashSet<Point> {

    public void addPoint(Point point){
        this.add(point);
    }

    public void addPoint(){
        Point point = new Point();
        point.setX(Math.random()*50);
        point.setY(Math.random()*50);
        this.add(point);
    }



}
