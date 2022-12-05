(ns advent-2022.day02-test
  (:require
    [advent-2022.day02 :refer :all]
    [clojure.test :refer :all]))

(def puzzle-input (slurp "resources/day-2-input.txt"))

(deftest part2-test
  (are [expected input] (= expected (part2 input))
       10349 puzzle-input))

