(ns advent-2022.day04 (:require
                        [clojure.string :as str]))

(defn- parse-ranges [range-str]
  (map #(map parse-long (str/split % #"-")) (str/split range-str #",")))
(defn- parse-input [raw]
  (map parse-ranges
       (str/split raw #"\n")))

(defn encompasses
  [a b]
  (and (>= (first b) (first a)) (<= (last b) (last a))))

(defn either-encompass
  [pair]
  (let [a (first pair) b (last pair)]
    (or
      (encompasses a b) (encompasses b a))))

(defn includes
  [range point]
  (let [start (first range) end (last range)] (and (<= start point) (>= end point))))

(defn either-includes
  [pair]
  (let [a (first pair)
        b (last pair)]
    (or
      (or (includes a (first b)) (includes a (last b)))
      (or (includes b (first a)) (includes b (last a))))))

(defn part1
  [input]
  (count (filter either-encompass (parse-input input))))

(defn part2
  [input]
  (count (filter either-includes (parse-input input))))

