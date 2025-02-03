import java.util.*;

// TrieNode for AutoCompleteSystem
class TrieNode {
    Map<Character, TrieNode> children;
    Map<String, Integer> frequencies;

    public TrieNode() {
        children = new HashMap<>();
        frequencies = new HashMap<>();
    }
}

public class AutoCompleteSystem {
    private TrieNode root;
    private TrieNode current;
    private StringBuilder currentQuery;

    public AutoCompleteSystem(String[] sentences, int[] times) {
        root = new TrieNode();
        current = root;
        currentQuery = new StringBuilder();

        for (int i = 0; i < sentences.length; i++) {
            insert(sentences[i], times[i]);
        }
    }

    private void insert(String sentence, int time) {
        TrieNode node = root;
        for (char c : sentence.toCharArray()) {
            node.children.putIfAbsent(c, new TrieNode());
            node = node.children.get(c);
        }
        node.frequencies.put(sentence, node.frequencies.getOrDefault(sentence, 0) + time);
    }

    public List<String> input(char c) {
        if (c == '#') {
            insert(currentQuery.toString(), 1);
            currentQuery.setLength(0);
            current = root;
            return new ArrayList<>();
        }

        currentQuery.append(c);
        if (!current.children.containsKey(c)) {
            current.children.put(c, new TrieNode());
            current = current.children.get(c);
            return new ArrayList<>();
        }

        current = current.children.get(c);
        List<Map.Entry<String, Integer>> suggestions = new ArrayList<>(current.frequencies.entrySet());

        suggestions.sort((a, b) -> {
            int freqCompare = b.getValue().compareTo(a.getValue());
            return freqCompare != 0 ? freqCompare : a.getKey().compareTo(b.getKey());
        });

        List<String> result = new ArrayList<>();
        for (int i = 0; i < Math.min(3, suggestions.size()); i++) {
            result.add(suggestions.get(i).getKey());
        }

        return result;
    }
}

// Data Type Size
class DataTypeSize {
    static int dataTypeSize(String str) {
        switch (str) {
            case "Character":
                return 2;
            case "Integer":
            case "Float":
                return 4;
            case "Long":
            case "Double":
                return 8;
            default:
                throw new IllegalArgumentException("Unsupported data type: " + str);
        }
    }
}

// Decision Making
class DecisionMaking {
    public static String compareNM(int n, int m) {
        if (n < m) return "lesser";
        if (n > m) return "greater";
        return "equal";
    }
}

// Switch Case
class SwitchCase {
    static double switchCase(int choice, List<Double> arr) {
        switch (choice) {
            case 1:
                if (arr.size() < 1) {
                    throw new IllegalArgumentException("Circle requires exactly one value: radius.");
                }
                return Math.PI * arr.get(0) * arr.get(0);
            case 2:
                if (arr.size() < 2) {
                    throw new IllegalArgumentException("Rectangle requires exactly two values: length and breadth.");
                }
                return arr.get(0) * arr.get(1);
            default:
                throw new IllegalArgumentException("Invalid choice: " + choice);
        }
    }
}

// While Loop
class WhileLoop {
    public static void printTable(int n) {
        int i = 10;
        while (i > 0) {
            System.out.print(i * n + " ");
            i--;
        }
        System.out.println();
    }
}

// Pass by Reference and Value
class PassByValue {
    static int[] passedBy(int a, int b) {
        return new int[]{a + 1, b + 2};
    }
}

// Main Class
class Main {
    public static void main(String[] args) {
        String[] sentences = {"hello world", "hello there", "hello java"};
        int[] times = {3, 1, 2};
        AutoCompleteSystem autoComplete = new AutoCompleteSystem(sentences, times);

        System.out.println(autoComplete.input('h'));
        System.out.println(autoComplete.input('e'));

        System.out.println(DataTypeSize.dataTypeSize("Integer"));

        System.out.println(DecisionMaking.compareNM(5, 10));

        List<Double> arr = Arrays.asList(5.0, 10.0);
        System.out.println(SwitchCase.switchCase(2, arr));

        WhileLoop.printTable(5);

        int[] result = PassByValue.passedBy(5, 10);
        System.out.println(Arrays.toString(result));
    }
}
