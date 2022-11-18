package pojo;

import lombok.Data;

@Data
public class User {
    private String name;
    private Double score;

    public User(String name, Double score) {
        this.name = name;
        this.score = score;
    }

    @Override
    public String toString() {
        return "UserPo{" +
                "name='" + name + '\'' +
                ", score=" + score +
                '}';
    }
}