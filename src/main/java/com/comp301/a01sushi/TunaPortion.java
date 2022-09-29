package com.comp301.a01sushi;

public class TunaPortion extends IngredientPortionImpl {
  private final double amount;

  public TunaPortion(double amount) {
    super(new Tuna(), amount);
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
