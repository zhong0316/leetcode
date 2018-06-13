package org.whuims.leetcode.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ShoppingOffers {

    public static void main(String[] args) {
        List<Integer> price = Arrays.asList(2, 5);
        List<Integer> needs = Arrays.asList(3, 2);
        List<List<Integer>> special = new ArrayList<>();
        special.add(Arrays.asList(3, 0, 5));
        special.add(Arrays.asList(1, 2, 10));
        ShoppingOffers shoppingOffers = new ShoppingOffers();
        int res = shoppingOffers.shoppingOffers(price, special, needs);
        System.out.println(res);
    }

    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        if (price == null || price.size() == 0 || needs == null || needs.size() == 0) {
            return 0;
        }
        if (!price.stream().filter(r -> r != 0).findAny().isPresent() ||
                !needs.stream().filter(r -> r != 0).findAny().isPresent()) {
            return 0;
        }
        int n = price.size();
        List<List<Integer>> spCans = getSpCandidate(special, needs);
        // 如果没有special offer，则直接计算总价
        if (spCans.size() == 0) {
            int res = 0;
            for (int i = 0; i < n; i++) {
                if (needs.get(i) > 0) {
                    res += needs.get(i) * price.get(i);
                }
            }
            return res;
        } else {
            // 有special offer可以使用，backtracking计算总价，选取最小的
            int resMin = Integer.MAX_VALUE;
            for (List<Integer> spOffer : spCans) {
                int sum = spOffer.get(n);
                List<Integer> newNeeds = new ArrayList<>();
                for (int i = 0; i < n; i++) {
                    newNeeds.add(needs.get(i) - spOffer.get(i));
                }
                sum += shoppingOffers(price, spCans, newNeeds);
                resMin = Math.min(resMin, sum);
            }
            return resMin;
        }
    }

    private List<List<Integer>> getSpCandidate(List<List<Integer>> special, List<Integer> needs) {
        final int n = needs.size();
        return special.stream().filter(r -> {
            boolean res = true;
            for (int i = 0; i < n; i++) {
                res = res && r.get(i) <= needs.get(i);
            }
            return res;
        }).collect(Collectors.toList());
    }
}
