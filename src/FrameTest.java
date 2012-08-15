//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;

import java.awt.*;
import java.awt.event.*;
import java.net.URL;
import javax.swing.*;

/**
 * Created with IntelliJ IDEA.
 * User: Menno.deJong
 * Date: 15-8-12
 * Time: 11:17
 * To change this template use File | Settings | File Templates.
 */
public class FrameTest {
    private JFrame frame;
    private Image dogImage;
    private SystemTray sysTray;
    private PopupMenu menu;
    private MenuItem item1;
    private MenuItem item2;
    private TrayIcon trayIcon;

    //constructor
    public FrameTest() {
        initComponents();
        //basic stuff.
        frame.setSize(300,300);
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    }

    private void initComponents() {
        //create jframe
        frame = new JFrame("Frame Test");

        //check to see if system tray is supported on OS.
        if (SystemTray.isSupported()) {
            sysTray = SystemTray.getSystemTray();

            //create dog image
            dogImage  = Toolkit.getDefaultToolkit().getImage("images/bulb.gif");

            //create popupmenu
            menu = new PopupMenu();

            //create item
            item1 = new MenuItem("Exit");
            item2 = new MenuItem("Show app");

            //add item to menu
            menu.add(item1);



            //add action listener to the item in the popup menu
            item1.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    System.exit(0);
                }
            });

            //add second item to popup menu
            menu.add(item2);

            item2.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    frame.setVisible(true);

                }
            });

            //create system tray icon.
            trayIcon = new TrayIcon(dogImage, "Dog App.", menu);

            //add the tray icon to the system tray.
            try {
                sysTray.add(trayIcon);
            }
            catch(AWTException e) {
                System.out.println("System Tray unsupported!");
            }
        }
    }//end FrameTest constructor

    //main
    public static void main(String[]args) {
        SwingUtilities.invokeLater(new Runnable(){
            public void run() {
                new FrameTest().frame.setVisible(true);
//                new FrameTest();
            }
        });
    }//end main()

}//end FrameTest Class