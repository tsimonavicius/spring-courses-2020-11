package lt.codeacademy;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        simpleDIExample();
        springDIExample();
    }

    private static void simpleDIExample() {

        GradeService gradeService = new GradeService(new InternalMarksDao());

        System.out.println("Simple JAVA Pazymiu vidurkis: " + gradeService.average());
    }

    private static void springDIExample() {
        ApplicationContext springContext = new AnnotationConfigApplicationContext(SpringContextConfig.class);

        GradeService gradeService = springContext.getBean(GradeService.class);

        System.out.println("Spring Pazymiu vidurkis: " + gradeService.average());
    }
}


// Service (average()) --> DAO (Data Access Object) (getMarks())
