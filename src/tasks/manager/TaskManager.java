package tasks.manager;

import tasks.manager.model.journal.Task;
import tasks.manager.model.journal.TaskJournal;
import tasks.manager.view.UndecoratedFrame;
import tasks.manager.view.animations.WavesAnimatedComponent;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.Vector;

public class TaskManager{

    TaskJournal journal;

    public TaskManager() {
        journal = new TaskJournal();
    }

    public void init() {


        JFrame mainFrame = new JFrame("Планировщик задачъ основная конструкция");
        mainFrame.setBounds(100, 100, 390, 500);
        mainFrame.setLayout(null);
        mainFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        mainFrame.setResizable(false);

        JButton addButton = new JButton("Add");
        addButton.setLocation(20, 20);
        addButton.setSize(100, 30);
        addButton.setVisible(true);
        mainFrame.add(addButton);

        JButton updateButton = new JButton("Update");
        updateButton.setLocation(140, 20);
        updateButton.setSize(100, 30);
        updateButton.setVisible(true);
        mainFrame.add(updateButton);

        JButton deleteButton = new JButton("Delete");
        deleteButton.setLocation(260, 20);
        deleteButton.setSize(100, 30);
        deleteButton.setVisible(true);
        mainFrame.add(deleteButton);

        Vector<Integer> test = new Vector<>(0);
        test.add(2);
        test.add(3);
        test.add(4);
        JList<Integer> list = new JList<>();
        list.setLocation(20, 70);
        list.setSize(mainFrame.getWidth() - 50, mainFrame.getHeight() - 29 - 90);
        list.setListData(test);
        list.setVisible(true);
        list.repaint();
        mainFrame.add(list);

        mainFrame.setVisible(true);


        JFrame notification = new UndecoratedFrame();
        JLayeredPane layeredPane = notification.getLayeredPane();
        WavesAnimatedComponent waves = new WavesAnimatedComponent();
        JButton completionButton = new JButton("Завершить");
        JButton prorogueButton = new JButton("Отложить");
        JLabel nameLabel = new JLabel("test name");


        nameLabel.setFont(new Font("Arial", Font.CENTER_BASELINE,24));
        nameLabel.setBounds(140,20,40, 460);
        nameLabel.setVisible(true);
        waves.setSize(600,150);
        prorogueButton.setBounds(20,20,100,100);
        completionButton.setBounds(480,20,100,100);


        notification.setBounds(500,375,600,150);

        layeredPane.add(nameLabel,new Integer(2));
        layeredPane.add(waves,JLayeredPane.DEFAULT_LAYER);
        layeredPane.add(completionButton,new Integer(2));
        layeredPane.add(prorogueButton,new Integer(2));
        notification.setLayeredPane(layeredPane);
        notification.setVisible(true);



    }


    //Delete task from journal
    public void deleteTask(Task task) {
        journal.addTask(task);
    }

    //Add task to journal
    public void addTask(Task task) {
        journal.addTask(task);
    }

    //Update task in journal
    public void updateTask(Task oldTask, Task newTask) {
        journal.modificationTask(oldTask, newTask);
    }

    public void loadJournalFromFile(File file) {

    }

    public void saveJournalToFile(File file) {

    }
}
