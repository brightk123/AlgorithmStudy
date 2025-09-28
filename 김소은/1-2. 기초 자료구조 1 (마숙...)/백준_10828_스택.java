import java.util.Scanner;
import java.util.Stack;

public class 백준_10828_스택 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < N; i++) {
            String command = sc.nextLine();
            String[] parts = command.split(" ");

            if (parts[0].equals("push")) {
                int num = Integer.parseInt(parts[1]);
                stack.push(num);
            } else if (parts[0].equals("pop")) {
                if (stack.isEmpty()) System.out.println(-1);
                else System.out.println(stack.pop());
            } else if (parts[0].equals("size")) {
                System.out.println(stack.size());
            } else if (parts[0].equals("empty")) {
                System.out.println(stack.isEmpty() ? 1 : 0);
            } else if (parts[0].equals("top")) {
                if (stack.isEmpty()) System.out.println(-1);
                else System.out.println(stack.peek());
            }
        }

        sc.close();
    }
}
