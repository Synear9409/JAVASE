package LinkList.SuperMarket;

public interface IShopCar {
    public void add(IGoods goods);      //添加商品
    public void delete(IGoods goods);   ///删除商品
    public Object[] getAll();           //获取购物车所有商品
}