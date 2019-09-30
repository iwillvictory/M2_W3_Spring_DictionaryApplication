package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
public class DictionaryController {
    private static Map<String,String> map= new HashMap<>();
    static{
        map.put("hello","Xin chào");
        map.put("floor","Sàn Nhà");
        map.put("clear","Sạch sẽ");
        map.put("book","Quyển sách");
    }

    @PostMapping("/dictionary")
    public ModelAndView translate(@RequestParam String search){
        ModelAndView modelAndView= new ModelAndView("/WEB-INF/views/dictionary.jsp");
        modelAndView.addObject("search",search);
        if(map.get(search)!=null){
            modelAndView.addObject("meaning",map.get(search));
        }else{
            modelAndView.addObject("meaning","not found");
        }
        return modelAndView;
    }
    @GetMapping()
    public String show(){
        return "/WEB-INF/views/index.jsp";
    }
}
