package org.example.lee.题目.其它;

public class b_整数转罗马数字 {


    /**
     * 罗马数字包含以下七种字符： I， V， X， L，C，D 和 M。
     *
     * 字符          数值
     * I             1
     * V             5
     * X             10
     * L             50
     * C             100
     * D             500
     * M             1000
     * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
     * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，
     * 所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
     * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
     * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。
     * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
     * int to roman
     *boring
     * @param num num
     * @return {@link String}
     */
    public static String intToRoman(int num) {
        Character roma[] = new Character[]{'I', 'V', 'X', 'L', 'C', 'D', 'M'};
        StringBuilder stringBuilder = new StringBuilder();
        int test = 0, a = 1000,index=6;
        while (index >= 0) {
            test = num;
            test /= a;
            num %= a;
            //TODO 这个if语句看题目要求加
            if(index < roma.length) {
                if (test == 9 || test == 4) {
                    stringBuilder.append(roma[index]).append(roma[index + 1+test%2]);
                } else{
                    if(test >4) {
                        stringBuilder.append(roma[index + 1]);
                        test -= 5;
                    }
                    while (test > 0) {
                        stringBuilder.append(roma[index]);
                        test--;
                    }
                }
                a/=10;
                index-=2;
            }
        }
        return stringBuilder.toString();
    }
}
