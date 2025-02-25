package Valid_Parenthesis;

import java.util.Stack;

public class Solution {
    public static boolean isValid(String s){
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < s.length(); i++){
            char C = s.charAt(i);

            switch (C){
                case '(' :
                    stack.push(')');
                    break;

                case '{' :
                    stack.push('}');
                    break;

                case '[':
                    stack.push(']');
                    break;

                case ']':
                case '}':
                case ')':
                    if(stack.isEmpty() || stack.pop() != C){
                        return false;
                    }
                    break;

                default:
                    return false;
            }
        }
        return stack.isEmpty();
    }
    public static void main(String[] args) {
        String s = "()[]{}";

        System.out.println(isValid(s));
    }
}
