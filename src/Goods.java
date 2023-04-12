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

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription(){
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMaker(){
        return this.maker;
    }

    public void setMaker(String maker) {
        this.maker = maker;
    }

    public int getAmountOnStock(){
        return amountOnStock;
    }

    public void setAmountOnStock(int amountOnStock) {
        this.amountOnStock = amountOnStock;
    }

    public double getPrice(){
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String toString(){
        return "Назва: " + this.name + "Опис: " + this.description + " Виробник: " + this.maker + " Кількість : " + this.amountOnStock +
                " Ціна : " + this.price;
    }

}
