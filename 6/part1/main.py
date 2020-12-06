
#97
def main():
    inFile = open("input.dat", "r")
    list = []
    total = 0
    for i in range(26):
        list.append(False)
    for line in inFile:
        if line == "\n":
            for item in list:
                if item:
                    total += 1
            list = []
            for i in range(26):
                list.append(False)
        else:
            for char in line:
                if char != '\n':
                    list[ord(char) - 97] = True
    for item in list:
        if item:
            total += 1
    print(total)

if __name__ == "__main__":
    main()
