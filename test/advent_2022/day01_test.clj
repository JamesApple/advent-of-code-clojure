(ns advent-2022.day01-test
  (:require [clojure.test :refer :all]
            [advent-2022.day01 :refer :all]))

(def puzzle-input (slurp "resources/day-1-input.txt"))

(deftest part1-test
  (are [expected input] (= expected (part1 input))
                        69626 puzzle-input))

(deftest part2-test
  (are [expected input] (= expected (part2 input))
                        206780 puzzle-input))
