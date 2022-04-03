package net.justinchoi.dsalgo.graph;

import java.util.*;

public class SellerNetwork {
    // BFS
    public static String findNearestDegreeSeller(Map<String, List<String>> sellerNetwork) {
        Queue<String> potentialSellers = new ArrayDeque<>();
        List<String> checked = new ArrayList<>();
        String seller;
        potentialSellers.addAll(sellerNetwork.get("you"));
        while (!potentialSellers.isEmpty()) {
            seller = potentialSellers.poll();
            if (checked.contains(seller)) { continue; }
            if (seller.charAt(seller.length() - 1) == 'm') {
                return seller;
            } else {
                checked.add(seller);
                potentialSellers.addAll(sellerNetwork.get(seller));
            }
        }
        return "no seller";
    }
}
