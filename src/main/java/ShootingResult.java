import java.util.*;
public enum ShootingResult {
    HIT('X'),
    MISS('O');
    private final char symbol;
    ShootingResult(char symbol){
        this.symbol = symbol;
    }
    public char getSymbol(){
        return symbol;
    }
}
