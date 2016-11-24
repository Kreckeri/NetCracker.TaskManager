package tasks.manager.view.animations;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WavesAnimatedComponent extends JComponent {
    private int speed = 8;//pixels per tic

    private int[] waveRadius = {0, 0, 0};

    private Color[] waveColors = {new Color(0x3E1965),
            new Color(0x380F65),
            new Color(0x310065),};

    /*private Color[] waveColors = {new Color(0xA7007B),
            new Color(0x7B003A),
            new Color(0x310065)};*/

    private int[] ticForStart = {0, 40, 80, 120, 160};
    private int ticsCounter = 0;

    private int delayBeforeRetrying = 1000;

    private Timer animationRepeater = new Timer(delayBeforeRetrying, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
                animationPlayer.start();
        }
    });

    private Timer animationPlayer = new Timer(10, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            ticsCounter++;
            int maxWaveRadius = (int)Math.sqrt((double)(getHeight()*getHeight()+getWidth()*getWidth()))+1;
            if (waveRadius[waveRadius.length-1] < maxWaveRadius) {
                for (int i = 0; i < waveRadius.length; i++)
                    if (ticsCounter >= ticForStart[i])
                        if (waveRadius[i] < maxWaveRadius)
                            waveRadius[i] += speed;
                repaint();
            } else {
                animationPlayer.stop();
                ticsCounter = 0;
                for (int i = 0; i < waveRadius.length; i++)
                    waveRadius[i] = 0;
            }
        }
    });


    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setPaint(waveColors[waveRadius.length-1]);
        g2d.fillRect(0, 0, getWidth(), getHeight());
        if (animationPlayer.isRunning()) {


            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);

            for (int i = 0; i < waveRadius.length; i++) {
                g2d.setPaint(waveColors[i]);
                g2d.fillOval((getSize().width - waveRadius[i]) / 2,
                        (getSize().height - waveRadius[i]) / 2,
                        waveRadius[i],
                        waveRadius[i]);
            }
        }

    }

    public WavesAnimatedComponent() {
        super();
        setOpaque(true);
        setDoubleBuffered(true);
        repaint();
        animationRepeater.start();
    }
}
