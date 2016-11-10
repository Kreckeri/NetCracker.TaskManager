package tasks.manager.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class UndecoratedFrame extends JFrame {

    Point position = null;

    public UndecoratedFrame() throws HeadlessException {
        super();
        setUndecorated(true);

        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                position = e.getPoint();
                getComponentAt(position);
            }
        });

        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {

                int thisX = UndecoratedFrame.this.getLocation().x;
                int thisY = UndecoratedFrame.this.getLocation().y;

                int xMoved = (thisX + e.getX()) - (thisX + position.x);
                int yMoved = (thisY + e.getY()) - (thisY + position.y);

                int X = thisX + xMoved;
                int Y = thisY + yMoved;
                UndecoratedFrame.this.setLocation(X, Y);
            }
        });
    }

    public UndecoratedFrame(GraphicsConfiguration gc) {
        super(gc);
        setUndecorated(true);

        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                position = e.getPoint();
                getComponentAt(position);
            }
        });

        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {

                int thisX = UndecoratedFrame.this.getLocation().x;
                int thisY = UndecoratedFrame.this.getLocation().y;

                int xMoved = (thisX + e.getX()) - (thisX + position.x);
                int yMoved = (thisY + e.getY()) - (thisY + position.y);

                int X = thisX + xMoved;
                int Y = thisY + yMoved;
                UndecoratedFrame.this.setLocation(X, Y);
            }
        });
    }

    public UndecoratedFrame(String title) throws HeadlessException {
        super(title);
        setUndecorated(true);

        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                position = e.getPoint();
                getComponentAt(position);
            }
        });

        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {

                int thisX = UndecoratedFrame.this.getLocation().x;
                int thisY = UndecoratedFrame.this.getLocation().y;

                int xMoved = (thisX + e.getX()) - (thisX + position.x);
                int yMoved = (thisY + e.getY()) - (thisY + position.y);

                int X = thisX + xMoved;
                int Y = thisY + yMoved;
                UndecoratedFrame.this.setLocation(X, Y);
            }
        });
    }

    public UndecoratedFrame(String title, GraphicsConfiguration gc) {
        super(title, gc);
        setUndecorated(true);

        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                position = e.getPoint();
                getComponentAt(position);
            }
        });

        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {

                int thisX = UndecoratedFrame.this.getLocation().x;
                int thisY = UndecoratedFrame.this.getLocation().y;

                int xMoved = (thisX + e.getX()) - (thisX + position.x);
                int yMoved = (thisY + e.getY()) - (thisY + position.y);

                int X = thisX + xMoved;
                int Y = thisY + yMoved;
                UndecoratedFrame.this.setLocation(X, Y);
            }
        });
    }
}
