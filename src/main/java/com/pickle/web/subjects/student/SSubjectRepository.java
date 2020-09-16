package com.pickle.web.subjects.student;

import com.pickle.web.subjects.Subject;
import com.pickle.web.subjects.SubjectDetail;
import com.pickle.web.subjects.teacher.SubjectDetailVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SSubjectRepository extends JpaRepository<SubjectDetail, Long>, ISSubjectRepository{
    @Query(value="select * from subject_detail d left outer join subject s on d.subject_id like s.subject_id where s.subject_code like :subjectCode", nativeQuery = true)
    List<SubjectDetail> findSubjectDetail(@Param("subjectCode") String subject);

    @Query(value="select lesson_detail from subject_detail d left outer join subject s\n" +
            "       on d.subject_id like s.subject_id where s.subject_code like :subjectCode", nativeQuery = true)
    List<SubjectDetail> findGetSubInfo(@Param("subjectCode") String subject);


    @Query(value="select",nativeQuery = true)
    Object findGetTName(String subjectCode);




  /*  @Query(value="select * from subject_detail  ", nativeQuery=true)
    List<SubjectDetail> findSubDetail(int userCode);*/
}
