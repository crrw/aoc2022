import operator, math

ops = {
    '+' : operator.add,
    '*' : operator.mul,
}

#I will not use regex. I will outlive the usefulness of regex
with open("Day11/input.txt") as f:
    monkeys = f.read().strip().split('\n\n')
details = []
for detail in monkeys:
    stuff = detail.split("\n")
    index = int(stuff[0][7:len(stuff[0])-1])
    items = list(map(int, stuff[1][18:].split(", ")))
    operation = [stuff[2][23:].split(" ")[0], stuff[2][23:].split(" ")[1]]
    test = int(stuff[3][21:])
    trueMon = int(stuff[4][29:])
    falseMon = int(stuff[5][30:])
    trades = 0
    details.append([index, items, operation, test, trueMon, falseMon])

def part1(details):
    tradeArr = [0] * len(monkeys)
    for i in range(20):
        for monkey in details:
            for item in monkey[1]:
                multiplier = monkey[2][1]
                if monkey[2][1] == "old":
                    multiplier = item
                newItem = ops[monkey[2][0]](item, int(multiplier))//3
                if newItem%monkey[3]==0:
                    details[monkey[4]][1].append(newItem)
                else:
                    details[monkey[5]][1].append(newItem)
                tradeArr[details[monkey[0]][0]] += 1
            monkey[1] = []
    return sorted(tradeArr)[-1] * sorted(tradeArr)[-2]

lcmNum = 1
for i in details:
    lcmNum = math.lcm(lcmNum, int(i[3]))
# print(lcmNum)

def part2(details):
    tradeArr = [0] * len(monkeys)
    for i in range(10000):
        for monkey in details:
            for item in monkey[1]:
                multiplier = monkey[2][1]
                if monkey[2][1] == "old":
                    multiplier = item
                newItem = ops[monkey[2][0]](item, int(multiplier))%lcmNum
                if newItem%monkey[3]==0:
                    details[monkey[4]][1].append(newItem)
                else:
                    details[monkey[5]][1].append(newItem)
                tradeArr[details[monkey[0]][0]] += 1
            monkey[1] = []
    return sorted(tradeArr)[-1] * sorted(tradeArr)[-2]

if __name__ == "__main__":
    print(part1(details))
    # print(part2(details))