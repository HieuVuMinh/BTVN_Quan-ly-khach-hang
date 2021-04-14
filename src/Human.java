public class Human {
    private String name;
    private int age;
    private String identity;

    public Human(){};

    public Human(String name, int age, String identity) {
        this.name = name;
        this.age = age;
        this.identity = identity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }


}
