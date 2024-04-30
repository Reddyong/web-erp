package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Member {
    private Long id;
    private String username;    // 회원 아이디
    private String password;    // 회원 비밀번호
    private String name;    // 회원명
    private String email;
}
