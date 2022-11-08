package LinkList.Pet;

public class Cat implements Pet {
    private String name;
    private String color;

    public Cat(String name, String color) {
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
        return "宠物猫 [color=" + color + ", name=" + name + "]";
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
    //     Cat cat = (Cat)obj;
    //     return this.name.equals(cat.name) && this.color.equals(cat.color);
    // }
    
}