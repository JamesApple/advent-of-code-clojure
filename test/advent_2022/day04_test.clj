(ns advent-2022.day04-test
  (:require
    [advent-2022.day04 :as subject]
    [clojure.test :refer [are deftest]]))

(def example-input "2-4,6-8
2-3,4-5
5-7,7-9
2-8,3-7
6-6,4-6
2-6,4-8")

(def input (slurp "resources/day-4-input.txt"))

(deftest part1-test (are [expected input] (= expected (subject/part1 input))
                         2 example-input
                         526 input))

(deftest part2
  (are [expected input] (= expected (subject/part2 input))
       4 example-input
       886 input))
