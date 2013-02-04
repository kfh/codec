(ns no.kfh.codec.core
    (:require [clojure.string :as s])
    (:use [clojure.math.numeric-tower :only [expt]]))

(def base62-string "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789")

(defn encode [base-string number]
    (let [counted (count base-string)]
        (->> (iterate #(quot % counted) number)
             (take-while pos?)
             (map #(nth base-string (mod % counted)))
             (reverse)
             (reduce str))))

(defn decode [base-string encoded-string]
    (let [xs (map #(.indexOf base-string (str %)) encoded-string)]
        (reduce +
            (map #(* % (expt (count base-string) (.indexOf (reverse xs) %)))
                xs))))

(def encode-base62 (partial encode base62-string))

(def decode-base62 (partial decode base62-string))