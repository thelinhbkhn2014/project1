/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thelinh.gui;

import com.thelinh.model.Answer;
import com.thelinh.model.AnswerSql;
import com.thelinh.model.Question;
import com.thelinh.model.QuestionSql;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author hoangkien
 */
public class DoExam extends JDialog implements Runnable {

    private JLabel timeLabel;
    private Thread t;
    private boolean running;
    private JPanel panel; // Panel of answer
    private JLabel txtTitle; // Question here
    private ArrayList<Question> questionList;
    private ArrayList<ArrayList<Answer>> answerSuperList;
    private ArrayList<ArrayList<Boolean>> userAnswer;
    private int currentQuestion;
    private int time; // Minutes

    private int correctAnswer;

    private void addACheckBox(String text, Container container, boolean isChecked) {
        JCheckBox cb = new JCheckBox(text);
        cb.setSelected(isChecked);
        cb.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                onChecked(e);
            }
        });
        container.add(cb);
    }

    private void changeQuestion(int questionNumber, Question question,
            ArrayList<Answer> answerList) {
        panel.removeAll();
        panel.revalidate();
        txtTitle.setText("Câu hỏi " + (questionNumber + 1) + ": " + question.getQuestion());
        for (int i = 0; i < answerList.size(); i++) {
            addACheckBox(Character.toString((char) (i + 65))
                    + ". " + answerList.get(i).getAnswer(), panel, 
                    this.userAnswer.get(questionNumber).get(i));
        }
    }

    private int countCorrectAnswer() {
        int count = 0;
        for (int i = 0; i < this.answerSuperList.size(); i++) {
            ArrayList<Answer> currentAnswer = this.answerSuperList.get(i);
            ArrayList<Boolean> currentUserAnswer = this.userAnswer.get(i);
            boolean flag = true;
            for (int j = 0; j < currentAnswer.size(); j++) {
                if (!currentUserAnswer.get(j).equals(currentAnswer.get(j).getYesNo())) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                count++;
            }
        }
        return count;
    }

    public DoExam(java.awt.Frame parent, boolean modal) {
        // Render Element
        super(parent, modal);
        this.setSize(400, 300);
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        Container pane = this.getContentPane();

        timeLabel = new JLabel("Remaining time: 3600");
        JPanel titlePanel = new JPanel();
        System.out.println(titlePanel.getLayout());
        txtTitle = new JLabel();
        txtTitle.setFont(new Font("Dialog", Font.BOLD, 13));
        timeLabel.setFont(new Font("Dialog", Font.BOLD, 13));

        titlePanel.add(timeLabel);
        titlePanel.add(txtTitle);

        titlePanel.setBorder(new EmptyBorder(10, 10, 10, 20));
        titlePanel.setLayout(new BoxLayout(titlePanel, BoxLayout.Y_AXIS));

        panel = new JPanel();
        panel.setBorder(new EmptyBorder(0, 20, 0, 20));
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new FlowLayout());
        JButton btnPrev = new JButton("Previous");
        JButton btnNext = new JButton("Next");
        JButton btnEnd = new JButton("End");
        //JButton btnExit = new JButton("Exit");

        bottomPanel.add(btnPrev);
        bottomPanel.add(btnNext);
        bottomPanel.add(btnEnd);
        //bottomPanel.add(btnExit);

        pane.add(titlePanel, BorderLayout.PAGE_START);
        pane.add(panel, BorderLayout.LINE_START);
        pane.add(bottomPanel, BorderLayout.PAGE_END);

        btnNext.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onBtnNextClick(e);
            }
        });
        btnPrev.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onBtnPrevClick(e);
            }
        });
        btnEnd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onBtnEndClick(e);
            }
        });

        this.running = true;
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                System.out.println("Close");
                running = false;
            }
        });
        // Initialize value
        currentQuestion = 0;
        time = 15 * 60;
        correctAnswer = 0;
    }

    private void onBtnNextClick(ActionEvent e) {
        if (currentQuestion < this.questionList.size() - 1) {
            currentQuestion++;
            changeQuestion(currentQuestion, questionList.get(currentQuestion),
                    answerSuperList.get(currentQuestion));
        }
    }

    private void onBtnPrevClick(ActionEvent e) {
        if (currentQuestion > 0) {
            currentQuestion--;
            changeQuestion(currentQuestion, questionList.get(currentQuestion),
                    answerSuperList.get(currentQuestion));
        }
    }

    private void onBtnEndClick(ActionEvent e) {
        running = false;
    }

    private void onChecked(ItemEvent e) {
        Component[] arr = panel.getComponents();
        for (int i = 0; i < arr.length; i++) {
            Component item = arr[i];
            //System.out.println(((JCheckBox) item).isSelected());
            this.userAnswer.get(this.currentQuestion).set(i, ((JCheckBox) item).isSelected());
        }
        //System.out.println("Action");
        // Update answer here
    }

    public void setQuestionList(ArrayList<Question> questionList) {
        this.questionList = questionList;
        this.answerSuperList = new ArrayList<>();
        this.userAnswer = new ArrayList<>();

        for (int i = 0; i < questionList.size(); i++) {
            this.userAnswer.add(new ArrayList<>());
            ArrayList<Answer> answerList = AnswerSql.getAnswersByQuestionId(
                    questionList.get(i).getQuestionId());
            this.answerSuperList.add(answerList);
            for (int j = 0; j < answerList.size(); j++) {
                userAnswer.get(i).add(false);
            }
        }
    }

    public void setTime(int time) {
        this.time = time * 60;
    }

    public int getCorrectAnswer() {
        return this.correctAnswer;
    }

    // Time thread
    public void start() {
        System.out.println("Starting thread");
        System.out.println("Time: " + time + " seconds");
        changeQuestion(1, questionList.get(0), answerSuperList.get(0));
        if (t == null) {
            t = new Thread(this);
            t.start();
        }
    }

    @Override
    public void run() {
        while (running && time >= 0) {
            int minutes = time / 60;
            int seconds = time - 60 * minutes;
            if (seconds < 10) {
                this.timeLabel.setText("Remaining time: " + minutes + ":0" + seconds);
            } else {
                this.timeLabel.setText("Remaining time: " + minutes + ":" + seconds);
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                System.out.println(ex.toString());
            }
            time--;
        }
        correctAnswer = countCorrectAnswer();
        System.out.println("Thread end");
        this.dispose();
    }

    public static void main(String[] args) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info
                    : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException
                | IllegalAccessException
                | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DoExam.class.getName()).
                    log(java.util.logging.Level.SEVERE, null, ex);
        }

        ArrayList<Question> list = QuestionSql.getAllQuestionBySubjectId("IT1110");
        DoExam demo = new DoExam(null, true);
        demo.setQuestionList(list);
        demo.setTime(1);
        demo.start();
        demo.setVisible(true);
        System.out.println("Correct Answer is: " + demo.getCorrectAnswer());
    }

}
