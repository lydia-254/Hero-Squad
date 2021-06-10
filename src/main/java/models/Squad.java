package models;
import java.util.ArrayList;
import java.util.Objects;
public class Squad {
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Squad squad = (Squad) o;
        return maxNum == squad.maxNum &&
                id == squad.id &&
                Objects.equals(squadName, squad.squadName) &&
                Objects.equals(cause, squad.cause);
    }