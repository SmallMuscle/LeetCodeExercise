package DifficultSequence.Easy;

import java.util.ArrayList;
import java.util.Stack;

public class L_682_BaseballGame {

    /*
        You're now a baseball game point recorder.

        Given a list of strings, each string can be one of the 4 following types:

        Integer (one round's score): Directly represents the number of points you
        get in this round.
        "+" (one round's score): Represents that the points you get in this round
        are the sum of the last two valid round's points.
        "D" (one round's score): Represents that the points you get in this round
        are the doubled data of the last valid round's points.
        "C" (an operation, which isn't a round's score): Represents the last valid
        round's points you get were invalid and should be removed.
        Each round's operation is permanent and could have an impact on the round
        before and the round after.

        You need to return the sum of the points you could get in all the rounds.

        Example 1:
            Input: ["5","2","C","D","+"]
            Output: 30
            Explanation:
            Round 1: You could get 5 points. The sum is: 5.
            Round 2: You could get 2 points. The sum is: 7.
            Operation 1: The round 2's data was invalid. The sum is: 5.
            Round 3: You could get 10 points (the round 2's data has been removed). The sum is: 15.
            Round 4: You could get 5 + 10 = 15 points. The sum is: 30.
        Example 2:
            Input: ["5","-2","4","C","D","9","+","+"]
            Output: 27
            Explanation:
            Round 1: You could get 5 points. The sum is: 5.
            Round 2: You could get -2 points. The sum is: 3.
            Round 3: You could get 4 points. The sum is: 7.
            Operation 1: The round 3's data is invalid. The sum is: 3.
            Round 4: You could get -4 points (the round 3's data has been removed). The sum is: -1.
            Round 5: You could get 9 points. The sum is: 8.
            Round 6: You could get -4 + 9 = 5 points. The sum is 13.
            Round 7: You could get 9 + 5 = 14 points. The sum is 27.

        Note:
        The size of the input list will be between 1 and 1000.
        Every integer represented in the list will be between -30000 and 30000.

     */

    public static void main(String[] args) {
        L_682_BaseballGame l = new L_682_BaseballGame();
        String[] ops1 = {"5","2","C","D","+"};
        System.out.println(l.calPoints(ops1));
        String[] ops2 = {"5","-2","4","C","D","9","+","+"};
        System.out.println(l.calPoints(ops2));
    }

    public int calPoints(String[] ops) {
        return calPoints3(ops);
    }

    // inspired by Discuss
    public int calPoints3(String[] ops) {
        int[] opsi = new int[ops.length];
        int first = 0;
        int second = 0;
        for (int i = 0; i < ops.length; i++) {
            String str = ops[i];
            if ('C' == str.charAt(0)) {
                opsi[i] = 55555;
                opsi[second] = 55555;
                second = first;
                --first;
                while (0 < first && 55555 == opsi[first]) --first;
            } else if ('D' == str.charAt(0)) {
                opsi[i] = opsi[second] << 1;
            } else if ('+' ==  str.charAt(0)) {
                opsi[i] = opsi[first] + opsi[second];
            } else {
                opsi[i] = Integer.parseInt(str);
            }
            if ('C' != str.charAt(0)) {
                first = second;
                second = i;
            }
        }
        int result = 0;
        for (int score : opsi) {
            if (55555 != score) result += score;
        }
        return result;
    }

    public int calPoints2(String[] ops) {
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> list = new ArrayList<>(1);
        list.add(1);
        for (String str : ops) {
            if ('C' == str.charAt(0)) {
                stack.pop();
            } else if ('D' == str.charAt(0)) {
                stack.push(stack.peek() << 1);
            } else if ('+' == str.charAt(0)) {
                stack.push(stack.get(stack.size() - 2) + stack.peek());
            } else {
                stack.push(Integer.parseInt(str));
            }
        }
        int result = 0;
        while (!stack.isEmpty()) result += stack.pop();
        return result;
    }


    public int calPoints1(String[] ops) {
        Stack<Integer> stack = new Stack<>();
        for (String str : ops) {
            if ("C".equals(str)) {
                stack.pop();
            } else if ("D".equals(str)) {
                stack.push(stack.peek() + stack.peek());
            } else if ("+".equals(str)) {
                stack.push(stack.get(stack.size() - 2) + stack.peek());
            } else {
                stack.push(Integer.parseInt(str));
            }
        }
        int result = 0;
        while (!stack.isEmpty()) result += stack.pop();
        return result;
    }

}
