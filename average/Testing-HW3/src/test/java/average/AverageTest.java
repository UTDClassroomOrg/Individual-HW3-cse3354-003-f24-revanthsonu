package average;

import static org.junit.Assert.*;
import org.junit.Test;

public class AverageTest {
    
    /*Functional test cases for the average function*/
    @Test
    public void testAverageFunctional() {
        Average avg = new Average();
        assertEquals(0, avg.average(0, new int[]{10, 10, 15})); // No elements to average
        assertEquals(0, avg.average(-1, new int[]{10, 20, 30, 40})); // Negative k
        assertEquals(2, avg.average(3, new int[]{1, 2, 3, 4, 5})); // Average of first 3
        assertEquals(15, avg.average(5, new int[]{10, 20})); // k > array length
    }
    
    /*Partition test cases for the average function*/
    @Test
    public void testPartitions() {
        Average avg = new Average();
        assertEquals(0, avg.average(0, new int[]{10, 15})); // k = 0
        assertEquals(0, avg.average(0, new int[]{1, 2, 3})); // k = 0
        assertEquals(20, avg.average(5, new int[]{10, 20, 30})); // k > array length
        assertEquals(10, avg.average(2, new int[]{5, 15, 15})); // k < array length
    }
    
    /*Boundary value test cases for the average function*/
    @Test
    public void testBoundaryValues() {
        Average avg = new Average();
        assertEquals(0, avg.average(0, new int[]{1, 2, 3})); // Minimum value of k
        assertEquals(2, avg.average(3, new int[]{1, 2, 3})); // k = array length
        assertEquals(15, avg.average(5, new int[]{10, 20})); // k > array length
    }
}