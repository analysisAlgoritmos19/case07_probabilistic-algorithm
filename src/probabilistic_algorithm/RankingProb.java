package probabilistic_algorithm;

import java.util.ArrayList;
import java.util.HashMap;

import probabilistic_balance.Subgroup;
import probabilistic_balance.Training;
import utils.Union;

public class RankingProb {
	
	private ArrayList<Integer> AllNumbers;
    private ArrayList<Character> AllLetters;
    private HashMap<Integer,Float> NumberProbability;
    private HashMap<Character,Float> LetterProbability;
    private Training SampleTraining;
    
    public RankingProb() {
        SampleTraining = new Training();
        AllNumbers = new ArrayList<>();
        AllLetters = new ArrayList<>();
        NumberProbability = new HashMap<>();
        LetterProbability = new HashMap<>();
        createRankingProb();
    }
    
    public HashMap<Character, Float> getLetterFrequency() {
        return LetterProbability;
    }

    public HashMap<Integer, Float> getNumberFrequency() {
        return NumberProbability;
    }

    public void createRankingProb(){

        float totalGroupsWithSucceed = SampleTraining.getSubgroupsWithSucceed().size();

        for(Subgroup subgroup: SampleTraining.getSubgroupsWithSucceed()){

            for (int number:AllNumbers) {
                if(subgroup.getNumbersOfSubgroup().contains(number)){
                    float count = NumberProbability.getOrDefault(number, (float)0);
                    NumberProbability.put(number, count + 1/totalGroupsWithSucceed);
                }
            }
            for(char letter:AllLetters){
                if(subgroup.getLettersOfSubgroup().contains(letter)){
                    float count = LetterProbability.getOrDefault(letter, (float)0);
                    LetterProbability.put(letter, count + 1/totalGroupsWithSucceed);
                }
            }
        }
    }
    
    public void getAllNumbersAndLetters(){
        ArrayList<Character> allLetters = new ArrayList<>();
        ArrayList<Integer> allNumbers = new ArrayList<>();
        for (Subgroup subgroup:SampleTraining.getSubgroupsWithSucceed()){
            allLetters = new Union().union(allLetters,subgroup.getLettersOfSubgroup());
            allNumbers = new Union().union(allNumbers,subgroup.getNumbersOfSubgroup());
        }
        AllLetters = allLetters;
        AllNumbers = allNumbers;
    }
    
    public void giveProbable() {
    	
    	//Falta obtener la probabilidad de las letras y los numeros
    	
    	LetterProbability = null;
    	
    	NumberProbability = null;
    	
    }
    
}
