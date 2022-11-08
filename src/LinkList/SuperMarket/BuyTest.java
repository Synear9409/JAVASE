package LinkList.SuperMarket;

public class BuyTest {
    public static void main(String[] args) {
        IShopCar shopCar = new ShopCarImp();
        Book book = new Book("Java开发", 79.80);
        shopCar.add(book);
        shopCar.add(new Bag("爱华仕", 200.80));
        
        // shopCar.delete(book);
        Cashier cashier = new Cashier(shopCar);
        System.out.println("总价格为："+cashier.allPrice()+"、购买物品的个数："+cashier.allCount());

        
        Object[] obj = shopCar.getAll();
        for(Object o : obj){
            System.out.println(o);
        }
    }
    
}