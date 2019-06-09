package modell;

import controller.constans.MY_STRINGS;
import controller.state.different_state_classes.AnimalWords;
import controller.state.different_state_classes.FlowerWords;
import controller.state.different_state_classes.FruitWords;
import controller.state.intfaces.WordsState;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.IOException;

public class XmlRead {


    private XmlRead() {
    }

    public static WordsState xmlToObject(String wordsGroup) throws IOException, JAXBException {

        try {
            File xmlFile = new File("./game_words.xml");
            if (!xmlFile.exists() || !xmlFile.canRead())
                throw new IOException("forrás fájl olvasási hiba");
            Class recentClass;
            recentClass = wordsGroup.equals(MY_STRINGS.wordsGroupAnimal) ? AnimalWords.class
                    : wordsGroup.equals(MY_STRINGS.wordsGroupFruit) ? FruitWords.class
                    : wordsGroup.equals(MY_STRINGS.wordsGroupFlower) ? FlowerWords.class
                    : null;

            JAXBContext jaxbContext = JAXBContext.newInstance(recentClass);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            return (WordsState) unmarshaller.unmarshal(xmlFile);

        } catch (JAXBException e) {
            throw e;
        }


    }
}
