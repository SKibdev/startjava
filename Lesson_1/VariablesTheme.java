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
        double penPrice = 200.00;
        double bookPrice = 100.00;
        double discount = 0.11;
        double withoutDiscount = penPrice + bookPrice;
        System.out.println("Общая стоимость товаров без скидки: " + withoutDiscount +
                " руб.\nCумма скидки: " + (withoutDiscount * discount) + 
                " руб.\nОбщая стоимость товаров со скидкой: " +
                 (withoutDiscount - withoutDiscount * discount) + " руб.");

        System.out.println("\n3. Вывод слова JAVA");
        System.out.println("   J    a  v     v  a\n" + 
                "   J   a a  v   v  a a\n" + 
                "J  J  aaaaa  V V  aaaaa\n" + 
                " JJ  a     a  V  a     a");

        System.out.println("\n4. Вывод min и max значений целых числовых типов");
        byte maxByte = 127;
        System.out.println("Переменная типа byte:\n первоначальное значение: " + maxByte + 
                "\n значение после инкремента на единицу: " + (++maxByte) + 
                "\n значение после декремента на единицу: " + (--maxByte));
        short maxShort = 32_767;
        System.out.println("Переменная типа short:\n первоначальное значение: " + maxShort + 
                "\n значение после инкремента на единицу: " + (++maxShort) + 
                "\n значение после декремента на единицу: " + (--maxShort));
        int maxInt = 2_147_483_647;
        System.out.println("Переменная типа int:\n первоначальное значение: " + maxInt + 
                "\n значение после инкремента на единицу: " + (++maxInt) + 
                "\n значение после декремента на единицу: " + (--maxInt));
        long maxLong = 9_223_372_036_854_775_807L;
        System.out.println("Переменная типа long:\n первоначальное значение: " + maxLong + 
                "\n значение после инкремента на единицу: " + (++maxLong) + 
                "\n значение после декремента на единицу: " + (--maxLong));

        System.out.println("\n5. Перестановка значений переменных");
        int num1 = 2;
        int num2 = 5;
        System.out.println("Перестановка с помощью третьей переменной\n" + 
                " исходные значения переменных: num1 = " + num1 + " num2 = " + num2);
        int tmp = num1;
        num1 = num2;
        num2 = tmp;
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
        char dollar = '$';
        char asterisk = '*';
        char atSign = '@';
        char verticalBar = '|';
        char tilde = '~';
        System.out.println((int) dollar + "\t" + dollar + "\n" + (int) asterisk + 
                "\t" + asterisk + "\n" + (int) atSign + "\t" + atSign + "\n" + 
                (int) verticalBar + "\t" + verticalBar + "\n" + 
                (int) tilde + "\t" + tilde);

        System.out.println("\n7. Вывод в консоль ASCII-арт Дюка");
        char slash = '/';
        char backslash = '\\';
        char underscore = '_';
        char leftParenthesis = '(';
        char rightParanthesis = ')';
        System.out.println("    " + slash + backslash +  
                "\n   " + slash + "  " + backslash +  
                "\n  " + slash + underscore + leftParenthesis + " " + 
                rightParanthesis + backslash + 
                "\n " + slash + "      " + backslash + 
                " \n" + slash + underscore + underscore + underscore + 
                underscore + slash + backslash + underscore + 
                underscore + backslash);

        System.out.println("\n8. Вывод количества сотен, десятков и единиц числа");
        int num = 123;
        int hundreds = num / 100;
        int tens = num % 100 / 10;
        int ones = num % 10;
        int sum = hundreds + tens + ones;
        int multiplication = hundreds * tens * ones;
        System.out.println("Число N содержит: \nсотен - " + hundreds + "\nдесятков - " + tens + 
                "\nединиц - " + ones + "\nСумма его цифр = " + sum + 
                "\nПроизведение = " + multiplication);

        System.out.println("\n9. Вывод времени");
        int inputTime = 86399;
        int hours = inputTime / 3600;
        int minutes = inputTime / 60 % 60;
        int seconds = inputTime % 60;
        System.out.println(hours + ":" + minutes + ":" + seconds);
    }
}