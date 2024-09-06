import strategy.ExpenseStrategy;
import factory.ExpenseStrategyFactory;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import models.BalanceMapping;
import models.enums.ExpenseType;

public class Splitwise {
    private final Map<String, BalanceMapping> userBalanceMap;

    public Splitwise() {
        this.userBalanceMap = new HashMap<>();
    }
    public void registerUser(final User user) {
        userBalanceMap.put(user.getUserId(), new BalanceMapping());

        //Save User data to MySQL database
    }

    public void addExpense(final String userPaid, final Double paidAmount, final ExpenseType expenseType,
                           final List<String> usersOwe, final List<Double> splitList) {
        // Evaluate the amounts that every user owe to userPaid
        final ExpenseStrategy expenseStrategy = ExpenseStrategyFactory.getExpenseStrategy(expenseType);

        expenseStrategy.validateExpenseRequest(splitList, paidAmount);

        final Map<String, Double> userOweMap = expenseStrategy.evaluateUsersExpense(usersOwe, splitList, paidAmount);

        // Update userBalanceMap
        final BalanceMapping balanceMapping = userBalanceMap.get(userPaid);
        userBalanceMap.put(userPaid, balanceMapping.updateExpense(userOweMap, userPaid));
    }

    void showSingleUserBalance(final String userId) {
        if (userBalanceMap.containsKey(userId)) {
            userBalanceMap.get(userId).getBalanceMap().forEach((key, value) -> System.out.println(key + " owes " + userId + " : " + value.getAmount()));
            if (userBalanceMap.get(userId).getBalanceMap().isEmpty()) {
                System.out.println("No Balances");
            }
        } else {
            System.out.println("No Balances");
        }
    }

    void allUserBalance() {
        userBalanceMap.forEach((key, value) -> showSingleUserBalance(key));
    }
}
