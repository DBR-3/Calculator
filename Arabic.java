package calculator2;

public class Arabic extends Number {
    private int value1;
    private int value2;
    private int result;

    Arabic(int value1, int value2) {
        this.value1 = value1;
        this.value2 = value2;
    }

    public void sum() {
        this.result = this.value1 + this.value2;
    }

    public void sub() {
        this.result = this.value1 - this.value2;
    }

    public void div() {
        try {
            this.result = this.value1 / this.value2;
        } catch (ArithmeticException var2) {
            System.out.print("Деление на 0! ");
        }
    }

    public void mul() {
        this.result = this.value1 * this.value2;
    }

    public int getResult() {
        return this.result;
    }

    public String getStringResult() {
        return "" + this.result;
    }

    public int getValue1() {
        return this.value1;
    }

    public int getValue2() {
        return this.value2;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public void setValue1(int value1) {
        this.value1 = value1;
    }

    public void setValue2(int value2) {
        this.value2 = value2;
    }
}
