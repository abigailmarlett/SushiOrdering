package com.comp301.a01sushi;

public class IngredientPortionImpl implements IngredientPortion {
  private final Ingredient ingredient;
  private final double amount;

  public IngredientPortionImpl(Ingredient ingredient, double amount) {
    this.ingredient = ingredient;
    if (amount < 0) {
      throw new IllegalArgumentException("Amount is less than 0.");
    }

    this.amount = amount;
  }

  public Ingredient getIngredient() {
    return ingredient;
  }

  public double getAmount() {
    return this.amount;
  }

  @Override
  public String getName() {
    return ingredient.getName();
  }

  @Override
  public boolean getIsVegetarian() {
    return ingredient.getIsVegetarian();
  }

  @Override
  public boolean getIsRice() {
    return ingredient.getIsRice();
  }

  @Override
  public boolean getIsShellfish() {
    return ingredient.getIsShellfish();
  }

  @Override
  public double getCalories() {
    return (this.ingredient.getCaloriesPerOunce() * amount);
  }

  @Override
  public double getCost() {
    return ingredient.getPricePerOunce() * amount;
  }

  @Override
  public IngredientPortion combine(IngredientPortion other) {
    if (other == null) {
      return this;
    }
    if (!other.getIngredient().equals(this.getIngredient())) {
      throw new IllegalArgumentException("Ingredients are not the same");
    }
    double amountsum = other.getAmount() + this.getAmount();
    return new IngredientPortionImpl(this.getIngredient(), amountsum);
  }
}
