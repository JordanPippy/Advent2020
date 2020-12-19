def main():
    list1 = unFuckInput()
    list2 = unFuckInput()
    map1h = [0 for x in range(301)]
    map1v = [0 for x in range(301)]
    map2h = [0 for x in range(301)]
    map2v = [0 for x in range(301)]
    crosses = [0 for x in range(1015)]
    makeMap(list1, map1h, map1v)
    makeMap(list2, map2h, map2v)
    print("Maps made, checking crosses")
    checkCrosses(map1h, map1v, map2h, map2v, crosses)
    print(crosses)
    print("done.")


def checkCrosses(map1h, map1v, map2h, map2v, crosses):
    crossIndex = 0
    for i in range(len(map1h)):
        for j in range(len(map2h) - 1):
            if ((map1h[i] < map2h[j]) and (map1h[i] > map2h[j+1])):
                if (map2v[j] == map2v[j+1]):
                    crosses[crossIndex] = abs(map1v[j] - map1h[i])
                    crossIndex += 1

#            elif ((map1h[i] > map2h[j]) and (map1h[i] < map2h[j+1])):
#                if (map2v[j] == map2v[j+1]):
#                    crosses[crossIndex] = abs(map1v[j] - map1h[i])
#                    crossIndex += 1
#
#            elif ((map1v[i] < map2v[j]) and (map1v[i] > map2v[j+1])):
#                if (map2h[j] == map2h[j+1]):
#                    crosses[crossIndex] = abs(map1v[j] - map1h[i])
    #                crossIndex += 1
#
    #        elif ((map1v[i] > map2v[j]) and (map1v[i] < map2v[j+1])):
    #            if (map2h[j] == map2h[j+1]):
    #                crosses[crossIndex] = abs(map1v[j] - map1h[i])
    #                crossIndex += 1
    print("yeet", crossIndex)



    print("Crossed:", crossIndex, "times.")



def makeMap(input, listh, listv):
    currentPosX = 0
    currentPosY = 0
    index = 0
    for item in input:
        direction = item[0]
        mag = item[1:]
        if (direction == 'U'):
            currentPosY += int(mag)
        if (direction == 'R'):
            currentPosX += int(mag)
        if (direction == 'D'):
            currentPosY -= int(mag)
        if (direction == 'L'):
            currentPosX -= int(mag)
        listh[index] = currentPosX
        listv[index] = currentPosY
        index += 1

def unFuckInput():
    list1 = input()
    list1 = list1.split(',')
    list1[-1] = list1[-1][0:-1]
    return list1







if __name__ == "__main__":
    main()
