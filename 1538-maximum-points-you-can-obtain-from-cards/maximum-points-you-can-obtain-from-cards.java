class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int total = 0;

        for (int point : cardPoints) {
            total += point;
        }

        int windowSize = n - k;
        int minWindowSum = 0;
        for (int i = 0; i < windowSize; i++) {
            minWindowSum += cardPoints[i];
        }

        int currWindowSum = minWindowSum;
        for (int i = windowSize; i < n; i++) {
            currWindowSum += cardPoints[i] - cardPoints[i - windowSize];
            minWindowSum = Math.min(minWindowSum, currWindowSum);
        }
        return total - minWindowSum;
    }
}