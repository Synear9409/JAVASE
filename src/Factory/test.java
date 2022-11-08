package Factory;


public class test {
    public static void main(String args[]) {
        PhoneFactory factory = new PhoneFactory();
        Phone mPhone = factory.getInstance("IPhone");          // make xiaomi phone!
        // Phone mPhone = factory.getInstance("Miphone");  
        // mPhone.make();
    }
}