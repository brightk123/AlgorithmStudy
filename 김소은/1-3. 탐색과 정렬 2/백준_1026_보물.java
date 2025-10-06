import java.util.Arrays;
import java.util.Scanner;

public class 백준_1026_보물 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[] A = new int[N];
        int[] B = new int[N];

        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }

        for (int i = 0; i < N; i++) {
            B[i] = sc.nextInt();
        }

        Arrays.sort(A);

        Integer[] idx = new Integer[N];
        for (int i = 0; i < N; i++) {
            idx[i] = i;
        }

        Arrays.sort(idx, (i, j) -> B[j] - B[i]);

        int[] newA = new int[N];
        for (int i = 0; i < N; i++) {
            newA[idx[i]] = A[i];
        }

        int S = 0;
        for (int i = 0; i < N; i++) {
            S += newA[i] * B[i];
        }

        System.out.println(S);
    }
}
