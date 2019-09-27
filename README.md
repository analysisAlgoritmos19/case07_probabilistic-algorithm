# case07_probabilistic-algorithm

========Objective of algorithm

This project is meant to develop a probabilistic algorithm in order to get the possible missing values of AES/ECB/PKCS5Padding 
cypher algorithm key.

========Description of the probabilistic algorithm

For obtaining the possible missing values of the key, we design a solution that creates "n" amount of subgroups with "m" amount of numbers and "p" amount of letters. Then, the subgroups are tested in the decrypt method of the AES algorithm (using cartesian product between the numbers and letters). Those subgroups whose elements succeeded are separated. Now the elements of the successful subgroups are evaluated. We count the amount of times an element appears in this subgroups, and based on the repetition the suggestion table is created.

=========Using the algorithm

For running the algorithm: Run the main method of the class RankiningProb.java

Output: The out will be two tables, one for numbers and other for letters, showing the probability percentage of each element in descending order (form more probable to less probable).

=========Modifying values in algorithm

For modifying the amount of subgroups: Edit the attribute AmountOfSubgroups (located in src/probabilistic_balance/Training)

For modifying the amount of numbers and letter in each subgroup: Edit the attribute NumbersSize or LettersSize (located in src/probabilistic_balance/Subgroup)


    

