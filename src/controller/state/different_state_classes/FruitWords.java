package controller.state.different_state_classes;


import javax.xml.bind.annotation.*;
import java.util.List;
import java.util.Random;

@XmlRootElement(name = "classes_element")
@XmlAccessorType(XmlAccessType.FIELD)
public class FruitWords implements controller.state.intfaces.WordsState {
    @XmlElementWrapper(name = "fruit")
    @XmlElement(name = "a_fruit")
    private List<String> fruits;

    public FruitWords() {

    }

    @Override
    public String changeRandomWord() {
        return fruits.get(new Random().nextInt(fruits.size()));
    }
}
