class Solution {
    public int countGoodSubstrings(String s) {
        int count = 0;

        int n = s.length();

        if(n < 3) return 0;

        for(int i = 0; i <= n-3; i++){
            char a = s.charAt(i);
            char b = s.charAt(i+1);
            char c = s.charAt(i+2);

            if(a !=b && b != c && c != a){
                count++;
            }
        }
        return count;
    }
}