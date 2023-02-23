package appearsln;

import java.util.ArrayList;
import java.util.List;

public abstract class Appearsln {
    @Override
    public String toString() {
        return "Appearsln{" +
                "appearsln=" + appearsln +
                '}';
    }

    private boolean appearsln;

    public Appearsln(boolean appearsln) {
        this.appearsln = appearsln;
    }

}




