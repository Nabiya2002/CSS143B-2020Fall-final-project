import java.util.*;

/*
DO NOT CHANGE
 */

public class Util {
    public static Map<String, List<List<Integer>>> getIndexForIndexerTest() {
        Map<String, List<List<Integer>>> index = new HashMap<String, List<List<Integer>>>() {{
            put("world", new ArrayList<>(
                    Arrays.asList(
                            // "world" appears in doc 0 at location 0,1,3
                            new ArrayList<>(Arrays.asList(0, 1, 3)),
                            // "world" appears in doc 1 at location 0,1
                            new ArrayList<>(Arrays.asList(0, 1)),
                            new ArrayList<>(Arrays.asList(0, 4)),
                            new ArrayList<>(Arrays.asList(2)),
                            new ArrayList<>(),
                            new ArrayList<>(),
                            new ArrayList<>()
                    ))
            );
            put("hello", new ArrayList<>(
                    Arrays.asList(
                            new ArrayList<>(Arrays.asList(2)),
                            new ArrayList<>(),
                            new ArrayList<>(Arrays.asList(2)),
                            new ArrayList<>(Arrays.asList(1)),
                            new ArrayList<>(),
                            new ArrayList<>(),
                            new ArrayList<>()
                    ))
            );
            put("hallo", new ArrayList<>(
                    Arrays.asList(
                            new ArrayList<>(),
                            new ArrayList<>(Arrays.asList(2)),
                            new ArrayList<>(),
                            new ArrayList<>(),
                            new ArrayList<>(),
                            new ArrayList<>(),
                            new ArrayList<>()
                    ))
            );
            put("seattle", new ArrayList<>(
                    Arrays.asList(
                            new ArrayList<>(),
                            new ArrayList<>(),
                            new ArrayList<>(Arrays.asList(1)),
                            new ArrayList<>(),
                            new ArrayList<>(),
                            new ArrayList<>(),
                            new ArrayList<>()
                    ))
            );
            put("abc", new ArrayList<>(
                    Arrays.asList(
                            new ArrayList<>(),
                            new ArrayList<>(),
                            new ArrayList<>(Arrays.asList(3)),
                            new ArrayList<>(Arrays.asList(0)),
                            new ArrayList<>(),
                            new ArrayList<>(),
                            new ArrayList<>()
                    ))
            );
            put("fun", new ArrayList<>(
                    Arrays.asList(
                            new ArrayList<>(),
                            new ArrayList<>(),
                            new ArrayList<>(),
                            new ArrayList<>(Arrays.asList(3)),
                            new ArrayList<>(),
                            new ArrayList<>(Arrays.asList(0, 2)),
                            new ArrayList<>(Arrays.asList(2))
                    ))
            );
            put("sunny", new ArrayList<>(
                    Arrays.asList(
                            new ArrayList<>(),
                            new ArrayList<>(),
                            new ArrayList<>(),
                            new ArrayList<>(),
                            new ArrayList<>(Arrays.asList(0)),
                            new ArrayList<>(),
                            new ArrayList<>(Arrays.asList(1))
                    ))
            );
            put("day", new ArrayList<>(
                    Arrays.asList(
                            new ArrayList<>(),
                            new ArrayList<>(),
                            new ArrayList<>(Arrays.asList(5)),
                            new ArrayList<>(),
                            new ArrayList<>(),
                            new ArrayList<>(Arrays.asList(1)),
                            new ArrayList<>(Arrays.asList(0))
                    ))
            );
            put("better", new ArrayList<>(
                    Arrays.asList(
                            new ArrayList<>(),
                            new ArrayList<>(),
                            new ArrayList<>(),
                            new ArrayList<>(),
                            new ArrayList<>(Arrays.asList(1)),
                            new ArrayList<>(),
                            new ArrayList<>()
                    ))
            );
        }};
        return index;
    }

    public static List<String> getMyDocumentsForIntTest() {
        return new ArrayList<>(
                Arrays.asList(
                        "test create your own account at the https://github.com/",
                        "in the action tab of the repo, click the green button to enable action",
                        "open your own repo in intellij using get from version control",
                        "create a new java project",
                        "java",
                        "start early. be active. ask questions",
                        "fluent with object-oriented programming using java",
                        "the final java project is awesome",
                        "press the green button to run the project"
                )
        );
    }

    public static List<String> getDocumentsForIntTest() {
        return new ArrayList<>(
                Arrays.asList(
                        "say hello world like you mean hello world not just world",
                        "hello world",
                        "hello",
                        "world",
                        "world world hello",
                        "world seattle rains hello abc world",
                        "sunday hello world fun",
                        " the new macbook is  awesome  "
                )
        );
    }

    public static List<Integer> emptyResult() {
        return new ArrayList<>();
    }

}