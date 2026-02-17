package Bracket_Reversal;

public class Bracket_reversal {
    public static int bracketReversal(String s){
        if (s.length()%2 != 0) {
            return -1;
        }
        int i = 0; int j = 0;
        char[] st = s.toCharArray();
        for (int k = 0; k < st.length; k++) {
            if (st[k] == '(') {
                i++;
            } else{
                if (i>0) {
                    i--;
                } else {
                    j++;
                }
            }
        }
        int result = ((i+1)/2) + ((j+1)/2);
        return result;
    }
    public static void main(String[] args) {
        String s = ")(())(((";
        System.out.println(bracketReversal(s));
    }
}
