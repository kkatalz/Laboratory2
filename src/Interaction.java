import org.w3c.dom.ls.LSOutput;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;
//TODO другий екран -2 кнопки: робота з новими даними й старими

public class Interaction extends JFrame implements ActionListener {
    JButton StartButton, CancelButton, availableDataButton, newDataButton, makeGroup, addGood, BACK, buttonEditGroup, Submit,
            buttonEditGoods, buttonDeleteGroup, buttonDeleteGoods, buttonNextToEditGroupToDesc,buttonToChooseGroupInAdditionGoods,
            buttonNextToEditNameOfGroup, buttonAssignGroup, buttonNextToDeleteGroup, buttonToChangeNameOgGroup,
            buttonToChooseGroupInEditingGoods, buttonToEditSpecifiedGood, buttonToChooseParametrOfProductL,
            SubmitGood, buttonToDeleteGood, buttonSearchForGoods, buttonFinishSearching,
            buttonToFinishEditingGoodsL, buttonToWriteInfoInFile, buttonChooseGroupToDeleteGoods, buttonSearchForGoodsWithEnteredData,
            buttonAddAmountOfGoods, buttonMakeLessAmountOfGoods,buttonAcceptAddAmountOfGoods,buttonToChooseGroupInAddingAmount,
            buttonAcceptGoods;
    JLabel nameLabel, startLabel, whichGroup, questionInEdit, labelInfoAboutGoods, labelToFindGoodsByName, labelQuestion;
    JLabel[] labelWithGoodsInSearching;
    JPanel mainPanel, buttonPanel, buttonPanelData, panelInteractionWithNewData, buttonPanelNewData, panelInteractionWithAvailableData,
            buttonPanelAvailableData, buttonPanelInEdit, buttonPanelForBack, panelInProcess, panelInProcess2, panelInteractionWithNewGood,
            panelToSearchForGoods, panelToChooseChangeAmountOfGoods;
    JFrame newFrame, thirdFrame, makeGroupFrame, addGoodFrame, availableDataFrame,makeGoodFrame,makeNewGoodFrame;
    JTextField newNameOrDescOfGroup, textFieldSearchGoods, textFieldAddAmountOfGoods;
    int  indexOfParametr;
    JTextField nameField, descriptionField, newParametrInEditingGoods, factureField, priceField,amountOnStockField;

    JLabel labelTitle;
    boolean isShowAvailable = true;
    JRadioButton[] radioButtonsToChooseGroupInEditingGoods, radioButtonsToChooseGoodsInEditingGoods,
            radioButtonsToChooseParametr,radioButtonsToChooseGroupInAdditionGoods, radioButtonsChooseGroupInEditingGroup;
    private Storage storage;
    private int indexOfGroup, indexOfProduct;


    public Interaction(Storage storage) {
        this.storage = storage;

        storage.addGroup("Їжа", "поїсти");
        storage.addGroup("одяг", "носити");
        storage.addGroup("кава", "пити");
        storage.addGroup("Взуття", "Спортивне");

        storage.getGroup(0).addGoodsToGroup("Гречка", "Україна", "Верес", 20, 30);
        storage.getGroup(0).addGoodsToGroup("Хліб", "Україна", "Київхліб", 10, 24);
        storage.getGroup(0).addGoodsToGroup("Молоко", "знежирене", "Яготинське", 90, 33);
        storage.getGroup(1).addGoodsToGroup("Джинси", "mom fit", "Bershka", 200, 800);
        storage.getGroup(1).addGoodsToGroup("Куртка", "Україна", "Zara", 90, 900);

        storage.getGroup(2).addGoodsToGroup("Lavazza", "Україна", "міцна", 6, 5);


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

        StartButton = new JButton("START");
        buttonPanel.add(StartButton);
        StartButton.addActionListener(this);

        CancelButton = new JButton("CANCEL");
        buttonPanel.add(CancelButton);
        CancelButton.addActionListener(this);


    }


    //відкриття панелі для роботи з даними
    public void showData(String title) {
//        if (storage.groups.length == 0 && title == "Робота з наявними даними") {
//
//        }
        availableDataFrame = new JFrame(title);
        availableDataFrame.setSize(500, 400);
        availableDataFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panelInteractionWithAvailableData = new JPanel();
        panelInteractionWithAvailableData.setBackground(Color.BLACK);
        panelInteractionWithAvailableData.setBorder(BorderFactory.createEmptyBorder(40, 0, 10, 0));
        panelInteractionWithAvailableData.setLayout(new FlowLayout());
        availableDataFrame.add(panelInteractionWithAvailableData);

        labelTitle = new JLabel("<html> На даній сторінці ви можете редагувати <br>/видалити групу товарів або ж товар");
        labelTitle.setForeground(Color.white);
        labelTitle.setFont(new Font("Georgia", Font.ITALIC, 18));
        labelTitle.setHorizontalAlignment(JLabel.CENTER);
        panelInteractionWithAvailableData.add(labelTitle);

        buttonPanelAvailableData = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 40));
        buttonPanelAvailableData.setBackground(Color.black);
        panelInteractionWithAvailableData.add(buttonPanelAvailableData, BorderLayout.SOUTH);

        buttonEditGroup = new JButton("Редагувати групу");
        buttonPanelAvailableData.add(buttonEditGroup, BorderLayout.CENTER);
        buttonEditGroup.addActionListener(this);

        buttonDeleteGroup = new JButton("Видалити групу");
        buttonPanelAvailableData.add(buttonDeleteGroup, BorderLayout.CENTER);
        buttonDeleteGroup.addActionListener(this);

         panelInProcess = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 10));
        panelInProcess.setBackground(Color.BLACK);

        panelInProcess.add(buttonEditGroup);


        panelInteractionWithAvailableData.add(panelInProcess);

         panelInProcess2 = new JPanel(new FlowLayout(FlowLayout.RIGHT, 15, 10));
        panelInProcess2.setBackground(Color.BLACK);

        buttonEditGoods = new JButton("Редагувати товар");
        buttonEditGoods.addActionListener(this);
        panelInProcess2.add(buttonEditGoods);


        buttonDeleteGoods = new JButton("Видалити товар");
        buttonDeleteGoods.addActionListener(this);
        panelInProcess2.add(buttonDeleteGoods);

        panelInteractionWithAvailableData.add(panelInProcess2);

        panelToChooseChangeAmountOfGoods = new JPanel(new FlowLayout(FlowLayout.RIGHT, 15, 10));
        panelToChooseChangeAmountOfGoods.setBackground(Color.BLACK);

        buttonAddAmountOfGoods = new JButton("Додавання товару");
        buttonAddAmountOfGoods.addActionListener(this);
        panelToChooseChangeAmountOfGoods.add(buttonAddAmountOfGoods);

        buttonMakeLessAmountOfGoods = new JButton("Списання товару");
        buttonMakeLessAmountOfGoods.addActionListener(this);
        panelToChooseChangeAmountOfGoods.add(buttonMakeLessAmountOfGoods);

        panelInteractionWithAvailableData.add(panelToChooseChangeAmountOfGoods);

        availableDataFrame.setVisible(true);
    }

    public void actionPerformed(ActionEvent event) {
        //відкрити друге вікно
        if (event.getSource() == StartButton) {
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

            JPanel myPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 10));
            myPanel.setBackground(Color.black);
            newPanel.add(myPanel);

            buttonToWriteInfoInFile = new JButton("Записати дані до файлу");
            myPanel.add(buttonToWriteInfoInFile, BorderLayout.SOUTH);
            buttonToWriteInfoInFile.addActionListener(this);

            buttonSearchForGoods = new JButton("Пошук товару");
            myPanel.add(buttonSearchForGoods, BorderLayout.SOUTH);
            buttonSearchForGoods.addActionListener(this);

            buttonPanelForBack = new JPanel(new FlowLayout(FlowLayout.RIGHT, 300, 60));
            buttonPanelForBack.setBackground(Color.black);
            newPanel.add(buttonPanelForBack);

            BACK = new JButton("BACK");
            buttonPanelForBack.add(BACK, BorderLayout.SOUTH);
            BACK.addActionListener(this);

            newFrame.setVisible(true);

            //закрити вікно
        } else if (event.getSource() == CancelButton) {
            this.dispose();

            //створюємо третє вікно
        } else if (event.getSource() == newDataButton) {
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
        } else if (event.getSource() == makeGroup) {
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
            nameField = new JTextField(15);//видимий розмір
            descriptionField = new JTextField(15);

            panelInteractionWithNewData.add(nameLabel);
            panelInteractionWithNewData.add(descriptionLabel);
            panelInteractionWithNewData.add(nameField);
            panelInteractionWithNewData.add(descriptionField);


            buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 60, 10));
            buttonPanel.setBackground(Color.black);
            panelInteractionWithNewData.add(buttonPanel, BorderLayout.SOUTH);

            Submit = new JButton("OK");
            buttonPanel.add(Submit);
            Submit.addActionListener(this);


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


        }//кнопка ОК зберігає нові дані
     else if (event.getSource() == Submit) {

            //зберігаємо додані групи
            String name = nameField.getText();
            String description = descriptionField.getText();
            storage.addGroup(name, description);

            panelInteractionWithNewData.setVisible(false);
            showData("Робота з оновленими даними");


            // кнопка додати товар
        }else if (event.getSource() == addGood) {

            thirdFrame.setVisible(false);

            makeNewGoodFrame = new JFrame("Обрати групу");
            makeNewGoodFrame.setSize(500, 400);
            makeNewGoodFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            panelInteractionWithNewGood = new JPanel();
            panelInteractionWithNewGood.setBackground(Color.BLACK);
            panelInteractionWithNewGood.setBorder(BorderFactory.createEmptyBorder(55, 0, 10, 0));
            makeNewGoodFrame.add(panelInteractionWithNewGood);

                ButtonGroup bg = new ButtonGroup();

                // додати вибір групи для користувача
                radioButtonsToChooseGroupInAdditionGoods = new JRadioButton[storage.numberOfGroups()];
                for (int i = 0; i < storage.numberOfGroups(); i++) {
                    radioButtonsToChooseGroupInAdditionGoods[i] = new JRadioButton(storage.getNameOfGroup(i));
                    panelInteractionWithNewGood.add(radioButtonsToChooseGroupInAdditionGoods[i], BorderLayout.CENTER);
                    bg.add(radioButtonsToChooseGroupInAdditionGoods[i]);
                }

                // додати кнопку аби користувач підтвердив групу, в якій хоче поредагувати товар
                buttonToChooseGroupInAdditionGoods = new JButton("Обрати групу");
            buttonToChooseGroupInAdditionGoods.addActionListener(this);
            panelInteractionWithNewGood.add(buttonToChooseGroupInAdditionGoods, BorderLayout.CENTER);

               SwingUtilities.updateComponentTreeUI(makeNewGoodFrame);
            makeNewGoodFrame.setVisible(true);

        //додати товар до групи
     }else if(event.getSource()==buttonToChooseGroupInAdditionGoods) {

            makeNewGoodFrame.setVisible(false);

            makeGoodFrame = new JFrame("Додати товар до групи");
            makeGoodFrame.setSize(500, 400);
            makeGoodFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            panelInteractionWithNewData = new JPanel();
            panelInteractionWithNewData.setBackground(Color.BLACK);
            panelInteractionWithNewData.setBorder(BorderFactory.createEmptyBorder(55, 0, 10, 0));
            makeGoodFrame.add(panelInteractionWithNewData);

            JLabel newLabel = new JLabel("<html> Введіть назву, опис, виробника, кількість<br> на складі й ціну за одиницю товара");
            newLabel.setForeground(Color.white);
            newLabel.setFont(new Font("Georgia", Font.ITALIC, 18));
            newLabel.setHorizontalAlignment(JLabel.CENTER);
            panelInteractionWithNewData.add(newLabel);

            JLabel nameLabel = new JLabel("Ім'я:");
            JLabel descriptionLabel = new JLabel("Опис:");
            JLabel factureLabel = new JLabel("Виробник:");
            JLabel amountOnStockLabel = new JLabel("Кількість:");
            JLabel priceLabel = new JLabel("Ціна:");


            nameLabel.setForeground(Color.white);
            descriptionLabel.setForeground(Color.white);
            factureLabel.setForeground(Color.white);
            amountOnStockLabel.setForeground(Color.white);
            priceLabel.setForeground(Color.white);
            nameField = new JTextField(15);
            descriptionField = new JTextField(15);
            factureField = new JTextField(15);
            amountOnStockField = new JTextField(15);
            priceField = new JTextField(15);

            panelInteractionWithNewData.add(nameLabel);
            panelInteractionWithNewData.add(nameField);
            panelInteractionWithNewData.add(descriptionLabel);
            panelInteractionWithNewData.add(descriptionField);
            panelInteractionWithNewData.add(factureLabel);
            panelInteractionWithNewData.add(factureField);
            panelInteractionWithNewData.add(amountOnStockLabel);
            panelInteractionWithNewData.add(amountOnStockField);
            panelInteractionWithNewData.add(priceLabel);
            panelInteractionWithNewData.add(priceField);


            buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 60, 10));
            buttonPanel.setBackground(Color.black);
            panelInteractionWithNewData.add(buttonPanel, BorderLayout.SOUTH);

            SubmitGood = new JButton("OK");
            buttonPanel.add(SubmitGood);
            SubmitGood.addActionListener(this);

            makeGoodFrame.setVisible(true);


        }else if(event.getSource()==SubmitGood){
            makeGoodFrame.setVisible(false);
            for (int i = 0; i < storage.numberOfGroups(); i++) {
                if (radioButtonsToChooseGroupInAdditionGoods[i].isSelected()) {
                    storage.getGroup(i).addGoodsToGroup(nameField.getText(), descriptionField.getText(), factureField.getText(), Integer.parseInt(amountOnStockField.getText()), Double.parseDouble(priceField.getText()));
                }

            }
            showData("Робота з оновленими даними");



            // to work with already added groups and goods (to edit or delete)
        } else if (event.getSource() == availableDataButton) {
            newFrame.setVisible(false);

            showData("Робота з наявними даними");
        }
        // when button "видалити групу" is pressed
        else if (event.getSource() == buttonDeleteGroup) {

            panelInteractionWithAvailableData.remove(panelInProcess2);
            panelInteractionWithAvailableData.remove(panelInProcess);
            panelInteractionWithAvailableData.remove(panelToChooseChangeAmountOfGoods);
            panelInteractionWithAvailableData.remove(buttonPanelAvailableData);
            panelInteractionWithAvailableData.remove(labelTitle);


            whichGroup = new JLabel("Оберіть групу, яку бажаєте видалити: ");
            whichGroup.setForeground(Color.white);
            whichGroup.setFont(new Font("Georgia", Font.ITALIC, 18));
            whichGroup.setHorizontalAlignment(JLabel.CENTER);
            panelInteractionWithAvailableData.add(whichGroup);

            ButtonGroup bg = new ButtonGroup();
            radioButtonsChooseGroupInEditingGroup = new JRadioButton[storage.numberOfGroups()];
            for(int i =0; i <radioButtonsChooseGroupInEditingGroup.length ; i++){
                radioButtonsChooseGroupInEditingGroup[i] = new JRadioButton(storage.getNameOfGroup(i));
                bg.add(radioButtonsChooseGroupInEditingGroup[i]);
                panelInteractionWithAvailableData.add(radioButtonsChooseGroupInEditingGroup[i]);

            }


            buttonNextToDeleteGroup = new JButton("Видалити");
            buttonNextToDeleteGroup.addActionListener(this);
            panelInteractionWithAvailableData.add(buttonNextToDeleteGroup);


            SwingUtilities.updateComponentTreeUI(availableDataFrame);

        }
        else if (event.getSource() == buttonNextToDeleteGroup) {
            // при видаленні групи видаляти також усі товари в цій групі
            boolean marker = false;
            for(int i =0; i< radioButtonsChooseGroupInEditingGroup.length; i++){
                if(radioButtonsChooseGroupInEditingGroup[i].isSelected()){
                    indexOfGroup = i;
                    marker = true;
                    storage.getGroup(indexOfGroup).deleteAllGoodsInGroup();
                    storage.deleteGroup(indexOfGroup);
                    break;
                }
            }

            if(!marker){
                JOptionPane.showMessageDialog(this, "Ви не обрали жодну групу, неможливо видалити.");
                availableDataFrame.setVisible(false);
                newFrame.setVisible(true);
                return;
            }


            availableDataFrame.setVisible(false);
            newFrame.setVisible(true);
        }

        else if(event.getSource() == buttonDeleteGoods){
            panelInteractionWithAvailableData.remove(panelInProcess2);
            panelInteractionWithAvailableData.remove(panelInProcess);
            panelInteractionWithAvailableData.remove(panelToChooseChangeAmountOfGoods);
            panelInteractionWithAvailableData.remove(buttonPanelAvailableData);
            panelInteractionWithAvailableData.remove(labelTitle);

            whichGroup = new JLabel("Оберіть групу, у якій знаходиться товар: ");
            whichGroup.setForeground(Color.white);
            whichGroup.setFont(new Font("Georgia", Font.ITALIC, 18));
            whichGroup.setHorizontalAlignment(JLabel.CENTER);
            panelInteractionWithAvailableData.add(whichGroup);

            ButtonGroup bg = new ButtonGroup();
            radioButtonsChooseGroupInEditingGroup = new JRadioButton[storage.numberOfGroups()];
            for(int i =0; i <radioButtonsChooseGroupInEditingGroup.length ; i++){
                radioButtonsChooseGroupInEditingGroup[i] = new JRadioButton(storage.getNameOfGroup(i));
                bg.add(radioButtonsChooseGroupInEditingGroup[i]);
                panelInteractionWithAvailableData.add(radioButtonsChooseGroupInEditingGroup[i]);
            }

            buttonChooseGroupToDeleteGoods = new JButton("Обрати групу");
            buttonChooseGroupToDeleteGoods.addActionListener(this);

            panelInProcess = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 10));
            panelInProcess.setBackground(Color.black);

            panelInProcess.add(buttonChooseGroupToDeleteGoods);
            panelInteractionWithAvailableData.add(panelInProcess);

            SwingUtilities.updateComponentTreeUI(availableDataFrame);

        }
        else if(event.getSource() == buttonChooseGroupToDeleteGoods){
            for(int j =0; j < radioButtonsChooseGroupInEditingGroup.length; j++){
                panelInteractionWithAvailableData.remove(radioButtonsChooseGroupInEditingGroup[j]);
            }
            boolean marker = false;
            panelInteractionWithAvailableData.remove(panelInProcess);
            panelInteractionWithAvailableData.remove(whichGroup);
            for(int i =0; i < radioButtonsChooseGroupInEditingGroup.length; i++){
                if(radioButtonsChooseGroupInEditingGroup[i].isSelected()) {
                    panelInteractionWithAvailableData.remove(radioButtonsChooseGroupInEditingGroup[i]);
                    indexOfGroup = i;
                    marker = true;
                    break;
                }
            }

            if(!marker || storage.getGroup(indexOfGroup).getNumberOfGoodsInGroup() == 0){
                JOptionPane.showMessageDialog(this, "Ви не обрали жодну групу або у групі немає товарів, неможливо застосувати зміни.");
                availableDataFrame.setVisible(false);
                newFrame.setVisible(true);
                return;
            }

            ButtonGroup bg = new ButtonGroup();
            radioButtonsToChooseGoodsInEditingGoods = new JRadioButton[storage.getGroup(indexOfGroup).getNumberOfGoodsInGroup()];
            for(int i =0; i <radioButtonsToChooseGoodsInEditingGoods.length; i++){
                radioButtonsToChooseGoodsInEditingGoods[i] = new JRadioButton(storage.getGroup(indexOfGroup).getGood(i).getName());
                panelInteractionWithAvailableData.add(radioButtonsToChooseGoodsInEditingGoods[i]);
                bg.add(radioButtonsToChooseGoodsInEditingGoods[i]);
            }

            buttonToDeleteGood  = new JButton("Видалити товар");
            buttonToDeleteGood.addActionListener(this);
            panelInteractionWithAvailableData.add(buttonToDeleteGood);

            SwingUtilities.updateComponentTreeUI(availableDataFrame);

        }

        else if(event.getSource() == buttonToDeleteGood){
            // for now
            panelInteractionWithAvailableData.remove(buttonToDeleteGood);
            for(int i =0; i < radioButtonsToChooseGoodsInEditingGoods.length; i++){
                panelInteractionWithAvailableData.remove(radioButtonsToChooseGoodsInEditingGoods[i]);
            }

            boolean marker = false;
            for(int i =0; i < radioButtonsToChooseGoodsInEditingGoods.length; i++){
                if(radioButtonsToChooseGoodsInEditingGoods[i].isSelected()){
                    storage.getGroup(indexOfGroup).deleteGoodsInGroup(i);
                    marker = true;
                    break;
                }
            }
            if(!marker){
                JOptionPane.showMessageDialog(this, "Ви не обрали жодну групу, неможливо застосувати зміни.");
                availableDataFrame.setVisible(false);
                newFrame.setVisible(true);
                return;

            }

            JOptionPane.showMessageDialog(this, "Товар було успішно видалено.");
            availableDataFrame.setVisible(false);
            newFrame.setVisible(true);

            SwingUtilities.updateComponentTreeUI(availableDataFrame);

        }
        // actions when button "редагувати групу" is pressed
        else if (event.getSource() == buttonEditGroup) {

            panelInteractionWithAvailableData.remove(panelInProcess2);
            panelInteractionWithAvailableData.remove(panelInProcess);
            panelInteractionWithAvailableData.remove(panelToChooseChangeAmountOfGoods);
            panelInteractionWithAvailableData.remove(buttonPanelAvailableData);
            panelInteractionWithAvailableData.remove(labelTitle);


            whichGroup = new JLabel("Оберіть групу, яку бажаєте відредагувати: ");
            whichGroup.setForeground(Color.white);
            whichGroup.setFont(new Font("Georgia", Font.ITALIC, 18));
            whichGroup.setHorizontalAlignment(JLabel.CENTER);
            panelInteractionWithAvailableData.add(whichGroup);

            ButtonGroup bg = new ButtonGroup();
            radioButtonsChooseGroupInEditingGroup = new JRadioButton[storage.numberOfGroups()];
            for(int i =0; i <radioButtonsChooseGroupInEditingGroup.length ; i++){
                radioButtonsChooseGroupInEditingGroup[i] = new JRadioButton(storage.getNameOfGroup(i));
                bg.add(radioButtonsChooseGroupInEditingGroup[i]);
                panelInteractionWithAvailableData.add(radioButtonsChooseGroupInEditingGroup[i]);

            }

            buttonNextToEditGroupToDesc = new JButton("Редагувати опис");


            buttonNextToEditNameOfGroup = new JButton("Редагувати назву");


            buttonPanelInEdit = new JPanel(new FlowLayout(FlowLayout.CENTER, 40, 40));
            buttonPanelInEdit.setBackground(Color.black);
            panelInteractionWithAvailableData.add(buttonPanelInEdit, BorderLayout.SOUTH);
            buttonPanelInEdit.add(buttonNextToEditGroupToDesc, BorderLayout.CENTER);
            buttonNextToEditGroupToDesc.addActionListener(this);

            buttonPanelInEdit.add(buttonNextToEditNameOfGroup, BorderLayout.CENTER);
            buttonNextToEditNameOfGroup.addActionListener(this);

            SwingUtilities.updateComponentTreeUI(availableDataFrame);

        } else if (event.getSource() == buttonNextToEditGroupToDesc) {
            // редагувати опис
            for(int i =0; i < radioButtonsChooseGroupInEditingGroup.length; i++){
                panelInteractionWithAvailableData.remove(radioButtonsChooseGroupInEditingGroup[i]);
            }
            panelInteractionWithAvailableData.remove(buttonPanelInEdit);


            panelInteractionWithAvailableData.remove(whichGroup);


            questionInEdit = new JLabel("Вкажіть новий опис групи: ");
            questionInEdit.setForeground(Color.white);
            questionInEdit.setFont(new Font("Georgia", Font.ITALIC, 18));
            questionInEdit.setHorizontalAlignment(JLabel.CENTER);
            panelInteractionWithAvailableData.add(questionInEdit);

            // new value
            newNameOrDescOfGroup = new JTextField(15);

            buttonAssignGroup = new JButton("Далі");
            buttonAssignGroup.addActionListener(this);
            panelInteractionWithAvailableData.add(newNameOrDescOfGroup);

            panelInteractionWithAvailableData.add(buttonAssignGroup, BorderLayout.SOUTH);
            SwingUtilities.updateComponentTreeUI(availableDataFrame);


        }
        else if (event.getSource() == buttonAssignGroup) {
            panelInteractionWithAvailableData.remove(questionInEdit);
            panelInteractionWithAvailableData.remove(newNameOrDescOfGroup);
            panelInteractionWithAvailableData.remove(buttonAssignGroup);

            String newDesc = newNameOrDescOfGroup.getText();
            if(newDesc.matches("[ ]+") || newDesc.equals("")){
                JOptionPane.showMessageDialog(this, "Невірно введені дані.");
                availableDataFrame.setVisible(false);
                newFrame.setVisible(true);
                return;

            }
            boolean marker = false;
            for(int i =0; i < radioButtonsChooseGroupInEditingGroup.length; i++){
                if(radioButtonsChooseGroupInEditingGroup[i].isSelected()) {
                    marker = true;
                    indexOfGroup = i;
                    storage.editGroup(i, storage.getNameOfGroup(indexOfGroup), newDesc);
                    break;
                }
            }

            if(!marker){
                JOptionPane.showMessageDialog(this, "Ви не обрали жодну групу, неможливо застосувати зміни.");
                availableDataFrame.setVisible(false);
                newFrame.setVisible(true);
                return;
            }

            SwingUtilities.updateComponentTreeUI(availableDataFrame);
            availableDataFrame.setVisible(false);
            newFrame.setVisible(true);

        } // натиснута кнопка редагувати назву групи
        else if (event.getSource() == buttonNextToEditNameOfGroup) {

            for(int i =0; i < radioButtonsChooseGroupInEditingGroup.length; i++){
                panelInteractionWithAvailableData.remove(radioButtonsChooseGroupInEditingGroup[i]);
            }
            panelInteractionWithAvailableData.remove(buttonPanelInEdit);


            panelInteractionWithAvailableData.remove(whichGroup);


            questionInEdit = new JLabel("Вкажіть нову назву групи: ");
            questionInEdit.setForeground(Color.white);
            questionInEdit.setFont(new Font("Georgia", Font.ITALIC, 18));
            questionInEdit.setHorizontalAlignment(JLabel.CENTER);
            panelInteractionWithAvailableData.add(questionInEdit);

            // new value
            newNameOrDescOfGroup = new JTextField(15);

            buttonToChangeNameOgGroup = new JButton("Далі");
            buttonToChangeNameOgGroup.addActionListener(this);
            panelInteractionWithAvailableData.add(newNameOrDescOfGroup);

            panelInteractionWithAvailableData.add(buttonToChangeNameOgGroup, BorderLayout.SOUTH);
            SwingUtilities.updateComponentTreeUI(availableDataFrame);

        }
        else if (event.getSource() == buttonToChangeNameOgGroup) {

            panelInteractionWithAvailableData.remove(questionInEdit);
            panelInteractionWithAvailableData.remove(newNameOrDescOfGroup);
            panelInteractionWithAvailableData.remove(buttonToChangeNameOgGroup);
            String newName = newNameOrDescOfGroup.getText();
            if(newName.matches("[ ]+") || newName.equals("")){
                JOptionPane.showMessageDialog(this, "Невірно введені дані.");
                availableDataFrame.setVisible(false);
                newFrame.setVisible(true);
                return;

            }
            boolean marker = false;
            for(int i =0; i < radioButtonsChooseGroupInEditingGroup.length; i++){
                if(radioButtonsChooseGroupInEditingGroup[i].isSelected()) {
                    marker = true;
                    indexOfGroup = i;
                    storage.editGroup(i, newName, storage.getDescOfGroup(indexOfGroup));
                    break;
                }
            }

            if(!marker){
                JOptionPane.showMessageDialog(this, "Ви не обрали жодну групу, неможливо застосувати зміни.");
                availableDataFrame.setVisible(false);
                newFrame.setVisible(true);
                return;
            }

            SwingUtilities.updateComponentTreeUI(availableDataFrame);
            availableDataFrame.setVisible(false);
            newFrame.setVisible(true);
        }
        // кнопка редагувати товар
        else if (event.getSource() == buttonEditGoods) {

            panelInteractionWithAvailableData.remove(panelInProcess2);
            panelInteractionWithAvailableData.remove(panelInProcess);
            panelInteractionWithAvailableData.remove(panelToChooseChangeAmountOfGoods);
            panelInteractionWithAvailableData.remove(buttonPanelAvailableData);
            panelInteractionWithAvailableData.remove(labelTitle);

            ButtonGroup bg = new ButtonGroup();
            // додати вибір групи для користувача
            radioButtonsToChooseGroupInEditingGoods = new JRadioButton[storage.numberOfGroups()];
            for (int i = 0; i < storage.numberOfGroups(); i++) {
                radioButtonsToChooseGroupInEditingGoods[i] = new JRadioButton(storage.getNameOfGroup(i));
                panelInteractionWithAvailableData.add(radioButtonsToChooseGroupInEditingGoods[i], BorderLayout.CENTER);
                bg.add(radioButtonsToChooseGroupInEditingGoods[i]);
            }

            // додати кнопку аби користувач підтвердив групу, в якій хоче поредагувати товар
            buttonToChooseGroupInEditingGoods = new JButton("Обрати групу");
            buttonToChooseGroupInEditingGoods.addActionListener(this);
            panelInteractionWithAvailableData.add(buttonToChooseGroupInEditingGoods, BorderLayout.CENTER);

            SwingUtilities.updateComponentTreeUI(availableDataFrame);

        }
        // кнопка, коли користувач вже обрав групу, в якій хоче поредагувати товар
        else if (event.getSource() == buttonToChooseGroupInEditingGoods) {

            for (int i = 0; i < storage.numberOfGroups(); i++) {
                panelInteractionWithAvailableData.remove(radioButtonsToChooseGroupInEditingGoods[i]);
            }
            panelInteractionWithAvailableData.remove(buttonToChooseGroupInEditingGoods);


            // створити нові radioButtons, або продемонструвати товари в обраній користувачем групі
            ButtonGroup bg = new ButtonGroup();
            boolean marker = false;
            for (int i = 0; i < storage.numberOfGroups(); i++) {
                if (radioButtonsToChooseGroupInEditingGoods[i].isSelected()) {
                    marker = true;
                    String[] goods;
                    goods = storage.getNamesOfGoods(i);
                    if(storage.groups[i].getNumberOfGoodsInGroup() == 0){
                        JOptionPane.showMessageDialog(this, "Неможливо відредагувати товар в даній групі, " +
                                "оскільки група не містить товарів.");
                        availableDataFrame.setVisible(false);
                        newFrame.setVisible(true);
                        return;
                    }
                    radioButtonsToChooseGoodsInEditingGoods = new JRadioButton[storage.groups[i].getNumberOfGoodsInGroup()];
                    for (int j = 0; j < storage.getGroup(i).getNumberOfGoodsInGroup(); j++) {
                        indexOfGroup = i;
                        // додаємо кнопки з продуктами
                        radioButtonsToChooseGoodsInEditingGoods[j] = new JRadioButton(goods[j]);
                        bg.add(radioButtonsToChooseGoodsInEditingGoods[j]);
                        panelInteractionWithAvailableData.add(radioButtonsToChooseGoodsInEditingGoods[j]);
                    }
                    break;
                }
            }
            if (!marker) {
                JOptionPane.showMessageDialog(this, "Ви не обрали жодної групи.");
                availableDataFrame.setVisible(false);
                newFrame.setVisible(true);
                return;
            }

            buttonToEditSpecifiedGood = new JButton("Редагувати даний продукт");
            buttonToEditSpecifiedGood.addActionListener(this);
            panelInteractionWithAvailableData.add(buttonToEditSpecifiedGood);

            SwingUtilities.updateComponentTreeUI(availableDataFrame);

        }
        // користувач вже вказав товар, який він хоче поредагувати, тепер треба дати користувачу обрати що саме він
        // хоче поредагувати в продукті (все, окрім кількості)
        else if (event.getSource() == buttonToEditSpecifiedGood) {
            for (JRadioButton radioButtonsToChooseGoodsInEditingGood : radioButtonsToChooseGoodsInEditingGoods) {
                panelInteractionWithAvailableData.remove(radioButtonsToChooseGoodsInEditingGood);
            }
            panelInteractionWithAvailableData.remove(buttonToEditSpecifiedGood);
            boolean marker = false;
            for (int j = 0; j < storage.getGroup(indexOfGroup).getNumberOfGoodsInGroup(); j++) {
                // дивимося який продукт був обраний користувачем для редагування
                if (radioButtonsToChooseGoodsInEditingGoods[j].isSelected()) {
                    marker = true;
                    indexOfProduct = j;
                    labelInfoAboutGoods = new JLabel("Назва: " + storage.getGroup(indexOfGroup).getGood(indexOfProduct).getName() +
                            ". Опис: " + storage.getGroup(indexOfGroup).getGood(indexOfProduct).getDescription() +
                            ". Виробник: " + storage.getGroup(indexOfGroup).getGood(indexOfProduct).getMaker() +
                            ". Кількість: " + storage.getGroup(indexOfGroup).getGood(indexOfProduct).getAmountOnStock() +
                            ". Ціна: " + storage.getGroup(indexOfGroup).getGood(indexOfProduct).getPrice());
                    labelInfoAboutGoods.setForeground(Color.white);
                    labelInfoAboutGoods.setFont(new Font("Georgia", Font.PLAIN, 10));
                    labelInfoAboutGoods.setHorizontalAlignment(SwingConstants.LEFT);
                    panelInteractionWithAvailableData.add(labelInfoAboutGoods);
                    break;
                }
            }
            if (!marker) {
                JOptionPane.showMessageDialog(this, "Ви не обрали жодного товару.");
                availableDataFrame.setVisible(false);
                newFrame.setVisible(true);
                return;
            }

            ButtonGroup bg = new ButtonGroup();
            radioButtonsToChooseParametr = new JRadioButton[4];
            radioButtonsToChooseParametr[0] = new JRadioButton("Назва");
            radioButtonsToChooseParametr[1] = new JRadioButton("Опис");
            radioButtonsToChooseParametr[2] = new JRadioButton("Виробник");
            radioButtonsToChooseParametr[3] = new JRadioButton("Ціна");
            for (int i = 0; i < radioButtonsToChooseParametr.length; i++) {
                bg.add(radioButtonsToChooseParametr[i]);
                panelInteractionWithAvailableData.add(radioButtonsToChooseParametr[i]);

            }
            // кнопка, аби користувач обрав параметр, який він хоче в продукті
            buttonToChooseParametrOfProductL = new JButton("Далі");
            buttonToChooseParametrOfProductL.addActionListener(this);
            panelInteractionWithAvailableData.add(buttonToChooseParametrOfProductL);

            SwingUtilities.updateComponentTreeUI(availableDataFrame);

        }
        // коли користувач обрав який параметр він хоче змінити в продукті
        else if (event.getSource() == buttonToChooseParametrOfProductL) {
            for (int i = 0; i < radioButtonsToChooseParametr.length; i++) {
                panelInteractionWithAvailableData.remove(radioButtonsToChooseParametr[i]);
            }
            panelInteractionWithAvailableData.remove(labelInfoAboutGoods);
            panelInteractionWithAvailableData.remove(buttonToChooseParametrOfProductL);

            boolean marker = false;
            for (int i = 0; i < radioButtonsToChooseParametr.length; i++) {
                if (radioButtonsToChooseParametr[i].isSelected()) {
                    marker = true;
                    indexOfParametr = i;
                    if (i == 0) {
                        labelInfoAboutGoods = new JLabel("Введіть нову назву: ");
                    } else if (i == 1) {
                        labelInfoAboutGoods = new JLabel("Введіть новий опис: ");
                    } else if (i == 2) {
                        labelInfoAboutGoods = new JLabel("Введіть нового виробника: ");
                    } else if (i == 3) {
                        labelInfoAboutGoods = new JLabel("Введіть нову ціну: ");
                    }
                    panelInteractionWithAvailableData.add(labelInfoAboutGoods);
                    labelInfoAboutGoods.setForeground(Color.white);
                    labelInfoAboutGoods.setHorizontalAlignment(SwingConstants.LEFT);
                    labelInfoAboutGoods.setFont(new Font("Georgia", Font.PLAIN, 15));
                    break;
                }
            }

            if (!marker) {
                JOptionPane.showMessageDialog(this, "Ви не обрали жодного пункту.");
                availableDataFrame.setVisible(false);
                newFrame.setVisible(true);
                return;
            }

            newParametrInEditingGoods = new JTextField(15);
            panelInteractionWithAvailableData.add(newParametrInEditingGoods);

            buttonToFinishEditingGoodsL = new JButton("Далі");
            panelInteractionWithAvailableData.add(buttonToFinishEditingGoodsL);
            buttonToFinishEditingGoodsL.addActionListener(this);

            SwingUtilities.updateComponentTreeUI(availableDataFrame);

        } else if (event.getSource() == BACK) {
            this.setVisible(false);
            Interaction prevFrame = new Interaction(storage);
            prevFrame.setVisible(true);
        }
        // користувач ввів поредагований параметр
        else if(event.getSource() == buttonToFinishEditingGoodsL){
            panelInteractionWithAvailableData.remove(buttonToFinishEditingGoodsL);
            panelInteractionWithAvailableData.remove(labelInfoAboutGoods);
            panelInteractionWithAvailableData.remove(newParametrInEditingGoods);



            String str = newParametrInEditingGoods.getText();
            if(str.matches("[ ]+") || str.equals("")) {
                JOptionPane.showMessageDialog(this, "Невірно введені дані.");
                newFrame.setVisible(true);
                availableDataFrame.setVisible(false);
                return;

            }
            if(indexOfParametr == 0 && !storage.searchForDuplicatesOfGoods(str)){
                JOptionPane.showMessageDialog(this, "Неможливо змінити назву товару, оскільки товар з такою назвою вже є.");
            }
            if(indexOfParametr == 0 && storage.searchForDuplicatesOfGoods(str)){ // name
                storage.getGroup(indexOfGroup).editGoodsInGroup(indexOfProduct, str,
                        storage.getGroup(indexOfGroup).getGood(indexOfProduct).getDescription(),
                        storage.getGroup(indexOfGroup).getGood(indexOfProduct).getMaker(),
                        storage.getGroup(indexOfGroup).getGood(indexOfProduct).getAmountOnStock(),
                        storage.getGroup(indexOfGroup).getGood(indexOfProduct).getPrice());
            } else if(indexOfParametr == 1){ // description
                storage.getGroup(indexOfGroup).editGoodsInGroup(indexOfProduct,
                        storage.getGroup(indexOfGroup).getGood(indexOfProduct).getName(), str,
                        storage.getGroup(indexOfGroup).getGood(indexOfProduct).getMaker(),
                        storage.getGroup(indexOfGroup).getGood(indexOfProduct).getAmountOnStock(),
                        storage.getGroup(indexOfGroup).getGood(indexOfProduct).getPrice());
            } else if(indexOfParametr == 2){ //maker
                storage.getGroup(indexOfGroup).editGoodsInGroup(indexOfProduct,
                        storage.getGroup(indexOfGroup).getGood(indexOfProduct).getName(),
                        storage.getGroup(indexOfGroup).getGood(indexOfProduct).getDescription(),
                        str,  storage.getGroup(indexOfGroup).getGood(indexOfProduct).getAmountOnStock(),
                        storage.getGroup(indexOfGroup).getGood(indexOfProduct).getPrice());

            } else if(indexOfParametr == 3) {// price
                boolean check = true;
                try {
                    double n = Double.parseDouble(str);
                } catch (NumberFormatException e) {
                    check = false;
                }
                if (check) {
                    storage.getGroup(indexOfGroup).editGoodsInGroup(indexOfProduct,
                            storage.getGroup(indexOfGroup).getGood(indexOfProduct).getName(),
                            storage.getGroup(indexOfGroup).getGood(indexOfProduct).getDescription(),
                            storage.getGroup(indexOfGroup).getGood(indexOfProduct).getMaker(),
                            storage.getGroup(indexOfGroup).getGood(indexOfProduct).getAmountOnStock(),
                            Double.parseDouble(str));
                }
            }

            availableDataFrame.setVisible(false);
            newFrame.setVisible(true);

            SwingUtilities.updateComponentTreeUI(availableDataFrame);

        }
        else if(event.getSource() == buttonToWriteInfoInFile){
            storage.writeAllGroups();
            JOptionPane.showMessageDialog(this, "Дані було успішно записано до файлу.");

        }
        else if(event.getSource() == buttonSearchForGoods){
            newFrame.setVisible(false);
            availableDataFrame = new JFrame("Пошук товару");
            availableDataFrame.setSize(500, 400);
            availableDataFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            panelToSearchForGoods = new JPanel();
            panelToSearchForGoods.setBackground(Color.BLACK);
            panelToSearchForGoods.setBorder(BorderFactory.createEmptyBorder(40, 0, 10, 0));
            panelToSearchForGoods.setLayout(new FlowLayout());
            availableDataFrame.add(panelToSearchForGoods);


            labelToFindGoodsByName = new JLabel("Введіть назву товару: ");
            labelToFindGoodsByName.setForeground(Color.white);
            labelToFindGoodsByName.setFont(new Font("Georgia", Font.ITALIC, 18));
            labelToFindGoodsByName.setHorizontalAlignment(JLabel.CENTER);

            textFieldSearchGoods = new JTextField(15);

            buttonSearchForGoodsWithEnteredData = new JButton("Шукати товар");
            buttonSearchForGoodsWithEnteredData.addActionListener(this);


            panelToSearchForGoods.add(labelToFindGoodsByName);
            panelToSearchForGoods.add(textFieldSearchGoods);
            panelToSearchForGoods.add(buttonSearchForGoodsWithEnteredData);
            availableDataFrame.setVisible(true);
        }

        else if(event.getSource() == buttonSearchForGoodsWithEnteredData){

            if(labelWithGoodsInSearching != null){
                panelToSearchForGoods.remove(labelWithGoodsInSearching[0]);
                panelToSearchForGoods.remove(labelWithGoodsInSearching[1]);
                panelToSearchForGoods.remove(labelWithGoodsInSearching[2]);
                panelToSearchForGoods.remove(labelWithGoodsInSearching[3]);
                panelToSearchForGoods.remove(buttonFinishSearching);
            }
            String str = textFieldSearchGoods.getText();
            String[] data;
            data = storage.searchForGoods(str);

            labelWithGoodsInSearching = new JLabel[4];

            labelWithGoodsInSearching[0] = new JLabel(data[0]);
            labelWithGoodsInSearching[0].setForeground(Color.white);
            labelWithGoodsInSearching[0].setFont(new Font("Georgia", Font.ITALIC, 15));
            labelWithGoodsInSearching[0].setHorizontalAlignment(JLabel.LEFT);

            labelWithGoodsInSearching[1] = new JLabel(data[1]);
            labelWithGoodsInSearching[1].setForeground(Color.white);
            labelWithGoodsInSearching[1].setFont(new Font("Georgia", Font.ITALIC, 15));
            labelWithGoodsInSearching[1].setHorizontalAlignment(JLabel.CENTER);

            labelWithGoodsInSearching[2] = new JLabel(data[2]);
            labelWithGoodsInSearching[2].setForeground(Color.white);
            labelWithGoodsInSearching[2].setFont(new Font("Georgia", Font.ITALIC, 15));
            labelWithGoodsInSearching[2].setHorizontalAlignment(JLabel.CENTER);

            labelWithGoodsInSearching[3] = new JLabel(data[3]);
            labelWithGoodsInSearching[3].setForeground(Color.white);
            labelWithGoodsInSearching[3].setFont(new Font("Georgia", Font.ITALIC, 15));
            labelWithGoodsInSearching[3].setHorizontalAlignment(JLabel.CENTER);

            panelToSearchForGoods.add(labelWithGoodsInSearching[0]);
            panelToSearchForGoods.add(labelWithGoodsInSearching[1]);
            panelToSearchForGoods.add(labelWithGoodsInSearching[2]);
            panelToSearchForGoods.add(labelWithGoodsInSearching[3]);


            buttonFinishSearching = new JButton("Закінчити пошук");
            buttonFinishSearching.addActionListener(this);
            panelToSearchForGoods.add(buttonFinishSearching);

            SwingUtilities.updateComponentTreeUI(availableDataFrame);


        }

        else if(event.getSource() == buttonFinishSearching){
            availableDataFrame.setVisible(false);
            newFrame.setVisible(true);
        }
        // інтерфейс додавання товару (7 пункт)
        else if(event.getSource() == buttonAddAmountOfGoods){
            panelInteractionWithAvailableData.remove(panelInProcess2);
            panelInteractionWithAvailableData.remove(panelInProcess);
            panelInteractionWithAvailableData.remove(panelToChooseChangeAmountOfGoods);
            panelInteractionWithAvailableData.remove(buttonPanelAvailableData);
            panelInteractionWithAvailableData.remove(labelTitle);

          radioButtonsToChooseGroupInEditingGoods = new JRadioButton[storage.numberOfGroups()];

          labelQuestion = new JLabel("Оберіть групу: ");
            labelQuestion.setForeground(Color.white);
          labelQuestion.setFont(new Font("Georgia", Font.ITALIC, 17));
          labelQuestion.setHorizontalAlignment(SwingConstants.LEFT);

          panelInteractionWithAvailableData.add(labelQuestion);

          ButtonGroup bg = new ButtonGroup();
          for(int i =0; i < storage.numberOfGroups(); i++){
              radioButtonsToChooseGroupInEditingGoods[i] = new JRadioButton(storage.getNameOfGroup(i));
              bg.add(radioButtonsToChooseGroupInEditingGoods[i]);
              panelInteractionWithAvailableData.add(radioButtonsToChooseGroupInEditingGoods[i]);
            }

          buttonToChooseGroupInAddingAmount = new JButton("ОК");
            buttonToChooseGroupInAddingAmount.addActionListener(this);
            panelInteractionWithAvailableData.add(buttonToChooseGroupInAddingAmount);

            SwingUtilities.updateComponentTreeUI(availableDataFrame);
        }

        else if(event.getSource() == buttonToChooseGroupInAddingAmount){

            panelInteractionWithAvailableData.remove(labelQuestion);
            for(int i =0; i < radioButtonsToChooseGroupInEditingGoods.length; i++){
                panelInteractionWithAvailableData.remove(radioButtonsToChooseGroupInEditingGoods[i]);
            }
            panelInteractionWithAvailableData.remove(buttonToChooseGroupInAddingAmount);

            boolean m = false;
            for(int i =0; i < radioButtonsToChooseGroupInEditingGoods.length; i++){
                if(radioButtonsToChooseGroupInEditingGoods[i].isSelected()){
                    m = true;
                    indexOfGroup = i;
                }
            }

            if(!m){
                JOptionPane.showMessageDialog(this, "Ви не обрали жодну групу,неможливо застосувати зміни.");
                availableDataFrame.setVisible(false);
                newFrame.setVisible(true);
                return;
            }

            labelQuestion = new JLabel("Оберіть товар: ");
            labelQuestion.setForeground(Color.white);
            labelQuestion.setFont(new Font("Georgia", Font.ITALIC, 17));
            labelQuestion.setHorizontalAlignment(SwingConstants.LEFT);

            panelInteractionWithAvailableData.add(labelQuestion);

            radioButtonsToChooseGoodsInEditingGoods = new JRadioButton[storage.getGroup(indexOfGroup).getNumberOfGoodsInGroup()];
            ButtonGroup bg = new ButtonGroup();
            for(int i =0; i < radioButtonsToChooseGoodsInEditingGoods.length; i++){
                radioButtonsToChooseGoodsInEditingGoods[i] = new JRadioButton(storage.getGroup(indexOfGroup).getGood(i).getName());
                bg.add(radioButtonsToChooseGoodsInEditingGoods[i]);
                panelInteractionWithAvailableData.add(radioButtonsToChooseGoodsInEditingGoods[i]);
            }

            buttonAcceptGoods = new JButton("OK");
            buttonAcceptGoods.addActionListener(this);
            panelInteractionWithAvailableData.add(buttonAcceptGoods);

            SwingUtilities.updateComponentTreeUI(availableDataFrame);

        }

        else if(event.getSource() == buttonAcceptGoods){
            panelInteractionWithAvailableData.remove(labelQuestion);
            panelInteractionWithAvailableData.remove(buttonAcceptGoods);
            for (JRadioButton radioButtonsToChooseGoodsInEditingGood : radioButtonsToChooseGoodsInEditingGoods) {
                panelInteractionWithAvailableData.remove(radioButtonsToChooseGoodsInEditingGood);
            }

            boolean m = false;
            for(int i =0; i < radioButtonsToChooseGoodsInEditingGoods.length; i++){
                if(radioButtonsToChooseGoodsInEditingGoods[i].isSelected()){
                    m = true;
                    indexOfProduct = i;
                }
            }

            if(!m){
                JOptionPane.showMessageDialog(this, "Ви не обрали жоден товар, неможливо застосувати зміни.");
                availableDataFrame.setVisible(false);
                newFrame.setVisible(true);
                return;
            }

            labelQuestion = new JLabel("Вкажіть, скільки нового товару надійшло: ");
              labelQuestion.setForeground(Color.white);
              labelQuestion.setFont(new Font("Georgia", Font.ITALIC, 17));
              labelQuestion.setHorizontalAlignment(SwingConstants.LEFT);

              textFieldAddAmountOfGoods = new JTextField(8);

              buttonAcceptAddAmountOfGoods = new JButton("ОК");
              buttonAcceptAddAmountOfGoods.addActionListener(this);

              panelInteractionWithAvailableData.add(labelQuestion);
              panelInteractionWithAvailableData.add(textFieldAddAmountOfGoods);
              panelInteractionWithAvailableData.add(buttonAcceptAddAmountOfGoods);
            SwingUtilities.updateComponentTreeUI(availableDataFrame);

        }

        else if(event.getSource() == buttonAcceptAddAmountOfGoods){
            String s = textFieldAddAmountOfGoods.getText();

            int i;
            try {
                i = Integer.parseInt(s);
            } catch (NumberFormatException e){
                JOptionPane.showMessageDialog(this, "Невірно вказані дані.");
                availableDataFrame.setVisible(false);
                newFrame.setVisible(true);
                return;
            }

            if(i < 0 ){
                JOptionPane.showMessageDialog(this, "Невірно вказані дані.");
                availableDataFrame.setVisible(false);
                newFrame.setVisible(true);
                return;
            }
            storage.getGroup(indexOfGroup).getGood(indexOfProduct).setAmountOnStock(storage.getGroup(indexOfGroup).getGood(indexOfProduct).getAmountOnStock() + i);

            availableDataFrame.setVisible(false);
            newFrame.setVisible(true);

        }
    }


}

/**
 *   labelQuestion = new JLabel("Вкажіть, скільки нового товару надійшло: ");
 *             labelQuestion.setForeground(Color.white);
 *             labelQuestion.setFont(new Font("Georgia", Font.ITALIC, 17));
 *             labelQuestion.setHorizontalAlignment(SwingConstants.LEFT);
 *
 *             textFieldAddAmountOfGoods = new JTextField(8);
 *
 *             buttonAcceptAddAmountOfGoods = new JButton("ОК");
 *             buttonAcceptAddAmountOfGoods.addActionListener(this);
 *
 *             panelInteractionWithAvailableData.add(labelQuestion);
 *             panelInteractionWithAvailableData.add(textFieldAddAmountOfGoods);
 *             panelInteractionWithAvailableData.add(buttonAcceptAddAmountOfGoods);
 *             SwingUtilities.updateComponentTreeUI(availableDataFrame);
 */