package artistep.version1.v1domain.majorUser.user;

import lombok.Getter;

@Getter
public enum Status {

    ROLE_USER, ROLE_SLEEPING_USER, ROLE_RESTRICTED_USER,
    ROLE_STATUS_ADMIN
}
