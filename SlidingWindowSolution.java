/* 
You are given an integer array prices where prices[i] is the price of NeetCoin on the ith day.
You may choose a single day to buy one NeetCoin and choose a different day in the 
future to sell it.Return the maximum profit you can achieve. 
You may choose to not make any transactions, in which case the profit would be 0. 
*/

// Dynamic sliding window

public class SlidingWindowSolution{
    public int maxProfit(int[] prices){
        int k = 2;
        
        //edge case: if the array has fewer elements than the window size
        if (prices == null || prices.length < k){
            throw new IllegalArgumentException("Invalid input: prices array is null or has fewer than k elements.");
        }

        int minPrice=Integer.MAX_VALUE;
        int maxProfit=0;

        for(int price : prices) {
            if(price < minPrice){
                minPrice=price;
            }else if(price - minPrice > maxProfit) {
                maxProfit = price - minPrice;
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] arr = {10,1,5,6,7,1};

        SlidingWindowSolution solution = new SlidingWindowSolution();
        int result = solution.maxProfit(arr);
        System.out.println(result);
        
    }
}


