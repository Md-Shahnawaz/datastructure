package com.test.amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

// CLASS BEGINS, THIS CLASS IS REQUIRED
public class Solution {
    public static void main(String[] args) {

        Solution s = new Solution();
        System.out.println(s.popularNFeatures(6, 2,
            Arrays.asList("storage", "battery", "hover", "alexa", "waterproof", "solar"), 7,
            Arrays.asList("I wish my Kindle had even more storage!",
            "I wish the battery life on my Kindle lasted 2 years.",
            "I read in the bath and would enjoy a waterproof kindle" ,
            "Waterproof and increased battery are my top 2 requests.",
            "I want to take my Kindle into the shower. Waterproof please waterproof!",
            "It would be neat if my Kindle would hover on my desk when not in use.",
            "How cool would it be if my Kindle charged in the sun via solar panel?"
        )));

    }

    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    public ArrayList<String> popularNFeatures(
        int numFeatures,
        int topFeatures,
        List<String> possibleFeatures,
        int numFeatureRequests,
        List<String> featureRequests) {
        Map<String, Integer> token_map = new HashMap<>();
        Map<String, String> copy_map = new HashMap<>();
        possibleFeatures.forEach(value -> {
            copy_map.put(value.toLowerCase(), value);
            token_map.put(value.toLowerCase(), 0);
        });

        featureRequests.forEach(text -> {
            String[] tokens = text.split("\\W+");
            Arrays.asList(tokens).forEach(token -> {
                Integer count = token_map.get(token.toLowerCase());
                if (Objects.nonNull(token_map.get(token.toLowerCase()))) {
                    token_map.put(token.toLowerCase(), ++count);
                }
            });
        });

        return (ArrayList<String>) token_map.entrySet()
            .stream()
            .filter(entry -> entry.getValue() > 0)
            .sorted(Comparator.comparingInt(entry -> ((Map.Entry<String, Integer>)entry).getValue()).reversed())
            .limit(topFeatures)
            .map(Map.Entry::getKey)
            .collect(Collectors.toList()).stream().map(copy_map::get).collect(Collectors.toList());

    }
    // METHOD SIGNATURE ENDS

//    public ArrayList<String> popularNFeatures(
//        int numFeatures,
//        int topFeatures,
//        List<String> possibleFeatures,
//        int numFeatureRequests,
//        List<String> featureRequests) {
//
//
//        if(numFeatures <= 0 || topFeatures <= 0) return new ArrayList<>();
//
//        Map<String, Integer> token_map = new HashMap<>(numFeatures);
//        possibleFeatures.forEach(value -> token_map.put(value, 0));
//
//        featureRequests.forEach(text -> {
//            for(Map.Entry<String, Integer> token : token_map.entrySet()){
//                if (text.contains(token.getKey())) {
//                    Integer value = token.getValue();
//                    token_map.put(token.getKey(), ++value);
//                }
//            }
//        });
//
//        return (ArrayList<String>) token_map.entrySet()
//            .stream()
//            .filter(entry -> entry.getValue() > 0)
//            .sorted(Comparator.comparingInt(entry -> ((Map.Entry<String, Integer>) entry).getValue()).reversed())
//            .limit(topFeatures > 0 ? topFeatures : 0)
//            .map(Map.Entry::getKey)
//            .collect(Collectors.toList());
//
//    }
}
