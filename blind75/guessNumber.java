package blind75;

public class guessNumber {
    /**
     * We are playing the Guess Game. The game is as follows:
     * I pick a number from 1 to n. You have to guess which number I
     * picked. Every time you guess wrong, I will tell you whether the number I picked is higher or lower than your guess.
     * You call a pre-defined API int guess(int num), which returns three possible results:
     * -1: Your guess is higher than the number I picked (i.e. num
     *  > pick).
     * 1: Your guess is lower than the number I picked (i.e. num
     *  < pick).
     * 0: your guess is equal to the number I picked (i.e. num
     *  == pick).
     * Return the number that I picked.
     * O (log n) time complexity and O(1) space complexity.
     */
    public int guessNumber(int n) {
        int res = 0;
        int g = -1;
        int top = n;
        int bot = 0;
        do{
            g = bot + (top - bot)/ 2;
            res = guess(g);
            if (res == -1){
                top = bot + (top - bot) / 2;
            }
            else if (res == 1){
                bot = (bot + (top - bot) / 2) + 1;
            }

        } while(res != 0);

        return g;
    }
}
