(ns com.leohetsch.playground.numbers
  (:use clojure.test))

(defn factorial [x]
  (loop [n x f 1]
    (if (< n 1)
      f 
      (recur (dec n) (* f n)))))

(deftest factorial-test
  (is (= (factorial 6) 720))
  (is (= (factorial 0) 1)))

(run-tests 'com.leohetsch.playground.numbers)