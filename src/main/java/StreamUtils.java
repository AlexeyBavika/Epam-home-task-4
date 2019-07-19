import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

class StreamUtils {
    // task 1
    static String takeEnumerationByOddIndex(List<String> namesList) {
        return IntStream.range(0, namesList.size()).mapToObj(index -> (index * 2 + 1) + ". " + namesList.get(index))
                .collect(Collectors.joining(", "));
    }

    // task 2
    static List<String> takeStringListToUppercaseAndSortByReduce(List<String> listToUppercaseAndSort) {
        return listToUppercaseAndSort.stream().map(String::toUpperCase).sorted().collect(Collectors.toList());
    }

    // task 3
    static List<String> sortByComma(List<String> list) {
        return list.stream().flatMap(string -> Arrays.stream(string.split(",\\s+"))).collect(Collectors.toList());
    }

    // task 4
    static LongStream generateLinearCongruent(long seed, long a, long c, long m) {
        return LongStream.iterate(seed, x -> (a * x + c) % m).limit(10);
    }

    // task 5
    static <T> Stream<T> iterateTwoStreamsUntilOneOfThemIsNotEmpty(Stream<T> firstStream, Stream<T> secondStream) {
        List<T> result = new ArrayList<>();
        List<T> firstStreamResult = firstStream.collect(Collectors.toList());
        List<T> secondStreamResult = secondStream.collect(Collectors.toList());

        for (int i = 0; i < firstStreamResult.size() && i < secondStreamResult.size() ; i++) {
            result.add(firstStreamResult.get(i));
            result.add(secondStreamResult.get(i));
        }

        return result.stream();
    }

    // task 6
    static <T> List<T> getStreamResultsOfAnyNumOfListsInOneList(List<T>... lists) {
        return Stream.of(lists).flatMap(Collection::stream).collect(Collectors.toList());
    }
}
