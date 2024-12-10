# Average Function Testing

This project implements and tests an average function in Java. The function calculates the arithmetic mean of the first k elements of an array. If k exceeds the array length, it computes the average of the entire array. If the array is empty or k is 0, it returns 0. The project includes functional tests, partition tests, boundary value tests, and measures code coverage using JUnit and VSCode.

## a. Functional Description
The `average` function calculates the average of the first `k` elements in an array:
- If `k > array.length`, the average of the entire array is returned.
- If `k = 0` or the array is empty, it returns `0`.

## b. Functional Test Cases

| Test Case ID | Input | Expected Output | Description |
|--------------|-------|-----------------|-------------|
| TC1 | k = 3, list = {1, 2, 3, 4, 5} | 2 | Average of the first 3 elements. |
| TC2 | k = 10, list = {1, 2, 3, 4, 5} | 3 | Average of the entire array. |
| TC3 | k = 0, list = {1, 2, 3} | 0 | No elements to average. |
| TC4 | k = 5, list = {} | 0 | Empty array. |
| TC5 | k = 2, list = {-3, 3, 6} | 0 | Average of {-3, 3}. |

## c. Partition Test Cases

| Partition | Input | Expected Output | Description |
|-----------|-------|-----------------|-------------|
| No elements to average | k = 0, list = {1, 2, 3} | 0 | k = 0 results in no averaging. |
| Average of k elements (k < n) | k = 2, list = {4, 5, 6} | 4 | Average of the first 2 elements. |
| Average of the entire array (k >= n) | k = 5, list = {2, 2} | 2 | Covers case where k exceeds array size. |
| Empty array | k = 3, list = {} | 0 | Empty list results in 0. |
| Mixed positive and negative values | k = 3, list = {-3, 3, 9} | 3 | Average of mixed values. |

## d. Boundary Value Test Cases

| Test Case ID | Input | Expected Output | Description |
|--------------|-------|-----------------|-------------|
| BV1 | k = 0, list = {} | 0 | No elements in the array or to process. |
| BV2 | k = 1, list = {10} | 10 | Single element in the array. |
| BV3 | k = 3, list = {1, 2, 3} | 2 | Average of exactly k elements. |
| BV4 | k = 3, list = {-5, -5, -5} | -5 | Negative values only. |
| BV5 | k = 3, list = {10, 20, 30} | 20 | Boundary case for average of 3 values. |

## e. Implementation
Original Function:
```java
public int average(int k, int[] list) {
    int average = 0;
    int n = Math.min(k, list.length);
    if (n > 0) {
        for (int i = 0; i < n; i++) {
            average += list[i];
        }
        average = average / n;
    }
    return average;
}
```

## f. Compile and Run the Test Cases

### Initial Results
| Test Case ID | Status |
|--------------|--------|
| testAverageWithFirstKElements | Passed |
| testAverageWhenKExceedsArrayLength | Passed |
| testAverageWhenKIsZero | Passed |
| testAverageWithEmptyArray | Passed |
| testAverageWithNegativeAndPositiveValues | Passed |

### Fault Injection
```java
public int average(int k, int[] list) {
    int average = 0;
    int n = Math.min(k, list.length);
    if (n > 0) {
        for (int i = 1; i < n; i++) { // Fault injected: i = 1
            average += list[i];
        }
        average = average / n;
    }
    return average;
}
```

### Analysis of Failures
The fault caused the loop to skip the first element of the array, leading to incorrect averages in all scenarios where at least one element should be included. Specifically:
- The loop started at the second element (i = 1) instead of the first (i = 0)
- Test cases requiring the inclusion of the first element failed

| Test Case ID | Status |
|--------------|--------|
| testAverageWithFirstKElements | Fail |
| testAverageWhenKExceedsArrayLength | Fail |
| testAverageWhenKIsZero | Passed |
| testAverageWithEmptyArray | Passed |
| testAverageWithNegativeAndPositiveValues | Fail |

### Fix
```java
public int average(int k, int[] list) {
    int average = 0;
    int n = Math.min(k, list.length);
    if (n > 0) {
        for (int i = 0; i < n; i++) { // Fixed: i = 0
            average += list[i];
        }
        average = average / n;
    }
    return average;
}
```

### Test Results after Fix
| Test Case ID | Status |
|--------------|--------|
| testAverageWithFirstKElements | Passed |
| testAverageWhenKExceedsArrayLength | Passed |
| testAverageWhenKIsZero | Passed |
| testAverageWithEmptyArray | Passed |
| testAverageWithNegativeAndPositiveValues | Passed |

## g. Code Coverage
<img width="1728" alt="Screenshot 2024-12-09 at 11 55 18 PM" src="https://github.com/user-attachments/assets/2bd7295a-410a-44c7-b4a4-71b62fea4e94">
