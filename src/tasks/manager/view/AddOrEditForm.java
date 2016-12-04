package tasks.manager.view;

import tasks.manager.model.journal.Task;

import javax.swing.*;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class AddOrEditForm
{

    JFrame form;
    JTextField name;
    JEditorPane textpane;
    JTextField dtf;
    JTextField mtf;
    JTextField ytf;
    JTextField htf;
    JTextField mintf;
    JLabel cancelLabel;
    JButton butAddEdit;

    public AddOrEditForm()
    {
        form = new JFrame();
        form.setSize(350, 400);
        form.setResizable(false);//возможность растягивать форму
        form.setLocation(160,200);
        form.setLayout(null);

        MyPanel panel = new MyPanel();
        panel.setBounds(0,0,350, 400);
        panel.setLayout(null);

        JLabel nameLabel = new JLabel("Задача:");
        nameLabel.setFont(new Font("Helvetica",Font.BOLD, 13));
        nameLabel.setForeground(new Color(0x575858));
        nameLabel.setBounds(10,20,80,15);
        panel.add(nameLabel);

        name = new JTextField();
        name.setDocument(new PlainDocument() {
            @Override//ограничение на ввод (меньше 25 символов)
            public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException
            {
                if (str == null) return;
                if ((getLength() + str.length()) <= 25) {super.insertString(offset, str, attr); }
            }
        });
        name.setBounds(70, 14, 280, 25);
        name.setBorder(null);
        name.setOpaque(false);
        panel.add(name);

        JLabel infoLabel = new JLabel("Описание:");
        infoLabel.setBounds(140,55,80,15);
        infoLabel.setFont(new Font("Helvetica",Font.BOLD, 13));
        infoLabel.setForeground(new Color(0x575858));
        panel.add(infoLabel);

        textpane = new JEditorPane();
        textpane.setOpaque(false);
        JScrollPane jsp = new JScrollPane(textpane);
        jsp.setBounds(5,75,340, 200);
        jsp.setBorder(null);
        jsp.setOpaque(false);
        jsp.getViewport().setOpaque(false);
        panel.add(jsp);

        LinePanel line1 = new LinePanel();
        line1.setBounds(0,40,350, 20);
        line1.setLayout(null);
        panel.add(line1);

        LinePanel line2 = new LinePanel();
        line2.setBounds(0,280,350, 20);
        panel.add(line2);

        JLabel dateLabel = new JLabel("Дата (дд/мм/гггг):");
        dateLabel.setBounds(28,295,120,15);
        dateLabel.setFont(new Font("Helvetica",Font.BOLD, 13));
        dateLabel.setForeground(new Color(0x575858));
        panel.add(dateLabel);

        SpinnerNumberModel day = new SpinnerNumberModel(12, 1, 31, 1);
        JSpinner dateDay = new JSpinner(day);
        dateDay.setBounds(20,310,32,30);
        dtf = ((JSpinner.DefaultEditor) dateDay.getEditor()).getTextField();
        dtf.setEditable(false);
        dtf.setOpaque(false);
        dtf.setBorder(null);
        panel.add(dateDay);

        JLabel slash1 = new JLabel("/");
        slash1.setBounds(53,307,10,40);
        slash1.setFont(new Font("Helvetica",Font.BOLD, 20));
        slash1.setForeground(new Color(0x575858));
        panel.add(slash1);

        SpinnerNumberModel month = new SpinnerNumberModel(11, 1, 12, 1);
        JSpinner dateMonth = new JSpinner(month);
        dateMonth.setBounds(60,310,32,30);
        mtf = ((JSpinner.DefaultEditor) dateMonth.getEditor()).getTextField();
        mtf.setEditable(false);
        mtf.setOpaque(false);
        mtf.setBorder(null);
        panel.add(dateMonth);

        JLabel slash2 = new JLabel("/");
        slash2.setBounds(93,307,10,40);
        slash2.setFont(new Font("Helvetica",Font.BOLD, 20));
        slash2.setForeground(new Color(0x575858));
        panel.add(slash2);

        SpinnerNumberModel year = new SpinnerNumberModel(2016, 2016, 2020, 1);
        JSpinner dateYear = new JSpinner(year);
        dateYear.setBounds(100,310,53,30);
        ytf = ((JSpinner.DefaultEditor) dateYear.getEditor()).getTextField();
        ytf.setEditable(false);
        ytf.setOpaque(false);
        ytf.setBorder(null);
        panel.add(dateYear);

        JLabel timeLabel = new JLabel("Время (чч:мм):");
        timeLabel.setBounds(210,295,120,15);
        timeLabel.setFont(new Font("Helvetica",Font.BOLD, 13));
        timeLabel.setForeground(new Color(0x575858));
        panel.add(timeLabel);

        SpinnerNumberModel hour = new SpinnerNumberModel(12, 0, 24, 1);
        JSpinner timeHour = new JSpinner(hour);
        timeHour.setBounds(218,310,32,30);
        htf = ((JSpinner.DefaultEditor) timeHour.getEditor()).getTextField();
        htf.setEditable(false);
        htf.setOpaque(false);
        htf.setBorder(null);
        panel.add(timeHour);

        JLabel dots = new JLabel(":");
        dots.setBounds(252,305,10,40);
        dots.setFont(new Font("Helvetica",Font.BOLD, 20));
        dots.setForeground(new Color(0x575858));
        panel.add(dots);

        SpinnerNumberModel minute = new SpinnerNumberModel(30, 0, 59, 1);
        JSpinner timeMinute = new JSpinner(minute);
        timeMinute.setBounds(261,310,32,30);
        mintf = ((JSpinner.DefaultEditor) timeMinute.getEditor()).getTextField();
        mintf.setEditable(false);
        mintf.setOpaque(false);
        mintf.setBorder(null);
        panel.add(timeMinute);

        butAddEdit = new JButton("");
        butAddEdit.setFont(new Font("Helvetica",Font.BOLD, 12));
        butAddEdit.setBounds(175, 346, 175, 30);
        butAddEdit.setForeground(new Color(0x3A3B3B));

        butAddEdit.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) { }
            @Override
            public void mousePressed(MouseEvent e) { }
            @Override
            public void mouseReleased(MouseEvent e) { }

            @Override
            public void mouseEntered(MouseEvent e) {
                butAddEdit.setForeground(new Color(0xA2CEFA));
            }
            @Override
            public void mouseExited(MouseEvent e) {
                butAddEdit.setForeground(new Color(0x575858));
            }
        });
        panel.add(butAddEdit);

        cancelLabel = new JLabel();

        JButton cancelButton = new JButton("Отменить");
        cancelButton.setFont(new Font("Helvetica",Font.BOLD, 12));
        cancelButton.setBounds(0, 346, 175, 30);
        cancelButton.setForeground(new Color(0x3A3B3B));
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JPanel pan = new JPanel(){
                    @Override
                    public void paintComponent(Graphics g) {
                        g.drawImage(new ImageIcon("cancel.png").getImage(), 0, 0, null);
                    }
                };
                pan.setBounds(0,0,350, 400);
                pan.setLayout(null);

                cancelLabel.setFont(new Font("Helvetica",Font.PLAIN, 15));
                cancelLabel.setBounds(60,150,300,50);
                pan.add(cancelLabel);

                JButton yesButton = new JButton("Да");
                yesButton.setBounds(25, 200, 150, 30);
                yesButton.addMouseListener(new MouseListener() {
                    @Override
                    public void mouseClicked(MouseEvent e) {}
                    @Override
                    public void mousePressed(MouseEvent e) {}
                    @Override
                    public void mouseReleased(MouseEvent e) {}
                    @Override
                    public void mouseEntered(MouseEvent e) {
                        yesButton.setForeground(new Color(0xFA8083));
                    }

                    @Override
                    public void mouseExited(MouseEvent e) {
                        yesButton.setForeground(new Color(0x575858));
                    }
                });
                yesButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        form.dispose();
                    }
                });//если да, то закрываем форму
                pan.add(yesButton);

                JButton noButton = new JButton("Нет");
                noButton.setBounds(175, 200, 150, 30);
                noButton.addMouseListener(new MouseListener() {
                    @Override
                    public void mouseClicked(MouseEvent e) {}
                    @Override
                    public void mousePressed(MouseEvent e) {}
                    @Override
                    public void mouseReleased(MouseEvent e) {}
                    @Override
                    public void mouseEntered(MouseEvent e) {
                        noButton.setForeground(new Color(0xA2CEFA));
                    }
                    @Override
                    public void mouseExited(MouseEvent e) {
                        noButton.setForeground(new Color(0x575858));
                    }
                });
                noButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        form.setContentPane(panel);
                        form.repaint();
                    }
                });//если нет, то перерисовываем
                pan.add(noButton);

                form.setContentPane(pan);
                form.repaint();
            }
        });
        cancelButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) { }
            @Override
            public void mousePressed(MouseEvent e) { }
            @Override
            public void mouseReleased(MouseEvent e) { }

            @Override
            public void mouseEntered(MouseEvent e) {
                cancelButton.setForeground(new Color(0xFA8083));
            }
            @Override
            public void mouseExited(MouseEvent e) {
                cancelButton.setForeground(new Color(0x575858));
            }
        });
        panel.add(cancelButton);

        form.getContentPane().add(panel);
    }

    public class MyPanel extends JPanel // фоновая панель
    {
        @Override
        public void paintComponent(Graphics g) {
            g.drawImage(new ImageIcon("Reg_back.png").getImage(), 0, 0, null);
        }
    }
    public class LinePanel extends JPanel // панель-линия
    {
        @Override
        public void paintComponent(Graphics g) {
            g.drawImage(new ImageIcon("line.png").getImage(), 0, 0, null);
        }
    }
}
