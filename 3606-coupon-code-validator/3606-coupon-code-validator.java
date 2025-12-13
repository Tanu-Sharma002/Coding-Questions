import java.util.*;

class Solution {
    public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {
        List<String> electronics = new ArrayList<>();
        List<String> grocery = new ArrayList<>();
        List<String> pharmacy = new ArrayList<>();
        List<String> restaurant = new ArrayList<>();

        for (int i = 0; i < code.length; i++) {
            if (!isActive[i]) continue;
            String c = code[i];
            String b = businessLine[i];
            if (c == null || c.length() == 0) continue;
            if (!c.matches("^[A-Za-z0-9_]+$")) continue;
            switch (b) {
                case "electronics":
                    electronics.add(c);
                    break;
                case "grocery":
                    grocery.add(c);
                    break;
                case "pharmacy":
                    pharmacy.add(c);
                    break;
                case "restaurant":
                    restaurant.add(c);
                    break;
            }
        }
        Collections.sort(electronics);
        Collections.sort(grocery);
        Collections.sort(pharmacy);
        Collections.sort(restaurant);
        List<String> result = new ArrayList<>();
        result.addAll(electronics);
        result.addAll(grocery);
        result.addAll(pharmacy);
        result.addAll(restaurant);
        return result;
    }
}
