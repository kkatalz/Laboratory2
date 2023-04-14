import org.w3c.dom.ls.LSOutput;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

import static java.util.Arrays.binarySearch;
import static java.util.Arrays.copyOf;

//містить масив груп
public class Storage {
    Group[] groups;

    Storage() {
        groups = new Group[0];
    }

    // second task: to write all groups and their goods to file
    public void writeAllGroups() {
        try {
            // the path of the file must be changed depending on the user
            FileWriter fw = new FileWriter("/home/liza/IdeaProjects/Laboratory2/AllGroups.txt");
            String s;
            fw.write("Усі групи: ");
            fw.write(System.getProperty("line.separator"));
            for (Group gr : groups) {
                s = gr.getName();
                fw.write("Група: " + s);
                fw.write(". Усі товари даної групи: ");
                s = gr.getInfo();
                fw.write(System.getProperty("line.separator"));
                fw.write(s);
                fw.write(System.getProperty("line.separator"));
            }
            fw.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }


    //ПУНКТ 5
    // додавання групи
    public void addGroup(String name, String description) {
        this.groups = copyOf(this.groups, this.groups.length + 1);
        this.groups[this.groups.length - 1] = new Group(name, description);
        System.out.println("Додаємо групу " + this.groups[this.groups.length - 1]);
        int numberOfGroups = groups.length;

    }

    //редагування групи
    public void editGroup(int whichGroupToChange, String name, String description) {
        Group pastGroup;

        for (int i = 0; i < this.groups.length; i++) {
            if (i == whichGroupToChange) {
                pastGroup = this.groups[i];
                pastGroup.setName(name);
                pastGroup.setDescription(description);
            }
        }
        System.out.println(Arrays.toString(this.groups));
    }

    //видалення групи
    public void deleteGroup(int whichGroupToDelete) {

        Group[] newGroup = new Group[this.groups.length-1];

        for (int i = 0, k = 0; i < this.groups.length; i++) {
            if(i!=whichGroupToDelete){
                newGroup[k] = groups[i];
                k++;
            }
        }
        this.groups = newGroup;

        System.out.println(Arrays.toString(this.groups));


    }
    // to return information about concrete group
    public String getInfoAboutGroup(int i){
       String s;
       s = "Назва: " + this.groups[i].getName() + ". " + "Опис: " + this.groups[i].getDescription() + ". ";
       return s;
    }

    public String getDescOfGroup(int index){
        return this.groups[index].getDescription();
    }

    public String getNameOfGroup(int index){
        return this.groups[index].getName();
    }
    public int numberOfGroups(){
        return this.groups.length;
    }

    public Group getGroup(int index){
        return this.groups[index];
    }

    // to get an array of goods names of specified group
    public String[] getNamesOfGoods(int indexOfGroup){
        return this.groups[indexOfGroup].getNamesOfGoods();
    }

    // перевірка чи назва товару унікальна (третій пункт)
    // повертає false, якщо назва товару вже є і true якщо назва товару унікальна
    public boolean searchForDuplicatesOfGoods(String nameOfGood){
        for(int i =0; i < this.groups.length; i++){
            for(int j = 0; j < this.groups[i].getNumberOfGoodsInGroup(); j++) {
               if(this.groups[i].getGood(j).getName().equals(nameOfGood)) return false;
            }
        }
        return true;
    }
    // знайти товар (восьмий пункт)
    public String[] searchForGoods(String nameOfGoods){
        String[] s = new String[4];
        for(Group group : this.groups){
            for(int j =0; j < group.getNumberOfGoodsInGroup(); j++){
                if(group.getGood(j).getName().equals(nameOfGoods)) {
                    s[0] = "Назва: " + group.getGood(j).getName();
                    s[0] = s[0].replaceAll("null", "");
                    s[1] = " Опис: " + group.getGood(j).getDescription();
                    s[2] = " Виробник: "+ group.getGood(j).getMaker();
                    s[3] = "Кількість: " +
                            group.getGood(j).getAmountOnStock() + ". Ціна: " + group.getGood(j).getPrice();
                }
            }
        }
        System.out.println(Arrays.toString(s));
        return s;
    }



}
