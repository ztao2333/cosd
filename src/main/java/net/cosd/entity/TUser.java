package net.cosd.entity;

public class TUser {
    private Integer userId;
    private String userName;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        System.out.println("122222222222222222222222222");
        return "TUser{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                '}';
    }
}
