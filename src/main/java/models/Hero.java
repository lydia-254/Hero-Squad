package models;
import java.util.ArrayList;
import java.util.Objects;
public class Hero {
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hero hero = (Hero) o;
        return age == hero.age &&
                id == hero.id &&
                Objects.equals(name, hero.name) &&
                Objects.equals(power, hero.power) &&
                Objects.equals(weakness, hero.weakness);
    }
