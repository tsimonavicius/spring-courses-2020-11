package lt.codeacademy;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        System.out.println("Pazymiu vidurkis: " + new GradeService().average());
    }


    private static class GradeService {

        private MarksDao marksDao = new InternalMarksDao();

        public double average() {

            List<Integer> marks = marksDao.getMarks();

            Double sum = Double.valueOf(0);

            for (Integer mark : marks) {
                sum += mark;
            }

            return sum / marks.size();
        }
    }
}



// Service (average()) --> DAO (Data Access Object) (getMarks())
