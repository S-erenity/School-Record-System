# School-Record-System

Algorithm      | Observed Behavior  | Big-O      | Evidence/Notes                              
---------------|------------------- |------------|---------------------------------------------
Linear Search  | Increases Linearly | O(n)       | Time taken is 2 more digits than sample size
Binary Search  | Barely Increases   | O(log n)   | Time take barely increase when sample x10   
Insertion Sort | Large increase     | O(n^2)     | Quick for small sample sizes                
Selection Sort | Large increase     | O(n^2)     | Slowest for all sample sizes                
Bubble Sort    | Large Increase     | O(n^2)     | Second Slowest for all sample sizes         
Merge Sort     | Grows Slowly       | O(n log n) | Slowest compared to other O(n log n) sorts  
Quick Sort     | Grows Slowly       | O(n log n) | Nearly Linear growth                        
Heap Sort      | Grows Slowly       | O(n log n) | Slightly faster than quick sort             

<p align="center">
  <img src="https://github.com/S-erenity/School-Record-System/blob/main/images/searchchart.png?raw=true" alt="Search Algorithms" width="500"/>
</p>

<p align="center">
  <img src="https://github.com/S-erenity/School-Record-System/blob/main/images/sortchart.png?raw=true" alt="Sort Algorithms" width="500"/>
</p>

## Recomendations

If the data is already sorted, then binary search would be the best. However, if the data is not sorted, even if you use the fastest sorting algorithm in the chart, binary search would still be slower than linear search.

From the charts, Heap sort is the fastest sorting algorithm except for small sample sizes. So, insertion sort would be recommended for sorting a single class and heap sort would be recommended for sorting an entire grade or school. This makes sense due to O(n log n) (heap sort) vs O(n) (insertion sort) time.
