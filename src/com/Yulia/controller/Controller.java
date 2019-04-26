package com.Yulia.controller;

import com.Yulia.model.Point;
import com.Yulia.model.PointsSet;
import com.Yulia.modelProcessing.PointsSetHandler;
import com.Yulia.view.View;

public class Controller {
    private PointsSet mySet;
    private View view;

    public Controller(PointsSet mySet) {
        this.mySet = mySet;
        view = new View();
    }
    public Controller() {
        mySet = new PointsSet();
        view = new View();
    }

    public void do_smth(){
        PointsSetHandler pointsSetHandler = new PointsSetHandler(mySet);
        int generatedNumOfPoints = 5 + (int)(Math.random()*25);
        pointsSetHandler.addPointsToHashSet(generatedNumOfPoints);
        view.output(mySet);
        Point myPoint = pointsSetHandler.searchPoint();
        System.out.println("\n\n\n");
        view.output(myPoint);
    }


}
