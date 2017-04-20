import java.util.ArrayList;
import java.util.List;

public class Main {
    private final static int ID_SIZE = 6;

    public static void main(String[] args) {
        List<Integer> happyTickets = calculateHappyTickets(ID_SIZE);

        for (Integer happyTicket : happyTickets) {
            printTicketId(happyTicket, ID_SIZE);
        }
    }

    private static List<Integer> calculateHappyTickets(Integer idSize) {
        List<Integer> numbers = createNumbers(idSize);
        List<Integer> happyTickets = new ArrayList<>();

        for (Integer number : numbers) {
            if (isTicketHappy(number, idSize)) {
                happyTickets.add(number);
            }
        }

        return happyTickets;
    }

    private static boolean isTicketHappy(Integer number, Integer idSize) {
        int rightSide = 0;
        int leftSide = 0;

        for (int i = 0; i < idSize; i++) {
            if (i < idSize / 2) {
                rightSide += number % 10;
            } else {
                leftSide += number % 10;
            }
            number /= 10;
        }

        return rightSide == leftSide;

    }

    private static List<Integer> createNumbers(Integer idSize) {
        List<Integer> result = new ArrayList<>();
        double maxLimitDouble = Math.pow(10, idSize);
        int number = 0;

        while (number / maxLimitDouble < 1) {
            result.add(number);
            number++;
        }

        return result;
    }

    private static void printTicketId(Integer number, Integer idSize) {
        Integer temp = number;
        int counter;

        for (counter = 0; temp >= 1; counter++) {
            temp /= 10;
        }

        for (int i = 0; i < idSize - counter; i++) {
            System.out.print(0);
        }
        System.out.println((number != 0) ? number : "");
    }

}
