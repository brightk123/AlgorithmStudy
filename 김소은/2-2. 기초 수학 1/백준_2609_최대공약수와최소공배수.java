import java.util.Scanner;

public class 백준_2609_최대공약수와최소공배수 {
    // 최대공약수(GCD) 구하는 메서드 (유클리드 호제법)
    // a와 b의 최소공배수 = a * b / a와 b의 최대공약수
    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b; // b의 값을 temp에 임시저장
            b = a % b; // b에 a를 b로 나눈 나머지 저장
            a = temp; // a를 b로 갱신
        }
        return a; // b가 0이 되면 a 가 최대공약수가 됨
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        int gcdValue = gcd(a, b);           // 최대공약수
        int lcmValue = a * b / gcdValue;    // 최소공배수

        System.out.println(gcdValue);
        System.out.println(lcmValue);
    }
}
