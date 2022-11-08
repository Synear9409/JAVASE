package LinkList.Pet;

public class Dog implements Pet {
    private String name;
    private String color;

    public Dog(String name, String color) {
        this.name = name;
        this.color = color;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getColor() {
        return this.color;
    }

    @Override
    public String toString() {
        return "宠物狗 [color=" + color + ", name=" + name + "]";
    }

    // @Override
    // public boolean equals(Object obj) {
    //     if(obj == null){
    //         return false;
    //     }
    //     if(!(obj instanceof Cat)){
    //         return false;
    //     }
    //     if(this == obj){
    //         return true;
    //     }
    //     Dog dog = (Dog)obj;
    //     return this.name.equals(dog.name) && this.color.equals(dog.color);
    // }
}