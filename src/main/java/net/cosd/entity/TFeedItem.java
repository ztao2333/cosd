package net.cosd.entity;

public class TFeedItem {
    private Long feedItemId;
    private String feedItemTitle;
    private String feedItemSubContent;
    private String feedItemContent;

    public Long getFeedItemId() {
        return feedItemId;
    }

    public void setFeedItemId(Long feedItemId) {
        this.feedItemId = feedItemId;
    }

    public String getFeedItemTitle() {
        return feedItemTitle;
    }

    public void setFeedItemTitle(String feedItemTitle) {
        this.feedItemTitle = feedItemTitle;
    }

    public String getFeedItemSubContent() {
        return feedItemSubContent;
    }

    public void setFeedItemSubContent(String feedItemSubContent) {
        this.feedItemSubContent = feedItemSubContent;
    }

    public String getFeedItemContent() {
        return feedItemContent;
    }

    public void setFeedItemContent(String feedItemContent) {
        this.feedItemContent = feedItemContent;
    }
}
