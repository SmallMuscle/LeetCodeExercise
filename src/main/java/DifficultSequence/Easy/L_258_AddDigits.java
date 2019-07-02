package DifficultSequence.Easy;

public class L_258_AddDigits {

    /*
        Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.

        Example:

        Input: 38
        Output: 2
        Explanation: The process is like: 3 + 8 = 11, 1 + 1 = 2.
                     Since 2 has only one digit, return it.
        Follow up:
        Could you do it without any loop/recursion in O(1) runtime?

     */

    public static void main(String[] args) {
        L_258_AddDigits l = new L_258_AddDigits();
        int num = 38;
        System.out.println(l.addDigits(38));
    }

    public int addDigits(int num) {
        return addDigits1(num);
    }

    // 0    1	2	3	4	5	6	7	8	9	10	11	12	13	14	15	16	17	18	19	20	21	22	23	24	25	26	27	28	29	30	31	32	33	34	35	36	37	38	39	40	41	42	43	44	45	46	47	48	49	50	51	52	53	54	55	56	57	58	59	60	61	62	63	64	65	66	67	68	69	70	71	72	73	74	75	76	77	78	79	80	81
    // 0    1	2	3	4	5	6	7	8	9	1	2	3	4	5	6	7	8	9	1	2	3	4	5	6	7	8	9	1	2	3	4	5	6	7	8	9	1	2	3	4	5	6	7	8	9	1	2	3	4	5	6	7	8	9	1	2	3	4	5	6	7	8	9	1	2	3	4	5	6	7	8	9	1	2	3	4	5	6	7	8	9
    public int addDigits1(int num) {
        int n = num % 9;
        return num > 0 ? (n == 0 ? 9 : n) : 0;
    }

    // inspired by Discuss
    public int addDigits2(int num) {
        return num > 0 ? ((num - 1) % 9) + 1 : 0;
    }
}
