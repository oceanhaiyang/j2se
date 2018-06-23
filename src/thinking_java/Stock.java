package thinking_java;

public class Stock {
    public static void main(String[] args){
        Solution03 solution03 = new Solution03();
        int prices[]={3,3,5,0,0,3,1,4};
        System.out.println(solution03.maxProfit(prices));
    }
}
class Solution03{
    public int maxProfit(int[] prices) {
        int sell1 = 0, sell2 = 0, buy1 = Integer.MIN_VALUE, buy2 = Integer.MIN_VALUE;
        for (int i = 0; i < prices.length; i++) {
            buy1 = Math.max(buy1, -prices[i]);
            sell1 = Math.max(sell1, buy1 + prices[i]);
            buy2 = Math.max(buy2, sell1 - prices[i]);
            sell2 = Math.max(sell2, buy2 + prices[i]);
        }
        return sell2;
    }
}