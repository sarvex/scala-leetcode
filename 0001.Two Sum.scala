/**
  * Find the indices of two numbers in an array that sum to a specific target.
  * @intuition Use a hash map to store previously seen numbers and check for complements in a single pass.
  * @approach Iterate through the array, for each element check if its complement (target - current) exists in the map; if so, return their indices. Otherwise, add the element to the map.
  * @time O(n), where n is the length of the input array.
  * @space O(n), where n is the length of the input array.
  *
  * Finds indices of the two numbers in the array that add up to the target.
  * Returns an array of two indices if a solution exists, otherwise an empty array.
  */
object Solution:
  def twoSum(nums: Array[Int], target: Int): Array[Int] =
    nums.zipWithIndex.foldLeft(Map.empty[Int, Int]) { (seen, pair) =>
      val (num, idx) = pair
      val complement = target - num
      seen.get(complement) match
        case Some(j) => return Array(j, idx)
        case None    => seen + (num -> idx)
    }
    Array.empty[Int]
