(ns advent-2022.day05-test
  (:require
    [advent-2022.day05 :as subject]
    [clojure.test :refer [are deftest]]))

(def example-input
  "    [D]    
[N] [C]    
[Z] [M] [P]
 1   2   3 

move 1 from 2 to 1
move 3 from 1 to 3
move 2 from 2 to 1
move 1 from 1 to 2")

(def input (slurp "resources/day-5-input.txt"))

(deftest part1-test (are [expected input] (= expected (subject/part1 input))
                         "CMZ" example-input
                         "RTGWZTHLD" input))

(deftest part2
  (are [expected input] (= expected (subject/part2 input))
       "MCD" example-input
       "STHGRZZFR" input))
