package net.cosd.ctrl;

import net.cosd.dao.TFeedItemDAO;
import net.cosd.entity.TFeedItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;


// 声明一个控制器
@Controller
@RequestMapping("/")
public class FeedController {
    public FeedController() {
    }
    @Autowired
    private TFeedItemDAO tFeedItemDAO;
    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public Object feed() {
        TFeedItem tFeedItem = tFeedItemDAO.findByFeedItemId(1);
        List<TFeedItem> tFeedItems = new ArrayList<>();
        tFeedItems.add(tFeedItem);
        System.out.println(tFeedItem.getFeedItemSubContent());
        return tFeedItems;
    }

}
