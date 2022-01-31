package mk.ukim.finki.wpaud.service.impl;

import mk.ukim.finki.wpaud.model.User;
import mk.ukim.finki.wpaud.model.enumeration.Role;
import mk.ukim.finki.wpaud.model.exceptions.InvalidArgumentsException;
import mk.ukim.finki.wpaud.model.exceptions.PasswordsNoNotMatchException;
import mk.ukim.finki.wpaud.model.exceptions.UsernameExistsException;
import mk.ukim.finki.wpaud.repository.jpa.UserRepository;
import mk.ukim.finki.wpaud.service.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User register(String username, String password, String repeatPassword, String name, String surname, Role role) {
        if(username==null || username.isEmpty() || password==null || password.isEmpty()) {
            throw new InvalidArgumentsException();
        }
        if(!password.equals(repeatPassword)) {
            throw new PasswordsNoNotMatchException();
        }
        if(this.userRepository.findUserByUsername(username).isPresent()) {
            throw new UsernameExistsException(username);
        }

        User user = new User(username, passwordEncoder.encode(password), name, surname, role);
        return userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return userRepository.findUserByUsername(s)
                .orElseThrow(() -> new UsernameNotFoundException(s));
    }
}
