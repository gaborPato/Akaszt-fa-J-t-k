package controller.state.different_state_classes;

import javax.xml.bind.annotation.*;
import java.util.List;
import java.util.Random;

@XmlRootElement(name = "classes_element")
@XmlAccessorType(XmlAccessType.FIELD)
public class AnimalWords implements controller.state.intfaces.WordsState {


    @XmlElementWrapper(name = "animal")
    @XmlElement(name = "an_animal")
    private List<String> animal;


//

    public AnimalWords() {

    }


    @Override
    public String changeRandomWord() {
        return (String) animal.get(new Random().nextInt(animal.size()));
    }
}
