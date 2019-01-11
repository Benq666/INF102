package mandatory2.src.main.java.no.uib.ii.inf102.f18.mandatory2;

import java.util.Objects;

/**
 * @author Me
 */
public class Event {
    final Date date;
    final String title;
    String description;

    public Event(Date date, String title) {
        this.date = date;
        this.title = title;
        this.description = String.format("Today is \"%s\" !!",  title);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || this.getClass() != o.getClass())
            return false;
        if (o == this)
            return true;

        Event event = (Event) o;
        return Objects.equals(this.date, event.date) &&
                Objects.equals(this.title, event.title);
    }

    @Override
    public int hashCode() {
        /*// manual hashing
        int hash = 1;
        hash = 31 * hash + date.hashCode();
        hash = 31 * hash + title.hashCode();
        hash = 31 * hash + description.hashCode();
        return hash;*/

        return Objects.hash(date, title, description);
    }
}
