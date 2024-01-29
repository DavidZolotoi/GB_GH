package gb.study;

import javax.persistence.*;
import java.util.Random;

@Entity
@Table(name = "school")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private int duration;   //количество месяцев

    private static final String[] TITLES = new String[] { "Математика", "Физика", "Русский", "Литература", "Биология", "Химия", "История", "География", "Английский", "Физкультура", "Труд" };
    private static final Random RANDOM = new Random();

    public Course(String title, int age) {
        this.title = title;
        this.duration = age;
    }

    public Course(int id, String title, int age) {
        this.id = id;
        this.title = title;
        this.duration = age;
    }

    public Course() {}

    public static Course create(){
        return new Course(TITLES[RANDOM.nextInt(TITLES.length)], RANDOM.nextInt(10, 16));
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void updateDuration(){
        duration = RANDOM.nextInt(12, 36);
    }

    public void updateTitle(){
        title = TITLES[RANDOM.nextInt(TITLES.length)];
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", duration=" + duration +
                '}';
    }
}
