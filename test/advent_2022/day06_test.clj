(ns advent-2022.day06-test
  (:require
    [advent-2022.day06 :as subject]
    [clojure.test :refer [are deftest]]))

(def input (slurp "resources/day-6-input.txt"))

(deftest part1-test (are [expected input] (= expected (subject/part1 input))
                         7 "mjqjpqmgbljsphdztnvjfqwrcgsmlb"
                         5 "bvwbjplbgvbhsrlpgdmjqwftvncz"
                         6 "nppdvjthqldpwncqszvftbrmjlhg"
                         10 "nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg"
                         11 "zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw"
                         1855 input))

(deftest part2
  (are [input expected] (= (subject/part2 input) expected)
       "mjqjpqmgbljsphdztnvjfqwrcgsmlb" 19
       "bvwbjplbgvbhsrlpgdmjqwftvncz" 23
       "nppdvjthqldpwncqszvftbrmjlhg" 23
       "nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg" 29
       "zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw" 26
       input 3256))
