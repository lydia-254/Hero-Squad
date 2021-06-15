//package models;
//
//import org.junit.Test;
//
//import static org.junit.Assert.*;
//
//public class HeroTest {
//    @Test
//    public void NewHeroObjectGetsCorrectlyCreated_true() throws Exception {
//        Hero hero = new Hero("Vikings", 14, "Darkness", "Nose");
//        assertEquals(true, hero instanceof Hero);
//    }
//    @Test
//    public void HeroInstantiatesWithCorrectName_true() throws Exception{
//        Hero hero = new Hero("Vikings",14,"Darkness","Nose");
//        assertEquals("Vikings",hero.getName());
//    }
//    @Test
//    public void HeroInstantiatesWithCorrectStrength_true() throws Exception{
//        Hero hero = new Hero("Vikings",18,"Darkness","Nose");
//        assertEquals("Darkness",hero.getSrength());
//    }
//    @Test
//    public void HeroInstantiatesWithCorrectAge_true() throws Exception{
//        Hero hero = new Hero("Vikings",18,"Darkness","Nose");
//        assertEquals(18,hero.getAge());
//    }
//    @Test
//    public void HeroInstantiatesWithCorrectId_true() throws Exception{
//        Hero hero = new Hero("Vikings",18,"Darkness","Nose");
//        assertEquals(0,hero.getId());
//    }
//    @Test
//    public void HeroInstantiatesWithCorrectWeakness_true() throws Exception{
//        Hero hero = new Hero("Vikings",18,"Darkness","Nose");
//        assertEquals("Nose",hero.getWeakness());
//    }
//    @Test
//    public void AllHeroInstancesAreCorrectlyReturned_true(){
//        Hero hero = new Hero("Vikings",18,"Darkness","Nose");
//        Hero heroTwo = new Hero("SpiderMan",15,"water","fire");
//        assertEquals(2,Hero.getAll().size());
//    }
//    @Test
//    public void AllHeroesContainsAllHeroes_true(){
//        Hero hero = new Hero("Vikings",18,"Darkness","Nose");
//        Hero heroTwo = new Hero("SpiderMan",15,"water","fire");
//        assertTrue(Hero.getAll().contains(hero));
//        assertTrue(Hero.getAll().contains(heroTwo));
//    }
//    public  Hero setUpNewHero(){
//         return new Hero("Vikings",18,"Darkness","Nose");
//    }
//}