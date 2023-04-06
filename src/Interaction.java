import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//TODO другий екран -2 кнопки: робота з новими даними й старими

public class Interaction extends JFrame implements ActionListener {
    JButton OKButton, CancelButton, availableDataButton, newDataButton,makeGroup,addGood, BACK;
    JLabel nameLabel, startLabel;
    JPanel mainPanel, buttonPanel,buttonPanelData,panelInteractionWithNewData,buttonPanelNewData;
    JFrame newFrame,thirdFrame,makeGroupFrame, addGoodFrame;

    public Interaction() {
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
    }

}