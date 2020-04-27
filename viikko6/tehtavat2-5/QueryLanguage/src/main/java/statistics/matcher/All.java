package statistics.matcher;

import statistics.Player;

public class All implements Matcher{
    private Matcher matcher;
    public All(Matcher matcher) {
        this.matcher = matcher;
    }
    
    @Override
    public boolean matches(Player p) {
        return true;
    }
}
