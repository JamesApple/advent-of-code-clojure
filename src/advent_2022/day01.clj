(ns advent-2022.day01
  (:require [clojure.string :as str]))

(defn split-into-2d-array
  [txt]
  (map #(clojure.string/split % #"\n") (clojure.string/split txt #"\n\n")))

(defn parse-2d-array
  [arr]
  (map (fn [nested] (map parse-long nested)) arr))

(defn sum-2d-array-groups
  [arr]
  (map #(reduce + %) arr))

(defn max-value
  [arr]
  (reduce (
           fn [max val]
           (
            if (> max val)
            max
            val)) 0 arr)
  )

(defn get-elves
  [raw]
  (sum-2d-array-groups
    (parse-2d-array
      (split-into-2d-array
        raw))))

(defn part1
  [raw]
  (first (sort > (get-elves raw))))


(defn part2
  [raw]
  (reduce + (take 3 (sort > (get-elves raw))))
)
