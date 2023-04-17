//                                   Робота невеликого підприємства по роботі зі складом
//TODO 0.Існує декілька груп товарів (наприклад: Продовольчі, непродовольчі...). У кожній групі товарів існують конкретні
// товари (наприклад: борошно, гречка ...).Група товарів містить наступні властивості - назва, опис. У кожного товару є
// наступні властивості - назва, опис, виробник, кількість на складі, ціна за одиницю.
// 1.Реалізувати графічний інтерфейс користувача
//5. Додавання\редагування\видалення групи товарів- при видаленні групи товарів , видаляти й всі товари в даній групі

import java.awt.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

//дві групи продовольчих товарів
        Group foodGroupOfCereals = new Group(new Goods[]{
                new Goods("борошно", "якісно перемелене", "Хуторок", 12, 87),
                new Goods("вівсянка", "крупна", "Наталка", 31, 35),
                new Goods("хліб", "чорносливовий", "Сонечко", 15, 19),
        }, "Злакові", "Поживні, є групою вуглеводів");

        Group foodGroupOfMilk = new Group(new Goods[]{
                new Goods("молоко", "пастеризоване", "Злагода", 20, 36),
                new Goods("сметана", "жирності 10% ", "Злагода", 25, 33),
                new Goods("шоколадка", "чорний", "Milka", 30, 43),
                new Goods("морозиво", "ванільне", "Ласунка", 40, 45)
        }, "Молочка", "Молочні фермерські продукти");


//3 групи непродовольчих товарів
        Group nonFoodGroupOfCloth = new Group(new Goods[]{
                new Goods("джинси", "фасон - бойфренди", "CalvinKlein", 16, 2_000),
                new Goods("світер", "англійський", "Zara", 14, 2_500),
        }, "Одяг", "Брендовий одяг , виготовлений у В'єтнамі");

        Group nonFoodGroupOfElectronic = new Group(new Goods[]{
                new Goods("навушники", "бездротові", "Sony", 50, 400),
                new Goods("електронна книжка", "зручний", "Sony", 15, 900),
        }, "Електроніка", "Країна виробник - США");


        Group nonFoodGroupOfHomely = new Group(new Goods[]{
                new Goods("крісло", "м'яке", "IKEA", 7, 5_000),
                new Goods("шампунь", "для волосся з посіченими кінчиками", "Garnier", 40, 180),
        }, "Усе для дому", "Найпотрібніше після важкого дня");


        //check if works
        nonFoodGroupOfHomely.addGoodsToGroup("світер", "англійський", "Zara", 14, 2_500);

        for (Goods good : nonFoodGroupOfHomely.getGoods()) {
            System.out.println(good.getName());
        }

        Storage workWithGroup = new Storage(new Group[]{foodGroupOfCereals, foodGroupOfMilk, nonFoodGroupOfCloth, nonFoodGroupOfElectronic, nonFoodGroupOfHomely});

//        EventQueue.invokeLater(() -> new Tree(workWithGroup).setVisible(true));

        Interaction interactionWithUser = new Interaction(workWithGroup);
        interactionWithUser.setVisible(true);
        interactionWithUser.setLocationRelativeTo(null);
    }
}