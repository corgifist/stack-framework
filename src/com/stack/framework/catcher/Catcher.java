/*
 * Created by JFormDesigner on Sat Mar 05 18:17:10 MSK 2022
 */

package com.stack.framework.catcher;

import com.stack.framework.Framework;
import com.stack.framework.Main;
import com.stack.framework.boot.Boot;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * @author unknown
 */
public class Catcher extends JFrame {

    private String ex;

    public Catcher(String ex) throws UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException{
        this.ex = ex;
        initComponents();
    }

    private void initComponents() throws UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - StackDev
        this.label1 = new JLabel();
        this.button1 = new JButton();
        this.button2 = new JButton();
        this.label2 = new JLabel();
        this.setTitle("stack!error");

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        this.label1.setText("An error occured, and framework can't continue to work!");
        this.label1.setFont(new Font("Segoe UI Black", Font.BOLD, 20));
        this.label1.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(this.label1);
        this.label1.setBounds(0, 5, 655, 25);

        //---- button1 ----
        this.button1.setText("Restart");
        this.button1.setFont(new Font("Segoe UI Black", Font.BOLD, 14));
        this.button1.setBackground(Color.LIGHT_GRAY);
        this.button1.setForeground(Color.BLACK);
        contentPane.add(this.button1);
        this.button1.addActionListener((e -> {
            try {
                Framework.run();
            } catch (UnsupportedLookAndFeelException | ClassNotFoundException | InstantiationException | IllegalAccessException exc) {
                exc.printStackTrace();
            }
        }));
        this.button1.setBounds(10, 350, 240, 45);

        //---- button2 ----
        this.button2.setFont(new Font("Segoe UI Black", Font.BOLD, 14));
        this.button2.setText("Exit");
        this.button2.addActionListener((e -> {
            System.exit(1);
        }));
        this.button2.setBackground(Color.LIGHT_GRAY);
        this.button2.setForeground(Color.BLACK);
        contentPane.add(this.button2);
        this.button2.setBounds(425, 350, 240, 45);

        //---- label2 ----
        System.out.println(ex);
        this.label2.setText(ex.split("\n")[0]);
        this.label2.setFont(new Font("Segoe UI Black", Font.BOLD, 12));
        this.label2.setHorizontalAlignment(SwingConstants.LEFT);
        contentPane.add(this.label2);
        this.label2.setBounds(10, 45, 655, 225);

        {
            // compute preferred size
            Dimension preferredSize = new Dimension();
            for(int i = 0; i < contentPane.getComponentCount(); i++) {
                Rectangle bounds = contentPane.getComponent(i).getBounds();
                preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
            }
            Insets insets = contentPane.getInsets();
            preferredSize.width += insets.right;
            preferredSize.height += insets.bottom;
            contentPane.setMinimumSize(preferredSize);
            contentPane.setPreferredSize(preferredSize);
        }
        pack();
        setLocationRelativeTo(getOwner());
        this.getContentPane().setBackground(Color.GRAY);
        this.setResizable(false);
        this.setVisible(true);
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - StackDev
    private JLabel label1;
    private JButton button1;
    private JButton button2;
    private JLabel label2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
