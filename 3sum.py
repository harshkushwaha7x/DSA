# Function to check whether any pair exists
# whose sum is equal to the given target value
def twoSum(arr, target):
    n = len(arr)

    # Iterate through each element in the array
    for i in range(n):
      
        # For each element arr[i], check every
        # other element arr[j] that comes after it
        for j in range(i + 1, n):
          
            # Check if the sum of the current pair
            # equals the target
            if arr[i] + arr[j] == target:
                return True
              
    # If no pair is found after checking
    # all possibilities
    return False

if __name__ == "__main__":
    arr = [0, -1, 2, -3, 1]
    target = -2

    if twoSum(arr, target):
        print("true")
    else:
        print("false")