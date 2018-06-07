package net.cosd.ctrl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

@Controller
@RequestMapping("/detail")
public class DetailController {
    public DetailController() {

    }
    @RequestMapping(value = "/{feedItemId}", method = RequestMethod.GET)
    @ResponseBody
    public Object getDetail(@PathVariable("feedItemId") Long feedItemId) {
        HashMap<String,String> detailMap = new HashMap<>();
        detailMap.put("name", "Aike");
        detailMap.put("sex", "男");
        detailMap.put("age", "25");
        detailMap.put("feedItemId", feedItemId.toString());
        return detailMap;
    }

}
