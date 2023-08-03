import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

public class SortTest {

    private User[] generateInput() {
        return new User[]{
            new User("an1on7"),
            new User("max898"),
            new User("pe1er2"),
            new User("paul"),
            new User("1anne1978"),
            new User("wa11er"),
            new User("an1on7"),
            new User("alex"),
        };
    }

    private User[] generateExpectedOutput(User[] input, boolean descending) {
        User[] expectedOutput = Arrays.copyOf(input, input.length);

        if (descending) {
            Arrays.sort(expectedOutput, Comparator.comparing(User::getUsername).reversed());
        } else {
            Arrays.sort(expectedOutput, Comparator.comparing(User::getUsername));
        }

        return expectedOutput;
    }

    @Test
    public void testBubblesortAscending() {
        User[] input = generateInput();
        User[] expectedOutput = generateExpectedOutput(input, false);
        User[] output = Sort.bubblesort(input, false);

        Assert.assertArrayEquals(expectedOutput, output);
    }

    @Test
    public void testQuicksortAscending() {
        User[] input = generateInput();
        User[] expectedOutput = generateExpectedOutput(input, false);
        User[] output = Sort.quicksort(input, false);

        Assert.assertArrayEquals(expectedOutput, output);
    }

    @Test
    public void testBubblesortDescending() {
        User[] input = generateInput();
        User[] expectedOutput = generateExpectedOutput(input, true);
        User[] output = Sort.bubblesort(input, true);

        Assert.assertArrayEquals(expectedOutput, output);
    }

    @Test
    public void testQuicksortDescending() {
        User[] input = generateInput();
        User[] expectedOutput = generateExpectedOutput(input, true);
        User[] output = Sort.quicksort(input, true);

        Assert.assertArrayEquals(expectedOutput, output);
    }
}
