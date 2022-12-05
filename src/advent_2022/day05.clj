(ns advent-2022.day05 (:require
                        [clojure.string :as str]))

(defn- parse-move-line [line]
  (let [match (re-matches #"^move (\d+) from (\d+) to (\d+)$" line)]
    (if match
      {:count (parse-long (nth (rest match) 0))
       :from (- (parse-long (nth (rest match) 1)) 1)
       :to (- (parse-long (nth (rest match) 2)) 1)})))

(defn- parse-stacks
  [lines]
  (mapv (fn [v]
          (filterv #(not= \space %) v))
        (apply mapv vector
               (map
                 (comp
                   #(take-nth 4 %)
                   #(drop 1 %)) lines))))

(defn- until-header
  [lines]
  (take-while #(not (str/starts-with? % " 1")) lines))

(defn- parse-input
  [raw]
  (let [header-strings (until-header (str/split-lines raw))]
    {:stacks (parse-stacks header-strings)
     :moves (filter identity (map parse-move-line (str/split-lines raw)))}))

(defn- apply-single-move
  [stacks from to count]
  (let [moved (take count (get stacks from))]
    ((comp
       #(assoc % from (drop count (get % from)))
       #(assoc % to (concat moved (get % to))))
     stacks)))

(defn- apply-move
  [stacks move] (reduce
                  (fn [stacks k]
                    (apply-single-move stacks (:from move) (:to move) 1))
                  stacks (range 0 (:count move))))

(defn- apply-group-move
  [stacks move] (apply-single-move stacks (:from move) (:to move) (:count move)))

(defn part1 [input]
  (apply str (map first (let [input (parse-input input)]
                          (reduce apply-move (:stacks input) (:moves input))))))

(defn part2 [input]
  (apply str
         (map first
              (let [input (parse-input input)]
                (reduce apply-group-move (:stacks input) (:moves input))))))

