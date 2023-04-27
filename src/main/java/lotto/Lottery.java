package lotto;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lottery {

    public static final int MIN_LOTTERY_NUM = 1;
    public static final int MAX_LOTTERY_NUM = 45;
    public static final int LOTTERY_SIZE = 6;

    private static final List<Integer> numbers = IntStream
            .rangeClosed(MIN_LOTTERY_NUM, MAX_LOTTERY_NUM)
            .boxed()
            .collect(Collectors.toList());
    private final List<Integer> lotteryNumber;

    public Lottery(List<Integer> lotteryNumber) {
        this.lotteryNumber = List.copyOf(lotteryNumber);
    }

    public Lottery() {
        Collections.shuffle(numbers);
        this.lotteryNumber = numbers.stream()
                .limit(LOTTERY_SIZE)
                .sorted()
                .collect(Collectors.toList());

    }

    public List<Integer> getLotteryNumber() {
        return lotteryNumber;
    }

    public int matchingCount(List<Integer> winningNumbers) {
        int result = 0;
        for (Integer winningNumber : winningNumbers) {
            if (lotteryNumber.contains(winningNumber)) {
                result++;
            }
        }
        return result;
    }
}
