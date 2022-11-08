package LinkList.SuperMarket;

import LinkList.ILink;
import LinkList.LinkImp;

public class ShopCarImp implements IShopCar {

    private ILink<IGoods> allGood = new LinkImp<>();

    @Override
    public void add(IGoods goods) {
        this.allGood.add(goods);
    }

    @Override
    public void delete(IGoods goods) {
        this.allGood.remove(goods);
    }

    @Override
    public Object[] getAll() {
        return this.allGood.toArray();
    }
    
}