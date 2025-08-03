import java.util.*;
import java.util.StringTokenizer;
class Solution {
    private static String[] operator = new String[]{"+-*", "+*-", "-+*", "-*+", "*+-", "*-+"};
    private void split(String expression, List<String> tokens){
        StringTokenizer st = new StringTokenizer(expression, "+-*", true);
        while(st.hasMoreTokens()){
            tokens.add(st.nextToken());
        }
    }
    
    private long calculate(long left, long right, String operator){
        switch (operator){
            case "+": return left + right;
            case "-": return left - right;
            case "*": return left * right;
        }
        return 0;
    }
    private long calculate(List<String> tokens, String op){
        for(char c : op.toCharArray()){
            for(int i = 0; i < tokens.size(); i++){
                if(tokens.get(i).equals(c + "")){
                    long left = Long.parseLong(tokens.get(i-1));
                    long right = Long.parseLong(tokens.get(i+1));
                    String result = Long.toString(calculate(left, right, c + ""));
                    for(int j = 0; j < 3; j++) tokens.remove(i-1);
                    tokens.add(i-1, result);
                    i = i-1;
                }
            }
        }

        return Math.abs(Long.parseLong(tokens.get(0)));
    }
    public long solution(String expression) {
        List<String> tokens = new LinkedList<>();
        split(expression, tokens);
        long max = 0;
        for(String op : operator){
            long tmp = calculate(new LinkedList<String>(tokens), op);
            if(max < tmp) max = tmp;           
        }
        return max;
    }
}