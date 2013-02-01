(ns no.kfh.codec.core
    (:use [clojure.math.numeric-tower :only [expt]]))

(def base62-string "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789")

(defn encode [base-string number]
    (apply str
        (for [x (loop [xs '() my-n number]
            (let [c (count base-string)
                  r (mod my-n c)
                  q (quot my-n c)]
                (if (pos? my-n) (recur (conj xs r) q)
                    xs)))]
            (nth base-string x))))

(defn decode [base-string encoded-string]
    (let [xs (map #(.indexOf base-string (str %)) encoded-string)]
        (reduce +
            (map #(* % (expt (count base-string) (.indexOf (reverse xs) %)))
                xs))))

(def encode-base62 (partial encode base62-string))

(def decode-base62 (partial decode base62-string))


