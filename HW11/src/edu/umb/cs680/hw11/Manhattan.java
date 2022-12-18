package edu.umb.cs680.hw11;

import java.util.List;

public class Manhattan implements DistanceMetric {

    @Override
    public Double distance(List<Double> p1, List<Double> p2) {
        // TODO Auto-generated method stub

        Double sum = (double) 0;

        // for each point, finding distance to
        // rest of the point
        for (int i = 0; i < p1.size(); i++) {
            sum = sum + (Math.abs(p1.get(i) - p2.get(i)));
        }
        return sum;
        // return (Math.abs(p1.get(0) - p2.get(0)) + Math.abs(p1.get(1) - p2.get(1)));
    }

}
