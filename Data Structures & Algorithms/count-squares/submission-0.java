class CountSquares {
    // Nested map: X coordinate -> (Y coordinate -> frequency count)
    private final Map<Integer, Map<Integer, Integer>> pointMap;

    public CountSquares() {
        this.pointMap = new HashMap<>();
    }

    public void add(int[] point) {
        int x = point[0];
        int y = point[1];

        // Compute if absent initializes the inner map if the X coordinate hasn't been seen yet
        pointMap.putIfAbsent(x, new HashMap<>());
        Map<Integer, Integer> yCounts = pointMap.get(x);
        yCounts.put(y, yCounts.getOrDefault(y, 0) + 1);
    }

    public int count(int[] point) {
        int x1 = point[0];
        int y1 = point[1];
        int totalSquares = 0;

        // If there are no points sharing the same X coordinate as our query, no square can be
        // formed
        if (!pointMap.containsKey(x1)) {
            return 0;
        }

        // Strategy: Look for points on the SAME vertical line (same X) to act as a side of the
        // square This instantly filters down our search space significantly!
        for (int y2 : pointMap.get(x1).keySet()) {
            // Skip the query point itself
            if (y2 == y1) {
                continue;
            }

            // Calculate side length of the potential square
            int sideLength = Math.abs(y1 - y2);

            // A square can be formed either to the right (+sideLength) or to the left (-sideLength)
            int[] potentialX3s = {x1 + sideLength, x1 - sideLength};

            for (int x3 : potentialX3s) {
                // Check if the other X coordinate even exists in our map
                if (pointMap.containsKey(x3)) {
                    Map<Integer, Integer> x3YCounts = pointMap.get(x3);

                    // We need both the diagonal corner (x3, y2) and the remaining corner (x3, y1)
                    if (x3YCounts.containsKey(y2) && x3YCounts.containsKey(y1)) {
                        int p2Count = pointMap.get(x1).get(y2); // Point (x1, y2)
                        int p3Count = x3YCounts.get(y2); // Point (x3, y2)
                        int p4Count = x3YCounts.get(y1); // Point (x3, y1)

                        totalSquares += p2Count * p3Count * p4Count;
                    }
                }
            }
        }

        return totalSquares;
    }
    }
