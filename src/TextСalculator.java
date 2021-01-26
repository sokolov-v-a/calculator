import java.util.Scanner;

public class TextСalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ввендите уравнение с переменными x1,x2,x3,x4");
        String equation = scanner.nextLine().trim();
        System.out.println("Ввендите значение переменных через пробел x1,x2,x3,x4");
        String[] variables = scanner.nextLine().split(" ");
        int count = 0;
        for (String variable:variables){
            count++;
            equation = equation.replaceAll("x"+count, variable);
        }
        System.out.println(equation);
        System.out.println(Espresso.calculus(equation));
    }
}
