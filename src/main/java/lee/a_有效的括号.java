package lee;

import java.util.HashMap;
import java.util.Stack;

public class a_有效的括号 {


    /**
     * is valid
     * easy way
     * @param s s
     * @return boolean
     */
    public boolean isValid(String s) {
        if(s.isEmpty()||s.length()%2!=0){
            return false;
        }
        Stack<Character> stack = new Stack<>();
        HashMap<Character, Character> map = new HashMap<>();
        map.put(')','(');map.put('}','{');map.put(']','[');
        int index = 0;
        while (index < s.length()){
            char c = s.charAt(index);
            switch (c){
                case '(':
                case '{':
                case '[':
                    stack.push(c);
                    break;
                case ')':
                case '}':
                case ']':
                    if(!stack.isEmpty()) {
                        Character pop = stack.pop();
                        if (!pop.equals(map.get(c))) {
                            return false;
                        }
                    }else {
                        return false;
                    }
                    break;
                default:
            }
            index++;
        }
        if(stack.isEmpty()){
            return true;
        }else {
            return false;
        }
    }
}
