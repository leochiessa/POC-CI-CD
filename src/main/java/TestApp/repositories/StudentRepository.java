package TestApp.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import TestApp.models.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
}