import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//TODO другий екран -2 кнопки: робота з новими даними й старими

public class Interaction extends JFrame implements ActionListener {
    JButton OKButton, CancelButton, availableDataButton, newDataButton,makeGroup,addGood, BACK, buttonEditGroup,
            buttonEditGoods, buttonDeleteGroup, buttonDeleteGoods,nextToEditGroup, buttonAssignGroup, buttonNextToDeleteGroup;
    JLabel nameLabel, startLabel, whichGroup,whatTo, questionInEdit;
    JPanel mainPanel, buttonPanel,buttonPanelData,panelInteractionWithNewData,buttonPanelNewData,  panelInteractionWithAvailableData,
    buttonPanelAvailableData, buttonPanelInEdit;
    JFrame newFrame,thirdFrame,makeGroupFrame, addGoodFrame, availableDataFrame;
    JSpinner spinnerOfGroup, whatToChange;
    JTextArea listOfGroups;
    JTextArea newNameOrDescOfGroup;
    int numberOfGroup, whatToChangeInEdit;

    JLabel labelTitle;
    JScrollPane scrollText;
    private Storage storage;

    public Interaction(Storage storage) {
        this.storage = storage;

        // for test
        storage.addGroup("їжа", "поїсти");
        storage.addGroup("одяг", "носити");
        storage.addGroup("кава", "пити");
        storage.addGroup("взуття", "взувати");

        this.setTitle("Робота зі складом ");
        this.setSize(500, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // головна панель
        mainPanel = new JPanel();
        mainPanel.setBackground(Color.BLACK);
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // відступ від верхньої частини панелі
        mainPanel.setLayout(new FlowLayout());
        this.add(mainPanel);


        //Назва на головній панелі
        nameLabel = new JLabel("   Робота невеликого підприємства по роботі зі складом");
        nameLabel.setForeground(Color.white);
        nameLabel.setFont(new Font("Georgia", Font.PLAIN, 18));
        nameLabel.setHorizontalAlignment(SwingConstants.LEFT);
        mainPanel.add(nameLabel);

        //Розпочнімо? на головній панелі
        startLabel = new JLabel("Розпочнімо?");
        startLabel.setForeground(Color.white);
        startLabel.setFont(new Font("Georgia", Font.PLAIN, 24));
        startLabel.setBorder(BorderFactory.createEmptyBorder(100, 10, 10, 10));
        startLabel.setHorizontalAlignment(JLabel.CENTER);
        mainPanel.add(startLabel);

        // кнопки на головній панелі
        buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 60, 10));//додається інтервал між кнопками START Cancel
        buttonPanel.setBackground(Color.black);
        this.add(buttonPanel, BorderLayout.SOUTH);

        OKButton = new JButton("START");
        buttonPanel.add(OKButton);
        OKButton.addActionListener(this);

        CancelButton = new JButton("CANCEL");
        buttonPanel.add(CancelButton);
        CancelButton.addActionListener(this);


    }

    public void actionPerformed(ActionEvent event) {

        //відкрити друге вікно
        if (event.getSource() == OKButton) {
            this.setVisible(false);
            newFrame = new JFrame("Взаємодія з даними");
            newFrame.setSize(500, 400);
            newFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            JPanel newPanel = new JPanel();
            newPanel.setBackground(Color.BLACK);
            newPanel.setBorder(BorderFactory.createEmptyBorder(55, 10, 10, 10));
            newPanel.setLayout(new FlowLayout());
            newFrame.add(newPanel);

            JLabel newLabel = new JLabel("Оберіть із якими даними працювати");

            newLabel.setForeground(Color.white);
            newLabel.setFont(new Font("Georgia", Font.ITALIC, 22));
            newLabel.setHorizontalAlignment(JLabel.CENTER);
            newPanel.add(newLabel);

            //кнопки для роботи з даними
            //додається інтервал між кнопками й текстом по горизонту й вертикалі відповідно
            buttonPanelData = new JPanel(new FlowLayout(FlowLayout.CENTER, 40, 40));
            buttonPanelData.setBackground(Color.black);
            newPanel.add(buttonPanelData, BorderLayout.SOUTH);

            availableDataButton = new JButton("із наявними");
            buttonPanelData.add(availableDataButton, BorderLayout.CENTER);
            availableDataButton.addActionListener(this);

            newDataButton = new JButton("створити нові");
            buttonPanelData.add(newDataButton, BorderLayout.CENTER);
            newDataButton.addActionListener(this);

            newFrame.setVisible(true);

            //закрити вікно
        } else if (event.getSource() == CancelButton) {
            this.dispose();

            //створюємо третє вікно
        } else if(event.getSource()==newDataButton){
            newFrame.setVisible(false);

            thirdFrame = new JFrame("Взаємодія з новими даними");
            thirdFrame.setSize(500, 400);
            thirdFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            panelInteractionWithNewData = new JPanel();
            panelInteractionWithNewData.setBackground(Color.BLACK);
            panelInteractionWithNewData.setBorder(BorderFactory.createEmptyBorder(40, 0, 10, 0));
            panelInteractionWithNewData.setLayout(new FlowLayout());
            thirdFrame.add(panelInteractionWithNewData);

            JLabel newLabel = new JLabel("<html> На даній сторінці ви можете додати групу й <br> товар до щойно створеної групи або ж -наявної");
            newLabel.setForeground(Color.white);
            newLabel.setFont(new Font("Georgia", Font.ITALIC, 18));
            newLabel.setHorizontalAlignment(JLabel.CENTER);
            panelInteractionWithNewData.add(newLabel);

            //кнопки для роботи з новими даними
            //додається інтервал між кнопками й текстом по горизонту й вертикалі відповідно
            buttonPanelNewData = new JPanel(new FlowLayout(FlowLayout.CENTER, 40, 40));
            buttonPanelNewData.setBackground(Color.black);
            panelInteractionWithNewData.add(buttonPanelNewData, BorderLayout.SOUTH);

            makeGroup = new JButton("створити групу");
            buttonPanelNewData.add(makeGroup, BorderLayout.CENTER);
            makeGroup.addActionListener(this);

            addGood = new JButton("додати товар до групи");
            buttonPanelNewData.add(addGood, BorderLayout.CENTER);
            addGood.addActionListener(this);

            thirdFrame.setVisible(true);

            //нове вікно, щоб додати групу
        }else if(event.getSource()==makeGroup){
            thirdFrame.setVisible(false);

            makeGroupFrame = new JFrame("Створити групу");
            makeGroupFrame.setSize(500, 400);
            makeGroupFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            panelInteractionWithNewData = new JPanel();
            panelInteractionWithNewData.setBackground(Color.BLACK);
            panelInteractionWithNewData.setBorder(BorderFactory.createEmptyBorder(55, 0, 10, 0));
            makeGroupFrame.add(panelInteractionWithNewData);

            JLabel newLabel = new JLabel("Введіть ім'я для групи та її опис");
            newLabel.setForeground(Color.white);
            newLabel.setFont(new Font("Georgia", Font.ITALIC, 18));
            newLabel.setHorizontalAlignment(JLabel.CENTER);
            panelInteractionWithNewData.add(newLabel);

            JLabel nameLabel = new JLabel("Ім'я:");
            JLabel descriptionLabel = new JLabel("Опис:");

            nameLabel.setForeground(Color.white);
            descriptionLabel.setForeground(Color.white);
            JTextField nameField = new JTextField(15);//видимий розмір
            JTextField descriptionField = new JTextField(15);

            panelInteractionWithNewData.add(nameLabel);
            panelInteractionWithNewData.add(descriptionLabel);
            panelInteractionWithNewData.add(nameField);
            panelInteractionWithNewData.add(descriptionField);

            // Set GridBagConstraints for nameLabel
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.anchor = GridBagConstraints.WEST;
            gbc.insets = new Insets(65, 5, 5, 5);
            panelInteractionWithNewData.add(nameLabel, gbc);

// Set GridBagConstraints for nameField
            gbc = new GridBagConstraints();
            gbc.gridx = 1;
            gbc.gridy = 0;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            gbc.insets = new Insets(65, 5, 5, 5);
            panelInteractionWithNewData.add(nameField, gbc);

// Set GridBagConstraints for descriptionLabel
            gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 1;
            gbc.anchor = GridBagConstraints.WEST;
            gbc.insets = new Insets(65, 5, 5, 5);
            panelInteractionWithNewData.add(descriptionLabel, gbc);

// Set GridBagConstraints for descriptionField
            gbc = new GridBagConstraints();
            gbc.gridx = 1;
            gbc.gridy = 1;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            gbc.insets = new Insets(65, 5, 5, 5);
            panelInteractionWithNewData.add(descriptionField, gbc);


            makeGroupFrame.setVisible(true);
        }
        // to work with already added groups and goods (to edit or delete)
        else if(event.getSource()== availableDataButton){
            newFrame.setVisible(false);


            availableDataFrame = new JFrame("Взаємодія з раніше введеними даними");
            availableDataFrame.setSize(500, 400);
            availableDataFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            panelInteractionWithAvailableData = new JPanel();
            panelInteractionWithAvailableData.setBackground(Color.BLACK);
            panelInteractionWithAvailableData.setBorder(BorderFactory.createEmptyBorder(40, 0, 10, 0));
            panelInteractionWithAvailableData.setLayout(new FlowLayout());
            availableDataFrame.add(panelInteractionWithAvailableData);

            labelTitle = new JLabel("<html> На даній сторінці ви можете редагувати/видалити групу товарів або ж товар");
            labelTitle.setForeground(Color.white);
            labelTitle.setFont(new Font("Georgia", Font.ITALIC, 18));
            labelTitle.setHorizontalAlignment(JLabel.CENTER);
            panelInteractionWithAvailableData.add(labelTitle);

            buttonPanelAvailableData = new JPanel(new FlowLayout(FlowLayout.CENTER, 40, 40));
            buttonPanelAvailableData.setBackground(Color.black);
            panelInteractionWithAvailableData.add(buttonPanelAvailableData, BorderLayout.SOUTH);

            buttonEditGroup = new JButton("Редагувати групу");
            buttonPanelAvailableData.add(buttonEditGroup, BorderLayout.CENTER);
            buttonEditGroup.addActionListener(this);

            buttonDeleteGroup = new JButton("Видалити групу");
            buttonPanelAvailableData.add(buttonDeleteGroup, BorderLayout.CENTER);
            buttonDeleteGroup.addActionListener(this);

            buttonEditGoods = new JButton("Редагувати товар");
            buttonPanelAvailableData.add(buttonEditGoods, BorderLayout.CENTER);
            buttonEditGoods.addActionListener(this);

            buttonDeleteGoods = new JButton("Видалити товар");
            buttonPanelAvailableData.add(buttonDeleteGoods, BorderLayout.CENTER);
            buttonDeleteGoods.addActionListener(this);

            availableDataFrame.setVisible(true);
        }
        // when button "видалити групу" is pressed
        else if(event.getSource() == buttonDeleteGroup){
            panelInteractionWithAvailableData.remove(buttonPanelAvailableData);
            panelInteractionWithAvailableData.remove(labelTitle);

            listOfGroups = new JTextArea(10, 40);
            listOfGroups.setLineWrap(true);
            listOfGroups.setWrapStyleWord(true);
            scrollText = new JScrollPane(listOfGroups);

            panelInteractionWithAvailableData.add(scrollText, BorderLayout.CENTER);

            String s ="";
            for(int i =0; i < storage.numberOfGroups(); i++) s +=  i + ")" + storage.getInfoAboutGroup(i) + "\n";
            listOfGroups.setText(s);
            ////////////////////////
            whichGroup = new JLabel("Оберіть групу, яку бажаєте видалити: ");
            whichGroup.setForeground(Color.white);
            whichGroup.setFont(new Font("Georgia", Font.ITALIC, 18));
            whichGroup.setHorizontalAlignment(JLabel.CENTER);
            panelInteractionWithAvailableData.add(whichGroup);

            SpinnerModel value = new SpinnerNumberModel(0, 0, storage.numberOfGroups() -1, 1);
            spinnerOfGroup = new JSpinner(value);
            panelInteractionWithAvailableData.add(spinnerOfGroup, BorderLayout.CENTER);

            buttonNextToDeleteGroup = new JButton("Видалити");
            buttonNextToDeleteGroup.addActionListener(this);
            panelInteractionWithAvailableData.add(buttonNextToDeleteGroup);


            SwingUtilities.updateComponentTreeUI(availableDataFrame);

        } else if(event.getSource() == buttonNextToDeleteGroup){
            numberOfGroup = (Integer) spinnerOfGroup.getValue();
            storage.deleteGroup(numberOfGroup);
            availableDataFrame.setVisible(false);
            newFrame.setVisible(true);

        }

        // actions when button "редагувати групу" is pressed
        else if(event.getSource() == buttonEditGroup){
        //    buttonPanelAvailableData.remove(buttonEditGroup);
         //   buttonPanelAvailableData.remove(buttonDeleteGoods);
        //    buttonPanelAvailableData.remove(buttonEditGoods);
        //    buttonPanelAvailableData.remove(buttonDeleteGroup);
            panelInteractionWithAvailableData.remove(buttonPanelAvailableData);
            panelInteractionWithAvailableData.remove(labelTitle);



            listOfGroups = new JTextArea(10, 40);
            listOfGroups.setLineWrap(true);
            listOfGroups.setWrapStyleWord(true);
            scrollText = new JScrollPane(listOfGroups);

            panelInteractionWithAvailableData.add(scrollText, BorderLayout.CENTER);

            String s ="";
            for(int i =0; i < storage.numberOfGroups(); i++) s +=  i + ")" + storage.getInfoAboutGroup(i) + "\n";
            listOfGroups.setText(s);

             whichGroup = new JLabel("Оберіть групу, яку бажаєте відредагувати: ");
            whichGroup.setForeground(Color.white);
            whichGroup.setFont(new Font("Georgia", Font.ITALIC, 18));
            whichGroup.setHorizontalAlignment(JLabel.CENTER);
            panelInteractionWithAvailableData.add(whichGroup);

            SpinnerModel value = new SpinnerNumberModel(0, 0, storage.numberOfGroups() -1, 1);
            spinnerOfGroup = new JSpinner(value);
            panelInteractionWithAvailableData.add(spinnerOfGroup, BorderLayout.CENTER);

             whatTo = new JLabel("Редагувати назву -1, редагувати опис -2: ");
            whatTo.setForeground(Color.white);
            whatTo.setFont(new Font("Georgia", Font.ITALIC, 18));
            whatTo.setHorizontalAlignment(JLabel.CENTER);
            panelInteractionWithAvailableData.add(whatTo);

            SpinnerModel value2 = new SpinnerNumberModel(1, 1, 2, 1);
             whatToChange = new JSpinner(value2);
            panelInteractionWithAvailableData.add(whatToChange, BorderLayout.CENTER);


            nextToEditGroup = new JButton("Далі");

            buttonPanelInEdit = new JPanel(new FlowLayout(FlowLayout.CENTER, 40, 40));
            buttonPanelInEdit.setBackground(Color.black);
            panelInteractionWithAvailableData.add(buttonPanelInEdit, BorderLayout.SOUTH);

            buttonPanelInEdit.add(nextToEditGroup, BorderLayout.CENTER);
            nextToEditGroup.addActionListener(this);

            SwingUtilities.updateComponentTreeUI(availableDataFrame);

        }
        else if(event.getSource() == nextToEditGroup){
             numberOfGroup = (Integer) spinnerOfGroup.getValue();
            // 1 - change name of a group, 2 - change the description
             whatToChangeInEdit = (Integer) whatToChange.getValue();

            panelInteractionWithAvailableData.remove(buttonPanelInEdit);
            panelInteractionWithAvailableData.remove(whatTo);
            panelInteractionWithAvailableData.remove(whichGroup);
            panelInteractionWithAvailableData.remove(listOfGroups);
            panelInteractionWithAvailableData.remove(scrollText);

            panelInteractionWithAvailableData.remove(whatToChange);
            panelInteractionWithAvailableData.remove(spinnerOfGroup);

            questionInEdit = new JLabel("Вкажіть нову назву/опис групи: ");
            questionInEdit.setForeground(Color.white);
            questionInEdit.setFont(new Font("Georgia", Font.ITALIC, 18));
            questionInEdit.setHorizontalAlignment(JLabel.CENTER);
            panelInteractionWithAvailableData.add(questionInEdit);

            // new value
            newNameOrDescOfGroup = new JTextArea(4, 10);

            newNameOrDescOfGroup.setLineWrap(true);
            newNameOrDescOfGroup.setWrapStyleWord(true);
            scrollText = new JScrollPane(newNameOrDescOfGroup);

            panelInteractionWithAvailableData.add(scrollText, BorderLayout.CENTER);
            buttonAssignGroup = new JButton("Далі");
            buttonAssignGroup.addActionListener(this);
            panelInteractionWithAvailableData.add(buttonAssignGroup, BorderLayout.SOUTH);
            SwingUtilities.updateComponentTreeUI(availableDataFrame);

        } else if(event.getSource() == buttonAssignGroup){
            if(whatToChangeInEdit == 1) {
                String newName = newNameOrDescOfGroup.getText();
                storage.editGroup(numberOfGroup, newName, storage.getDescOfGroup(numberOfGroup));
            } else if(whatToChangeInEdit == 2){
                String newDesc = newNameOrDescOfGroup.getText();
                storage.editGroup(numberOfGroup, storage.getNameOfGroup(numberOfGroup), newDesc);
            }

            panelInteractionWithAvailableData.remove(questionInEdit);
            panelInteractionWithAvailableData.remove(newNameOrDescOfGroup);
            panelInteractionWithAvailableData.remove(buttonAssignGroup);

            SwingUtilities.updateComponentTreeUI(availableDataFrame);
            System.out.println("done");
            availableDataFrame.setVisible(false);
            newFrame.setVisible(true);

        }
    }

}