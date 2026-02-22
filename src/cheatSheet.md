# Java Interview Cheat Sheet

## ARRAYS

```java
// Declaration & Creation
int[] arr = {1, 2, 3};
int[] arr = new int[5];
int[][] grid = new int[3][4];  // 3 rows, 4 cols

// Access & Modify
arr[0] = 5;
int val = arr[0];
int len = arr.length;  // NOT .length() - it's a property!

// Sorting
Arrays.sort(arr);                              // Ascending
Arrays.sort(arr, (a, b) -> b - a);             // Descending
Arrays.sort(intervals, (a, b) -> a[0] - b[0]); // Sort 2D by first element

// Copy
int[] copy = Arrays.copyOf(arr, arr.length);
int[] copy = arr.clone();

// Convert to List
List<Integer> list = Arrays.asList(1, 2, 3);   // Fixed size!
List<Integer> list = new ArrayList<>(Arrays.asList(arr)); // Mutable

// Fill & Compare
Arrays.fill(arr, 0);
boolean same = Arrays.equals(arr1, arr2);

// String conversion
String str = Arrays.toString(arr);  // [1, 2, 3]
```

## LISTS

```java
// Creation
List<Integer> list = new ArrayList<>();
List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3));
List<List<Integer>> grid = new ArrayList<>();  // 2D list

// Access & Modify
list.get(0);           // NOT list[0]
list.set(0, 5);        // NOT list[0] = 5
list.size();           // NOT .length
list.add(4);           // Append
list.add(0, 99);       // Insert at index 0
list.remove(0);        // Remove by index
list.remove(Integer.valueOf(99));  // Remove by value

// Reverse & Sort
Collections.reverse(list);
Collections.sort(list);
Collections.sort(list, (a, b) -> b - a);  // Descending

// Convert to Array
Integer[] arr = list.toArray(new Integer[list.size()]);
int[] arr = list.stream().mapToInt(i -> i).toArray();
```

## HASHMAPS

```java
// Creation & Operations
HashMap<String, Integer> map = new HashMap<>();
map.put("key", 1);
int val = map.get("key");
int val = map.getOrDefault("key", 0);  // Returns 0 if not found
map.containsKey("key");
map.remove("key");

// Common Pattern: Frequency Count
map.put(key, map.getOrDefault(key, 0) + 1);

// Iteration
for (String key : map.keySet()) { ... }
for (Integer val : map.values()) { ... }
for (Map.Entry<String, Integer> entry : map.entrySet()) {
    String key = entry.getKey();
    Integer val = entry.getValue();
}
map.forEach((k, v) -> System.out.println(k + ": " + v));
```

## HASHSET

```java
HashSet<Integer> set = new HashSet<>();
set.add(5);
set.contains(5);  // O(1) lookup!
set.remove(5);
set.size();

// Convert
List<Integer> list = new ArrayList<>(set);
```

## STRINGS

```java
// Creation & Properties
String s = "hello";
int len = s.length();  // Method, not property!
char c = s.charAt(0);
char[] chars = s.toCharArray();

// Substring
String sub = s.substring(0, 3);  // "hel" - end is EXCLUSIVE

// Split & Join
String[] words = s.split(" ");           // Single space
String[] words = s.trim().split("\\s+"); // Multiple spaces (BEST)
String joined = String.join(" ", words);

// Modify (Strings are immutable!)
s = s.replace("l", "x");  // "hexxo"
s = s.toUpperCase();
s = s.toLowerCase();
s = s.trim();  // Remove leading/trailing whitespace

// Compare
s.equals("hello");     // Content comparison
s == "hello";          // Reference comparison (DON'T USE!)
```

## STACK

```java
Stack<Integer> stack = new Stack<>();
stack.push(1);
int top = stack.pop();
int peek = stack.peek();  // Look without removing
boolean empty = stack.isEmpty();
int size = stack.size();
```

## QUEUE

```java
Queue<Integer> queue = new LinkedList<>();  // Queue is interface!
queue.add(1);      // or queue.offer(1)
int first = queue.poll();  // Remove from front
int peek = queue.peek();   // Look without removing
```

## LAMBDA & SHORTCUTS

```java
// For-each
for (int num : arr) { ... }
list.forEach(num -> System.out.println(num));

// Lambda syntax
(a, b) -> a + b              // Two params
x -> x * 2                   // One param (parens optional)
() -> 42                     // No params
(a, b) -> { return a + b; }  // Multi-line

// Method reference
list.forEach(System.out::println);  // Same as: x -> System.out.println(x)
Arrays.sort(arr, Integer::compare);
```

## COMMON PATTERNS

```java
// Two Pointers
int left = 0, right = arr.length - 1;
while (left < right) {
    if (condition) left++;
    else right--;
}

// Sliding Window
int left = 0;
for (int right = 0; right < arr.length; right++) {
    // Add arr[right] to window
    while (window_invalid) {
        // Remove arr[left] from window
        left++;
    }
}

// Binary Search (Sorted Array)
int left = 0, right = arr.length - 1;
while (left < right) {
    int mid = left + (right - left) / 2;
    if (arr[mid] < target) left = mid + 1;
    else right = mid;
}

// Swap
int temp = arr[i];
arr[i] = arr[j];
arr[j] = temp;

// Max/Min
int max = Math.max(a, b);
int min = Math.min(a, b);
```

## CRITICAL GOTCHAS

```java
// Primitives vs Objects
int x = 5;           // Primitive - COPY by value
int[] arr = {1,2,3}; // Object - COPY by reference!

int a = x; a = 10;   // x is still 5 ✓
int[] b = arr; b[0] = 99;  // arr[0] is now 99! ✗

// List access
list.get(0)   ✓   // NOT list[0]
list.set(0, 5) ✓  // NOT list[0] = 5

// Array length vs List size
arr.length    ✓   // Property (no parens)
list.size()   ✓   // Method (with parens)

// String immutability
s.toUpperCase();     // ✗ Doesn't change s!
s = s.toUpperCase(); // ✓ Must reassign

// Integer comparison in List
list.remove(0);                    // Remove index 0
list.remove(Integer.valueOf(0));   // Remove value 0
```

## TIME COMPLEXITY QUICK REF

```java
HashMap: get/put/contains = O(1)
HashSet: add/contains/remove = O(1)
ArrayList: get/set = O(1), add/remove = O(n)
Arrays.sort() = O(n log n)
Binary Search = O(log n)
```