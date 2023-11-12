public class b_N字形变换 {

    public static void main(String[] args) {
        convert("PAYPALISHIRING",3);
    }

    /**
     * 将一个给定字符串 s 根据给定的行数 numRows ，
     * 以从上往下、从左到右进行 Z 字形排列。
     * convert
     * 重在规律 一个周期 = 2numRows - 2
     * @param s       s
     * @param numRows num rows
     * @return {@link String}
     */
    public static String convert(String s, int numRows) {
         int round = numRows*2-2 , len = s.length();
         StringBuilder stringBuilder = new StringBuilder();
         int index=0,save;
        while (index<numRows){
            save = index;
            while (save<len) {
                stringBuilder.append(s.charAt(save));
                if(index != 0 && index != numRows -1) {
                    int check = save + round - 2 * (save % round);
                    if(check<len){
                        stringBuilder.append(s.charAt(check));
                    }
                }
                save += round;
            }
            index++;
        }
         return stringBuilder.toString();
    }
}
