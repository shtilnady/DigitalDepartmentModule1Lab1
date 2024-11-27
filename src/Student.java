import java.util.HashMap;
import java.util.Map;

public class Student {
    private String name;
    private String group;
    private int course;
    private final Map<String, Integer> marks;

    public Student(String name, String group, int course) {
        this.name = name;
        this.group = group;
        this.course = course;
        marks = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public int getMark(String subject) {
        return marks.get(subject);
    }

    public void setMark(String subject, int mark) {
        marks.put(subject, mark);
    }

    public Map<String, Integer> getMarks() {
        return marks;
    }
    public double getAverageMark() {
        if (marks.isEmpty()) {
            return 0;
        }
        int sumMark = 0;
        for (int mark: marks.values()) {
            sumMark += mark;
        }
        return (double) sumMark / marks.size();
    }
}
