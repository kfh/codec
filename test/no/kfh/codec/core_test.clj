(ns no.kfh.codec.core-test
    (:use clojure.test
          no.kfh.codec.core))


(deftest encode-number
    (testing "encode numbers to strings"
        (is (= "e9a" (encode-base62 19158)))
        (is (= "Gzj" (encode-base62 124567)))
        (is (= "b" (encode-base62 1)))))

(deftest decode-string
    (testing "decode strings to numbers "
        (is (= 19158 (decode-base62 "e9a")))
        (is (= 124567 (decode-base62 "Gzj")))
        (is (= 1 (decode-base62 "b")))))