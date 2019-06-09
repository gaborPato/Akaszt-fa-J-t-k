package controller.state;

import controller.constans.MY_STRINGS;
import controller.state.intfaces.WordsState;
import modell.XmlRead;

import javax.xml.bind.JAXBException;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.IOException;

@XmlRootElement(name = "words")
public class FindOutWords {

    private String word;
    private WordsState wordsState;

    public FindOutWords(String wordGroup) throws IOException, JAXBException {
        setWordGroup(wordGroup);
        generateNewWord();
    }

    public String getWord() {
        return word;
    }


    public void generateNewWord() {
        word = wordsState.changeRandomWord();
    }


    private void setWordGroup(String wordGroup) throws IOException, JAXBException {
        wordsState = XmlRead.xmlToObject(wordGroup);

      /*  if (wordGroup.equals(MY_STRINGS.wordsGroupFruit)) {
            wordsState = XmlRead.xmlToObject(wordGroup);
        }

        if (wordGroup.equals(MY_STRINGS.wordsGroupAnimal)) {
            wordsState = XmlRead.xmlToObject(wordGroup);
        }*/


    }


}
