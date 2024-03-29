package artistep.version1.global.jwt;

import artistep.version1.global.exception.CustomException;
import artistep.version1.global.exception.ErrorCode;
import artistep.version1.v1domain.majorUser.user.User;
import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.security.Key;
import java.util.*;

@Component
public class JwtUtilizer {

    // 어느시점에 secretKey 값이 등록되는가?
    @Value("${spring.jwt.secret-key}")
    private String secretKey;

    private static final long ACCESS_TOKEN_EXPIRE_TIME = 30 * 60 * 1000L; // 30분
    private static final long REFRESH_TOKEN_EXPIRE_TIME = 14 * 24 * 60 * 60 * 1000L; // 14일

    private Key getSigningKey() {
        byte[] keyBytes = Decoders.BASE64.decode(this.secretKey);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    //AccessToken 생성
    public String createAccessToken(User user) {
        Date now = new Date();
        Date accessTokenExpireIn = new Date(now.getTime() + ACCESS_TOKEN_EXPIRE_TIME);

        //페이로드에 남길 정보들 (Id, loginId, role, restricted)
        Claims claims = Jwts.claims();
        claims.setSubject("user");
        claims.put("id", user.getId());
        claims.put("nickname", user.getNickname());
        claims.put("picture", user.getPicture());
        claims.put("genre", user.getGenre());
        claims.put("status", user.getStatus());

        // Access Token 생성
        return Jwts.builder()
                .setHeaderParam("type","JWT")
                .setClaims(claims)
                .setExpiration(accessTokenExpireIn)
                .signWith(getSigningKey(), SignatureAlgorithm.HS512)
                .compact();
    }

    //AccessToken 생성
    @Transactional
    public String createRefreshToken(User user) {
        Date now = new Date();
        Date refreshTokenExpireIn = new Date(now.getTime() + REFRESH_TOKEN_EXPIRE_TIME);

        //페이로드에 남길 정보들 (Id, loginId, role, restricted)
        Claims claims = Jwts.claims();
        claims.setSubject("Artistep-re");

        // Access Token 생성
        String refreshToken = Jwts.builder()
                .setHeaderParam("type","JWT")
                .setClaims(claims)
                .setExpiration(refreshTokenExpireIn)
                .signWith(getSigningKey(), SignatureAlgorithm.HS512)
                .compact();

        return refreshToken;
    }

//    public Authentication getAuthentication(String token) {
//        // 토큰 복호화
//        Status claims = (Status) Jwts.parserBuilder()
//                .setSigningKey(getSigningKey())
//                .build()
//                .parseClaimsJws(token).getBody().get("status");
//
//        // 클레임에서 권한 정보 가져오기
//        Collection<? extends GrantedAuthority> authorities =
//                Arrays.stream(claims.getTitle())
//                        .map(SimpleGrantedAuthority::new)
//                        .collect(Collectors.toList());
//
//        // UserDetails 객체를 만들어서 Authentication 리턴
//        UserDetails principal = new User(claims.getSubject(), "", authorities);
//
//        return new UsernamePasswordAuthenticationToken(principal, "", authorities);
//    }

    // Jwt 토큰 유효성 검사
    public void validateToken(String token) {
        try {
            Jwts.parserBuilder()
                    .setSigningKey(getSigningKey())
                    .build();
        }
        // 400 Error - MalFormed
        catch (MalformedJwtException ex) {
            throw new CustomException(ErrorCode.JWT_MALFORMED_EXCEPTION);
        }
        // 401 Error - Expired
        catch (ExpiredJwtException ex) {
            throw new CustomException(ErrorCode.JWT_EXPIRED_EXCEPTION);
        }
        // 400 Error - UnSupported
        catch (UnsupportedJwtException ex) {
            throw new CustomException(ErrorCode.JWT_UNSUPPORTED_EXCEPTION);
        }
        // 400 Error - Illegal
        catch (IllegalArgumentException ex) {
            throw new CustomException(ErrorCode.JWT_IllegalARGUMENT_EXCEPTION);
        }
    }

    // AccessToken 에서 Claims 꺼내기
    public Claims jwtResolve(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(getSigningKey())
                .build()
                .parseClaimsJws(token).getBody();
    }

    // AccessToken 에서 userId 꺼내기
    public Long jwtResolveToUserId(String token) {
        Object claims = Jwts.parserBuilder()
                .setSigningKey(getSigningKey())
                .build()
                .parseClaimsJws(token).getBody().get("id");

        return Long.valueOf(String.valueOf(claims));
    }

    // AccessToken 에서 Nickname 꺼내기
    public String jwtResolveToUserNickname(String token) {
        Object claims = Jwts.parserBuilder()
                .setSigningKey(getSigningKey())
                .build()
                .parseClaimsJws(token).getBody().get("nickname");
        return String.valueOf(claims);
    }

    // AccessToken 에서 Picture 꺼내기
    public String jwtResolveToUserPicture(String token) {
        Object claims = Jwts.parserBuilder()
                .setSigningKey(getSigningKey())
                .build()
                .parseClaimsJws(token).getBody().get("picture");
        return String.valueOf(claims);
    }

    // AccessToken 에서 Genre 꺼내기
    public String jwtResolveToUserGenre(String token) {
        Object claims = Jwts.parserBuilder()
                .setSigningKey(getSigningKey())
                .build()
                .parseClaimsJws(token).getBody().get("genre");
        return String.valueOf(claims);
    }

    // AccessToken 에서 Status 꺼내기
    public String jwtResolveToUserStatus(String token) {
        Object claims = Jwts.parserBuilder()
                .setSigningKey(getSigningKey())
                .build()
                .parseClaimsJws(token).getBody().get("status");
        return String.valueOf(claims);
    }
}
