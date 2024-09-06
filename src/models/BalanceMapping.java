package models;

import java.util.HashMap;
import java.util.Map;

public class BalanceMapping {

    private final Map<String, Expense> balanceMap;

    public BalanceMapping() {
        this.balanceMap = new HashMap<>();
    }

    public Map<String, Expense> getBalanceMap() {
        return balanceMap;
    }

    public BalanceMapping updateExpense(final Map<String, Double> userOweMap, final String userId) {
        userOweMap.forEach((key, value) -> {
            if (userId.equals(key))
                return;
            if (balanceMap.containsKey(key)) {
                final Double existingAmount = balanceMap.get(key).getAmount();
                balanceMap.get(key).setAmount(existingAmount + value);
            } else {
                balanceMap.put(key, new Expense(value));
            }
        });
        return this;
    }
}
