import java.util.Objects;

public class Human {
    private String surname;
    private String name;
    private String patronymic;
    private int age;
    enum Gender { MALE("Мужской"), FEMALE("Женский");
        private final String gender;
        Gender(String gender) {
            this.gender = gender;
        }
        public String getGender() {
            return gender;
        }
    }
    Gender gender;

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Human(String surname, String name, String patronymic, int age, Gender gender) {
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.age = age;
        this.gender = gender;
    }

    public Human() {
        this.surname = null;
        this.name = null;
        this.patronymic = null;
        this.age = 0;
        this.gender = null;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Human human)) return false;
        return getAge() == human.getAge() && Objects.equals(getSurname(), human.getSurname()) && Objects.equals(getName(), human.getName()) && Objects.equals(getPatronymic(), human.getPatronymic()) && gender == human.gender;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSurname(), getName(), getPatronymic(), getAge(), gender);
    }

    @Override
    public String toString() {
        return "Human{" +
                "surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", age=" + age +
                ", gender=" + gender.getGender() +
                '}';
    }
}
