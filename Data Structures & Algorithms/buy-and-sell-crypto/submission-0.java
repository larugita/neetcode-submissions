class Solution {
    public int maxProfit(int[] prices) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int num : prices){
            map.put(num,0);
        }

        for(int buy = 0; buy < prices.length; buy++){
            for(int sell = buy+1; sell < prices.length; sell++){
                int profit = prices[sell] - prices[buy];
                if(profit > map.get(prices[buy])) map.put(prices[buy], profit);
            }
        }
        
        int max1 = 0;

        for(int val : map.values()){
            if(val > max1) max1 = val;
        }
        return max1;
    }
}
