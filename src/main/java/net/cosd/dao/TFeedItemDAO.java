package net.cosd.dao;

import net.cosd.entity.TFeedItem;
import net.cosd.mapper.TFeedItemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TFeedItemDAO {
    @Autowired
    private TFeedItemMapper tFeedItemMapper;

    public TFeedItem findByFeedItemId(Integer feedItemId) {
        return tFeedItemMapper.findByFeedItemId(feedItemId);

    }


}
