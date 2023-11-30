package com.green.growgreen.user;

import com.green.growgreen.ResVo;
import com.green.growgreen.user.model.UserInsDto;
import lombok.RequiredArgsConstructor;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserMapper mapper;

    public ResVo signup(UserInsDto dto) {
        String hashedPw = BCrypt.hashpw(dto.getUpw(), BCrypt.gensalt());

        dto.setUpw(hashedPw);

        int affectedRow = mapper.insUser(dto);
        return new ResVo(dto.getIuser());
    }
}
