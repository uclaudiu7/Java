package week1;

public class Compulsory {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        String languages[] = {"C", "C++", "C#", "Python", "Go", "Rust", "JavaScript", "PHP", "Swift", "Java"};

        int n = (int) (Math.random() * 1_000_000);
        System.out.println("Radnom number:" + n);

        n = n*3;
        System.out.println(n);
        n = n + Integer.parseInt("10101", 2);
        System.out.println(n);
        n = n + Integer.parseInt("FF", 16);
        System.out.println(n);
        n = n*6;
        System.out.println(n);

        while(n/10 != 0){
            int aux = n;
            n = 0;
            while(aux/10 != 0){
                n += aux%10;
                aux = aux/10;
            }
            n += aux;
            System.out.println(n);
        }

        int result = n;
        System.out.println("Willy-nilly, this semester I will learn " + languages[result] + ".");

    }
}
