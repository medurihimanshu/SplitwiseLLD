package strategy;

import java.util.List;
import java.util.Map;

public interface ExpenseStrategy {
    Map<String, Double> evaluateUsersExpense(final List<String> users, final List<Double> splitList, final Double amount);

    boolean validateExpenseRequest(final List<Double> splitList, final Double amount);
}
