import tasks.manager.TaskManager;

public class Main {
    public static void main(String args[]){
        /*UndecoratedFrame frame = new UndecoratedFrame();

        frame.setSize(400,150);
        frame.setVisible(true);
        frame.setLocation(600,375);

        WavesAnimatedComponent waves = new WavesAnimatedComponent();
        waves.setOpaque(true);
        waves.setSize(400,150);
        waves.setVisible(true);

        //frame.setSize(500,500);
        //frame.setLocation(550,200);
        JButton t = new UndecoratedButton();
        t.setSize(100,100);

        JLayeredPane lp = frame.getLayeredPane();
        lp.add(waves,JLayeredPane.DEFAULT_LAYER);
        lp.add(t,new Integer(2));

        frame.setLayeredPane(lp);

        frame.setVisible(true);
        */

        TaskManager manager = new TaskManager();
        manager.init();

    }
}
