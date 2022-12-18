
package edu.umb.cs680.hw16;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;

public class ChebyshevTest {
    @Test
    public void verifyChebyshevDistance() {
        List<Double> p1 = Arrays.asList(2.0, 3.0);
        List<Double> p2 = Arrays.asList(5.0, 7.0);
        Double actual = Distance.get(p1, p2, (List<Double> q1, List<Double> q2) -> {
            List<Double> DistanceList = new ArrayList<Double>();
            for (int i = 0; i < q1.size(); i++) {
                DistanceList.add(i, Math.abs(q1.get(0) - q2.get(0)));
            }
            Collections.sort(DistanceList);
            return DistanceList.get(DistanceList.size() - 1);
        });
        Double expected = 3.0;
        assertNotNull(actual);
        assertEquals(expected, actual);

    }

    @Test
    public void verifyChebyshevDistanceMetric() {
        List<Double> p1 = Arrays.asList(2.0, 3.0);
        List<Double> p2 = Arrays.asList(5.0, 7.0);
        List<List<Double>> points = Arrays.asList(p1, p2);
        List<List<Double>> actual = Distance.matrix(points, (List<Double> q1, List<Double> q2) -> {
            List<Double> DistanceList = new ArrayList<Double>();
            for (int i = 0; i < q1.size(); i++) {
                DistanceList.add(i, Math.abs(q1.get(0) - q2.get(0)));
            }
            Collections.sort(DistanceList);
            return DistanceList.get(DistanceList.size() - 1);
        });
        List<List<Double>> expected = Arrays.asList(Arrays.asList(0.0, 3.0), Arrays.asList(3.0, 0.0));
        assertNotNull(actual);
        assertEquals(expected, actual);
    }

    @Test
    public void verifyChebyshevDistanceMetricfor3DPoints() {
        List<Double> p1 = Arrays.asList(2.0, 3.0, 4.0);
        List<Double> p2 = Arrays.asList(5.0, 7.0, 8.0);
        List<Double> p3 = Arrays.asList(9.0, 10.0, 11.0);
        List<Double> p4 = Arrays.asList(13.0, 14.0, 15.0);
        List<Double> p5 = Arrays.asList(16.0, 17.0, 18.0);
        List<List<Double>> points = Arrays.asList(p1, p2, p3, p4, p5);
        List<List<Double>> actual = Distance.matrix(points, (List<Double> q1, List<Double> q2) -> {
            List<Double> DistanceList = new ArrayList<Double>();
            for (int i = 0; i < q1.size(); i++) {
                DistanceList.add(i, Math.abs(q1.get(0) - q2.get(0)));
            }
            Collections.sort(DistanceList);
            return DistanceList.get(DistanceList.size() - 1);
        });
        List<List<Double>> expected = Arrays.asList(Arrays.asList(0.0, 3.0, 7.0, 11.0, 14.0),
                Arrays.asList(3.0, 0.0, 4.0, 8.0, 11.0),
                Arrays.asList(7.0, 4.0, 0.0, 4.0, 7.0),
                Arrays.asList(11.0, 8.0, 4.0, 0.0, 3.0),
                Arrays.asList(14.0, 11.0, 7.0, 3.0, 0.0));
        assertNotNull(actual);
        assertEquals(expected, actual);
    }
}
