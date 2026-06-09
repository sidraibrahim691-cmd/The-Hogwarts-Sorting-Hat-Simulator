package com.hogwarts.engine;

import com.hogwarts.data.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

public class SortingHatGUI extends JFrame {
    private JLabel sortingHatLabel;
    private Clip currentClip;

    // Window size
    private static final int WIDTH = 1000;
    private static final int HEIGHT = 700;

    // Main Panel
    private CardLayout cardLayout;
    private JPanel mainPanel;

    // Welcome Screen Components
    private JPanel welcomePanel;
    private JTextField nameField;
    private JButton startButton;

    // User
    private User currentUser;

    // Quiz Data
    private Question[] questions;
    private int currentQuestion = 0;

    // Quiz Screen Components
    private JPanel quizPanel;
    private JLabel questionNumberLabel;
    private JTextArea questionLabel;

    private JButton optionButton1;
    private JButton optionButton2;
    private JButton optionButton3;
    private JButton optionButton4;

    // Sorting Screen Components
    private JPanel sortingPanel;
    private JLabel sortingLabel;
    private JLabel thinkingLabel;
    private JProgressBar sortingProgressBar;
    private Timer sortingTimer;
    private int progressValue = 0;

    // Result Screen Components
    private JPanel resultPanel;
    private JLabel congratulationsLabel;
    private JLabel houseLabel;
    private JLabel imageLabel;
    private JLabel logoLabel;
    private JTextArea descriptionArea;
    private JButton restartButton;
    private JButton exitButton;

    // Scores
    private int gryffindorScore = 0;
    private int hufflepuffScore = 0;
    private int ravenclawScore = 0;
    private int slytherinScore = 0;

    // Calculator
    private HouseCalculator calculator;

    public SortingHatGUI() {
        questions = QuizData.getQuestions_text();
        calculator = new HouseCalculator();

        initializeFrame();
        initializePanels();

        setVisible(true);
    }

    private void initializeFrame() {
        setTitle("Hogwarts House Sorting Ceremony");
        setSize(WIDTH, HEIGHT);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
    }

    private void initializePanels() {
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        createWelcomePanel();
        createQuizPanel();
        createSortingPanel();
        createResultPanel();

        mainPanel.add(welcomePanel, "WELCOME");
        mainPanel.add(quizPanel, "QUIZ");
        mainPanel.add(sortingPanel, "SORTING");
        mainPanel.add(resultPanel, "RESULT");

        add(mainPanel);
        cardLayout.show(mainPanel, "WELCOME");
    }

    private void createWelcomePanel() {
        welcomePanel = new JPanel() {
            private Image background = new ImageIcon("images/hogwarts_background.jpg").getImage();

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(background, 0, 0, getWidth(), getHeight(), this);
                g.setColor(new Color(0, 0, 0, 120));
                g.fillRect(0, 0, getWidth(), getHeight());
            }
        };

        welcomePanel.setLayout(null);

        JLabel title = new JLabel("HOGWARTS HOUSE SORTING CEREMONY");
        title.setFont(new Font("Serif", Font.BOLD, 36));
        title.setForeground(new Color(255, 215, 0));
        title.setBounds(180, 50, 700, 50);
        welcomePanel.add(title);

        ImageIcon hatIcon = new ImageIcon("images/sorting_hat.png");
        Image hatImage = hatIcon.getImage().getScaledInstance(250, 250, Image.SCALE_SMOOTH);
        JLabel hatLabel = new JLabel(new ImageIcon(hatImage));
        hatLabel.setBounds(375, 120, 250, 250);
        welcomePanel.add(hatLabel);

        JLabel nameLabel = new JLabel("Enter Your Name:");
        nameLabel.setFont(new Font("Serif", Font.BOLD, 22));
        nameLabel.setForeground(Color.WHITE);
        nameLabel.setBounds(350, 390, 250, 30);
        welcomePanel.add(nameLabel);

        nameField = new JTextField();
        nameField.setFont(new Font("Arial", Font.PLAIN, 20));
        nameField.setBounds(330, 430, 320, 40);
        welcomePanel.add(nameField);

        startButton = new JButton("Begin the Sorting");
        startButton.setFont(new Font("Serif", Font.BOLD, 20));
        addHoverEffect(startButton, new Color(128, 0, 0), new Color(180, 30, 30));
        startButton.setForeground(Color.WHITE);
        startButton.setFocusPainted(false);
        startButton.setBounds(360, 510, 250, 50);
        welcomePanel.add(startButton);

        startButton.addActionListener(e -> {
            String name = nameField.getText().trim();
            if (name.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter your name!", "Missing Name", JOptionPane.WARNING_MESSAGE);
                return;
            }
            currentUser = new User(name);
            JOptionPane.showMessageDialog(this, "Welcome to Hogwarts, " + name + "!");
            startQuiz();
        });
    }

    private void createQuizPanel() {
        quizPanel = new JPanel();
        quizPanel.setLayout(null);
        quizPanel.setBackground(new Color(245, 222, 179));

        // Question Number
        questionNumberLabel = new JLabel();
        questionNumberLabel.setFont(new Font("Serif", Font.BOLD, 24));
        questionNumberLabel.setBounds(40, 30, 250, 40);
        quizPanel.add(questionNumberLabel);

        // Question Text
        questionLabel = new JTextArea();
        questionLabel.setEditable(false);
        questionLabel.setLineWrap(true);
        questionLabel.setWrapStyleWord(true);
        questionLabel.setOpaque(false);
        questionLabel.setFont(new Font("Serif", Font.BOLD, 28));
        questionLabel.setBounds(100, 100, 800, 120);
        quizPanel.add(questionLabel);

        optionButton1 = createOptionButton();
        optionButton2 = createOptionButton();
        optionButton3 = createOptionButton();
        optionButton4 = createOptionButton();

        optionButton1.setBounds(250, 260, 500, 50);
        optionButton2.setBounds(250, 340, 500, 50);
        optionButton3.setBounds(250, 420, 500, 50);
        optionButton4.setBounds(250, 500, 500, 50);

        quizPanel.add(optionButton1);
        quizPanel.add(optionButton2);
        quizPanel.add(optionButton3);
        quizPanel.add(optionButton4);

        optionButton1.addActionListener(e -> handleAnswer(0));
        optionButton2.addActionListener(e -> handleAnswer(1));
        optionButton3.addActionListener(e -> handleAnswer(2));
        optionButton4.addActionListener(e -> handleAnswer(3));
    }

    private void startQuiz() {
        currentQuestion = 0;
        gryffindorScore = 0;
        hufflepuffScore = 0;
        ravenclawScore = 0;
        slytherinScore = 0;

        loadQuestion();
        cardLayout.show(mainPanel, "QUIZ");
    }

    private JButton createOptionButton() {
        JButton button = new JButton();
        button.setFont(new Font("Arial", Font.BOLD, 18));
        button.setFocusPainted(false);
        // FIXED: Added interactive state hover changes to all newly generated options variables
        addHoverEffect(button, new Color(128, 0, 0), new Color(180, 30, 30));
        button.setForeground(Color.WHITE);
        return button;
    }

    private void loadQuestion() {
        Question q = questions[currentQuestion];
        questionNumberLabel.setText("Question " + (currentQuestion + 1) + " of " + questions.length);
        questionLabel.setText(q.getQuestion_text());

        String[] options = q.getOptions();
        optionButton1.setText(options[0]);
        optionButton2.setText(options[1]);
        optionButton3.setText(options[2]);
        optionButton4.setText(options[3]);
    }

    private void handleAnswer(int selectedOption) {
        Question q = questions[currentQuestion];
        String house = q.getHouse_weights()[selectedOption];

        switch (house) {
            case "G" -> gryffindorScore++;
            case "H" -> hufflepuffScore++;
            case "R" -> ravenclawScore++;
            case "S" -> slytherinScore++;
        }

        currentQuestion++;
        if (currentQuestion < questions.length) {
            loadQuestion();
        } else {
            showSortingAnimation();
        }
    }

    private void createSortingPanel() {
        sortingPanel = new JPanel();
        sortingPanel.setLayout(null);
        sortingPanel.setBackground(new Color(35, 25, 45));

        ImageIcon hatGIF = new ImageIcon("images/sorting_hat.gif");
        sortingHatLabel = new JLabel(hatGIF);
        sortingHatLabel.setBounds(350, 20, 300, 200);
        sortingPanel.add(sortingHatLabel);

        sortingLabel = new JLabel("The Sorting Hat is deciding...");
        sortingLabel.setFont(new Font("Serif", Font.BOLD, 34));
        sortingLabel.setForeground(new Color(255, 215, 0));
        sortingLabel.setBounds(250, 230, 600, 50);
        sortingPanel.add(sortingLabel);

        thinkingLabel = new JLabel("Hmm...");
        thinkingLabel.setFont(new Font("Serif", Font.ITALIC, 28));
        thinkingLabel.setForeground(Color.WHITE);
        thinkingLabel.setBounds(350, 320, 400, 40);
        sortingPanel.add(thinkingLabel);

        sortingProgressBar = new JProgressBar(0, 100);
        sortingProgressBar.setBounds(250, 420, 500, 35);
        sortingProgressBar.setValue(0);
        sortingProgressBar.setStringPainted(true);
        sortingPanel.add(sortingProgressBar);
    }

    private void showSortingAnimation() {
        progressValue = 0;
        sortingProgressBar.setValue(0);
        cardLayout.show(mainPanel, "SORTING");

        sortingTimer = new Timer(100, null);
        sortingTimer.addActionListener(e -> {
            progressValue++;
            sortingProgressBar.setValue(progressValue);

            if (progressValue == 20) {
                thinkingLabel.setText("Interesting...");
            } else if (progressValue == 40) {
                thinkingLabel.setText("Very difficult...");
            } else if (progressValue == 60) {
                thinkingLabel.setText("You possess great qualities...");
            } else if (progressValue == 80) {
                thinkingLabel.setText("I know exactly where to put you...");
            } else if (progressValue >= 100) {
                sortingTimer.stop();
                showResultScreen();
            }
        });
        sortingTimer.start();
    }

    private void createResultPanel() {
        resultPanel = new JPanel();
        resultPanel.setLayout(null);
        resultPanel.setBackground(Color.BLACK);

        congratulationsLabel = new JLabel();
        congratulationsLabel.setFont(new Font("Serif", Font.BOLD, 28));
        congratulationsLabel.setBounds(250, 20, 600, 40);
        congratulationsLabel.setHorizontalAlignment(SwingConstants.CENTER);
        resultPanel.add(congratulationsLabel);

        houseLabel = new JLabel();
        houseLabel.setFont(new Font("Serif", Font.BOLD, 40));
        houseLabel.setBounds(250, 70, 500, 60);
        houseLabel.setHorizontalAlignment(SwingConstants.CENTER);
        resultPanel.add(houseLabel);

        imageLabel = new JLabel();
        imageLabel.setBounds(50, 150, 300, 350);
        resultPanel.add(imageLabel);

        logoLabel = new JLabel();
        logoLabel.setBounds(650, 180, 250, 250);
        resultPanel.add(logoLabel);

        descriptionArea = new JTextArea();
        descriptionArea.setEditable(false);
        descriptionArea.setOpaque(false);
        descriptionArea.setLineWrap(true);
        descriptionArea.setWrapStyleWord(true);
        descriptionArea.setFont(new Font("Serif", Font.PLAIN, 20));
        descriptionArea.setBounds(300, 180, 350, 250);
        resultPanel.add(descriptionArea);

        restartButton = new JButton("Sort Again");
        restartButton.setBounds(280, 550, 180, 50);
        restartButton.setFont(new Font("Arial", Font.BOLD, 18));
        restartButton.setFocusPainted(false);
        addHoverEffect(restartButton, new Color(50, 50, 50), new Color(90, 90, 90));
        resultPanel.add(restartButton);

        exitButton = new JButton("Exit");
        exitButton.setBounds(540, 550, 180, 50);
        exitButton.setFont(new Font("Arial", Font.BOLD, 18));
        exitButton.setFocusPainted(false);
        addHoverEffect(exitButton, new Color(50, 50, 50), new Color(90, 90, 90));
        resultPanel.add(exitButton);

        // FIXED: Registered functional listeners onto interactive command triggers
        restartButton.addActionListener(e -> {
            nameField.setText("");
            cardLayout.show(mainPanel, "WELCOME");
        });

        exitButton.addActionListener(e -> System.exit(0));
    }

    private void showResultScreen() {
        String winningHouse = calculator.determine_house(gryffindorScore, hufflepuffScore, ravenclawScore, slytherinScore);

        // FIXED: Null prevention check
        if (currentUser != null) {
            currentUser.setUser_house(winningHouse);
            congratulationsLabel.setText("Congratulations " + currentUser.getUser_name() + "!");
        } else {
            congratulationsLabel.setText("Congratulations!");
        }

        houseLabel.setText(winningHouse);

        switch (winningHouse) {
            case "Gryffindor" -> {
                resultPanel.setBackground(new Color(116, 0, 1));
                houseLabel.setForeground(Color.YELLOW);
                descriptionArea.setForeground(Color.WHITE);
                descriptionArea.setText("House Colors: Scarlet and Gold\n\n"
                        + "Where the brave dare to tread and the bold dare to lead!\n\n"
                        + "Your courage burns brighter than the scarlet in your robes.\n\n"
                        + "Motto:\nCourage above all.");
                loadImages("images/harry.png", "images/gryffindor_logo.png");
                playHouseVoice("audio/gryffindor.wav");
            }
            case "Hufflepuff" -> {
                resultPanel.setBackground(new Color(255, 204, 0));
                houseLabel.setForeground(Color.BLACK);
                descriptionArea.setForeground(Color.BLACK);
                descriptionArea.setText("House Colors: Yellow and Black\n\n"
                        + "Where kindness is a superpower.\n\n"
                        + "The world needs more people like you.\n\n"
                        + "Motto:\nBe kind. Work hard.");
                loadImages("images/cedric.png", "images/hufflepuff_logo.png");
                playHouseVoice("audio/hufflepuff.wav");
            }
            case "Ravenclaw" -> {
                resultPanel.setBackground(new Color(14, 26, 64));
                houseLabel.setForeground(Color.CYAN);
                descriptionArea.setForeground(Color.WHITE);
                descriptionArea.setText("House Colors: Blue and Bronze\n\n"
                        + "Where wit is worshipped and wisdom lights the way.\n\n"
                        + "Your mind is your greatest weapon.\n\n"
                        + "Motto:\nKnowledge is power.");
                loadImages("images/luna.png", "images/ravenclaw_logo.png");
                playHouseVoice("audio/ravenclaw.wav");
            }
            case "Slytherin" -> {
                resultPanel.setBackground(new Color(26, 71, 42));
                houseLabel.setForeground(Color.GREEN);
                descriptionArea.setForeground(Color.WHITE);
                descriptionArea.setText("House Colors: Green and Silver\n\n"
                        + "Where ambition meets cunning.\n\n"
                        + "Others dream of success.\nYou plan it.\n\n"
                        + "Motto:\nAmbition is destiny.");
                loadImages("images/draco.png", "images/slytherin_logo.png");
                playHouseVoice("audio/slytherin.wav");
            }
        }
        cardLayout.show(mainPanel, "RESULT");
    }

    private void loadImages(String character, String logo) {
        try {
            ImageIcon charIcon = new ImageIcon(character);
            Image charImg = charIcon.getImage().getScaledInstance(250, 300, Image.SCALE_SMOOTH);
            imageLabel.setIcon(new ImageIcon(charImg));

            ImageIcon logoIcon = new ImageIcon(logo);
            Image logoImg = logoIcon.getImage().getScaledInstance(220, 220, Image.SCALE_SMOOTH);
            logoLabel.setIcon(new ImageIcon(logoImg));
        } catch (Exception e) {
            System.err.println("Error loading result images: " + e.getMessage());
        }
    }

    private void playHouseVoice(String path) {
        try {
            if (currentClip != null && currentClip.isRunning()) {
                currentClip.stop();
                currentClip.close();
            }

            File audioFile = new File(path);
            if (!audioFile.exists()) {
                System.out.println("Audio file not found: " + path);
                return;
            }

            AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
            currentClip = AudioSystem.getClip();
            currentClip.open(audioStream);
            currentClip.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void addHoverEffect(JButton button, Color normal, Color hover) {
        button.setBackground(normal);
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                button.setBackground(hover);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                button.setBackground(normal);
            }
        });
    }
}