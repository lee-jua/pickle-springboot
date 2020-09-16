package com.pickle.web.subjects.student;


import com.pickle.web.subjects.SubjectDetail;
import com.pickle.web.subjects.teacher.SubjectDetailVO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


interface ISSubjectService{

    List<SubjectDetail> getSubjectDetail(String subjectCode);

    List<SubjectDetail> findSubInfo(String subjectCode);

    Object findTNameTitle(String subjectCode);
}



@Service
@AllArgsConstructor
public class SSubjectServiceImpl implements ISSubjectService{
    private final SSubjectRepository sSubjectRepository;

  /*  public List<SubjectDetail> findSubDetail(int userCode){
        return sSubjectRepository.findSubDetail(userCode);
    }*/

    @Override
    public List<SubjectDetail> getSubjectDetail(String subjectCode) {
        String subject = subjectCode.substring(0,4);
        return sSubjectRepository.findSubjectDetail(subject);
    }

    @Override
    public List<SubjectDetail> findSubInfo(String subjectCode) {
        return sSubjectRepository.findGetSubInfo(subjectCode);
    }

    @Override
    public Object findTNameTitle(String subjectCode) {

        return sSubjectRepository.findGetTName(subjectCode);
    }
}
