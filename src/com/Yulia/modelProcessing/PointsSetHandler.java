package com.Yulia.modelProcessing;

import com.Yulia.model.Point;
import com.Yulia.model.PointsSet;

public class PointsSetHandler {
    private PointsSet points;

    public PointsSetHandler(PointsSet points) {
        this.points = points;
    }

    public Point searchPoint(){
        double[] points = new double[this.points.size()];
        int i = 0;
        for (Point point: this.points) {
            if(i>points.length/2)
                break;
            int j = 0;
            for (Point newpoint: this.points){
                if (newpoint!=point){
                    double distance = countDistanceTo(point,newpoint);
                    points[i]+= distance;
                    points[j]+=distance;
                }
                j++;
            }
            i++;
        }

        double min = 10000000;
        int idx = -1;
        for(i = 0; i < points.length; i++){
            if(points[i]<=min){
                min = points[i];
                idx = i;
            }
        }
        return (Point) this.points.toArray()[idx];
    }

    private static double countDistanceTo(Point point1, Point point2){
        double num = (Math.sqrt(
                Math.pow(point1.getX()-point2.getX(),2)+Math.pow(point1.getY()-point2.getY(),2)));
        return num;
    }

    public void addPointsToHashSet(int numberOfPoints){
        for(int i = 0; i < numberOfPoints; i++){
            points.addPoint();
        }
    }
}
