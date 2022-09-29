package com.comp301.a01sushi;

public class IngredientImpl implements Ingredient {
  private final boolean vegetarian;
  private final boolean rice;
  private final boolean shellfish;
  private String name;
  private int calPerOunce;
  private double pricePerOunce;

  public IngredientImpl(
      String name,
      double pricePerOunce,
      int calPerOunce,
      boolean vegetarian,
      boolean rice,
      boolean shellfish) {

    // throw exceptions for invalid parameters
    if (name == null) {
      throw new IllegalArgumentException("Cannot add null.");
    }
    if (name != null) {
      this.name = name;
    }

    if (calPerOunce <= 0) {
      throw new IllegalArgumentException("Calories per ounce cannot be below 0.");
    }
    if (calPerOunce > 0) {
      this.calPerOunce = calPerOunce;
    }
    if (pricePerOunce < 0) {
      throw new IllegalArgumentException("Price per ounce cannot be below 0.");
    }
    if (pricePerOunce > 0) {
      this.pricePerOunce = pricePerOunce;
    }
    this.vegetarian = vegetarian;
    this.rice = rice;
    this.shellfish = shellfish;
  }

  // getters
  public String getName() {
    return name;
  }

  public double getCaloriesPerDollar() {
    return this.getCaloriesPerOunce() / this.getPricePerOunce();
  }

  public int getCaloriesPerOunce() {
    return calPerOunce;
  }

  public double getPricePerOunce() {
    return pricePerOunce;
  }

  public boolean getIsVegetarian() {
    return vegetarian;
  }

  public boolean getIsRice() {
    return rice;
  }

  public boolean getIsShellfish() {
    return shellfish;
  }

  public boolean equals(Ingredient other) {
    if (this.getIsRice() == other.getIsRice()) {
      if (this.getIsShellfish() == other.getIsShellfish()) {
        if (this.getPricePerOunce() - other.getPricePerOunce() < 0.01) {
          if (this.getIsVegetarian() == other.getIsVegetarian()) {
            if (this.getCaloriesPerOunce() == other.getCaloriesPerOunce()) {
              if (this.getCaloriesPerDollar() == other.getCaloriesPerDollar()) {
                return this.getName() == other.getName();
              }
            }
          }
        }
      }
    }
    return false;
  }
}
