def fibonacci(n):
    if n <= 1:
        return n
    else:
        F1 = fibonacci(n - 1)
        F2 = fibonacci(n - 2)
        return F1 + F2

n = 5
result = fibonacci(n)
print(f"Fibonacci dari {n} adalah {result}")

