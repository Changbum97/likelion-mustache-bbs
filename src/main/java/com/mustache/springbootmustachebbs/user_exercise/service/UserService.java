package com.mustache.springbootmustachebbs.user_exercise.service;

import com.mustache.springbootmustachebbs.user_exercise.domain.dto.UserAddRequest;
import com.mustache.springbootmustachebbs.user_exercise.domain.dto.UserResponse;
import com.mustache.springbootmustachebbs.user_exercise.domain.entity.User;
import com.mustache.springbootmustachebbs.user_exercise.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserResponse findSingleUser(Long id) {
        Optional<User> optUser = userRepository.findById(id);
        if(optUser.isEmpty()) {
            return UserResponse.builder()
                    .message("해당 id의 user가 없습니다")
                    .build();
        }

        User findUser = optUser.get();

        // User -> UserFindResponse로 변환해서 return
        return UserResponse.builder()
                .id(findUser.getId())
                .username(findUser.getUsername())
                .message(id + "번 회원 조회 성공")
                .build();
    }

    public UserResponse addUser(UserAddRequest request) {

        // Username이 중복되면 가입 못하게 처리
        if(userRepository.findByUsername(request.getUsername()).isPresent()) {
            return UserResponse.builder()
                    .message("해당 username은 중복입니다.")
                    .build();
        }

        User newUser = User.builder()
                .username(request.getUsername())
                .password(request.getPassword())
                .build();

        User savedUser = userRepository.save(newUser);

        return UserResponse.builder()
                .id(savedUser.getId())
                .username(savedUser.getUsername())
                .message("가입이 완료 되었습니다.")
                .build();
    }
}
