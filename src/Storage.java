import java.io.FileWriter;
import java.io.IOException;

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
}
