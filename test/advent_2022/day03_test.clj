(ns advent-2022.day03-test
  (:require
    [advent-2022.day03 :as subject]
    [clojure.test :refer [are deftest]]))

(def example-input
  "vJrwpWtwJgWrhcsFMMfFFhFp
jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL
PmmdzqPrVvPwwTWBwg
wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn
ttgJtRGJQctTZtZT
CrZsJsPPZsGzwwsLwLmpwMDw")

(def input (slurp "resources/day-3-input.txt"))

(deftest part1-test (are [expected input] (= expected (subject/part1 input))
                         157 example-input
                         7903 input))

(deftest part1-char-value
  (are [expected input] (= expected (first (subject/to-char-values input)))
       1 "a"
       26 "z"
       27 "A"
       52 "Z"
       38 "L"
       42 "P"))

(deftest part2-group
  (are [expected input] (= expected (subject/part2 input))
       70 example-input
       2548 input))
