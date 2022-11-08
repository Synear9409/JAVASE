package LinkList.Pet;

import LinkList.ILink;
import LinkList.LinkImp;

public class PetShop {
    private ILink<Pet> allPets = new LinkImp<>();
    public void add(Pet pet){  ////宠物上架
        this.allPets.add(pet);
    }
    public void delete(Pet pet){  //宠物下架
        this.allPets.remove(pet);
    }
    public ILink<Pet> search(String keyWord){
        ILink<Pet> searchResult = new LinkImp<>();  ///保存查询结果
        Object[] result = this.allPets.toArray();
        if(result != null){
            for(Object obj:result){
                Pet pet = (Pet)obj;
                if(pet.getName().contains(keyWord) || pet.getColor().contains(keyWord)){  ///String类中的contains()，是判断目标对象中是否含有子字符串
                    searchResult.add(pet);  ///保存
                }
            }
        }
        return searchResult;
    }
}