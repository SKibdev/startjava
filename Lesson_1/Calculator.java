public class Calculator {
    public static void main(String[] args) {
        int num1 = 3;
        int num2 = 4 ;
        //  Возможные операции +, -, *, /, ^, %
        char sign = '^';
        int result = 1;

        if (!(sign == '+' || sign == '-' || sign == '*' || sign == '/' || 
                sign == '^' || sign == '%')) {
            System.out.println("Ошибка! Возможные операции +, -, *, /, ^, %");
        } else {
            if (!(num1 > 0 && num2 > 0)) {
                System.out.println("Ошибка! Введите целые положительные числа");
            } else {
                if (sign == '+') {
                    result = num1 + num2;
                }
                if (sign == '-') {
                    result = num1 - num2;
                }
                if (sign == '*') {
                    result = num1 * num2;
                }
                if (sign == '/') {
                    result = num1 / num2;
                }
                if (sign == '%') {
                    result = num1 % num2;
                }
                if (sign == '^') {
                    for (int i = 1; i <= num2; i++) {
                        result *= num1;
                    }
                }
                System.out.println(num1 + " " + sign + " " + num2 + " = " + result);
            }
        }
    }
}