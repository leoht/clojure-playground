(ns com.leohetsch.playground.text
  (:use clojure.test))

(defn reverse [x]
  (if (= 1 (count x))
    x
    (str (reverse (subs x 1)) (subs x 0 1))))

(deftest reverse-test
  (is (= "olleh" (reverse "hello"))))

(run-tests 'com.leohetsch.playground.text)