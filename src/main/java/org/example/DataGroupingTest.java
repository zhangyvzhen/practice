package org.example;

import org.example.comm.Const;
import org.example.model.User;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/** 数据分组 */
public class DataGroupingTest {

  @Test
  public void dataGrouping() {
    List<User> userList =
        Arrays.asList(
            User.builder().name("张三").age(18).gender(Const.gender.MAN).build(),
            User.builder().name("李四").age(19).gender(Const.gender.WOMAN).build(),
            User.builder().name("王五").age(28).gender(Const.gender.MAN).build(),
            User.builder().name("赵六").age(38).gender(Const.gender.WOMAN).build(),
            User.builder().name("田七").age(17).gender(Const.gender.MAN).build(),
            User.builder().name("孙八").age(20).gender(Const.gender.MAN).build(),
            User.builder().name("周九").age(19).gender(Const.gender.WOMAN).build(),
            User.builder().name("吴十").age(9).gender(Const.gender.MAN).build());
    // 按性别分组
    Map<Const.gender, List<User>> groupByGender = userList.stream().collect(Collectors.groupingBy(User::getGender));

    // 按年龄段分组 10-19，20-29，30-39
    Map<String, List<User>> groupByAge = userList.stream().collect(Collectors.groupingBy(user -> {
      Integer age = user.getAge();
      if (10 <= age && age <= 19) {
        return "10-19";
      } else if (20 <= age && age <= 29) {
        return "20-29";
      } else if (30 <= age && age <= 39) {
        return "30-39";
      } else {
        return "其它";
      }
    }));

    // 统计每种性别的人数
    Map<Const.gender, Long> groupByGenderAndCount = userList.stream().collect(Collectors.groupingBy(User::getGender,Collectors.counting()));

    System.out.println(groupByGender);
    System.out.println(groupByAge);
    System.out.println(groupByGenderAndCount);

  }
}
