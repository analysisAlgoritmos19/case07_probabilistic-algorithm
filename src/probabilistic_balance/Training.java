package probabilistic_balance;

import java.util.ArrayList;

import aes_ecb_pkcs5padding.CodeAndDecode;

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

    public boolean verifySubgroupForKey(Subgroup subgroup) {

        String encryptedMessage = "xZwM7BWIpSjYyGFr9rhpEa+cYVtACW7yQKmyN6OYSCv0ZEg9jWbc6lKzzCxRSSIvOvlimQZBMZOYnOwiA9yy3YU8zk4abFSItoW6Wj0ufQ0=";
        String key1 ="29dh120";
        String key2 = "dk1";
        String key3 = "3";

        for (char letter: subgroup.getLettersOfSubgroup()) {

            for (int number: subgroup.getNumbersOfSubgroup()) {

                if (number!=3 && letter!='b'){ //verification base on trash print

                    String secretKey = key1 + (char) letter + key2 + number + key3;
                    boolean result = CodeAndDecode.decrypt(encryptedMessage, secretKey);
                    if (result){
                        return true;
                    }
                }

            }

        }
        return false;
    }

    public void setSucceedSubgroups(){
        for (Subgroup subgroup: this.SubgroupsForTraining) {

            if(verifySubgroupForKey(subgroup)){

                this.SubgroupsWithSucceed.add(subgroup);
            
            }
        }
    }

    public void printSucceedSubgroups(){
        for (Subgroup subgroup:this.SubgroupsWithSucceed) {
            System.out.println("Subgroup with succeed: ");
            System.out.println("List of numbers: ");
            subgroup.printNumberArray(subgroup.getNumbersOfSubgroup());
            System.out.println("List of letters: ");
            subgroup.printCharArray(subgroup.getLettersOfSubgroup());
        }
    }

    public void printAllSubgroups(){
        for (Subgroup subgroup:this.SubgroupsForTraining) {
            System.out.println("Subgroup with : ");
            System.out.println("List of numbers: ");
            subgroup.printNumberArray(subgroup.getNumbersOfSubgroup());
            System.out.println("List of letters: ");
            subgroup.printCharArray(subgroup.getLettersOfSubgroup());
        }
    }

    public static void main(String [] arg){
        Training training = new Training();
        //training.printAllSubgroups();
        training.printSucceedSubgroups();
    }

}
