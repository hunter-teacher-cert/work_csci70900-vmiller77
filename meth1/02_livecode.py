#Our goal is to unstack these cups one by open
#Once the stack of cups only has one cups left,
#We have successfuly unstacked our cups
##########   Manually   ##########
stackOfCups = ["yellowCup", "blueCup", "pinkCup", "greenCup"]
print(stackOfCups)
stackOfCups.pop() #write each manually
stackOfCups.pop() #show how this can take really long
stackOfCups.pop() #emphasize how this could be tedious for a list of 50 cups
print(stackOfCups)



#That was kind of long and took a while, can we try something else?
#It may work for this many cups, but what about 1000?

##########  WHILE LOOP  ##########
#what was the repetitive action?
#so how many times do we want to do this?
#when do we want to stop?

stackOfCups = ["yellowCup", "blueCup", "pinkCup", "greenCup"]
print(stackOfCups)
#we can repeat this action of moving cups in a while loop
#type the shell first
# then talk about what condition we would want to stop
#while loop
while (len(stackOfCups) > 1):
    stackOfCups.pop()

print(stackOfCups)

########## RECURSION ##########
#what if I told you we can do this in a function?
#what was the condition for removing cups?
#what should we do with the remaining cups?
#can't call on our function forever! so how do we know when to stop?
stackOfCups = ["yellowCup", "blueCup", "pinkCup", "greenCup"]
print(stackOfCups)


#recursive function
def unstackCups(stackOfCups):
    if len(stackOfCups) > 1: #keep going
        stackOfCups.pop() # remove that cup
        return unstackCups(stackOfCups) #keep solving the problem once we made it smaller
    else:
        return stackOfCups #base case - 1 all done


unstackCups(stackOfCups)

print(unstackCups(stackOfCups))
