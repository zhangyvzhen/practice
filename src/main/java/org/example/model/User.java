package org.example.model;

import lombok.*;
import lombok.experimental.SuperBuilder;
import org.example.comm.Const;

@Getter
@Setter
@ToString
@SuperBuilder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private String name;
    private Integer age;
    private Const.gender gender;
}

