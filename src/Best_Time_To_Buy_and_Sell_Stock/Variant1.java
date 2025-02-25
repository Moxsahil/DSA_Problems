package Best_Time_To_Buy_and_Sell_Stock;

public class Variant1 {
    public static int maxProfit(int[] prices){
        int result = 0;
        int minProfit = prices[0];

        for(int i = 1; i < prices.length; i++){
            minProfit = Math.min(minProfit, prices[i]);

            result = Math.max(result, prices[i] - minProfit);
        }
        return result;
    }
    public static void main(String[] args) {
        int []prices = {7, 10, 1, 3, 6, 9, 2};
        System.out.println(maxProfit(prices));
    }
}
