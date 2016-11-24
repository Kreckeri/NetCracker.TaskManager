package tasks.manager.view.animations;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PulsatingTextAnimatedComponent extends JComponent{

    private String text;
    private JLabel textLabel = new JLabel();

    private Font defaultFont = new Font("Arial", 0,24);

    private int maxSize = 30;
    private int speed = 1;
    private int increase = 0;

    private boolean mouseOnLabel = false;

    private Timer animationPlayer = new Timer(200, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(mouseOnLabel) {
                if (increase<=0 || defaultFont.getSize()+increase<= maxSize)
                    increase += speed;
                else if( defaultFont.getSize()+increase > maxSize)
                    increase -= speed;
            }
            else
            {
                if(increase > 0)
                    increase-=speed;
                else
                    animationPlayer.stop();
            }

            textLabel.setFont(new Font(defaultFont.getFontName(), defaultFont.getStyle(), defaultFont.getSize()+increase));
            textLabel.setText(text);
        }
    });

    public PulsatingTextAnimatedComponent(String text) {
        super();
        this.text = text;
        textLabel.setFont(defaultFont);
        textLabel.setText(text);
        setSize(100,100);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                mouseOnLabel = true;
                if (!animationPlayer.isRunning())
                    animationPlayer.start();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                mouseOnLabel = false;
            }
        });
        add(textLabel);
    }
}
