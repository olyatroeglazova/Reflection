public class Student extends Human {
        private String faculty;

        public Student(Human human, String faculty) {
            super(human);
            this.faculty = faculty;
        }
        //
        public Student(String surname, String name, String patronymic, int age, String faculty) {
            super(surname, name, patronymic, age);
            this.faculty = faculty;
        }

        public String getFaculty() {
            return faculty;
        }

        public void setFaculty(String faculty) {
            this.faculty = faculty;
        }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Student student = (Student) o;

        return faculty != null ? faculty.equals(student.faculty) : student.faculty == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (faculty != null ? faculty.hashCode() : 0);
        return result;
    }
}
