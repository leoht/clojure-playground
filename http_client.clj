(ns com.leohetsch.playground
    (:require [clj-http.client :as client])
    (:use clojure.test))

; Simple implementation of an HTTP client
; using clj-http and Github API

(def base-url "https://api.github.com")

(defn get-repo [user, repo] 
    (:body 
        (client/get
            (str base-url "/repos/leoht/clojure-playground")
            {:as :json})))

(defn get-user [user]
    (:body 
        (client/get
            (str base-url "/users/leoht")
            {:as :json})))

(deftest get-repo-test 
    (let [repo (get-repo "leoht" "clojure-playground")]
        (is (repo :description) "Scripts and snippets wrote while learning Clojure")))

(deftest get-user-test
    (let [user (get-user "leoht")]
        (is (user :id) 2395588)))

(run-tests 'com.leohetsch.playground)