package springframework;

public class UserService {
    private String name;

    public UserService(String username) {
        this.name = username;
    }

    public String toSting() {
        StringBuilder sb = new StringBuilder("");
        sb.append("").append(name);
        return sb.toString();
    }

    public void queryUserInfo() {
        System.out.println("查询用户信息" + name);
    }
}
