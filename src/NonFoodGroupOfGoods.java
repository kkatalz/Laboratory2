import java.io.FileWriter;
import java.io.IOException;

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

    public void writeNonFoodGroup(){
        try{
            // the path of the file must be changed depending on the user
            FileWriter fw = new FileWriter("/home/liza/IdeaProjects/Laboratory2/NonFoodGroup.txt");
            String s;
            fw.write("Непродовольчі товари: ");
            fw.write(System.getProperty( "line.separator" ));
            for (Goods goods : nonFoodGroup) {
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

