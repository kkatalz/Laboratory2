import java.io.*;

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

    public void writeFoodGroup(){
        try{
            // the path of the file must be changed depending on the user
            FileWriter fw = new FileWriter("/home/liza/IdeaProjects/Laboratory2/FoodGroup.txt");
            String s;
            fw.write("Продовольчі товари: ");
            fw.write(System.getProperty( "line.separator" ));
            for (Goods goods : foodGroup) {
                s = "Назва: " + goods.getName() + ". Опис: " + goods.getDescription() + ". Виробник: " + goods.getMaker() +
                ". Кількість на складі: " + goods.getAmountOnStock() + ". Ціна: " + goods.getPrice();
                fw.write(s);
                fw.write(System.getProperty("line.separator"));
            }
            fw.close();
        } catch (IOException e){
            System.out.println(e);
        }
    }
}
