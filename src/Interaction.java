import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Interaction extends JFrame implements ActionListener {
    JButton OKButton;
    JButton CancelButton;
    JLabel nameLabel, startLabel;

    public Interaction() {
        this.setTitle("Робота зі складом ");
        this.setSize(500, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // головна панель
        JPanel mainPanel = new JPanel();
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
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 60, 10));//додається інтервал між кнопками OK Cancel
        buttonPanel.setBackground(Color.black);
        this.add(buttonPanel, BorderLayout.SOUTH);

        OKButton = new JButton("ОК");
        buttonPanel.add(OKButton);
        OKButton.addActionListener(this);

        CancelButton = new JButton("Cancel");
        buttonPanel.add(CancelButton);
        CancelButton.addActionListener(this);
    }

    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == CancelButton) {//закрити вікно
            this.dispose(); //
        }
    }

}