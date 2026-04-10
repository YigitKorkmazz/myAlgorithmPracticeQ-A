package greedy;

import java.util.Arrays;

public class BuyMaximumStocks {

    /**
     * You are given an array price[] of size n,
     * where price[i] is the price of a stock on the i-th day.
     * You have k units of money to spend, and you want to buy as many stocks as possible.
     * On each day, you can buy at most one stock,
     * and you can only buy a stock if you have enough money to pay for it.
     * Your task is to determine the maximum number of stocks you can buy with your available money.
     */
    
    static class stock{
        int day;
        int price;
        
        stock(int d, int p){
            day = d;
            price = p;
        }
    }
    
    // O(n log n) time complexity because of sorting, where n is the length of the price array.
    public static int buyMaximumProducts(int n, int k, int[] price) {
        stock[] stocks = new stock[n];
        for (int i = 0 ; i < n; i++){
            stocks[i] = new stock (i + 1, price[i]);
        }
        
        Arrays.sort(stocks, (a,b) -> Integer.compare(a.price, b.price));
        int totalBought = 0;
        int remainingMoney = k;
        
        for (int i = 0 ; i < n; i++){
            int amount = stocks[i].day;
            if ((stocks[i].price *  amount) > remainingMoney){
                while (amount > 0 && (stocks[i].price *  amount) > remainingMoney){
                    amount--;
                }
                
                if (amount > 0){
                    remainingMoney -= stocks[i].price *  amount;
                    totalBought += amount;
                }
                
                else 
                {
                    return totalBought;
                }
            }
            
            else
            {
                remainingMoney -= stocks[i].price *  amount;
                totalBought += amount;                
            }
            
        }
        
        return totalBought;
    }
}
