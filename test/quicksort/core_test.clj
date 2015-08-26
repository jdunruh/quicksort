(ns quicksort.core-test
  (:require [clojure.test :refer :all]
            [quicksort.core :refer :all]))

(deftest partition-test
  (testing "my-partition"
    (is (= (my-partition '(5 3 6 3 2)) '((5 3 3 2) (6) ())))
    (is (= (my-partition '(5)) '(() (5) ())))
    (is (= (my-partition '(5 3)) '(() (3) (5))))
    (is (= (my-partition [5 2 4 1 0 1]) '((0) (1) (5 2 4 1))))))

(deftest quicksort.core-test
  (testing "quicksort"
    (is (= (quicksort '(5 2 6 8 9)) '(2 5 6 8 9)))
    (is (= (quicksort '(1 2 3 4 5 6)) '(1 2 3 4 5 6)))
    (is (= (quicksort [2 1]) [1 2]))
    (is (= (quicksort '(1)) '(1)))))
