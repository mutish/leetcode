// (),{},[]
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;


public class validParenthesis {
    public boolean isValid(String s) {
        if (s == null){
            return false;
        }

        
        // define the hash map or dictionary
        Map<Character, Character> bracketPairs = new HashMap<>();
        bracketPairs.put(')', '(');
        bracketPairs.put('}','{');
        bracketPairs.put(']', '[');
        
        // stack to store the opening brackets
        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            if(bracketPairs.containsKey(currentChar)){  //t
                if(stack.isEmpty() || !stack.pop().equals(bracketPairs.get(currentChar))){
                    return false;
                }
            }else {

                stack.push(currentChar);
            }
            
        }
        return stack.isEmpty();
    }

    public static void main(String[] args){
        validParenthesis vp = new validParenthesis();
        String s = "()";
        String s2 = "({[]})";
        String s3 = "([)]";

        System.out.println(vp.isValid(s));
        System.out.println(vp.isValid(s2));
        System.out.println(vp.isValid(s3));
    }
}

