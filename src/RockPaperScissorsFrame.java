import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

public class RockPaperScissorsFrame extends JFrame {
    int userChoice = 0;
    int minChoice = 0;
    String result = "";
    ArrayList<Integer> usePast = new ArrayList<Integer>();
    ArrayList<Integer> minPast = new ArrayList<Integer>();
    ArrayList<String> gamePast = new ArrayList<String>();

    public RockPaperScissorsFrame() {
        super("A Game of Rock Paper and Scissors");
        // declaration of background elements


        ArrayList<Integer> usePast = new ArrayList<Integer>();
        ArrayList<Integer> minPast = new ArrayList<Integer>();
        ArrayList<String> gamePast = new ArrayList<String>();
        Participant minerva = new Participant(false);
        GameControl gC=new GameControl();

        //declaring the UI Elements
        ImageIcon rock = new ImageIcon(getClass().getResource("Rock_Icon2.png"));
        ImageIcon paper = new ImageIcon(getClass().getResource("Paper_Icon2.png"));
        ImageIcon scissors = new ImageIcon(getClass().getResource("Scissors_Icon2.png"));
        ImageIcon quit = new ImageIcon(getClass().getResource("Quit_Icon2.png"));
        JPanel gamePanel = new JPanel();
        JPanel statPanel = new JPanel();
        JPanel recordsPanel = new JPanel();
        JButton rockButton = new JButton(rock);
        JButton paperButton = new JButton(paper);
        JButton scissorsButton = new JButton(scissors);
        JButton quitButton = new JButton(quit);
        JLabel title = new JLabel("Rock Paper Scissors");
        JLabel playerWins = new JLabel("0");
        JLabel computerWins = new JLabel("0");
        JLabel ties = new JLabel("0");
        JLabel playerWTitle = new JLabel("Player Wins");
        JLabel tiesTitle = new JLabel("Ties");
        JLabel computerWTitle = new JLabel("Computer Wins");
        GridBagConstraints c = new GridBagConstraints();

        //format recordsPanel
        recordsPanel.setLayout(new GridBagLayout());
        JTextArea ta = new JTextArea("", 5, 50); // Text area
        ta.setLineWrap(true);
        JScrollPane sbrText = new JScrollPane(ta); // Scroll pane for text area


        sbrText.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        c.weightx = 1;

        c.ipady = 0;
        c.gridx = 1;
        c.gridy = 1;

        recordsPanel.add(sbrText, c);
        c.weightx = 1;

        c.ipady = 0;
        c.gridx = 1;
        c.gridy = 0;
        recordsPanel.add(title, c);


        //format gamePanel

        gamePanel.setLayout(new GridBagLayout());
        c.weightx = 1;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 0;
        c.gridx = 0;
        c.gridy = 0;

        gamePanel.add(rockButton, c);
        c.weightx = 1;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 0;
        c.gridx = 1;
        c.gridy = 0;

        gamePanel.add(paperButton, c);
        c.weightx = 1;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 0;
        c.gridx = 2;
        c.gridy = 0;

        gamePanel.add(scissorsButton, c);
        c.weightx = 1;
        c.ipadx = 0;
        c.ipady = 0;
        c.gridx = 1;
        c.gridy = 1;

        gamePanel.add(quitButton, c);

        //format statPanel

        statPanel.setLayout(new GridBagLayout());
        c.weightx = 1;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 0;
        c.gridx = 0;
        c.gridy = 0;
        statPanel.add(playerWTitle, c);
        c.weightx = 1;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 0;
        c.gridx = 0;
        c.gridy = 1;
        statPanel.add(playerWins, c);
        c.weightx = 1;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 0;
        c.gridx = 1;
        c.gridy = 0;
        statPanel.add(tiesTitle, c);
        c.weightx = 1;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 0;
        c.gridx = 1;
        c.gridy = 1;
        statPanel.add(ties, c);
        c.weightx = 1;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 0;
        c.gridx = 2;
        c.gridy = 0;
        statPanel.add(computerWTitle, c);
        c.weightx = 1;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 0;
        c.gridx = 2;
        c.gridy = 1;
        statPanel.add(computerWins, c);

        //adding UI Elements
        setLayout(new GridBagLayout());
        c.weightx = 1;
        c.ipadx = 0;
        c.ipady = 0;
        c.gridx = 1;
        c.gridy = 2;
        add(statPanel, c);
        c.weightx = 1;
        c.ipadx = 0;
        c.ipady = 0;
        c.gridx = 1;
        c.gridy = 1;
        add(gamePanel, c);
        c.weightx = 1;
        c.ipadx = 0;
        c.ipady = 0;
        c.gridx = 1;
        c.gridy = 0;
        add(recordsPanel, c);

        //button listener
        quitButton.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        System.exit(0);
                    }
                }
        );
        rockButton.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        setUserChoice(0);
                        ArrayList<Integer>past=getUsePast();
                        gC.calculateResult(0,minerva.getChoice(0,getUsePast()));

                        if(past.size()==0) {
                            ta.setText(gC.getResult(minerva.getUsedStrat()));
                        }else {
                            ta.setText(ta.getText()+"\n"+gC.getResult(minerva.getUsedStrat()));

                        }
                        addToUserPast(0);
                        playerWins.setText(gC.getUserWins()+"");
                        ties.setText(gC.getTies()+"");
                        computerWins.setText(gC.getMinervaWins()+"");

                    }
                }
        );
        paperButton.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        setUserChoice(1);
                        ArrayList<Integer>past=getUsePast();
                        gC.calculateResult(1,minerva.getChoice(1,getUsePast()));

                        if(past.size()==0) {
                            ta.setText(gC.getResult(minerva.getUsedStrat()));
                        }else {
                            ta.setText(ta.getText()+"\n"+gC.getResult(minerva.getUsedStrat()));

                        }
                        addToUserPast(1);
                        playerWins.setText(gC.getUserWins()+"");
                        ties.setText(gC.getTies()+"");
                        computerWins.setText(gC.getMinervaWins()+"");

                    }
                }
        );
        scissorsButton.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        setUserChoice(2);
                        ArrayList<Integer>past=getUsePast();
                        gC.calculateResult(2,minerva.getChoice(2,getUsePast()));

                        if(past.size()==0) {
                            ta.setText(gC.getResult(minerva.getUsedStrat()));
                        }else {
                            ta.setText(ta.getText()+"\n"+gC.getResult(minerva.getUsedStrat()));

                        }
                        addToUserPast(2);
                        playerWins.setText(gC.getUserWins()+"");
                        ties.setText(gC.getTies()+"");
                        computerWins.setText(gC.getMinervaWins()+"");

                    }
                }
        );


        // formatting the frame
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;

        // center frame in screen

        setSize((int) (screenWidth / 1.25), (int) (screenHeight / 1.25));

        setLocation((int) (screenWidth / 9.5), (int) (screenHeight / 9));

        // Render the Frame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.show();

    }
    public void setUserChoice(int uChoice){
        this.userChoice=uChoice;
    }
    public void setMinChoice(int mChoice){
        this.minChoice=mChoice;
    }

    public ArrayList<Integer> getMinPast() {
        return minPast;
    }

    public ArrayList<Integer> getUsePast() {
        return usePast;
    }
    public void addToUserPast(int userChoice){
        this.usePast.add(userChoice);
    }

}






