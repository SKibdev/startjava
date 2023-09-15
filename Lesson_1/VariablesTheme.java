public class VariablesTheme {

        public static void main(String[] args) {
        System.out.println("1. Вывод характеристик компьютера");
        long sn = 1111_2222_3333_4444L;
        byte numCore = 2;
        double freqCpu = 2.4e9;
        float ram = 4.01f;
        short ssd = 512;
        boolean availableGpu = false;
        int vram = 2048;
        char os = 'W';

        System.out.println("Серийный номер компьютера: " + sn + 
                        "\nКоличество ядер CPU: " + numCore + 
                        "\nЧастота процессора, Гц: " + freqCpu + 
                        "\nОбъем оперативной памяти, Гб: " + ram + 
                        "\nОбъем жесткого (SSD) диска памяти, Гб: " + ssd + 
                        "\nВстроенный графический процессор: " + availableGpu + 
                        "\nОбъем оперативной памяти видеокарты, Мб: " + vram + 
                        "\nОперационная система (W - Windows, L - Linux): " + os);

        System.out.println("\n2. Расчет стоимости товара со скидкой");
        double penPr = 200.00;
        double bookPr = 100.00;
        double disc = 0.11;
        double rez = penPr + bookPr;
        System.out.println("Общая стоимость товаров без скидки: " + rez +
                        " руб.\nCумма скидки: " + (rez * disc) + 
                        " руб.\nОбщая стоимость товаров со скидкой: " + (rez - rez * disc) + 
                        " руб.");

        System.out.println("\n3. Вывод слова JAVA");
        System.out.println("   J    a  v     v  a\n" + 
                        "   J   a a  v   v  a a\n" + 
                        "J  J  aaaaa  V V  aaaaa\n" + 
                        " JJ  a     a  V  a     a");

        System.out.println("\n4. Вывод min и max значений целых числовых типов");
        byte typeB = 127;
        System.out.println("Переменная типа byte:\n первоначальное значение: " + typeB + 
                        "\n значение после инкремента на единицу: " + (++typeB) + 
                        "\n значение после декремента на единицу: " + (--typeB));
        short typeSh = 32_767;
        System.out.println("Переменная типа short:\n первоначальное значение: " + typeSh + 
                        "\n значение после инкремента на единицу: " + (++typeSh) + 
                        "\n значение после декремента на единицу: " + (--typeSh));
        int typeI = 2_147_483_647;
        System.out.println("Переменная типа int:\n первоначальное значение: " + typeI + 
                        "\n значение после инкремента на единицу: " + (++typeI) + 
                        "\n значение после декремента на единицу: " + (--typeI));
        long typeL = 9_223_372_036_854_775_807L;
        System.out.println("Переменная типа long:\n первоначальное значение: " + typeL + 
                        "\n значение после инкремента на единицу: " + (++typeL) + 
                        "\n значение после декремента на единицу: " + (--typeL));

        System.out.println("\n5. Перестановка значений переменных");
        int num1 = 2;
        int num2 = 5;
        System.out.println("Перестановка с помощью третьей переменной\n" + 
                        " исходные значения переменных: num1 = " + num1 + " num2 = " + num2);
        int exch = num1;
        num1 = num2;
        num2 = exch;
        System.out.println(" новые значения переменных: num1 = " + num1 + " num2 = " + num2);
        System.out.println("Перестановка с помощью арифметических операций\n" + 
                        " исходные значения переменных: num1 = " + num1 + " num2 = " + num2);
        num1 += num2;
        num2 = num1 - num2;
        num1 -= num2;
        System.out.println(" новые значения переменных: num1 = " + num1 + " num2 = " + num2);
        System.out.println("Перестановка с помощью  побитовой операции\n" + 
                        " исходные значения переменных: num1 = " + num1 + " num2 = " + num2);
        num1 ^= num2;
        num2 ^= num1;
        num1 ^= num2;
        System.out.println(" новые значения переменных: num1 = " + num1 + " num2 = " + num2);

        System.out.println("\n6. Вывод символов и их кодов");
        char ch36 = 36;
        char ch42 = 42;
        char ch64 = 64;
        char ch124 = 124;
        char ch126 = 126;
        System.out.println((int) ch36 + " " + ch36 + "\n" + (int) ch42 + " " + ch42 + "\n" + 
                        (int) ch64 + " " + ch64 + "\n" + (int) ch124 + " " + ch124 + "\n" + 
                        (int) ch126 + " " + ch126);

        System.out.println("\n7. Вывод в консоль ASCII-арт Дюка");
        char chDuke1 = '/';
        char chDuke2 = '\\';
        char chDuke3 = '_';
        char chDuke4 = '(';
        char chDuke5 = ')';
        System.out.println("    " + chDuke1 + chDuke2 +  
                        "\n   " + chDuke1 + "  " + chDuke2 +  
                        "\n  " + chDuke1 + chDuke3 + chDuke4 + " " + chDuke5 + chDuke2 + 
                        "\n " + chDuke1 + "      " + chDuke2 + 
                        " \n" + chDuke1 + chDuke3 + chDuke3 + chDuke3 + chDuke3 + chDuke1 + 
                        chDuke2 + chDuke3 + chDuke3 + chDuke2);

        System.out.println("\n8. Вывод количества сотен, десятков и единиц числа");
        int num = 123;
        int hundreds = num / 100;
        num = num % 100;
        int tens = num / 10;
        int units = num % 10;
        int sum = hundreds + tens + units;
        int multiplication = hundreds * tens * units;
        System.out.println("Число N содержит: \nсотен - " + hundreds + "\nдесятков - " + tens + 
                        "\nединиц - " + units + "\nСумма его цифр = " + sum + "\nПроизведение = " + 
                        multiplication);

        System.out.println("\n9. Вывод времени");
        int inputTime = 86399;
        int hours = inputTime / 3600;
        int minutes = (inputTime % 3600) / 60;
        int seconds = (inputTime % 3600) % 60;
        String outputTime = (hours + ":" + minutes + ":" + seconds);
        System.out.println(outputTime);
        }
}