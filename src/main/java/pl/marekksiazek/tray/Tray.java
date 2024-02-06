package pl.marekksiazek.tray;

import pl.marekksiazek.frames.SetupFrame;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Tray{

    public Tray() {

        SystemTray systemTray = SystemTray.getSystemTray();

        PopupMenu popupMenu = new PopupMenu("Loop Driver");
        MenuItem setting = new MenuItem("Settings");
        MenuItem exit = new MenuItem("Exit");

        Image img =Toolkit.getDefaultToolkit().getImage(getClass().getClassLoader().getResource("icon.png"));
        TrayIcon trayIcon = new TrayIcon(img, "Loop Driver", popupMenu);



        setting.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SetupFrame setupFrame = new SetupFrame();
            }
        });

        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        popupMenu.add(setting);
        popupMenu.add(exit);

        trayIcon.setImageAutoSize(true);
        trayIcon.setPopupMenu(popupMenu);

        try{
            systemTray.add(trayIcon);
        } catch (AWTException e) {
            throw new RuntimeException(e.getMessage());
        }


    }

}
