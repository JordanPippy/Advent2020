
#shiny gold
#1 plaid orange bag, 2 striped lavender bags, 4 pale brown bags, 5 wavy blue bags.
def main():
    list = []
    inFile = open("input.dat", "r")
    outFile = open("output.dat", "w")
    toWrite = ["shiny gold"]
    didSomething = False
    while (True):
        for line in inFile:
            line = line.split("contain")
            part1 = line[0].split(' ')
            part1 = part1[0] + ' ' + part1[1]
            temp = line[1].split(',')
            part2 = []
            for item in temp:
                tempItem = item
                tempItem = tempItem.split(' ')
                tempItem = tempItem[2] + ' ' + tempItem[3]
                part2.append(tempItem)
            
            for item in part2:
                if item in toWrite and part1 not in toWrite:
                    didSomething = True
                    toWrite.append(part1)
        print("Size: " + str(len(toWrite)))
        inFile.seek(0)
        if not didSomething:
            break
        didSomething = False

    for item in toWrite:
        outFile.write(item + '\n')


if __name__ == "__main__":
    main()