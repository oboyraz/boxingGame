public class Main {
    public static void main(String[] args) throws InterruptedException {
        Fighter f1 = new Fighter("A",10,100,90,30);
        Fighter f2 = new Fighter("B",15, 100, 95,20);

        Match m1 = new Match(f1,f2,80,100);
        m1.run();
    }
}