package artistep.version1.v1domain.majorUser.user;


import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Genre {

    ListenerHipHop("타입", "리스너-힙합"),
    ListenerRhythmAndBlues("타입", "리스너-R&B"),
    ListenerProducing("타입", "리스너-프로듀싱"),
    ListenerComposition("타입", "리스너-작곡"),

    MusicianHipHop("타입", "뮤지션-힙합"),
    MusicianRhythmAndBlues("타입", "뮤지션-R&B"),
    MusicianProducing("타입", "뮤지션-프로듀싱"),
    MusicianComposition("타입", "뮤지션-작곡");

    private final String type;
    private final String genre;

    @JsonCreator
    public static Genre from(String s) {
        return Genre.valueOf(s.toString());
    }

    public static String convertFromGenreToString(String s) {
        return s.toString();
    }
}
