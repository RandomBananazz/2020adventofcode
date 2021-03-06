import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class Day1 {
    public static int day1(List<Integer> expenseReport) {
        for (int firstExpense : expenseReport) {
            int secondExpense = 2020 - firstExpense;
            if (expenseReport.contains(secondExpense)) {
                return firstExpense * secondExpense;
            }
        }
        return 0;
    }

    public static int day2(List<Integer> expenseReport) {
        for (int firstExpense : expenseReport) {
            int firstDifference = 2020 - firstExpense;
            for (int secondExpense : expenseReport) {
                if (secondExpense == firstExpense) continue;
                int secondDifference = firstDifference - secondExpense;
                if (expenseReport.contains(secondDifference)) {
                    return firstExpense * secondExpense * secondDifference;
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) throws FileNotFoundException, IOException {
        File expenseInput = new File("input.txt");
        BufferedReader br = new BufferedReader(new FileReader(expenseInput));
        List<Integer> expenseReport = new ArrayList<Integer>();
        // Convert String stream to Integer List
        expenseReport.addAll(br.lines().map(Integer::valueOf).collect(Collectors.toList()));
        System.out.println(day1(expenseReport));
        System.out.println(day2(expenseReport));
    }
}