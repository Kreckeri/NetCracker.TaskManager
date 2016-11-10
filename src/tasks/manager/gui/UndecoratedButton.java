package tasks.manager.gui;

import javax.swing.*;

public class UndecoratedButton extends JButton{

    public UndecoratedButton() {
        super();
        setBorderPainted(false);
        setFocusPainted(false);
        setContentAreaFilled(false);
        setOpaque(false);
    }

    public UndecoratedButton(Icon icon) {
        super(icon);
        setBorderPainted(false);
        setFocusPainted(false);
        setContentAreaFilled(false);
        setOpaque(false);
    }

    public UndecoratedButton(String text) {
        super(text);
        setBorderPainted(false);
        setFocusPainted(false);
        setContentAreaFilled(false);
        setOpaque(false);
    }

    public UndecoratedButton(Action a) {
        super(a);
        setBorderPainted(false);
        setFocusPainted(false);
        setContentAreaFilled(false);
        setOpaque(false);
    }

    public UndecoratedButton(String text, Icon icon) {
        super(text, icon);
        setBorderPainted(false);
        setFocusPainted(false);
        setContentAreaFilled(false);
        setOpaque(false);
    }
}
