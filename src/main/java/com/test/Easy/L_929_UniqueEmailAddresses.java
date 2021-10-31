package com.test.Easy;

import java.util.HashSet;

public class L_929_UniqueEmailAddresses {


    /*
        2019.03.21

        Every email consists of a local name and a domain name, separated
        by the @ sign.

        For example, in alice@leetcode.com, alice is the local name, and
        leetcode.com is the domain name.

        Besides lowercase letters, these emails may contain '.'s or '+'s.

        If you add periods ('.') between some characters in the local name
        part of an email address, mail sent there will be forwarded to the
        same address without dots in the local name.  For example, "alice.z@leetcode.com"
        and "alicez@leetcode.com" forward to the same email address.
        (Note that this rule does not apply for domain names.)

        If you add a plus ('+') in the local name, everything after the first
        plus sign will be ignored. This allows certain emails to be filtered,
        for example m.y+name@email.com will be forwarded to my@email.com.
        (Again, this rule does not apply for domain names.)

        It is possible to use both of these rules at the same time.

        Given a list of emails, we send one email to each address in the list.
        How many different addresses actually receive mails?

        Example 1:
            Input: ["test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com",
                "testemail+david@lee.tcode.com"]
            Output: 2
            Explanation: "testemail@leetcode.com" and "testemail@lee.tcode.com" actually receive mails
        Note:
            1 <= emails[i].length <= 100
            1 <= emails.length <= 100
            Each emails[i] contains exactly one '@' character.

     */


    public static void main(String[] args) {
        L_929_UniqueEmailAddresses l = new L_929_UniqueEmailAddresses();
        String[] strs = {"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"};
        System.out.println(strs[0] + ", " + strs[1] + ", " + strs[2]);
        System.out.println(l.numUniqueEmails(strs));
    }

    public int numUniqueEmails(String[] emails) {
        if (null != emails && emails.length > 0) {
            HashSet<String> set = new HashSet();
            for (int i = 0; i < emails.length; i++) {
                if (null != emails[i] && emails[i].length() > 0) {
                    String str = this.dealString4(emails[i]);
                    //System.out.println(str.hashCode());
                    set.add(str);
                }
            }
            //System.out.println(set);
            return set.size();
        }
        return 0;
    }



    /*
    * dealString1、dealString3 大同小异
    * dealString2 增加处理 连续出现 . 的情况，相对于 1、3 减少 copy 次数，不确定输入的数据是否存在这种类型的。。。。
    * dealString4 更好理解，效率也不错
    * */
    public String dealString4(String dest) {
        char[] chs = new char[dest.length()];
        int num = 0;
        for (int i = 0; i < dest.length(); i++) {
            if ('@' == dest.charAt(i)) {
                for (;i < dest.length();chs[num] = dest.charAt(i), ++num, ++i);
                break;
            } else if ('+' == dest.charAt(i)) {
                for (;'@' != dest.charAt(++i););
                --i;
                continue;
            } else if ('.' == dest.charAt(i)) {
                continue;
            } else {
                chs[num++] = dest.charAt(i);
            }
        }
        return new String(chs, 0, num);
    }

    public String dealString3(String dest) {
        char[] chs = dest.toCharArray();
        int num = chs.length;
        int src = 0;
        int des = 0;
        int d = 0;
        for (; '@' != chs[src];) {
            if ('+' == chs[src]) {
                des = src;
                ++d;
                ++src;
                for (; '@' != chs[src] ; ++src, ++d);
                break;
            } else if ('.' == chs[src]) {
                des = src;
                ++d;
                ++src;
                System.arraycopy(chs, src, chs, des, num - src);
            } else {
                ++src;
            }
        }
        System.arraycopy(chs, src, chs, des, num - src);
        return new String(chs, 0, num - d);
    }

    public String dealString2(String dest) {
        char[] chs = dest.toCharArray();
        int num = chs.length;
        int src = 0;
        int des = 0;
        int d = 0;
        for (src = 0; '@' != chs[src];) {
            if ('+' == chs[src]) {
                des = src;
                ++d;
                ++src;
                for (; '@' != chs[src] ; ++src, ++d);
                break;
            } else {
                boolean flag = false;
                int tmp = 0;
                des = src;
                for (; '.' == chs[src]; ++src, ++tmp, flag = true);
                if ('@' == chs[src]) {
                    break;
                } else if ('+' == chs[src]) {
                    ++d;
                    ++src;
                    for (; '@' != chs[src] ; ++src, ++d);
                    break;
                } else {
                    if (flag) {
                        System.arraycopy(chs, src, chs, des, num - src);
                        d += tmp;
                    } else {
                        ++src;
                    }
                }
            }
        }
        System.arraycopy(chs, src, chs, des, num - src);
        return new String(chs, 0, num - d);
    }

    public String dealString1(String dest) {
        char[] chs = dest.toCharArray();
        int num = chs.length;
        for (int i = 0; i < chs.length; i++) {
            if ('@' == chs[i]) {
                return new String(chs, 0, num);
            }
            if ('+' == chs[i]) {
                int f = 1;
                for (int j = i + 1; '@' != chs[j]; j++) {
                    ++f;
                }
                System.arraycopy(chs, i + f, chs, i, num - i - f);
                return new String(chs, 0, num - f);
            }
            if ('.' == chs[i]) {
                int d = 1;
                for (int j = i + 1; '.' == chs[j]; j++) {
                    ++d;
                }
                System.arraycopy(chs, i + d, chs, i, num - i - d);
                num -= d;
            }
        }
        return "";
    }
}
