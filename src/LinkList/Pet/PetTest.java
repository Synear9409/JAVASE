package LinkList.Pet;

public class PetTest {
    public static void main(String[] args) {
        PetShop petShop = new PetShop();  ///开店
        Dog dog1 = new Dog("小黄狗", "淡黄色");
        petShop.add(new Cat("黄猫", "黄色"));
        petShop.add(dog1);
        petShop.add(new Cat("加菲猫", "灰色"));
        petShop.add(new Dog("萨摩亚", "白色"));

        petShop.delete(dog1);

        Object[] obj = petShop.search("黄").toArray();
        for(Object o : obj){
            System.out.println(o);
        }
    }
    
}