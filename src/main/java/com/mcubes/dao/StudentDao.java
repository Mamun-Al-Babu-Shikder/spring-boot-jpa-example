package com.mcubes.dao;

import com.mcubes.entity.Student;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by A.A.MAMUN on 10/25/2019.
 */
@Transactional
public interface StudentDao extends CrudRepository<Student, Integer> {

    @Modifying
    @Query(value = "SELECT * FROM  Student ORDER BY id DESC", nativeQuery = true)
    public List<Student> findAllByDescOrder();

    @Modifying
    @Query(value = "SELECT * FROM  Student WHERE department=?1", nativeQuery = true)
    public List<Student> findAllByDepartment(String department);

    @Modifying
    @Query(value = "DELETE FROM Student WHERE id=?1", nativeQuery = true)
    public void deleteStudentById(Integer id);

}
