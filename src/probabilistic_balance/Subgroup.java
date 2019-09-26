package probabilistic_balance;

import java.util.ArrayList;
import java.util.Random;

public class Subgroup {
	
	private ArrayList<Character> LettersOfSubgroup;
    private ArrayList<Integer> NumbersOfSubgroup;
    private int LettersSize = 5;
    private int NumbersSize = 3;
    
    public Subgroup() {
        LettersOfSubgroup = new ArrayList<>();
        setLettersOfSubgroup();
        NumbersOfSubgroup = new ArrayList<>();
        setNumbersOfSubgroup();
    }
    
    public ArrayList<Character> getLettersOfSubgroup() {
        return LettersOfSubgroup;
    }

    public void setLettersOfSubgroup() {
        Random rand = new Random();
        char letter;
        for(int letterIndex=0; letterIndex < LettersSize; letterIndex++){
           letter =(char) (rand.nextInt((122 - 97) + 1) + 97);
           this.LettersOfSubgroup.add(letter);
        }

    }

    public ArrayList<Integer> getNumbersOfSubgroup() {
        return NumbersOfSubgroup;
    }

    public void setNumbersOfSubgroup() {
        Random rand = new Random();
        for(int numberIndex=0; numberIndex < NumbersSize; numberIndex++){
            int randNum = rand.nextInt(10);
            this.NumbersOfSubgroup.add(randNum);
        }
    }
    
    public void printNumberArray(ArrayList<Integer> arrayListOfNumbers){
        for (int element:arrayListOfNumbers) {
            System.out.println(element);
        }
    }

    public void printCharArray(ArrayList<Character> arrayListOfChars){
        for (char element:arrayListOfChars) {
            System.out.println(element);
        }
    }
    
}
