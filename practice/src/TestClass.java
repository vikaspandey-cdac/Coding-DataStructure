public class TestClass {
    public static void main(String[] args) {
        int name = 2;
        Employee employee = new Employee();
        employee.setPerson(new Person(){

            public void setAge(){
                int str1 = name;
                System.out.println("value::"+name);
            }
        });
    }
}

class Employee{
    public void setPerson(Person person) {
        this.person = person;
    }

    private Person person;

}

class Person {

    private String name;
    private int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }
    //gettersm setters, toString
}
