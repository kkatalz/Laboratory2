//Клас : продовольча група товарів . Властивості - назва, опис.
public class FoodGroupOfGoods {

Goods[] foodGroup;
    String name;
    String description;

    public FoodGroupOfGoods(Goods[] foodGroup,String name,String description){//масив з конкретним товаром,загальної назви для цілої групи та її опис
        this.foodGroup=foodGroup;
        this.name=name;
        this.description=description;
    }

    public FoodGroupOfGoods(){//порожній масив для створення нового товару користувачем
        this.foodGroup=new Goods[0];
    }


    //return global items
    public String getName(){
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Goods[] getFoodGroup() {
        return foodGroup;
    }
}
