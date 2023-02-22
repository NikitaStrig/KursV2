package CH2;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MainCH2 {
    public static void main(String[] args) {
        String sentence = "Шла Саша как саша по саша и b b b шла как шла";

        List<String> str = new ArrayList<>();
        for (String s : sentence.split(" ")) {
            str.add(s.replaceAll("[^a-zA-Zа-яёА-ЯЁ]", "").toLowerCase());
        }

        Map<String, Long> resol = countDuplicates(str);
        System.out.println( "В тексте " + str.size() + " слов");
        List<Map.Entry<String, Long>> resolList = new ArrayList<>(resol.entrySet());
        resolList.sort(Map.Entry.comparingByValue());
        Map<String, Long> result = new LinkedHashMap<>();
        for (Map.Entry<String, Long> entry : resolList) {
            result.put( entry.getKey(), entry.getValue());
        }
        System.out.println(result);

    }
    public static Map<String, Long> countDuplicates(List<String> inputList) {
        return inputList.stream()
                .collect(Collectors.toMap(Function.identity() , v -> 1L, Long::sum));
    }
}
