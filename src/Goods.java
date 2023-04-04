import java.io.Serializable;

//Клас :  товари. Властивості - назва, опис, виробник, кількість на складі, ціна за одиницю.
public class Goods {
    String name;
    String description;
    String maker;
    int amountOnStock;
    double price;

    public Goods(String name, String description,String maker, int amountOnStock, double price){
        this.name=name;
        this.description=description;
        this.maker=maker;
        this.amountOnStock=amountOnStock;
        this.price=price;
    }


    //return for specific item
    public String getName(){
        return name;
    }

    public String getDescription(){
        return description;
    }
    public String getMaker(){
        return maker;
    }

    public int getAmountOnStock(){
        return amountOnStock;
    }

    public double getPrice(){
        return price;
    }


}
