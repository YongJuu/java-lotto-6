package lotto.validator;

import java.util.List;

public class ValidationUtil {

    public static boolean isNumber(String input) {
        if (input.isEmpty()) {
            return false;
        }

        if (input.charAt(0) == '-') {
            return input.length() > 1 && input.substring(1).chars().allMatch(Character::isDigit);
        }

        return input.chars().allMatch(Character::isDigit);
    }

    public static boolean isInputFirstZero(String input) {
        return input.charAt(0) == '0';
    }

    public static boolean isDuplicateNumbers(List<Integer> numbers) {
        List<Integer> duplicateNumbers = numbers
                .stream()
                .distinct()
                .toList();

        if (duplicateNumbers.size() != numbers.size()) {
            return true;
        }
        return false;
    }
    
    public static boolean isOutOfRange(int start, int end, int num) {
        if (num < start || end < num) {
            return true;
        }
        return false;
    }
}