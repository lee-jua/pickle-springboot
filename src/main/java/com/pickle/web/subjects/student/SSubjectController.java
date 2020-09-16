package com.pickle.web.subjects.student;

import com.pickle.web.commons.Box;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/ssubject")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class SSubjectController {
    private final ISSubjectRepository isSubjectRepository;
    private final ISSubjectService isSubjectService;
    private final Box box;

    public SSubjectController(@Qualifier("SSubjectRepository") ISSubjectRepository isSubjectRepository, ISSubjectService isSubjectService, Box box) {
        this.isSubjectRepository = isSubjectRepository;
        this.isSubjectService = isSubjectService;
        this.box = box;
    }

 /*   @GetMapping("/detail/{userCode}")
    public Map<String, List<SubjectDetail>> getSSubDetail(@PathVariable int userCode){
        Map<String,List<SubjectDetail>> map = new HashMap<>();
        map.put("subDetail",isSubjectService.getDetailList(userCode));
        return null;
    }*/
    @GetMapping("/detailList/{subjectCode}")
    public HashMap<String, ?> getDetail(@PathVariable String subjectCode){
        box.clear();
        box.put("subjectDetail", isSubjectService.getSubjectDetail(subjectCode));
        box.put("tNameTitle", isSubjectService.findTNameTitle(subjectCode));
        return box.get();
    }

    @GetMapping("/detailList/{subjectCode}/info")
    public HashMap<String, ?> getDetailInfo(@PathVariable String subjectCode){
        box.clear();
        box.put("subInfo", isSubjectService.findSubInfo(subjectCode));
        return box.get();
    }


}