import java.util.Objects;

class TestAbstractClass {
    private int id;
    private String name;

    public TestAbstractClass(int id, String name){
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TestAbstractClass that = (TestAbstractClass) o;
        return id == that.id &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}

public class TestAbstract {
    public static void main(String args[]){
        TestAbstractClass abstractClass = new TestAbstractClass(1, "Vikas");
    }
}
