(ns advent-2022.day02
  (:require
    [clojure.set :as set]
    [clojure.string :as str]))

(def ^:private score-values
  {:rock 1
   :paper 2
   :scissors 3

   :win 6
   :draw 3
   :loss 0})

(def ^:private action-map {:A :rock
                           :B :paper
                           :C :scissors

                           :X :rock
                           :Y :paper
                           :Z :scissors})

(def ^:private beats-map {:rock :scissors
                          :paper :rock
                          :scissors :paper})

(def ^:private outcome-map {:X :loss
                            :Y :draw
                            :Z :win})

(defn- parse-input-string
  "Parse the input string into a keyword 2D array"
  [raw]
  (map #(map keyword (clojure.string/split % #" ")) (clojure.string/split raw #"\n")))

(defn- calculate-mine
  [theirs outcome]
  (if (= outcome :draw)
    theirs
    (if (= outcome :loss)
      (theirs beats-map)
      (if (= outcome :win)
        (theirs (set/map-invert beats-map))
        (println str theirs outcome)))))

(defn- play-games
  [game-array]
  (map #(identity
          {:mine (calculate-mine ((first %) action-map) ((last %) outcome-map))
           :theirs ((first %) action-map)
           :outcome ((last %) outcome-map)}) game-array))

(defn- calc-score [game]
  (+
    ((:mine game) score-values)
    ((:outcome game) score-values)))

(defn part2
  [input]
  (reduce + (map calc-score (play-games (parse-input-string input)))))
