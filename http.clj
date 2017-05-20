(ns com.leohetsch.playground
    (:import (java.net ServerSocket
                      Socket)
             (java.io BufferedReader
                     InputStreamReader)))

; A simple implementation of an HTTP server
; using java.net.ServerSocket

(defn parse-request [line]
    "Extract method and path from first request line"
    (let [[method path _] (clojure.string/split line #" ")]
        [method path]))

(defn handle-client [socket] 
    "Handle a socket connection"
    (let [reader (-> (.getInputStream socket) InputStreamReader. BufferedReader.)] 
        (let [[method path] (parse-request (.readLine reader))]
            (println "Received " method " " path)
            (with-open [w (clojure.java.io/writer (.getOutputStream socket))] 
                (.write w (str "HTTP/1.1 200 OK\r\n\r\n"
                                "Hello from Clojure\n" 
                                "Method: " method "\n"
                                "Path: " path))))))

(defn run-server [port]
    (try 
        (let [server (ServerSocket. port)]
            (println "Server listening on :" port)
            (while true
                (let [socket (.accept server)]
                    (.start (Thread. #(handle-client socket))))))
        (catch java.net.BindException e 
            (println "Error: port " port " already in use"))))

(run-server 8080)