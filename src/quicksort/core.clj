(ns quicksort.core
  (:gen-class))



(defn my-partition [in-var] ;; don't conflict with the built-in partition
   (let [pivot (quot (count in-var) 2)
         pivot-val (nth in-var pivot)
         before-pivot (take pivot in-var)
         pivot-seq (take 1 (drop pivot in-var)) ;; get pivot value out as a seq so concat works
         after-pivot (drop (+ pivot 1) in-var)
         left (concat (filter  #(< % pivot-val) before-pivot) ;; this makes sure dups of the pivot value remain
                      (filter  #(< % pivot-val) after-pivot))
         right (concat (filter  #(>= % pivot-val) before-pivot) ;; same here
                       (filter  #(>= % pivot-val) after-pivot))]
     [left pivot-seq right]))

(defn quicksort [to-sort]
  (println to-sort)
  (if (<= (count to-sort) 1 )
    to-sort
    (let [[partition-low pivot partition-high] (my-partition to-sort)]
      (concat (quicksort partition-low) pivot (quicksort partition-high)))))

