package factory;

import models.enums.ExpenseType;
import strategy.EqualExpenseStrategy;
import strategy.ExactExpenseStrategy;
import strategy.ExpenseStrategy;
import strategy.PercentageExpenseStrategy;

public class ExpenseStrategyFactory {
    public ExpenseStrategyFactory() {
    }

    public static ExpenseStrategy getExpenseStrategy(final ExpenseType expenseType) {
        switch (expenseType) {
            case EXACT:
                return new ExactExpenseStrategy();
            case PERCENTAGE:
                return new PercentageExpenseStrategy();
            default:
                return new EqualExpenseStrategy();
        }
    }
}
