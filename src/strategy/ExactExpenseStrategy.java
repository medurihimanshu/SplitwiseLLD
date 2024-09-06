package strategy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExactExpenseStrategy implements ExpenseStrategy {

    @Override
    public Map<String, Double> evaluateUsersExpense(final List<String> users, final List<Double> splitList, final Double amount) {
        int numberOfUsers = users.size();
        final Map<String, Double> usersMap = new HashMap<>();
        for (int i=0;i<numberOfUsers;i++) {
            usersMap.put(users.get(i), splitList.get(i));
        }

        return usersMap;
    }

    @Override
    public boolean validateExpenseRequest(List<Double> splitList, Double amount) {
        return amount.equals(splitList.stream().mapToDouble(Double::doubleValue).sum());
    }
}
