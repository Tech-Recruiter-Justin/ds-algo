package net.justinchoi.dsalgo.graph;

import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SellerNetworkTest {
    Map<String, List<String>> sellerNetwork = new HashMap<>();

    @Before
    public void setup() {
        sellerNetwork.put("you", new ArrayList<>(Arrays.asList("alice", "bob", "claire")));
        sellerNetwork.put("bob", new ArrayList<>(Arrays.asList("anuj", "peggy")));
        sellerNetwork.put("alice", new ArrayList<>(Arrays.asList("peggy")));
        sellerNetwork.put("claire", new ArrayList<>(Arrays.asList("thom", "jonny")));
        sellerNetwork.put("anuj", new ArrayList<>());
        sellerNetwork.put("peggy", new ArrayList<>());
        sellerNetwork.put("thom", new ArrayList<>());
        sellerNetwork.put("jonny", new ArrayList<>());
    }

    @Test
    public void findNearestDegreeSeller_NearestSellerIsThom_ReturnsThom() {
        String result = SellerNetwork.findNearestDegreeSeller(sellerNetwork);
        assertEquals("thom", result);
    }

}
