package br.com.ufrn.imd.securityexample.service;

import br.com.ufrn.imd.securityexample.PasswordEncoderUtil;
import br.com.ufrn.imd.securityexample.domain.Users;
import br.com.ufrn.imd.securityexample.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;


    public void save(Users user) {
        if (userRepository.findByUsername(user.getUsername()).isPresent()) {
            throw new RuntimeException("The username " + user.getUsername() + " is already taken.");
        }

        user.setPassword(PasswordEncoderUtil.encode(user.getPassword()));
        user.setActive(true);
        userRepository.save(user);
    }

    public Optional<Users> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
