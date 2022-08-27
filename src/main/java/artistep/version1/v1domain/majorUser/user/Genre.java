package artistep.version1.v1domain.majorUser.user;

import lombok.Getter;

@Getter
public enum Genre {

    리스너힙합, 리스너RB,리스너프로듀싱, 리스너작곡,
    뮤지션힙합, 뮤지션RB, 뮤지션프로듀싱, 뮤지션작곡;

    public String hiphop(String type) {
        return type + "-힙합";
    }
    public String Rhythm(String type) {
        return type + "-R&B";
    }
    public String Producing(String type) {
        return type + "-프로듀싱";
    }
    public String Composition(String type) {
        return type + "-작곡";
    }
}
