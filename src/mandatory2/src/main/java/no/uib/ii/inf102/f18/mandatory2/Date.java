package mandatory2.src.main.java.no.uib.ii.inf102.f18.mandatory2;

import java.util.Objects;

/**
 * @author Me
 */
public final class Date {
    final Month month;
    final int year, day;

    public Date(Month month, int year, int day) {
        this.month = month;
        this.year = year;
        this.day = day;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || this.getClass() != o.getClass())
            return false;
        if (o == this)
            return true;

        Date date = (Date) o;
        return Objects.equals(this.year, date.year) &&
                Objects.equals(this.month, date.month) &&
                Objects.equals(this.day, date.day);
    }

    @Override
    public int hashCode() {
        /*// manual hashing
        int hash = 1;
        hash = 31 * hash + year;
        hash = 31 * hash + month.hashCode();
        hash = 31 * hash + day;
        return hash;*/

        return Objects.hash(year, month, day);
    }
}
