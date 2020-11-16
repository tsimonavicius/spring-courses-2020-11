package lt.codeacademy;

public class Main {

    public static void main(String[] args) {
        System.out.println("Pazymiu vidurkis: " + new GradeService(new InternalMarksDao()).average());
    }

    private static class GradeService {

        private MarksDao marksDao;

        public GradeService(MarksDao marksDao) {
            this.marksDao = marksDao;
        }

        public double average() {

            return marksDao.getMarks().stream()
                    .mapToInt(Integer::intValue)
                    .average()
                    .getAsDouble();
        }
    }
}


// Service (average()) --> DAO (Data Access Object) (getMarks())
