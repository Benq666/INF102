package mandatory2.src.test.java.no.uib.ii.inf102.f18.mandatory2;

import mandatory2.src.main.java.no.uib.ii.inf102.f18.mandatory2.Calendar;
import mandatory2.src.main.java.no.uib.ii.inf102.f18.mandatory2.Date;
import mandatory2.src.main.java.no.uib.ii.inf102.f18.mandatory2.Event;
import mandatory2.src.main.java.no.uib.ii.inf102.f18.mandatory2.Month;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author Torstein Strømme
 */
public class CalendarTest {

    private Calendar calendar;

    @BeforeEach
    void setup() {
        this.calendar = new Calendar();
    }

    @Test
    void sanityTest() {
        Event bgOpen = new Event(new Date(Month.NOV, 2018, 10), "Bergen Open");
        Event exam = new Event(new Date(Month.NOV, 2018, 20), "INF102 Final Exam");
        Event freedom = new Event(new Date(Month.NOV, 2018, 20), "Freedom!");
        // Adding the INF102 exam again, just to be 100% sure not to forget it
        Event exam2 = new Event(new Date(Month.NOV, 2018, 20), "INF102 Final Exam");

        calendar.addEvent(bgOpen);
        calendar.addEvent(exam);
        calendar.addEvent(freedom);
        calendar.addEvent(exam2);

        assertEquals(1, calendar.eventsOnDate(new Date(Month.NOV, 2018, 10)).size());
        assertTrue(calendar.eventsOnDate(new Date(Month.NOV, 2018, 10)).contains(bgOpen));

        assertEquals(2, calendar.eventsOnDate(new Date(Month.NOV, 2018, 20)).size());
        assertTrue(calendar.eventsOnDate(new Date(Month.NOV, 2018, 20)).contains(exam));
        assertTrue(calendar.eventsOnDate(new Date(Month.NOV, 2018, 20)).contains(exam2));
        assertTrue(calendar.eventsOnDate(new Date(Month.NOV, 2018, 20)).contains(freedom));
    }
}
