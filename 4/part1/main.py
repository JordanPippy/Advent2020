def main():
    inFile = open("input.dat", "r")
    numFields = 0
    temp = ""
    numValid = 0
    notValid = 0
    numPassports = 0
    fields = []
    valid = False
    for line in inFile:
        temp = line.split()
        for field in temp:
            if "cid" in field:
                continue
            fields.append(field)

        if line == "\n":
            numPassports += 1
            if len(fields) >= 7:
                valid = checkValid(fields)
                if (valid):
                    numValid += 1
                    print(fields)
                #else:
                    #print(fields)
            fields = []
            numFields = 0

    if (len(fields) == 7):
        valid = checkValid(fields)
        if (valid):
            numValid += 1
    print(numValid)


###
#    byr (Birth Year) - four digits; at least 1920 and at most 2002.
#    iyr (Issue Year) - four digits; at least 2010 and at most 2020.
#    eyr (Expiration Year) - four digits; at least 2020 and at most 2030.
#    hgt (Height) - a number followed by either cm or in:
#        If cm, the number must be at least 150 and at most 193.
#        If in, the number must be at least 59 and at most 76.
#    hcl (Hair Color) - a # followed by exactly six characters 0-9 or a-f.
#    ecl (Eye Color) - exactly one of: amb blu brn gry grn hzl oth.
#    pid (Passport ID) - a nine-digit number, including leading zeroes.
#    cid (Country ID) - ignored, missing or not.
###


def checkValid(fields):
    for field in fields:
        if ("byr" in field):
            x = int(field[4:])
            if not (x >= 1920 and x <= 2002):
                return False
        if ("iyr" in field):
            x = int(field[4:])
            if not (x >= 2010 and x <= 2020):
                return False
        if ("eyr" in field):
            x = int(field[4:])
            if not (x >= 2020 and x <= 2030):
                return False
        if ("hgt" in field):
            if ("cm" in field):
                x = int(field[4:-2])
                if not(x >= 150 and x <= 193):
                    return False
            elif ("in" in field):
                x = int(field[4:-2])
                if not (x >= 59 and x <= 76):
                    return False
            else:
                return False
        if ("hcl" in field):
            count = 0
            chars = "#0123456789abcdef"
            for char in field[4:]:
                count += 1
                if not (char in chars):
                    return False
            if (count != 7):
                return False
        if ("ecl" in field):
            possible = "amb blu brn gry grn hzl oth"
            if not (field[4:] in possible):
                print(fields)
                return False
        if ("pid" in field):
            x = field[4:]
            if not (len(x) == 9):
                return False
    return True
if __name__ == "__main__":
    main()
