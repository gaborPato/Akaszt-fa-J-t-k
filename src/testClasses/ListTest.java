package testClasses;

import controller.constans.MY_STRINGS;
import controller.state.FindOutWords;

import javax.xml.bind.JAXBException;
import java.io.IOException;

public class ListTest {

    public static void main(String[] args) throws IOException, JAXBException {

        FindOutWords f1 = new FindOutWords(MY_STRINGS.wordsGroupAnimal);
        System.out.println(f1.getWord());
        FindOutWords f2 = new FindOutWords(MY_STRINGS.wordsGroupFruit);
        System.out.println(f2.getWord());

    }
//        FindOutWords findOutWords= null;
//        try {
//            findOutWords = XmlRead.xmlToObject();
//        } catch (IOException | JAXBException e) {
//            System.out.println(e.getMessage());
//        }
//        System.out.println(findOutWords.getAnimals());
//        System.out.println(findOutWords.toString()); ;
//    }


   /* public static void main(String[] args) {
//        try {
//            System.out.println(ReadText.getWordList());
//        }catch (Exception e){
//
//            System.out.println(e.getMessage());
//        }

        for (int i = 0; i <20 ; i++) {

            System.out.println(DataService.getFindOutWords().getWord());

            System.out.println(DataService.addStarsString());
            DataService.resetFindOutWords();
        }


    }*/
}
