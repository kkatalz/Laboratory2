import java.io.FileWriter;
import java.io.IOException;

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
                fw.write(s);
                fw.write("Усі товари даної групи: ");
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


    }

}
