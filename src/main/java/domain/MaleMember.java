package domain;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * packageName : domain
 * fileName : ManMembers
 * author : haedoang
 * date : 2022/01/01
 * description :
 */
public class MaleMember implements Member {
    private static MaleMember instance;

    private String name;
    private int age;

    private MaleMember() {
    }

    private MaleMember(String name) {
        this.name = name;
    }

    private MaleMember(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public static MaleMember from(String name) {
        return new MaleMember(name);
    }

    public static MaleMember of(String name, int age) {
        return new MaleMember(name, age);
    }

    public static MaleMember valueOf(String name, int age) {
        return of(name, age);
    }

    public static MaleMember getInstance() {
        if(Objects.isNull(instance)) {
            instance = new MaleMember();
        }
        return instance;
    }

    public static MaleMember newInstance() {
        instance = new MaleMember();
        return instance;
    }

    public static House getHouse() {
        return House.of(instance.name);
    }

    public static House newHouse() {
        return House.newInstance();
    }

    public static List<MaleMember> list() {
        return Arrays.asList(instance);
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}


