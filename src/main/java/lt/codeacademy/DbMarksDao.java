package lt.codeacademy;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DbMarksDao implements MarksDao {

    @Override
    public List<Integer> getMarks() {
        return null;
    }
}
