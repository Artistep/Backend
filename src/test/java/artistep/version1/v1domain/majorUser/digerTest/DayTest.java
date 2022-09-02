package artistep.version1.v1domain.majorUser.digerTest;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@SpringBootTest
public class DayTest {


    @Test
    public void dayPrint() {
        LocalDate date = LocalDate.of(2021, 12, 25);

        System.out.println(date.getDayOfWeek());
    }

    @Test
    public void iteratorTest() {
        List<String> list = new ArrayList<>();

        list.add("diger");
        list.add("song");
        list.add("john");

        Iterator<String> iter = list.iterator();

        while(iter.hasNext()) {
            String s = iter.next();
            s = "변경테스트";
            System.out.println(s);
        }
    }
}
