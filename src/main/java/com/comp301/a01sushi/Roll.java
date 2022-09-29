package com.comp301.a01sushi;

import java.util.HashMap;

public class Roll implements Sushi {
  String name;
  IngredientPortion[] ingredientList;
  double calories;
  double cost;
  boolean rice;
  boolean shellfish;
  boolean vegetarian;
  SeaweedPortion seaweed;
  HashMap map;

  public Roll(String name, IngredientPortion[] roll_ingredients) {
    IngredientPortion seaweed = new SeaweedPortion(0.1);
    ingredientList = roll_ingredients.clone();
    // checking if parameters are valid
    // checking if roll_ingredients are valid
    for (int i = 0; i < roll_ingredients.length; i++) {
      if (roll_ingredients[i] == null) {
        throw new IllegalArgumentException("null ingredient");
      }
    }
    // checking if name is valid
    if (name == null) {
      throw new IllegalArgumentException("name cannot be null");
    }
    this.name = name;

    // using hashmap to find duplicates
    // private Map<String, IngredientPortion> map(IngredientPortion[] roll_ingredients, )<>();
    HashMap<String, IngredientPortion> map = new HashMap<>();
    for (IngredientPortion ip : roll_ingredients) {
      String ipname = ip.getName();
      if (!map.containsKey(ipname)) {
        map.put(ipname, ip);
      } else { // combine if it already exists
        IngredientPortion np = ip.combine(map.get(ipname));
        map.put(ipname, np);
      }
    }

    this.ingredientList = map.values().toArray(new IngredientPortion[0]);

    // adding seaweed if needed
    if (!map.containsKey("seaweed")) {
      IngredientPortion[] withSeaweed = new IngredientPortion[this.ingredientList.length + 1];
      for (int i = 0; i < this.ingredientList.length; i++) {
        withSeaweed[i] = this.ingredientList[i];
      }
      withSeaweed[this.ingredientList.length] = seaweed;
      this.ingredientList = withSeaweed;
    }
    if (map.containsKey("seaweed")) {
      if (map.get("seaweed").getAmount() < 0.1) {
        IngredientPortion additionalSeaweed =
            new SeaweedPortion(0.1 - map.get("seaweed").getAmount());
        IngredientPortion[] withSeaweed = new IngredientPortion[this.ingredientList.length];
        for (int i = 0; i < this.ingredientList.length; i++) {
          if (this.ingredientList[i].getName() == "seaweed") {
            this.ingredientList[i] = this.ingredientList[i].combine(additionalSeaweed);
          }
          withSeaweed[i] = this.ingredientList[i];
        }
        this.ingredientList = withSeaweed;
      }
    }
  }

  public String getName() {
    return name;
  }

  public IngredientPortion[] getIngredients() {
    return this.ingredientList;
  }

  public int getCalories() {
    for (int i = 0; i < this.ingredientList.length; i++) {
      this.calories += (this.ingredientList[i].getCalories());
    }
    return (int) Math.round(this.calories);
  }

  public double getCost() {
    for (int i = 0; i < this.ingredientList.length; i++) {
      this.cost += this.ingredientList[i].getCost();
    }
    // if you are supposed to add seaweed, add it here
    this.cost = Math.round(this.cost * 100.0) / 100.0;
    return this.cost;
  }

  public boolean getHasRice() {
    this.rice = false;
    for (int i = 0; i < this.ingredientList.length; i++) {
      if (this.ingredientList[i].getIsRice() == true) {
        this.rice = true;
      }
    }
    return this.rice;
  }

  public boolean getHasShellfish() {
    this.shellfish = false;
    for (int i = 0; i < this.ingredientList.length; i++) {
      if (this.ingredientList[i].getIsShellfish() == true) {
        this.shellfish = true;
      }
    }
    return this.shellfish;
  }

  public boolean getIsVegetarian() {
    this.vegetarian = false;
    for (int i = 0; i < this.ingredientList.length; i++) {
      if (this.ingredientList[i].getIsVegetarian() == true) {
        this.vegetarian = true;
      }
    }
    return this.vegetarian;
  }
}
