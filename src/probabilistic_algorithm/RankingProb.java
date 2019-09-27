package probabilistic_algorithm;

import java.util.ArrayList;
import java.util.HashMap;

import probabilistic_balance.Subgroup;
import probabilistic_balance.Training;
import utils.HashHighValues;
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
        getAllNumbersAndLetters();
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
    
    public void printNumbersHash(){
        this.NumberProbability.forEach((k,v)->{
            System.out.println("The number: "+k+" has: "+v+" probability");
        });
    }
    public void printLetterHash(){
        this.LetterProbability.forEach((k,v)->{
            System.out.println("The letter: "+k+" has: "+v+" probability");
        });
    }

    public void giveProbableAns(){
        System.out.println("The suggested letters to choose are given in descendent order: ");
        LetterProbability = (HashMap<Character, Float>) HashHighValues.sortByValue(LetterProbability);
        printLetterHash();
        System.out.println("The suggested numbers to choose are given in descendent order: ");
        NumberProbability = (HashMap<Integer, Float>) HashHighValues.sortByValue(NumberProbability);
        printNumbersHash();
    }

    public static void main (String [] args){
        RankingProb rankingProb = new RankingProb();
        rankingProb.giveProbableAns();
    }
    
    
    
}
