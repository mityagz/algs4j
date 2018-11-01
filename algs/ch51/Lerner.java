package algs.ch51;

/**
 * Created by mitya on 4/15/17.
 */
public class Lerner {
    private String Name;
    private Integer Section;

    public Lerner(String Name, Integer Section) {
        this.Name = Name;
        this.Section = Section;
    }

    public int key() {
        return Section;
    }

    public String getName() {
        return Name;
    }

    public String toString() {
        return Name + " : " + Section;
    }
}
