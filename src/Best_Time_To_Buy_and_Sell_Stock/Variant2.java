package Best_Time_To_Buy_and_Sell_Stock;

public class Variant2 {
    public static int maxProfit(int [] prices){
        int maxProfit = 0;
        for(int i = 1; i < prices.length; i++){
            if(prices[i] > prices[i-1]){
                maxProfit += prices[i] - prices[i-1];
            }
        }
        return maxProfit;
    }
    public static void main(String[] args) {
        int [] prices = {7, 1, 5, 3, 6, 4};
        Variant2 sol = new Variant2();

        System.out.println("Maximum Profit : " + sol.maxProfit(prices));
    }
}
