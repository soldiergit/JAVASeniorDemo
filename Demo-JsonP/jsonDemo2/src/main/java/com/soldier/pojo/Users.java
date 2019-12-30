package com.soldier.pojo;

/**
 * @ProjectName:JAVA-Senior-Demo
 * @author:soldier
 * @Email:583403411@qq.com
 * @create:19-12-30下午5:32
 * @Describe:模拟数据库,用户实体
 **/
public class Users {

    private int userid;
    private String username;
    private int userage;

    public Users() {
        super();
    }

    public Users(int userid, String username, int userage) {
        this.userid = userid;
        this.username = username;
        this.userage = userage;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getUserage() {
        return userage;
    }

    public void setUserage(int userage) {
        this.userage = userage;
    }

    @Override
    public String toString() {
        return "Users{" +
                "userid=" + userid +
                ", username='" + username + '\'' +
                ", userage=" + userage +
                '}';
    }
}
