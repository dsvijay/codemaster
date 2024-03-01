package com.leet.codemaster.medium;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SubDomainVisits {

    public static void main(String[] argz) {
        String[] cpdomains = {"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org","1110 kdd.znq.us","1137 ujs.qzi.co","817 htq.co"};
        Map<String, Integer> stats = new HashMap<String, Integer>();
        System.out.println("Input Count :: " + cpdomains.length);

        for (String domain : cpdomains) {
            // fetch the count and full domain
            String[] domainValues = domain.split(" ");
            int numberOfVisits = Integer.valueOf(domainValues[0]);
            String address = domainValues[1];
            if (stats.containsKey(address)) {
                stats.put(address, stats.get(address) + numberOfVisits);
            } else {
                stats.put(address, numberOfVisits);
            }

            // mail.google.com
            String[] subDomains = address.split("");
            for (int index = subDomains.length - 1; index >= 0; index--) {
                if (subDomains[index].equals(".")) {
                    //sub domain end to index of "."
                    String subDomain = address.substring(index + 1, subDomains.length);

                    // check if present in map then increase number of visit else add with given number of visits
                    if (stats.containsKey(subDomain)) {
                        int subDomainVisits = stats.get(subDomain) + numberOfVisits;
                        stats.put(subDomain, subDomainVisits);
                    } else {
                        stats.put(subDomain, numberOfVisits);
                    }
                }
            }

        }

        List<String> statsResult = stats.entrySet().stream().map(entry -> entry.getValue() + " " + entry.getKey()).collect(Collectors.toList());
        System.out.println("output :: " + statsResult.size());
        System.out.println(statsResult);
    }
}
