package POJ;

import utils.StringUtil;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Poj_1001_Exponentiation {

    /*
        Description
            Problems involving the computation of exact values of very large magnitude
            and precision are common. For example, the computation of the national debt
            is a taxing experience for many computer systems.

            This problem requires that you write a program to compute the exact value
            of Rn where R is a real number ( 0.0 < R < 99.999 ) and n is an integer such
            that 0 < n <= 25.
        Input
            The input will consist of a set of pairs of values for R and n. The R value
            will occupy columns 1 through 6, and the n value will be in columns 8 and 9.
        Output
            The output will consist of one line for each line of input giving the exact
            value of R^n. Leading zeros should be suppressed in the output. Insignificant
            trailing zeros must not be printed. Don't print the decimal point if the
            result is an integer.
        Sample Input
            95.123 12
            0.4321 20
            5.1234 15
            6.7592  9
            98.999 10
            1.0100 12
        Sample Output

            548815620517731830194541.899025343415715973535967221869852721
            548815620517731830194541.899025343415715973535967221869852721
            .00000005148554641076956121994511276767154838481760200726351203835429763013462401
            .00000005148554641076956121994511276767154838481760200726351203835429763013462401
            43992025569.928573701266488041146654993318703707511666295476720493953024
            43992025569.928573701266488041146654993318703707511666295476720493953024
            29448126.764121021618164430206909037173276672
            29448126.764121021618164430206909037173276672
            90429072743629540498.107596019456651774561044010001
            90429072743629540498.107596019456651774561044010001
            1.126825030131969720661201
            1.126825030131969720661201
     */


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String num = null;
        Integer e = null;
        while (!scanner.hasNext("x")) {
            num = scanner.next();
            e = scanner.nextInt();
            System.out.println(pow(num, e));
        }
    }



    private static final Map<Integer, byte[]> resultMap = new HashMap<Integer, byte[]>(128);
    private static final byte zero = '0';
    private static final Poj_1001_Exponentiation p = new Poj_1001_Exponentiation();

    private static String pow(String num, Integer e) {
        resultMap.clear();
        Num n = p.new Num(num);
        calculatePow(n.getBytes(), e);
        return getResult(n, e);
    }

    private static String getResult(Num base, int e) {
        int start, end, dest;
        byte[] result = resultMap.get(e);
        if (base.havePoint) {
            for (start = 0; start < result.length && '0' == result[start]; ++start);
            for (end = result.length - 1; end >= start && '0' == result[end]; --end);
            dest = start + result.length - end - 1;
            int pointBits = base.pointBit * e;
            int strLen = end - start + 1;
            if (pointBits > result.length) {
                byte[] tmp = new byte[pointBits + 1];
                resetArray(tmp, 1, tmp.length - 1);
                System.arraycopy(tmp, tmp.length - strLen, result, start, strLen);
                tmp[0] = '.';
                start = 0;
                end = pointBits;
                result = tmp;
            } else {
                System.arraycopy(result, start, result, dest, strLen);
                resetArray(result, start, dest - start);
                int pointIndex = result.length - pointBits - 1;
                System.arraycopy(result, 1, result, 0, pointIndex);
                result[pointIndex] = '.';
                if (start <= pointIndex) --start;
                else start = pointIndex;
                end = result.length - 1;
            }
            return new String(result, start, end - start + 1);
        } else {
            for (start = 0; start < result.length && '0' == result[start]; ++start);
            return start == result.length ? "0" : new String(result, start, result.length - start);
        }
    }

    class Num {

        private String origin;
        private boolean havePoint = false;
        private int pointBit;
        private int pointIndex;
        private byte[] intt;
        private int start;
        private int end;

        public Num() {}

        public Num(String origin) {
            this.origin = origin;

            recordMateData();
        }

        private void recordMateData() {
            intt = origin.getBytes();
            boolean flag = false;
            // check float tail
            // locate end, pointIndex
            for (int i = intt.length - 1; i >= 0; --i) {
                if (!flag && '0' != intt[i] && '.' != intt[i]) {
                    flag = true;
                    end = i;
                }
                if ('.' == intt[i]) {
                    havePoint = flag;
                    pointIndex = i;
                    if (havePoint) {
                        pointBit = end - i;
                    } else {
                        end = i - 1;
                    }
                    break;
                }
            }
            // have point, not must float
            // locate start
            if (0 != pointIndex) {
                for (start = 0; start < pointIndex && '0' == intt[start]; ++start) ;
                if (havePoint) {
                    for (end = intt.length - 1; end > pointIndex && '0' == intt[end]; --end) ;
                    if (start == pointIndex) ++start;
                    else System.arraycopy(intt, start, intt, ++start, pointIndex - start + 1);
                } else {
                    end = pointIndex - 1;
                }
                int desc = start + intt.length - end -1;
                System.arraycopy(intt, start, intt, desc, end - start + 1);
                resetArray(intt, 0, desc);
            }
        }

        public byte[] getBytes() {
            return intt;
        }
    }

    private static void calculatePow(byte[] num, int e) {
        if (0 == e) {
            if (null == resultMap.get(0)) {
                resultMap.put(e, new byte[]{'1'});
            }
            return ;
        }
        if (1 == e) {
            if (null == resultMap.get(1)) {
                resultMap.put(e, num);
            }
            return ;
        }
        if (isZero(num) || isOne(num)) {
            resultMap.put(e, num);
            return ;
        }
        if (null == resultMap.get(e)) {
            int tmp1 = e / 2;
            int tmp2 = e - tmp1;
            calculatePow(num, tmp1);
            calculatePow(num, tmp2);
            resultMap.put(e, calculateMultiply(resultMap.get(tmp1), resultMap.get(tmp2)));
        }
    }

    private static byte[] calculateMultiply(byte[] num1, byte[] num2) {
        byte[] result = new byte[num1.length + num2.length];
        byte[] tmp = new byte[result.length];
        boolean flag = true;
        byte carry = 0;
        int rstIndex;
        byte a,b;
        for (int i = num2.length - 1; i >= 0; --i) {
            rstIndex = tmp.length + i - num2.length;
            a = (byte)(num2[i] - zero);
            resetArray(tmp, 0, tmp.length);
            for (int j = num1.length - 1; j >= -1 ; --j) {
                if (-1 == j) {
                    tmp[rstIndex] = (byte)(carry + zero);
                    carry = 0;
                } else {
                    b = (byte)(num1[j] - zero);
                    byte t = (byte)(a * b + carry);
                    tmp[rstIndex] = (byte)((t % 10) + zero);
                    carry = (byte)(t / 10);
                    --rstIndex;
                }
            }
            if (flag) {
                flag = false;
                System.arraycopy(tmp, 0, result, 0, tmp.length);
            } else {
                result = calculatePlus(result, tmp);
            }
        }
        return result;
    }

    private static byte[] calculatePlus(byte[] num1, byte[] num2) {
        byte carry = 0;
        byte tmp;
        int j = num2.length - 1;
        if (num1.length <= num2.length) {
            byte[] t = new byte[num2.length + 1];
            System.arraycopy(num1, 0, t, t.length - num1.length, num1.length);
            resetArray(t, 0, t.length - num1.length);
            num1 = t;
        }
        for (int i = num1.length - 1; i >= 0; --i) {
            if (j >= 0) {
                byte a = (byte) (num1[i] - zero);
                byte b = (byte)(num2[j--] - zero);
                tmp = (byte)(a + b + carry);
                num1[i] = (byte)((tmp % 10) + zero);
                carry = (byte)(tmp / 10);
            } else if (0 != carry) {
                byte a = (byte) (num1[i] - zero);
                tmp = (byte)(a + carry);
                num1[i] = (byte)((tmp % 10) + zero);
                carry = 0;
            }
        }
        return num1;
    }

    private static boolean isOne(byte[] num) {
        for (int i = num.length - 2; i >= 0; --i) {
            if ('0' != num[i]) return false;
        }
        return '1' == num[num.length - 1];
    }

    private static boolean isZero(byte[] num) {
        for (int i = 0; i < num.length; i++) {
            if ('0' != num[i]) return false;
        }
        return true;
    }

    private static void resetArray(byte[] array, int start, int len) {
        if (validRange(start, 0, array.length - 1)) {
            for (int i = start; i < len && validRange(i, 0, array.length - 1); i++) {
                array[i] = '0';
            }
        }
    }

    private static boolean validRange(int index, int start, int end) {
        return index >= start && index <= end;
    }


    /*

     private static final Map<Integer, byte[]> resultMap = new HashMap<Integer, byte[]>(128);

    private static final Poj_1001_Exponentiation p = new Poj_1001_Exponentiation();

    private static String pow(String num, Integer e) {
        resultMap.clear();
        Num n = p.new Num(num);
        calculatePow(n.getBytes(), e);
        return getResult(n, e);
    }

    private static String getResult(Num base, int e) {
        int start, end, dest;
        byte[] result = resultMap.get(e);
        if (base.havePoint) {
            for (start = 0; start < result.length && '0' == result[start]; ++start);
            for (end = result.length - 1; end >= start && '0' == result[end]; --end);
            dest = start + result.length - end - 1;
            int pointBits = base.pointBit * e;
            int strLen = end - start + 1;
            if (pointBits > result.length) {
                byte[] tmp = new byte[pointBits + 1];
                resetArray(tmp, 1, tmp.length - 1);
                System.arraycopy(tmp, tmp.length - strLen, result, start, strLen);
                tmp[0] = '.';
                start = 0;
                end = pointBits;
                result = tmp;
            } else {
                System.arraycopy(result, start, result, dest, strLen);
                resetArray(result, start, dest - start);
                int pointIndex = result.length - pointBits - 1;
                System.arraycopy(result, 1, result, 0, pointIndex);
                result[pointIndex] = '.';
                if (start <= pointIndex) --start;
                else start = pointIndex;
                end = result.length - 1;
            }
            return new String(result, start, end - start + 1);
        } else {
            for (start = 0; start < result.length && '0' == result[start]; ++start);
            return start == result.length ? "0" : new String(result, start, result.length - start);
        }
    }

    class Num {

        private String origin;
        private boolean havePoint = false;
        private int pointBit;
        private int pointIndex;
        private byte[] intt;
        private int start;
        private int end;

        public Num() {}

        public Num(String origin) {
            this.origin = origin;

            recordMateData();
        }

        private void recordMateData() {
            intt = origin.getBytes();
            boolean flag = false;
            // check float tail
            // locate end, pointIndex
            for (int i = intt.length - 1; i >= 0; --i) {
                if (!flag && '0' != intt[i] && '.' != intt[i]) {
                    flag = true;
                    end = i;
                }
                if ('.' == intt[i]) {
                    havePoint = flag;
                    pointIndex = i;
                    if (havePoint) {
                        pointBit = end - i;
                    } else {
                        end = i - 1;
                    }
                    break;
                }
            }
            // have point, not must float
            // locate start
            if (0 != pointIndex) {
                for (start = 0; start < pointIndex && '0' == intt[start]; ++start) ;
                if (havePoint) {
                    for (end = intt.length - 1; end > pointIndex && '0' == intt[end]; --end) ;
                    if (start == pointIndex) ++start;
                    else System.arraycopy(intt, start, intt, ++start, pointIndex - start + 1);
                } else {
                    end = pointIndex - 1;
                }
                int desc = start + intt.length - end -1;
                System.arraycopy(intt, start, intt, desc, end - start + 1);
                resetArray(intt, 0, desc);
            }
        }

        public byte[] getBytes() {
            return intt;
        }
    }

    private static void calculatePow(byte[] num, int e) {
        if (0 == e) {
            if (null == resultMap.get(0)) {
                resultMap.put(e, new byte[]{'1'});
            }
            return ;
        }
        if (1 == e) {
            if (null == resultMap.get(1)) {
                resultMap.put(e, num);
            }
            return ;
        }
        if (isZero(num) || isOne(num)) {
            resultMap.put(e, num);
            return ;
        }
        if (null == resultMap.get(e)) {
            int tmp1 = e / 2;
            int tmp2 = e - tmp1;
            calculatePow(num, tmp1);
            calculatePow(num, tmp2);
            resultMap.put(e, calculateMultiply(resultMap.get(tmp1), resultMap.get(tmp2)));
        }
    }

    private static byte[] calculateMultiply(byte[] num1, byte[] num2) {
        byte[] result = new byte[num1.length + num2.length];
        byte[] tmp = new byte[result.length];
        boolean flag = true;
        byte carry = 0;
        int rstIndex;
        byte a,b;
        for (int i = num2.length - 1; i >= 0; --i) {
            rstIndex = result.length + i - num2.length;
            a = (byte)(num2[i] - '0');
            resetArray(tmp, 0, tmp.length);
            for (int j = num1.length - 1; j >= -1 ; --j) {
                if (-1 == j) {
                    tmp[rstIndex] = (byte)(carry + '0');
                } else {
                    b = (byte)(num1[j] - '0');
                    byte t = (byte)(a * b + carry);
                    tmp[rstIndex] = (byte)((t % 10) + '0');
                    carry = (byte)(t / 10);
                    --rstIndex;
                }
            }
            if (flag) {
                flag = false;
                System.arraycopy(tmp, 0, result, 0, tmp.length);
            } else {
                calculatePlus(result, tmp);
            }
        }
        return result;
    }

    private static void calculatePlus(byte[] num1, byte[] num2) {
        byte carry = 0;
        byte tmp;
        for (int i = num1.length - 1; i >= 0; --i) {
            byte a = (byte) (num1[i] - '0');
            byte b = (byte)(num2[i] - '0');
            tmp = (byte)(a + b + carry);
            num1[i] = (byte)((tmp % 10) + '0');
            carry = (byte)(tmp / 10);
        }
    }

    private static boolean isOne(byte[] num) {
        for (int i = num.length - 2; i >= 0; --i) {
            if ('0' != num[i]) return false;
        }
        return '1' == num[num.length - 1];
    }

    private static boolean isZero(byte[] num) {
        for (int i = 0; i < num.length; i++) {
            if ('0' != num[i]) return false;
        }
        return true;
    }

    private static void resetArray(byte[] array, int start, int len) {
        if (validRange(start, 0, array.length - 1)) {
            for (int i = start; i < len && validRange(i, 0, array.length - 1); i++) {
                array[i] = '0';
            }
        }
    }

    private static boolean validRange(int index, int start, int end) {
        return index >= start && index <= end;
    }



     */


/*

    private static String pow(String num, Integer e) {
        int pointBit = 0;
        boolean havePoint = false;
        StringBuilder n = new StringBuilder(num);
        havePoint = removeExtraZero(n);
        if (havePoint) {
            pointBit = getPointBit(n);
            removePoint(n, pointBit);
            removeFrontExtraZero(n, n.length());
            pointBit *= e;
            calculatePow(n, e);
            fixPoint(n, pointBit);
        } else {
            calculatePow(n, e);
        }
        return n.toString();
    }

    private static void fixPoint(StringBuilder num, int pointBit) {
        if (0 == pointBit) return;
        int interval = 1;
        if (num.length() > pointBit) {
            num.insert(num.length() - pointBit, '.');
        } else {
            int len = pointBit - num.length() + interval;
            StringBuilder tmp = new StringBuilder(len);
            tmp.append(".");
            for (int i = interval; i < len; i++) {
                tmp.append('0');
            }
            num.insert(0, tmp);
        }
        removeExtraZero(num);
    }

    private static void calculatePow(StringBuilder num, int e) {
        if (0 == e) {
            num.delete(0, num.length());
            num.append('1');
        } else if (!num.equals('0')) {
            String base = num.toString();
            for (int i = 1; i < e; i++) {
                calculateMultiply(num, base);
            }
        }
    }

    private static void calculateMultiply(StringBuilder num, String base) {
        char carry = '0';
        StringBuilder rst = new StringBuilder(2);
        int resultLen = num.length() + base.length();
        StringBuilder first = new StringBuilder(resultLen);
        StringBuilder second = new StringBuilder(resultLen);
        int firstIndex;
        for (int i = base.length() - 1; i >= 0; --i) {
            firstIndex = resultLen - (base.length() - 1 - i) - 1;
            resetStringBuilder(first, resultLen);
            int a = base.charAt(i) - '0';
            int b;
            for (int j = num.length() - 1; j >= -1; --j) {
                if (j == -1) {
                    first.setCharAt(firstIndex, carry);
                    carry = '0';
                } else {
                    b = num.charAt(j) - '0';
                    rst.delete(0, rst.length());
                    rst.append(a * b + (carry - '0'));
                    if (2 == rst.length()) {
                        carry = rst.charAt(0);
                        first.setCharAt(firstIndex, rst.charAt(1));
                    } else {
                        carry = '0';
                        first.setCharAt(firstIndex, rst.charAt(0));
                    }
                    --firstIndex;
                }
            }
            if (0 == second.length()) {
                second.append(first);
            } else {
                calculatePlus(second, first);
            }
        }
        num.delete(0, num.length());
        removeFrontExtraZero(second, second.length());
        if (0 == second.length()) second.append('0');
        num.append(second);
    }

    private static void calculatePlus(StringBuilder result, StringBuilder num) {
        char carry = '0';
        StringBuilder rst = new StringBuilder(2);
        for (int i = result.length() - 1; i >= 0; --i) {
            int a = result.charAt(i) - '0';
            int b = num.charAt(i) - '0';
            rst.delete(0, rst.length());
            rst.append(a + b + (carry - '0'));
            if (2 == rst.length()) {
                carry = rst.charAt(0);
                result.setCharAt(i, rst.charAt(1));
            } else {
                carry = '0';
                result.setCharAt(i, rst.charAt(0));
            }
        }
    }

    private static void resetStringBuilder(StringBuilder num, int len) {
        int numLen = num.length();
        for (int i = 0; i < len; i++) {
            if (i > numLen - 1) {
                num.append('0');
            } else {
                num.setCharAt(i, '0');
            }
        }
    }

    private static void removePoint(StringBuilder num, int pointBit) {
        num.deleteCharAt(num.length() - pointBit - 1);
    }

    private static int getPointBit(StringBuilder num) {
        for (int i = 1; i < num.length(); i++) {
            if (num.charAt(i) == '.') return num.length() - i - 1;
        }
        return 0;
    }

    private static boolean removeExtraZero(StringBuilder num) {
        boolean havePoint = false;
        int pointIndex = 0;
        for (int i = 0; i < num.length(); i++) {
            if ('.' == num.charAt(i)) {
                pointIndex = i;
                havePoint = true;
                break;
            }
        }
        if (havePoint) {
            removeBehindExtraZero(num, pointIndex);
            removeFrontExtraZero(num, pointIndex - 1);
        } else {
            removeFrontExtraZero(num, num.length());
        }
        return havePoint;
    }

    private static void removeFrontExtraZero(StringBuilder num, int len) {
        int index;
        for (index = 0; index < len && '0' == num.charAt(index); ++index) ;
        num.delete(0, index);
        if (0 == num.length()) num.append('0');
    }

    private static void removeBehindExtraZero(StringBuilder num, int pointIndex) {
        int index;
        for (index = num.length() - 1; index > pointIndex && '0' == num.charAt(index); --index);
        num.delete(index + 1, num.length());
    }
*/

}
