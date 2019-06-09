package controller.state.different_state_classes;

import controller.state.intfaces.WordsState;

import javax.xml.bind.annotation.*;
import java.util.List;
import java.util.Random;

@XmlRootElement(name = "classes_element")
@XmlAccessorType(XmlAccessType.FIELD)
public class FlowerWords implements WordsState {

    @XmlElementWrapper(name = "flower")
    @XmlElement(name = "a_flower")
    private List<String> flowers;
    @Override
    public String changeRandomWord() {
        return flowers.get(new Random().nextInt(flowers.size()));
    }
}
