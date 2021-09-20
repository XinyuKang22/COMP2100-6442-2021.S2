package Task1_Factory;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class ArmyFactory {
    public Army createArmy(ArmyType armyType){
        ArmyType at = armyType;
        if (at == null){
            List<ArmyType> l = Arrays.asList(ArmyType.Muggle,ArmyType.Healer,ArmyType.Low_Archon,ArmyType.High_Archon);
            Random rand = new Random();
            at = l.get(rand.nextInt(l.size()));
        }
        if (at == ArmyType.Muggle){
            return new MuggleArmy();
        }else if (at == ArmyType.Healer){
            return new HealerArmy();
        }else if (at == ArmyType.Low_Archon){
            return new LowArchonArmy();
        }else if (at == ArmyType.High_Archon){
            return new HighArchonArmy();
        }
        return null;
    }
}
