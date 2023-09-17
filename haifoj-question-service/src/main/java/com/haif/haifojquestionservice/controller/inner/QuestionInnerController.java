package com.haif.haifojquestionservice.controller.inner;

import com.haif.haifojmodel.model.entity.Question;
import com.haif.haifojmodel.model.entity.QuestionSubmit;
import com.haif.haifojquestionservice.service.QuestionService;
import com.haif.haifojquestionservice.service.QuestionSubmitService;
import com.haif.haifojserviceclient.service.QuestionFeignClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 该服务仅内部调用，不是给前端的
 */
@RestController
@RequestMapping("inner")
public class QuestionInnerController implements QuestionFeignClient {

    @Resource
    private QuestionService questionService;

    @Resource
    private QuestionSubmitService questionSubmitService;


    @Override
    @GetMapping("/get/id")
    public Question getQuestionById(@RequestParam("questionId") long questionId) {
        return questionService.getById(questionId);
    }

    @Override
    @GetMapping("/question_submit/get/id")
    public QuestionSubmit getQuestionSubmitById(@RequestParam("questionSubmitId") long questionSubmitId) {
        return questionSubmitService.getById(questionSubmitId);
    }

    @Override
    @PostMapping("/question_submit/update")
    public boolean updateQuestionSubmitById(@RequestBody QuestionSubmit questionSubmitUpdate) {
        return questionSubmitService.updateById(questionSubmitUpdate);
    }
}
