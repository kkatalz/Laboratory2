//Клас : непродовольча група товарів. Властивості - назва, опис.
public class NonFoodGroupOfGoods {


    Goods[] nonFoodGroup;
    String name;
    String description;

    public NonFoodGroupOfGoods(Goods[] nonFoodGroup,String name,String description){
        this.nonFoodGroup=nonFoodGroup;
        this.name=name;
        this.description=description;
    }

    public NonFoodGroupOfGoods(){//порожній масив для створення нового товару користувачем
        this.nonFoodGroup=new Goods[0];
    }

    //return global items
    public String getName(){
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Goods[] getNonFoodGroup() {
        return nonFoodGroup;
    }
}

