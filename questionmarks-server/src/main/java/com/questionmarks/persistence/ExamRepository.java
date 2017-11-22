package com.questionmarks.persistence;

import com.questionmarks.model.Exam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public interface ExamRepository extends JpaRepository<Exam, Long> {//interface, define, no implementation

    List<Exam> findAll();
    Exam findById(Long id);

}
