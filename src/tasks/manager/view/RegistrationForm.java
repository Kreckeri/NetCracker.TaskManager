package tasks.manager.view;

import tasks.manager.model.journal.TaskJournal;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class RegistrationForm
{
    TaskJournal journal;

    public RegistrationForm()
    {
        //journal = new TaskJournal();
    }

    public void init() {
        JFrame form = new JFrame("Планировщик задач (авторизация)");
        form.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        form.setSize(350, 180);
        form.setResizable(false);
        form.setLocationRelativeTo(null);
        form.setLayout(null);

        JPanel panel = new JPanel() {
            public void paintComponent(Graphics g) {
                g.drawImage(new ImageIcon("Reg_back.png").getImage(), 0, 0, null);
            }
        };
        panel.setBounds(0, 0, 350, 300);
        panel.setLayout(null);

        JButton entryButton = new JButton("Войти");
        entryButton.setBounds(140, 80, 70, 35);
        panel.add(entryButton);

        JButton registrationButton = new JButton("Новый пользователь");
        registrationButton.setFont(new Font("Helvetica", Font.PLAIN, 10));
        registrationButton.setForeground(new Color(0x575858));
        registrationButton.setBounds(115, 120, 120, 20);
        registrationButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) { }
            @Override
            public void mousePressed(MouseEvent e) { }
            @Override
            public void mouseReleased(MouseEvent e) { }

            @Override
            public void mouseEntered(MouseEvent e) {
                registrationButton.setForeground(new Color(0xA2CEFA));
            }
            @Override
            public void mouseExited(MouseEvent e) {
                registrationButton.setForeground(new Color(0x575858));
            }
        });
        registrationButton.setBorder(new EmptyBorder(1, 1, 1, 1));
        panel.add(registrationButton);

        JTextField login = new JTextField(15);
        login.setDocument(new PlainDocument() {
            @Override//ограничение на ввод (меньше 12 символов)
            public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
                if (str == null) return;
                if ((getLength() + str.length()) <= 12) {
                    super.insertString(offset, str, attr);
                }
            }
        });
        login.setBounds(100, 15, 160, 25);
        panel.add(login);

        JPasswordField password = new JPasswordField();
        password.setDocument(new PlainDocument() {
            @Override//ограничение на ввод (меньше 12 символов)
            public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
                if (str == null) return;
                if ((getLength() + str.length()) <= 12) {
                    super.insertString(offset, str, attr);
                }
            }
        });
        password.setBounds(100, 50, 160, 25);
        panel.add(password);

        JLabel logLabel = new JLabel("Логин");
        logLabel.setBounds(45, 15, 150, 25);
        panel.add(logLabel);

        JLabel logErrLabel = new JLabel();
        logErrLabel.setFont(new Font("Helvetica", Font.ITALIC, 10));
        logErrLabel.setForeground(new Color(0xF41E1D));
        logErrLabel.setBounds(105, 4, 200, 14);
        panel.add(logErrLabel);
        logErrLabel.setVisible(false);

        JLabel pasLabel = new JLabel("Пароль");
        pasLabel.setBounds(45, 50, 150, 25);
        panel.add(pasLabel);

        JLabel pasErrLabel = new JLabel();
        pasErrLabel.setFont(new Font("Helvetica", Font.ITALIC, 10));
        pasErrLabel.setForeground(new Color(0xF41E1D));
        pasErrLabel.setBounds(105, 39, 200, 14);
        panel.add(pasErrLabel);
        pasErrLabel.setVisible(false);

        entryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (check(login, logErrLabel, password, pasErrLabel))
                {
                    String log = login.getText();//полученный логин
                    //if (такой пользователь существует)
                    {
                        String pass = new String(password.getPassword());//полученный пароль
                        //if (пароль для заданного пользователя верный)
                        {
                            TaskManagerForm form_main = new TaskManagerForm(log);
                            form_main.init();
                            form.dispose();
                        }
                        //else {logErrLabel.setText("Неверный логин/пароль");}
                    }
                    //else {logErrLabel.setText("Неверный логин/пароль");}
                }
            }
        });

        registrationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (check(login, logErrLabel, password, pasErrLabel))
                {
                    String log = login.getText();//полученный логин
                    //if (такого пользователя не существует)
                    {
                        String pass = new String(password.getPassword());//полученный пароль

                        TaskManagerForm form_main = new TaskManagerForm(log, pass);
                        form_main.init();
                        form.dispose();
                    }
                    //else {вывести: пользователь с таким логином уже есть}
                }
            }
        });

        form.getContentPane().add(panel);
        form.setVisible(true);
    }

    public boolean check(JTextField login, JLabel logErrLabel, JPasswordField password, JLabel pasErrLabel)
    {
        if (login.getText().equals(""))//проверка на пустое поле логина
        {
            logErrLabel.setText("Введите логин");
            logErrLabel.setVisible(true);
            return false;
        }
        else
        {
            char[] ch = login.getText().toCharArray();
            for (int i = 0; i < login.getText().length(); i++)
            {
                if (ch[i] == ' ')
                {
                    logErrLabel.setText("Логин не должен содержать пробелов");
                    logErrLabel.setVisible(true);
                    return false;
                }
            }
        }
        if (password.getPassword().length == 0)
        {
            pasErrLabel.setText("Введите пароль");
            pasErrLabel.setVisible(true);
            return false;
        }
        else
        {
            for (int i = 0; i < password.getPassword().length; i++)
            {
                if (password.getPassword()[i] == ' ')
                {
                    pasErrLabel.setText("Пароль не должен содержать пробелов");
                    pasErrLabel.setVisible(true);
                    return false;
                }
            }
        }
        return true;
    }
}
