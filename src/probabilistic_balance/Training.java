package probabilistic_balance;

import java.util.ArrayList;

public class Training {
	
	int AmountOfSubgroups = 100;
    ArrayList<Subgroup> SubgroupsForTraining;
    ArrayList<Subgroup> SubgroupsWithSucceed;

    public Training() {
        SubgroupsForTraining = new ArrayList<>();
        setSubgroupsForTraining();
        SubgroupsWithSucceed = new ArrayList<>();
    }


    public ArrayList<Subgroup> getSubgroupsWithSucceed() {
        return SubgroupsWithSucceed;
    }

    public ArrayList<Subgroup> getSubgroupsForTraining() {
        return SubgroupsForTraining;
    }

    public void setSubgroupsForTraining() {
        for (int subgroupIndex=0; subgroupIndex < AmountOfSubgroups; subgroupIndex++){
            Subgroup subgroup = new Subgroup();
            this.SubgroupsForTraining.add(subgroup);
        }
    }
}
