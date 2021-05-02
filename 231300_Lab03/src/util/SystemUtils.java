package util;

import java.util.List;
import java.util.Map;

public class SystemUtils {
    public static void validateStrings(List<Map<String, String>> strings, String objName) {
        for (Map<String, String> strMap : strings) {
            for (String strName : strMap.keySet()) {
                String value = strMap.get(strName);

                if (value == null || value.isBlank()) {
                    throw new IllegalArgumentException("Invalid " + objName + " " + strName + "!");
                }
            }
        }
    }
}
