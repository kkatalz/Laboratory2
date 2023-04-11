import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//TODO другий екран -2 кнопки: робота з новими даними й старими

public class Interaction extends JFrame implements ActionListener {
    JButton OKButton, CancelButton, availableDataButton, newDataButton, makeGroup, addGood, BACK, buttonEditGroup,
            buttonEditGoods, buttonDeleteGroup, buttonDeleteGoods, buttonNextToEditGroupToDesc,
            buttonNextToEditNameOfGroup, buttonAssignGroup, buttonNextToDeleteGroup, buttonToChangeNameOgGroup,
            buttonToChooseGroupInEditingGoods, buttonToEditSpecifiedGood, buttonToChooseParametrOfProductL;
    JLabel nameLabel, startLabel, whichGroup, questionInEdit, questionInEditToChangeNameOfGroup, labelInfoAboutGoods;
    JPanel mainPanel, buttonPanel, buttonPanelData, panelInteractionWithNewData, buttonPanelNewData, panelInteractionWithAvailableData,
            buttonPanelAvailableData, buttonPanelInEdit;
    JFrame newFrame, thirdFrame, makeGroupFrame, addGoodFrame, availableDataFrame;
    JSpinner spinnerOfGroup, whatToChange;
    JTextArea listOfGroups;
    JTextArea newNameOrDescOfGroup;
    int numberOfGroup, whatToChangeInEdit;

    JLabel labelTitle;
    JScrollPane scrollText;
    JRadioButton[] radioButtonsToChooseGroupInEditingGoods, radioButtonsToChooseGoodsInEditingGoods, radioButtonsToChooseParametr;
    private Storage storage;
    private int indexOfGroup, indexOfProduct;


    public Interaction(Storage storage) {
        this.storage = storage;

        // for test
        storage.addGroup("їжа", "поїсти");
        storage.addGroup("одяг", "носити");
        storage.addGroup("кава", "пити");
        storage.addGroup("взуття", "взувати");

        storage.getGroup(1).addGoodsToGroup("Гречка", "Україна", "Верес", 20, 30);
        storage.getGroup(1).addGoodsToGroup("Хліб", "Україна", "Київхліб", 10, 24);
        storage.getGroup(1).addGoodsToGroup("Молоко", "Україна", "Яготинське", 90, 33);
        storage.getGroup(2).addGoodsToGroup("Джинси", "Україна", "Нові", 200, 800);
        storage.getGroup(2).addGoodsToGroup("Куртка", "Україна", "Нова", 90, 900);

        storage.getGroup(3).addGoodsToGroup("jacobs", "Україна", "міцна", 6, 5);

        storage.getGroup(4).addGoodsToGroup("Кросівки", "Україна", "Milana", 12, 600);


        //  storage.groups[1].addGoodsToGroup("гречка", "Україна", "Верес", 20, 30);

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
        else if (event.getSource() == availableDataButton) {
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

            buttonPanelAvailableData = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 40));
            buttonPanelAvailableData.setBackground(Color.black);
            panelInteractionWithAvailableData.add(buttonPanelAvailableData, BorderLayout.SOUTH);

            buttonEditGroup = new JButton("Редагувати групу");
            buttonPanelAvailableData.add(buttonEditGroup, BorderLayout.CENTER);
            buttonEditGroup.addActionListener(this);

            buttonDeleteGroup = new JButton("Видалити групу");
            buttonPanelAvailableData.add(buttonDeleteGroup, BorderLayout.CENTER);
            buttonDeleteGroup.addActionListener(this);

            buttonEditGoods = new JButton("Редагувати товар");
            buttonPanelAvailableData.add(buttonEditGoods, BorderLayout.SOUTH);
            buttonEditGoods.addActionListener(this);

            buttonDeleteGoods = new JButton("Видалити товар");
            buttonPanelAvailableData.add(buttonDeleteGoods, BorderLayout.SOUTH);
            buttonDeleteGoods.addActionListener(this);

            availableDataFrame.setVisible(true);
        }
        // when button "видалити групу" is pressed
        else if (event.getSource() == buttonDeleteGroup) {
            panelInteractionWithAvailableData.remove(buttonPanelAvailableData);
            panelInteractionWithAvailableData.remove(labelTitle);

            listOfGroups = new JTextArea(10, 40);
            listOfGroups.setLineWrap(true);
            listOfGroups.setWrapStyleWord(true);
            scrollText = new JScrollPane(listOfGroups);

            panelInteractionWithAvailableData.add(scrollText, BorderLayout.CENTER);

            String s = "";
            for (int i = 0; i < storage.numberOfGroups(); i++) s += i + ")" + storage.getInfoAboutGroup(i) + "\n";
            listOfGroups.setText(s);
            ////////////////////////
            whichGroup = new JLabel("Оберіть групу, яку бажаєте видалити: ");
            whichGroup.setForeground(Color.white);
            whichGroup.setFont(new Font("Georgia", Font.ITALIC, 18));
            whichGroup.setHorizontalAlignment(JLabel.CENTER);
            panelInteractionWithAvailableData.add(whichGroup);

            SpinnerModel value = new SpinnerNumberModel(0, 0, storage.numberOfGroups() - 1, 1);
            spinnerOfGroup = new JSpinner(value);
            panelInteractionWithAvailableData.add(spinnerOfGroup, BorderLayout.CENTER);

            buttonNextToDeleteGroup = new JButton("Видалити");
            buttonNextToDeleteGroup.addActionListener(this);
            panelInteractionWithAvailableData.add(buttonNextToDeleteGroup);


            SwingUtilities.updateComponentTreeUI(availableDataFrame);

        } else if (event.getSource() == buttonNextToDeleteGroup) {
            numberOfGroup = (Integer) spinnerOfGroup.getValue();
            // not correctly when
            //    for(int i =0; i < storage.groups[numberOfGroup].getNumberOfGoods(); i++) {
            //       storage.groups[numberOfGroup].deleteGoodsInGroup(i);
            //   }
            storage.deleteGroup(numberOfGroup);
            availableDataFrame.setVisible(false);
            newFrame.setVisible(true);
        }

        // actions when button "редагувати групу" is pressed
        else if (event.getSource() == buttonEditGroup) {
            panelInteractionWithAvailableData.remove(buttonPanelAvailableData);
            panelInteractionWithAvailableData.remove(labelTitle);


            listOfGroups = new JTextArea(10, 40);
            listOfGroups.setLineWrap(true);
            listOfGroups.setWrapStyleWord(true);
            scrollText = new JScrollPane(listOfGroups);

            panelInteractionWithAvailableData.add(scrollText, BorderLayout.CENTER);

            String s = "";
            for (int i = 0; i < storage.numberOfGroups(); i++) s += i + ")" + storage.getInfoAboutGroup(i) + "\n";
            listOfGroups.setText(s);

            whichGroup = new JLabel("Оберіть групу, яку бажаєте відредагувати: ");
            whichGroup.setForeground(Color.white);
            whichGroup.setFont(new Font("Georgia", Font.ITALIC, 18));
            whichGroup.setHorizontalAlignment(JLabel.CENTER);
            panelInteractionWithAvailableData.add(whichGroup);

            SpinnerModel value = new SpinnerNumberModel(0, 0, storage.numberOfGroups() - 1, 1);
            spinnerOfGroup = new JSpinner(value);
            panelInteractionWithAvailableData.add(spinnerOfGroup, BorderLayout.CENTER);


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

            panelInteractionWithAvailableData.remove(buttonPanelInEdit);


            panelInteractionWithAvailableData.remove(whichGroup);
            panelInteractionWithAvailableData.remove(listOfGroups);
            panelInteractionWithAvailableData.remove(scrollText);

            panelInteractionWithAvailableData.remove(spinnerOfGroup);

            questionInEdit = new JLabel("Вкажіть новий опис групи: ");
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

        } else if (event.getSource() == buttonAssignGroup) {
            String newDesc = newNameOrDescOfGroup.getText();
            storage.editGroup(numberOfGroup, storage.getNameOfGroup(numberOfGroup), newDesc);

            panelInteractionWithAvailableData.remove(questionInEdit);
            panelInteractionWithAvailableData.remove(newNameOrDescOfGroup);
            panelInteractionWithAvailableData.remove(buttonAssignGroup);

            SwingUtilities.updateComponentTreeUI(availableDataFrame);
            availableDataFrame.setVisible(false);
            newFrame.setVisible(true);

        } // натиснута кнопка редагувати опис групи
        else if (event.getSource() == buttonNextToEditNameOfGroup) {

            panelInteractionWithAvailableData.remove(buttonPanelInEdit);

            panelInteractionWithAvailableData.remove(whichGroup);
            panelInteractionWithAvailableData.remove(listOfGroups);
            panelInteractionWithAvailableData.remove(scrollText);

            panelInteractionWithAvailableData.remove(spinnerOfGroup);

            questionInEditToChangeNameOfGroup = new JLabel("Вкажіть нову назву групи: ");
            questionInEditToChangeNameOfGroup.setForeground(Color.white);
            questionInEditToChangeNameOfGroup.setFont(new Font("Georgia", Font.ITALIC, 18));
            questionInEditToChangeNameOfGroup.setHorizontalAlignment(JLabel.CENTER);
            panelInteractionWithAvailableData.add(questionInEditToChangeNameOfGroup);

            // new value
            newNameOrDescOfGroup = new JTextArea(4, 10);

            newNameOrDescOfGroup.setLineWrap(true);
            newNameOrDescOfGroup.setWrapStyleWord(true);
            scrollText = new JScrollPane(newNameOrDescOfGroup);

            panelInteractionWithAvailableData.add(scrollText, BorderLayout.CENTER);
            // change button
            buttonToChangeNameOgGroup = new JButton("Далі");
            buttonToChangeNameOgGroup.addActionListener(this);
            panelInteractionWithAvailableData.add(buttonToChangeNameOgGroup, BorderLayout.SOUTH);


            SwingUtilities.updateComponentTreeUI(availableDataFrame);

        } else if (event.getSource() == buttonToChangeNameOgGroup) {
            String newName = newNameOrDescOfGroup.getText();
            storage.editGroup(numberOfGroup, newName, storage.getDescOfGroup(numberOfGroup));

            panelInteractionWithAvailableData.remove(questionInEdit);
            panelInteractionWithAvailableData.remove(questionInEditToChangeNameOfGroup);
            panelInteractionWithAvailableData.remove(newNameOrDescOfGroup);
            panelInteractionWithAvailableData.remove(buttonToChangeNameOgGroup);

            SwingUtilities.updateComponentTreeUI(availableDataFrame);
            availableDataFrame.setVisible(false);
            newFrame.setVisible(true);
        }
        // кнопка редагувати товар
        else if (event.getSource() == buttonEditGoods) {
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
        // хоче поредагувати в продукті
        else if (event.getSource() == buttonToEditSpecifiedGood) {
            for (JRadioButton radioButtonsToChooseGoodsInEditingGood : radioButtonsToChooseGoodsInEditingGoods) {
                panelInteractionWithAvailableData.remove(radioButtonsToChooseGoodsInEditingGood);
            }
            panelInteractionWithAvailableData.remove(buttonToEditSpecifiedGood);
            System.out.println("Кількість товарів у групі: " + storage.getGroup(indexOfGroup).getNumberOfGoodsInGroup());
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
            radioButtonsToChooseParametr = new JRadioButton[5];
            radioButtonsToChooseParametr[0] = new JRadioButton("Назва");
            radioButtonsToChooseParametr[1] = new JRadioButton("Опис");
            radioButtonsToChooseParametr[2] = new JRadioButton("Виробник");
            radioButtonsToChooseParametr[3] = new JRadioButton("Кількість");
            radioButtonsToChooseParametr[4] = new JRadioButton("Ціна");
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
                    if (i == 0) {
                        labelInfoAboutGoods = new JLabel("Введіть нову назву: ");
                        panelInteractionWithAvailableData.add(labelInfoAboutGoods);
                        labelInfoAboutGoods.setForeground(Color.white);
                        labelInfoAboutGoods.setFont(new Font("Georgia", Font.PLAIN, 10));
                        labelInfoAboutGoods.setHorizontalAlignment(SwingConstants.LEFT);
                    } else if (i == 1) {
                        labelInfoAboutGoods = new JLabel("Введіть новий опис: ");
                        panelInteractionWithAvailableData.add(labelInfoAboutGoods);
                        labelInfoAboutGoods.setForeground(Color.white);
                        labelInfoAboutGoods.setFont(new Font("Georgia", Font.PLAIN, 15));
                        labelInfoAboutGoods.setHorizontalAlignment(SwingConstants.LEFT);
                    } else if (i == 2) {
                        labelInfoAboutGoods = new JLabel("Введіть нового виробника: ");
                        panelInteractionWithAvailableData.add(labelInfoAboutGoods);
                        labelInfoAboutGoods.setForeground(Color.white);
                        labelInfoAboutGoods.setFont(new Font("Georgia", Font.PLAIN, 15));
                        labelInfoAboutGoods.setHorizontalAlignment(SwingConstants.LEFT);
                    } else if (i == 3) {
                        labelInfoAboutGoods = new JLabel("Введіть нову кількість: ");
                        panelInteractionWithAvailableData.add(labelInfoAboutGoods);
                        labelInfoAboutGoods.setForeground(Color.white);
                        labelInfoAboutGoods.setFont(new Font("Georgia", Font.PLAIN, 15));
                        labelInfoAboutGoods.setHorizontalAlignment(SwingConstants.LEFT);
                    } else if (i == 4) {
                        labelInfoAboutGoods = new JLabel("Введіть нову ціну: ");
                        panelInteractionWithAvailableData.add(labelInfoAboutGoods);
                        labelInfoAboutGoods.setForeground(Color.white);
                        labelInfoAboutGoods.setFont(new Font("Georgia", Font.PLAIN, 15));
                        labelInfoAboutGoods.setHorizontalAlignment(SwingConstants.LEFT);
                    }
                    break;
                }
            }

            if (!marker) {
                JOptionPane.showMessageDialog(this, "Ви не обрали жодного пункту.");
                availableDataFrame.setVisible(false);
                newFrame.setVisible(true);
                return;
            }

            JTextField newInfo = new JTextField(15);
            panelInteractionWithAvailableData.add(newInfo);



            SwingUtilities.updateComponentTreeUI(availableDataFrame);

        }
    }


}