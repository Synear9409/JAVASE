package Factory;

public class PhoneFactory {
    public Phone getInstance(String phoneType) {
        if(phoneType.equals("MiPhone")){
            return new MiPhone();
        }
        else if(phoneType.equals("IPhone")) {
            return new Iphone();
        }
        return null;
    }
}