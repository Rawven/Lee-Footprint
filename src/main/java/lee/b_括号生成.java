package lee;

import java.util.ArrayList;
import java.util.List;

public class b_括号生成 {


    public List<String> generateParenthesis(int n) {
        ArrayList<String> strings = new ArrayList<>();
        tool(n, n, strings, "");
        return strings;
    }

    public void tool(int left, int right, List<String> list, String str) {
        if (left == 0 && right == 0) {
            list.add(str);
            return;
        }
        if(left<=right && left>0){
            tool(left - 1, right, list, str.concat("("));
        }
        if(left < right){
            tool(left, right - 1, list, str.concat(")"));
        }
    }


}
