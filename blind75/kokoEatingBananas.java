package blind75;

public class kokoEatingBananas {
    /*
        * Koko loves to eat bananas. There are n piles of bananas, the i-th pile has piles[i] bananas.
        * The guards have gone and will come back in h hours.
        * Koko can decide her bananas-per-hour eating speed of k.
        * Each hour, she chooses some pile of bananas and eats k bananas from that pile.
        * If the pile has less than k bananas, she eats all of them instead and will not eat any more bananas during that hour.
        * Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.
        * Return the minimum integer k such that she can eat all the bananas within h hours.
     */
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = 1000000000;
        while (left < right){
            int mid = left + (right - left) / 2;
            if (canEatAll(piles, h, mid)){
                right = mid;
            }
            else{
                left = mid + 1;
            }
        }
        return left;
    }

    public boolean canEatAll(int[] piles, int h, int k){
        int hours = 0;
        for (int pile : piles){
            hours += (pile + k - 1) / k; // This is equivalent to Math.ceil(pile / (double) k)
        }
        return hours <= h;
    }
}
