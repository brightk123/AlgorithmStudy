import java.util.*;

public class 백준_1181_단어정렬 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        Set<String> set = new HashSet<>();

        for (int i = 0; i < N; i++) {
            set.add(sc.next());
        }

        List<String> list = new ArrayList<>(set);

        list.sort((o1, o2) -> {
            if (o1.length() == o2.length()) {
                return o1.compareTo(o2);
            } else {
                return o1.length() - o2.length();
            }
        });

        for (int i = 0; i < list.size(); i++) {
            String word = list.get(i);
            System.out.println(word);
        }
    }
}
