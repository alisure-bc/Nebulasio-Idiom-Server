package com.alisure.controller;

import com.alisure.entity.Result;
import com.alisure.tool.core.CoreNetwork;
import com.alisure.tool.core.CoreString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.net.URLEncoder;

@Controller
@RequestMapping("/query")
public class IdiomController {

    @Autowired
    private HttpServletRequest request;

    @ResponseBody
    @RequestMapping(value = {"/idiom"}, method = {RequestMethod.GET})
    public Result idiom(@RequestParam String idiom) {
        boolean isOk = !(idiom == null || "".equals(idiom)) && getStringByUrl(idiom);
        return new Result(isOk);
    }

    private static boolean getStringByUrl(String word){
        try {
            System.err.println(word);
            String url = "https://www.pwxcoo.com/dictionary?type=idiom&word=" + URLEncoder.encode(word, "UTF-8");
            System.err.println(url);
            CoreNetwork coreNetwork = new CoreNetwork(CoreNetwork.Utf8);
            String result = coreNetwork.getResult(url);
            System.err.println(result);
            if(result.length() > 40){
                System.err.println("ok");
                return true;
            }else {
                System.err.println("error");
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void main(String[] args) {
        getStringByUrl("兴高采烈");
        getStringByUrl("兴高烈");
        getStringByUrl("七上八下");
    }
}
