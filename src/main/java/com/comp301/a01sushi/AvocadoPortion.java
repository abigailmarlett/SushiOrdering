package com.comp301.a01sushi;

public class AvocadoPortion extends IngredientPortionImpl {
  public AvocadoPortion(double amount) {
    super(new Avocado(), amount);
  }

  @Override
  public IngredientPortion combine(IngredientPortion other) {
    if (other == null) {
      return this;
    }

    if (!other.getIngredient().equals(this.getIngredient())) {
      throw new IllegalArgumentException("Ingredients are not the same");
    } else {
      return new AvocadoPortion(other.getAmount() + this.getAmount());
    }
  }
}
