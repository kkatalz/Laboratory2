//Клас : продовольча група товарів . Властивості - назва, опис.
public class FoodGroupOfGoods {

Goods[] foodGroup;
    String name;
    String description;

    public FoodGroupOfGoods(Goods[] foodGroup,String name,String description){
        this.foodGroup=foodGroup;
        this.name=name;
        this.description=description;
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
