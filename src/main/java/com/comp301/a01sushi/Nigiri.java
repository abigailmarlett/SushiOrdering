package com.comp301.a01sushi;

public class Nigiri implements Sushi {
  private IngredientPortion nigiri;

  private IngredientPortion riceIngredient;

  public Nigiri(NigiriType type) {
    if (type == Nigiri.NigiriType.CRAB) {
      nigiri = new CrabPortion(0.75);
      riceIngredient = new RicePortion(0.5);
    }
    if (type == Nigiri.NigiriType.EEL) {
      nigiri = new EelPortion(0.75);
      riceIngredient = new RicePortion(0.5);
    }
    if (type == Nigiri.NigiriType.SHRIMP) {
      nigiri = new ShrimpPortion(0.75);
      riceIngredient = new RicePortion(0.5);
    }
    if (type == Nigiri.NigiriType.TUNA) {
      nigiri = new TunaPortion(0.75);
      riceIngredient = new RicePortion(0.5);
    }
    if (type == Nigiri.NigiriType.YELLOWTAIL) {
      nigiri = new YellowtailPortion(0.75);
      riceIngredient = new RicePortion(0.5);
    }
  }

  public String getName() {
    return (nigiri.getName() + " nigiri");
  }

  public IngredientPortion[] getIngredients() {
    return new IngredientPortion[] {nigiri, riceIngredient};
  }

  public int getCalories() {
    return (int) Math.round(nigiri.getCalories() + riceIngredient.getCalories());
  }

  public double getCost() {
    return Math.round((nigiri.getCost() + riceIngredient.getCost()) * 100.0) / 100.0;
  }

  public boolean getHasRice() {
    return nigiri.getIsRice();
  }

  public boolean getHasShellfish() {
    return nigiri.getIsShellfish();
  }

  public boolean getIsVegetarian() {
    return nigiri.getIsVegetarian();
  }

  public enum NigiriType {
    TUNA,
    YELLOWTAIL,
    EEL,
    CRAB,
    SHRIMP
  }
}
