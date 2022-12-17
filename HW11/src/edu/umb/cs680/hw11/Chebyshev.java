package edu.umb.cs680.hw11;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Chebyshev implements DistanceMetric {

    @Override
    public Double distance(List<Double> p1, List<Double> p2) {
        // TODO Auto-generated method stub
        List<Double> DistanceList = new ArrayList<Double>();

        for (int i = 0; i < p1.size(); i++) {
            DistanceList.add(i, Math.abs(p1.get(0) - p2.get(0)));
        }
        Collections.sort(DistanceList);
        return DistanceList.get(DistanceList.size() - 1);
    }

}
