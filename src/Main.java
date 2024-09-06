import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jdk.nashorn.internal.ir.annotations.Immutable;
import models.enums.ExpenseType;

public class Main {
    public static void main(String[] args) {
        System.out.println("----WELCOME TO SPLITWISE----");
        final User user1 = new User("User1");
        final User user2 = new User("User2");
        final User user3 = new User("User3");
        final User user4 = new User("User4");

        final Splitwise splitwise = new Splitwise();
        List<String> usersInvolved = Arrays.asList(user1.getUserId(), user2.getUserId(), user3.getUserId(), user4.getUserId());
        splitwise.registerUser(user1);
        splitwise.registerUser(user2);
        splitwise.allUserBalance();

        splitwise.addExpense(user1.getUserId(), 1000.00, ExpenseType.EQUAL, usersInvolved, Collections.emptyList());
        splitwise.addExpense(user2.getUserId(), 10000.00, ExpenseType.EQUAL, usersInvolved, Collections.emptyList());
        splitwise.addExpense(user1.getUserId(), 10000.00, ExpenseType.EQUAL, usersInvolved, Collections.emptyList());


        splitwise.allUserBalance();
        System.out.println();
        splitwise.showSingleUserBalance(user3.getUserId());

    }
}