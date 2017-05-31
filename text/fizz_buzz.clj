(ns com.leohetsch.playground.text
  (:use clojure.test))

(defn divby? [x n]
  (= 0 (mod x n)))

(deftest divby?-test
  (is (= true (divby? 10 2)))
  (is (= true (divby? 9 3)))
  (is (= false (divby? 5 2))))

(defn fizz-buzz [to]
  (doseq [n (range to)]
    (println (cond 
      (and (divby? n 3) (divby? n 5)) "FizzBuzz"
      (divby? n 3) "Fizz"
      (divby? n 5) "Buzz"))))

(fizz-buzz 100)
(run-tests 'com.leohetsch.playground.text)