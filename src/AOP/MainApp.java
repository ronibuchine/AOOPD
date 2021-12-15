package AOP;

public class MainApp {
    public static void main(String[] args) {
        Weld weld = new Weld();
        WeldContainer container = weld.initialize();
        Student student = container.select(Student.class).get();
        student.setAge(22);
        student.setName("Assaf");
        student.getAge();
        student.getName();
    }
}
