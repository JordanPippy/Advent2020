def main():
    inFile = open("input.dat", "r")
    input = []
    total = 0
    for line in inFile:
        if line == "\n":
            total += checkList(input)
            input = []
        else:
            input.append(line[:-1])
    total += checkList(input)
    print(total)


def checkList(list):
    questions = []
    size = len(list)
    toRet = 0
    for i in range(26):
        questions.append(0)
    for item in list:
        for char in item:
            questions[ord(char) - 97] += 1
    for item in questions:
        if item == size:
            toRet += 1
    return toRet

if __name__ == "__main__":
    main()
