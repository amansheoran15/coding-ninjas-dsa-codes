package complex_number;

public class ComplexNumber {
    int real;
    int img;

    public ComplexNumber(int real,int img){
        this.real = real;
        this.img = img;
    }

    public void print(){
        if(img<0){
            System.out.println(this.real +" - " + -this.img + "i");
        }else
            System.out.println(this.real +" + " + this.img + "i");
    }

    public void plus(ComplexNumber c){
        this.real += c.real;
        this.img += c.img;
    }

    public void subtract(ComplexNumber c){
        this.real += c.real;
        this.img += c.img;
    }

    public void multiply(ComplexNumber c){
        this.real = (this.real*c.real) - (this.img * c.img);
        this.img = (this.real*c.img) + (this.img*c.real);
    }

    public static ComplexNumber add(ComplexNumber c1, ComplexNumber c2){
        int real = c1.real + c2.real;
        int img = c1.img + c2.img;
        return new ComplexNumber(real,img);
    }

    public ComplexNumber conjugate(){
        int img = -this.img;
        return new ComplexNumber(this.real,img);
    }
}
