package com.friendexam.domain;

import lombok.*;
import org.springframework.data.annotation.Id;

@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Friend {
    @Id
    private Long id;
    private String name;
    private String email;
}
