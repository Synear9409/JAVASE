package LinkList.SuperMarket;

public class Book implements IGoods {
    private String name;
    private double price;
    public Book(String name, double price){
        this.name = name;
        this.price = price;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public double getPrice() {
        return this.price;
    }

    @Override
    public String toString() {
        return "Book [name=" + name + ", price=" + price + "]";
    }
    
    ////覆写equals方法


    
}