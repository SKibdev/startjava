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
        double rezult = penPrice + bookPrice;
        System.out.println("Общая стоимость товаров без скидки: " + rezult +
                " руб.\nCумма скидки: " + (rezult * discount) + 
                " руб.\nОбщая стоимость товаров со скидкой: " + (rezult - rezult * discount) + 
                " руб.");

        System.out.println("\n3. Вывод слова JAVA");
        System.out.println("   J    a  v     v  a\n" + 
                "   J   a a  v   v  a a\n" + 
                "J  J  aaaaa  V V  aaaaa\n" + 
                " JJ  a     a  V  a     a");

        System.out.println("\n4. Вывод min и max значений целых числовых типов");
        byte varByte = 127;
        System.out.println("Переменная типа byte:\n первоначальное значение: " + varByte + 
                "\n значение после инкремента на единицу: " + (++varByte) + 
                "\n значение после декремента на единицу: " + (--varByte));
        short varShort = 32_767;
        System.out.println("Переменная типа short:\n первоначальное значение: " + varShort + 
                "\n значение после инкремента на единицу: " + (++varShort) + 
                "\n значение после декремента на единицу: " + (--varShort));
        int varInt = 2_147_483_647;
        System.out.println("Переменная типа int:\n первоначальное значение: " + varInt + 
                "\n значение после инкремента на единицу: " + (++varInt) + 
                "\n значение после декремента на единицу: " + (--varInt));
        long varLong = 9_223_372_036_854_775_807L;
        System.out.println("Переменная типа long:\n первоначальное значение: " + varLong + 
                "\n значение после инкремента на единицу: " + (++varLong) + 
                "\n значение после декремента на единицу: " + (--varLong));

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
        char charDollar = '$';
        char charAsterisk = '*';
        char charAtSign = '@';
        char charVerticalBar = '|';
        char charTilde = '~';
        System.out.println((int) charDollar + "\t" + charDollar + "\n" + (int) charAsterisk + 
                "\t" + charAsterisk + "\n" + (int) charAtSign + "\t" + charAtSign + "\n" + 
                (int) charVerticalBar + "\t" + charVerticalBar + "\n" + 
                (int) charTilde + "\t" + charTilde);

        System.out.println("\n7. Вывод в консоль ASCII-арт Дюка");
        char charSlash = '/';
        char charBackslash = '\\';
        char charUnderscore = '_';
        char charLeftParenthesis = '(';
        char charRightParanthesis = ')';
        System.out.println("    " + charSlash + charBackslash +  
                "\n   " + charSlash + "  " + charBackslash +  
                "\n  " + charSlash + charUnderscore + charLeftParenthesis + " " + 
                charRightParanthesis + charBackslash + 
                "\n " + charSlash + "      " + charBackslash + 
                " \n" + charSlash + charUnderscore + charUnderscore + charUnderscore + 
                charUnderscore + charSlash + charBackslash + charUnderscore + 
                charUnderscore + charBackslash);

        System.out.println("\n8. Вывод количества сотен, десятков и единиц числа");
        int num = 123;
        int hundreds = num / 100;
        int tens = num %100 / 10;
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