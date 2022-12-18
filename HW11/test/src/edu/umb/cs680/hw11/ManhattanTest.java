
package edu.umb.cs680.hw11;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

public class ManhattanTest {
    @Test
    public void verifyManhattanDistance() {
        List<Double> p1 = Arrays.asList(2.0,3.0);
        List<Double>  p2 = Arrays.asList(5.0,7.0);
        Double actual  = Distance.get(p1, p2, new Manhattan());
        Double expected  = 7.0;
        assertNotNull(actual);
        assertEquals(expected, actual);

    }

    @Test
    public void verifyManhattanDistanceMetric() {
        List<Double> p1 = Arrays.asList(2.0,3.0);
        List<Double>  p2 = Arrays.asList(5.0,7.0);
        List<List<Double>> points = Arrays.asList(p1,p2);
        List<List<Double>> actual  = Distance.matrix(points, new Manhattan());
        List<List<Double>> expected  = Arrays.asList(Arrays.asList(0.0,7.0),Arrays.asList(7.0,0.0));
        assertNotNull(actual);
        assertEquals(expected, actual);
    }

    @Test
    public void verifyManhattanDistanceMetricfor3DPoints() {
        List<Double> p1 = Arrays.asList(2.0,3.0,4.0);
        List<Double>  p2 = Arrays.asList(5.0,7.0,8.0);
        List<Double>  p3 = Arrays.asList(9.0,10.0,11.0);
        List<Double>  p4 = Arrays.asList(13.0,14.0,15.0);
        List<Double>  p5 = Arrays.asList(16.0,17.0,18.0);
        List<List<Double>> points = Arrays.asList(p1,p2,p3,p4,p5);
        List<List<Double>> actual  =  Distance.matrix(points, new Manhattan());
        List<List<Double>> expected  = Arrays.asList(Arrays.asList(0.0, 11.0, 21.0, 33.0, 42.0),
                                                    Arrays.asList(11.0, 0.0, 10.0, 22.0, 31.0),
                                                    Arrays.asList(21.0, 10.0, 0.0, 12.0, 21.0),
                                                    Arrays.asList(33.0, 22.0, 12.0, 0.0, 9.0),
                                                    Arrays.asList(42.0, 31.0, 21.0, 9.0, 0.0));
        assertNotNull(actual);
        assertEquals(expected, actual);
    }
}
