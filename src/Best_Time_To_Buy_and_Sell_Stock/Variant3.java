package Best_Time_To_Buy_and_Sell_Stock;

public class Variant3 {
    public static int maxProfit(int [] prices){
        if(prices.length == 0 || prices == null){
            return 0;
        }

        int maxProfit = 0;
        int n = prices.length;
        int [] leftProfit = new int [n];
        int [] rightProfit = new int [n];

        int minPrice = prices[0];
        for(int i = 1; i < n; i++){
            leftProfit[i] = Math.max(leftProfit[i-1], prices[i] - minPrice );
            minPrice = Math.min(minPrice, prices[i]);
        }

        int maxPrice = prices[n-1];
        for(int i = n-2; i>=0; i--){
            rightProfit[i] = Math.max(rightProfit[i+1], maxPrice - prices[i]);
            maxPrice = Math.max(maxPrice, prices[i]);
        }

        for(int i=0; i<n; i++){
            maxProfit = Math.max(maxProfit, leftProfit[i] + rightProfit[i]);
        }

        return maxProfit;
    }
    public static void main(String[] args) {
        int [] prices = {3, 3, 5, 0, 0, 3, 1, 4};

        Variant3 sol = new Variant3();

        System.out.println("Maximum profit : " + sol.maxProfit(prices));
    }
}
