package calculator2;

public class Romes extends Number {
    private String romes_value1;
    private String romes_value2;
    private int romes_value1_int;
    private int romes_value2_int;
    private int result_int;
    private String sign = "";
    private String result_string;
    private final String[] roman_letters_9 = new String[]{"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};

    Romes(String value1, String value2) {
        this.romes_value1 = value1;
        this.romes_value2 = value2;
        this.romes_value1_int = this.convert_to_int(this.romes_value1);
        this.romes_value2_int = this.convert_to_int(this.romes_value2);
    }

    private String convert_result_to_Romes(int n, int ostatok) {
        ostatok = n % 10;
        if (ostatok != 0) {
            try {
                return this.convert_result_to_Romes(n - ostatok, 0) + this.roman_letters_9[ostatok - 1];
            } catch (ArrayIndexOutOfBoundsException var4) {
                this.sign = "-";
                return this.convert_result_to_Romes(n - ostatok, 0) + this.roman_letters_9[(ostatok + 1) * -1];
            }
        } else if (n > 0) {
            n -= 10;
            return this.convert_result_to_Romes(n, 0) + "X";
        } else if (n < 0) {
            n += 10;
            return this.convert_result_to_Romes(n, 0) + "X";
        } else {
            return this.sign;
        }
    }

    public void sum() {
        this.result_int = this.romes_value1_int + this.romes_value2_int;
        this.result_string = this.convert_result_to_Romes(this.result_int, this.result_int);
    }

    public void sub() {
        this.result_int = this.romes_value1_int - this.romes_value2_int;
        this.result_string = this.convert_result_to_Romes(this.result_int, this.result_int);
    }

    public void div() {
        try {
            this.result_int = this.romes_value1_int / this.romes_value2_int;
            this.result_string = this.convert_result_to_Romes(this.result_int, this.result_int);
        } catch (ArithmeticException var2) {
            System.out.print("Проверьте правильность ввода римских цифр. Вероятно введены и арабские и римские одновременно. ");
        }
    }

    public void mul() {
        this.result_int = this.romes_value1_int * this.romes_value2_int;
        this.result_string = this.convert_result_to_Romes(this.result_int, this.result_int);
    }

    public int getResult() {
        return this.result_int;
    }

    public String getStringResult() {
        return this.result_string;
    }

    private int convert_to_int(String romes_value) {
        char[] value_char = romes_value.toCharArray();
        int[] values_int = new int[value_char.length];

        int result;
        for(result = 0; result < value_char.length; ++result) {
            switch(value_char[result]) {
                case 'I':
                    values_int[result] = 1;
                    break;
                case 'V':
                    values_int[result] = 5;
                    break;
                case 'X':
                    values_int[result] = 10;
                    break;
                default:
                    System.out.println("Содержится неверный символ. Проверьте правильность ввода римских цифр:\nI = 1\nV = 5\nX = 10");
            }
        }

        result = values_int[0];

        for(int i = 0; i < values_int.length && values_int.length > i + 1; ++i) {
            if (values_int[i] >= values_int[i + 1]) {
                result += values_int[i + 1];
            } else if (values_int[i] < values_int[i + 1]) {
                result = result + values_int[i + 1] - 2;
            }
        }

        return result;
    }

    public String getRomes_value1() {
        return this.romes_value1;
    }

    public String getRomes_value2() {
        return this.romes_value2;
    }

    public void setRomes_value1(String romes_value1) {
        this.romes_value1 = romes_value1;
    }

    public void setRomes_value2(String romes_value2) {
        this.romes_value2 = romes_value2;
    }

    public int getRomes_value1_int() {
        return this.romes_value1_int;
    }

    public int getRomes_value2_int() {
        return this.romes_value2_int;
    }

    public void setRomes_value1_int(int romes_value1_int) {
        this.romes_value1_int = romes_value1_int;
    }

    public void setRomes_value2_int(int romes_value2_int) {
        this.romes_value2_int = romes_value2_int;
    }
}
