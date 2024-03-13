import java.util.Arrays;
import java.util.Comparator;

/**
 * A simple way to sort arrays using merge sort.
 *
 * @author YourName Here
 * @author Your NameHere
 * @author Samuel A. Rebelsky
 */
public class MergeSorter {

  // +------------------+--------------------------------------------
  // | Exported methods |
  // +------------------+

  /**
   * Sort an array using the merge sort algorithm.
   */
  public static <T> void sort(T[] vals, Comparator<? super T> comparator) {
    mergeSort(vals, 0, vals.length, comparator);
  } // sort

  // +-----------------+---------------------------------------------
  // | Local utilities |
  // +-----------------+

  /**
   * Merge the values from positions [lo..mid) and [mid..hi) back into
   * the same part of the array.
   *
   * Preconditions: Each subarray is sorted accorting to comparator.
   */
  static <T> void merge(T[] vals, int lo, int mid, int hi, Comparator<? super T> comparator) {
    T[] unsorted = Arrays.copyOfRange(vals, lo, hi);
    // referring to index in unsorted
    int lIndex = 0;
    int rIndex = mid - lo;
    // referring to index in vals
    int combinedIndex = lo;

    while (lIndex < (mid - lo) || rIndex < (hi - lo)) {
      if (lIndex < (mid - lo) && rIndex < (hi - lo)) {
        if (comparator.compare(unsorted[lIndex], unsorted[rIndex]) <= 0) {
          vals[combinedIndex] = unsorted[lIndex];
          lIndex++;
        } else {
          vals[combinedIndex] = unsorted[rIndex];
          rIndex++;
        }
      } else if (lIndex < (mid - lo)) {
        vals[combinedIndex] = unsorted[lIndex];
        lIndex++;
      } else {
        vals[combinedIndex] = unsorted[rIndex];
        rIndex++;
      }
      combinedIndex++;
    }
  } // merge

  /**
   * Helper version of mergeSort that takes these bounds as arguments. 
   * Initially you should pass 0 and vals.size() to this helper method 
   * to kick off the merge sort process.
   */
  static <T> void mergeSort(T[] vals, int lo, int hi, Comparator<? super T> comparator) {
    if (lo >= (hi - 1)) {
      return;
    } 
    int mid = (hi + lo)/2;
    
    mergeSort(vals, lo, mid, comparator);
    mergeSort(vals, mid, hi, comparator);

    merge(vals, lo, mid, hi, comparator);
  } // mergeSort

} // class MergeSorter

