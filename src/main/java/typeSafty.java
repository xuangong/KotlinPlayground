import java.util.HashMap;
import java.util.Map;

class typeSafty {
    @SuppressWarnings("unchecked")
    public static <K, V> Map<K, V> getMap(String source, String firstSplit, String secondSplit) {

        Map<K, V> result = new HashMap<K, V>();
        if (source.equals("")) {
            return result;
        }

        String[] strings = source.split(firstSplit);
        for (String string : strings) {
            String[] tmp = string.split(secondSplit);
            if (tmp.length == 2) {
                result.put((K) tmp[0], (V) tmp[1]);
                System.out.println("(K) tmp[0]:" + ((K) tmp[0]).getClass());
                System.out.println("(V) tmp[1]:" + ((V) tmp[1]).getClass());
            }
        }

        return result;
    }

    public static void main(String[] args) {
        String test = "key1:1k;key2:2;key:3";
        Map<String, Integer> map = getMap(test, ";", ":");

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            Integer value = entry.getValue();
        }
    }
}