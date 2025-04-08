package Guess_Number_lower_or_higher;

 class GuessGame {
    private int pick;

    public GuessGame(int pick) {
        this.pick = pick;
    }

    public int guess(int num) {
        if (num > pick) return -1;
        else if (num < pick) return 1;
        else return 0;
    }
}
public class Solution extends GuessGame {
    public Solution(int pick) {
        super(pick);
    }

    public int guessNumber(int n) {
        int low = 1, high = n;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int result = guess(mid);

            if (result == 0) return mid;
            else if (result < 0) high = mid - 1;
            else low = mid + 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int n = 10;
        int pickedNumber = 6;

        Solution game = new Solution(pickedNumber);
        int result = game.guessNumber(n);
        System.out.println("Guessed number is: " + result);
    }
}



