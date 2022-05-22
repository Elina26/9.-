import java.util.Objects;

public class Student extends Human {
    private String university;
    private String faculty;
    private String speciality;

    public Student(String surname, String name, String patronymic, int age, Gender gender, String university, String faculty, String speciality) {
        super(surname, name, patronymic, age, gender);
        this.university = university;
        this.faculty = faculty;
        this.speciality = speciality;
    }

    public Student() {
        super();
        this.university = null;
        this.faculty = null;
        this.speciality = null;
    }


    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student student)) return false;
        if (!super.equals(o)) return false;
        return Objects.equals(getUniversity(), student.getUniversity()) && Objects.equals(getFaculty(), student.getFaculty()) && Objects.equals(getSpeciality(), student.getSpeciality());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getUniversity(), getFaculty(), getSpeciality());
    }


    @Override
    public String toString() {
        return "Student{" +
                "surname='" + getSurname() + '\'' +
                ", name='" + getName() + '\'' +
                ", patronymic='" + getPatronymic() + '\'' +
                ", age=" + getAge() +
                ", gender=" + gender.getGender() +
                ", university='" + university + '\'' +
                ", faculty='" + faculty + '\'' +
                ", speciality='" + speciality + '\'' +
                '}';
    }
}
