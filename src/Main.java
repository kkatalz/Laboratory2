//TODO 0.Існує декілька груп товарів (наприклад: Продовольчі, непродовольчі...). У кожній групі товарів існують конкретні
// товари (наприклад: борошно, гречка ...).Група товарів містить наступні властивості - назва, опис. У кожного товару є
// наступні властивості - назва, опис, виробник, кількість на складі, ціна за одиницю.
// 1.Реалізувати графічний інтерфейс користувача

public class Main {
    public static void main(String[] args) {

//дві групи продовольчих товарів
        FoodGroupOfGoods foodGroupOfCereals = new FoodGroupOfGoods(new Goods[]{
                new Goods("борошно", "якісно перемелене", "Хуторок", 12, 87),
                new Goods("вівсянка", "крупна", "Наталка", 31, 35),
                new Goods("хліб", "чорносливовий", "Сонечко", 15, 19),
        }, "злакові", "поживні, є групою вуглеводів");

        FoodGroupOfGoods foodGroupOfMilk = new FoodGroupOfGoods(new Goods[]{
                new Goods("молоко", "пастеризоване", "Злагода", 20, 36),
                new Goods("сметана", "жирності 10% ", "Злагода", 25, 33),
                new Goods("шоколадка", "чорний", "Milka", 30, 43),
                new Goods("морозиво", "ванільне", "Ласунка", 40, 45)
        }, "молочка", "молочні фермерські продукти");



//3 групи непродовольчих товарів
        NonFoodGroupOfGoods nonFoodGroupOfCloth = new NonFoodGroupOfGoods(new Goods[]{
                new Goods("джинси", "фасон - бойфренди", "CalvinKlein", 16, 2_000),
                new Goods("світер", "англійський", "Zara", 14, 2_500),
        }, "одяг", "брендовий одяг , виготовлений у В'єтнамі");

        NonFoodGroupOfGoods nonFoodGroupOfElectronic = new NonFoodGroupOfGoods(new Goods[]{
                new Goods("навушники", "бездротові", "Sony", 50, 400),
                new Goods("електронна книжка", "зручний", "Sony", 15, 900),
        }, "електроніка", "країна виготовлення - США");


        NonFoodGroupOfGoods nonFoodGroupOfHomely = new NonFoodGroupOfGoods(new Goods[]{
                new Goods("крісло", "м'яке", "IKEA", 7, 5_000),
                new Goods("шампунь", "для волосся з посіченими кінчиками", "Garnier", 40, 180),
        }, "усе для дому", "найпотрібніше у кінця дня");


    }
}