package pl.marekksiazek.frames;

import pl.marekksiazek.controller.DataReaderController;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class SetupFrame extends JFrame {

    public String username = System.getenv("USERNAME");

    public SetupFrame(){

        DataReaderController dataReaderController = new DataReaderController();

        Border borderInput = BorderFactory.createLineBorder(Color.BLACK, 1);

        String user = System.getenv("USERNAME");
        String[] minList = new String[60];

        for (int i = 0; i < minList.length; i++) {
           minList[i] = (i + 1) + "";
        }

        JButton buttonSave = new JButton("Save");
        JButton exitBtn = new JButton("Exit");

        this.setTitle("Settings");
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        this.setResizable(false);
        this.setSize(600, 300);
        this.setLayout(null);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(Color.LIGHT_GRAY);

        // LABELS

        JLabel userName = new JLabel("User name: ");
        JLabel loopTime = new JLabel("Loop time:  ");

        userName.setFont(new Font("Arial", Font.PLAIN, 14));
        userName.setForeground(Color.BLACK);
        userName.setBounds(50, 50, 210, 26);

        loopTime.setFont(new Font("Arial", Font.PLAIN, 14));
        loopTime.setForeground(Color.BLACK);
        loopTime.setBounds(50, 100, 210, 26);


        // INPUTS

        JTextField userNameInput = new JTextField(200);
        userNameInput.setFont(new Font("Arial", Font.PLAIN, 14));
        userNameInput.setForeground(Color.BLACK);
        userNameInput.setBounds(200, 50, 210, 26);
        userNameInput.setText(user);

        JComboBox loopTimeInput = new JComboBox(minList);
        loopTimeInput.setFont(new Font("Arial", Font.PLAIN, 14));
        loopTimeInput.setForeground(Color.BLACK);
        loopTimeInput.setBounds(200, 100, 210, 26);
        loopTimeInput.setSelectedItem(dataReaderController.getSecondLine());



        // BUTTONS

        buttonSave.setBounds(375, 200, 70, 26);
        buttonSave.setBorder(borderInput);
        buttonSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userNameInputValue = userNameInput.getText();
                String loopTimeInputValue = loopTimeInput.getItemAt(loopTimeInput.getSelectedIndex()).toString();

                try {
                    PrintWriter out = new PrintWriter("C:\\Users\\" + username + "\\Path\\to\\setup\\file" +
                            ".ini");
                    out.println(userNameInputValue);
                    out.println(loopTimeInputValue);
                    out.close();

                } catch (FileNotFoundException ex) {
                    throw new RuntimeException(ex);
                }



                SetupFrame.this.dispose();
            }
        });

        exitBtn.setBounds(450, 200, 70, 26);
        exitBtn.setBorder(borderInput);
        exitBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });


        this.add(userName);
        this.add(userNameInput);
        this.add(loopTime);
        this.add(loopTimeInput);
        this.add(buttonSave);
        this.add(exitBtn);

    }


}
