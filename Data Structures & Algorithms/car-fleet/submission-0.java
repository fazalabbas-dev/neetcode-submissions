
public class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        if (n == 0) return 0;

        // Combine position and speed into a 2D array for easy sorting
        double[][] cars = new double[n][2];
        for (int i = 0; i < n; i++) {
            cars[i][0] = position[i];
            // Pre-calculate arrival time to avoid repeating division
            cars[i][1] = (double) (target - position[i]) / speed[i];
        }

        // Sort cars by starting position in descending order (closest to target first)
        Arrays.sort(cars, (a, b) -> Double.compare(b[0], a[0]));

        int fleets = 0;
        double currentFleetTime = 0.0;

        // Iterate through the sorted cars
        for (int i = 0; i < n; i++) {
            double arrivalTime = cars[i][1];

            // If this car takes MORE time than the current fleet ahead,
            // it cannot catch up. It starts a brand new fleet.
            if (arrivalTime > currentFleetTime) {
                fleets++;
                currentFleetTime = arrivalTime; // This car is now the leader of the new fleet
            }
            // If arrivalTime <= currentFleetTime, it catches up and merges into the existing fleet
        }

        return fleets;
    }
}