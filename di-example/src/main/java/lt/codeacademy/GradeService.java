package lt.codeacademy;

import org.springframework.stereotype.Service;

@Service
public class GradeService {

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
