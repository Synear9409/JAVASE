package LinkList.SuperMarket;

public class Cashier { ////收银台
    private IShopCar shopCar;
    public Cashier(IShopCar shopCar){
        this.shopCar = shopCar;
    }
    public double allPrice(){   ///计算总价
        double price = 0.0;
        Object[] result = this.shopCar.getAll();
        for(Object obj : result){
            IGoods goods = (IGoods)obj;
            price += goods.getPrice();
        }
        return price;
    }
    public int allCount(){
        return this.shopCar.getAll().length;
    }
}