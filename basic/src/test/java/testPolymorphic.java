public class testPolymorphic {
    public static void main(String[] args) {
        polymorphic pm1 = new son1();
        polymorphic pm2 = new son2();

        pm1.hello();
        pm2.hello();

        pm2 = pm1;
        pm2.hello();
    }
}
