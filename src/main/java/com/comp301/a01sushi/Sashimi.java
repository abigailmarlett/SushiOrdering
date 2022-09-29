package com.comp301.a01sushi;

public class Sashimi implements Sushi {
  private IngredientPortion sashimi;

  public Sashimi(SashimiType type) {
    if (type == SashimiType.CRAB) {
      sashimi = new CrabPortion(0.75);
    }
    if (type == SashimiType.EEL) {
      sashimi = new EelPortion(0.75);
    }
    if (type == SashimiType.SHRIMP) {
      sashimi = new ShrimpPortion(0.75);
    }
    if (type == SashimiType.TUNA) {
      sashimi = new TunaPortion(0.75);
    }
    if (type == SashimiType.YELLOWTAIL) {
      sashimi = new YellowtailPortion(0.75);
    }
  }

  // getters
  public String getName() {
    return (sashimi.getName() + " sashimi");
  }

  public IngredientPortion[] getIngredients() {
    return new IngredientPortion[] {sashimi};
  }

  public int getCalories() {
    return (int) Math.round(sashimi.getCalories());
  }

  public double getCost() {
    return sashimi.getCost();
  }

  public boolean getHasRice() {
    return sashimi.getIsRice();
  }

  public boolean getHasShellfish() {
    return sashimi.getIsShellfish();
  }

  public boolean getIsVegetarian() {
    return sashimi.getIsVegetarian();
  }

  public enum SashimiType {
    TUNA,
    YELLOWTAIL,
    EEL,
    CRAB,
    SHRIMP
  }
}
