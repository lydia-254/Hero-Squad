package models;

import org.junit.Test;

import static org.junit.Assert.*;

public class SquadTest {
    @Test
    public void NewSquadObjectGetsCorrectlyCreated_true() throws Exception {
        Squad squad = new Squad("Hero-Squad", 12, "fighting all crimes in the city");
        assertEquals(true,squad instanceof Squad);
    }
    @Test
    public void SquadInstantiatesWithCorrectName_true() throws Exception{
        Squad squad = new Squad("Hero-Squad", 12, "fighting all crimes in the city");
        assertEquals("Hero-Squad",squad.getSquadName());
    }
    @Test
    public void SquadInstantiatesWithCorrectStrength_true() throws Exception{
        Squad squad = new Squad("Hero-Squad", 12, "fighting all crimes in the city");
        assertEquals("Hero-Squad",squad.getSquadName());
    }
    @Test
    public void SquadInstantiatesWithCorrectAge_true() throws Exception{
        Squad squad = new Squad("Hero-Squad", 12, "fighting all crimes in the city");
        assertEquals("Hero-Squad",squad.getSquadName());
    }
    @Test
    public void HeroInstantiatesWithCorrectId_true() throws Exception{
        Squad squad = new Squad("Hero-Squad", 12, "fighting all crimes in the city");
        assertEquals("Hero-Squad",squad.getSquadName());
    }
    @Test
    public void HeroInstantiatesWithCorrectWeakness_true() throws Exception{
        Squad squad = new Squad("Hero-Squad", 12, "fighting all crimes in the city");
        assertEquals("Hero-Squad",squad.getSquadName());
    }
    @Test
    public void AllHeroInstancesAreCorrectlyReturned_true(){
        Squad squad = new Squad("Hero-Squad", 12, "fighting all crimes in the city");
        Squad squadTwo = new Squad("Hero-Squad", 12, "fighting all crimes in the city");
        assertEquals(2,Squad.getAll().size());
    }
    @Test
    public void AllHeroesContainsAllHeroes_true(){
        Squad squad = new Squad("Hero-Squad", 12, "fighting all crimes in the city");
        Squad squadTwo = new Squad("Hero-Squad", 12, "fighting all crimes in the city");
        assertTrue(Squad.getAll().contains(squad));
        assertTrue(Squad.getAll().contains(squadTwo));
    }
    public  Squad setUpNewSquad(){
        return new Squad("Hero-Squad",12,"fighting all crimes in the city");
    }
}