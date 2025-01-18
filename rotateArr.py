# Python Program to left rotate the array by d positions
# by rotating one element at a time

# Function to left rotate array by d positions
def rotateArr(arr, d):
    n = len(arr)
  
    # Repeat the rotation d times
    for i in range(d):
      
        # Left rotate the array by one position
        first = arr[0]
        for j in range(n - 1):
            arr[j] = arr[j + 1]
        arr[n - 1] = first

if __name__ == "__main__":
    arr = [1, 2, 3, 4, 5, 6]
    d = 2

    rotateArr(arr, d)

    for i in range(len(arr)):
        print(arr[i], end=" ")
