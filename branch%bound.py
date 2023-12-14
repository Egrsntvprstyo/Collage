class Job:
    def __init__(self, id, deadline, profit):
        self.id = id
        self.deadline = deadline
        self.profit = profit

def jobScheduling(jobs):
    jobs.sort(key=lambda x: x.profit, reverse=True)
    n = len(jobs)
    result = [False] * n
    slot = [-1] * n

    for i in range(n):
        for j in range(min(n, jobs[i].deadline) - 1, -1, -1):
            if not result[j]:
                result[j] = True
                slot[j] = i
                break

    final_result = []
    for i in range(n):
        if result[i]:
            final_result.append(jobs[slot[i]].id)

    return final_result

jobs = [Job(1, 4, 20), Job(2, 1, 10), Job(3, 1, 40), Job(4, 1, 30)]
result = jobScheduling(jobs)
print("Urutan pekerjaan yang dijadwalkan:", result)
