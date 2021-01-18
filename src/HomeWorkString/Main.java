package HomeWorkString;

public class Main {
    public static void main(String[] args) {
        String string = "Once upon a time a Wolf was lapping at a spring on a hillside, when, looking up, what" +
                " should he see but a Lamb just beginning to drink a little lower down.";
        TaskAlgoritm task = new TaskAlgoritm();
        System.out.println(task.getResult(string));
    }
}
