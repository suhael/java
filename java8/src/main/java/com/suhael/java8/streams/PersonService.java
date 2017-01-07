package com.suhael.java8.streams;

import java.util.List;
import java.util.Objects;

import static java.util.stream.Collectors.toList;

public class PersonService {

//    https://docs.oracle.com/javase/8/docs/api/java/util/stream/Collectors.html
    public List<String> accumulateNamesIntoAList(List<Person> people) {
        return people.stream().map(Person::getName).collect(toList());
    }


    private class Person {
        private String name;
        private int salary;
        private String department;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getSalary() {
            return salary;
        }

        public void setSalary(int salary) {
            this.salary = salary;
        }

        public String getDepartment() {
            return department;
        }

        public void setDepartment(String department) {
            this.department = department;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Person person = (Person) o;
            return salary == person.salary &&
                    Objects.equals(name, person.name) &&
                    Objects.equals(department, person.department);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, salary, department);
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", salary=" + salary +
                    ", department='" + department + '\'' +
                    '}';
        }
    }

}
