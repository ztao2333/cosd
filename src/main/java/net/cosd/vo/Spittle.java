package net.cosd.vo;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.util.Date;

public class Spittle {
    private final Long id;
    private final String message;
    private final Date time;
    private Double latitude;
    private Double longitube;

    public Spittle(String message, Date time) {
        this(message, time,null, null);
    }
    public Spittle(
            String message, Date time, Double longitube, Double latitude) {
        this.id = null;
        this.message = message;
        this.time = time;
        this.longitube = longitube;
        this.latitude = latitude;
    }

    public Long getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }

    public Date getTime() {
        return time;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitube() {
        return longitube;
    }

    public void setLongitube(Double longitube) {
        this.longitube = longitube;
    }

    // http://blog.csdn.net/mlin_123/article/details/51353829
    // HashCodeBuilder和EqualsBuilder的作用  Apache Common Lang包
    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this, "id", "time");
    }

    @Override
    public boolean equals(Object that) {
        return EqualsBuilder.reflectionEquals(this, that, "id", "time");
    }
}
