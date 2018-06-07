package net.cosd.mapper;

import net.cosd.entity.TFeedItem;
import org.springframework.stereotype.Component;

@Component
public interface TFeedItemMapper {
    TFeedItem findByFeedItemId(Integer feedItemId);

}
