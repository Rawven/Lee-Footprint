package lee;

public class b_两数相除 {
    public static void main(String[] args) {
        divide(-2147483648,1);
    }


    /**
     * divide
     * 逆天负数运算 绝妙 位运算 牛逼
     * @param dividend dividend
     * @param divisor  divisor
     * @return int
     */
    public static int divide(int dividend, int divisor) {
        int result=0;
        boolean bool = (dividend >0)^(divisor>0);
        if( dividend>0){
            dividend*=-1;
        }
        if( divisor>0){
            divisor*=-1;
        }
        while (dividend<=divisor){
            int temp_result = -1;
            int temp_divisor = divisor;
            while (dividend <= temp_divisor <<1 ){
                if(temp_divisor <= Integer.MIN_VALUE >>1) {
                    break;
                }
                temp_result <<= 1;
                temp_divisor <<= 1;
            }
            dividend -= temp_divisor;
            result += temp_result;
        }
        if(!bool){
            if( result <=Integer.MIN_VALUE){
                return Integer.MIN_VALUE;
            }
            result = -result;
        }
        return result;
    }
}
