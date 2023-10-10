package complex_number;

public class ComplexNumberUse {

    public static void main(String[] args) {
        ComplexNumber c1 = new ComplexNumber(10,2);
        c1.print();

        ComplexNumber c2 = new ComplexNumber(2,10);

        ComplexNumber c3 = ComplexNumber.add(c1,c2);
        c3.print();

        ComplexNumber c4 = c2.conjugate();
        c4.print();

    }
}
