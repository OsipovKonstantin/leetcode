package org.example.java;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

//    https://leetcode.com/problems/design-a-food-rating-system
//    Design a food rating system that can do the following:
//
//    Modify the rating of a food item listed in the system.
//    Return the highest-rated food item for a type of cuisine in the system.
//    Implement the FoodRatings class:
//
//    FoodRatings(String[] foods, String[] cuisines, int[] ratings) Initializes the system. The food items are described by
//     foods, cuisines and ratings, all of which have a length of n.
//    foods[i] is the name of the ith food,
//    cuisines[i] is the type of cuisine of the ith food, and
//    ratings[i] is the initial rating of the ith food.
//    void changeRating(String food, int newRating) Changes the rating of the food item with the name food.
//    String highestRated(String cuisine) Returns the name of the food item that has the highest rating for the given type
//     of cuisine. If there is a tie, return the item with the lexicographically smaller name.
//    Note that a string x is lexicographically smaller than string y if x comes before y in dictionary order, that is,
//     either x is a prefix of y, or if i is the first position such that x[i] != y[i], then x[i] comes before y[i] in
//     alphabetic order.
//
//    Example 1:
//
//    Input
//    ["FoodRatings", "highestRated", "highestRated", "changeRating", "highestRated", "changeRating", "highestRated"]
//    [[["kimchi", "miso", "sushi", "moussaka", "ramen", "bulgogi"], ["korean", "japanese", "japanese", "greek", "japanese",
//     "korean"],
//     [9, 12, 8, 15, 14, 7]], ["korean"], ["japanese"], ["sushi", 16], ["japanese"], ["ramen", 16], ["japanese"]]
//    Output
//    [null, "kimchi", "ramen", null, "sushi", null, "ramen"]
//
//    Explanation
//    FoodRatings foodRatings = new FoodRatings(["kimchi", "miso", "sushi", "moussaka", "ramen", "bulgogi"], ["korean", "japanese", "japanese", "greek", "japanese", "korean"], [9, 12, 8, 15, 14, 7]);
//    foodRatings.highestRated("korean"); // return "kimchi"
//                                        // "kimchi" is the highest rated korean food with a rating of 9.
//    foodRatings.highestRated("japanese"); // return "ramen"
//                                          // "ramen" is the highest rated japanese food with a rating of 14.
//    foodRatings.changeRating("sushi", 16); // "sushi" now has a rating of 16.
//    foodRatings.highestRated("japanese"); // return "sushi"
//                                          // "sushi" is the highest rated japanese food with a rating of 16.
//    foodRatings.changeRating("ramen", 16); // "ramen" now has a rating of 16.
//    foodRatings.highestRated("japanese"); // return "ramen"
//                                          // Both "sushi" and "ramen" have a rating of 16.
//                                          // However, "ramen" is lexicographically smaller than "sushi".
public class SolutionDay7FoodRatings {
    private final Map<String, Integer> foodRatingMap;
    private final Map<String, String> foodCuisineMap;
    private final Map<String, PriorityQueue<Food>> cuisineFoodMap;

    public SolutionDay7FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        foodRatingMap = new HashMap<>();
        foodCuisineMap = new HashMap<>();
        cuisineFoodMap = new HashMap<>();

        for (int i = 0; i < foods.length; ++i) {
            foodRatingMap.put(foods[i], ratings[i]);
            foodCuisineMap.put(foods[i], cuisines[i]);
            cuisineFoodMap.computeIfAbsent(cuisines[i], k -> new PriorityQueue<>()).add(new Food(foods[i], ratings[i]));
        }
    }

    public void changeRating(String food, int newRating) {
        foodRatingMap.put(food, newRating);
        String cuisine = foodCuisineMap.get(food);
        cuisineFoodMap.get(cuisine).add(new Food(food, newRating));
    }

    public String highestRated(String cuisine) {
        Food highestRated = cuisineFoodMap.get(cuisine).peek();

        while (!foodRatingMap.get(highestRated.getFoodName()).equals(highestRated.getFoodRating())) {
            cuisineFoodMap.get(cuisine).poll();
            highestRated = cuisineFoodMap.get(cuisine).peek();
        }
        return highestRated.getFoodName();
    }
}

@Getter
@AllArgsConstructor
class Food implements Comparable<Food> {
    private String foodName;
    private int foodRating;

    @Override
    public int compareTo(Food otherFood) {
        if (foodRating == otherFood.foodRating) {
            return foodName.compareTo(otherFood.foodName);
        }
        return -1 * Integer.compare(foodRating, otherFood.foodRating);
    }
}
