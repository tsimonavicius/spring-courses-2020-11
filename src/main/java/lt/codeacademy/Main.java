package lt.codeacademy;

public class Main {

    public static void main(String[] args) {
        System.out.println("Pazymiu vidurkis: " + new GradeService(new InternalMarksDao()).average());
    }
}


// Service (average()) --> DAO (Data Access Object) (getMarks())
