#  Prompt: You are given a sample .txt file that is formatted with the following content:
#
#  3 dog
#  28 pizza
#  201 salad
#  27 desk
#  192 laptop
#  29 eggs
#
#  If you were to sort the numbers into a pyramid-like structure, it would look something like this when ordered from top-to-bottom:
#  
#        3
#      27 28
#    29 192 201
# 
#  With this structuring in mind, if we print out each word that is associated with the last number in each row, our printed result should look like this:
#  
#  dog, pizza, salad
#
#  The objective is to write a function that achieves this goal, but with any .txt file that is formatted as such in the example.
#  The function should be able to work on any amount of pairings in any appropriate .txt file. 


def decode(message_file):

        #Get contents of the file in dictionary. Numbers are keys, words are values.
        unsortedDictionary = {}

        with open(message_file) as f:
                for line in f:
                        (key, val) = line.split()
                        unsortedDictionary[int(key)] = val

        #Now to sort keys into a new dictionary 
        sortedDictionary = {k: v for k, v in sorted(unsortedDictionary.items())}


        #Once sorted, search through dictionary using for loop. Start from 1. We only need to return the concatination of all strings right most side of the pyramid of keys.
        secret_code = ""
        target = 1
        increment = 2

        #Assuming number range is continuous (no missing numbers from number range), program works fine.
        for x in range(1, len(sortedDictionary)+1): #range from 1-n+1 excluding top of range, so 1-300 for our used .txt file. 
                if x == target:
                        secret_code = secret_code + sortedDictionary[x] + " "
                        target = target + increment
                        increment = increment + 1

        print(secret_code)

# Call function
decode("coding_qual_input.txt")

###Explanation###
# The core idea here is to filter the .txt file into a dictionary. From there, we can confirm we've gathered all the data.

# It then becomes a matter of sorting the dictionary with keys in numerical order, which then we can easily use in a for loop to extract the value of each key.

# Each new row in the pyramid of keys has as many elements as the last row + 1, and by looping the addition of the increment to target - 
# which already increments itself by 1 per successful if condition - we achieve a new target that always targets the last key value pair in a pyramid.
