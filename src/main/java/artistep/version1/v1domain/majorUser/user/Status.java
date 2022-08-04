package artistep.version1.v1domain.majorUser.user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Status {

    USER("ROLE_STATUS_USER", "일반 사용자"),
    ADMIN("ROLE_STATUS_ADMIN", "관리자"),
    RESTRICTED("ROLE_STATUS_RESTRICTED", "이용 제한된 사용자"),
    SLEEPING("ROLE_STATUS_ADMIN", "휴면 계정 사용자");

    private final String key;
    private final String title;
}
