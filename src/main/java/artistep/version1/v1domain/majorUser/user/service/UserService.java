package artistep.version1.v1domain.majorUser.user.service;

import artistep.version1.global.exception.CustomException;
import artistep.version1.v1domain.majorUser.user.Status;
import artistep.version1.v1domain.majorUser.user.User;
import artistep.version1.v1domain.majorUser.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;

    public void createInitUserKDH(String email) {
        User user = User.builder()
                .email(email)
                .status(Status.ROLE_USER)
                .build();
        userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<User> loadedUser = userRepository.findByEmail(email);

        if (loadedUser.isEmpty()) {
            throw new UsernameNotFoundException("NOT FOUNDED");
        }

        return loadedUser.get();
    }
}
