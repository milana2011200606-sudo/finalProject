import java.util.*;

public class Main {
    public static void main(String[] args) {
        //1
        HashMap<String, Integer> students = new HashMap<>();
        students.put("Aida", 85);
        students.put("Azat", 92);
        students.put("Dana", 77);
        System.out.println("1) Map: " + students);
        System.out.println("1) Size: " + students.size());
        System.out.println();

        // 2)
        System.out.println("2) get(\"Aida\") = " + students.get("Aida"));
        System.out.println("2) get(\"Mira\") = " + students.get("Mira")); // null
        if (students.containsKey("Mira")) {
            System.out.println("2) Mira found, score = " + students.get("Mira"));
        } else {
            System.out.println("2) Mira NOT found");
        }
        System.out.println();


        // 3)
        Integer oldDana = students.put("Dana", 80); // returns old value
        System.out.println("3) Old Dana score = " + oldDana);
        System.out.println("3) New map = " + students);
        System.out.println();

        // 4)
        Integer removedAzat = students.remove("Azat");
        System.out.println("4) Removed Azat value = " + removedAzat);
        Integer removedNon = students.remove("NonExisting");
        System.out.println("4) Removed NonExisting = " + removedNon);
        System.out.println("4) Map now = " + students);
        System.out.println();

        // 5)
        System.out.println("5) isEmpty before clear: " + students.isEmpty());
        students.clear();
        System.out.println("5) isEmpty after clear: " + students.isEmpty());
        System.out.println("5) Map = " + students);
        System.out.println();

        students.put("Aida", 85);
        students.put("Azat", 92);
        students.put("Dana", 77);

        // 6)
        int miraScore = students.getOrDefault("Mira", -1);
        if (miraScore == -1) System.out.println("6) Mira: Not found");
        else System.out.println("6) Mira score = " + miraScore);

        int aidaScore = students.getOrDefault("Aida", -1);
        System.out.println("6) Aida score = " + aidaScore);
        System.out.println();

        // 7)
        students.putIfAbsent("Aida", 90); // keeps old value
        students.putIfAbsent("Mira", 88); // inserts Mira
        System.out.println("7) After putIfAbsent: " + students);
        System.out.println();

        // 8)
        boolean cond = students.replace("Aida", 85, 86); // conditional
        System.out.println("8) Conditional replace Aida 85->86 success? " + cond);
        System.out.println("8) Map = " + students);

        Integer prev = students.replace("Aida", 91); // unconditional
        System.out.println("8) Unconditional replace Aida prev = " + prev);
        System.out.println("8) Map = " + students);

        Integer missing = students.replace("NoOne", 100);
        System.out.println("8) Replace missing key returns = " + missing);
        System.out.println();

        // 9)
        System.out.println("9) Keys: " + students.keySet());
        System.out.println("9) Values: " + students.values());
        System.out.println("9) Entries:");
        for (Map.Entry<String, Integer> e : students.entrySet()) {
            System.out.println("   " + e.getKey() + " = " + e.getValue());
        }
        System.out.println();

        // 10)
        int count80 = 0;
        for (int v : students.values()) {
            if (v >= 80) count80++;
        }
        System.out.println("10) Count score >= 80 = " + count80);
        System.out.println();

        // 11)
        int max = Integer.MIN_VALUE;
        ArrayList<String> topNames = new ArrayList<>();
        for (Map.Entry<String, Integer> e : students.entrySet()) {
            int v = e.getValue();
            if (v > max) {
                max = v;
                topNames.clear();
                topNames.add(e.getKey());
            } else if (v == max) {
                topNames.add(e.getKey());
            }
        }
        System.out.println("11) Max score = " + max + ", who: " + topNames);
        System.out.println();

        // 12) Word Frequency Counter
        String text12 = "Java is fun and Java is powerful and fun";
        String[] words12 = text12.toLowerCase().split("\\s+");
        HashMap<String, Integer> freqWords = new HashMap<>();
        for (String w : words12) {
            freqWords.put(w, freqWords.getOrDefault(w, 0) + 1);
        }
        System.out.println("12) Word freq: " + freqWords);
        System.out.println();

        // 13)
        String s13 = "Mississippi";
        HashMap<Character, Integer> freqChars = new HashMap<>();
        for (char ch : s13.toCharArray()) {
            if (Character.isLetter(ch)) {
                char c = Character.toLowerCase(ch);
                freqChars.put(c, freqChars.getOrDefault(c, 0) + 1);
            }
        }
        System.out.println("13) Char freq: " + freqChars);

        char mostChar = 0;
        int mostCount = -1;
        for (Map.Entry<Character, Integer> e : freqChars.entrySet()) {
            if (e.getValue() > mostCount) {
                mostCount = e.getValue();
                mostChar = e.getKey();
            }
        }
        System.out.println("13) Most frequent char = " + mostChar + " (" + mostCount + ")");
        System.out.println();

        // 14)
        String[] arr14 = {"hi", "book", "java", "sun", "loop", "map"};
        HashMap<Integer, ArrayList<String>> byLen = new HashMap<>();
        for (String w : arr14) {
            byLen.computeIfAbsent(w.length(), k -> new ArrayList<>()).add(w);
        }
        System.out.println("14) Group by length: " + byLen);
        System.out.println();

        // 15)
        String s15 = "swiss";
        HashMap<Character, Integer> f15 = new HashMap<>();
        for (char ch : s15.toCharArray()) {
            f15.put(ch, f15.getOrDefault(ch, 0) + 1);
        }
        Character firstUnique = null;
        for (char ch : s15.toCharArray()) {
            if (f15.get(ch) == 1) {
                firstUnique = ch;
                break;
            }
        }
        System.out.println("15) String: " + s15);
        System.out.println("15) First non-repeating = " + (firstUnique == null ? "None" : firstUnique));
        System.out.println();

        //16
        int[] nums16 = {2, 7, 11, 15};
        int target16 = 9;
        HashMap<Integer, Integer> valToIndex = new HashMap<>();
        int i1 = -1, i2 = -1;
        for (int i = 0; i < nums16.length; i++) {
            int x = nums16[i];
            int need = target16 - x;
            if (valToIndex.containsKey(need)) {
                i1 = valToIndex.get(need);
                i2 = i;
                break;
            }
            valToIndex.put(x, i);
        }
        System.out.println("16) Two-sum indices for target " + target16 + ": " + i1 + ", " + i2);
        System.out.println();

        // 17)
        String[] arr17 = {"apple", "banana", "apple", "orange", "banana", "kiwi"};
        HashMap<String, Integer> f17 = new HashMap<>();
        for (String w : arr17) {
            f17.put(w, f17.getOrDefault(w, 0) + 1);
        }
        System.out.println("17) Frequency: " + f17);

        System.out.print("17) Unique items (freq=1): ");
        boolean first = true;
        for (Map.Entry<String, Integer> e : f17.entrySet()) {
            if (e.getValue() == 1) {
                if (!first) System.out.print(", ");
                System.out.print(e.getKey());
                first = false;
            }
        }
        System.out.println();

        System.out.println("17) Duplicated items (freq>1):");
        for (Map.Entry<String, Integer> e : f17.entrySet()) {
            if (e.getValue() > 1) {
                System.out.println("   " + e.getKey() + " -> " + e.getValue());
            }
        }
        System.out.println();

        // 18)
        HashMap<String, Integer> m1 = new HashMap<>();
        m1.put("Aida", 85);
        m1.put("Azat", 92);
        m1.put("Dana", 77);

        HashMap<String, Integer> m2 = new HashMap<>();
        m2.put("Dana", 77);
        m2.put("Aida", 85);
        m2.put("Azat", 92);

        System.out.println("18) m1 = " + m1);
        System.out.println("18) m2 = " + m2);
        System.out.println("18) m1.equals(m2) = " + m1.equals(m2));
        System.out.println("18) hashCode m1 = " + m1.hashCode());
        System.out.println("18) hashCode m2 = " + m2.hashCode());
        System.out.println();

        // 19)
        HashMap<String, Integer> scores19 = new HashMap<>();
        scores19.put("Aida", 40);
        scores19.put("Azat", 35);
        scores19.put("Dana", 50);
        scores19.put("Mira", 88);

        Iterator<Map.Entry<String, Integer>> it = scores19.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, Integer> e = it.next();
            if (e.getValue() < 60) {
                it.remove();
            }
        }
        System.out.println("19) After removing <60: " + scores19);
        System.out.println();

        // 20) Merge scores
        HashMap<String, Integer> scores1 = new HashMap<>();
        scores1.put("Aida", 40);
        scores1.put("Azat", 35);
        scores1.put("Dana", 50);

        HashMap<String, Integer> scores2 = new HashMap<>();
        scores2.put("Azat", 10);
        scores2.put("Dana", 5);
        scores2.put("Mira", 45);

        for (Map.Entry<String, Integer> e : scores2.entrySet()) {
            scores1.merge(e.getKey(), e.getValue(), Integer::sum);
        }
        System.out.println("20) Merged scores: " + scores1);
        System.out.println();

        // 21
        HashMap<String, Integer> st21 = new HashMap<>();
        st21.put("Aida", 90);
        st21.put("Azat", 90);
        st21.put("Dana", 80);
        st21.put("Mira", 80);
        st21.put("Kiwi", 70);

        HashMap<Integer, ArrayList<String>> scoreToStudents = new HashMap<>();
        for (Map.Entry<String, Integer> e : st21.entrySet()) {
            int score = e.getValue();
            String name = e.getKey();
            scoreToStudents.computeIfAbsent(score, k -> new ArrayList<>()).add(name);
        }
        System.out.println("21) Original: " + st21);
        System.out.println("21) Inverted: " + scoreToStudents);
        System.out.println();

        // 22)
        String text22 = "Java is fun and Java is powerful and fun";
        String[] words22 = text22.toLowerCase().split("\\s+");

        HashMap<String, Integer> f22 = new HashMap<>();
        for (String w : words22) {
            f22.put(w, f22.getOrDefault(w, 0) + 1);
        }

        String top1 = null, top2 = null;
        int c1 = -1, c2 = -1;

        for (Map.Entry<String, Integer> e : f22.entrySet()) {
            String w = e.getKey();
            int c = e.getValue();

            if (c > c1) {
                top2 = top1; c2 = c1;
                top1 = w;    c1 = c;
            } else if (c > c2) {
                top2 = w;    c2 = c;
            }
        }

        System.out.println("22) Frequency: " + f22);
        System.out.println("22) Top1: " + top1 + " -> " + c1);
        System.out.println("22) Top2: " + top2 + " -> " + c2);

    }
}
