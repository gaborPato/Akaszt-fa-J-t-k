package view;

import controller.DataService;
import controller.WordsVerify;
import controller.constans.MY_STRINGS;
import controller.state.FindOutWords;

import javax.swing.*;
import javax.xml.bind.JAXBException;
import java.awt.*;
import java.io.IOException;
import java.util.List;

public class AkasztofaRun extends JFrame {

    public static void main(String[] args)  {
        new AkasztofaRun().setVisible(true);
    }


    private Container cont;
    private ButtonPanel buttonPanel;
    private WordLabel wordLabel;
    private PicturePanel picturePanel;
    private FindOutWords findOutWords;
    private WordGroupComboBox wordGroupComboBox;

    private int iconCounter;
    private List<ImageIcon> iconPathList;

    public AkasztofaRun() throws HeadlessException {


        super("akasztófa játék");
        setLayout(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        setSize(1320, 650);
        setResizable(false);
        cont = getContentPane();
        wordGroupComboBox = new WordGroupComboBox();
        try {
            findOutWords = new FindOutWords((String) wordGroupComboBox.getSelectedItem());
        } catch (IOException | JAXBException e) {
            JOptionPane.showMessageDialog(null,e.getMessage());
            System.exit(1);
        }
        iconCounter = 0;//lépésszámláló
        iconPathList = DataService.getPictureList();

        picturePanel = new PicturePanel();
        wordLabel = new WordLabel();
        buttonPanel = new ButtonPanel();
        cont.add(buttonPanel);
        cont.add(wordLabel);
        cont.add(picturePanel);
        cont.add(wordGroupComboBox);





    }

   private class WordLabel extends JLabel {

        String wordLabelText;
        int textSize;

        void setTextSize() {
            textSize = 33;
            if (wordLabelText.length() > 30) {
                textSize = textSize - ((wordLabelText.length() - 30) / 2);
            }
            setFont(new java.awt.Font("Dialog", 1, textSize));
            System.out.println("textLength " + wordLabelText.length());
        }

        WordLabel() {
            super();

            wordLabelText = DataService.addStarsString(findOutWords);
            setTextSize();

            setBounds(520, 215, 720, 50);

            setText(wordLabelText);
        }

    }

    private class PicturePanel extends JPanel {

        JLabel pictureJlabel;


        PicturePanel() {

            super();
            setLayout(new FlowLayout(FlowLayout.CENTER));
            setBounds(30, 110, 350, 350);
            setBackground(Color.BLACK);
            pictureJlabel = new JLabel();
            add(pictureJlabel);
            //  pictureJlabel.setIcon(new ImageIcon("./Photos/08.jpg"));
        }
    }

    private class ButtonPanel extends JPanel {

        private JButton[] buttons;

        ButtonPanel() {

            super();
            this.setLayout(new FlowLayout());
            setBounds(470, 340, 580, 180);


            buttons = new JButton[35];
            buttons[0] = new JButton("a");
            buttons[1] = new JButton("á");
            buttons[2] = new JButton("b");
            buttons[3] = new JButton("c");
            buttons[4] = new JButton("d");
            buttons[5] = new JButton("e");
            buttons[6] = new JButton("é");
            buttons[7] = new JButton("f");
            buttons[8] = new JButton("g");
            buttons[9] = new JButton("h");
            buttons[10] = new JButton("i");
            buttons[11] = new JButton("í");
            buttons[12] = new JButton("j");
            buttons[13] = new JButton("k");
            buttons[14] = new JButton("l");
            buttons[15] = new JButton("m");
            buttons[16] = new JButton("n");
            buttons[17] = new JButton("o");
            buttons[18] = new JButton("ó");
            buttons[19] = new JButton("ö");
            buttons[20] = new JButton("ő");
            buttons[21] = new JButton("p");
            buttons[22] = new JButton("q");
            buttons[23] = new JButton("r");
            buttons[24] = new JButton("s");
            buttons[25] = new JButton("t");
            buttons[26] = new JButton("u");
            buttons[27] = new JButton("ú");
            buttons[28] = new JButton("ü");
            buttons[29] = new JButton("ű");
            buttons[30] = new JButton("v");
            buttons[31] = new JButton("w");
            buttons[32] = new JButton("x");
            buttons[33] = new JButton("y");
            buttons[34] = new JButton("z");

            for (JButton button : buttons) {
                button.setForeground(Color.RED);
                button.setFont(new Font(null, Font.BOLD, 18));

                this.add(button);
                button.addActionListener(l -> {
                    // System.out.println(button.getText());
                    button.setEnabled(false);
                    List<Integer> talalatList = WordsVerify.charVerify(button.getText(), findOutWords);
                    System.out.println(talalatList);
                    if (!talalatList.isEmpty()) {
                        goodAnswer(talalatList);

                    } else {//ures listanal nincs találat
                        badAnswer();
                    }
                    picturePanel.revalidate();
                    picturePanel.repaint();
                });

            }

        }
    }

    private void badAnswer() {

        picturePanel.pictureJlabel.setIcon(iconPathList.get(iconCounter));
        iconCounter++;
        //ez ellenörzi hol tart az akasztófa képek listája.Ha a végére ért,game over.
        if (iconCounter == iconPathList.size()) {

            JOptionPane.showMessageDialog(cont, "vesztes" +
                    "\nA helyes valasz:\n" + findOutWords.getWord());


            newGameProtocol();

        }


    }


    /**
     * @param talalatList
     */
    private void goodAnswer(List<Integer> talalatList) {
        StringBuffer tmp = new StringBuffer(wordLabel.getText());

        // tmp.append(wordLabel.getText());
        for (Integer integer : talalatList) {

            tmp.replace(integer, integer + 1, Character.toString(findOutWords.getWord().charAt(integer)));

        }

        wordLabel.setText(tmp.toString());
        if (!wordLabel.getText().contains("*")) {
            JOptionPane.showMessageDialog(null, "nyertes");
            newGameProtocol();
        }
    }

    /**
     * Kezdo ertekre allitja a jatek elemeit.
     */
    private void newGameProtocol() {

        iconCounter = 0;
        picturePanel.pictureJlabel.setIcon(null);

        findOutWords.generateNewWord();
        wordLabel.wordLabelText = DataService.addStarsString(findOutWords);
        wordLabel.setText(wordLabel.wordLabelText);
        wordLabel.setTextSize();
        for (JButton button : buttonPanel.buttons) {
            button.setEnabled(true);
        }
    }

    private final class WordGroupComboBox extends JComboBox<String> {
        public WordGroupComboBox() {
            super();
            setBounds(800, 100, 110, 40);
            addItem(MY_STRINGS.wordsGroupAnimal);
            addItem(MY_STRINGS.wordsGroupFruit);
            addItem(MY_STRINGS.wordsGroupFlower);
            addActionListener(l -> {

                try {
                    findOutWords = new FindOutWords((String) this.getSelectedItem());
                } catch (IOException | JAXBException e) {
                    JOptionPane.showMessageDialog(null,e.getMessage());
                    System.exit(1);
                }

                newGameProtocol();
            });

        }
    }
}
