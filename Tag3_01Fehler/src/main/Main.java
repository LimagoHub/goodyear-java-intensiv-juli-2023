package main;
public class Main {
    public static void main(String[] args) {

      new Main().run();
    }

    private void run() {
        try {
            int feld[] = new int[2];
            int a,b,c;
            a = b = 0;
            c =  a / b;
            feld[1000] = 13;


        } catch (ArithmeticException | ArrayIndexOutOfBoundsException e) {
            System.out.println("A " + e.getMessage());
        }

        catch (Exception e) {
            System.out.println("C " + e.getMessage());
        }

        System.out.println("Ich bin gluecklich");
    }


}

