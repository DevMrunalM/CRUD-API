package StudentMaster.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import StudentMaster.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
	

}


