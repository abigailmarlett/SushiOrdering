package com.comp301.a01sushi;

public class Main {
  public static void main(String[] args) {
    // System.out.print("Hello, world");
    IngredientPortion ing1 = new AvocadoPortion(0.25);
    IngredientPortion ing2 = new AvocadoPortion(0.25);
    IngredientPortion ing3 = new SeaweedPortion(0.25);
    IngredientPortion[] ing = new IngredientPortion[3];
    ing[0] = ing1;
    ing[1] = ing2;
    ing[2] = ing3;
    Roll one = new Roll("roll", ing);
    System.out.print(one.getCalories());
  }
}
