package com.phil.headline.controller;

import com.phil.headline.common.Result;
import com.phil.headline.pojo.NewsType;
import com.phil.headline.pojo.vo.HeadlineDetailVo;
import com.phil.headline.pojo.vo.HeadlineQueryVo;
import com.phil.headline.service.NewsHeadlineService;
import com.phil.headline.service.NewsTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Admin
 * @version 1.0
 * @description TODO
 * @create 2023/11/23 17:20
 */
@CrossOrigin(origins="*",allowedHeaders="*")
@RestController
@RequestMapping("portal")
public class PortalController{

    @Autowired
    private NewsTypeService newsTypeService;

    @Autowired
    private NewsHeadlineService newsHeadlineService;

    @GetMapping("findAllTypes")
    public Result findAllTypes(){
        List<NewsType> newsTypeList = newsTypeService.findAllTypes();
        return Result.ok(newsTypeList);
    }

    @PostMapping("findNewsPage")
    public Result findNewsPage(@RequestBody HeadlineQueryVo headlineQueryVo){
        // 查询分页五项数据
        Map<String, Object> pageInfo = newsHeadlineService.findNewsPage(headlineQueryVo);
        // 将分页五项数据放入pageInfoMap
        Map<String, Object> pageInfoMap = new HashMap<>();
        pageInfoMap.put("pageInfo", pageInfo);
        return Result.ok(pageInfoMap);
    }


    @PostMapping("showHeadlineDetail")
    public Result showHeadlineDetail(@RequestParam Integer hid) {
        System.out.println("hid = " + hid);
        HeadlineDetailVo headlineDetailVo = newsHeadlineService.showHeadlineDetail(hid);
        Map<String, HeadlineDetailVo>  headlineMap = new HashMap<>();
        headlineMap.put("headline", headlineDetailVo);
        return Result.ok(headlineMap);
    }
}
