package strategy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EqualExpenseStrategy implements ExpenseStrategy {

    @Override
    public Map<String, Double> evaluateUsersExpense(final List<String> users, final List<Double> splitList, final Double amount) {
        int numberOfUsers = users.size();
        double roundedAmountPerUser = (Math.round((amount/numberOfUsers)*100))/100;
        final Map<String, Double> usersMap = new HashMap<>();
        for (String userId : users) {
            usersMap.put(userId, roundedAmountPerUser);
        }

        return usersMap;
    }

    @Override
    public boolean validateExpenseRequest(List<Double> splitList, Double amount) {
        return splitList.isEmpty();
    }
}
