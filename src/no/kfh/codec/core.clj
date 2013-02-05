(ns no.kfh.codec.core)

(def base62-string "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789")

(defn encode [base-string number]
    (let [counted (count base-string)]
        (->> (iterate #(quot % counted) number)
             (take-while pos?)
             (map #(nth base-string (mod % counted)))
             (reverse)
             (apply str))))

(defn decode [base-string encoded-string]
    (->> encoded-string
        (reduce
            #(+ (* (count base-string) %1) (.indexOf base-string (str %2)))
            0)))

(def encode-base62 (partial encode base62-string))

(def decode-base62 (partial decode base62-string))