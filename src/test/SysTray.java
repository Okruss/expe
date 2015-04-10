/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.Panel;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import javax.swing.Icon;
import javax.swing.JOptionPane;
import javax.swing.plaf.metal.MetalIconFactory;

/**
 *
 * @author Okruss
 */
public class SysTray {
   public static void main(String[] args) throws Exception {
      TrayIcon icon = new TrayIcon(getImage(), "Java application as a tray icon", 
            createPopupMenu());
      icon.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(null, "Tenemos contratos pendientes.");
         }


      });
      SystemTray.getSystemTray().add(icon);

      Thread.sleep(3000);

      icon.displayMessage("Hey!", "Contratos pendientes!", 
            TrayIcon.MessageType.WARNING);
   }

   private static Image getImage() throws HeadlessException {
      Icon defaultIcon = MetalIconFactory.getTreeHardDriveIcon();
      Image img = new BufferedImage(defaultIcon.getIconWidth(), 
            defaultIcon.getIconHeight(), BufferedImage.TYPE_4BYTE_ABGR);
      defaultIcon.paintIcon(new Panel(), img.getGraphics(), 0, 0);

      return img;
   }

   private static PopupMenu createPopupMenu() throws HeadlessException {
      PopupMenu menu = new PopupMenu();

      MenuItem exit = new MenuItem("Exit");
      exit.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            System.exit(0);
         }
      });
      menu.add(exit);

      return menu;
   }
}