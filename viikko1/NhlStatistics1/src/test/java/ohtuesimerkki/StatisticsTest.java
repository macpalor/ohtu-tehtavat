package ohtuesimerkki;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.List;
import java.util.ArrayList;


public class StatisticsTest {
 
    Reader readerStub = new Reader() {
 
        public List<Player> getPlayers() {
            ArrayList<Player> players = new ArrayList<>();
 
            players.add(new Player("Semenko", "EDM", 4, 12));
            players.add(new Player("Lemieux", "PIT", 45, 54));
            players.add(new Player("Kurri",   "EDM", 37, 53));
            players.add(new Player("Yzerman", "DET", 42, 56));
            players.add(new Player("Gretzky", "EDM", 35, 89));
 
            return players;
        }
    };
 
    Statistics stats;

    @Before
    public void setUp(){
        // luodaan Statistics-olio joka käyttää "stubia"
        stats = new Statistics(readerStub);
    }  
    
    @Test
    public void konstruktori() {
        
    }
    
    @Test
    public void hakuToimiiOikein() {
        Player pelaaja = stats.search("Kurri");
        assertEquals("Kurri", pelaaja.getName());
        assertEquals("EDM", pelaaja.getTeam());
        assertEquals(37, pelaaja.getGoals());
        assertEquals(53, pelaaja.getAssists());
        assertEquals(90, pelaaja.getPoints());
    }
    
    @Test
    public void vaaraHakuPalauttaaTyhjan() {
        Player pelaaja = stats.search("Jagr");
        assertEquals(null, pelaaja);
    }
    
    @Test
    public void joukkueenPelaajatHaetaanOikein() {
        List<Player> pelaajat = stats.team("DET");
        assertEquals("Yzerman", pelaajat.get(0).getName());
        assertEquals("DET", pelaajat.get(0).getTeam());
        assertEquals(42, pelaajat.get(0).getGoals());
        assertEquals(56, pelaajat.get(0).getAssists());
        assertEquals(98, pelaajat.get(0).getPoints());
        
    }
    
    @Test
    public void tehokkainPelaajaHaetaanOikein() {
        List<Player> pelaaja = stats.topScorers(1);
        assertEquals("Gretzky", pelaaja.get(0).getName());
        assertEquals("EDM", pelaaja.get(0).getTeam());
        assertEquals(35, pelaaja.get(0).getGoals());
        assertEquals(89, pelaaja.get(0).getAssists());
        assertEquals(124, pelaaja.get(0).getPoints());
    }
    
}
