public class Group {
    private Goods[] goods;
    private String name;
    private String description;

    Group(String name, String description){
        this.name = name;
        this.description = description;
    }

    public String getName(){
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public Goods[] getGoods() {
        return this.goods;
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
    }

