def solution(lottos, win_nums):
    answer = []

    lottos.sort(reverse=True)
    win_nums.sort(reverse=True)

    low_cnt = 0 # 맞은 횟수
    lottos_idx = 0 # lottos idx
    win_nums_idx = 0 # win_nums idx
    zero_cnt = lottos.count(0) # 0의 개수

    while True:
        if lottos[lottos_idx] == win_nums[win_nums_idx]:
            low_cnt+=1
            lottos_idx+=1
            win_nums_idx+=1
        elif lottos[lottos_idx] < win_nums[win_nums_idx]:
            win_nums_idx +=1
        else:
            lottos_idx +=1

        if lottos_idx == 6 or win_nums_idx == 6:
            break

    low = 0
    if low_cnt < 1: # 맞은 횟수가 1 이하인 경우 최저등수는 6등
        low = 6
    else:
        low = 7 - low_cnt

    up = 0
    if zero_cnt == 6: # 0의 개수가 6개면 최고등수는 1등
        up = 1
    else:
        up = low -zero_cnt

    answer.append(up)
    answer.append(low)
    return answer
