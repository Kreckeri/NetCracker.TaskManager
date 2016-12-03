package tasks.manager.view;

import tasks.manager.model.journal.Task;
import tasks.manager.model.journal.TaskJournal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TaskManagerForm
{
    TaskJournal journal;

    public TaskManagerForm (String login, String password) //вызывается при регистрации нового пользователя ()
    {
        journal = new TaskJournal();

    }

    public TaskManagerForm(String login) //Вызывается при входе в существующий аккаунт
    {
        //journal =
    }


    public void init()
    {
        JFrame form = new JFrame("Планировщик задач");
        form.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        form.setSize(350, 500);
        form.setResizable(false);//возможность растягивать форму
        form.setLocationRelativeTo(null);//приложение открывается посередине экрана
        form.setLayout(null);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(221, 219, 221));
        panel.setBounds(0,0,350, 40);
        panel.setLayout(null);

        JButton addButton = new JButton(new ImageIcon("add(plus).png"));
        addButton.setBounds(35, 2, 70, 35);
        panel.add(addButton);

        JButton deleteButton = new JButton(new ImageIcon("delete.png"));
        deleteButton.setBounds(140, 2, 70, 35);
        panel.add(deleteButton);

        JButton editButton = new JButton(new ImageIcon("edit.png"));
        editButton.setBounds(245, 2, 70, 35);
        panel.add(editButton);

        JTable table = new JTable(){   //Object[]{"Задача", "Время"}
            @Override
            public boolean isCellEditable ( int row, int column ) {return false;}
        };
        table.setBounds(0, 50, 320, 40);
        table.getTableHeader().setFont(new Font ("Helvetica",Font.PLAIN, 16));
        table.getTableHeader().setForeground(new Color(40, 40, 40));
        table.setFont(new Font ("Helvetica", Font.PLAIN, 14));
        table.setBackground(new Color(255, 255, 255));
        table.setForeground(new Color(40, 40, 40));
        table.setSelectionBackground(new Color(164, 214, 244));
        table.setGridColor(new Color(221, 219, 221));
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0, 40, 350, 460);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddForm form_add = new AddForm(journal);
                form_add.init();
            }
        });

        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (table.getSelectedRow()!=-1) //проверка на выделение в таблице строки
                {
                    //EditForm form_edit = new EditForm(journal, journal.getTask(table.getSelectedRow());нужен метод получения таска из журнала по порядковому номеру
                    //form_edit.init();
                }
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (table.getSelectedRow()!=-1)
                {
                    //journal.deleteTask(table.getSelectedRow());нужен метод удаления таска по порядковому номеру из журнала
                    table.repaint();
                }
            }
        });

        form.getContentPane().add(jsp);
        form.getContentPane().add(panel);

        form.setVisible(true);
    }

}
