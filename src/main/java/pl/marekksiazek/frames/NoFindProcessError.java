package pl.marekksiazek.frames;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NoFindProcessError extends JFrame {
    public NoFindProcessError(){

        Border borderInput = BorderFactory.createLineBorder(Color.BLACK, 1);


        JButton exitBtn = new JButton("Wyjdź");

        this.setTitle("Brak procesu");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(500, 150);
        this.setLayout(null);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(Color.LIGHT_GRAY);

        // LABELS

        JLabel errorMsg = new JLabel("BSXPrinter nie jest uruchomiony");

        errorMsg.setFont(new Font("Arial", Font.BOLD, 14));
        errorMsg.setForeground(Color.RED);
        errorMsg.setBounds(125, 25, 300, 26);


        exitBtn.setBounds(375, 70, 70, 26);
        exitBtn.setBorder(borderInput);
        exitBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });


        this.add(errorMsg);
        this.add(exitBtn);

    }
}
