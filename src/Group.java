import static java.util.Arrays.copyOf;

//містить масив товарів
public class Group {
    private Goods[] goods;
    private String name;
    private String description;

    //для готової групи,яка містить товари, назву й опис групи
    public Group(Goods[] foodGroup,String name,String description){//масив з конкретним товаром,загальної назви для цілої групи та її опис
        this.goods=foodGroup;
        this.name=name;
        this.description=description;
    }


    //для створення порожнього без товарів
    Group(String name, String description){
        this.name = name;
        this.description = description;
    }

    public String getName(){
        return this.name;
    }
    public void setName(String newName){this.name=newName;}

    public String getDescription() {
        return this.description;
    }
    public void setDescription(String newDescription){this.description=newDescription;}

    public Goods[] getGoods() {
        return this.goods;
    }

    public void setGoods(Goods[] goods) {
        this.goods = goods;
    }

    // second task
    public String getInfo(){
        String s ="";
            for (Goods goods : this.goods) {
                s += "Назва: " + goods.getName() + ". Опис: " + goods.getDescription() + ". Виробник: " + goods.getMaker() +
                        ". Кількість на складі: " + goods.getAmountOnStock() + ". Ціна: " + goods.getPrice();
            }
            return s;
        }



    //ПУНКТ 6
    // додавання товарів до групи
    public void addGoodsToGroup(String name, String description,String maker, int amountOnStock, double price) {
        this.goods = copyOf(this.goods, this.goods.length + 1);
        this.goods[this.goods.length - 1] = new Goods(name,description,maker,amountOnStock,price);
        System.out.println("Додаємо товар до групи " + this.goods[this.goods.length - 1]);

    }

    //редагування товарів в групі
    public void editGoodsInGroup(int whichOfGoodsToChange, String name, String description,String maker, int amountOnStock, double price) {
        Goods pastGoods;

        for (int i = 0; i < this.goods.length; i++) {
            if (i == whichOfGoodsToChange) {
                pastGoods = this.goods[i];
                pastGoods.setName(name);
                pastGoods.setDescription(description);
                pastGoods.setMaker(maker);
                pastGoods.setAmountOnStock(amountOnStock);
                pastGoods.setPrice(price);

            }
        }
    }

    //видалення товарів в групі
    public void deleteGoodsInGroup(int whichGoodsToDelete) {

        Goods[] newGoods = new Goods[this.goods.length-1];//cut the array because one of the elements wil be deleted

        for (int i = 0, k = 0; i < this.goods.length; i++) {
            if(i!=whichGoodsToDelete){
                newGoods[k] = goods[i];
                k++;
            }
        }

        this.goods = newGoods;

    }
    public int getNumberOfGoods(){

        return this.goods.length;
    }
    public String toString(){
        return this.name + this.description;
    }

}

