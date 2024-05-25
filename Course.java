import java.util.ArrayList;
import java.util.List;

class Course {
    private String code;
    private String title;
    private String description;
    private int capacity;
    private String schedule;

    public Course(String code, String title, String description, int capacity, String schedule) {
        this.code = code;
        this.title = title;
        this.description = description;
        this.capacity = capacity;
        this.schedule = schedule;
    }

    // Getters and setters

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }
}

class CourseDatabase {
    private List<Course> courses;

    public CourseDatabase() {
        courses = new ArrayList<>();
    }

    public void addCourse(Course course) {
        courses.add(course);
    }

    public void removeCourse(Course course) {
        courses.remove(course);
    }

    public List<Course> getAllCourses() {
        return courses;
    }
}


class Student {
    private int id;
    private String name;
    private List<Course> registeredCourses;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
        registeredCourses = new ArrayList<>();
    }

    // Getters and setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Course> getRegisteredCourses() {
        return registeredCourses;
    }

    public void registerCourse(Course course) {
        registeredCourses.add(course);
    }

    public void dropCourse(Course course) {
        registeredCourses.remove(course);
    }
}

class StudentDatabase {
    private List<Student> students;

    public StudentDatabase() {
        students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void removeStudent(Student student) {
        students.remove(student);
    }

    public List<Student> getAllStudents() {
        return students;
    }
}

class CourseListing {
    private CourseDatabase courseDatabase;

    public CourseListing(CourseDatabase courseDatabase) {
        this.courseDatabase = courseDatabase;
    }

    public void displayAvailableCourses() {
        List<Course> courses = courseDatabase.getAllCourses();
        for (Course course : courses) {
            System.out.println("Course Code: " + course.getCode());
            System.out.println("Title: " + course.getTitle());
            System.out.println("Description: " + course.getDescription());
            System.out.println("Capacity: " + course.getCapacity());
            System.out.println("Schedule: " + course.getSchedule());
            System.out.println("Available Slots: " + (course.getCapacity() - getRegisteredStudentsCount(course)));
            System.out.println("------------------------");
        }
    }

    private int getRegisteredStudentsCount(Course course) {
        int count = 0;
        List<Student> students = course.getRegisteredStudents();
        for (Student student : students) {
            if (student.getRegisteredCourses().contains(course)) {
                count++;
            }
        }
        return count;
    }
}

class StudentRegistration {
    private CourseDatabase courseDatabase;
    private StudentDatabase studentDatabase;

    public StudentRegistration(CourseDatabase courseDatabase, StudentDatabase studentDatabase) {
        this.courseDatabase = courseDatabase;
        this.studentDatabase = studentDatabase;
    }

    public void registerStudentForCourse(Student student, Course course) {
        if (course.getCapacity() - getRegisteredStudentsCount(course) > 0) {
            student.registerCourse(course);
        } else {
            System.out.println("Course is full. Cannot register student.");
        }
    }

    private int getRegisteredStudentsCount(Course course) {
        int count = 0;
        List<Student> students = course.StudentRegistration();
        for (Student student : students) {
            if (student.registerStudentForCourse().contains(course)) {
                count++;
            }
        }
        return count;
    }
}

class CourseRemoval {
    private CourseDatabase courseDatabase;
    private StudentDatabase studentDatabase;

    public CourseRemoval(CourseDatabase courseDatabase, StudentDatabase studentDatabase) {
        this.courseDatabase = courseDatabase;
        this.studentDatabase = studentDatabase;
    }

    public void removeCourse(Course course) {
        List<Student> students = course.getRegisteredStudents();
        for (Student student : students) {
            student.dropCourse(course);
        }
        courseDatabase.removeCourse(course);
    }
}
