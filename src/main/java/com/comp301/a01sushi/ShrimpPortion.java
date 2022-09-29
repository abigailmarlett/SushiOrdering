package com.comp301.a01sushi;

public class ShrimpPortion extends IngredientPortionImpl {
  private final double amount;

  public ShrimpPortion(double amount) {
    super(new Shrimp(), amount);
    this.amount = amount;
  }

  public IngredientPortion combine(IngredientPortion other) {
    if (other.getIngredient().equals(this.getIngredient())) {
      double amountsum = other.getAmount() + amount;
      IngredientPortion combined = new IngredientPortionImpl(this.getIngredient(), amountsum);
      return combined;
    } else {
      throw new IllegalArgumentException("Ingredients are not the same");
    }
  }
}
