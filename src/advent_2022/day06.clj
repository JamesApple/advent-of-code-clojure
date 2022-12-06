(ns advent-2022.day06)

(defn- to-distinct-groups
  [signal-len input]
  (let [wrapped (vec (str input input))]
    (map-indexed
      (fn [idx _]
        (let [signal (subvec wrapped idx (+ idx signal-len))]
          (if (=
                signal-len
                (count (set signal)))
            (+ idx signal-len))))
      input)))

(defn part1 [input]
  (first
    (filter identity
            (to-distinct-groups 4 input))))
(defn part2 [input]
  (first
    (filter identity
            (to-distinct-groups 14 input))))

