package com.test.Easy;

import com.test.utils.PrintUtil;

import java.util.*;

public class L_811_SubdomainVisitCount {

    /*
        2019.04.16

        A website domain like "discuss.leetcode.com" consists of various subdomains.
        At the top level, we have "com", at the next level, we have "leetcode.com",
        and at the lowest level, "discuss.leetcode.com". When we visit a domain like
        "discuss.leetcode.com", we will also visit the parent domains "leetcode.com"
        and "com" implicitly.

        Now, call a "count-paired domain" to be a count (representing the number of
        visits this domain received), followed by a space, followed by the address.
        An example of a count-paired domain might be "9001 discuss.leetcode.com".

        We are given a list cpdomains of count-paired domains. We would like a list
        of count-paired domains, (in the same format as the input, and in any order),
        that explicitly counts the number of visits to each subdomain.

        Example 1:
                Input:
                    ["9001 discuss.leetcode.com"]
                Output:
                   ["9001 discuss.leetcode.com", "9001 leetcode.com", "9001 com"]
                Explanation:
                    We only have one website domain: "discuss.leetcode.com". As discussed
                    above, the subdomain "leetcode.com" and "com" will also be visited. So
                    they will all be visited 9001 times.

        Example 2:
            Input:
                ["900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"]
            Output:
                ["901 mail.com","50 yahoo.com","900 google.mail.com","5 wiki.org","5 org",
                "1 intel.mail.com","951 com"]
            Explanation:
                We will visit "google.mail.com" 900 times, "yahoo.com" 50 times,
                "intel.mail.com" once and "wiki.org" 5 times. For the subdomains,
                we will visit "mail.com" 900 + 1 = 901 times, "com" 900 + 50 + 1 =
                951 times, and "org" 5 times.

        Notes:
            The length of cpdomains will not exceed 100.
            The length of each domain name will not exceed 100.
            Each address will have either 1 or 2 "." characters.
            The input count in any count-paired domain will not exceed 10000.
            The answer output can be returned in any order.

["9001 com","9001 discuss.leetcode.com","9001 leetcode.com"]
["9001 com","9001 discuss.leetcode.com","9001 leetcode.com"]

     */


    public static void main(String[] args) {
        L_811_SubdomainVisitCount l = new L_811_SubdomainVisitCount();
        String[] strs1 = {"9001 discuss.leetcode.com"};
        PrintUtil.printList(l.subdomainVisits(strs1));
        String[] strs2 = {"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"};
        PrintUtil.printList(l.subdomainVisits(strs2));
    }

    public List<String> subdomainVisits(String[] cpdomains) {
        return subdomainVisits1(cpdomains);
    }

    // inspired by Discuss
    // replace split to indexOf will be fast
    public List<String> subdomainVisits2(String[] cpdomains) {
        List<String> list = new ArrayList<>();
        if (null != cpdomains && 0 < cpdomains.length) {
            Map<String, Integer>  map = new HashMap<>();
            for (String str : cpdomains) {
                int index = str.indexOf(' ');
                int times = Integer.parseInt(str.substring(0, index));
                String domain = str.substring(index + 1);

                if (map.containsKey(domain)) {
                    map.put(domain, map.get(domain) + times);
                } else {
                    map.put(domain, times);
                }
                while (0 < domain.indexOf(".")) {
                    domain = domain.substring(domain.indexOf(".") + 1);
                    if (map.containsKey(domain)) {
                        map.put(domain, map.get(domain) + times);
                    } else {
                        map.put(domain, times);
                    }
                }
            }
            Iterator<Map.Entry<String, Integer>> it = map.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<String, Integer> entry = it.next();
                list.add(entry.getValue() + " " + entry.getKey());
            }
        }
        return list;
    }

    public List<String> subdomainVisits1(String[] cpdomains) {
        List<String> list = new ArrayList<>();
        if (null != cpdomains && 0 < cpdomains.length) {
            Map<String, Integer>  map = new HashMap<>();
            for (String str : cpdomains) {
                String[] strs = str.split(" ");

                if (map.containsKey(strs[1])) {
                    map.put(strs[1], map.get(strs[1]) + Integer.parseInt(strs[0]));
                } else {
                    map.put(strs[1], Integer.parseInt(strs[0]));
                }
                String s = strs[1];
                while (0 < s.indexOf(".")) {
                    s = s.substring(s.indexOf(".") + 1);
                    if (map.containsKey(s)) {
                        map.put(s, map.get(s) + Integer.parseInt(strs[0]));
                    } else {
                        map.put(s, Integer.parseInt(strs[0]));
                    }
                }
            }
            Iterator<Map.Entry<String, Integer>> it = map.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<String, Integer> entry = it.next();
                list.add(entry.getValue() + " " + entry.getKey());
            }
        }
        return list;
    }

}
