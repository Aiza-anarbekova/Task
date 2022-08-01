package org.example;



import org.example.model.Course;
import org.example.model.Instructor;
import org.example.model.Lesson;
import org.example.model.Task;
import org.example.serviceImpl.CourseServiceImpl;
import org.example.serviceImpl.InstructorServiceIml;
import org.example.serviceImpl.LessonServiceImpl;
import org.example.serviceImpl.TaskServiceImpl;

import java.time.LocalDate;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
        Scanner scanner = new Scanner(System.in);
        DataBase.entityManager();




        CourseServiceImpl courseService =new  CourseServiceImpl();
        InstructorServiceIml instService = new InstructorServiceIml();
        LessonServiceImpl lessonService = new LessonServiceImpl();
        TaskServiceImpl taskService = new TaskServiceImpl();
        Course course1 = new Course("Piton",7,LocalDate.of(2022,10,27),"5ty&&роланао@@","backend");
       Course course = new Course("Java",9, LocalDate.of(2020,11,12),"78g2$%&&%**KUGFH#@1","Backend");
       Course course2 = new Course("Java Script",9, LocalDate.of(2020,10,21),"854+&THDE#%@","Frontend");

        Instructor instructor = new Instructor("Nurisa","Mamiraimova","nuri.0303@gmail.com","+996554321234");
        Instructor instructor1 = new Instructor("Aijamal","Asangazieva","aijamal.12@gmail.com","+996709768934");
        Instructor instructor2 = new Instructor("Munarjan","Aitbekova","muna.12@gmail.com","+996709768934");

        Lesson lesson = new Lesson("Hibernate","57858h$##%%$^#QQ");
        Lesson lesson1 = new Lesson("JDBC","57858h$##%%$^#QQ");
        Lesson lesson2 = new Lesson("SQL","jfdkjfkln58h$##%%$^#QQ");

        Task task = new Task("HomeWork 7 ",LocalDate.of(2022,7,20),"JDBC proekti Hibernate menen realizaciya kylynyzdar.");
        Task task2= new Task("HomeWork 5 ",LocalDate.of(2022,7,12),"sql zaprostordu kaitaloo");
        Task task1 = new Task("HomeWork 6 ",LocalDate.of(2022,7,16),"Атайын даярдалган проект менен таанышып чыгыныз жана аны аягына чыгарыныз. \n" +
                "Тапшырманы буткон сон жазган методдорунузду атайын жазылган JUnit тесттери менен текшериниз.\n" +
                "Тесттерди иштетуу учун test деген папканы таап, анын ичиндеги классты иштетуу керек (Run Класстын аты)\n " +
                "деген кнопканы басып класс UserDaoHibernateImpl бул тапшырмада бош калат.");

        System.out.println("1-- save Course \n" +
                "2--get Course ById \n" +
                "3--get all course \n " +
                "4--update course \n " +
                "5--delete course by id \n" +
                "6--get course by name \n" +
                "7--save instructor \n" +
                "8--update instructor \n" +
                "9--get instructor by id\n" +
                "10--get instructor by course id\n" +
                "11--delete inst by id\n" +
                "12--assign inst to course \n" +
                "13---save lesson\n" +
                "14 -- update lesson\n" +
                "15--get lesson by id\n" +
                "16--get lesson by course id\n" +
                "17-- save task\n" +
                "18--update task\n" +
                "19-- get task by lesson id\n" +
                "20-- delete task by id ");



        while (true){
            int a = scanner.nextInt();
            switch (a){
                case 1:
                    courseService.saveCourse(course);
                    courseService.saveCourse(course1);
                    ///courseService.saveCourse(course2);
                    break;
                case 2:
                    System.out.println(courseService.getCourseById(2L));
                    break;
                case 3:
                    courseService.getAllCourse().forEach(System.out::println);
                    break;
                case 4:
                    courseService.updateCourse(2L,course2);
                    break;
                case 5:
                    //courseService.deleteCourseById(1L);
                    courseService.deleteCourseById(2L);
                    break;
                case 6:
                    System.out.println(courseService.getCourseByName("Java Script"));
                    break;
                case 7:
                    instService.saveInstructor(instructor);
                    instService.saveInstructor(instructor1);
                    break;
                case 8:
                    instService.updateInstructor(4L,instructor2);
                    break;
                case 9:
                    System.out.println(instService.getInstructorById(4L));
                    break;
                case 10:
                    instService.getInstructorByCourseId(2L).forEach(System.out::println);
                    break;
                case 11:
                    instService.deleteInstructorById(5L);
                    break;
                case 12:
                    instService.assignInstructorToCourse(5L,2L);
                    instService.assignInstructorToCourse(5L,2L);
                    break;
                case 13:
                    lessonService.saveLesson(2L,lesson);
                    lessonService.saveLesson(3L,lesson1);
                    break;
                case 14:
                    lessonService.updateLesson(7L,lesson2);
                    break;
                case 15:
                    System.out.println(lessonService.getLessonById(6L));
                    break;
                case 16:
                    lessonService.getLessonByCourseId(3L).forEach(System.out::println);
                    break;
                case 17:
                    taskService.saveTask(6L,task);
                    taskService.saveTask(7L,task1);
                    break;
                case 18:
                    taskService.update(10L,task2);
                    break;
                case 19:
                    System.out.println(taskService.getTaskByLessonId(7L));
                    break;
                case 20:
                    taskService.deleteTaskById(9L);

            }
        }

    }
}
