package edu.umb.cs680.hw16;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

public class EuclideanTest {
    @Test
    public void verifyDefaultDistance() {
        List<Double> p1 = Arrays.asList(2.0,3.0);
        List<Double>  p2 = Arrays.asList(5.0,7.0);
        Double actual  = Distance.get(p1, p2);
        Double expected  = 5.0;
        assertNotNull(actual);
        assertEquals(expected, actual);

    }

    @Test
    public void verifyDefaultDistanceMetric() {
        List<Double> p1 = Arrays.asList(2.0,3.0);
        List<Double>  p2 = Arrays.asList(5.0,7.0);
        List<List<Double>> points = Arrays.asList(p1,p2);
        List<List<Double>> actual  = Distance.matrix(points);
        List<List<Double>> expected  = Arrays.asList(Arrays.asList(0.0,5.0),Arrays.asList(5.0,0.0));
        assertNotNull(actual);
        assertEquals(expected, actual);
    }


    @Test
    public void verifyDefaultDistanceMetricfor3DPoints() {
        List<Double> p1 = Arrays.asList(2.0,3.0,4.0);
        List<Double>  p2 = Arrays.asList(5.0,7.0,8.0);
        List<Double>  p3 = Arrays.asList(9.0,10.0,11.0);
        List<Double>  p4 = Arrays.asList(13.0,14.0,15.0);
        List<Double>  p5 = Arrays.asList(16.0,17.0,18.0);
        List<List<Double>> points = Arrays.asList(p1,p2,p3,p4,p5);
        List<List<Double>> actual  = Distance.matrix(points);
        List<List<Double>> expected  = Arrays.asList(Arrays.asList(0.0, 6.4031242374328485, 12.12435565298214, 19.05255888325765, 24.24871130596428),
                                                    Arrays.asList(6.4031242374328485, 0.0, 5.830951894845301, 12.727922061357855, 17.916472867168917),
                                                    Arrays.asList(12.12435565298214, 5.830951894845301, 0.0, 6.928203230275509, 12.12435565298214),
                                                    Arrays.asList(19.05255888325765, 12.727922061357855, 6.928203230275509, 0.0, 5.196152422706632),
                                                    Arrays.asList(24.24871130596428, 17.916472867168917, 12.12435565298214, 5.196152422706632, 0.0));
        assertNotNull(actual);
        assertEquals(expected, actual);
    }


}
